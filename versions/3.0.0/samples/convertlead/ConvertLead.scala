package samples.convertlead

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.convertlead.{APIException, ActionHandler, ActionWrapper, BodyWrapper, ConvertLeadOperations, LeadConverter, SuccessResponse}
import com.zoho.crm.api.record.Field.Deals
import com.zoho.crm.api.record.Record
import com.zoho.crm.api.util.{APIResponse, Choice}
import com.zoho.crm.api.util.Model

import scala.collection.mutable.ArrayBuffer

object ConvertLead {

  @throws[Exception]
  private def convertLead(leadId: Long): Unit = {
    val convertLeadOperations = new ConvertLeadOperations(leadId)
    val bodyWrapper = new BodyWrapper()
    val leadConverters = ArrayBuffer[LeadConverter]()
    val leadConverter = new LeadConverter()
    leadConverter.setOverwrite(Option(true))
    leadConverter.setNotifyLeadOwner(Option(true))
    leadConverter.setNotifyNewEntityOwner(Option(true))
    val accounts = new Record()
    accounts.setId(Option(34770607004L))
    leadConverter.setAccounts(Option(accounts))
    val contacts = new Record()
    contacts.setId(Option(1055806000000002179L))
    leadConverter.setContacts(Option(contacts))
    val deals = new Record()
    deals.addFieldValue(new Deals().DealName, "Converted Deal")
    deals.addFieldValue(new Deals().Stage, new Choice("Closed Won"))
    deals.addFieldValue(new Deals().Amount, 50000.0)
    deals.addFieldValue(new Deals().ClosingDate, java.time.LocalDate.now().plusDays(30))
    deals.addFieldValue(new Deals().Probability, 100)
    deals.addFieldValue(new Deals().LeadSource, new Choice("Advertisement"))
    deals.addFieldValue(new Deals().Description, "Deal created from lead conversion")
    leadConverter.setDeals(Option(deals))

    leadConverters += leadConverter
    bodyWrapper.setData(leadConverters)

    val response: Option[APIResponse[ActionHandler]] = convertLeadOperations.convertLead(bodyWrapper)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getData()
                actionResponses.foreach {
                  case successResponse: SuccessResponse =>
                    println(s"Status: ${successResponse.getStatus().getValue}")
                    println(s"Code: ${successResponse.getCode().getValue}")
                    println("Details: ")
                    successResponse.getDetails().foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"$key: $value")
                      }
                    }
                    println(s"Message: ${successResponse.getMessage().getValue}")

                  case exception: APIException =>
                    println(s"Status: ${exception.getStatus().getValue}")
                    println(s"Code: ${exception.getCode().getValue}")
                    println("Details: ")
                    exception.getDetails().foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"$key: $value")
                      }
                    }
                    println(s"Message: ${exception.getMessage().getValue}")
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
                println(s"Message: ${exception.getMessage().getValue}")

              case responseObject: Model =>
                val fields = responseObject.getClass.getDeclaredFields
                fields.foreach { field =>
                  field.setAccessible(true)
                  println(s"${field.getName}: ${field.get(responseObject)}")
                }
            }
          } else {
            val responseObject: Any = apiResponse.getModel
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
        .clientID("Client_Id")
        .clientSecret("Client_Secret")
        .refreshToken("Refresh_Token")
        .build()

      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      val leadId = 1055806000028754072L
      convertLead(leadId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}