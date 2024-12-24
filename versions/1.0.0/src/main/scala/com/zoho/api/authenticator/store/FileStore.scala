package com.zoho.api.authenticator.store

import com.zoho.api.authenticator.Token
import com.zoho.crm.api.UserSignature

import java.io.{File, FileReader, FileWriter}
import com.zoho.api.authenticator.OAuthToken
import com.zoho.crm.api.util.{Constants, Utility}
import com.zoho.crm.api.exception.SDKException

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

/**
 * Creates a FileStore class instance with the specified parameters.
 *
 * @param filePath A String containing the absolute file path to store tokens.
 * @throws Exception Exception
 */
class FileStore(private var filePath: String) extends TokenStore {
  private val writer = new FileWriter(new File(filePath), true)
  private val fileReader: FileReader = new FileReader(filePath)
  private val headerString: ArrayBuffer[String] = ArrayBuffer(Constants.ID, Constants.USER_NAME, Constants.CLIENT_ID, Constants.CLIENT_SECRET, Constants.REFRESH_TOKEN, Constants.ACCESS_TOKEN, Constants.GRANT_TOKEN, Constants.EXPIRY_TIME, Constants.REDIRECT_URL, Constants.API_DOMAIN)
  if (fileReader.read == -1) {
    writer.write(headerString.mkString(","))
  }
  fileReader.close()
  writer.flush()
  writer.close()

