package com.zoho.crm.api.util

import com.zoho.crm.api.Initializer
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.record.Record
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase
import org.apache.http.entity.StringEntity
import org.apache.http.util.EntityUtils
import org.json.{JSONArray, JSONException, JSONObject}

import java.io.File
import java.lang.reflect.{Constructor, InvocationTargetException, Modifier}
import java.nio.charset.StandardCharsets
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

class JSONConverter(commonAPIHandler: CommonAPIHandler) extends Converter(commonAPIHandler) {

  private val uniqueValuesHashMap: mutable.HashMap[String, ArrayBuffer[Any]] = mutable.HashMap()

  override def appendToRequest(requestBase: HttpEntityEnclosingRequestBase, requestObject: Any): Unit = {
    requestBase.setEntity(new StringEntity(requestObject.toString, StandardCharsets.UTF_8))
  }

  @throws[NoSuchFieldException]
  @throws[SecurityException]
  @throws[IllegalArgumentException]
  @throws[IllegalAccessException]
  override def formRequest(requestInstance: Any, pack: String, instanceNumber: Integer, memberDetail: JSONObject = null): Any = {
    var classDetail = Initializer.jsonDetails.get(pack).asInstanceOf[JSONObject]
    if (classDetail.has(Constants.INTERFACE) && classDetail.getBoolean(Constants.INTERFACE)) {
      val classes = classDetail.getJSONArray(Constants.CLASSES)
      val requestObjectClassName = requestInstance.getClass.getCanonicalName
      breakable {
        classes.forEach(className => {
          if (className.asInstanceOf[String].equalsIgnoreCase(requestObjectClassName)) {
            classDetail = Initializer.jsonDetails.get(requestObjectClassName).asInstanceOf[JSONObject]
            break
          }
        })
      }
    }
    if (requestInstance.isInstanceOf[Record]) {
      val moduleAPIName = this.commonAPIHandler.getModuleAPIName
      val returnJSON = isRecordRequest(requestInstance, classDetail, instanceNumber: Int, memberDetail)
      this.commonAPIHandler.setModuleAPIName(moduleAPIName)
      returnJSON
    }
    else isNotRecordRequest(requestInstance, classDetail, instanceNumber, memberDetail)
  }

  @throws[Exception]
  private def isNotRecordRequest(requestInstance: Any, classDetail: JSONObject, instanceNumber: Int, classMemberDetail: JSONObject): JSONObject = {
    var lookUp = false
    var skipMandatory = false
    var classMemberName: String = null
    if (classMemberDetail != null) {
      lookUp = classMemberDetail.optBoolean(Constants.LOOKUP)
      skipMandatory = classMemberDetail.optBoolean(Constants.SKIP_MANDATORY)
      classMemberName = this.buildName(classMemberDetail.getString(Constants.NAME))
    }
    val requestJSON = new JSONObject
    val classDetailKeys = classDetail.keys()
    val requiredKeys: mutable.HashMap[String, Boolean] = mutable.HashMap()
    val primaryKeys: mutable.HashMap[String, Boolean] = mutable.HashMap()
    val requiredInUpdateKeys: mutable.HashMap[String, Boolean] = mutable.HashMap()
    while (classDetailKeys.hasNext) {
      val memberName = classDetailKeys.next()
      var modification: Any = None
      val memberDetail = classDetail.get(memberName).asInstanceOf[JSONObject]
      if ((!memberDetail.has(Constants.READ_ONLY) || !memberDetail.getBoolean(Constants.READ_ONLY)) && memberDetail.has(Constants.NAME)) {
        val keyName: String = memberDetail.getString(Constants.NAME)
        try {
          val isKeyModified = requestInstance.getClass.getMethod(Constants.IS_KEY_MODIFIED, classOf[String])
          modification = isKeyModified.invoke(requestInstance, keyName)
        }
        catch {
          case x: InvocationTargetException =>
            throw new SDKException(Constants.EXCEPTION_IS_KEY_MODIFIED, x)
          case x: NoSuchMethodException =>
            throw new SDKException(Constants.EXCEPTION_IS_KEY_MODIFIED, x)
        }
        if (memberDetail.has(Constants.REQUIRED) && memberDetail.getBoolean(Constants.REQUIRED)) requiredKeys(keyName) = true
        if (memberDetail.has(Constants.REQUIRED_IN_UPDATE) && memberDetail.getBoolean(Constants.REQUIRED_IN_UPDATE)) requiredInUpdateKeys(keyName) = true
        if (memberDetail.has(Constants.PRIMARY) && memberDetail.getBoolean(Constants.PRIMARY) && (!memberDetail.has(Constants.REQUIRED_IN_UPDATE) || memberDetail.getBoolean(Constants.REQUIRED_IN_UPDATE))) primaryKeys(keyName) = true
        var fieldValue: Any = None
        if (modification != None && modification != 0) {
          val field = requestInstance.getClass.getDeclaredField(memberName)
          field.setAccessible(true)
          fieldValue = field.get(requestInstance)
          fieldValue match {
            case value: Option[_] => fieldValue = value.getOrElse(None)
            case _ =>
          }
          if(fieldValue != null && fieldValue != None) {
            if (this.valueChecker(requestInstance.getClass.getSimpleName, memberName, memberDetail, fieldValue, uniqueValuesHashMap, instanceNumber)) {
              if (fieldValue != None && fieldValue != null) {
                requiredKeys.remove(keyName)
                primaryKeys.remove(keyName)
                requiredInUpdateKeys.remove(keyName)
              }
              requestJSON.put(keyName, setData(memberDetail, fieldValue))
            }
          }
        }
      }
    }
    if (skipMandatory || checkException(classMemberName, requestInstance, instanceNumber, lookUp, requiredKeys, primaryKeys, requiredInUpdateKeys)) {
      return requestJSON
    }
    requestJSON
  }

