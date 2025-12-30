package samples.contactroles

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.contactroles.{APIException, ContactRolesOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetRoles {

  @throws[Exception]
  private def getRoles(): Unit = {
    val contactRolesOperations = new ContactRolesOperations()
    val response: Option[APIResponse[ResponseHandler]] = contactRolesOperations.getRoles()

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
                val contactRoles = responseWrapper.getContactRoles()
                if (contactRoles != null) {
                  contactRoles.foreach { contactRole =>
                    println(s"ContactRole ID: ${contactRole.getId()}")
                    if (contactRole.getName().isDefined) {
                      println(s"ContactRole Name: ${contactRole.getName().get}")
                    }
                    if (contactRole.getSequenceNumber().isDefined) {
                      println(s"ContactRole SequenceNumber: ${contactRole.getSequenceNumber().get}")
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

      getRoles()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}