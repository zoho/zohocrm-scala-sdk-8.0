package samples.massdeletetags

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{Initializer, ParameterMap}
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.massdeletetags.MassDeleteTagsOperations.GetStatusParam
import com.zoho.crm.api.massdeletetags.{APIException, MassDeleteDetails, MassDeleteTagsOperations, StatusResponseHandler, StatusResponseWrapper}
import com.zoho.crm.api.util.{APIResponse, Model}


object GetStatus {

  @throws[Exception]
  def getStatus(): Unit = {
    val massDeleteTagsOperations = new MassDeleteTagsOperations()
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetStatusParam().jobId, "7534770350002")

    val response: Option[APIResponse[StatusResponseHandler]] = massDeleteTagsOperations.getStatus(Option(paramInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case statusResponseWrapper: StatusResponseWrapper =>
                val statusActionResponses = statusResponseWrapper.getMassDelete()
                statusActionResponses.foreach {
                  case massDeleteDetail: MassDeleteDetails =>
                    println(s"Status JobId: ${massDeleteDetail.getJobId()}")
                    println(s"Status TotalCount: ${massDeleteDetail.getTotalCount()}")
                    println(s"Status FailedCount: ${massDeleteDetail.getFailedCount()}")
                    println(s"Status DeletedCount: ${massDeleteDetail.getDeletedCount()}")
                    println(s"Job Status: ${massDeleteDetail.getStatus().getValue}")

                  case apiException: APIException =>
                    println(s"Status: ${apiException.getStatus().getValue}")
                    println(s"Code: ${apiException.getCode().getValue}")
                    println("Details: ")
                    apiException.getDetails().foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"$key: $value")
                      }
                    }
                    println(s"Message: ${apiException.getMessage()}")
                }

              case apiException: APIException =>
                println(s"Status: ${apiException.getStatus().getValue}")
                println(s"Code: ${apiException.getCode().getValue}")
                println("Details: ")
                apiException.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${apiException.getMessage()}")

              case _ =>
                val responseObject: Any = apiResponse.getModel
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

      getStatus()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
