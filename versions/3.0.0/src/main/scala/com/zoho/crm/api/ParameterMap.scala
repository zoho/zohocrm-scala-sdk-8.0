package com.zoho.crm.api

import com.zoho.api.logger.SDKLogger
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.util.{Constants, DataTypeConverter, HeaderParamValidator}

import java.util.logging.{Level, Logger}
import scala.collection.mutable

/**
 * This class represents the HTTP parameter name and value.
 */
class ParameterMap {
  private val parameterHashMap: mutable.HashMap[String, String] = mutable.HashMap()
  private val LOGGER: Logger = Logger.getLogger(classOf[SDKLogger].getName)

  /**
   * This is a getter method to get parameter map.
   *
   * @return A HashMap&lt;String, String&gt; representing the API request parameters.
   */
  def getParameterMap: mutable.HashMap[String, String] = parameterHashMap

  /**
   * This method to add parameter name and value.
   *
   * @param param A Param&lt;T&gt; class instance.
   * @param value A T containing the parameter value.
   * @throws SDKException Exception
   */
  @throws[SDKException]
  def add[T](param: Param[T], value: T): Unit = {
    if (param == null) throw new SDKException(Constants.PARAMETER_NULL_ERROR, Constants.PARAM_INSTANCE_NULL_ERROR)
    val paramName = param.getName
    if (paramName == null) throw new SDKException(Constants.PARAM_NAME_NULL_ERROR, Constants.PARAM_NAME_NULL_ERROR_MESSAGE)
    if (value == null) throw new SDKException(Constants.PARAMETER_NULL_ERROR, paramName + Constants.NULL_VALUE_ERROR_MESSAGE)
    try {
      val paramClassName = param.getClassName
      var parsedParamValue: String = null
      if (paramClassName != null) {
        val headerParamValidator = new HeaderParamValidator[T]
        parsedParamValue = headerParamValidator.validate(paramName, paramClassName, value)
      }
      else {
        try parsedParamValue = DataTypeConverter.postConvert(value, value.getClass.getName).toString
        catch {
          case _: Exception =>
            parsedParamValue = value.toString
        }
      }
      if (parameterHashMap.keySet.contains(paramName) && parameterHashMap(paramName).nonEmpty) {
        var existingParamValue = parameterHashMap(paramName)
        existingParamValue = existingParamValue + "," + parsedParamValue
        parameterHashMap(paramName) = existingParamValue
      }
      else parameterHashMap(paramName) = parsedParamValue
    } catch {
      case e: SDKException =>
        LOGGER.log(Level.SEVERE, Constants.PARAM_EXCEPTION, e)
        throw e
      case e: Exception =>
        val exception = new SDKException(e)
        LOGGER.log(Level.SEVERE, Constants.PARAM_EXCEPTION, exception)
        throw exception
    }
  }
}