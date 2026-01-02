package samples.notes

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.notes.{ActionHandler, ActionWrapper, APIException, BodyWrapper, Note, NotesOperations, SuccessResponse}
import com.zoho.crm.api.users.MinifiedUser
import com.zoho.crm.api.notes.ParentId
import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

import scala.collection.mutable.ArrayBuffer

object CreateNotes {

  @throws[Exception]
  private def createNotes(): Unit = {
    val notesOperations = new NotesOperations()
    val notes = new ArrayBuffer[Note]()
    
    // Create first note
    val note1 = new Note()
    note1.setNoteTitle(Option("Sample Note Title 1"))
    note1.setNoteContent(Option("This is a sample note content for demonstration purposes."))

    val parentRecord = new ParentId()
    parentRecord.setId(Option(1055806000028688018L)) // Replace with actual record ID
    val module = new MinifiedModule();
    module.setAPIName(Option("Leads"))
    module.setId(Option(1055806000000002175L))
    parentRecord.setModule(Option(module))
    note1.setParentId(Option(parentRecord))
    notes.addOne(note1)
    
    val request = new BodyWrapper()
    request.setData(notes)
    
    val response: Option[APIResponse[ActionHandler]] = notesOperations.createNotes(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getData()
                if (actionResponses != null) {
                  actionResponses.foreach {
                    case successResponse: SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus().getValue}")
                      println(s"Code: ${successResponse.getCode().getValue}")
                      println("Details: ")
                      successResponse.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"$key: $value")
                        }
                      }
                      if (successResponse.getMessage() != null) {
                        println(s"Message: ${successResponse.getMessage().getValue}")
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
                      println("Unexpected action response type")
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
                println("Unexpected action handler")
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

      createNotes()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}