package com.zoho.crm.api.util

import _root_.org.json.{JSONArray, JSONException, JSONObject}
import com.zoho.api.logger.SDKLogger
import com.zoho.crm.api.exception.SDKException
import com.zoho.crm.api.fields.FieldsOperations.GetFieldsParam
import com.zoho.crm.api.fields.{APIException, Fields, FieldsOperations, ResponseWrapper}
import com.zoho.crm.api.modules.ModulesOperations.GetModulesHeader
import com.zoho.crm.api.modules.{MinifiedModule, ModulesOperations}
import com.zoho.crm.api.relatedlists.RelatedListsOperations
import com.zoho.crm.api.relatedlists.RelatedListsOperations.GetRelatedListsParam
import com.zoho.crm.api.users.UsersOperations.GetUsersParam
import com.zoho.crm.api.{Header, HeaderMap, Initializer, ParameterMap, modules, relatedlists, users}
import org.apache.hc.core5.http.ClassicHttpRequest

import java.io.{File, FileWriter, IOException, UnsupportedEncodingException}
import java.time.{Instant, OffsetDateTime, ZoneId}
import java.util
import java.util.logging.{Level, Logger}
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.*

/**
 * This class handles module field details.
 */
object Utility {
  private val apiTypeVsDataType: mutable.HashMap[String, String] = mutable.HashMap()
  private val apiTypeVsStructureName: mutable.HashMap[String, String] = mutable.HashMap()
  private val LOGGER = Logger.getLogger(classOf[SDKLogger].getName)
  private var newFile: Boolean = false
  private var getModifiedModules: Boolean = false
  private var forceRefresh: Boolean = false
  private var apiSupportedModule = new JSONObject()
  private var moduleAPIName: String = ""

  def assertNotNull(value: Object, errorCode: String, errorMessage: String): Unit = {
    if (value == null) {
      throw new SDKException(errorCode, errorMessage)
    }
  }

  def areAllObjectsNull(objects: Object*): Boolean = {
    for (o <- objects) {
      if (o != null) {
        return false
      }
    }
    true
  }

  private def fileExistsFlow(moduleAPIName: String, recordFieldDetailsPath: String, lastModifiedTime1: String): Unit = synchronized {
    var recordFieldDetailsJson = Initializer.getJSON(recordFieldDetailsPath)
    var lastModifiedTime = lastModifiedTime1
    if (Initializer.getInitializer.getSDKConfig.getAutoRefreshFields && !newFile && !getModifiedModules && (recordFieldDetailsJson.optString(Constants.FIELDS_LAST_MODIFIED_TIME).isEmpty || forceRefresh || (System.currentTimeMillis - recordFieldDetailsJson.getString(Constants.FIELDS_LAST_MODIFIED_TIME).toLong) > 3600000)) {
      getModifiedModules = true
      if (!forceRefresh && recordFieldDetailsJson.has(Constants.FIELDS_LAST_MODIFIED_TIME)) lastModifiedTime = recordFieldDetailsJson.getString(Constants.FIELDS_LAST_MODIFIED_TIME)
      else lastModifiedTime = null
      modifyFields(recordFieldDetailsPath, lastModifiedTime)
      getModifiedModules = false
    }
    else if (!Initializer.getInitializer.getSDKConfig.getAutoRefreshFields && forceRefresh && !getModifiedModules) {
      getModifiedModules = true
      modifyFields(recordFieldDetailsPath, lastModifiedTime)
      getModifiedModules = false
    }
    recordFieldDetailsJson = Initializer.getJSON(recordFieldDetailsPath)
    if (moduleAPIName == null || (recordFieldDetailsJson.has(moduleAPIName.toLowerCase) && recordFieldDetailsJson.get(moduleAPIName.toLowerCase) != null)) return
    else {
      fillDatatype()
      recordFieldDetailsJson.put(moduleAPIName.toLowerCase, new JSONObject)
      var file = new FileWriter(recordFieldDetailsPath)
      file.flush()
      file.write(recordFieldDetailsJson.toString) // write existing data + dummy
      file.flush()
      file.close()
      val fieldDetails = getFieldsDetails(moduleAPIName)
      recordFieldDetailsJson = Initializer.getJSON(recordFieldDetailsPath)
      recordFieldDetailsJson.put(moduleAPIName.toLowerCase, fieldDetails)
      file = new FileWriter(recordFieldDetailsPath)
      file.flush()
      file.write(recordFieldDetailsJson.toString) // over writing the dummy +existing data
      file.flush()
      file.close()
    }
  }

  private def verifyModuleAPIName(moduleName: String): String = {
    if (moduleName != null && Constants.DEFAULT_MODULENAME_VS_APINAME.contains(moduleName.toLowerCase) && Constants.DEFAULT_MODULENAME_VS_APINAME.get(moduleName.toLowerCase) != null) {
      return Constants.DEFAULT_MODULENAME_VS_APINAME(moduleName.toLowerCase)
    }
    val recordFieldDetailsPath: String = getFileName
    val recordFieldDetails = new File(recordFieldDetailsPath)
    if (recordFieldDetails.exists) {
      val fieldsJSON = Initializer.getJSON(recordFieldDetailsPath)
      if (fieldsJSON.has(Constants.SDK_MODULE_METADATA) && fieldsJSON.getJSONObject(Constants.SDK_MODULE_METADATA).has(moduleName.toLowerCase)) {
        return fieldsJSON.getJSONObject(Constants.SDK_MODULE_METADATA).getJSONObject(moduleName.toLowerCase).getString(Constants.API_NAME)
      }
    }
    moduleName
  }

  private def setHandlerAPIPath(moduleAPIName: String, handlerInstance: CommonAPIHandler): Unit = synchronized {
    if (handlerInstance == null) {
      return
    }
    var apiPath = handlerInstance.getAPIPath
    if (apiPath.toLowerCase.contains(moduleAPIName.toLowerCase)) {
      val apiPathSplit: Array[String] = apiPath.split("/")
      for (index <- apiPathSplit.indices) {
        if (apiPathSplit(index).equalsIgnoreCase(moduleAPIName)) {
          apiPathSplit(index) = moduleAPIName
        }
        else if (Constants.DEFAULT_MODULENAME_VS_APINAME.contains(apiPathSplit(index).toLowerCase()) && Constants.DEFAULT_MODULENAME_VS_APINAME.get(apiPathSplit(index).toLowerCase) != null) {
          apiPathSplit(index) = Constants.DEFAULT_MODULENAME_VS_APINAME(apiPathSplit(index).toLowerCase)
        }
      }
      apiPath = apiPathSplit.mkString("/")
      handlerInstance.setAPIPath(apiPath)
    }
  }

