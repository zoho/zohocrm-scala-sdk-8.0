package com.zoho.crm.api.dc

import com.zoho.crm.api.dc.DataCenter.Environment

/**
 * This class represents the properties of Zoho CRM in CA Domain.
 */
class CADataCenter extends DataCenter {
  override def getIamUrl: String = "https://accounts.zohocloud.ca/oauth/v2/token"
  override def getFileUploadUrl: String = "https://upload.zohocloud.ca"
}

object CADataCenter {

  /**
   * This Environment class instance represents the Zoho CRM Production environment in CA domain
   *
   * @return An instance of Environment
   */
  val PRODUCTION: Environment = new Environment {
    /**
     * This method is to get Zoho CRM production API URL.
     *
     * @return A String representing the Zoho CRM production API URL.
     */
    override def getUrl = "https://www.zohoapis.ca"

    /**
     * This method is to get Zoho CRM Accounts URL.
     *
     * @return A String representing the accounts URL.
     */
    override def getAccountsUrl: String = new CADataCenter().getIamUrl

    /**
     * The method to get Zoho File Upload URL
     *
     * @return A String representing the File Upload URL.
     */
    override def getFileUploadUrl: String = new CADataCenter().getFileUploadUrl
  }

  /**
   * This Environment class instance represents the Zoho CRM Sandbox environment in CA domain
   *
   * @return An instance of Environment
   */
  val SANDBOX: Environment = new Environment {
    /**
     * This method is to get Zoho CRM production API URL.
     *
     * @return A String representing the Zoho CRM production API URL.
     */
    override def getUrl: String = "https://sandbox.zohoapis.ca"

    /**
     * This method is to get Zoho CRM Accounts URL.
     *
     * @return A String representing the accounts URL.
     */
    override def getAccountsUrl: String = new CADataCenter().getIamUrl

    /**
     * The method to get Zoho File Upload URL
     *
     * @return A String representing the File Upload URL.
     */
    override def getFileUploadUrl: String = new CADataCenter().getFileUploadUrl
  }

  /**
   * This Environment class instance represents the Zoho CRM Developer environment in CA domain
   *
   * @return An instance of Environment
   */
  val DEVELOPER: Environment = new Environment {
    /**
     * This method is to get Zoho CRM production API URL.
     *
     * @return A String representing the Zoho CRM production API URL.
     */
    override def getUrl: String = "https://developer.zohoapis.ca"

    /**
     * This method is to get Zoho CRM Accounts URL.
     *
     * @return A String representing the accounts URL.
     */
    override def getAccountsUrl: String = new CADataCenter().getIamUrl

    /**
     * The method to get Zoho File Upload URL
     *
     * @return A String representing the File Upload URL.
     */
    override def getFileUploadUrl: String = new CADataCenter().getFileUploadUrl
  }
}

