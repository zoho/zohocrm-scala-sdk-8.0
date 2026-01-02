package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{HeaderMap, Initializer, ParameterMap}
import com.zoho.crm.api.record.{APIException, DeletedRecord, DeletedRecordsHandler, DeletedRecordsWrapper, RecordOperations}
import com.zoho.crm.api.record.RecordOperations.{GetDeletedRecordsHeader, GetDeletedRecordsParam}
import com.zoho.crm.api.dc.{DataCenter, USDataCenter}
import com.zoho.crm.api.util.APIResponse

import java.time.{OffsetDateTime, ZoneOffset}

object GetDeletedRecords {

  @throws[Exception]
  private def getDeletedRecords(moduleAPIName: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetDeletedRecordsParam().type1, "all")
    paramInstance.add(new GetDeletedRecordsParam().page, 1)
    paramInstance.add(new GetDeletedRecordsParam().perPage, 50)
    
    val headerInstance = new HeaderMap()
    val ifModifiedSince = OffsetDateTime.of(2020, 5, 20, 10, 0, 0, 1, ZoneOffset.of("+05:30"))
    headerInstance.add(new GetDeletedRecordsHeader().IfModifiedSince, ifModifiedSince)

    val response: Option[APIResponse[DeletedRecordsHandler]] = recordOperations.getDeletedRecords(Option(paramInstance), Option(headerInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }

          if (apiResponse.isExpected) {
            val deletedRecordsHandler = apiResponse.getObject

            deletedRecordsHandler match {
              case deletedRecordsWrapper: DeletedRecordsWrapper =>
                val deletedRecords = deletedRecordsWrapper.getData()
                if (deletedRecords != null && deletedRecords.nonEmpty) {
                  deletedRecords.foreach { deletedRecord =>
                    if (deletedRecord.getDeletedBy() != null && deletedRecord.getDeletedBy().isDefined) {
                      val deletedBy = deletedRecord.getDeletedBy().get
                      println(s"DeletedRecord Deleted By User-ID: ${deletedBy.getId()}")
                      if (deletedBy.getName().isDefined) {
                        println(s"DeletedRecord Deleted By User-Name: ${deletedBy.getName().get}")
                      }
                      if (deletedBy.getEmail().isDefined) {
                        println(s"DeletedRecord Deleted By User-Email: ${deletedBy.getEmail().get}")
                      }
                    }
                    
                    println(s"DeletedRecord ID: ${deletedRecord.getId()}")
                    
                    if (deletedRecord.getDeletedTime() != null && deletedRecord.getDeletedTime().isDefined) {
                      println(s"DeletedRecord DeletedTime: ${deletedRecord.getDeletedTime().get}")
                    }
                    
                    if (deletedRecord.getCreatedBy() != null && deletedRecord.getCreatedBy().isDefined) {
                      val createdBy = deletedRecord.getCreatedBy().get
                      println(s"DeletedRecord Created By User-ID: ${createdBy.getId()}")
                      if (createdBy.getName().isDefined) {
                        println(s"DeletedRecord Created By User-Name: ${createdBy.getName().get}")
                      }
                      if (createdBy.getEmail().isDefined) {
                        println(s"DeletedRecord Created By User-Email: ${createdBy.getEmail().get}")
                      }
                    }
                    
                    if (deletedRecord.getDisplayName() != null && deletedRecord.getDisplayName().isDefined) {
                      println(s"DeletedRecord DisplayName: ${deletedRecord.getDisplayName().get}")
                    }
                    
                    if (deletedRecord.getType() != null && deletedRecord.getType().isDefined) {
                      println(s"DeletedRecord Type: ${deletedRecord.getType().get}")
                    }
                    println("--------------------")
                  }
                }

                val info = deletedRecordsWrapper.getInfo()
                if (info.isDefined) {
                  val infoData = info.get
                  if (infoData.getCount().isDefined) {
                    println(s"DeletedRecord Info Count: ${infoData.getCount().get}")
                  }
                  if (infoData.getMoreRecords().isDefined) {
                    println(s"DeletedRecord Info MoreRecords: ${infoData.getMoreRecords().get}")
                  }
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage()}")

              case _ => println("Unexpected response type.")
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

        case None => println("No response from the GetDeletedRecords API.")
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: DataCenter.Environment = USDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
       .clientID("client_id")
       .clientSecret("client_secret")
       .grantToken("grant_token")
        .build()

      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      val moduleAPIName = "Leads"
      getDeletedRecords(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}