  /**
   * This method to fetch field details of the current module for the current user and store the result in a JSON file.
   *
   * @param moduleAPIName   A String containing the CRM module API name.
   * @param handlerInstance A CommonAPIHandler Instance
   */
  def getFields(moduleAPIName: String, handlerInstance: CommonAPIHandler): Unit = synchronized {
    if (moduleAPIName.contains(",")) {
      val modules = moduleAPIName.split(",")
      for (name <- modules) {
        Utility.moduleAPIName = name
        getFieldsInfo(name, handlerInstance)
      }
    }
    else {
      Utility.moduleAPIName = moduleAPIName
      getFieldsInfo(Utility.moduleAPIName, handlerInstance)
    }
  }

  /**
   * This method to fetch field details of the current module for the current user and store the result in a JSON file.
   *
   * @param moduleName A String containing the CRM module API name.
   * @throws SDKException Exception
   */
  @throws[SDKException]
  private def getFieldsInfo(moduleName: String, handlerInstance: CommonAPIHandler): Unit = synchronized {
    var recordFieldDetailsPath: String = null
    val lastModifiedTime: String = null
    var moduleAPIName: String = moduleName
    try {
      val resourcesPath = new File(Initializer.getInitializer.getResourcePath + File.separator + Constants.FIELD_DETAILS_DIRECTORY)
      if (!resourcesPath.exists) resourcesPath.mkdirs
      moduleAPIName = verifyModuleAPIName(moduleAPIName)
      setHandlerAPIPath(moduleAPIName, handlerInstance)
      if (handlerInstance != null && handlerInstance.getModuleAPIName == null && !Constants.SKIP_MODULES.contains(moduleAPIName.toLowerCase)) return
      recordFieldDetailsPath = getFileName
      val recordFieldDetails = new File(recordFieldDetailsPath)
      if (recordFieldDetails.exists) {
        fileExistsFlow(moduleAPIName, recordFieldDetailsPath, lastModifiedTime)
      }
      else if (Initializer.getInitializer.getSDKConfig.getAutoRefreshFields) {
        newFile = true
        fillDatatype()
        apiSupportedModule = if (apiSupportedModule.length() > 0) apiSupportedModule
        else getModules(null)
        var recordFieldDetailsJson = if (recordFieldDetails.exists()) Initializer.getJSON(recordFieldDetailsPath)
        else new JSONObject
        recordFieldDetailsJson.put(Constants.FIELDS_LAST_MODIFIED_TIME, String.valueOf(System.currentTimeMillis))
        if (apiSupportedModule.length() > 0) {
          apiSupportedModule.keySet().forEach(module => {
            if (!recordFieldDetailsJson.has(module.toLowerCase)) {
              val moduleData = apiSupportedModule.getJSONObject(module.toLowerCase)
              recordFieldDetailsJson.put(module.toLowerCase, new JSONObject)
              var file = new FileWriter(recordFieldDetailsPath)
              file.write(recordFieldDetailsJson.toString)
              file.flush()
              file.close() // file created with only dummy
              val fieldDetails = getFieldsDetails(moduleData.getString(Constants.API_NAME))
              recordFieldDetailsJson = Initializer.getJSON(recordFieldDetailsPath)
              recordFieldDetailsJson.put(module.toLowerCase, fieldDetails)
              file = new FileWriter(recordFieldDetailsPath)
              file.flush()
              file.write(recordFieldDetailsJson.toString)
              file.flush()
              file.close()
            }
          })
        }
        newFile = false
      }
      else if (forceRefresh && !getModifiedModules) { //New file - and force refresh by User
        getModifiedModules = true
        val recordFieldDetailsJson = new JSONObject
        val file = new FileWriter(recordFieldDetailsPath)
        file.write(recordFieldDetailsJson.toString)
        file.flush()
        file.close()
        modifyFields(recordFieldDetailsPath, lastModifiedTime)
        getModifiedModules = false
      }
      else {
        fillDatatype()
        var recordFieldDetailsJson = new JSONObject
        recordFieldDetailsJson.put(moduleAPIName.toLowerCase, new JSONObject)
        var file = new FileWriter(recordFieldDetailsPath)
        file.write(recordFieldDetailsJson.toString)
        file.flush()
        file.close()
        val fieldDetails = getFieldsDetails(moduleAPIName)
        recordFieldDetailsJson = Initializer.getJSON(recordFieldDetailsPath)
        recordFieldDetailsJson.put(moduleAPIName.toLowerCase, fieldDetails)
        file = new FileWriter(recordFieldDetailsPath)
        file.flush()
        file.write(recordFieldDetailsJson.toString)
        file.flush()
        file.close()
      }
    } catch {
      case e@(_: IOException | _: JSONException | _: SDKException) =>
        if (recordFieldDetailsPath != null && new File(recordFieldDetailsPath).exists) {
          try {
            val recordFieldDetailsJson = Initializer.getJSON(recordFieldDetailsPath)
            if (recordFieldDetailsJson.has(moduleAPIName.toLowerCase)) recordFieldDetailsJson.remove(moduleAPIName.toLowerCase)
            if (newFile) {
              if (recordFieldDetailsJson.get(Constants.FIELDS_LAST_MODIFIED_TIME) != null) recordFieldDetailsJson.remove(Constants.FIELDS_LAST_MODIFIED_TIME)
              newFile = false
            }
            if (getModifiedModules || forceRefresh) {
              getModifiedModules = false
              forceRefresh = false
              if (lastModifiedTime != null) recordFieldDetailsJson.put(Constants.FIELDS_LAST_MODIFIED_TIME, lastModifiedTime)
            }
            val file = new FileWriter(recordFieldDetailsPath)
            file.flush()
            file.write(recordFieldDetailsJson.toString)
            file.flush()
            file.close()
          } catch {
            case ex: IOException =>
              val exception = new SDKException(Constants.EXCEPTION, ex)
              LOGGER.log(Level.SEVERE, Constants.EXCEPTION, exception)
              throw exception
          }
        }
        var exception: SDKException = new SDKException(Constants.EXCEPTION, e.asInstanceOf[Exception])
        e match {
          case kException: SDKException =>
            exception = kException
          case _ =>
        }
        LOGGER.log(Level.SEVERE, Constants.EXCEPTION, exception)
        throw exception
    }
  }

