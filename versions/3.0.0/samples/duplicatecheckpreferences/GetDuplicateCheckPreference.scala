package samples.duplicatecheckpreferences

import com.zoho.crm.api.Initializer
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.duplicatecheckpreference.{ResponseHandler, ResponseWrapper, BodyWrapper, CurrentField, DuplicateCheckPreference, DuplicateCheckPreferenceOperations, FieldMappings, MappedField, MappedModule, TypeConfiguration, SuccessResponse, APIException}
import com.zoho.crm.api.util.APIResponse

object GetDuplicateCheckPreference {

  def getDuplicateCheckPreference(moduleAPIName: String): Unit = {
    val duplicateCheckPreferenceOperations = new DuplicateCheckPreferenceOperations(Option(moduleAPIName))
    val response: Option[APIResponse[ResponseHandler]] = duplicateCheckPreferenceOperations.getDuplicateCheckPreference()

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case responseWrapper: ResponseWrapper =>
                val duplicateCheckPreference = responseWrapper.getDuplicateCheckPreference()
                duplicateCheckPreference match {
                  case Some(duplicateCheckPreference_1)=>
                    println(s"DuplicateCheckPreference Type : ${duplicateCheckPreference_1.getType().getValue}")
                    val typeConfigurations = duplicateCheckPreference_1.getTypeConfigurations()
                    if (typeConfigurations != null){
                      typeConfigurations.foreach { typeConfiguration =>
                        val mappedModule = typeConfiguration.getMappedModule()
                        if (mappedModule != null) {
                          mappedModule match {
                            case Some(mappedModule_1) =>
                              println(s"DuplicateCheckPreference TypeConfiguration MappedModule Id : ${mappedModule_1.getId()}")
                              println(s"DuplicateCheckPreference TypeConfiguration MappedModule Name : ${mappedModule_1.getName()}")
                              println(s"DuplicateCheckPreference TypeConfiguration MappedModule APIName : ${mappedModule_1.getAPIName()}")
                          }
                        }
                        val fieldMappings = typeConfiguration.getFieldMappings()
                        fieldMappings.foreach { fieldMapping =>
                          val currentField = fieldMapping.getCurrentField()
                          if (currentField != null) {
                            currentField match {
                              case Some(currentField_1) =>
                                println(s"DuplicateCheckPreference TypeConfiguration FieldMappings CurrentField Id : ${currentField_1.getId()}")
                                println(s"DuplicateCheckPreference TypeConfiguration FieldMappings CurrentField Name : ${currentField_1.getName()}")
                                println(s"DuplicateCheckPreference TypeConfiguration FieldMappings CurrentField APIName : ${currentField_1.getAPIName()}")
                            }
                          }
                          val mappedField = fieldMapping.getMappedField()
                          if (mappedField != null) {
                            mappedField match {
                              case Some(mappedField_1) =>
                                println(s"DuplicateCheckPreference TypeConfiguration FieldMappings MappedField Id : ${mappedField_1.getId()}")
                                println(s"DuplicateCheckPreference TypeConfiguration FieldMappings MappedField Name : ${mappedField_1.getName()}")
                                println(s"DuplicateCheckPreference TypeConfiguration FieldMappings MappedField APIName : ${mappedField_1.getAPIName()}")
                            }
                          }
                        }
                      }
                    }
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                println("Details: ")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage()}")

              case _ =>
                val responseObject = apiResponse.getModel
                responseObject.getClass.getDeclaredFields.foreach { field =>
                  field.setAccessible(true)
                  println(s"${field.getName}: ${field.get(responseObject)}")
                }
            }
          }
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: Environment = USDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("client_id")
        .clientSecret("client_secret")
        .grantToken("grant_token")
        .build()
      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      val moduleAPIName = "Leads"
      getDuplicateCheckPreference(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
