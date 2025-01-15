package samples.picklistvalues

import java.lang.reflect.Field
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.picklistvalues.{APIException, LayoutAssociation, PickListValues, PickListValuesOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.{APIResponse, Model}

object GetPickListValues {

  def getPickListValues(fieldId: Long, moduleAPIName: String): Unit = {
    val pickListValuesOperations = new PickListValuesOperations(fieldId, Option(moduleAPIName))
    val response: Option[APIResponse[ResponseHandler]] = pickListValuesOperations.getPickListValues()

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
                val pickListValues = responseWrapper.getPickListValues
                if (pickListValues != null){
                  pickListValues.foreach { pickListValue =>
                    println(s"PickListValues SequenceNumber: ${pickListValue.getSequenceNumber}")
                    println(s"PickListValues DisplayValue: ${pickListValue.getDisplayValue}")
                    println(s"PickListValues ReferenceValue: ${pickListValue.getReferenceValue}")
                    println(s"PickListValues ColourCode: ${pickListValue.getColourCode}")
                    println(s"PickListValues ActualValue: ${pickListValue.getActualValue}")
                    println(s"PickListValues Id: ${pickListValue.getId}")
                    println(s"PickListValues Type: ${pickListValue.getType}")

                    val layoutAssociations = pickListValue.getLayoutAssociations
                    if (layoutAssociations != null) {
                      layoutAssociations.foreach { layoutAssociation =>
                        println(s"PickListValues LayoutAssociation Id: ${layoutAssociation.getId}")
                        println(s"PickListValues LayoutAssociation Name: ${layoutAssociation.getName}")
                        println(s"PickListValues LayoutAssociation APIName: ${layoutAssociation.getAPIName}")
                      }
                    }
                  }
                }
              case exception: APIException =>
                println(s"Status: ${exception.getStatus.getValue}")
                println(s"Code: ${exception.getCode.getValue}")
                println("Details: ")
                exception.getDetails.foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage}")
            }
          } else if (apiResponse.getStatusCode != 204) {
            val responseObject: Any = apiResponse.getModel
            val fields: Array[Field] = responseObject.getClass.getDeclaredFields
            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
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

      val moduleAPIName: String = "Leads"
      val fieldId: Long = 753477084001L
      getPickListValues(fieldId, moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
