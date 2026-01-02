package samples.sharingrules

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.sharingrules._
import com.zoho.crm.api.util.{APIResponse, Choice, Model}
import com.zoho.crm.api.Initializer

import scala.collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer
import scala.util.{Failure, Success, Try}

object UpdateSharingRule {

  def updateSharingRule(id: Long, moduleAPIName: String): Unit = {
    val sharingRulesOperations = new SharingRulesOperations(Option(moduleAPIName))
    val request = new BodyWrapper
    val sharingRules = new ArrayBuffer[SharingRules]()
    val sharingRule = new SharingRules
    sharingRule.setType(new Choice[String]("Record_Owner_Based"))

    val sharedFrom = new Shared
    val resourceFrom = new Resource
    resourceFrom.setId(Option(3477036002L))
    sharedFrom.setResource(Option(resourceFrom))
    sharedFrom.setType(new Choice[String]("groups"))
    sharedFrom.setSubordinates(Option(false))
    sharingRule.setSharedFrom(Option(sharedFrom))

    // Optional Criteria section (commented out in Java code)
    // sharingRule.setType(new Choice[String]("Criteria_Based"))
    // val criteria = new Criteria
    // criteria.setComparator("equal")
    // val field = new com.zoho.crm.api.sharingrules.Field
    // field.setAPIName("Wizard")
    // field.setId(1111195003L)
    // criteria.setField(field)
    // val value = new JSONObject
    // value.put("name", "TestWizards")
    // value.put("id", "11111195001")
    // criteria.setValue(value)
    // sharingRule.setCriteria(criteria)

    sharingRule.setSuperiorsAllowed(Option(false))

    val sharedTo = new Shared
    val resourceTo = new Resource
    resourceTo.setId(Option(3477236002L))
    sharedTo.setResource(Option(resourceTo))
    sharedTo.setType(new Choice[String]("groups"))
    sharedTo.setSubordinates(Option(false))
    sharingRule.setSharedTo(Option(sharedTo))

    sharingRule.setPermissionType(new Choice[String]("read_write_delete"))

    sharingRules.addOne(sharingRule)
    request.setSharingRules(sharingRules)

    val response = sharingRulesOperations.updateSharingRule(id, request)

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
            val fields = responseObject.getClass.getDeclaredFields
            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}:${field.get(responseObject)}")
            }
          }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    try {
      val environment = USDataCenter.PRODUCTION
      val token = new OAuthToken.Builder()
        .clientID("Client_Id")
        .clientSecret("Client_Secret")
        .refreshToken("Refresh_Token")
        .build()

      new Initializer.Builder().environment(environment).token(token).initialize()

      val moduleAPIName = "Leads"
      val id = 34770551001L
      updateSharingRule(id, moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
