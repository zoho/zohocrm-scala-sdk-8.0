package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{HeaderMap, Initializer, ParameterMap}
import com.zoho.crm.api.record.{APIException, RecordOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.record.RecordOperations.{GetRecordsHeader, GetRecordsParam}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.util.APIResponse

import java.time.{OffsetDateTime, ZoneOffset}

object GetRecords {

  @throws[Exception]
  def getRecords(moduleAPIName: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetRecordsParam().approved, "both")
    paramInstance.add(new GetRecordsParam().converted, "false")
    paramInstance.add(new GetRecordsParam().fields, "Last_Name,Account_Name,First_Name,Lead_Source")
    paramInstance.add(new GetRecordsParam().sortBy, "Email")
    paramInstance.add(new GetRecordsParam().sortOrder, "desc")
    paramInstance.add(new GetRecordsParam().page, 1)
    paramInstance.add(new GetRecordsParam().perPage, 50)
//    paramInstance.add(new GetRecordsParam().ids, "1055806000028418048")
    
    val headerInstance = new HeaderMap()
    val ifModifiedSince = OffsetDateTime.of(2020, 5, 20, 10, 0, 0, 1, ZoneOffset.of("+05:30"))
    headerInstance.add(new GetRecordsHeader().IfModifiedSince, ifModifiedSince)

    val response: Option[APIResponse[ResponseHandler]] = recordOperations.getRecords(Option(paramInstance), Option(headerInstance))

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
                  println(s"Last Name: ${record.getKeyValue("Last_Name")}")
                  println(s"Account Name: ${record.getKeyValue("Account_Name")}")
                  println(s"First Name: ${record.getKeyValue("First_Name")}")
                  println(s"Lead Source: ${record.getKeyValue("Lead_Source")}")
                  
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
                  println("--------------------")
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
                println(s"Message: ${exception.getMessage().getValue}")

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

        case None => println("No response from the GetRecords API.")
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
      getRecords(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}