package samples.coql

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.coql.{APIException, BodyWrapper, CoqlOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetRecords {

  @throws[Exception]
  private def getRecords(): Unit = {
    val coqlOperations = new CoqlOperations()
    val bodyWrapper = new BodyWrapper()
    
    // Set the COQL query
    val selectQuery = "select Last_Name from Leads where Last_Name is not null limit 200"
    bodyWrapper.setSelectQuery(Option(selectQuery))
    
    val response: Option[APIResponse[ResponseHandler]] = coqlOperations.getRecords(bodyWrapper)

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
                val data = responseWrapper.getData()
                if (data != null && data.nonEmpty) {
                  data.foreach { record =>
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
                    println(s"First Name: ${record.getKeyValue("First_Name")}")
                    println(s"Account Name: ${record.getKeyValue("Account_Name")}")
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
                }
                
                val info = responseWrapper.getInfo()
                if (info.isDefined) {
                  val infoData = info.get
                  if (infoData.getCount().isDefined) {
                    println(s"Total Count: ${infoData.getCount().get}")
                  }
                  if (infoData.getMoreRecords().isDefined) {
                    println(s"More Records Available: ${infoData.getMoreRecords().get}")
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

      getRecords()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}