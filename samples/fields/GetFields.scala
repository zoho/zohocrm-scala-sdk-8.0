package samples.fields

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.fields.FieldsOperations.GetFieldsParam
import com.zoho.crm.api.fields.{APIException, FieldsOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetFields {

  @throws[Exception]
  private def getFields(): Unit = {
    val fieldsOperations = new FieldsOperations()
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetFieldsParam().module, "Leads")
    val response: Option[APIResponse[ResponseHandler]] = fieldsOperations.getFields(Option(paramInstance))
    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }

          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject

            responseHandler match {
              case responseWrapper: ResponseWrapper =>
                val fields = responseWrapper.getFields()
                if (fields != null) {
                  fields.foreach { field =>
                    println(s"Field ID: ${field.getId()}")
                    if (field.getAPIName().isDefined) {
                      println(s"Field API Name: ${field.getAPIName().get}")
                    }
                    if (field.getFieldLabel().isDefined) {
                      println(s"Field Label: ${field.getFieldLabel().get}")
                    }
                    if (field.getDisplayLabel().isDefined) {
                      println(s"Field Display Label: ${field.getDisplayLabel().get}")
                    }
                    if (field.getDataType().isDefined) {
                      println(s"Field Data Type: ${field.getDataType().get}")
                    }
                    if (field.getLength().isDefined) {
                      println(s"Field Length: ${field.getLength().get}")
                    }
                    if (field.getReadOnly().isDefined) {
                      println(s"Field ReadOnly: ${field.getReadOnly().get}")
                    }
                    if (field.getCustomField().isDefined) {
                      println(s"Field Custom: ${field.getCustomField().get}")
                    }
                    if (field.getVisible().isDefined) {
                      println(s"Field Visible: ${field.getVisible().get}")
                    }
                    if (field.getSystemMandatory().isDefined) {
                      println(s"Field System Mandatory: ${field.getSystemMandatory().get}")
                    }
                    if (field.getWebhook().isDefined) {
                      println(s"Field Webhook: ${field.getWebhook().get}")
                    }
                    if (field.getSequenceNumber().isDefined) {
                      println(s"Field Sequence Number: ${field.getSequenceNumber().get}")
                    }
                    if (field.getDefaultValue().isDefined) {
                      println(s"Field Default Value: ${field.getDefaultValue().get}")
                    }
                    if (field.getCreatedTime().isDefined) {
                      println(s"Field Created Time: ${field.getCreatedTime().get}")
                    }
                    if (field.getModifiedTime().isDefined) {
                      println(s"Field Modified Time: ${field.getModifiedTime().get}")
                    }
                    if (field.getPickListValues() != null && field.getPickListValues().nonEmpty) {
                      println("Pick List Values:")
                      field.getPickListValues().foreach { pickListValue =>
                        if (pickListValue.getDisplayValue().isDefined) {
                          println(s"  Display Value: ${pickListValue.getDisplayValue().get}")
                        }
                        if (pickListValue.getSequenceNumber().isDefined) {
                          println(s"  Sequence Number: ${pickListValue.getSequenceNumber().get}")
                        }
                        if (pickListValue.getExpectedDataType().isDefined) {
                          println(s"  Expected Data Type: ${pickListValue.getExpectedDataType().get}")
                        }
                      }
                    }
                    println("--------------------")
                  }
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage()}")

              case _ =>
                println("Unexpected response handler")
            }
          } else {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields

            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }

        case None =>
          println("No response received")
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: Environment = INDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("client_id")
        .clientSecret("client_secret")
        .grantToken("grant_token")
        .build()
      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      getFields()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}