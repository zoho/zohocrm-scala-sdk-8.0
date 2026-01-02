package samples.sharingrules

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.{DataCenter, USDataCenter}
import com.zoho.crm.api.sharingrules._
import com.zoho.crm.api.util.{APIResponse, Choice, Model}
import org.json.JSONObject

import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

object CreateSharingRules {

  @throws[Exception]
  def createSharingRules(moduleAPIName: String): Unit = {
    val sharingRulesOperations = new SharingRulesOperations(Option(moduleAPIName))
    val request = new BodyWrapper
    val sharingRules = new ArrayBuffer[SharingRules]()
    val sharingRule = new SharingRules()

    sharingRule.setType(new Choice[String]("Record_Owner_Based"))
    val sharedFrom = new Shared
    var resource = new Resource
    resource.setId(Option(347706117236002L))
    sharedFrom.setResource(Option(resource))
    sharedFrom.setType(new Choice[String]("groups"))
    sharedFrom.setSubordinates(Option(false))
    sharingRule.setSharedFrom(Option(sharedFrom))

    /*
    sharingRule.setType(new Choice[String]("Criteria_Based"))
    val criteria = new Criteria
    criteria.setComparator("equal")
    val field = new com.zoho.crm.api.sharingrules.Field
    field.setAPIName("Wizard")
    field.setId(11111195003L)
    criteria.setField(field)
    val value = new JSONObject
    value.put("name", "TestWizards")
    value.put("id", "111111095001")
    criteria.setValue(value)
    sharingRule.setCriteria(criteria)
    */

    sharingRule.setSuperiorsAllowed(Option(false))

    val sharedTo = new Shared
    resource = new Resource
    resource.setId(Option(347706117236002L))
    sharedTo.setResource(Option(resource))
    sharedTo.setType(new Choice[String]("groups"))
    sharedTo.setSubordinates(Option(false))
    sharingRule.setSharedTo(Option(sharedTo))

    sharingRule.setPermissionType(new Choice[String]("read_write_delete"))
    sharingRule.setName(Option("TestJavaSDK"))

    sharingRules.addOne(sharingRule)
    request.setSharingRules(sharingRules)

    val response = sharingRulesOperations.createSharingRules(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }
          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getSharingRules()
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

            }

          } else {
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
      createSharingRules(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
