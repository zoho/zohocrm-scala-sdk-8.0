package com.zoho.crm.api.util

import com.zoho.crm.api.Initializer
import com.zoho.crm.api.exception.SDKException
import org.apache.commons.io.output.ByteArrayOutputStream
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.content.ByteArrayBody
import org.apache.http.entity.mime.{HttpMultipartMode, MultipartEntityBuilder}
import org.json.{JSONArray, JSONObject}

import java.io.IOException
import java.lang.reflect.InvocationTargetException
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * This class is to process the upload file and stream.
 *
 * @param commonAPIHandler A CommonAPIHandler class instance.
 */
class FormDataConverter(commonAPIHandler: CommonAPIHandler) extends Converter(commonAPIHandler) {
  private val uniqueValuesHashMap: mutable.HashMap[String, ArrayBuffer[Any]] = mutable.HashMap()

  /**
   * This abstract method is to construct the API request.
   *
   * @param requestInstance  An Object containing the POJO class instance.
   * @param pack           A String containing the expected method return type.
   * @param instanceNumber An Integer containing the POJO class instance list number.
   * @return A Object representing the API request body object.
   * @throws Exception Exception
   */
  @throws[NoSuchFieldException]
  @throws[SecurityException]
  @throws[IllegalArgumentException]
  @throws[IllegalAccessException]
  @throws[SDKException]
  def formRequest(requestInstance: Any, pack: String, instanceNumber: Integer, classMemberDetail: JSONObject): Any = {
    val classDetail = Initializer.jsonDetails.get(pack).asInstanceOf[JSONObject]
    val request = mutable.HashMap[String, Any]()
    classDetail.keySet.forEach(memberName => {
      var modification: Any = None
      val memberDetail = classDetail.get(memberName).asInstanceOf[JSONObject]
      // check and neglect read_only
      if ((!memberDetail.has(Constants.READ_ONLY) || !memberDetail.getBoolean(Constants.READ_ONLY)) && memberDetail.has(Constants.NAME)) {
        try {
          val method = requestInstance.getClass.getMethod(Constants.IS_KEY_MODIFIED, classOf[String])
          modification = method.invoke(requestInstance, memberDetail.getString(Constants.NAME))
        } catch {
          case ex: InvocationTargetException =>
            throw new SDKException(Constants.EXCEPTION_IS_KEY_MODIFIED, ex)
          case e: NoSuchMethodException =>
            throw new SDKException(Constants.EXCEPTION_IS_KEY_MODIFIED, e)
        }
        if ((modification == None || (modification == 0)) && memberDetail.has(Constants.REQUIRED) && memberDetail.getBoolean(Constants.REQUIRED)) throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR + memberName)
        val field = requestInstance.getClass.getDeclaredField(memberName)
        field.setAccessible(true)
        var fieldValue: Any = field.get(requestInstance)
        fieldValue match {
          case value: Option[_] =>
            fieldValue = value.getOrElse(None)
          case _ =>
        }
        if (modification != None && (modification != 0) && fieldValue != None && fieldValue != null && this.valueChecker(requestInstance.getClass.getSimpleName, memberName, memberDetail, fieldValue, uniqueValuesHashMap, instanceNumber)) {
          val keyName = memberDetail.get(Constants.NAME).asInstanceOf[String]
          val `type` = memberDetail.get(Constants.TYPE).asInstanceOf[String]
          if (`type`.equalsIgnoreCase(Constants.LIST_NAMESPACE)) request(keyName) = setJSONArray(fieldValue, memberDetail)
          else if (`type`.equalsIgnoreCase(Constants.MAP_NAMESPACE)) request(keyName) = setJSONObject(fieldValue, memberDetail)
          else if (memberDetail.has(Constants.STRUCTURE_NAME)) request(keyName) = formRequest(fieldValue, memberDetail.getString(Constants.STRUCTURE_NAME), 1, memberDetail)
          else request(keyName) = fieldValue
        }
      }
    })
    request
  }

  override def appendToRequest(requestBase: HttpEntityEnclosingRequestBase, requestObject: Any): Unit = {
    val multipartEntity = MultipartEntityBuilder.create
    multipartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
    if (requestObject.isInstanceOf[mutable.HashMap[_, _]]) {
      this.addFileBody(requestObject, multipartEntity)
    }
    requestBase.setEntity(multipartEntity.build)
  }

  @throws[IOException]
  private def addFileBody(requestObject: Any, multipartEntity: MultipartEntityBuilder): Unit = {
    val requestObjectHashMap = requestObject.asInstanceOf[mutable.HashMap[Any, Any]]
    requestObjectHashMap.foreachEntry((key, requestData) => {
      requestData match {
        case keysDetail: JSONArray =>
          for (keyIndex <- 0 until keysDetail.length) {
            val fileObject = keysDetail.get(keyIndex)
            fileObject match {
              case streamWrapper: StreamWrapper =>
                val buffer = new Array[Byte](8192)
                val output = new ByteArrayOutputStream
                var bytesRead = 0
                while ( {
                  bytesRead = streamWrapper.getStream.get.read(buffer)
                  bytesRead != -1
                }) output.write(buffer, 0, bytesRead)
                multipartEntity.addPart(key.toString, new ByteArrayBody(output.toByteArray, streamWrapper.getName.get))
              case _ =>
            }
          }
        case streamWrapper: StreamWrapper =>
            val buffer = new Array[Byte](8192)
            val output = new ByteArrayOutputStream
            var bytesRead = 0
            while ( {
              bytesRead = streamWrapper.getStream.get.read(buffer)
              bytesRead != -1
            }) output.write(buffer, 0, bytesRead)
            multipartEntity.addPart(key.toString, new ByteArrayBody(output.toByteArray, streamWrapper.getName.get))
        case _ => requestData match {
            case requestData1: mutable.HashMap[_, _] =>
              val json = new JSONObject(requestData1.asInstanceOf[JSONObject])
              multipartEntity.addTextBody(key.toString, json.toString, ContentType.APPLICATION_JSON)
            case requestData2 : Any =>
              multipartEntity.addTextBody(key.toString, requestData2.toString, ContentType.APPLICATION_JSON)
            case _ =>
        }
      }
    })
  }

  private def setJSONObject(fieldValue: Any, memberDetail: JSONObject) = {
    val jsonObject: JSONObject = new JSONObject
    val requestObject = fieldValue.asInstanceOf[mutable.HashMap[String, _]]
    if (memberDetail == null || (memberDetail != null && !memberDetail.has(Constants.KEYS))) {
      requestObject.foreach(entry => {
        jsonObject.put(entry._1, redirectorForObjectToJSON(entry._2))
      })
    }
    else {
      if (memberDetail.has(Constants.KEYS)) {
        val keysDetail = memberDetail.getJSONArray(Constants.KEYS)
        for (keyIndex <- 0 until keysDetail.length) {
          val keyDetail = keysDetail.getJSONObject(keyIndex)
          val keyName = keyDetail.getString(Constants.NAME)
          var keyValue: Any = None
          if (requestObject.contains(keyName) && requestObject.get(keyName) != null) {
            if (keyDetail.has(Constants.STRUCTURE_NAME)) {
              keyValue = formRequest(requestObject.get(keyName), keyDetail.getString(Constants.STRUCTURE_NAME), 1, memberDetail)
              jsonObject.put(keyName, keyValue)
            }
            else {
              keyValue = requestObject.get(keyName)
              jsonObject.put(keyName, redirectorForObjectToJSON(keyValue))
            }
          }
        }
      }
    }
    jsonObject
  }

  private def setJSONArray(fieldValue: Any, memberDetail: JSONObject) = {
    val jsonArray = new JSONArray
    val requestObjects = fieldValue.asInstanceOf[ArrayBuffer[_]]
    if (memberDetail == null) {
      requestObjects.foreach(request => {
        jsonArray.put(redirectorForObjectToJSON(request))
      })
    }
    else if (memberDetail.has(Constants.STRUCTURE_NAME)) {
      var instanceCount = 0
      val pack = memberDetail.getString(Constants.STRUCTURE_NAME)
      requestObjects.foreach(request => {
        jsonArray.put(formRequest(request, pack, instanceCount, memberDetail))
        instanceCount += 1
      })
    }
    else {
      requestObjects.foreach(request => {
        jsonArray.put(redirectorForObjectToJSON(request))
      })
    }
    jsonArray
  }

  private def redirectorForObjectToJSON(request: Any): Any = request match {
    case _: ArrayBuffer[_] => setJSONArray(request, null)
    case _: mutable.HashMap[_, _] => setJSONObject(request, null)
    case _ => request
  }

  override def getWrappedResponse(response: Any, pack: String): Option[java.util.ArrayList[Any]] = None

  override def getResponse(response: Any, pack: String): Any = null
}
