package com.zoho.api.authenticator

import com.zoho.api.authenticator.store.TokenStore
import com.zoho.api.logger.SDKLogger
import com.zoho.crm.api.dc.DataCenter
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.{APIHTTPConnector, Constants, Utility}
import com.zoho.crm.api.{Initializer, SDKConfig, UserSignature}
import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.conn.ssl.{NoopHostnameVerifier, SSLConnectionSocketFactory}
import org.apache.http.impl.client.{CloseableHttpClient, HttpClientBuilder}
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils
import org.json.{JSONException, JSONObject}

import java.io.IOException
import java.security.NoSuchAlgorithmException
import java.util
import java.util.logging.{Level, Logger}
import javax.net.ssl.SSLContext
import scala.collection.mutable

/**
 * This object contains OAuthToken
 */
object OAuthToken {
  class Builder() {
    private var clientID: String = _
    private var clientSecret: String = _
    private var redirectURL: String = _
    private var refreshToken: String = _
    private var grantToken: String = _
    private var accessToken: String = _
    private var id: String = _
    private var userSignature: UserSignature = _
    private var findUser: Boolean = true

    def id(id: String): OAuthToken.Builder = {
      this.id = id
      this
    }

    def clientID(clientID: String): OAuthToken.Builder = {
      Utility.assertNotNull(clientID, Constants.TOKEN_ERROR, Constants.CLIENT_ID_NULL_ERROR_MESSAGE)
      this.clientID = clientID
      this
    }

    def clientSecret(clientSecret: String): OAuthToken.Builder = {
      Utility.assertNotNull(clientSecret, Constants.TOKEN_ERROR, Constants.CLIENT_SECRET_NULL_ERROR_MESSAGE)
      this.clientSecret = clientSecret
      this
    }

    def redirectURL(redirectURL: String): OAuthToken.Builder = {
      this.redirectURL = redirectURL
      this
    }

    def refreshToken(refreshToken: String): OAuthToken.Builder = {
      this.refreshToken = refreshToken
      this
    }

    def grantToken(grantToken: String): OAuthToken.Builder = {
      this.grantToken = grantToken
      this
    }

    def accessToken(accessToken: String): OAuthToken.Builder = {
      this.accessToken = accessToken
      this
    }

    def userSignature(userSignature: UserSignature): OAuthToken.Builder = {
      this.userSignature = userSignature
      this
    }

    def findUser(findUser: Boolean): OAuthToken.Builder = {
      this.findUser = findUser
      this
    }

    def build(): OAuthToken = {
      if (Utility.areAllObjectsNull(this.grantToken, this.refreshToken, this.id, this.accessToken, this.userSignature)) {
        throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR.concat(" - ").concat(Constants.OAUTH_MANDATORY_KEYS.mkString(", ")))
      }
      if (!Utility.areAllObjectsNull(this.grantToken, this.refreshToken)) if (Utility.areAllObjectsNull(this.clientID, this.clientSecret)) {
        throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR.concat(" - ").concat(Constants.OAUTH_MANDATORY_KEYS1.mkString(", ")))
      }
      else {
        Utility.assertNotNull(this.clientID, Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR.concat(" - ").concat(Constants.CLIENT_ID))
        Utility.assertNotNull(this.clientSecret, Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR.concat(" - ").concat(Constants.CLIENT_SECRET))
      }
      new OAuthToken(this.clientID, this.clientSecret, this.grantToken, this.refreshToken, this.redirectURL, this.id, this.accessToken, this.userSignature, this.findUser)
    }
  }
}

/**
 * This class gets and refreshes the tokens based on the expiry time.
 *
 * @constructor Creates an OAuthToken class instance with the specified parameters.
 * @param clientID     A String containing the OAuth client id.
 * @param clientSecret A String containing the OAuth client secret.
 * @param grantToken  A String containing the OAuth GRANT token.
 * @param refreshToken A String containing the OAuth REFRESH token.
 * @param id.
 * @param accessToken.
 */
