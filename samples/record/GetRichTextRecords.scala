package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{Initializer, ParameterMap}
import com.zoho.crm.api.record.{APIException, RecordOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.record.RecordOperations.GetRichTextRecordsParam
import com.zoho.crm.api.dc.{DataCenter, USDataCenter}
import com.zoho.crm.api.util.APIResponse

import scala.jdk.CollectionConverters._

object GetRichTextRecords {

  @throws[Exception]
  def getRichTextRecords(moduleAPIName: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetRichTextRecordsParam().ids, "3477062")
    val response = recordOperations.getRichTextRecords(Option(paramInstance))
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
                  println(s"Record ID: ${record.getId}")
                  val createdBy = record.getCreatedBy().get
                  if (createdBy != null) {
                    println(s"Record Created By User-ID: ${createdBy.getId}")
                    println(s"Record Created By User-Name: ${createdBy.getName}")
                    println(s"Record Created By User-Email: ${createdBy.getEmail}")
                  }
                  println(s"Record CreatedTime: ${record.getCreatedTime}")
                  val modifiedBy = record.getModifiedBy.get
                  if (modifiedBy != null) {
                    println(s"Record Modified By User-ID: ${modifiedBy.getId}")
                    println(s"Record Modified By User-Name: ${modifiedBy.getName}")
                    println(s"Record Modified By User-Email: ${modifiedBy.getEmail}")
                  }
                  println(s"Record ModifiedTime: ${record.getModifiedTime}")
                  println(s"Record Field Value: ${record.getKeyValue("Last_Name")}")
                  println("Record KeyValues: ")
                  record.getKeyValues().foreach { case (keyName, value) =>
                    value match {
                      case dataList: List[_] =>
                        println(s"Record KeyName: $keyName")
                        dataList.foreach {
                          case map: Map[_, _] =>
                            println(s"Record KeyName: $keyName - Value:")
                            map.asInstanceOf[Map[String, Object]].foreach {
                              case (mapKey, mapValue) => println(s"$mapKey : $mapValue")
                            }
                          case data => println(data)
                        }
                      case _: Map[_, _] =>
                        println(s"Record KeyName: $keyName - Value:")
                        val mapValue = value.asInstanceOf[Map[String, Object]]
                        mapValue.foreach { case (mapKey, mapValue) =>
                          println(s"$mapKey : $mapValue")
                        }
                      case _ =>
                        println(s"Record KeyName: $keyName - Value: $value")
                    }
                  }
                }

                val info = responseWrapper.getInfo().get
                if (info != null) {
                  Option(info.getCount).foreach { count =>
                    println(s"Record Info Count: $count")
                  }
                  Option(info.getMoreRecords).foreach { moreRecords =>
                    println(s"Record Info MoreRecords: $moreRecords")
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
                println(s"Message: ${exception.getMessage.getValue}")

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

        case None => println("No response from the GetRichTextRecords API.")
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
      getRichTextRecords(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
