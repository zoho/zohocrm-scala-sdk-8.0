package com.zoho.api.authenticator.store

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.UserSignature

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.Statement
import java.sql.ResultSet
import com.zoho.crm.api.util.{Constants, Utility}
import com.zoho.crm.api.exception.SDKException

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object DBStore {
  class Builder() {
    private var userName = Constants.MYSQL_USER_NAME
    private var portNumber = Constants.MYSQL_PORT_NUMBER
    private var password = ""
    private var host = Constants.MYSQL_HOST
    private var databaseName = Constants.MYSQL_DATABASE_NAME
    private var tableName = Constants.MYSQL_TABLE_NAME

    def userName(userName: Option[String]): DBStore.Builder = {
      if (userName.isDefined) {
        this.userName = userName.get
      }
      this
    }

    def portNumber(portNumber: Option[String]): DBStore.Builder = {
      if (portNumber.isDefined) {
        this.portNumber = portNumber.get
      }
      this
    }

    def password(password: Option[String]): DBStore.Builder = {
      if (password.isDefined) {
        this.password = password.get
      }
      this
    }

    def host(host: Option[String]): DBStore.Builder = {
      if (host.isDefined) {
        this.host = host.get
      }
      this
    }

    def databaseName(databaseName: Option[String]): DBStore.Builder = {
      if (databaseName.isDefined) {
        this.databaseName = databaseName.get
      }
      this
    }

    def tableName(tableName: Option[String]): DBStore.Builder = {
      if (tableName.isDefined) {
        this.tableName = tableName.get
      }
      this
    }

    def build = new DBStore(host, databaseName, tableName, userName, password, portNumber)
  }
}

/**
 * This class stores the user token details to the MySQL DataBase.
 *
 * @constructor Creates a DBStore class instance with the specified parameters.
 * @param host         A String containing the DataBase host name.
 * @param databaseName A String containing the DataBase name.
 * @param userName     A String containing the DataBase user name.
 * @param password     A String containing the DataBase password.
 * @param portNumber   A String containing the DataBase port number.
 */
class DBStore(private var host: String, private var databaseName: String, private var tableName: String, private var userName: String, private var password: String, private var portNumber: String) extends TokenStore {
  host = host
  databaseName = databaseName
  tableName = tableName
  userName = userName
  password = password
  portNumber = portNumber
  private val connectionString: String = this.host + ":" + this.portNumber + "/" + this.databaseName + "?allowPublicKeyRetrieval=true&useSSL=false"