class OAuthToken(private var clientID: String, private var clientSecret: String, private var grantToken: String, private var refreshToken: String, private var redirectURL: String, private var id: String, private var accessToken: String, private var userSignature:UserSignature, private var findUser:Boolean) extends Token {
  private val LOGGER: Logger = Logger.getLogger(classOf[SDKLogger].getName)
  clientID = clientID
  clientSecret = clientSecret
  grantToken = grantToken
  refreshToken = refreshToken
  redirectURL = redirectURL
  accessToken = accessToken
  id = id
  userSignature = userSignature
  private var expiresIn: String = _
  private var apiDomain: String = null
  findUser = findUser

  def this() = {
    this(null,null,null,null,null,null,null,null,true)
  }

  /**
   * This is a getter method to get OAuth client id.
   *
   * @return A String representing the OAuth client id.
   */
  def getClientId: String = clientID

  /**
   * This is a getter method to get OAuth client secret.
   *
   * @return A String representing the OAuth client secret.
   */
  def getClientSecret: String = clientSecret

  /**
   * This is a getter method to get OAuth redirect URL.
   *
   * @return A String representing the OAuth redirect URL.
   */
  def getRedirectURL: String = redirectURL

  /**
   * This is a getter method to get grant token.
   *
   * @return A String representing the grant token.
   */
  def getGrantToken: String = grantToken

  /**
   * This is a getter method to get refresh token.
   *
   * @return A String representing the refresh token.
   */
  def getRefreshToken: String = refreshToken

  /**
   * This is a setter method to set refresh token.
   *
   * @param refreshToken A String containing the refresh token.
   */
  def setRefreshToken(refreshToken: String): Unit = {
    this.refreshToken = refreshToken
  }

  /**
   * This is a setter method to set redirect URL.
   *
   * @param redirectURL A String containing the redirect URL.
   */
  def setRedirectURL(redirectURL: String): Unit = {
    this.redirectURL = redirectURL
  }

  /**
   * This is a getter method to get OAuth client id.
   *
   * @return A String representing the OAuth client id.
   */
  def setClientId(clientID: String): Unit = {
    this.clientID = clientID
  }

  /**
   * This is a getter method to get OAuth client secret.
   *
   * @return A String representing the OAuth client secret.
   */
  def setClientSecret(clientSecret: String): Unit = {
    this.clientSecret = clientSecret
  }

  /**
   * This is a setter method to set grant token.
   *
   * @return A String containing the grant token.
   */
  def setGrantToken(grantToken: String): Unit = {
    this.grantToken = grantToken
  }

  /**
   * This is a getter method to get access token.
   *
   * @return A String representing the access token.
   */
  def getAccessToken: String = accessToken

  /**
   * This is a setter method to set access token.
   *
   * @param accessToken A String containing the access token.
   */
  def setAccessToken(accessToken: String): Unit = {
    this.accessToken = accessToken
  }

  /**
   * This is a getter method to get token expire time.
   *
   * @return A String containing the token expire time.
   */
  def getExpiresIn: String = expiresIn

  /**
   * This is a setter method to set token expire time.
   *
   * @param expiresIn A String containing the token expire time.
   */
  def setExpiresIn(expiresIn: String): Unit = {
    this.expiresIn = expiresIn
  }

  def getUserSignature: UserSignature = userSignature

  def setUserSignature(userSignature: UserSignature): Unit = {
    this.userSignature = userSignature
  }

  def getAPIDomain: String = apiDomain

  def setAPIDomain(apiDomain: String): Unit = {
    this.apiDomain = apiDomain
  }

  /**
   * @return the id
   */
  def getId: String = id

  /**
   * @param id the id to set
   */
  def setId(id: String): Unit = {
    this.id = id
  }

  override def generateToken(): Unit = synchronized {
    getToken
  }

