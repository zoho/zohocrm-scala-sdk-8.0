package samples.auditlogexport

import com.zoho.crm.api.Initializer
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.auditlogexport.{APIException, AuditLogExportOperations, Criteria, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.util.APIResponse


object GetExportedAuditlog {

  def getExportedAuditlog(id: Long): Unit = {
    val auditLogExportOperations = new AuditLogExportOperations()
    val response: Option[APIResponse[ResponseHandler]] = auditLogExportOperations.getExportedAuditlog(id)

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
                val auditLogExports = responseWrapper.getAuditLogExport
                auditLogExports.foreach { auditLogExport =>
                  val criteria = auditLogExport.getCriteria
                  if (criteria != null) printCriteria(criteria)

                  println(s"AuditLogExport Id : ${auditLogExport.getId}")
                  println(s"AuditLogExport Status : ${auditLogExport.getStatus}")
                  val createdBy = auditLogExport.getCreatedBy
                  if (createdBy != null) {
                    createdBy match {
                      case Some(created_by)=>
                        println(s"AuditLogExport User Id : ${created_by.getId}")
                        println(s"AuditLogExport User Name : ${created_by.getName}")
                    }
                  }
                  val downloadLinks = auditLogExport.getDownloadLinks
                  if (downloadLinks != null) {
                    downloadLinks.foreach(link => println(s"AuditLogExport DownloadLink : $link"))
                    println(s"AuditLogExport JobStartTime : ${auditLogExport.getJobStartTime}")
                    println(s"AuditLogExport JobEndTime : ${auditLogExport.getJobEndTime}")
                    println(s"AuditLogExport ExpiryDate : ${auditLogExport.getExpiryDate}")
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

              case _ =>
                val responseObject = apiResponse.getModel
                responseObject.getClass.getDeclaredFields.foreach { field =>
                  field.setAccessible(true)
                  println(s"${field.getName}: ${field.get(responseObject)}")
                }
            }
          }
      }
    }
  }

  private def printCriteria(criteria: Option[Criteria]): Unit = {
    criteria match {
      case Some(criteria_1) =>
        if (criteria_1.getComparator != null) {
          println(s"ExportedAuditlogs Criteria Comparator: ${criteria_1.getComparator}")
        }
        if (criteria_1.getValue != null) {
          println(s"ExportedAuditlogs Criteria Value: ${criteria_1.getValue}")
        }
        if (criteria_1.getField != null) {
          criteria_1.getField() match {
            case Some(field) =>
              println(s"ExportedAuditlogs Criteria Field Name: ${field.getAPIName}")
          }
        }
        val criteriaGroup = criteria_1.getGroup
        if (criteriaGroup != null)
        {
          criteriaGroup.foreach { criteria_group =>
            printCriteria(Option(criteria_group))
          }
        }
        if (criteria_1.getGroupOperator != null) {
          println(s"ExportedAuditlogs Criteria Group Operator: ${criteria_1.getGroupOperator}")
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

      val id: Long = 7534000347001L
      getExportedAuditlog(id)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
