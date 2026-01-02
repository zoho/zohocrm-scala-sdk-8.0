package samples.ziaorgenrichment

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.{Initializer, ParameterMap, dc}
import com.zoho.crm.api.ziaorgenrichment.{ResponseWrapper, APIException, ResponseHandler, ZiaOrgEnrichmentOperations}
import com.zoho.crm.api.util.{APIResponse, Model}

object GetZiaOrgEnrichments {

  @throws[Exception]
  private def getZiaOrgEnrichments(): Unit = {
    val ziaOrgEnrichmentOperations = new ZiaOrgEnrichmentOperations()
    val paramInstance = new ParameterMap()
    val response: Option[APIResponse[ResponseHandler]] = ziaOrgEnrichmentOperations.getZiaOrgEnrichments(Option(paramInstance))

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
                val ziaOrgEnrichments = responseWrapper.getZiaOrgEnrichment()
                if (ziaOrgEnrichments != null) {
                  ziaOrgEnrichments.foreach { ziaOrgEnrichment =>
                    println(s"ZiaOrgEnrichment CreatedTime: ${ziaOrgEnrichment.getCreatedTime()}")
                    println(s"ZiaOrgEnrichment Id: ${ziaOrgEnrichment.getId()}")

                    val user = ziaOrgEnrichment.getCreatedBy()
                    if (user != null) {
                      user match {
                        case Some(user_1)=>
                          println(s"ZiaOrgEnrichment User Id: ${user_1.getId()}")
                          println(s"ZiaOrgEnrichment User Name: ${user_1.getName()}")
                      }
                    }

                    println(s"ZiaOrgEnrichment Status: ${ziaOrgEnrichment.getStatus()}")
                  }
                }

                val info = responseWrapper.getInfo()
                if (info != null) {
                  info match {
                    case Some(info_1)=>
                      Option(info_1.getPerPage()).foreach(perPage => println(s"ZiaOrgEnrichment Info PerPage: $perPage"))
                      Option(info_1.getCount()).foreach(count => println(s"ZiaOrgEnrichment Info Count: $count"))
                      Option(info_1.getPage()).foreach(page => println(s"ZiaOrgEnrichment Info Page: $page"))
                      Option(info_1.getMoreRecords()).foreach(moreRecords => println(s"ZiaOrgEnrichment Info MoreRecords: $moreRecords"))
                  }
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

      getZiaOrgEnrichments()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
