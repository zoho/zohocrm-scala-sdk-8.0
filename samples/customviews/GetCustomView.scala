package samples.customviews

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.customviews.CustomViewsOperations.GetCustomViewParam
import com.zoho.crm.api.customviews.{APIException, CustomViewsOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetCustomView {

  @throws[Exception]
  private def getCustomView(): Unit = {
    val customViewId = 1055806000000087501L // Replace with actual custom view ID
    val customViewsOperations = new CustomViewsOperations()
    val paramInstance = new ParameterMap()
    
    // Add module parameter
    paramInstance.add(new GetCustomViewParam().module, "Leads")
    
    val response: Option[APIResponse[ResponseHandler]] = customViewsOperations.getCustomView(customViewId, Option(paramInstance))

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
                val customViews = responseWrapper.getCustomViews()
                if (customViews != null && customViews.nonEmpty) {
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
                    if (customView.getCriteria().isDefined) {
                      val criteria = customView.getCriteria().get
                      println(s"CustomView Criteria: ${criteria}")
                    }
                    if (customView.getFields() != null) {
                      val fields = customView.getFields()
                      println("CustomView Fields:")
                      fields.foreach { field =>
                        if (field.getAPIName().isDefined) {
                          println(s"  Field API Name: ${field.getAPIName().get}")
                        }
                      }
                    }
                    if (customView.getSortBy().isDefined) {
                      println(s"CustomView Sort By: ${customView.getSortBy().get}")
                    }
                    if (customView.getSortOrder() != null) {
                      println(s"CustomView Sort Order: ${customView.getSortOrder()}")
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
                    if (customView.getCategory().isDefined) {
                      println(s"CustomView Category: ${customView.getCategory().get}")
                    }
                    if (customView.getCreatedBy().isDefined) {
                      val createdBy = customView.getCreatedBy().get
                      println(s"CustomView Created By User-ID: ${createdBy.getId()}")
                      if (createdBy.getName().isDefined) {
                        println(s"CustomView Created By User-Name: ${createdBy.getName().get}")
                      }
                      if (createdBy.getEmail().isDefined) {
                        println(s"CustomView Created By User-Email: ${createdBy.getEmail().get}")
                      }
                    }
                    if (customView.getModifiedBy().isDefined) {
                      val modifiedBy = customView.getModifiedBy().get
                      println(s"CustomView Modified By User-ID: ${modifiedBy.getId()}")
                      if (modifiedBy.getName().isDefined) {
                        println(s"CustomView Modified By User-Name: ${modifiedBy.getName().get}")
                      }
                      if (modifiedBy.getEmail().isDefined) {
                        println(s"CustomView Modified By User-Email: ${modifiedBy.getEmail().get}")
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

      getCustomView()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}