  def getToken: String = {
    val initializer = Initializer.getInitializer
    val store: TokenStore = initializer.getStore
    var oauthToken: OAuthToken = null
    if (this.getId != null) {
      oauthToken = store.findTokenById(this.getId).asInstanceOf[OAuthToken]
      mergeObjects(this, oauthToken)
      oauthToken.findUser = this.findUser
    }
    else {
      oauthToken = store.findToken(this).asInstanceOf[OAuthToken]
    }
    if (oauthToken == null) {
      if (this.getUserSignature != null) {
        checkTokenDetails
      }
      oauthToken = this
    }
    if (oauthToken.getAPIDomain == null || oauthToken.getAPIDomain.length <= 0) {
      if (initializer.getEnvironment == null) throw new SDKException(Constants.ENVIRONMENT_ERROR_1, Constants.ENVIRONMENT_ERROR_MESSAGE.concat(" : "))
      oauthToken.setAPIDomain(initializer.getEnvironment.getUrl)
    }
    val environment = DataCenter.get(oauthToken.getAPIDomain)
    if (environment != null) {
      try {
        val member = initializer.getClass.getDeclaredField(Constants.ENVIRONMENT)
        member.setAccessible(true)
        member.set(initializer, environment)
      } catch {
        case e: Exception =>
          throw new SDKException(Constants.ENVIRONMENT_ERROR_RESPONSE.concat(" : "), e)
      }
    }
    else if (initializer.getEnvironment == null) throw new SDKException(Constants.ENVIRONMENT_ERROR_1, Constants.ENVIRONMENT_ERROR_MESSAGE.concat(" : "))
    val url = initializer.getEnvironment.getAccountsUrl
    var save = false
    if (oauthToken == null || oauthToken.getAccessToken == null  || oauthToken.getAccessToken.isEmpty) {
      if (oauthToken.refreshToken != null && oauthToken.getRefreshToken != null && oauthToken.getRefreshToken.nonEmpty) {
        LOGGER.log(Level.INFO, Constants.ACCESS_TOKEN_USING_REFRESH_TOKEN_MESSAGE)
        this.refreshAccessToken(oauthToken, url)
      } else {
        LOGGER.log(Level.INFO, Constants.ACCESS_TOKEN_USING_GRANT_TOKEN_MESSAGE)
        this.generateAccessToken(oauthToken, url)
      }
      save = true
    } else if (oauthToken.getExpiresIn != null && (oauthToken.getExpiresIn.toLong - System.currentTimeMillis()) < 5000) { // access token will expire in next 5 seconds or less
      LOGGER.log(Level.INFO, Constants.REFRESH_TOKEN_MESSAGE)
      oauthToken.refreshAccessToken(oauthToken, url)
      save = true
    } else if (oauthToken.getExpiresIn == null && oauthToken.getAccessToken != null && oauthToken.getId == null) {
      save = true
    }
    if (save) try {
      if (oauthToken.getUserSignature == null && oauthToken.findUser) {
        try {
          val userName = Utility.getUserName(oauthToken.getAccessToken)
          if (userName != null) {
            oauthToken.setUserSignature(new UserSignature(userName))
          }
        } catch {
          case ex: SDKException =>
            LOGGER.log(Level.SEVERE, Constants.API_EXCEPTION, ex)
        }
      }
      store.saveToken(oauthToken)
    } catch {
      case ex: Exception =>
        throw new SDKException(Constants.SAVE_TOKEN_ERROR, ex)
    }
    oauthToken.getAccessToken
  }

