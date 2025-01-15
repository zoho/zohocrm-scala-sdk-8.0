package samples.auditlogexport

import java.time.{OffsetDateTime, ZoneOffset}
import java.util.{ArrayList, HashMap, List, Map}
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.auditlogexport.{APIException, ActionHandler, ActionWrapper, AuditLogExport, AuditLogExportOperations, BodyWrapper, Criteria, Field, SuccessResponse}
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.APIResponse

import scala.collection.mutable.ArrayBuffer

object CreateAuditLogExport {

  def createAuditLogExport(): Unit = {
    val auditLogExportOperations = new AuditLogExportOperations()
    val request = new BodyWrapper()
    val auditLogExports = new ArrayBuffer[AuditLogExport]()
    val auditLogExport = new AuditLogExport()

    val criteria = new Criteria()
    criteria.setComparator(Option("between"))

    val field = new Field()
    field.setAPIName(Option("audited_time"))
    criteria.setField(Option(field))

    val values = new ArrayBuffer[OffsetDateTime]()
    values.addOne(OffsetDateTime.of(2024, 1, 2, 10, 0, 0, 0, ZoneOffset.of("+05:30")))
    values.addOne(OffsetDateTime.of(2024, 1, 3, 10, 0, 0, 0, ZoneOffset.of("+05:30")))
    criteria.setValue(values)

    auditLogExport.setCriteria(Option(criteria))
    auditLogExports.addOne(auditLogExport)
    request.setAuditLogExport(auditLogExports)

    val response: Option[APIResponse[ActionHandler]] = auditLogExportOperations.createAuditlogExport(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getAuditLogExport
                for (actionResponse <- actionResponses) {
                  actionResponse match {
                    case successResponse: SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus.getValue}")
                      println(s"Code: ${successResponse.getCode.getValue}")
                      println("Details: ")
                      successResponse.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"$key: $value")
                        }
                      }
                      println(s"Message: ${successResponse.getMessage}")

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
          } else {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            for (field <- fields) {
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

      createAuditLogExport()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}
