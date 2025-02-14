package samples.sharingrules

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.{USDataCenter, DataCenter}
import com.zoho.crm.api.sharingrules._
import com.zoho.crm.api.util.{APIResponse, Model}

import scala.jdk.CollectionConverters._

object GetSharingRule {

  @throws[Exception]
  def getSharingRule(moduleAPIName: String, id: Long): Unit = {
    val sharingRulesOperations = new SharingRulesOperations(Option(moduleAPIName))
    val response = sharingRulesOperations.getSharingRule(id)

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
                val sharingRules = responseWrapper.getSharingRules
                sharingRules.foreach { sharingRule =>
                  val module = sharingRule.getModule.get
                  if (module != null) {
                    println(s"SharingRules Module APIName: ${module.getAPIName}")
                    println(s"SharingRules Module Name: ${module.getName}")
                    println(s"SharingRules Module Id: ${module.getId}")
                  }
                  println(s"SharingRules SuperiorsAllowed: ${sharingRule.getSuperiorsAllowed}")
                  println(s"SharingRules Type: ${sharingRule.getType.getValue}")

                  val sharedTo = sharingRule.getSharedTo.get
                  if (sharedTo != null) {
                    val resource = sharedTo.getResource.get
                    if (resource != null) {
                      println(s"SharingRules SharedTo Resource Name: ${resource.getName}")
                      println(s"SharingRules SharedTo Resource Id: ${resource.getId}")
                    }
                    println(s"SharingRules SharedTo Type: ${sharedTo.getType}")
                    println(s"SharingRules SharedTo Subordinates: ${sharedTo.getSubordinates}")
                  }

                  val sharedFrom = sharingRule.getSharedFrom.get
                  if (sharedFrom != null) {
                    val resource = sharedFrom.getResource.get
                    if (resource != null) {
                      println(s"SharingRules SharedFrom Resource Name: ${resource.getName}")
                      println(s"SharingRules SharedFrom Resource Id: ${resource.getId}")
                    }
                    println(s"SharingRules SharedFrom Type: ${sharedFrom.getType}")
                    println(s"SharingRules SharedFrom Subordinates: ${sharedFrom.getSubordinates}")
                  }

                  println(s"SharingRules PermissionType: ${sharingRule.getPermissionType.getValue}")
                  println(s"SharingRules Name: ${sharingRule.getName}")
                  println(s"SharingRules Id: ${sharingRule.getId}")
                  println(s"SharingRules Status: ${sharingRule.getStatus.getValue}")
                  println(s"SharingRules MatchLimitExceeded: ${sharingRule.getMatchLimitExceeded}")
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
                println(s"Message: ${exception.getMessage.getValue}")

              case _ => println("Unexpected response type.")
            }

          } else if (apiResponse.getStatusCode != 204) {
            val responseObject = apiResponse.getModel
            val clazz = responseObject.getClass
            val fields = clazz.getDeclaredFields
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
      val environment: DataCenter.Environment = USDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("Client_Id")
        .clientSecret("Client_Secret")
        .refreshToken("Refresh_Token")
        .build()

      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      val moduleAPIName = "Leads"
      val id = 347706151001L
      getSharingRule(moduleAPIName, id)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
