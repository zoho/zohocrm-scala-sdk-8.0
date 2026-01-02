package samples.sharerecords

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.sharerecords.{APIException, ResponseHandler, ResponseWrapper, ShareRecordsOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.{Initializer, ParameterMap}

object GetSharedRecordDetails {

  @throws[Exception]
  private def getSharedRecordDetails(recordId: Long, moduleAPIName: String): Unit = {
    val shareRecordsOperations = new ShareRecordsOperations(recordId, moduleAPIName)
    
    val paramInstance = new ParameterMap()
//    paramInstance.add(new GetSharedRecordDetailsParam().sharedTo, 34770615791024L)
//    paramInstance.add(new GetSharedRecordDetailsParam().view, "summary")
    
    val response: Option[APIResponse[ResponseHandler]] = shareRecordsOperations.getSharedRecordDetails(
      Option(paramInstance)
    )

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (List(204, 304).contains(apiResponse.getStatusCode)) {
            println(if (apiResponse.getStatusCode == 204) "No Content" else "Not Modified")
            return
          }

          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject

            responseHandler match {
              case responseWrapper: ResponseWrapper =>
                val shareRecords = responseWrapper.getShare()
                if (shareRecords != null) {
                  for (shareRecord <- shareRecords) {

                    val sharedWith = shareRecord.getSharedWith().get
                    if (sharedWith != null) {
                      println(s"ShareRecord sharedWith Name: ${sharedWith.getName()}")
                      println(s"ShareRecord sharedWith Id: ${sharedWith.getId()}")
                      println(s"ShareRecord sharedWith Type: ${sharedWith.getKeyValue("type")}")
                      println(s"ShareRecord sharedWith Zuid: ${sharedWith.getZuid()}")
                    }

                    println(s"ShareRecord ShareRelatedRecords: ${shareRecord.getShareRelatedRecords()}")

                    val sharedThrough = shareRecord.getSharedThrough().get
                    if (sharedThrough != null) {

                      val module = sharedThrough.getModule().get
                      if (module != null) {
                        println(s"ShareRecord SharedThrough Module ID: ${module.getId()}")
                        println(s"ShareRecord SharedThrough Module Name: ${module.getName()}")
                      }

                      println(s"ShareRecord SharedThrough Name: ${sharedThrough.getName()}")
                      println(s"ShareRecord SharedThrough ID: ${sharedThrough.getId()}")
                    }

                    println(s"ShareRecord SharedTime: ${shareRecord.getSharedTime()}")
                    println(s"ShareRecord Permission: ${shareRecord.getPermission()}")

                    if (shareRecord.getSharedBy() != null && shareRecord.getSharedBy().isDefined) {
                      val sharedBy = shareRecord.getSharedBy().get
                      println(s"ShareRecord SharedBy-ID: ${sharedBy.getId()}")
                      println(s"ShareRecord SharedBy-Name: ${sharedBy.getName()}")
                      println(s"ShareRecord SharedBy-Zuid: ${sharedBy.getZuid()}")
                    }

                    if (shareRecord.getUser().isDefined) {
                      val user = shareRecord.getUser().get
                      println(s"ShareRecord User-ID: ${user.getId()}")
                      println(s"ShareRecord User-Name: ${user.getName()}")
                      println(s"ShareRecord User-Zuid: ${user.getZuid()}")
                    }

                    val recordType = shareRecord.getType()
                    if (recordType != null) {
                      println(s"ShareRecord Type: ${recordType.getValue}")
                    }
                  }
                }

                val shareableUsers = responseWrapper.getShareableUser()
                if (shareableUsers != null) {
                  for (shareableUser <- shareableUsers) {
                    println(s"ShareRecord User-ID: ${shareableUser.getId()}")
                    println(s"ShareRecord User-FullName: ${shareableUser.getFullName()}")
                    println(s"ShareRecord User-Zuid: ${shareableUser.getZuid()}")
                  }
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"Details: $key -> $value")
                  }
                }
                println(s"Message: ${exception.getMessage()}")

              case _ =>
                println("Unexpected response handler")
            }
          } else {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields

            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }

        case None =>
          println("No response received from GetSharedRecordDetails API.")
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: DataCenter.Environment = INDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("client_id")
        .clientSecret("client_secret")
        .grantToken("grant_token")
        .build()

      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      val recordId = 1055806000028754070L  // Record ID to get shared details for
      val moduleAPIName = "Leads"     // Module API name
      getSharedRecordDetails(recordId, moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}