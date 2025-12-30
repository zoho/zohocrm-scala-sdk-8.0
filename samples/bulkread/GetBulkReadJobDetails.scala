package samples.bulkread

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.bulkread.{APIException, BulkReadOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.APIResponse

object GetBulkReadJobDetails {

  private def getBulkReadJobDetails(): Unit = {
    val jobId: Long = 1055806000028743001L // Replace with actual job ID
    val bulkReadOperations = new BulkReadOperations()
    val response: Option[APIResponse[ResponseHandler]] = bulkReadOperations.getBulkReadJobDetails(jobId)
    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (List(204, 304).contains(apiResponse.getStatusCode)) {
            println(if (apiResponse.getStatusCode == 204) "No Content" else "Not Modified")
            return
          }
          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case responseWrapper: ResponseWrapper =>
                val jobDetails = responseWrapper.getData()
                
                for (jobDetail <- jobDetails) {
                  println(s"Bulk read Job ID: ${jobDetail.getId()}")
                  println(s"Bulk read Operation: ${jobDetail.getOperation()}")
                  
                  if (jobDetail.getState() != null) {
                    println(s"Bulk read State: ${jobDetail.getState().getValue}")
                  }
                  
                  // Process Result details
                  val resultOption = jobDetail.getResult()
                  if (resultOption.isDefined) {
                    val result = resultOption.get
                    if (result.getPage().isDefined) {
                      println(s"Bulk read Result Page: ${result.getPage().get}")
                    }
                    if (result.getCount().isDefined) {
                      println(s"Bulk read Result Count: ${result.getCount().get}")
                    }
                    if (result.getDownloadUrl().isDefined) {
                      println(s"Bulk read Result Download URL: ${result.getDownloadUrl().get}")
                    }
                    if (result.getPerPage().isDefined) {
                      println(s"Bulk read Result Per_Page: ${result.getPerPage().get}")
                    }
                    if (result.getMoreRecords().isDefined) {
                      println(s"Bulk read Result MoreRecords: ${result.getMoreRecords().get}")
                    }
                  }
                  
                  // Process Query details
                  val queryOption = jobDetail.getQuery()
                  if (queryOption.isDefined) {
                    val query = queryOption.get
                    if (query.getModule().isDefined) {
                      println(s"Bulk read Query Module: ${query.getModule().get}")
                    }
                    if (query.getPage().isDefined) {
                      println(s"Bulk read Query Page: ${query.getPage().get}")
                    }
                    if (query.getCvid().isDefined) {
                      println(s"Bulk read Query cvid: ${query.getCvid().get}")
                    }
                    
                    // Process fields
                    val fields = query.getFields()
                    if (fields != null) {
                      println("Bulk read Query Fields:")
                      fields.foreach(fieldName => println(s"  - $fieldName"))
                    }
                    
                    // Process criteria
                    val criteriaOption = query.getCriteria()
                    if (criteriaOption.isDefined) {
                      println("Query Criteria:")
                      printCriteria(criteriaOption.get)
                    }
                  }
                  
                  // Process CreatedBy User details
                  val createdByOption = jobDetail.getCreatedBy()
                  if (createdByOption.isDefined) {
                    val createdBy = createdByOption.get
                    println(s"Bulk read Created By User-ID: ${createdBy.getId()}")
                    if (createdBy.getName().isDefined) {
                      println(s"Bulk read Created By User-Name: ${createdBy.getName().get}")
                    }
                  }
                  
                  // Process other details
                  if (jobDetail.getCreatedTime().isDefined) {
                    println(s"Bulk read CreatedTime: ${jobDetail.getCreatedTime().get}")
                  }
                  if (jobDetail.getFileType().isDefined) {
                    println(s"Bulk read File Type: ${jobDetail.getFileType().get}")
                  }
                  
                  println("--------------------")
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
                println(s"Message: ${exception.getMessage()}")
            }
          } else {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            for (field <- fields) {
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }
        case None =>
          println("No response received")
      }
    }
  }

  private def printCriteria(criteria: com.zoho.crm.api.bulkread.Criteria): Unit = {
    if (criteria.getAPIName().isDefined) {
      println(s"Bulk read Query Criteria APIName: ${criteria.getAPIName().get}")
    }
    if (criteria.getComparator() != null) {
      println(s"Bulk read Query Criteria Comparator: ${criteria.getComparator().getValue}")
    }
    if (criteria.getValue() != null) {
      println(s"Bulk read Query Criteria Value: ${criteria.getValue().toString}")
    }

    val criteriaGroup = criteria.getGroup()
    if (criteriaGroup != null) {
      criteriaGroup.foreach(printCriteria)
    }

    if (criteria.getGroupOperator() != null) {
      println(s"Bulk read Query Criteria Group Operator: ${criteria.getGroupOperator().getValue}")
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

      getBulkReadJobDetails()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}