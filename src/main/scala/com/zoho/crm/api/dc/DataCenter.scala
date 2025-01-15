package com.zoho.crm.api.dc

import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.Constants

/**
 * This object represents the Zoho CRM environment and accounts URL.
 */
object DataCenter {
  /**
   * This abstract class represents the Zoho CRM environment.
   */
  abstract class Environment {

    /**
     * This method is used to get Zoho CRM API URL.
     *
     * @return A String representing the Zoho CRM API URL.
     */
    def getUrl: String

    /**
     * This method is to get Zoho CRM Accounts URL.
     *
     * @return A String representing the accounts URL.
     */
    def getAccountsUrl: String

    /**
     * This method is to get Zoho CRM File Upload URL.
     *
     * @return A String representing the File Upload URL.
     */
    def getFileUploadUrl: String
  }

  @throws[SDKException]
  def get(config: String): Environment = {
    if (Constants.US_DATACENTER.exists(a => a.equals(config))) {
      if (config.contains(Constants.SANDBOX)) return USDataCenter.SANDBOX
      else if (config.contains(Constants.DEVELOPER)) return USDataCenter.DEVELOPER
      return USDataCenter.PRODUCTION
    }
    else if (Constants.JP_DATACENTER.exists(a => a.equals(config))) {
      if (config.contains(Constants.SANDBOX)) return JPDataCenter.SANDBOX
      else if (config.contains(Constants.DEVELOPER)) return JPDataCenter.DEVELOPER
      return JPDataCenter.PRODUCTION
    }
    else if (Constants.IN_DATACENTER.exists(a => a.equals(config))) {
      if (config.contains(Constants.SANDBOX)) return INDataCenter.SANDBOX
      else if (config.contains(Constants.DEVELOPER)) return INDataCenter.DEVELOPER
      return INDataCenter.PRODUCTION
    }
    else if (Constants.EU_DATACENTER.exists(a => a.equals(config))) {
      if (config.contains(Constants.SANDBOX)) return EUDataCenter.SANDBOX
      else if (config.contains(Constants.DEVELOPER)) return EUDataCenter.DEVELOPER
      return EUDataCenter.PRODUCTION
    }
    else if (Constants.CN_DATACENTER.exists(a => a.equals(config))) {
      if (config.contains(Constants.SANDBOX)) return CNDataCenter.SANDBOX
      else if (config.contains(Constants.DEVELOPER)) return CNDataCenter.DEVELOPER
      return CNDataCenter.PRODUCTION
    }
    else if (Constants.AU_DATACENTER.exists(a => a.equals(config))) {
      if (config.contains(Constants.SANDBOX)) return AUDataCenter.SANDBOX
      else if (config.contains(Constants.DEVELOPER)) return AUDataCenter.DEVELOPER
      return AUDataCenter.PRODUCTION
    }
    else if (Constants.CA_DATACENTER.exists(a => a.equals(config))) {
      if (config.contains(Constants.SANDBOX)) return CADataCenter.SANDBOX
      else if (config.contains(Constants.DEVELOPER)) return CADataCenter.DEVELOPER
      return CADataCenter.PRODUCTION
    }
    else if (Constants.SA_DATACENTER.exists(a => a.equals(config))) {
      if (config.contains(Constants.SANDBOX)) return SADataCenter.SANDBOX
      else if (config.contains(Constants.DEVELOPER)) return SADataCenter.DEVELOPER
      return SADataCenter.PRODUCTION
    }
    null
  }
}

/**
 * This abstract class represents the Zoho CRM environment and accounts URL.
 */
abstract class DataCenter {
  /**
   * This method is to get accounts URL.
   * URL to be used when calling an OAuth accounts.
   *
   * @return A String representing the accounts URL.
   */
  def getIamUrl: String

  /**
   * This method is to get File Upload URL.
   *
   * @return A String representing the accounts URL.
   */
  def getFileUploadUrl: String
}
