package samples.bulkwrite

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.bulkwrite.{APIException, BulkWriteOperations, BulkWriteResponse, ResponseWrapper}
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.APIResponse

object GetBulkWriteJobDetails {

  private def getBulkWriteJobDetails(): Unit = {
    val jobId = "1055806000028747001" // Replace with actual job ID
    val bulkWriteOperations = new BulkWriteOperations()

    val response: Option[APIResponse[ResponseWrapper]] = bulkWriteOperations.getBulkWriteJobDetails(jobId)

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
              case responseWrapper: BulkWriteResponse =>
                val bulkWriteJob = responseWrapper
                  println(s"Bulk Write Job ID: ${bulkWriteJob.getId()}")
                  if (bulkWriteJob.getOperation().isDefined) {
                    println(s"Operation: ${bulkWriteJob.getOperation().get}")
                  }
                  
                  if (bulkWriteJob.getStatus()!= null) {
                    println(s"Status: ${bulkWriteJob.getStatus()}")
                  }
                  
                  if (bulkWriteJob.getCharacterEncoding().isDefined) {
                    println(s"Character Encoding: ${bulkWriteJob.getCharacterEncoding().get}")
                  }
                  
                  // Process Result details
                  val resultOption = bulkWriteJob.getResult()
                  if (resultOption.isDefined) {
                    val result = resultOption.get
                    if (result.getDownloadUrl().isDefined) {
                      println(s"Download URL: ${result.getDownloadUrl().get}")
                    }
                  }
                  
                  // Process Callback details
                  val callbackOption = bulkWriteJob.getCallback()
                  if (callbackOption.isDefined) {
                    val callback = callbackOption.get
                    if (callback.getUrl().isDefined) {
                      println(s"Callback URL: ${callback.getUrl().get}")
                    }
                    if (callback.getMethod() != null) {
                      println(s"Callback Method: ${callback.getMethod().getValue}")
                    }
                  }
                  
                  // Process Resource details
                  val resources = bulkWriteJob.getResource()
                  if (resources != null) {
                    println("Resources:")
                    for (resource <- resources) {
                      if (resource.getStatus() != null) {
                        println(s"  Resource Status: ${resource.getStatus().getValue}")
                      }
                      if (resource.getType() != null) {
                        println(s"  Resource Type: ${resource.getType().getValue}")
                      }
                      if (resource.getModule().isDefined) {
                        val module = resource.getModule().get
                        if (module.getAPIName().isDefined) {
                          println(s"  Module: ${module.getAPIName().get}")
                        }
                      }
                      if (resource.getFileId().isDefined) {
                        println(s"  File ID: ${resource.getFileId().get}")
                      }
                      if (resource.getIgnoreEmpty().isDefined) {
                        println(s"  Ignore Empty: ${resource.getIgnoreEmpty().get}")
                      }
                      
                      // Process field mappings
                      val fieldMappings = resource.getFieldMappings()
                      if (fieldMappings != null && fieldMappings.nonEmpty) {
                        println("  Field Mappings:")
                        for (fieldMapping <- fieldMappings) {
                          if (fieldMapping.getAPIName().isDefined) {
                            println(s"    API Name: ${fieldMapping.getAPIName().get}")
                          }
                          if (fieldMapping.getIndex().isDefined) {
                            println(s"    Index: ${fieldMapping.getIndex().get}")
                          }
                          val defaultValueOption = fieldMapping.getDefaultValue()
                          if (defaultValueOption.isDefined) {
                            val defaultValue = defaultValueOption.get
                            println(s"    Default Value: ${defaultValue.getValue()}")
                          }
                        }
                      }
                    }
                  }
                  
                  // Process CreatedBy User details
                  val createdByOption = bulkWriteJob.getCreatedBy()
                  if (createdByOption.isDefined) {
                    val createdBy = createdByOption.get
                    println(s"Created By User-ID: ${createdBy.getId()}")
                    if (createdBy.getName().isDefined) {
                      println(s"Created By User-Name: ${createdBy.getName().get}")
                    }
                  }
                  
                  // Process other details
                  if (bulkWriteJob.getCreatedTime().isDefined) {
                    println(s"Created Time: ${bulkWriteJob.getCreatedTime().get}")
                  }
                  
                  println("--------------------")
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

      getBulkWriteJobDetails()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}