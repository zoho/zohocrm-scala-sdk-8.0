package samples.relatedrecords

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.relatedrecords.RelatedRecordsOperations.{GetRelatedRecordHeader, GetRelatedRecordParam}
import com.zoho.crm.api.relatedrecords.{APIException, RelatedRecordsOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.{HeaderMap, Initializer, ParameterMap}

object GetRelatedRecord {

  @throws[Exception]
  private def getRelatedRecord(moduleAPIName: String, recordId: Long, relatedListAPIName: String, relatedRecordId: Long): Unit = {
    val relatedRecordsOperations = new RelatedRecordsOperations(relatedListAPIName, moduleAPIName)
    
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetRelatedRecordParam().fields, "Last_Name,First_Name,Email,Phone,Mailing_Street,Mailing_City")
    
    val headerInstance = new HeaderMap()
    val response: Option[APIResponse[ResponseHandler]] = relatedRecordsOperations.getRelatedRecord(
      relatedRecordId, 
      recordId, 
      Option(paramInstance), 
      Option(headerInstance)
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
                val records = responseWrapper.getData()
                records.foreach { record =>
                  println(s"Record ID: ${record.getId()}")

                  if (record.getCreatedBy() != null && record.getCreatedBy().isDefined) {
                    val createdBy = record.getCreatedBy().get
                    println(s"Record Created By User-ID: ${createdBy.getId()}")
                    if (createdBy.getName().isDefined) {
                      println(s"Record Created By User-Name: ${createdBy.getName().get}")
                    }
                    if (createdBy.getEmail().isDefined) {
                      println(s"Record Created By User-Email: ${createdBy.getEmail().get}")
                    }
                  }

                  if (record.getCreatedTime() != null && record.getCreatedTime().isDefined) {
                    println(s"Record CreatedTime: ${record.getCreatedTime().get}")
                  }

                  if (record.getModifiedBy() != null && record.getModifiedBy().isDefined) {
                    val modifiedBy = record.getModifiedBy().get
                    println(s"Record Modified By User-ID: ${modifiedBy.getId()}")
                    if (modifiedBy.getName().isDefined) {
                      println(s"Record Modified By User-Name: ${modifiedBy.getName().get}")
                    }
                    if (modifiedBy.getEmail().isDefined) {
                      println(s"Record Modified By User-Email: ${modifiedBy.getEmail().get}")
                    }
                  }

                  if (record.getModifiedTime() != null && record.getModifiedTime().isDefined) {
                    println(s"Record ModifiedTime: ${record.getModifiedTime().get}")
                  }

                  // Access specific field values
                  println(s"Company: ${record.getKeyValue("Company")}")
                  println(s"Email: ${record.getKeyValue("Email")}")

                  println("Record KeyValues: ")
                  if (record.getKeyValues() != null) {
                    record.getKeyValues().foreach { case (keyName, value) =>
                      value match {
                        case dataList: Seq[_] =>
                          println(s"Record KeyName: $keyName")
                          dataList.foreach {
                            case map: Map[_, _] =>
                              println(s"Record KeyName: $keyName - Value:")
                              map.asInstanceOf[Map[String, Object]].foreach {
                                case (mapKey, mapValue) => println(s"$mapKey : $mapValue")
                              }
                            case data => println(data)
                          }
                        case map: Map[_, _] =>
                          println(s"Record KeyName: $keyName - Value:")
                          val mapValue = map.asInstanceOf[Map[String, Object]]
                          mapValue.foreach { case (mapKey, mapValue) =>
                            println(s"$mapKey : $mapValue")
                          }
                        case _ =>
                          println(s"Record KeyName: $keyName - Value: $value")
                      }
                    }
                  }
                }
              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                println(s"Message: ${exception.getMessage()}")
                
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"Details: $key -> $value")
                  }
                }

              case _ =>
                println("Unexpected response handler type.")
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

        case None => 
          println("No response received from GetRelatedRecord API.")
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

      val moduleAPIName = "Leads"
      val recordId = 1055806000028754070L        // Account record ID
      val relatedListAPIName = "Products"
      val relatedRecordId = 1055806000006611017L  // Contact record ID
      
      getRelatedRecord(moduleAPIName, recordId, relatedListAPIName, relatedRecordId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}