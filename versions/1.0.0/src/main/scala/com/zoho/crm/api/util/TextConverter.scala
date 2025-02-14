package com.zoho.crm.api.util

import com.zoho.crm.api.Initializer
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase
import org.apache.http.util.EntityUtils
import org.json.JSONObject

import java.lang.reflect.Modifier
//$Id$


class TextConverter(commonAPIHandler: CommonAPIHandler) extends Converter(commonAPIHandler) {
  @throws[Exception]
  override def formRequest(requestInstance: Any, pack: String, instanceNumber: Integer, memberDetail: JSONObject): Any = {
    // TODO Auto-generated method stub
    null
  }

  @throws[Exception]
  override def appendToRequest(requestBase: HttpEntityEnclosingRequestBase, requestObject: Any): Unit = {

    // TODO Auto-generated method stub
  }

  @throws[Exception]
  override def getWrappedResponse(response: Any, pack: String): Option[java.util.ArrayList[Any]] = {
    val responseEntity = response.asInstanceOf[HttpResponse].getEntity
    if (responseEntity != null) {
      var responseArray = new java.util.ArrayList[Any]()
      val responseObject = EntityUtils.toString(responseEntity)
      responseArray.add(getResponse(responseObject, pack))
      responseArray.add(responseObject)
      return Option(responseArray)
    }
    None
  }

  @throws[Exception]
  override def getResponse(response: Any, packageName: String): Any = {
    val classDetail = Initializer.jsonDetails.getJSONObject(packageName)
    val responseString = response.toString
    if (responseString == null || responseString == "null" || responseString.isEmpty || responseString.trim.isEmpty) return null
    var instance: Any = None
    val constructor = Class.forName(packageName).getDeclaredConstructors()(0)
    if (Modifier.isPrivate(constructor.getModifiers)) constructor.setAccessible(true)
    instance = constructor.newInstance()
    val classDetailKeys = classDetail.keys()
    while (classDetailKeys.hasNext) {
      val memberName = classDetailKeys.next()
      val keyDetail = classDetail.getJSONObject(memberName)
      val keyName = if (keyDetail.has(Constants.NAME)) keyDetail.getString(Constants.NAME)
      else None
      if (keyName != null) {
        val member = instance.getClass.getDeclaredField(memberName)
        member.setAccessible(true)
        member.set(instance, responseString)
      }
    }
    instance
  }
}
