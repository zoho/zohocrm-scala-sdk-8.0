package samples.modules

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.modules.{ActionHandler, ActionResponse, ActionWrapper, APIException, BodyWrapper, Modules, ModulesOperations, SuccessResponse}
import com.zoho.crm.api.profiles.MinifiedProfile
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

import scala.collection.mutable.ArrayBuffer

object UpdateModuleByAPIName {

  @throws[Exception]
  private def updateModuleByAPIName(): Unit = {
    val moduleAPIName = "Leads" // Replace with actual module API name
    val modulesOperations = new ModulesOperations()
    val modules = new ArrayBuffer[Modules]()
    val profiles = new ArrayBuffer[MinifiedProfile]()
    
    // Create profile instance
    val profile = new MinifiedProfile()
    profile.setId(Option(3477061000000026014L)) // Replace with actual profile ID
    profiles.addOne(profile)
    
    val module = new Modules()
    module.setProfiles(profiles)
    modules.addOne(module)
    
    val request = new BodyWrapper()
    request.setModules(modules)
    
    val response: Option[APIResponse[ActionHandler]] = modulesOperations.updateModuleByAPIName(moduleAPIName, request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject

            responseHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getModules()
                if (actionResponses != null) {
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
                      if (successResponse.getMessage() != null) {
                        println(s"Message: ${successResponse.getMessage().getValue}")
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
                      println("Unexpected action response type")
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

      updateModuleByAPIName()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}