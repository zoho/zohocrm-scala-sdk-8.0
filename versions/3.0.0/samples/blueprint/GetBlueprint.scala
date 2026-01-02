package samples.blueprint

import com.zoho.api.authenticator.OAuthToken
import com.zoho.api.authenticator.Token
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.blueprint.{APIException, BluePrint, BlueprintOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.dc.DataCenter.Environment

object GetBlueprint {

  @throws[Exception]
  private def getBlueprint(): Unit = {
    val module = "Leads"
    val recordId: String = "1055806000028638063" // Replace with actual record ID
    val blueprintOperations = new BlueprintOperations(recordId, module)
    val response: Option[APIResponse[ResponseHandler]] = blueprintOperations.getBlueprint()
    response match {
      case Some(apiResponse) =>
        println(s"Status Code: ${apiResponse.getStatusCode}")
        if (List(204, 304).contains(apiResponse.getStatusCode)) {
          println(if (apiResponse.getStatusCode == 204) "No Content" else "Not Modified")
          return
        }
        if (apiResponse.isExpected) {
          val responseHandler: ResponseHandler = apiResponse.getObject
          responseHandler match {
            case responseWrapper: ResponseWrapper =>
              val blueprintList = responseWrapper.getBlueprint()
              if (blueprintList != null && blueprintList.isDefined) {
                val blueprint = blueprintList.get
                val transitions = blueprint.getTransitions()
                if (transitions != null) {
                  println("Available Transitions:")
                  transitions.foreach { transition =>
                    println(s"  Transition ID: ${transition.getId()}")
                    println(s"  Transition Name: ${transition.getName()}")
                    println(s"  Transition Type: ${transition.getType()}")
                    val nextTransitions = transition.getNextTransitions()
                    if (nextTransitions != null) {
                      println("  Next Transitions:")
                      nextTransitions.foreach { nextTransition =>
                        println(s"    - ${nextTransition.getName()}")
                      }
                    }
                    val fields = transition.getFields()
                    if (fields != null) {
                      println("  Required Fields:")
                      fields.foreach { field =>
                        println(s"    Field: ${field.getAPIName()}")
                        println(s"    Display Label: ${field.getDisplayLabel()}")
                      }
                    }
                    println("  --------------------")
                  }
                }
              } else {
                println("No blueprint found for this record.")
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
          }
        } else if (apiResponse.getStatusCode != 204) {
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
      getBlueprint()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}