  @throws[IOException]
  @throws[SDKException]
  private def modifyFields(recordFieldDetailsPath: String, modifiedTime: String): Unit = {
    val modifiedModules: JSONObject = getModules(modifiedTime)
    val recordFieldDetailsJson = Initializer.getJSON(recordFieldDetailsPath)
    recordFieldDetailsJson.put(Constants.FIELDS_LAST_MODIFIED_TIME, String.valueOf(System.currentTimeMillis))
    var file = new FileWriter(recordFieldDetailsPath)
    file.flush()
    file.write(recordFieldDetailsJson.toString)
    file.flush()
    file.close()
    if (modifiedModules.length() > 0) {
      modifiedModules.keySet().forEach(module => {
        if (recordFieldDetailsJson.has(module.toLowerCase)) deleteFields(recordFieldDetailsJson, module.toLowerCase)
      })
      file = new FileWriter(recordFieldDetailsPath)
      file.flush()
      file.write(recordFieldDetailsJson.toString)
      file.flush()
      file.close()
      modifiedModules.keySet().forEach(module => {
        val moduleData = modifiedModules.getJSONObject(module)
        getFieldsInfo(moduleData.getString(Constants.API_NAME), null)
      })
    }
  }

  def deleteFields(recordFieldDetailsJson: JSONObject, module: String): Unit = {
    val subformModules = new ArrayBuffer[String]
    val fieldsJSON = recordFieldDetailsJson.getJSONObject(module.toLowerCase)
    fieldsJSON.keySet.forEach((key: String) => {
      def foo(key: String) = if (fieldsJSON.getJSONObject(key).has(Constants.SUBFORM) && fieldsJSON.getJSONObject(key).getBoolean(Constants.SUBFORM) && recordFieldDetailsJson.has(fieldsJSON.getJSONObject(key).getString(Constants.MODULE.toLowerCase))) subformModules.addOne(fieldsJSON.getJSONObject(key).getString(Constants.MODULE.toLowerCase))

      foo(key)
    })
    recordFieldDetailsJson.remove(module.toLowerCase)
    if (subformModules.nonEmpty) {
      for (subformModule <- subformModules) {
        deleteFields(recordFieldDetailsJson, subformModule)
      }
    }
  }

  @throws[UnsupportedEncodingException]
  private def getFileName: String = {
    val converterInstance = new Converter() {
      override def getResponse(response: Any, pack: String): Any = None

      override def formRequest(requestObject: Any, pack: String, instanceNumber: Integer, memberDetails: JSONObject): Any = None

      override def appendToRequest(requestBase: ClassicHttpRequest, requestObject: Any): Unit = {}

      override def getWrappedResponse(response: Any, pack: String): Option[java.util.ArrayList[Any]] = None
    }
    Initializer.getInitializer.getResourcePath + File.separator + Constants.FIELD_DETAILS_DIRECTORY + File.separator + converterInstance.getEncodedFileName
  }

  @throws[SDKException]
  def getRelatedLists(relatedModuleName: String, moduleName: String, commonAPIHandler: CommonAPIHandler): Unit = synchronized {
    try {
      var moduleAPIName: String = moduleName
      var isNewData = false
      val key = (moduleAPIName + Constants.UNDERSCORE + Constants.RELATED_LISTS).toLowerCase
      val resourcesPath = new File(Initializer.getInitializer.getResourcePath + File.separator + Constants.FIELD_DETAILS_DIRECTORY)
      if (!resourcesPath.exists) resourcesPath.mkdirs
      val recordFieldDetailsPath = getFileName
      val recordFieldDetails = new File(recordFieldDetailsPath)
      if (!recordFieldDetails.exists || (recordFieldDetails.exists && Initializer.getJSON(recordFieldDetailsPath).optJSONArray(key) == null)) {
        isNewData = true
        moduleAPIName = verifyModuleAPIName(moduleAPIName)
        val relatedListValues = getRelatedListDetails(moduleAPIName)
        val recordFieldDetailsJSON = if (recordFieldDetails.exists) Initializer.getJSON(recordFieldDetailsPath)
        else new JSONObject
        recordFieldDetailsJSON.put(key, relatedListValues)
        val file = new FileWriter(recordFieldDetailsPath)
        file.write(recordFieldDetailsJSON.toString)
        file.flush()
        file.close()
      }
      val recordFieldDetailsJSON = Initializer.getJSON(recordFieldDetailsPath)
      val moduleRelatedList = recordFieldDetailsJSON.getJSONArray(key)
      if (!checkRelatedListExists(relatedModuleName, moduleRelatedList, commonAPIHandler) && !isNewData) {
        recordFieldDetailsJSON.remove(key)
        val file = new FileWriter(recordFieldDetailsPath)
        file.write(recordFieldDetailsJSON.toString)
        file.flush()
        file.close()
        getRelatedLists(relatedModuleName, moduleAPIName, commonAPIHandler)
      }
    } catch {
      case e: SDKException =>
        LOGGER.log(Level.SEVERE, Constants.EXCEPTION, e)
        throw e
      case e: Exception =>
        val exception = new SDKException(Constants.EXCEPTION, e)
        LOGGER.log(Level.SEVERE, Constants.EXCEPTION, exception)
        throw exception
    }
  }

