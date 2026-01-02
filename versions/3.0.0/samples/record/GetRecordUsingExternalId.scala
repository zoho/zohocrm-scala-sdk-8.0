package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{HeaderMap, Initializer, ParameterMap}
import com.zoho.crm.api.record.{APIException, RecordOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.record.RecordOperations.{GetRecordUsingExternalIDHeader, GetRecordUsingExternalIDParam}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.util.APIResponse

import java.time.{OffsetDateTime, ZoneOffset}

object GetRecordUsingExternalId {

  @throws[Exception]
  private def getRecordUsingExternalId(moduleAPIName: String, externalFieldValue: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetRecordUsingExternalIDParam().approved, "both")
    paramInstance.add(new GetRecordUsingExternalIDParam().converted, "false")
    paramInstance.add(new GetRecordUsingExternalIDParam().fields, "Company,Email")
    
    val headerInstance = new HeaderMap()
    val ifModifiedSince = OffsetDateTime.of(2020, 5, 20, 10, 0, 0, 1, ZoneOffset.of("+05:30"))
    headerInstance.add(new GetRecordUsingExternalIDHeader().IfModifiedSince, ifModifiedSince)
    headerInstance.add(new GetRecordUsingExternalIDHeader().XEXTERNAL, "Leads.External")

    val response: Option[APIResponse[ResponseHandler]] = recordOperations.getRecordUsingExternalId(externalFieldValue, Option(paramInstance), Option(headerInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
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
                  println(s"External Field Value: $externalFieldValue")
                  
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

                val info = responseWrapper.getInfo()
                if (info.isDefined) {
                  val infoData = info.get
                  if (infoData.getCount().isDefined) {
                    println(s"Record Info Count: ${infoData.getCount().get}")
                  }
                  if (infoData.getMoreRecords().isDefined) {
                    println(s"Record Info MoreRecords: ${infoData.getMoreRecords().get}")
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

        case None => println("No response from the GetRecordUsingExternalId API.")
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
      val externalFieldValue = "TestExternal123"
      getRecordUsingExternalId(moduleAPIName, externalFieldValue)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}