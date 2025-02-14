package com.zoho.crm.api.dc

import com.zoho.crm.api.dc.DataCenter.Environment

class INDataCenter extends DataCenter {
  override def getIamUrl: String = "https://accounts.zoho.in/oauth/v2/token"

  override def getFileUploadUrl: String = "https://content.zohoapis.in"
}

object INDataCenter {
  /**
   * This Environment class instance represents the Zoho CRM Production environment in IN domain
   *
   * @return An instance of Environment
   */
  val PRODUCTION: Environment = new Environment {
    /**
     * This method is to get Zoho CRM Production API URL.
     *
     * @return A String representing the Zoho CRM production API URL.
     */
    override def getUrl: String = "https://www.zohoapis.in"

    /**
     * This method is to get Zoho CRM Accounts URL.
     *
     * @return A String representing the accounts URL.
     */
    override def getAccountsUrl: String = new INDataCenter().getIamUrl

    /**
     * The method to get Zoho File Upload URL
     *
     * @return A String representing the File Upload URL.
     */
    override def getFileUploadUrl: String = new INDataCenter().getFileUploadUrl
  }

  /**
   * This Environment class instance represents the Zoho CRM Sandbox environment in IN domain
   *
   * @return An instance of Environment
   */
  val SANDBOX: Environment = new Environment {
    /**
     * This method is to get Zoho CRM Sandbox API URL.
     *
     * @return A String representing the Zoho CRM production API URL.
     */
    override def getUrl: String = "https://sandbox.zohoapis.in"

    /**
     * This method is to get Zoho CRM Accounts URL.
     *
     * @return A String representing the accounts URL.
     */
    override def getAccountsUrl: String = new INDataCenter().getIamUrl

    /**
     * The method to get Zoho File Upload URL
     *
     * @return A String representing the File Upload URL.
     */
    override def getFileUploadUrl: String = new INDataCenter().getFileUploadUrl
  }

  /**
   * This Environment class instance represents the Zoho CRM Developer environment in IN domain
   *
   * @return An instance of Environment
   */
  val DEVELOPER: Environment = new Environment {
    /**
     * This method is to get Zoho CRM Developer API URL.
     *
     * @return A String representing the Zoho CRM production API URL.
     */
    override def getUrl: String = "https://developer.zohoapis.in"

    /**
     * This method is to get Zoho CRM Accounts URL.
     *
     * @return A String representing the accounts URL.
     */
    override def getAccountsUrl: String = new INDataCenter().getIamUrl

    /**
     * The method to get Zoho File Upload URL
     *
     * @return A String representing the File Upload URL.
     */
    override def getFileUploadUrl: String = new INDataCenter().getFileUploadUrl
  }
}

