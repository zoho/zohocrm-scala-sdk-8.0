package com.zoho.crm.api.dc
import com.zoho.crm.api.dc.DataCenter.Environment


class SADataCenter extends DataCenter {
  override def getIamUrl: String = "https://accounts.zoho.sa/oauth/v2/token"

  override def getFileUploadUrl: String = "https://files.zoho.sa"
}
object SADataCenter {

  /**
   * This Environment class instance represents the Zoho CRM Production environment in SA domain
   *
   * @return An instance of Environment
   */
  val PRODUCTION: Environment = new Environment {
    /**
     * This method is to get Zoho CRM production API URL.
     *
     * @return A String representing the Zoho CRM production API URL.
     */
    override def getUrl: String = "https://www.zohoapis.sa"

    /**
     * This method is to get Zoho CRM Accounts URL.
     *
     * @return A String representing the accounts URL.
     */
    override def getAccountsUrl: String = new SADataCenter().getIamUrl

    /**
     * The method to get Zoho File Upload URL
     *
     * @return A String representing the File Upload URL.
     */
    override def getFileUploadUrl: String = new SADataCenter().getFileUploadUrl
  }

  /**
   * This Environment class instance represents the Zoho CRM Sandbox environment in SA domain
   *
   * @return An instance of Environment
   */
  val SANDBOX: Environment = new Environment {
    /**
     * This method is to get Zoho CRM sandbox API URL.
     *
     * @return A String representing the Zoho CRM production API URL.
     */
    override def getUrl: String = "https://sandbox.zohoapis.sa"

    /**
     * This method is to get Zoho CRM Accounts URL.
     *
     * @return A String representing the accounts URL.
     */
    override def getAccountsUrl: String = new SADataCenter().getIamUrl

    /**
     * The method to get Zoho File Upload URL
     *
     * @return A String representing the File Upload URL.
     */
    override def getFileUploadUrl: String = new SADataCenter().getFileUploadUrl
  }

  /**
   * This Environment class instance represents the Zoho CRM Developer environment in SA domain
   *
   * @return An instance of Environment
   */
  val DEVELOPER: Environment = new Environment {
    /**
     * This method is to get Zoho CRM Developer API URL.
     *
     * @return A String representing the Zoho CRM production API URL.
     */
    override def getUrl: String = "https://developer.zohoapis.sa"

    /**
     * This method is to get Zoho CRM Accounts URL.
     *
     * @return A String representing the accounts URL.
     */
    override def getAccountsUrl: String = new SADataCenter().getIamUrl

    /**
     * The method to get Zoho File Upload URL
     *
     * @return A String representing the File Upload URL.
     */
    override def getFileUploadUrl: String = new SADataCenter().getFileUploadUrl
  }
}