  @throws[SDKException]
  override def findToken(token: Token): Token = {
    var src: Source = null
    try {
      token match {
        case oauthToken: OAuthToken =>
          src = Source.fromFile(this.filePath)
          val lines = src.getLines.toList
          var isRowPresent = false
          if(lines.size > 1) {
            for (i <- 1 until lines.length) {
              val nextRecord = lines(i).split(",")
              if (nextRecord.length > 1) {
                isRowPresent = checkCondition(oauthToken, nextRecord)
                if (isRowPresent) {
                  setMergeData(oauthToken, nextRecord)
                  return oauthToken
                }
              }
            }
          }
          if (!isRowPresent) {
            return null
          }
        case _ =>
      }
    } catch {
      case e: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_FILE_ERROR, e)
    }
    finally {
      if (src != null) src.close()
    }
    token
  }

  @throws[SDKException]
  override def saveToken(token: Token): Unit = {
    var src: Source = null
    val file = new File(this.filePath)
    var writer: FileWriter = null
    try {
      token match {
        case oauthToken: OAuthToken =>
          src = Source.fromFile(this.filePath)
          val allContents: collection.mutable.ListBuffer[String] = src.getLines.toList.to(collection.mutable.ListBuffer)
          var isRowPresent = false
          if(allContents.size > 1) {
            for (i <- 1 until allContents.length) {
              val nextRecord = allContents(i).split(",")
              if (nextRecord.length > 1) {
                if (oauthToken.getId != null) {
                  val id = getData(String.valueOf(nextRecord(0)))
                  if (id != null && oauthToken.getId != null && id.equals(oauthToken.getId)) {
                    isRowPresent = true
                  }
                }
                else {
                  isRowPresent = checkCondition(oauthToken, nextRecord)
                }
                if (isRowPresent) {
                  setMergeData(oauthToken, nextRecord)
                  allContents.update(i, setToken(oauthToken).mkString(","))
                }
              }
              else {
                allContents.remove(i)
              }
            }
          }
          if (!isRowPresent) {
            if (oauthToken.getId != null || oauthToken.getUserSignature != null) {
              if (oauthToken.getRefreshToken == null && oauthToken.getGrantToken == null && oauthToken.getAccessToken == null) {
                throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_FILE_ERROR1)
              }
            }
            if (oauthToken.getId == null) {
              val newId = generateId(allContents)
              oauthToken.setId(newId)
            }
            allContents.addOne(setToken(oauthToken).mkString(","));
          }
          writer = new FileWriter(file)
          writer.write(allContents.mkString("\n"))
          writer.flush()
        case _ =>
      }
    }
    catch {
      case e: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.SAVE_TOKEN_FILE_ERROR, e)
    }
    finally {
      if (src != null) src.close()
      if (writer != null) writer.close()
    }
  }

  @throws[SDKException]
  override def deleteToken(id: String): Unit = {
    var src: Source = null
    var writer: FileWriter = null
    try {
      val file = new File(this.filePath)
      src = Source.fromFile(this.filePath)
      var isRowPresent = false
      val allContents: collection.mutable.ListBuffer[String] = src.getLines.toList.to(collection.mutable.ListBuffer)
      if(allContents.size > 1) {
        breakable {
          for (i <- 1 until allContents.length) {
            val nextRecord = allContents(i).split(",")
            if (nextRecord.length > 1) {
              val recordId = getData(String.valueOf(nextRecord(0)))
              if (recordId != null && recordId.equals(id)) {
                isRowPresent = true
                allContents.remove(i)
                break
              }
            }
          }
        }
      }
      writer = new FileWriter(file)
      allContents.foreach(writer.write)
      writer.flush()
      if (!isRowPresent) {
				throw new SDKException(Constants.TOKEN_STORE, Constants.TOKEN_BY_ID_FILE_ERROR)
			}
    }
    catch {
      case e: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.DELETE_TOKEN_FILE_ERROR, e)
    }
    finally {
      if(src != null) src.close()
      if(writer != null ) writer.close()
    }
  }

  @throws[SDKException]
  override def getTokens: ArrayBuffer[Token] = {
    val tokens = new ArrayBuffer[Token]
    var src: Source = null
    val lines = src.getLines.toList
    try {
      src = Source.fromFile(this.filePath)
      if(lines.size > 1) {
        for (i <- 1 until lines.length) {
          val nextRecord = lines(i).split(",")
          val oauthToken = new OAuthToken()
          setMergeData(oauthToken, nextRecord)
          tokens.addOne(oauthToken)
        }
      }
    } catch {
      case e: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKENS_FILE_ERROR, e)
    }
    finally {
      if(src != null) src.close()
    }
    tokens
  }

  @throws[SDKException]
  override def deleteTokens(): Unit = {
    val file = new File(this.filePath)
    var writer: FileWriter = null
    try {
      writer = new FileWriter(file)
      writer.write(this.headerString.mkString(","))
      writer.flush()
    }
    catch {
      case e: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.DELETE_TOKENS_FILE_ERROR, e)
    }
    finally {
      if (writer != null) writer.close()
    }
  }

  @throws[SDKException]
  override def findTokenById(id: String): Token = {
    var src: Source = null
    try {
      val oauthToken = new OAuthToken
      src = Source.fromFile(this.filePath)
      val lines = src.getLines.toList
      var isRowPresent: Boolean = false
      if(lines.size > 1) {
        for (i <- 1 until lines.length) {
          val nextRecord = lines(i).split(",")
          if (nextRecord(0) == id) {
            isRowPresent = true
            setMergeData(oauthToken, nextRecord)
            return oauthToken
          }
        }
      }
      if (!isRowPresent) {
				throw new SDKException(Constants.TOKEN_STORE, Constants.TOKEN_BY_ID_FILE_ERROR)
			}
    } catch {
      case e: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_FILE_ERROR, e)
    }
    finally {
      if(src != null) src.close()
    }
    null
  }

  private def checkCondition(oauthToken: OAuthToken, nextRecord: Array[String]): Boolean = {
    var isRowPresent = false
    if (oauthToken.getUserSignature != null) {
      val name = oauthToken.getUserSignature.getName
      val userName = getData(nextRecord(1))
      if (name != null && name.nonEmpty && userName != null && userName.nonEmpty && name == userName) {
        isRowPresent = true
      }
    }
    else if (oauthToken.getAccessToken != null && Utility.areAllObjectsNull(oauthToken.getClientId, oauthToken.getClientSecret)) {
      val accessToken = getData(nextRecord(5))
      if (accessToken != null && accessToken.nonEmpty && oauthToken.getAccessToken.nonEmpty && oauthToken.getAccessToken.equals(accessToken)) {
        isRowPresent = true
      }
    }
    else if ((oauthToken.getRefreshToken != null || oauthToken.getGrantToken != null) && oauthToken.getClientId != null && oauthToken.getClientSecret != null) {
      val grantToken = getData(nextRecord(6))
      val refreshToken = getData(nextRecord(4))
      if (grantToken != null && grantToken.nonEmpty && oauthToken.getGrantToken != null && oauthToken.getGrantToken.nonEmpty && oauthToken.getGrantToken.equals(grantToken)) {
        isRowPresent = true
      }
      else if (refreshToken != null && refreshToken.nonEmpty && oauthToken.getRefreshToken != null && oauthToken.getRefreshToken.nonEmpty && oauthToken.getRefreshToken.equals(refreshToken)) {
        isRowPresent = true
      }
    }
    isRowPresent
  }

  private def getData(value: String): String = {
    if (value != null && value.nonEmpty && !value.equals("null")) value else null
  }

  @throws[SDKException]
  private def setMergeData(oauthToken: OAuthToken, nextRecord: Array[String]): Unit = {
    if (oauthToken.getId == null) oauthToken.setId(getData(nextRecord(0)))
    if (oauthToken.getUserSignature == null) {
      val name = getData(nextRecord(1))
      if (name != null) oauthToken.setUserSignature(new UserSignature(name))
    }
    if (oauthToken.getClientId == null) oauthToken.setClientId(getData(nextRecord(2)))
    if (oauthToken.getClientSecret == null) oauthToken.setClientSecret(getData(nextRecord(3)))
    if (oauthToken.getRefreshToken == null) oauthToken.setRefreshToken(getData(nextRecord(4)))
    if (oauthToken.getAccessToken == null) oauthToken.setAccessToken(getData(nextRecord(5)))
    if (oauthToken.getGrantToken == null) oauthToken.setGrantToken(getData(nextRecord(6)))
    if (oauthToken.getExpiresIn == null) {
      val expiresIn = getData(nextRecord(7))
      if (expiresIn != null) oauthToken.setExpiresIn(String.valueOf(expiresIn))
    }
    if (oauthToken.getRedirectURL == null) oauthToken.setRedirectURL(getData(nextRecord(8)))
    if (oauthToken.getAPIDomain == null) oauthToken.setAPIDomain(getData(nextRecord(9)))
  }

  private def setToken(oauthToken: OAuthToken): Array[String] = {
    val data: Array[String] =  new Array[String](10)
    data(0) = oauthToken.getId
    data(1) = if (oauthToken.getUserSignature != null) oauthToken.getUserSignature.getName else null
    data(2) = oauthToken.getClientId
    data(3) = oauthToken.getClientSecret
    data(4) = oauthToken.getRefreshToken
    data(5) = oauthToken.getAccessToken
    data(6) = oauthToken.getGrantToken
    data(7) = oauthToken.getExpiresIn
    data(8) = oauthToken.getRedirectURL
    data(9) = oauthToken.getAPIDomain
    data
  }

  private def generateId(allContents: ListBuffer[String]) = {
    var maxValue = 0
    if (allContents.length > 1) {
      var index = 1
      for (i <- 1 until allContents.length) {
        val nextRecord = allContents(i).split(",")
        if (nextRecord.length > 1 && nextRecord(0) != null && nextRecord(0).nonEmpty) {
          if (maxValue < nextRecord(0).toInt) {
            maxValue = nextRecord(0).toInt
          }
        }
        index += 1
      }
    }
    String.valueOf(maxValue + 1)
  }
}
