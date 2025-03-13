package com.zoho.crm.api

import com.zoho.api.logger.SDKLogger
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.{Constants, DataTypeConverter, HeaderParamValidator}

import java.util.logging.{Level, Logger}
import scala.collection.mutable

/**
 * This class represents the HTTP header name and value.
 */
class HeaderMap {
  private val headerHashMap: mutable.HashMap[String, String] = mutable.HashMap()
  private val LOGGER: Logger = Logger.getLogger(classOf[SDKLogger].getName)

  /**
   * This is a getter method to get header map.
   *
   * @return A HashMap&lt;String, String&gt; representing the API request headers.
   */
  def getHeaderMap: mutable.HashMap[String, String] = headerHashMap

  /**
   * This method is to add header name and value.
   *
   * @param header A Header&lt;T&gt; class instance.
   * @param value  A T containing the header value.
   * @throws SDKException Exception
   */
  @throws[SDKException]
  def add[T](header: Header[T], value: T): Unit = {
    if (header == null) throw new SDKException(Constants.HEADER_NULL_ERROR, Constants.HEADER_INSTANCE_NULL_ERROR)
    val headerName = header.getName
    if (headerName == null) throw new SDKException(Constants.HEADER_NAME_NULL_ERROR, Constants.HEADER_NAME_NULL_ERROR_MESSAGE)
    if (value == null) throw new SDKException(Constants.HEADER_NULL_ERROR, headerName + Constants.NULL_VALUE_ERROR_MESSAGE)
    try {
      val headerClassName = header.getClassName
      var parsedHeaderValue: String = null
      if (headerClassName != null) {
        val headerParamValidator = new HeaderParamValidator[T]
        parsedHeaderValue = headerParamValidator.validate(headerName, headerClassName, value)
      }
      else {
        try parsedHeaderValue = DataTypeConverter.postConvert(value, value.getClass.getName).toString
        catch {
          case _: Exception =>
            parsedHeaderValue = value.toString
        }
      }
      if (headerHashMap.keySet.contains(headerName) && headerHashMap(headerName).nonEmpty) {
        var existingHeaderValue: String = headerHashMap(headerName)
        existingHeaderValue = existingHeaderValue + "," + parsedHeaderValue
        headerHashMap(headerName) = existingHeaderValue
      }
      else headerHashMap(headerName) = parsedHeaderValue
    } catch {
      case e: SDKException =>
        LOGGER.log(Level.SEVERE, Constants.HEADER_EXCEPTION, e)
        throw e
      case e: Exception =>
        val exception = new SDKException(e)
        LOGGER.log(Level.SEVERE, Constants.HEADER_EXCEPTION, exception)
        throw exception
    }
  }
}