package samples.layouts

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.layouts.LayoutsOperations.GetLayoutsParam
import com.zoho.crm.api.layouts.{APIException, LayoutsOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetLayouts {

  @throws[Exception]
  private def getLayouts(): Unit = {
    val layoutsOperations = new LayoutsOperations()
    val paramInstance = new ParameterMap()
    
    // Add module parameter
    paramInstance.add(new GetLayoutsParam().module, "Leads")
    
    val response: Option[APIResponse[ResponseHandler]] = layoutsOperations.getLayouts(Option(paramInstance))

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
                val layouts = responseWrapper.getLayouts()
                if (layouts != null) {
                  layouts.foreach { layout =>
                    println(s"Layout ID: ${layout.getId()}")
                    if (layout.getName().isDefined) {
                      println(s"Layout Name: ${layout.getName().get}")
                    }
                    if (layout.getDisplayLabel().isDefined) {
                      println(s"Layout Display Label: ${layout.getDisplayLabel().get}")
                    }
                    if (layout.getVisible().isDefined) {
                      println(s"Layout Visible: ${layout.getVisible().get}")
                    }
                    if (layout.getStatus().isDefined) {
                      println(s"Layout Status: ${layout.getStatus().get}")
                    }
                    if (layout.getGeneratedType().isDefined) {
                      println(s"Layout Generated Type: ${layout.getGeneratedType().get}")
                    }
                    if (layout.getCreatedTime().isDefined) {
                      println(s"Layout Created Time: ${layout.getCreatedTime().get}")
                    }
                    if (layout.getModifiedTime().isDefined) {
                      println(s"Layout Modified Time: ${layout.getModifiedTime().get}")
                    }
                    if (layout.getCreatedBy().isDefined) {
                      val createdBy = layout.getCreatedBy().get
                      println(s"Layout Created By User-ID: ${createdBy.getId()}")
                      if (createdBy.getName().isDefined) {
                        println(s"Layout Created By User-Name: ${createdBy.getName().get}")
                      }
                    }
                    if (layout.getModifiedBy().isDefined) {
                      val modifiedBy = layout.getModifiedBy().get
                      println(s"Layout Modified By User-ID: ${modifiedBy.getId()}")
                      if (modifiedBy.getName().isDefined) {
                        println(s"Layout Modified By User-Name: ${modifiedBy.getName().get}")
                      }
                    }
                    if (layout.getProfiles() != null && layout.getProfiles().nonEmpty) {
                      println("Layout Profiles:")
                      layout.getProfiles().foreach { profile =>
                        println(s"  Profile ID: ${profile.getId()}")
                        if (profile.getName().isDefined) {
                          println(s"  Profile Name: ${profile.getName().get}")
                        }
                        if (profile.getDefault().isDefined) {
                          println(s"  Profile Default: ${profile.getDefault().get}")
                        }
                      }
                    }
                    println("--------------------")
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

      getLayouts()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}