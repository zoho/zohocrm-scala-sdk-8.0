package com.zoho.api.authenticator

import com.zoho.crm.api.util.APIHTTPConnector
import com.zoho.crm.api.exception.SDKException

/**
 * This trait verifies and sets token to APIHTTPConnector instance.
 */
trait Token {
  @throws[SDKException]
  def authenticate(urlConnection: APIHTTPConnector): Unit
  @throws[SDKException]
  def revoke(id: String): Boolean
  @throws[SDKException]
  def remove(): Unit
  @throws[SDKException]
  def generateToken(): Unit
  def getId: String
}