  @throws[SDKException]
  override def findToken(token: Token) : Token = {
    var connection: Connection = null
    var statement: PreparedStatement = null
    var resultSet: ResultSet = null
    try {
      token match {
        case oauthToken: OAuthToken =>
          val sb = new mutable.StringBuilder
          sb.append("select * from ").append(this.tableName)
          var param: Object = null
          if (oauthToken.getUserSignature != null) {
            val name = oauthToken.getUserSignature.getName
            if (name != null && name.nonEmpty) {
              sb.append(" where user_name = ?")
              param = name
            }
          }
          else if (oauthToken.getAccessToken != null && Utility.areAllObjectsNull(oauthToken.getClientId, oauthToken.getClientSecret)) {
            sb.append(" where access_token = ?")
            param = oauthToken.getAccessToken
          }
          else if ((oauthToken.getRefreshToken != null || oauthToken.getGrantToken != null) && oauthToken.getClientId != null && oauthToken.getClientSecret != null) {
            if (oauthToken.getGrantToken != null && oauthToken.getGrantToken.nonEmpty) {
              sb.append(" where grant_token = ?")
              param = oauthToken.getGrantToken
            }
            else if (oauthToken.getRefreshToken != null && oauthToken.getRefreshToken.nonEmpty) {
              sb.append(" where refresh_token = ?")
              param = oauthToken.getRefreshToken
            }
          }
          sb.append(" limit 1")
          Class.forName(Constants.JDBC_DRIVER_NAME)
          connection = DriverManager.getConnection(this.connectionString, this.userName, this.password)
          statement = connection.prepareStatement(sb.toString())
          statement.setString(1, param.toString)
          resultSet = statement.executeQuery()
          while (resultSet.next()) {
            setMergeData(oauthToken, resultSet)
            return oauthToken
          }
        case _ =>
      }
    } catch {
      case e: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_DB_ERROR, e)
    }
    finally {
      if (resultSet != null) resultSet.close()
      if (statement != null) statement.close()
      if (connection != null) connection.close()
    }
    token
  }

  @throws[SDKException]
  override def saveToken(token: Token): Unit = {
    var connection: Connection = null
    var statement: PreparedStatement = null
    try {
      token match {
        case oauthToken: OAuthToken =>
          val sb = new mutable.StringBuilder
          sb.append("update ").append(this.tableName).append(" set ")
          var param: String = null
          if (oauthToken.getUserSignature != null) {
            val name = oauthToken.getUserSignature.getName
            if (name != null && name.nonEmpty) {
              sb.append(setToken(oauthToken)).append(" where user_name = ?")
              param = name
            }
          }
          else if (oauthToken.getAccessToken != null && oauthToken.getAccessToken.nonEmpty && Utility.areAllObjectsNull(oauthToken.getClientId, oauthToken.getClientSecret)){
            sb.append(setToken(oauthToken)).append(" where access_token = ?")
            param = oauthToken.getAccessToken
          }
          else if (((oauthToken.getRefreshToken != null && oauthToken.getRefreshToken.nonEmpty) || (oauthToken.getGrantToken != null && oauthToken.getGrantToken.nonEmpty)) && oauthToken.getClientId != null && oauthToken.getClientSecret != null) {
            if (oauthToken.getGrantToken != null && oauthToken.getGrantToken.nonEmpty) {
              sb.append(setToken(oauthToken)).append(" where grant_token = ?")
              param = oauthToken.getGrantToken
            }
            else if (oauthToken.getRefreshToken != null && oauthToken.getRefreshToken.nonEmpty) {
              sb.append(setToken(oauthToken)).append(" where refresh_token = ?")
              param = oauthToken.getRefreshToken
            }
          }
          sb.append(" limit 1")
          Class.forName(Constants.JDBC_DRIVER_NAME)
          connection = DriverManager.getConnection(this.connectionString, this.userName, this.password)
          var rowAffected = 0
          statement = connection.prepareStatement(sb.toString)
          statement.setString(1, param)
          rowAffected = statement.executeUpdate
          if(rowAffected == 0) {
            if (oauthToken.getId != null || oauthToken.getUserSignature != null) {
              if (oauthToken.getRefreshToken == null && oauthToken.getGrantToken == null && oauthToken.getAccessToken == null) {
                throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_DB_ERROR1)
              }
            }
            if (oauthToken.getId == null) {
              val newId = String.valueOf(generateId)
              oauthToken.setId(newId)
            }
            statement = connection.prepareStatement("insert into " + this.tableName + "(id,user_name,client_id,client_secret,refresh_token,access_token,grant_token,expiry_time,redirect_url,api_domain) values(?,?,?,?,?,?,?,?,?,?) on duplicate key update user_name=values(user_name),client_id=values(client_id),client_secret=values(client_secret),refresh_token=values(refresh_token),access_token=values(access_token),grant_token=values(grant_token),expiry_time=values(expiry_time),redirect_url=values(redirect_url),api_domain=values(api_domain)") // No i18N
            statement.setString(1, oauthToken.getId)
            statement.setString(2, if (oauthToken.getUserSignature != null)  oauthToken.getUserSignature.getName else null)
            statement.setString(3, oauthToken.getClientId)
            statement.setString(4, oauthToken.getClientSecret)
            statement.setString(5, oauthToken.getRefreshToken)
            statement.setString(6, oauthToken.getAccessToken)
            statement.setString(7, oauthToken.getGrantToken)
            statement.setString(8, oauthToken.getExpiresIn)
            statement.setString(9, oauthToken.getRedirectURL)
            statement.setString(10, oauthToken.getAPIDomain)
            statement.executeUpdate()
          }
        case _ =>
      }
    }
    catch {
      case e: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.SAVE_TOKEN_DB_ERROR, e)
    }
    finally {
      if (statement != null) statement.close()
      if (connection != null) connection.close()
    }
  }

  @throws[SDKException]
  override def deleteToken(id: String): Unit = {
    var connection: Connection = null
    try {
      Class.forName(Constants.JDBC_DRIVER_NAME)
      connection = DriverManager.getConnection(this.connectionString, this.userName, this.password)
      val sb = new StringBuilder().append("delete from ").append(this.tableName).append(" where id = ?").toString()
      val statement = connection.prepareStatement(sb)
      statement.setString(1, id)
      try statement.executeUpdate
      finally if (statement != null) statement.close()
    }
    catch {
      case e: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.DELETE_TOKEN_DB_ERROR, e)
    }
    finally {
      if (connection != null) connection.close()
    }
  }

  @throws[SDKException]
  override def getTokens: ArrayBuffer[Token] = {
    var statement: Statement = null
    var result: ResultSet = null
    var connection: Connection = null
    val tokens = new ArrayBuffer[Token]
    try {
      connection = DriverManager.getConnection(this.connectionString, this.userName, this.password)
      Class.forName(Constants.JDBC_DRIVER_NAME)
      statement = connection.createStatement
      val query = "select * from " + this.tableName + ";"
      result = statement.executeQuery(query)
      while ({result.next}) {
        val oauthToken = new OAuthToken
        setMergeData(oauthToken, result)
        tokens.addOne(oauthToken)
      }
    } catch {
      case ex: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKENS_DB_ERROR, ex)
    }
    finally {
      if (result != null) result.close()
      if (statement != null) statement.close()
      if (connection != null) connection.close()
    }
    tokens
  }

  @throws[SDKException]
  override def deleteTokens(): Unit = {
    var connection: Connection = null
    try {
      connection = DriverManager.getConnection(this.connectionString, this.userName, this.password)
      Class.forName(Constants.JDBC_DRIVER_NAME)
      val query = "delete from " + this.tableName + ";"
      val statement = connection.prepareStatement(query)
      try statement.executeUpdate
      finally if (statement != null) statement.close()
    }
    catch {
      case ex: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.DELETE_TOKENS_DB_ERROR, ex)
    }
    finally if (connection != null) connection.close()
  }

  @throws[SDKException]
  override def findTokenById(id: String): Token = {
    var connection: Connection = null
    var statement: PreparedStatement = null
    var resultSet: ResultSet = null
    try {
      Class.forName(Constants.JDBC_DRIVER_NAME)
      connection = DriverManager.getConnection(this.connectionString, this.userName, this.password)
      val oauthToken = new OAuthToken
      val query = s"select * from " + this.tableName + " where id = ?"
      statement = connection.prepareStatement(query)
      statement.setString(1, id)
      resultSet = statement.executeQuery()
      while (resultSet.next()) {
        setMergeData(oauthToken, resultSet)
        return oauthToken
      }
    } catch {
      case e: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.GET_TOKEN_BY_ID_DB_ERROR, e)
    }
    finally {
      if (resultSet != null) resultSet.close()
      if (statement != null) statement.close()
      if (connection != null) connection.close()
    }
    null
  }

  private def setMergeData(oauthToken: OAuthToken, result: ResultSet): Unit = {
    if (oauthToken.getId == null) oauthToken.setId(result.getString(1))
    if (oauthToken.getUserSignature == null) {
      val name = result.getString(2)
      if (name != null && name.nonEmpty) oauthToken.setUserSignature(new UserSignature(name))
    }
    if (oauthToken.getClientId == null) oauthToken.setClientId(result.getString(3))
    if (oauthToken.getClientSecret == null) oauthToken.setClientSecret(result.getString(4))
    if (oauthToken.getRefreshToken == null) oauthToken.setRefreshToken(result.getString(5))
    if (oauthToken.getAccessToken == null) oauthToken.setAccessToken(result.getString(6))
    if (oauthToken.getGrantToken == null) oauthToken.setGrantToken(result.getString(7))
    if (oauthToken.getExpiresIn == null) {
      val expiresIn = result.getString(8)
      if (expiresIn != null) oauthToken.setExpiresIn(String.valueOf(expiresIn))
    }
    if (oauthToken.getRedirectURL == null) oauthToken.setRedirectURL(result.getString(9))
    if (oauthToken.getAPIDomain == null) oauthToken.setAPIDomain(result.getString(10))
  }

  private def setToken(oauthToken: OAuthToken) = {
    val query = new ArrayBuffer[String]()
    if (oauthToken.getUserSignature != null) {
      val name = oauthToken.getUserSignature.getName
      if (name != null && name.nonEmpty) {
        query.addOne(setTokenInfo(Constants.USER_NAME, name))
      }
    }
    if (oauthToken.getClientId != null) {
      query.addOne(setTokenInfo(Constants.CLIENT_ID, oauthToken.getClientId))
    }
    if (oauthToken.getClientSecret != null) {
      query.addOne(setTokenInfo(Constants.CLIENT_SECRET, oauthToken.getClientSecret))
    }
    if (oauthToken.getRefreshToken != null) {
      query.addOne(setTokenInfo(Constants.REFRESH_TOKEN, oauthToken.getRefreshToken))
    }
    if (oauthToken.getAccessToken != null) {
      query.addOne(setTokenInfo(Constants.ACCESS_TOKEN, oauthToken.getAccessToken))
    }
    if (oauthToken.getGrantToken != null) {
      query.addOne(setTokenInfo(Constants.GRANT_TOKEN, oauthToken.getGrantToken))
    }
    if (oauthToken.getExpiresIn != null) {
      query.addOne(setTokenInfo(Constants.EXPIRY_TIME, oauthToken.getExpiresIn))
    }
    if (oauthToken.getRedirectURL != null) {
      query.addOne(setTokenInfo(Constants.REDIRECT_URL, oauthToken.getRedirectURL))
    }
    if (oauthToken.getAPIDomain != null) {
      query.addOne(setTokenInfo(Constants.API_DOMAIN, oauthToken.getAPIDomain))
    }
    query.mkString(",")
  }

  private def setTokenInfo(key: String, value: String):String = {
    new StringBuilder().append (key).append ("='").append (value).append ("'").toString
  }

  @throws[SDKException]
  private def generateId: Int = {
    val id = 0
    var connection: Connection = null
    var statement: Statement = null
    var resultSet: ResultSet = null
    try {
      Class.forName(Constants.JDBC_DRIVER_NAME)
      connection = DriverManager.getConnection(connectionString, userName, password)
      statement = connection.createStatement
      val query = "select coalesce(max(`id`), 0) as id from " + this.tableName + ";" // No i18N
      resultSet = statement.executeQuery(query)
      while (resultSet.next()) {
        val max = resultSet.getString(1)
        if (max != null) return Integer.parseInt(max) + 1
      }
      id
    } catch {
      case ex: Exception =>
        throw new SDKException(Constants.TOKEN_STORE, Constants.GENERATE_TOKEN_ID_ERROR, ex)
    }
    finally {
      if (resultSet != null) resultSet.close()
      if (statement != null) statement.close()
      if (connection != null) connection.close()
    }
  }
}