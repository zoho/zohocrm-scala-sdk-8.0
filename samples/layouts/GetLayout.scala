package samples.layouts

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.layouts.LayoutsOperations.GetLayoutParam
import com.zoho.crm.api.layouts.{APIException, LayoutsOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetLayout {

  @throws[Exception]
  private def getLayout(): Unit = {
    val layoutId = 1055806000000091055L // Replace with actual layout ID
    val layoutsOperations = new LayoutsOperations()
    val paramInstance = new ParameterMap()
    
    // Add module parameter
    paramInstance.add(new GetLayoutParam().module, "Leads")
    
    val response: Option[APIResponse[ResponseHandler]] = layoutsOperations.getLayout(layoutId, Option(paramInstance))

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
                val layouts = responseWrapper.getLayouts()
                if (layouts != null && layouts.nonEmpty) {
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
                    if (layout.getSections() != null && layout.getSections().nonEmpty) {
                      println("Layout Sections:")
                      layout.getSections().foreach { section =>
                        println(s"  Section ID: ${section.getId()}")
                        if (section.getName().isDefined) {
                          println(s"  Section Name: ${section.getName().get}")
                        }
                        if (section.getDisplayLabel().isDefined) {
                          println(s"  Section Display Label: ${section.getDisplayLabel().get}")
                        }
                        if (section.getColumnCount().isDefined) {
                          println(s"  Section Column Count: ${section.getColumnCount().get}")
                        }
                        if (section.getSequenceNumber().isDefined) {
                          println(s"  Section Sequence Number: ${section.getSequenceNumber().get}")
                        }
                        if (section.getFields() != null && section.getFields().nonEmpty) {
                          println("  Section Fields:")
                          section.getFields().foreach { field =>
                            if (field.getAPIName().isDefined) {
                              println(s"    Field API Name: ${field.getAPIName().get}")
                            }
                            if (field.getDisplayLabel().isDefined) {
                              println(s"    Field Display Label: ${field.getDisplayLabel().get}")
                            }
                            if (field.getSequenceNumber().isDefined) {
                              println(s"    Field Sequence Number: ${field.getSequenceNumber().get}")
                            }
                          }
                        }
                      }
                    }
                    if (layout.getConvertMapping().isDefined) {
                      val convertMapping = layout.getConvertMapping().get
                      if (convertMapping.getContacts().isDefined) {
                        println(s"Layout Convert Mapping Contacts: ${convertMapping.getContacts().get}")
                      }
                      if (convertMapping.getDeals().isDefined) {
                        println(s"Layout Convert Mapping Deals: ${convertMapping.getDeals().get}")
                      }
                      if (convertMapping.getAccounts().isDefined) {
                        println(s"Layout Convert Mapping Accounts: ${convertMapping.getAccounts().get}")
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

      getLayout()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}