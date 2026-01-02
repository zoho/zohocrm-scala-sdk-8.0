package samples.notes

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.HeaderMap
import com.zoho.crm.api.notes.NotesOperations.{GetNotesParam, GetNotesHeader}
import com.zoho.crm.api.notes.{APIException, NotesOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse
import java.time.{OffsetDateTime, ZoneOffset}

object GetNotes {

  @throws[Exception]
  private def getNotes(): Unit = {
    val notesOperations = new NotesOperations()
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetNotesParam().page, "1")
    paramInstance.add(new GetNotesParam().perPage, "50")
    paramInstance.add(new GetNotesParam().fields, "Note_Title,Note_Content,Created_By,Modified_Time")
    
    val headerInstance = new HeaderMap()
    val ifModifiedSince = OffsetDateTime.of(2020, 5, 20, 10, 0, 0, 1, ZoneOffset.of("+05:30"))
    headerInstance.add(new GetNotesHeader().IfModifiedSince, ifModifiedSince)
    
    val response: Option[APIResponse[ResponseHandler]] = notesOperations.getNotes(Option(paramInstance), Option(headerInstance))

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
                val notes = responseWrapper.getData()
                if (notes != null) {
                  notes.foreach { note =>
                    println(s"Note ID: ${note.getId()}")
                    
                    if (note.getNoteTitle().isDefined) {
                      println(s"Note Title: ${note.getNoteTitle().get}")
                    }
                    if (note.getNoteContent().isDefined) {
                      println(s"Note Content: ${note.getNoteContent().get}")
                    }
                    if (note.getCreatedTime().isDefined) {
                      println(s"Note Created Time: ${note.getCreatedTime().get}")
                    }
                    if (note.getModifiedTime().isDefined) {
                      println(s"Note Modified Time: ${note.getModifiedTime().get}")
                    }
                    if (note.getCreatedBy().isDefined) {
                      val createdBy = note.getCreatedBy().get
                      println(s"Note Created By - ID: ${createdBy.getId()}")
                      if (createdBy.getName().isDefined) {
                        println(s"Note Created By - Name: ${createdBy.getName().get}")
                      }
                      if (createdBy.getEmail().isDefined) {
                        println(s"Note Created By - Email: ${createdBy.getEmail().get}")
                      }
                    }
                    if (note.getModifiedBy().isDefined) {
                      val modifiedBy = note.getModifiedBy().get
                      println(s"Note Modified By - ID: ${modifiedBy.getId()}")
                      if (modifiedBy.getName().isDefined) {
                        println(s"Note Modified By - Name: ${modifiedBy.getName().get}")
                      }
                    }
                    if (note.getOwner().isDefined) {
                      val owner = note.getOwner().get
                      println(s"Note Owner - ID: ${owner.getId()}")
                      if (owner.getName().isDefined) {
                        println(s"Note Owner - Name: ${owner.getName().get}")
                      }
                    }
                    if (note.getParentId().isDefined) {
                      val parentId = note.getParentId().get
                      println(s"Note Parent Record ID: ${parentId.getId()}")
                      if (parentId.getName().isDefined) {
                        println(s"Note Parent Record Name: ${parentId.getName().get}")
                      }
                    }
                    println("--------------------")
                  }
                }

                val info = responseWrapper.getInfo().get
                if (info != null) {
                  if (info.getCount().isDefined) {
                    println(s"Total Count: ${info.getCount().get}")
                  }
                  if (info.getPage().isDefined) {
                    println(s"Current Page: ${info.getPage().get}")
                  }
                  if (info.getPerPage().isDefined) {
                    println(s"Per Page: ${info.getPerPage().get}")
                  }
                  if (info.getMoreRecords().isDefined) {
                    println(s"More Records Available: ${info.getMoreRecords().get}")
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

      getNotes()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}