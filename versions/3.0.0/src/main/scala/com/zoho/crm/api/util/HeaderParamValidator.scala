package com.zoho.crm.api.util

import com.zoho.crm.api.Initializer
import org.json.JSONArray
import org.json.JSONObject
import java.util

class HeaderParamValidator[T] {
  private[util] val jsonDetails = Initializer.jsonDetails

  @throws[Exception]
  def validate(name: String, className: String, value: T): String = {
    val className1 = getClassName(className)
    if (jsonDetails.has(className1)) {
      val classObject = jsonDetails.getJSONObject(className1)
      classObject.keySet.forEach(key => {
        val memberDetail = classObject.getJSONObject(key)
        val keyName = memberDetail.getString(Constants.NAME)
        if (name.equalsIgnoreCase(keyName)) {
          if (memberDetail.has(Constants.STRUCTURE_NAME)) {
            if (value.isInstanceOf[util.Collection[_]]) {
              val jsonArray = new JSONArray
              val requestObjects = value.asInstanceOf[util.ArrayList[_]]
              if (!requestObjects.isEmpty) {
                requestObjects.forEach(requestObject => {
                  jsonArray.put(new JSONConverter(new CommonAPIHandler()).formRequest(requestObject, memberDetail.getString(Constants.STRUCTURE_NAME), null, null))
                })
              }
              return jsonArray.toString
            }
            return new JSONConverter(new CommonAPIHandler()).formRequest(value, memberDetail.getString(Constants.STRUCTURE_NAME), null, null).toString
          }
          else if(memberDetail.has(Constants.TYPE) && memberDetail.getString(Constants.TYPE).equalsIgnoreCase(Constants.CHOICE_NAMESPACE))
          {
            new JSONConverter(new CommonAPIHandler()).checkChoiceValue(Constants.CHOICE_NAMESPACE, memberDetail, value.asInstanceOf[Any]);
          }
          return parseData(value).toString
        }
      })
    }
    var valueClassName = value.getClass.getName
    if (value.isInstanceOf[util.Map[_, _]] || value.isInstanceOf[util.Collection[_]]){
      valueClassName = Constants.OBJECT_NAMESPACE
    }
    DataTypeConverter.postConvert(value, valueClassName).toString
  }

  @throws[Exception]
  private def parseData(value: Any): Any = {
    value match {
      case _: util.Map[_, _] =>
        val jsonObject = new JSONObject
        val requestObject = value.asInstanceOf[util.HashMap[_, _]]
        if (!requestObject.isEmpty) {
          requestObject.forEach((key, requestData) => {
            jsonObject.put(key.toString, parseData(requestData))
          })
        }
        jsonObject
      case _: util.Collection[_] =>
        val jsonArray = new JSONArray
        val requestObjects = value.asInstanceOf[util.ArrayList[_]]
        if (!requestObjects.isEmpty) {
          requestObjects.forEach(requestObject => {
            jsonArray.put(parseData(requestObject))
          })
        }
        jsonArray
      case value1: Choice[_] => value1.getValue
      case _ => DataTypeConverter.postConvert(value, value.getClass.getName).toString
    }
  }

  private def getClassName(canonicalName: String): String = {
    if (canonicalName.contains(".")) return canonicalName.substring(0, canonicalName.lastIndexOf(".")).toLowerCase + canonicalName.substring(canonicalName.lastIndexOf("."))
    canonicalName
  }
}
