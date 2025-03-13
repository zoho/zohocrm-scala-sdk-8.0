package samples.recordshareemails

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.recordshareemail.{APIException, ActionWrapper, RecordShareEmailOperations, SuccessResponse}

object ShareEmails {
  def shareEmails(moduleAPIName: String, id: Long): Unit = {
    val recordShareEmailOperations = new RecordShareEmailOperations(moduleAPIName)
    val response = recordShareEmailOperations.shareEmails(id)
    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getData
                for (actionResponse <- actionResponses) {
                  actionResponse match {
                    case successResponse: SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus.getValue}")
                      println(s"Code: ${successResponse.getCode.getValue}")
                      println("Details: ")
                      successResponse.getDetails.foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"$key: $value")
                        }
                      }
                      println(s"Message: ${successResponse.getMessage.getValue}")

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

                    case _ =>
                      println("Unexpected ActionResponse type")
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
                println(s"Message: ${exception.getMessage.getValue}")

              case _ =>
                println("Unexpected ActionHandler type")
            }
          } else {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
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

      shareEmails("Leads", 32321232L)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
