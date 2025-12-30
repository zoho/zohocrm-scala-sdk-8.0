package samples.blueprint

import com.zoho.api.authenticator.OAuthToken
import com.zoho.api.authenticator.Token
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.blueprint.{APIException, ActionHandler, ActionResponse, ActionWrapper, BluePrint, BlueprintOperations, BodyWrapper, SuccessResponse, Transition}
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.record.Record
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.dc.DataCenter.Environment

import scala.collection.mutable.Map
import scala.collection.mutable.ArrayBuffer

object UpdateBlueprint {

  @throws[Exception]
  private def updateBlueprint(): Unit = {
    val module = "Leads"
    val recordId: String = "1055806000028638063" // Replace with actual record ID
    val transitionId: String = "1055806000000293001"
    val blueprintOperations = new BlueprintOperations(recordId, module)
    val bodyWrapper = new BodyWrapper()
    val bluePrintList = new ArrayBuffer[BluePrint]
    val blueprint = new BluePrint()
    blueprint.setTransitionId(Option(transitionId)) // Replace with actual transition ID
    val data = new Record
    val lookup: Map[String, Any] = Map()
    lookup.put("Phone", "8940372937")
    lookup.put("id", "8940372937")
//    data.addKeyValue("Lookup_2", lookup)
    data.addKeyValue("Phone", "8940372937")
    data.addKeyValue("Notes", "Updated via blueprint")
    blueprint.setData(Option(data))
    bluePrintList.addOne(blueprint)
    bodyWrapper.setBlueprint(bluePrintList)
    val response: Option[APIResponse[ActionHandler]] = blueprintOperations.updateBlueprint(bodyWrapper)
    response match {
      case Some(apiResponse) =>
        println(s"Status Code: ${apiResponse.getStatusCode}")
        if (apiResponse.isExpected) {
          val responseHandler: ActionHandler = apiResponse.getObject
          responseHandler match {
            case responseHandler: SuccessResponse =>
              println(s"Status: ${responseHandler.getStatus().getValue}")
              println(s"Code: ${responseHandler.getCode().getValue}")
              val details = responseHandler.getDetails()
              if (details != null && details.isDefined) {
                println("Details: ")
                details.get.foreach { case (key, value) =>
                  println(s"$key: $value")
                }
              }
              println(s"Message: ${responseHandler.getMessage()}")
            case actionWrapper: ActionWrapper =>
              val actionResponses = actionWrapper.getBlueprint()
              if (actionResponses != null) {
                actionResponses.foreach {
                  case successResponse: SuccessResponse =>
                    println(s"Status: ${successResponse.getStatus().getValue}")
                    println(s"Code: ${successResponse.getCode().getValue}")
                    val details = successResponse.getDetails()
                    if (details != null && details.isDefined) {
                      println("Details: ")
                      details.get.foreach { case (key, value) =>
                        println(s"$key: $value")
                      }
                    }
                    println(s"Message: ${successResponse.getMessage()}")
                  case exception: APIException =>
                    println(s"Status: ${exception.getStatus().getValue}")
                    println(s"Code: ${exception.getCode().getValue}")
                    val details = exception.getDetails()
                    if (details != null && details.isDefined) {
                      println("Details: ")
                      details.get.foreach { case (key, value) =>
                        println(s"$key: $value")
                      }
                    }
                    println(s"Message: ${exception.getMessage()}")
                }
              }
            case exception: APIException =>
              println(s"Status: ${exception.getStatus().getValue}")
              println(s"Code: ${exception.getCode().getValue}")
              println("Details: ")
              exception.getDetails().foreach { details =>
                details.foreach { case (key, value) =>
                  println(s"$key: $value")
                }
              }
              println(s"Message: ${exception.getMessage()}")
            case _ =>
              val responseObject: Any = apiResponse.getModel
              val fields = responseObject.getClass.getDeclaredFields
              fields.foreach { field =>
                field.setAccessible(true)
                println(s"${field.getName}: ${field.get(responseObject)}")
              }
          }
        } else {
          val responseObject: Any = apiResponse.getModel
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
      updateBlueprint()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}