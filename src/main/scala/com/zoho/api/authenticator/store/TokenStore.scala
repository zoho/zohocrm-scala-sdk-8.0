package com.zoho.api.authenticator.store

import com.zoho.api.authenticator.Token
import com.zoho.crm.api.exception.SDKException

import scala.collection.mutable.ArrayBuffer

/**
 * This trait stores the user token details.
 */
trait TokenStore {
  @throws[SDKException]
  def findToken(token: Token): Token
  @throws[SDKException]
  def findTokenById(id: String): Token
  @throws[SDKException]
  def saveToken(token: Token): Unit
  @throws[SDKException]
  def deleteToken(id: String): Unit
  @throws[SDKException]
  def getTokens: ArrayBuffer[Token]
  @throws[SDKException]
  def deleteTokens(): Unit
}
