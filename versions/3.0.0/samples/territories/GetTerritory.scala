package samples.territories

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.territories.{APIException, ResponseHandler, ResponseWrapper, TerritoriesOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

object GetTerritory {

  @throws[Exception]
  private def getTerritory(territoryId: Long): Unit = {
    val territoriesOperations = new TerritoriesOperations()
    
    val response: Option[APIResponse[ResponseHandler]] = territoriesOperations.getTerritory(territoryId)

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
                val territories = responseWrapper.getTerritories()
                if (territories != null && territories.nonEmpty) {
                  val territory = territories.head // Should be single territory for getTerritory() call
                  
                  println("Territory Details:")
                  println(s"Territory ID: ${territory.getId()}")
                  
                  if (territory.getName().isDefined) {
                    println(s"Territory Name: ${territory.getName().get}")
                  }
                  
                  if (territory.getDescription().isDefined) {
                    println(s"Description: ${territory.getDescription().get}")
                  }
                  
                  if (territory.getPermissionType() != null) {
                    println(s"Permission Type: ${territory.getPermissionType().getValue}")
                  }
                  if (territory.getCreatedTime().isDefined) {
                    println(s"Created Time: ${territory.getCreatedTime().get}")
                  }
                  
                  if (territory.getModifiedTime().isDefined) {
                    println(s"Modified Time: ${territory.getModifiedTime().get}")
                  }
                  
                  if (territory.getCreatedBy().isDefined) {
                    val createdBy = territory.getCreatedBy().get
                    println(s"Created By - ID: ${createdBy.getId()}")
                    if (createdBy.getName().isDefined) {
                      println(s"Created By - Name: ${createdBy.getName().get}")
                    }
                    if (createdBy.getEmail().isDefined) {
                      println(s"Created By - Email: ${createdBy.getEmail().get}")
                    }
                  }
                  
                  if (territory.getModifiedBy().isDefined) {
                    val modifiedBy = territory.getModifiedBy().get
                    println(s"Modified By - ID: ${modifiedBy.getId()}")
                    if (modifiedBy.getName().isDefined) {
                      println(s"Modified By - Name: ${modifiedBy.getName().get}")
                    }
                    if (modifiedBy.getEmail().isDefined) {
                      println(s"Modified By - Email: ${modifiedBy.getEmail().get}")
                    }
                  }
                  
                } else {
                  println(s"No territory found with ID: $territoryId")
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
          println("No response received from GetTerritory API.")
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

      val territoryId = 1055806000003051397L // Replace with actual territory ID
      getTerritory(territoryId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}