package samples.modules

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.modules.{APIException, ModulesOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetModule {

  @throws[Exception]
  private def getModule(): Unit = {
    val moduleId = 1055806000000002175L // Replace with actual module ID
    val modulesOperations = new ModulesOperations()
    
    val response: Option[APIResponse[ResponseHandler]] = modulesOperations.getModule(moduleId)

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
                val modules = responseWrapper.getModules()
                if (modules != null && modules.nonEmpty) {
                  modules.foreach { module =>
                    println(s"Module ID: ${module.getId()}")
                    if (module.getAPIName().isDefined) {
                      println(s"Module API Name: ${module.getAPIName().get}")
                    }
                    if (module.getModuleName().isDefined) {
                      println(s"Module Name: ${module.getModuleName().get}")
                    }
                    if (module.getSingularLabel().isDefined) {
                      println(s"Module Singular Label: ${module.getSingularLabel().get}")
                    }
                    if (module.getPluralLabel().isDefined) {
                      println(s"Module Plural Label: ${module.getPluralLabel().get}")
                    }
                    if (module.getDescription().isDefined) {
                      println(s"Module Description: ${module.getDescription().get}")
                    }
                    if (module.getCreatable().isDefined) {
                      println(s"Module Creatable: ${module.getCreatable().get}")
                    }
                    if (module.getDeletable().isDefined) {
                      println(s"Module Deletable: ${module.getDeletable().get}")
                    }
                    if (module.getViewable().isDefined) {
                      println(s"Module Viewable: ${module.getViewable().get}")
                    }
                    if (module.getConvertable().isDefined) {
                      println(s"Module Convertable: ${module.getConvertable().get}")
                    }
                    if (module.getEditable().isDefined) {
                      println(s"Module Editable: ${module.getEditable().get}")
                    }
                    if (module.getWebLink().isDefined) {
                      println(s"Module Web Link: ${module.getWebLink().get}")
                    }
                    if (module.getSequenceNumber().isDefined) {
                      println(s"Module Sequence Number: ${module.getSequenceNumber().get}")
                    }
                    if (module.getPresenceSubMenu().isDefined) {
                      println(s"Module Presence Sub Menu: ${module.getPresenceSubMenu().get}")
                    }
                    if (module.getTriggersSupported().isDefined) {
                      println(s"Module Triggers Supported: ${module.getTriggersSupported().get}")
                    }
                    if (module.getKanbanView().isDefined) {
                      println(s"Module Kanban View: ${module.getKanbanView().get}")
                    }
                    if (module.getEmailtemplateSupport().isDefined) {
                      println(s"Module Email Template Support: ${module.getEmailtemplateSupport().get}")
                    }
                    if (module.getProfiles() != null && module.getProfiles().nonEmpty) {
                      println("Module Profiles:")
                      module.getProfiles().foreach { profile =>
                        println(s"  Profile ID: ${profile.getId()}")
                        if (profile.getName().isDefined) {
                          println(s"  Profile Name: ${profile.getName().get}")
                        }
                      }
                    }
                    if (module.getFilterStatus().isDefined) {
                      println(s"Module Filter Status: ${module.getFilterStatus().get}")
                    }
                    if (module.getInventoryTemplateSupported().isDefined) {
                      println(s"Module Inventory Template Supported: ${module.getInventoryTemplateSupported().get}")
                    }
                    if (module.getModifiedTime().isDefined) {
                      println(s"Module Modified Time: ${module.getModifiedTime().get}")
                    }
                    if (module.getModifiedBy().isDefined) {
                      val modifiedBy = module.getModifiedBy().get
                      println(s"Module Modified By User-ID: ${modifiedBy.getId()}")
                      if (modifiedBy.getName().isDefined) {
                        println(s"Module Modified By User-Name: ${modifiedBy.getName().get}")
                      }
                      if (modifiedBy.getEmail().isDefined) {
                        println(s"Module Modified By User-Email: ${modifiedBy.getEmail().get}")
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

      getModule()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}