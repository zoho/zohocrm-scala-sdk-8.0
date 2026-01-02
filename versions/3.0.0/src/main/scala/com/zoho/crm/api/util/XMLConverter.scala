package com.zoho.crm.api.util

import org.apache.hc.core5.http.ClassicHttpRequest
import org.json.JSONObject


/**
 * This class processes the API response object to the POJO object and POJO object to an XML object.
 */
class XMLConverter(commonAPIHandler: CommonAPIHandler) extends Converter(commonAPIHandler) {
  @throws[Exception]
  def appendToRequest(requestBase: ClassicHttpRequest, requestObject: Any): Unit = {
  }

  @throws[Exception]
  def getWrappedResponse(response: Any, pack: String): Option[java.util.ArrayList[Any]] = None

  def getResponse(response: Any, pack: String): Any = None

  /**
   * This abstract method is to construct the API request.
   *
   * @param requestObject  An Object containing the POJO class instance.
   * @param pack           A String containing the expected method return type.
   * @param instanceNumber An Integer containing the POJO class instance list number.
   * @return An Object representing the API request body object.
   * @throws Exception Exception
   */
  override def formRequest(requestObject: Any, pack: String, instanceNumber: Integer, memberDetails: JSONObject): Any = None
}