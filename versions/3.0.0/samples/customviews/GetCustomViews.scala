package samples.customviews

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.customviews.CustomViewsOperations.GetCustomViewsParam
import com.zoho.crm.api.customviews.{APIException, CustomViewsOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetCustomViews {

  @throws[Exception]
  private def getCustomViews(): Unit = {
    val customViewsOperations = new CustomViewsOperations()
    val paramInstance = new ParameterMap()
    
    // Add parameters if needed
    paramInstance.add(new GetCustomViewsParam().module, "Leads")
    paramInstance.add(new GetCustomViewsParam().page, Int.box(1))
    paramInstance.add(new GetCustomViewsParam().perPage, Int.box(20))
    
    val response: Option[APIResponse[ResponseHandler]] = customViewsOperations.getCustomViews(Option(paramInstance))

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
                val customViews = responseWrapper.getCustomViews()
                if (customViews != null) {
                  customViews.foreach { customView =>
                    println(s"CustomView ID: ${customView.getId()}")
                    if (customView.getName().isDefined) {
                      println(s"CustomView Name: ${customView.getName().get}")
                    }
                    if (customView.getSystemName().isDefined) {
                      println(s"CustomView System Name: ${customView.getSystemName().get}")
                    }
                    if (customView.getDisplayValue().isDefined) {
                      println(s"CustomView Display Value: ${customView.getDisplayValue().get}")
                    }
                    if (customView.getSortBy().isDefined) {
                      println(s"CustomView Sort By: ${customView.getSortBy().get}")
                    }
                    if (customView.getCategory().isDefined) {
                      println(s"CustomView Category: ${customView.getCategory().get}")
                    }
                    if (customView.getFavorite().isDefined) {
                      println(s"CustomView Favorite: ${customView.getFavorite().get}")
                    }
                    if (customView.getDefault().isDefined) {
                      println(s"CustomView Default: ${customView.getDefault().get}")
                    }
                    if (customView.getSystemDefined().isDefined) {
                      println(s"CustomView System Defined: ${customView.getSystemDefined().get}")
                    }
                    if (customView.getSortOrder() != null) {
                      println(s"CustomView Sort Order: ${customView.getSortOrder().getValue}")
                    }
                    if (customView.getOffline().isDefined) {
                      println(s"CustomView Offline: ${customView.getOffline().get}")
                    }
                    if (customView.getCreatedBy().isDefined) {
                      val createdBy = customView.getCreatedBy().get
                      println(s"CustomView Created By User-ID: ${createdBy.getId()}")
                      if (createdBy.getName().isDefined) {
                        println(s"CustomView Created By User-Name: ${createdBy.getName().get}")
                      }
                    }
                    if (customView.getModifiedBy().isDefined) {
                      val modifiedBy = customView.getModifiedBy().get
                      println(s"CustomView Modified By User-ID: ${modifiedBy.getId()}")
                      if (modifiedBy.getName().isDefined) {
                        println(s"CustomView Modified By User-Name: ${modifiedBy.getName().get}")
                      }
                    }
                    if (customView.getCreatedTime().isDefined) {
                      println(s"CustomView CreatedTime: ${customView.getCreatedTime().get}")
                    }
                    if (customView.getModifiedTime().isDefined) {
                      println(s"CustomView ModifiedTime: ${customView.getModifiedTime().get}")
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

      getCustomViews()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}