  @throws[SDKException]
  private def checkTokenDetails: Boolean = {
    if (Utility.areAllObjectsNull(this.grantToken, this.refreshToken)) {
      throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.GET_TOKEN_BY_USER_NAME_ERROR.concat(" - ").concat(Constants.OAUTH_MANDATORY_KEYS2.mkString(",")))
    }
    true
  }

  override def authenticate(urlConnection: APIHTTPConnector): Unit = synchronized {
    if (!urlConnection.getHeaders.contains(Constants.AUTHORIZATION)) {
      urlConnection.addHeader(Constants.AUTHORIZATION, Constants.OAUTH_HEADER_PREFIX + getToken)
    }
  }

  @throws[SDKException]
  private def mergeObjects[T](first: T, second: T): Unit = {
    try {
      val clas = first.getClass
      val fields = clas.getDeclaredFields
      for (field <- fields) {
        if (Constants.OAUTH_TOKEN_FIELDS.contains(field.getName)) {
          field.setAccessible(true)
          val value1 = field.get(first)
          val value2 = field.get(second)
          val value = if (value1 != null) value1
          else value2
          field.set(first, value)
        }
      }
    } catch {
      case ex: Exception =>
        throw new SDKException(Constants.MERGE_OBJECT, ex)
    }
  }

  private def getResponseFromServer(requestParams: mutable.HashMap[String, String], url: String): String = {
    try {
      val USER_AGENT = Constants.USER_AGENT
      val client = getHttpClient
      val post = new HttpPost(url)
      post.setHeader(Constants.USER_AGENT_KEY, USER_AGENT)
      val urlParameters = new util.ArrayList[NameValuePair]()
      /*
			 * Set request Parameters
			 */
      if (requestParams != null && requestParams.nonEmpty) {
        for ((key, value) <- requestParams) {
          if (value != null) {
            urlParameters.add(new BasicNameValuePair(key, value))
          }
        }
        post.setEntity(new UrlEncodedFormEntity(urlParameters))
        LOGGER.log(Level.INFO, this.toString(url))
        val response = EntityUtils.toString(client.execute(post).getEntity)
        return response
      }
    }
    catch {
      case e: NoSuchAlgorithmException => throw new SDKException(e)
      case e: IOException => throw new SDKException(e)
    }
    null
  }

  def toString(url: String): String = {
    val requestStringBuilder = new StringBuilder()
		requestStringBuilder.append("POST - ")
		requestStringBuilder.append(Constants.URL).append(" = ").append(url).append(".")
    requestStringBuilder.toString()
	}

  private def getHttpClient: CloseableHttpClient = {
    val httpClientBuilder: HttpClientBuilder = HttpClientBuilder.create()
    val sslContext: SSLContext = SSLContext.getDefault
    val sslConnectionSocketFactory: SSLConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE)
    httpClientBuilder.setSSLSocketFactory(sslConnectionSocketFactory).build()
  }

  private def refreshAccessToken(oauthToken: OAuthToken, url: String): OAuthToken = {
    val requestParams: mutable.HashMap[String, String] = new mutable.HashMap[String, String]()
    requestParams(Constants.CLIENT_ID) = this.clientID
    requestParams(Constants.CLIENT_SECRET) = this.clientSecret
    requestParams(Constants.GRANT_TYPE) = Constants.REFRESH_TOKEN
    requestParams(Constants.REFRESH_TOKEN) = this.refreshToken
    try {
      parseResponse(oauthToken, getResponseFromServer(requestParams, url))
    }
    catch {
      case e: SDKException => throw e
      case e: Exception =>

        throw new SDKException(Constants.SAVE_TOKEN_ERROR, e)
    }
    oauthToken
  }

  private def generateAccessToken(oauthToken: OAuthToken, url: String): OAuthToken = {
    val requestParams: mutable.HashMap[String, String] = new mutable.HashMap[String, String]()
    requestParams(Constants.CLIENT_ID) = this.clientID
    requestParams(Constants.CLIENT_SECRET) = this.clientSecret
    if (this.redirectURL != null) {
      requestParams(Constants.REDIRECT_URI) = this.redirectURL
    }
    requestParams(Constants.GRANT_TYPE) = Constants.GRANT_TYPE_AUTH_CODE
    requestParams(Constants.CODE) = this.grantToken
    try {
      parseResponse(oauthToken, getResponseFromServer(requestParams, url))
    }
    catch {
      case e: SDKException => throw e
      case e: Exception =>
        throw new SDKException(Constants.SAVE_TOKEN_ERROR, e)
    }
    oauthToken
  }

  private def revokeRefreshToken(refreshToken: String, url: String): Boolean = {
    val requestParams: mutable.HashMap[String, String] = new mutable.HashMap[String, String]()
    requestParams(Constants.TOKEN) = refreshToken
    var response: String = ""
    try {
      response = getResponseFromServer(requestParams, url)
      val responseJSON: JSONObject = new JSONObject(response)
      if (responseJSON != null && responseJSON.has(Constants.STATUS) && responseJSON.getString(Constants.STATUS).equals(Constants.SUCCESS)) {
				return true
			}
      false
    }
    catch {
      case e: JSONException =>
        throw new SDKException(Constants.PARSE_RESPONSE.concat(" : ").concat(response), e);
      case e: SDKException => throw e
      case e: Exception =>
        throw new SDKException(Constants.SAVE_TOKEN_ERROR, e)
    }
  }

  private def parseResponse(oauthToken: OAuthToken, response: String): OAuthToken = {
    val responseJSON: JSONObject = new JSONObject(response)
    val initializer = Initializer.getInitializer
    val sdkConfig = initializer.getSDKConfig
    if (!responseJSON.has(Constants.ACCESS_TOKEN)) {
      throw new SDKException(Constants.INVALID_CLIENT_ERROR, if (responseJSON.has(Constants.ERROR_KEY)) responseJSON.getString(Constants.ERROR_KEY) else Constants.NO_ACCESS_TOKEN_ERROR)
    }
    oauthToken.setAccessToken(responseJSON.getString(Constants.ACCESS_TOKEN))
    oauthToken.setExpiresIn(String.valueOf(this.getTokenExpiryTime(responseJSON)))
    if (responseJSON.has(Constants.REFRESH_TOKEN)) {
      oauthToken.setRefreshToken(responseJSON.getString(Constants.REFRESH_TOKEN))
    }
    if (responseJSON.has(Constants.API_DOMAIN)) {
      oauthToken.setAPIDomain(responseJSON.getString(Constants.API_DOMAIN))
    }

    if (sdkConfig.applyAPIDomainUpdate && responseJSON.has(Constants.API_DOMAIN))
    {
      oauthToken.setAPIDomain(responseJSON.getString(Constants.API_DOMAIN))
    }
    oauthToken
  }

  private def getTokenExpiryTime(responseJO: JSONObject): java.lang.Long = {
    System.currentTimeMillis() +
      (if (responseJO.has(Constants.EXPIRES_IN_SEC)) {
        responseJO.getLong(Constants.EXPIRES_IN)
      }
      else {
        responseJO.getInt(Constants.EXPIRES_IN) * 1000
      })
  }

  /**
   * The method to remove the current token from the Store.
   *
   * @throws SDKException Exception
   */
  @throws[SDKException]
  override def remove(): Unit = try {
    if (Initializer.getInitializer == null) {
      throw new SDKException(Constants.SDK_UNINITIALIZATION_ERROR, Constants.SDK_UNINITIALIZATION_MESSAGE)
    }
    Initializer.getInitializer.getStore.deleteToken(this.getId)
  } catch {
    case ex: SDKException =>
      throw ex
    case ex: Exception =>
      throw new SDKException(ex)
  }

  @throws[SDKException]
  def revoke(id: String): Boolean = try {
    if (Initializer.getInitializer == null) {
      throw new SDKException(Constants.SDK_UNINITIALIZATION_ERROR, Constants.SDK_UNINITIALIZATION_MESSAGE)
    }
    val initializer = Initializer.getInitializer
    val store = initializer.getStore
    val url = initializer.getEnvironment.getAccountsUrl
    var isRevoke = false
    val oauthToken = new OAuthToken
    oauthToken.setId(id)
    store.findToken(oauthToken)
    if (oauthToken != null && oauthToken.getRefreshToken != null) {
      isRevoke = this.revokeRefreshToken(oauthToken.getRefreshToken, url.concat(Constants.REVOKE_URL))
      LOGGER.log(Level.INFO, new StringBuffer().append(Constants.ID).append(" : ").append(id).append(Constants.REFRESH_TOKEN_REMOVED).toString)
    }
    else {
      LOGGER.log(Level.WARNING, new StringBuffer().append(Constants.ID).append(" : ").append(id).append(Constants.TOKEN_NOT_FOUND).toString)
    }
    isRevoke
  } catch {
    case ex: SDKException =>
      throw ex
    case ex: Exception =>
      throw new SDKException(ex)
  }
}