  @throws[SDKException]
  private def checkException(memberName: String, requestInstance: Any, instanceNumber: Integer, lookUp: Boolean, requiredKeys: mutable.HashMap[String, Boolean], primaryKeys: mutable.HashMap[String, Boolean], requiredInUpdateKeys: mutable.HashMap[String, Boolean] = mutable.HashMap()) = {
    if (requiredInUpdateKeys.nonEmpty && this.commonAPIHandler.getCategoryMethod.equals(Constants.REQUEST_CATEGORY_UPDATE)) {
      val error = new JSONObject
      error.put(Constants.FIELD, memberName)
      error.put(Constants.TYPE, requestInstance.getClass.getCanonicalName)
      error.put(Constants.KEYS, requiredInUpdateKeys.keySet.toString)
      error.put(Constants.INSTANCE_NUMBER, instanceNumber)
      throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR, error)
    }
    if (this.commonAPIHandler.isMandatoryChecker) {
      if (this.commonAPIHandler.getCategoryMethod.equalsIgnoreCase(Constants.REQUEST_CATEGORY_CREATE)) {
        if (lookUp) {
          if (primaryKeys.nonEmpty) {
            val error = new JSONObject
            error.put(Constants.FIELD, memberName)
            error.put(Constants.TYPE, requestInstance.getClass.getCanonicalName)
            error.put(Constants.KEYS, primaryKeys.keySet.toString)
            error.put(Constants.INSTANCE_NUMBER, instanceNumber)
            throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.PRIMARY_KEY_ERROR, error)
          }
        }
        else if (requiredKeys.nonEmpty) {
          val error = new JSONObject
          error.put(Constants.FIELD, memberName)
          error.put(Constants.TYPE, requestInstance.getClass.getCanonicalName)
          error.put(Constants.KEYS, requiredKeys.keySet.toString)
          error.put(Constants.INSTANCE_NUMBER, instanceNumber)
          throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.MANDATORY_KEY_ERROR, error)
        }
      }
      if (this.commonAPIHandler.getCategoryMethod.equalsIgnoreCase(Constants.REQUEST_CATEGORY_UPDATE) && primaryKeys.nonEmpty) {
        val error = new JSONObject
        error.put(Constants.FIELD, memberName)
        error.put(Constants.TYPE, requestInstance.getClass.getCanonicalName)
        error.put(Constants.KEYS, primaryKeys.keySet.toString)
        error.put(Constants.INSTANCE_NUMBER, instanceNumber)
        throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.PRIMARY_KEY_ERROR, error)
      }
    }
    else if (lookUp && this.commonAPIHandler.getCategoryMethod.equalsIgnoreCase(Constants.REQUEST_CATEGORY_UPDATE)) if (primaryKeys.nonEmpty) {
      val error = new JSONObject
      error.put(Constants.FIELD, memberName)
      error.put(Constants.TYPE, requestInstance.getClass.getCanonicalName)
      error.put(Constants.KEYS, primaryKeys.keySet.toString)
      error.put(Constants.INSTANCE_NUMBER, instanceNumber)
      throw new SDKException(Constants.MANDATORY_VALUE_ERROR, Constants.PRIMARY_KEY_ERROR, error)
    }
    true
  }

  @throws[JSONException]
  @throws[Exception]
  private def isRecordRequest(recordInstance: Any, classDetail1: JSONObject, instanceNumber: Integer = null, memberDetail: JSONObject): Any = {
    var lookUp = false
    var skipMandatory = false
    var classMemberName: String = null
    var classDetail = classDetail1
    if (memberDetail != null) {
      lookUp = memberDetail.optBoolean(Constants.LOOKUP)
      skipMandatory = memberDetail.optBoolean(Constants.SKIP_MANDATORY)
      classMemberName = this.buildName(memberDetail.getString(Constants.NAME))
    }
    val requestJSON = new JSONObject
    var moduleDetail = new JSONObject
    val moduleAPIName = this.commonAPIHandler.getModuleAPIName
    if (moduleAPIName != null) { // entry
      this.commonAPIHandler.setModuleAPIName(null)
      moduleDetail = getModuleDetailFromUserSpecJSON(moduleAPIName)
    }
    else { // inner case
      moduleDetail = classDetail
      classDetail = Initializer.jsonDetails.getJSONObject(Constants.RECORD_NAMESPACE)
    }
    // after above steps, ClassDetail must always contain record structure detail,module detail could be any,entry case pack detail is record
    var cl = recordInstance.getClass
    val scl = cl.getSuperclass
    if (scl.getCanonicalName == Constants.RECORD_NAMESPACE) cl = scl
    val keyValueField = cl.getDeclaredField(Constants.KEY_VALUES)
    keyValueField.setAccessible(true)
    val keyModifiedField = cl.getDeclaredField(Constants.KEY_MODIFIED)
    keyModifiedField.setAccessible(true)
    val keyValues = keyValueField.get(recordInstance).asInstanceOf[mutable.HashMap[String, Any]]
    val keyModified = keyModifiedField.get(recordInstance).asInstanceOf[mutable.HashMap[String, Int]]
    val requiredKeys: mutable.HashMap[String, Boolean] = mutable.HashMap()
    val primaryKeys: mutable.HashMap[String, Boolean] = mutable.HashMap()
    if (!skipMandatory) {
      moduleDetail.keySet().forEach(keyName => {
        val keyDetail = moduleDetail.optJSONObject(keyName)
        if (keyDetail != null && keyDetail.has(Constants.NAME)) {
          val name = keyDetail.getString(Constants.NAME)
          if (keyDetail.has(Constants.REQUIRED) && keyDetail.getBoolean(Constants.REQUIRED)) requiredKeys(name) = true
          if (keyDetail.has(Constants.PRIMARY) && keyDetail.getBoolean(Constants.PRIMARY)) primaryKeys(name) = true
        }

      })
      classDetail.keySet().forEach(keyName => {
        val keyDetail = classDetail.getJSONObject(keyName)
        val name = keyDetail.getString(Constants.NAME)
        if (keyDetail.has(Constants.REQUIRED) && keyDetail.getBoolean(Constants.REQUIRED)) requiredKeys(name) = true
        if (keyDetail.has(Constants.PRIMARY) && keyDetail.getBoolean(Constants.PRIMARY)) primaryKeys(name) = true
      })
    }

    for (keyName <- keyModified.keySet) {
      if (keyModified(keyName) == 1) {
        var keyDetail = new JSONObject
        var keyValue: Any = None
        keyValue = if (keyValues.contains(keyName)) {
          if (keyValues(keyName) != None && keyValues(keyName) != null) {
            keyValue = keyValues(keyName)
            if (keyValue.isInstanceOf[Option[_]]) keyValue.asInstanceOf[Some[_]].getOrElse(None)
            else keyValue
          }
        }
        var jsonValue: Any = null
        val memberName = buildName(keyName)
        var customHandling = false
        if (moduleDetail.length > 0 && (moduleDetail.has(keyName) || moduleDetail.has(memberName))) {
          if (moduleDetail.has(keyName)) keyDetail = moduleDetail.optJSONObject(keyName) // in-case of user spec json
          else keyDetail = moduleDetail.optJSONObject(memberName) // json details
        }
        else if (classDetail.has(memberName)) {
          keyDetail = classDetail.getJSONObject(memberName)
        }
        else {
          customHandling = true
        }
        if (keyValue != null) {
          if (keyDetail != null && keyDetail.length > 0) {
            if ((!memberDetail.has(Constants.READ_ONLY) || !memberDetail.getBoolean(Constants.READ_ONLY)) && memberDetail.has(Constants.NAME)) {
              if (this.valueChecker(cl.getSimpleName, memberName, keyDetail, keyValue, uniqueValuesHashMap, instanceNumber)) {
                jsonValue = setData(keyDetail, keyValue)
              }
            }
          }
          else {
            if (keyDetail == null || keyDetail.length == 0) {
              keyDetail = new JSONObject
              customHandling = true
            }
            if (customHandling && !keyValue.isInstanceOf[ArrayBuffer[_]] && !keyValue.isInstanceOf[mutable.HashMap[_, _]] && !keyValue.isInstanceOf[Choice[_]]) {
              if (Constants.PRIMITIVE_TYPES.contains(keyValue.getClass.getSimpleName)) {
                keyDetail.put(Constants.TYPE, keyValue.getClass.getCanonicalName)
                jsonValue = setData(keyDetail, keyValue)
              }
              else if (Initializer.jsonDetails.has(keyValue.getClass.getCanonicalName)) {
                keyDetail.put(Constants.STRUCTURE_NAME, keyValue.getClass.getCanonicalName).put(Constants.NAME, keyName).put(Constants.TYPE, keyValue.getClass.getCanonicalName)
                jsonValue = setData(keyDetail, keyValue)
              }
            }
            else {
              if (customHandling && keyValue.isInstanceOf[ArrayBuffer[_]]) {
                if (Initializer.jsonDetails.has(keyValue.asInstanceOf[ArrayBuffer[_]](0).getClass.getCanonicalName)) {
                  keyDetail.put(Constants.STRUCTURE_NAME, keyValue.asInstanceOf[ArrayBuffer[_]](0).getClass.getCanonicalName).put(Constants.NAME, keyName).put(Constants.TYPE, keyValue.asInstanceOf[ArrayBuffer[_]](0).getClass.getCanonicalName)
                  jsonValue = setJSONArray(keyValue, keyDetail)
                }
                else jsonValue = redirectorForObjectToJSON(keyValue)
              }
              else jsonValue = redirectorForObjectToJSON(keyValue)
            }
          }
        }
        else jsonValue = JSONObject.NULL
        if (keyValue != None && keyValue != null) {
          requiredKeys.remove(keyName)
          primaryKeys.remove(keyName)
        }
        requestJSON.put(keyName, jsonValue)
      }
    }
    if (skipMandatory || checkException(classMemberName, recordInstance, instanceNumber, lookUp, requiredKeys, primaryKeys)) {
      return requestJSON
    }
  }

  @throws[JSONException]
  @throws[Exception]
  private def setData(memberDetail: JSONObject, fieldValue: Any): Any = {
    if (fieldValue != None || fieldValue != null) {
      val `type` = memberDetail.get(Constants.TYPE).asInstanceOf[String]
      return setDataValue(`type`, memberDetail, fieldValue)
    }
    JSONObject.NULL
  }

  private def setDataValue(`type`: String, memberDetail: JSONObject, fieldValue: Any) : Any = {
      if (`type`.equalsIgnoreCase(Constants.LIST_NAMESPACE)) setJSONArray(fieldValue, memberDetail)
      else if (`type`.equalsIgnoreCase(Constants.MAP_NAMESPACE)) setJSONObject(fieldValue, memberDetail)
      else if (`type` == Constants.CHOICE_NAMESPACE || (memberDetail.has(Constants.STRUCTURE_NAME) && memberDetail.getString(Constants.STRUCTURE_NAME) == Constants.CHOICE_NAMESPACE)) fieldValue.asInstanceOf[Choice[_]].getValue
      else if (memberDetail.has(Constants.STRUCTURE_NAME) && memberDetail.has(Constants.MODULE.toLowerCase)) isRecordRequest(fieldValue, getModuleDetailFromUserSpecJSON(memberDetail.getString(Constants.MODULE.toLowerCase)), null, memberDetail)
      else if (memberDetail.has(Constants.STRUCTURE_NAME)) formRequest(fieldValue, memberDetail.getString(Constants.STRUCTURE_NAME), null, memberDetail)
      else fieldValue match {
        case value: Option[_] =>
          if (value.isDefined) {
            DataTypeConverter.postConvert(value.get, `type`)
          }
          else {
            JSONObject.NULL
          }
        case _ => DataTypeConverter.postConvert(fieldValue, `type`)
      }
  }

  @throws[NoSuchFieldException]
  @throws[SecurityException]
  @throws[IllegalArgumentException]
  @throws[IllegalAccessException]
  @throws[JSONException]
  private def setJSONObject(fieldValue: Any, memberDetail: JSONObject) = {
    val jsonObject = new JSONObject
    val requestObject = fieldValue.asInstanceOf[mutable.HashMap[Any, _]]
    if (requestObject.nonEmpty) {
      if (memberDetail == null || (memberDetail != null && !memberDetail.has(Constants.KEYS))) {
        for (key <- requestObject.keySet) {
          jsonObject.put(key.asInstanceOf[String], redirectorForObjectToJSON(requestObject(key)))
        }
      }
      else {
        if (memberDetail.has(Constants.KEYS)) {
          val keysDetail = memberDetail.getJSONArray(Constants.KEYS)
          for (keyIndex <- 0 until keysDetail.length) {
            val keyDetail = keysDetail.getJSONObject(keyIndex)
            val keyName = keyDetail.getString(Constants.NAME)
            if (requestObject.contains(keyName) && requestObject.get(keyName) != null) {
              val keyValue = setData(keyDetail, requestObject(keyName))
              jsonObject.put(keyName, keyValue)
            }
          }
        }
      }
    }
    jsonObject
  }

  @throws[NoSuchFieldException]
  @throws[SecurityException]
  @throws[IllegalArgumentException]
  @throws[IllegalAccessException]
  private def setJSONArray(fieldValue: Any, memberDetail: JSONObject) = {
    val jsonArray = new JSONArray
    val requestObjects = fieldValue.asInstanceOf[ArrayBuffer[_]]
    if (requestObjects.nonEmpty) {
      if (memberDetail == null || (memberDetail != null && !memberDetail.has(Constants.STRUCTURE_NAME))) {
        if (memberDetail != null && memberDetail.has(Constants.SUB_TYPE)) {
          val subType = memberDetail.getJSONObject(Constants.SUB_TYPE)
          val `type` = subType.getString(Constants.TYPE)
          if (`type`.equalsIgnoreCase(Constants.CHOICE_NAMESPACE)) {
            for (response <- requestObjects) {
              jsonArray.put(response.asInstanceOf[Choice[_]].getValue)
            }
          }
          else {
            for (response <- requestObjects) {
              jsonArray.put(setDataValue(`type`, memberDetail, response))
            }
          }
        }
        else for (request <- requestObjects) {
          jsonArray.put(redirectorForObjectToJSON(request))
        }
      }
      else {
        val pack = memberDetail.getString(Constants.STRUCTURE_NAME)
        if (pack.equalsIgnoreCase(Constants.CHOICE_NAMESPACE)) {
          for (request <- requestObjects) {
            jsonArray.put(request.asInstanceOf[Choice[_]].getValue)
          }
        }
        else if (memberDetail.has(Constants.MODULE.toLowerCase) && memberDetail.get(Constants.MODULE.toLowerCase) != null) {
          var instanceCount = 0
          for (request <- requestObjects) {
            jsonArray.put(isRecordRequest(request, getModuleDetailFromUserSpecJSON(memberDetail.getString(Constants.MODULE.toLowerCase)), instanceCount, memberDetail))
            instanceCount += 1
          }
        }
        else {
          var instanceCount = 0
          for (request <- requestObjects) {
            jsonArray.put(formRequest(request, pack, instanceCount, memberDetail))
            instanceCount += 1
          }
        }
      }
    }
    jsonArray
  }

  @throws[NoSuchFieldException]
  @throws[SecurityException]
  @throws[IllegalArgumentException]
  @throws[IllegalAccessException]
  @throws[JSONException]
  private def redirectorForObjectToJSON(request: Any): Any = {
    request match {//    request match {// _ _ represents an “existential type”
      case _: ArrayBuffer[_] => setJSONArray(request, null)
      case _: mutable.HashMap[_, _] => setJSONObject(request, null)
      case _: Choice[_] => request.asInstanceOf[Choice[_]].getValue
      case _ => request match {
        case value: Option[_] => value.getOrElse(JSONObject.NULL)
        case _ => if (request == null || request == None) JSONObject.NULL
        else request
      }
    }
  }

  override def getWrappedResponse(response: Any, pack: String): Option[java.util.ArrayList[Any]] = {
    val responseEntity = response.asInstanceOf[HttpResponse].getEntity
    if (responseEntity != null) {
      var responseArray = new java.util.ArrayList[Any]()
      val responseObject = EntityUtils.toString(responseEntity)
      responseArray.add(getResponse(responseObject, pack))
      responseArray.add(getJSON(responseObject))
      return Option(responseArray)
    }
    None
  }

  def getJSON(response: Any): JSONObject = {
    var responseString = response.toString
    if (responseString == null || responseString.equals("null") || responseString.isEmpty || responseString.trim().isEmpty || responseString.equals("{}")) {
      null
    }
    else{
      new JSONObject(responseString);
    }

  }

  @throws[InstantiationException]
  @throws[IllegalAccessException]
  @throws[ClassNotFoundException]
  @throws[IllegalArgumentException]
  @throws[InvocationTargetException]
  @throws[NoSuchFieldException]
  @throws[SecurityException]
  override def getResponse(response: Any, packageName: String): Any = {
    val classDetail = Initializer.jsonDetails.getJSONObject(packageName)
    val responseJson = getJSON(response)
    if (responseJson == null){
      return responseJson
    }
    var instance: Any = null
    if (classDetail.has(Constants.INTERFACE) && classDetail.getBoolean(Constants.INTERFACE)) {
      val classes = classDetail.getJSONArray(Constants.CLASSES)
      instance = findMatch(classes, responseJson)// find match returns instance(calls getResponse() recursively)
    }
    else {
      val constructor: Constructor[_] = Class.forName(packageName).getDeclaredConstructors()(0)
      if (Modifier.isPrivate(constructor.getModifiers)) constructor.setAccessible(true)
      instance = constructor.newInstance()
      if (instance.isInstanceOf[Record]) {// if record -> based on response json data will be assigned to field Values
        val moduleAPIName = this.commonAPIHandler.getModuleAPIName
        instance = isRecordResponse(responseJson, classDetail, packageName)
        this.commonAPIHandler.setModuleAPIName(moduleAPIName)
      }
      else {
        instance = notRecordResponse(instance, responseJson, classDetail) // based on json details data will be assigned
      }
    }
    instance
  }

  @throws[Exception]
  private def notRecordResponse(instance: Any, responseJson: JSONObject, classDetail: JSONObject) = {
    val classDetailKeys = classDetail.keys()
    while (classDetailKeys.hasNext) {
      val memberName = classDetailKeys.next()
      val keyDetail = classDetail.getJSONObject(memberName)
      val keyName = if (keyDetail.has(Constants.NAME)) keyDetail.getString(Constants.NAME) else null
      if (keyName != null && responseJson.has(keyName) && responseJson.get(keyName) != null && !responseJson.isNull(keyName)) {
        val keyData = responseJson.get(keyName)
        val member = instance.getClass.getDeclaredField(memberName)
        member.setAccessible(true)
        val memberValue = getData(keyData, keyDetail)
        if (member.getType.getName.contains("scala.Option")) {
          member.set(instance, Option(memberValue))
        }
        else {
          member.set(instance, memberValue)
        }
      }
    }
    instance
  }

  @throws[JSONException]
  @throws[Exception]
  private def isRecordResponse(responseJson: JSONObject, classDetails: JSONObject, pack: String): Any = {
    val classDetail = classDetails
    val recordInstance = Class.forName(pack).getDeclaredConstructor().newInstance()
    val moduleAPIName = this.commonAPIHandler.getModuleAPIName
    var moduleDetail = new JSONObject
    if (moduleAPIName != null) { // entry
      this.commonAPIHandler.setModuleAPIName(null)
      moduleDetail = getModuleDetailFromUserSpecJSON(moduleAPIName)
    }
    for (key <- JSONObject.getNames(classDetail)) {
      moduleDetail.put(key, classDetail.get(key))
    }
    val recordDetail = Initializer.jsonDetails.getJSONObject(Constants.RECORD_NAMESPACE)
    var cl = recordInstance.getClass
    val scl = cl.getSuperclass
    if (scl.getCanonicalName == Constants.RECORD_NAMESPACE) cl = scl
    val member = cl.getDeclaredField(Constants.KEY_VALUES)
    member.setAccessible(true)
    val keyValues: mutable.HashMap[String, Any] = mutable.HashMap()
    val responseJsonKeys = responseJson.keys()
    while (responseJsonKeys.hasNext) {
      var keyName = responseJsonKeys.next()
      val memberName = buildName(keyName)
      var keyDetail = new JSONObject
      if (moduleDetail.length > 0 && (moduleDetail.has(keyName) || moduleDetail.has(memberName))) {
        if (moduleDetail.has(keyName)) keyDetail = moduleDetail.getJSONObject(keyName) // in-case of user spec json
        else keyDetail = moduleDetail.getJSONObject(memberName)
      } // json details
      else if (recordDetail.has(memberName)) keyDetail = recordDetail.getJSONObject(memberName)
      var keyValue: Any = null
      val keyData = responseJson.get(keyName)
      if (keyDetail.length > 0) {
        keyName = keyDetail.getString(Constants.NAME)
        keyValue = getData(keyData, keyDetail)
      }
      else { // if not key detail
        keyValue = redirectorForJSONToObject(keyData)
      }
      if (keyValue.isInstanceOf[ArrayBuffer[_]] || keyValue.isInstanceOf[mutable.HashMap[_, _]] || keyValue.isInstanceOf[Choice[_]]) {
        keyValues(keyName) = keyValue
      }
      else {
        keyValues(keyName) = Option(keyValue)
      }
    }
    member.set(recordInstance, keyValues)
    recordInstance
  }

  @throws[Exception]
  private def getData(keyData: Any, memberDetail: JSONObject): Any = {
    var memberValue: Any = null
    if (keyData != JSONObject.NULL) {
      val `type` = memberDetail.get(Constants.TYPE).asInstanceOf[String]
      memberValue = getDataValue(`type`, keyData, memberDetail)
    }
    memberValue
  }

  private def getDataValue(`type`: String, keyData: Any, memberDetail: JSONObject): Any = {
    var memberValue: Any = null
    if (`type`.equalsIgnoreCase(Constants.LIST_NAMESPACE)) memberValue = getCollectionsData(keyData.asInstanceOf[JSONArray], memberDetail)
    else if (`type`.equalsIgnoreCase(Constants.MAP_NAMESPACE)) memberValue = getHashMapData(keyData.asInstanceOf[JSONObject], memberDetail)
    else if (`type`.equalsIgnoreCase(Constants.CHOICE_NAMESPACE) || (memberDetail.has(Constants.STRUCTURE_NAME) && memberDetail.getString(Constants.STRUCTURE_NAME).equals(Constants.CHOICE_NAMESPACE))) memberValue = Class.forName(`type`).getConstructors()(0).newInstance(keyData)
    else if (memberDetail.has(Constants.STRUCTURE_NAME) && memberDetail.has(Constants.MODULE.toLowerCase)) memberValue = isRecordResponse(keyData.asInstanceOf[JSONObject], getModuleDetailFromUserSpecJSON(memberDetail.getString(Constants.MODULE.toLowerCase)), memberDetail.getString(Constants.STRUCTURE_NAME))
    else if (memberDetail.has(Constants.STRUCTURE_NAME)) memberValue = getResponse(keyData, memberDetail.getString(Constants.STRUCTURE_NAME))
    else memberValue = DataTypeConverter.preConvert(keyData, `type`)
    memberValue
  }

  @throws[InstantiationException]
  @throws[IllegalAccessException]
  @throws[ClassNotFoundException]
  @throws[IllegalArgumentException]
  @throws[InvocationTargetException]
  @throws[NoSuchFieldException]
  @throws[SecurityException]
  @throws[JSONException]
  private def getHashMapData(response: JSONObject, memberDetail: JSONObject): mutable.HashMap[String, Any] = {
    val mapInstance = mutable.HashMap[String, Any]()
    if (response.length() > 0)
      if (memberDetail == null || (memberDetail != null && !memberDetail.has(Constants.KEYS))) {
        val responseKeys = response.keys()
        while (responseKeys.hasNext) {
          val key = responseKeys.next()
          mapInstance(key) = redirectorForJSONToObject(response.get(key))
        }
      }
      else {
        val responseKeys = response.keySet
        if (memberDetail.has(Constants.KEYS)) {
          val keysDetail = memberDetail.getJSONArray(Constants.KEYS)
          for (keyIndex <- 0 until keysDetail.length) {
            val keyDetail = keysDetail.getJSONObject(keyIndex)
            val keyName = keyDetail.getString(Constants.NAME)
            if (response.has(keyName) && response.get(keyName) != null) {
              val keyValue = getData(response.get(keyName), keyDetail)
              mapInstance(keyName) = keyValue
              responseKeys.remove(keyName)
            }
          }
        }
        if (responseKeys.size > 0) responseKeys.forEach(name => {
          mapInstance.put(name, response.get(name))
        })
      }
    mapInstance
  }

  @throws[InstantiationException]
  @throws[IllegalAccessException]
  @throws[ClassNotFoundException]
  @throws[IllegalArgumentException]
  @throws[InvocationTargetException]
  @throws[NoSuchFieldException]
  @throws[SecurityException]
  private def getCollectionsData(responses: JSONArray, memberDetail: JSONObject): ArrayBuffer[Any] = {
    val values = new ArrayBuffer[Any]()
    if (responses.length() > 0) {
      if (memberDetail == null || (memberDetail != null && !memberDetail.has(Constants.STRUCTURE_NAME))) {
        if (memberDetail != null && memberDetail.has(Constants.SUB_TYPE)) {
          val subType = memberDetail.getJSONObject(Constants.SUB_TYPE)
          val `type` = subType.getString(Constants.TYPE)
          if (`type`.equalsIgnoreCase(Constants.CHOICE_NAMESPACE)) {
            responses.forEach(response => {
              values.addOne(Class.forName(Constants.CHOICE_NAMESPACE).getConstructor().newInstance(response))
            })
          }
          else {
            responses.forEach(response => {
              values.addOne(getDataValue(`type`, response, memberDetail))
            })
          }
        }
        else {
          for (responseIndex <- 0 until responses.length) {
            val response = responses.get(responseIndex)
            values.addOne(redirectorForJSONToObject(response))
          }
        }
      }
      else {
        val pack = memberDetail.getString(Constants.STRUCTURE_NAME)
        if (pack.equalsIgnoreCase(Constants.CHOICE_NAMESPACE)) for (responseIndex <- 0 until responses.length) {
          val response = responses.get(responseIndex)
          values.addOne(Class.forName(Constants.CHOICE_NAMESPACE).getConstructors()(0).newInstance(response))
        }
        else if (memberDetail.has(Constants.MODULE.toLowerCase) && memberDetail.get(Constants.MODULE.toLowerCase) != null) for (responseIndex <- 0 until responses.length) {
          val response = responses.get(responseIndex)
          values.addOne(isRecordResponse(response.asInstanceOf[JSONObject], getModuleDetailFromUserSpecJSON(memberDetail.getString(Constants.MODULE.toLowerCase)), pack))
        }
        else {
          for (responseIndex <- 0 until responses.length) {
            val response = responses.get(responseIndex)
            values.addOne(getResponse(response, pack))
          }
        }
      }
    }
    values
  }

  private def getModuleDetailFromUserSpecJSON(module: String): JSONObject = {
    var moduleDetail: JSONObject = new JSONObject()
    val recordFieldDetailsPath = Initializer.getInitializer.getResourcePath + File.separator + Constants.FIELD_DETAILS_DIRECTORY + File.separator + getEncodedFileName
    moduleDetail = Utility.getJSONObject(Initializer.getJSON(recordFieldDetailsPath), module).getOrElse(new JSONObject())
    moduleDetail
  }

  @throws[InstantiationException]
  @throws[IllegalAccessException]
  @throws[ClassNotFoundException]
  @throws[IllegalArgumentException]
  @throws[InvocationTargetException]
  @throws[NoSuchFieldException]
  @throws[SecurityException]
  @throws[JSONException]
  private def redirectorForJSONToObject(keyData: Any): Any = {
    keyData match {
      case nObject: JSONObject => getHashMapData(nObject, null)
      case _ => keyData match {
        case array: JSONArray => getCollectionsData(array, null)
        case _ => if (keyData == JSONObject.NULL) None
        else keyData
      }
    }
  }

  @throws[InstantiationException]
  @throws[IllegalAccessException]
  @throws[ClassNotFoundException]
  @throws[IllegalArgumentException]
  @throws[InvocationTargetException]
  @throws[NoSuchFieldException]
  @throws[SecurityException]
  private def findMatch(classes: JSONArray, responseJson: JSONObject): Any = {
    if (classes.length == 1) {
      return getResponse(responseJson, classes.getString(0))
    }
    var pack = ""
    var ratio: Float = 0
    breakable {
      for (classIndex: Int <- 0 until classes.length()) {
        val className = classes.get(classIndex)
        val matchRatio = findRatio(className.asInstanceOf[String], responseJson)
        if (matchRatio == 1.0) {
          pack = className.asInstanceOf[String]
          ratio = 1
          break
        }
        else if (matchRatio > ratio) {
          ratio = matchRatio
          pack = className.asInstanceOf[String]
        }
      }
    }
    getResponse(responseJson, pack)
  }

  private def findRatio(className: String, responseJson: JSONObject): Float = {
    val classDetail = Initializer.jsonDetails.get(className).asInstanceOf[JSONObject]
    val totalPoints: Float = classDetail.keySet.size
    var matches: Float = 0
    if (totalPoints == 0) return 0
    else {
      val classDetailsKeys = classDetail.keys()
      while (classDetailsKeys.hasNext) {
        val memberName = classDetailsKeys.next()
        val memberDetail = classDetail.getJSONObject(memberName)
        val keyName = if (memberDetail.has(Constants.NAME)) memberDetail.getString(Constants.NAME)
        else null
        if (keyName != null && responseJson.has(keyName) && responseJson.get(keyName) != null) { // key not empty
          val keyData = responseJson.get(keyName)
          var `type` = keyData.getClass.getTypeName
          val structureName = if (memberDetail.has(Constants.STRUCTURE_NAME)) memberDetail.getString(Constants.STRUCTURE_NAME)
          else null
          if (keyData.isInstanceOf[JSONObject]) `type` = Constants.MAP_NAMESPACE
          if (keyData.isInstanceOf[JSONArray]) `type` = Constants.LIST_NAMESPACE
          if (`type` == memberDetail.get(Constants.TYPE)) matches += 1
          else if (keyName.equalsIgnoreCase(Constants.COUNT) && `type`.equalsIgnoreCase(Constants.INTEGER_NAMESPACE)) matches += 1
          else if (memberDetail.getString(Constants.TYPE).equalsIgnoreCase(Constants.CHOICE_NAMESPACE)) {
            val values = memberDetail.getJSONArray(Constants.VALUES)
            breakable {
              for (valueIndex: Int <- 0 until values.length()) {
                val value = values.get(valueIndex)
                if (value == keyData) {
                  matches += 1
                  break
                }
              }
            }
          }
          if (structureName != null && structureName == memberDetail.get(Constants.TYPE)) if (memberDetail.has(Constants.VALUES)) {
            val values = memberDetail.getJSONArray(Constants.VALUES)
            breakable {
              for (valueIndex: Int <- 0 until values.length()) {
                val value = values.get(valueIndex)
                if (value == keyData) {
                  matches += 1
                  break
                }
              }
            }
          }
          else {
            matches += 1
          }
        }
      }
    }
    matches / totalPoints
  }

  def buildName(memberName: String): String = {
    val name = memberName.toLowerCase().split("_")
    var sdkName = ""
    var index = 0
    if (name.isEmpty) index = 1
    if (name(0) != null && name(0).nonEmpty) {
      sdkName = name(0).substring(0, 1).toLowerCase().concat(name(0).substring(1))
    }
    index = 1
    for (nameIndex <- index until name.length) {
      var firstLetterUppercase = ""
      if (name(nameIndex).nonEmpty) {
        firstLetterUppercase = name(nameIndex).substring(0, 1).toUpperCase.concat(name(nameIndex).substring(1))
      }
      sdkName = sdkName.concat(firstLetterUppercase)
    }
    sdkName
  }
}