  @throws[JSONException]
  @throws[SDKException]
  private def checkRelatedListExists(relatedModuleName: String, moduleRelatedListJA: JSONArray, commonAPIHandler: CommonAPIHandler): Boolean = {
    for (index <- 0 until moduleRelatedListJA.length) {
      val relatedListJO = moduleRelatedListJA.getJSONObject(index)
      if (relatedListJO.getString(Constants.API_NAME) != null && relatedListJO.getString(Constants.API_NAME).equalsIgnoreCase(relatedModuleName)) {
        if (relatedListJO.getString(Constants.HREF) == Constants.NULL_VALUE) throw new SDKException(Constants.UNSUPPORTED_IN_API, commonAPIHandler.getHttpMethod + " " + commonAPIHandler.getAPIPath + Constants.UNSUPPORTED_IN_API_MESSAGE)
        if (!relatedListJO.getString(Constants.MODULE.toLowerCase).equalsIgnoreCase(Constants.NULL_VALUE)) {
          commonAPIHandler.setModuleAPIName(relatedListJO.getString(Constants.MODULE.toLowerCase))
          getFieldsInfo(relatedListJO.getString(Constants.MODULE.toLowerCase), commonAPIHandler)
        }
        return true
      }
    }
    false
  }

  @throws[SDKException]
  private def getRelatedListDetails(moduleAPIName: String): JSONArray = {
    val relatedListsOperations = new RelatedListsOperations(null)
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetRelatedListsParam().module, moduleAPIName)
    val responseOption = relatedListsOperations.getRelatedLists(Option(paramInstance))
    val relatedListJA = new JSONArray
    if (responseOption.isDefined) {
      val response = responseOption.get
      if (response.getStatusCode == Constants.NO_CONTENT_STATUS_CODE) return relatedListJA
      if (response.isExpected) {
        val responseHandler = response.getObject
        responseHandler match {
          case responseWrapper: relatedlists.ResponseWrapper =>
            val relatedLists = responseWrapper.getRelatedLists()
            for (relatedList <- relatedLists) {
              val relatedListDetail = new JSONObject
              relatedListDetail.put(Constants.API_NAME, if (relatedList.getAPIName().isDefined) relatedList.getAPIName().get else Constants.NULL_VALUE)
              relatedListDetail.put(Constants.MODULE.toLowerCase, if (relatedList.getModule().isDefined) relatedList.getModule().get else Constants.NULL_VALUE)
              relatedListDetail.put(Constants.NAME, if (relatedList.getName().isDefined) relatedList.getName().get else Constants.NULL_VALUE)
              relatedListDetail.put(Constants.HREF, if (relatedList.getHref().isDefined) relatedList.getHref().get else Constants.NULL_VALUE)
              relatedListJA.put(relatedListDetail)
            }
          case _: relatedlists.APIException =>
            val exception = responseHandler.asInstanceOf[APIException]
            val errorResponse = new JSONObject
            errorResponse.put(Constants.CODE, exception.getCode().getValue)
            errorResponse.put(Constants.STATUS, exception.getStatus().getValue)
            errorResponse.put(Constants.MESSAGE, exception.getMessage())
            throw new SDKException(Constants.API_EXCEPTION, errorResponse)
          case _ =>
        }
      }
      else {
        val errorResponse = new JSONObject
        errorResponse.put(Constants.CODE, response.getStatusCode)
        throw new SDKException(Constants.API_EXCEPTION, errorResponse)
      }
    }
    relatedListJA
  }

  private def getFieldsDetails(moduleAPIName: String): JSONObject = {
    val fieldsDetails = new JSONObject
    val fieldOperation = new FieldsOperations()
    val parameterMap = new ParameterMap
    parameterMap.add(new GetFieldsParam().module, moduleAPIName)
    val responseOption = fieldOperation.getFields(Option(parameterMap))
    if (responseOption.isDefined) {
      val response = responseOption.get
      if (response.getStatusCode == Constants.NO_CONTENT_STATUS_CODE) {
        return fieldsDetails
      }
      // Check if expected response is received
      if (response.isExpected) {
        val responseHandler = response.getObject
        responseHandler match {
          case responseWrapper: ResponseWrapper =>
            val fields = responseWrapper.getFields()
            fields.foreach(field => {
              breakable {
                val keyName = field.getAPIName().orNull
                if (Constants.KEYS_TO_SKIP.contains(keyName)) {
                  break
                }
                val fieldDetail = new JSONObject
                setDataType(fieldDetail, field, moduleAPIName)
                fieldsDetails.put(field.getAPIName().get, fieldDetail)
              }
            })
            if (Constants.INVENTORY_MODULES.contains(moduleAPIName.toLowerCase)) {
              val fieldDetail = new JSONObject
              fieldDetail.put(Constants.NAME, Constants.LINE_TAX)
              fieldDetail.put(Constants.TYPE, Constants.LIST_NAMESPACE)
              fieldDetail.put(Constants.STRUCTURE_NAME, Constants.LINE_TAX_NAMESPACE)
              fieldDetail.put(Constants.LOOKUP, true)
              fieldsDetails.put(Constants.LINE_TAX, fieldDetail)
            }
            if (Constants.NOTES.equalsIgnoreCase(moduleAPIName)) {
              val fieldDetail = new JSONObject
              fieldDetail.put(Constants.NAME, Constants.ATTACHMENTS)
              fieldDetail.put(Constants.TYPE, Constants.LIST_NAMESPACE)
              fieldDetail.put(Constants.STRUCTURE_NAME, Constants.ATTACHMENTS_NAMESPACE)
              fieldsDetails.put(Constants.ATTACHMENTS, fieldDetail)
            }
          case _ =>
            responseHandler match {
              case exception: APIException =>
                val errorResponse = new JSONObject
                errorResponse.put(Constants.CODE, exception.getCode().getValue)
                errorResponse.put(Constants.STATUS, exception.getStatus().getValue)
                errorResponse.put(Constants.MESSAGE, exception.getMessage())
                val exceptionInstance = new SDKException(Constants.API_EXCEPTION, errorResponse)
                if (Utility.moduleAPIName.equalsIgnoreCase(moduleAPIName)) {
                  throw exceptionInstance
                }
                LOGGER.log(Level.SEVERE, Constants.API_EXCEPTION, exceptionInstance)
              case _ =>
            }
        }
      }
      else {
        val errorResponse = new JSONObject
        errorResponse.put(Constants.CODE, response.getStatusCode)
        throw new SDKException(Constants.API_EXCEPTION, errorResponse)
      }
    }
    fieldsDetails
  }

  def verifyPhotoSupport(moduleName: String): Boolean = synchronized {
    try {
      val moduleAPIName = verifyModuleAPIName(moduleName)
      if (Constants.PHOTO_SUPPORTED_MODULES.contains(moduleAPIName.toLowerCase)) return true
      val modules: JSONObject = getModuleNames
      if (modules.optJSONObject(moduleAPIName.toLowerCase()) != null) {
        val moduleMetaData = modules.getJSONObject(moduleAPIName.toLowerCase)
        if (moduleMetaData.has(Constants.GENERATED_TYPE) && !moduleMetaData.getString(Constants.GENERATED_TYPE).equals(Constants.GENERATED_TYPE_CUSTOM)) {
          throw new SDKException(Constants.UPLOAD_PHOTO_UNSUPPORTED_ERROR, Constants.UPLOAD_PHOTO_UNSUPPORTED_MESSAGE + moduleAPIName)
        }
      }
    }
    catch {
      case e: SDKException =>
        throw e
      case e: Exception =>
        val exception = new SDKException(Constants.EXCEPTION, e)
        throw exception
    }
    return true
  }

  private def getModuleNames: JSONObject = {
    var moduleData = new JSONObject()
    val resourcesPath = new File(Initializer.getInitializer.getResourcePath + File.separator + Constants.FIELD_DETAILS_DIRECTORY)
    if (!resourcesPath.exists) resourcesPath.mkdirs
    val recordFieldDetailsPath: String = getFileName
    val recordFieldDetails = new File(recordFieldDetailsPath)
    if (!recordFieldDetails.exists || (recordFieldDetails.exists && (Initializer.getJSON(recordFieldDetailsPath).optJSONObject(Constants.SDK_MODULE_METADATA) == null || Initializer.getJSON(recordFieldDetailsPath).optJSONObject(Constants.SDK_MODULE_METADATA).length == 0))) {
      moduleData = getModules(null)
      writeModuleMetaData(recordFieldDetailsPath, moduleData)
      return moduleData
    }
    val recordFieldDetailsJson: JSONObject = Initializer.getJSON(recordFieldDetailsPath)
    moduleData = recordFieldDetailsJson.getJSONObject(Constants.SDK_MODULE_METADATA)
    moduleData
  }

  private def writeModuleMetaData(recordFieldDetailsPath: String, moduleData: JSONObject): Unit = synchronized {
    val moduleDataJSON = new JSONObject()
    moduleData.keySet().forEach(key => {
      moduleDataJSON.put(key, moduleData.get(key))
    })
    val recordFieldDetails = new File(recordFieldDetailsPath)
    val fieldDetailsJSON = if (recordFieldDetails.exists()) Initializer.getJSON(recordFieldDetailsPath)
    else new JSONObject()
    fieldDetailsJSON.put(Constants.SDK_MODULE_METADATA, moduleDataJSON)
    val file = new FileWriter(recordFieldDetailsPath)
    file.write(fieldDetailsJSON.toString)
    file.flush()
    file.close()
  }

  @throws[SDKException]
  private def getModules(header: String): JSONObject = {
    val apiNames = new JSONObject()
    val headerHashMap = new HeaderMap
    val parameterMap = new ParameterMap
    if (header != null) {
      val headerValue = OffsetDateTime.ofInstant(Instant.ofEpochMilli(header.toLong), ZoneId.systemDefault).withNano(0)
      headerHashMap.add(new GetModulesHeader().IfModifiedSince, headerValue)
    }
    val responseOption = new ModulesOperations().getModules(Option(parameterMap), Option(headerHashMap))
    if (responseOption.isDefined) {
      val response = responseOption.get
      if (util.Arrays.asList(Constants.NO_CONTENT_STATUS_CODE, Constants.NOT_MODIFIED_STATUS_CODE).contains(response.getStatusCode)) return apiNames
      // Check if expected response is received
      if (response.isExpected) {
        val responseObject = response.getObject
        responseObject match {
          case wrapper: modules.ResponseWrapper =>
            val modules = wrapper.getModules()
            for (module <- modules) {
              if (module.getAPISupported().get) {
                val moduleDetails = new JSONObject()
                moduleDetails.put(Constants.API_NAME, module.getAPIName().get)
                moduleDetails.put(Constants.GENERATED_TYPE, module.getGeneratedType().getValue)
                apiNames.put(module.getAPIName().get.toLowerCase(), moduleDetails)
              }
            }
          case _ => responseObject match {
            case exception: modules.APIException =>
              val errorResponse = new JSONObject
              errorResponse.put(Constants.CODE, exception.getCode().getValue)
              errorResponse.put(Constants.STATUS, exception.getStatus().getValue)
              errorResponse.put(Constants.MESSAGE, exception.getMessage())
              throw new SDKException(Constants.API_EXCEPTION, errorResponse)
            case _ =>
          }
        }
      }
    }
    if (header == null) {
      try {
        val resourcesPath = new File(Initializer.getInitializer.getResourcePath + File.separator + Constants.FIELD_DETAILS_DIRECTORY)
        if (!resourcesPath.exists()) resourcesPath.mkdirs
        writeModuleMetaData(getFileName, apiNames)
      } catch {
        case ex: IOException =>
          throw new SDKException(Constants.EXCEPTION, ex)
      }
    }
    apiNames
  }

  @throws[SDKException]
  def refreshModules(): Unit = {
    forceRefresh = true
    getFieldsInfo(null, null)
    forceRefresh = false
  }

  def getJSONObject(json: JSONObject, key: String): Option[JSONObject] = {
    val iterator = json.keySet.iterator
    while ( {
      iterator.hasNext
    }) {
      val keyInJSON = iterator.next
      if (keyInJSON.equalsIgnoreCase(key)) return Option(json.getJSONObject(keyInJSON))
    }
    None
  }

  private def setDataType(fieldDetail: JSONObject, field: Fields, moduleAPIName: String): Unit = {
    val apiType = field.getDataType().orNull
    val keyName = field.getAPIName().orNull
    var module = new MinifiedModule
    if (field.getSystemMandatory().isDefined && (field.getSystemMandatory().get.isInstanceOf[Boolean] && field.getSystemMandatory().get) && !(moduleAPIName.equalsIgnoreCase(Constants.CALLS) && keyName.equalsIgnoreCase(Constants.CALL_DURATION))) {
      fieldDetail.put(Constants.REQUIRED, true)
    }
    if (keyName.equalsIgnoreCase(Constants.PRICING_DETAILS) && moduleAPIName.equalsIgnoreCase(Constants.PRICE_BOOKS)) {
      fieldDetail.put(Constants.NAME, keyName)
      fieldDetail.put(Constants.TYPE, Constants.LIST_NAMESPACE)
      fieldDetail.put(Constants.STRUCTURE_NAME, Constants.PRICINGDETAILS)
      fieldDetail.put(Constants.SKIP_MANDATORY, true)
      return
    }
    else if (keyName.equalsIgnoreCase(Constants.PARTICIPANT_API_NAME) && (moduleAPIName.equalsIgnoreCase(Constants.EVENTS) || moduleAPIName.equalsIgnoreCase(Constants.ACTIVITIES))) {
      fieldDetail.put(Constants.NAME, keyName)
      fieldDetail.put(Constants.TYPE, Constants.LIST_NAMESPACE)
      fieldDetail.put(Constants.STRUCTURE_NAME, Constants.PARTICIPANTS)
      fieldDetail.put(Constants.SKIP_MANDATORY, true)
      return
    }
    else if (keyName.equalsIgnoreCase(Constants.COMMENTS) && (moduleAPIName.equalsIgnoreCase(Constants.SOLUTIONS) || moduleAPIName.equalsIgnoreCase(Constants.CASES))) {
      fieldDetail.put(Constants.NAME, keyName)
      fieldDetail.put(Constants.TYPE, Constants.LIST_NAMESPACE)
      fieldDetail.put(Constants.STRUCTURE_NAME, Constants.COMMENT_NAMESPACE)
      fieldDetail.put(Constants.LOOKUP, true)
      return
    }
    else if (keyName.equalsIgnoreCase(Constants.LAYOUT)) {
      fieldDetail.put(Constants.NAME, keyName)
      fieldDetail.put(Constants.TYPE, Constants.LAYOUT_NAMESPACE)
      fieldDetail.put(Constants.STRUCTURE_NAME, Constants.LAYOUT_NAMESPACE)
      fieldDetail.put(Constants.LOOKUP, true)
      return
    }
    else if ((keyName.equalsIgnoreCase(Constants.TERRITORIES) || keyName.equalsIgnoreCase(Constants.TERRITORY)) && field.getCustomField() != null && !field.getCustomField().get) {
      fieldDetail.put(Constants.NAME, keyName)
      fieldDetail.put(Constants.TYPE, Constants.LIST_NAMESPACE)
      fieldDetail.put(Constants.STRUCTURE_NAME, Constants.TERRITORY_NAMESPACE)
      fieldDetail.put(Constants.LOOKUP, true)
      return
    }
    else if (keyName.equalsIgnoreCase(Constants.PRODUCT_NAME) && Constants.INVENTORY_MODULES_ITEMS.contains(moduleAPIName.toLowerCase())) {
      fieldDetail.put(Constants.NAME, keyName)
      fieldDetail.put(Constants.TYPE, Constants.LINEITEM_PRODUCT)
      fieldDetail.put(Constants.STRUCTURE_NAME, Constants.LINEITEM_PRODUCT)
      fieldDetail.put(Constants.SKIP_MANDATORY, true)
      return
    }
    else if (keyName.equalsIgnoreCase(Constants.DISCOUNT) && Constants.INVENTORY_MODULES_ITEMS.contains(moduleAPIName.toLowerCase())) {
      fieldDetail.put(Constants.NAME, keyName)
      fieldDetail.put(Constants.TYPE, Constants.STRING_NAMESPACE)
      return
    }
    else if (keyName.equalsIgnoreCase(Constants.TAX) && moduleAPIName.toLowerCase() == Constants.PRODUCTS.toLowerCase()) {
      fieldDetail.put(Constants.NAME, keyName)
      fieldDetail.put(Constants.TYPE, Constants.LIST_NAMESPACE)
      fieldDetail.put(Constants.STRUCTURE_NAME, Constants.TAX_NAMESPACE)
      return
    }
    else if (apiTypeVsDataType.keySet.contains(apiType)) {
      fieldDetail.put(Constants.TYPE, apiTypeVsDataType(apiType))
    }
    else if (apiType.equalsIgnoreCase(Constants.FORMULA)) {
      if (field.getFormula().isDefined) {
        val returnType = field.getFormula().get.getReturnType().orNull
        val apiDataType = apiTypeVsDataType.get(returnType) match {
          case Some(value) => value
          case _ => null
        }
        if (apiDataType != null) fieldDetail.put(Constants.TYPE, apiDataType)
      }
      fieldDetail.put(Constants.READ_ONLY, true)
    }
    else if (apiType.equalsIgnoreCase(Constants.ROLLUP_SUMMARY)) {
      if (field.getRollupSummary().isDefined) {
        val returnType = field.getRollupSummary().get.getReturnType().orNull
        val apiDataType = apiTypeVsDataType.get(returnType) match {
          case Some(value) => value
          case _ => null
        }
        val jsonType = field.getJsonType().orNull
        val jsonType1 = apiTypeVsDataType.get(jsonType) match {
          case Some(value) => value
          case _ => null
        }
        if (apiDataType != null) {
          fieldDetail.put(Constants.TYPE, apiDataType)
        }
        else if (jsonType1 != null) {
          fieldDetail.put(Constants.TYPE, jsonType1)
        }
      }
    }
    else return
    if (apiType.toLowerCase.contains(Constants.LOOKUP)) {
      fieldDetail.put(Constants.LOOKUP, true)
    }
    if (apiType.toLowerCase.equalsIgnoreCase(Constants.CONSENT_LOOKUP) || apiType.toLowerCase().equalsIgnoreCase(Constants.OWNER_LOOKUP)) {
      fieldDetail.put(Constants.SKIP_MANDATORY, true)
    }
    if (apiType.toLowerCase().equalsIgnoreCase(Constants.MULTI_SELECT_LOOKUP)) {
      fieldDetail.put(Constants.SKIP_MANDATORY, true)
      if (field.getMultiselectlookup() != null && field.getMultiselectlookup().isDefined) {
        val linkingDetails = field.getMultiselectlookup().get.getLinkingDetails()
        if (linkingDetails != null && linkingDetails.isDefined) {
          val linkingModule = linkingDetails.get.getModule()
          if (linkingModule != null && linkingModule.isDefined) {
            fieldDetail.put(Constants.MODULE.toLowerCase, linkingModule.get.getAPIName())
            module = new MinifiedModule
            module.setAPIName(linkingModule.get.getAPIName())
            module.setId(linkingModule.get.getId())
          }
        }
      }
      fieldDetail.put(Constants.SUBFORM, true)
    }
    if (apiType.toLowerCase().equalsIgnoreCase(Constants.MULTI_USER_LOOKUP)) {
      fieldDetail.put(Constants.SKIP_MANDATORY, true)
      if (field.getMultiuserlookup() != null && field.getMultiuserlookup().isDefined) {
        val linkingDetails = field.getMultiuserlookup().get.getLinkingDetails()
        if (linkingDetails != null && linkingDetails.isDefined) {
          val linkingModule = linkingDetails.get.getModule()
          if (linkingModule != null && linkingModule.isDefined) {
            fieldDetail.put(Constants.MODULE.toLowerCase, linkingModule.get.getAPIName())
            module = new MinifiedModule
            module.setAPIName(linkingModule.get.getAPIName())
            module.setId(linkingModule.get.getId())
          }
        }
      }
      fieldDetail.put(Constants.SUBFORM, true)
    }
    if (apiType.toLowerCase.equalsIgnoreCase(Constants.MULTI_MODULE_LOOKUP)) {
      fieldDetail.put(Constants.SKIP_MANDATORY, true)
    }
    if (apiTypeVsStructureName.contains(apiType)) {
      fieldDetail.put(Constants.STRUCTURE_NAME, apiTypeVsStructureName(apiType))
    }
    if (apiType.equalsIgnoreCase(Constants.PICKLIST) && (field.getPickListValues() != null && field.getPickListValues().nonEmpty)) {
      fieldDetail.put(Constants.PICKLIST, true)
      val values = new JSONArray()
      for (plv <- field.getPickListValues()) {
        values.put(plv.getDisplayValue().get)
      }
      fieldDetail.put(Constants.VALUES, values)
    }
    if (apiType.equalsIgnoreCase(Constants.SUBFORM)) {
      module.setAPIName(field.getAssociatedModule().get.getModule())
      fieldDetail.put(Constants.MODULE.toLowerCase, module.getAPIName().get)
      fieldDetail.put(Constants.SKIP_MANDATORY, true)
      fieldDetail.put(Constants.SUBFORM, true)
    }
    if (apiType.equalsIgnoreCase(Constants.LOOKUP) && field.getLookup() != null && field.getLookup().isDefined) {
      val module1 = field.getLookup().get.getModule().orNull
      if (module1 != null && !module1.getAPIName().get.equalsIgnoreCase(Constants.SE_MODULE)) {
        module.setAPIName(module1.getAPIName())
        module.setId(module1.getId())
        fieldDetail.put(Constants.MODULE.toLowerCase, module1.getAPIName().get)
        if (module1.getAPIName().get.equalsIgnoreCase(Constants.ACCOUNTS) && !field.getCustomField().get) {
          fieldDetail.put(Constants.SKIP_MANDATORY, true)
        }
      }
      else module = new MinifiedModule
      fieldDetail.put(Constants.LOOKUP, true)
    }
    if (module != null && module.getAPIName().isDefined && module.getAPIName().get != null&& module.getAPIName().get.nonEmpty) {
      getFieldsInfo(module.getAPIName().get, null)
    }
    fieldDetail.put(Constants.NAME, keyName)
  }

  private def fillDatatype(): Unit = {
    if (apiTypeVsDataType.nonEmpty) return
    val fieldAPINamesString = Array[String]("textarea", "text", "website", "email", "phone", "mediumtext", "profileimage", "autonumber") // No I18N
    val fieldAPINamesInteger = Array[String]("integer")
    val fieldAPINamesBoolean = Array[String]("boolean")
    val fieldAPINamesLong = Array[String]("long", "bigint")
    val fieldAPINamesDouble = Array[String]("double", "percent", "currency")
    val fieldAPINamesFieldFile = Array[String]("fileupload")
    val fieldAPINamesDateTime = Array[String]("datetime", "event_reminder")
    val fieldAPINamesDate = Array[String]("date")
    val fieldAPINamesLookup = Array[String]("lookup")
    val fieldAPINamesPickList = Array[String]("picklist")
    val fieldAPINamesMultiSelectPickList = Array[String]("multiselectpicklist")
    val fieldAPINamesSubForm = Array[String]("subform")
    val fieldAPINamesOwnerLookUp = Array[String]("ownerlookup", "userlookup")
    val fieldAPINamesMultiUserLookUp = Array[String]("multiuserlookup")
    val fieldAPINameTaskRemindAt = Array[String]("ALARM")
    val fieldAPINameRecurringActivity = Array[String]("RRULE")
    val fieldAPINameReminder = Array[String]("multireminder")
    val fieldAPINameConsentLookUp = Array[String]("consent_lookup")
    val fieldAPINameImageUpload = Array[String]("imageupload")
    val fieldAPInameMultiSelectLookUp = Array[String]("multiselectlookup")
    val fieldAPINameLineTax = Array[String]("linetax")
    val fieldAPINamesModule = Array[String]("module")
    val fieldAPINamesLayout = Array[String]("layout")
    val fieldAPINamesMultiModuleLookUp = Array[String]("multi_module_lookup")
    val fieldAPINamesTimeRange = Array[String]("time_range")
    for (fieldAPIName <- fieldAPINamesString) {
      apiTypeVsDataType.put(fieldAPIName, Constants.STRING_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesInteger) {
      apiTypeVsDataType.put(fieldAPIName, Constants.INTEGER_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesBoolean) {
      apiTypeVsDataType.put(fieldAPIName, Constants.BOOLEAN_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesLong) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LONG_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesDouble) {
      apiTypeVsDataType.put(fieldAPIName, Constants.DOUBLE_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesDateTime) {
      apiTypeVsDataType.put(fieldAPIName, Constants.DATETIME_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesDate) {
      apiTypeVsDataType.put(fieldAPIName, Constants.DATE_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesLookup) {
      apiTypeVsDataType.put(fieldAPIName, Constants.RECORD_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.RECORD_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesPickList) {
      apiTypeVsDataType.put(fieldAPIName, Constants.CHOICE_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesMultiSelectPickList) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LIST_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.CHOICE_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesSubForm) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LIST_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.RECORD_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesOwnerLookUp) {
      apiTypeVsDataType.put(fieldAPIName, Constants.USER_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.USER_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesMultiUserLookUp) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LIST_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.RECORD_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesFieldFile) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LIST_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.FIELD_FILE_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINameTaskRemindAt) {
      apiTypeVsDataType.put(fieldAPIName, Constants.REMINDAT_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.REMINDAT_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINameRecurringActivity) {
      apiTypeVsDataType.put(fieldAPIName, Constants.RECURRING_ACTIVITY_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.RECURRING_ACTIVITY_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINameReminder) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LIST_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.REMINDER_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINameConsentLookUp) {
      apiTypeVsDataType.put(fieldAPIName, Constants.CONSENT_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.CONSENT_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINameImageUpload) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LIST_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.IMAGEUPLOAD_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPInameMultiSelectLookUp) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LIST_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.RECORD_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINameLineTax) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LIST_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.LINE_TAX_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesModule) {
      apiTypeVsDataType.put(fieldAPIName, Constants.MODULE_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.MODULE_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesMultiModuleLookUp) {
      apiTypeVsDataType.put(fieldAPIName, Constants.RECORD_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.MODULE_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesLayout) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LAYOUT_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.LAYOUT_NAMESPACE)
    }
    for (fieldAPIName <- fieldAPINamesTimeRange) {
      apiTypeVsDataType.put(fieldAPIName, Constants.LIST_NAMESPACE)
      apiTypeVsStructureName.put(fieldAPIName, Constants.TIME_RANGE_NAMESPACE)
    }
  }

  @throws[Exception]
  @throws[SDKException]
  def getUserName(token: String): String = {
    var userName: String = null
    val paramInstance = new ParameterMap
    paramInstance.add(new GetUsersParam().type1, Constants.CURRENTUSER)
    val headerInstance = new HeaderMap
    val handlerInstance = new CommonAPIHandler
    var apiPath = new String
    apiPath = apiPath.concat("/crm/v8/users")
    handlerInstance.setAPIPath(apiPath)
    handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
    handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ)
    handlerInstance.setParam(Option(paramInstance))
    headerInstance.add(new Header[String](Constants.AUTHORIZATION, Constants.STRING_NAMESPACE), Constants.OAUTH_HEADER_PREFIX + token)
    handlerInstance.setHeader(Option(headerInstance))
    val responseOption = handlerInstance.apiCall(classOf[com.zoho.crm.api.users.ResponseHandler], "application/json")
    if (responseOption.isDefined) {
      val response = responseOption.get
      if (response != null) {
        if (util.Arrays.asList(204, 304).contains(response.getStatusCode)) return null
        if (response.isExpected) {
          val responseHandler = response.getObject
          responseHandler match {
            case _: users.ResponseWrapper =>
              val responseWrapper = responseHandler.asInstanceOf[com.zoho.crm.api.users.ResponseWrapper]
              val users = responseWrapper.getUsers()
              breakable {
                for (user <- users) {
                  userName = user.getEmail().get
                  break
                }
              }
            case _: users.APIException =>
              val exception = responseHandler.asInstanceOf[users.APIException]
              val errorResponse = new JSONObject()
              errorResponse.put(Constants.CODE, exception.getCode().getValue)
              errorResponse.put(Constants.STATUS, exception.getStatus().getValue)
              errorResponse.put(Constants.MESSAGE, exception.getMessage())
              throw new SDKException(Constants.API_EXCEPTION, errorResponse)
            case _ =>
          }
        }
      }
    }
    val orgID = getUserOrgID(token)
    if (userName == null || orgID == null) {
      return null
    }
    userName + ":" + getUserOrgID(token)
  }

  @throws[Exception]
  @throws[SDKException]
  private def getUserOrgID(token: String): String = {
    var userOrgID: String = null
    val headerInstance = new HeaderMap
    val handlerInstance = new CommonAPIHandler
    var apiPath = new String
    apiPath = apiPath.concat("/crm/v8/org")
    handlerInstance.setAPIPath(apiPath)
    handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_GET)
    handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_READ)
    headerInstance.add(new Header[String](Constants.AUTHORIZATION, Constants.STRING_NAMESPACE), Constants.OAUTH_HEADER_PREFIX + token)
    handlerInstance.setHeader(Option(headerInstance))
    val responseOption = handlerInstance.apiCall(classOf[com.zoho.crm.api.org.ResponseHandler], "application/json")
    if (responseOption.isDefined) {
      val response = responseOption.get
      if (response != null) {
        if (util.Arrays.asList(204, 304).contains(response.getStatusCode)) return null
        if (response.isExpected) {
          val responseHandler = response.getObject
          responseHandler match {
            case responseWrapper: com.zoho.crm.api.org.ResponseWrapper =>
              val orgs = responseWrapper.getOrg()
              breakable {
                for (org <- orgs) {
                  userOrgID = org.getZgid().get
                  break
                }
              }
            case exception: com.zoho.crm.api.org.APIException =>
              val errorResponse = new JSONObject()
              errorResponse.put(Constants.CODE, exception.getCode().getValue)
              errorResponse.put(Constants.STATUS, exception.getStatus().getValue)
              errorResponse.put(Constants.MESSAGE, exception.getMessage())
              throw new SDKException(Constants.API_EXCEPTION, errorResponse)
            case _ =>
          }
        }
      }
    }
    userOrgID
  }
}
