package samples.dealcontactroles

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.dealcontactroles.DealContactRolesOperations.GetAssociatedContactRolesParam
import com.zoho.crm.api.dealcontactroles.{APIException, DealContactRolesOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetAssociatedContactRoles {

  @throws[Exception]
  private def getAssociatedContactRoles(): Unit = {
    val dealId = 1055806000028564012L // Replace with actual deal ID
    val dealContactRolesOperations = new DealContactRolesOperations()
    val paramInstance = new ParameterMap()
    
    // Add parameters if needed
     paramInstance.add(new GetAssociatedContactRolesParam().ids, "1055806000028723005,1055806000000661002")
//     paramInstance.add(new GetAssociatedContactRolesParam().fields, "Contact_Name,Email")
    
    val response: Option[APIResponse[ResponseHandler]] = dealContactRolesOperations.getAssociatedContactRoles(dealId, Option(paramInstance))

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
                    val createdBy = record.getCreatedBy().get
                    if (createdBy != null) {
                      println(s"Record Created By User-ID: ${createdBy.getId()}")
                      println(s"Record Created By User-Name: ${createdBy.getName()}")
                      println(s"Record Created By User-Email: ${createdBy.getEmail()}")
                    }
                    println(s"Record CreatedTime: ${record.getCreatedTime()}")
                    val modifiedBy = record.getModifiedBy().get
                    if (modifiedBy != null) {
                      println(s"Record Modified By User-ID: ${modifiedBy.getId()}")
                      println(s"Record Modified By User-Name: ${modifiedBy.getName()}")
                      println(s"Record Modified By User-Email: ${modifiedBy.getEmail()}")
                    }
                    println(s"Record ModifiedTime: ${record.getModifiedTime()}")
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

      getAssociatedContactRoles()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}