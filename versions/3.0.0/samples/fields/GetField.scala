package samples.fields

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.fields.FieldsOperations.GetFieldParam
import com.zoho.crm.api.fields.{APIException, FieldsOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetField {

  @throws[Exception]
  private def getField(): Unit = {
    val fieldId = 1055806000025636002L // Replace with actual field ID
    val fieldsOperations = new FieldsOperations()
    val paramInstance = new ParameterMap()
    
    // Add module parameter
    paramInstance.add(new GetFieldParam().module, "Leads")
    
    val response: Option[APIResponse[ResponseHandler]] = fieldsOperations.getField(fieldId, Option(paramInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (List(204, 304).contains(apiResponse.getStatusCode)) {
            println(if (apiResponse.getStatusCode == 204) "No Content" else "Not Modified")
            return
          }

          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject

            responseHandler match {
              case responseWrapper: ResponseWrapper =>
                val fields = responseWrapper.getFields()
                if (fields != null && fields.nonEmpty) {
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
                    if (field.getColumnName().isDefined) {
                      println(s"Field Column Name: ${field.getColumnName().get}")
                    }
                    if (field.getType().isDefined) {
                      println(s"Field Type: ${field.getType().get}")
                    }
                    if (field.getLength().isDefined) {
                      println(s"Field Length: ${field.getLength().get}")
                    }
                    if (field.getDecimalPlace().isDefined) {
                      println(s"Field Decimal Place: ${field.getDecimalPlace().get}")
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
                    if (field.getSearchable().isDefined) {
                      println(s"Field Searchable: ${field.getSearchable().get}")
                    }
                    if (field.getFilterable().isDefined) {
                      println(s"Field Filterable: ${field.getFilterable().get}")
                    }
                    if (field.getSortable().isDefined) {
                      println(s"Field Sortable: ${field.getSortable().get}")
                    }
                    if (field.getMassUpdate().isDefined) {
                      println(s"Field Mass Update: ${field.getMassUpdate().get}")
                    }
                    if (field.getBlueprintSupported().isDefined) {
                      println(s"Field Blueprint Supported: ${field.getBlueprintSupported().get}")
                    }
                    if (field.getLookup().isDefined) {
                      val lookup = field.getLookup().get
                      println("Lookup Details:")
                      if (lookup.getDisplayLabel().isDefined) {
                        println(s"  Display Label: ${lookup.getDisplayLabel().get}")
                      }
                      if (lookup.getModule().isDefined) {
                        val module = lookup.getModule().get
                        if (module.getAPIName().isDefined) {
                          println(s"  Module: ${module.getAPIName().get}")
                        }
                      }
                    }
                    if (field.getPickListValues() != null && field.getPickListValues().nonEmpty) {
                      println("Pick List Values:")
                      field.getPickListValues().foreach { pickListValue =>
                        if (pickListValue.getDisplayValue().isDefined) {
                          println(s"  Display Value: ${pickListValue.getDisplayValue().get}")
                        }
                        if (pickListValue.getActualValue().isDefined) {
                          println(s"  Actual Value: ${pickListValue.getActualValue().get}")
                        }
                        if (pickListValue.getId().isDefined) {
                          println(s"  ID: ${pickListValue.getId().get}")
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

      getField()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}