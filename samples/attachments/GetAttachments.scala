package samples.attachments

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{Initializer, ParameterMap}
import com.zoho.crm.api.attachments.AttachmentsOperations.GetAttachmentsParam
import com.zoho.crm.api.attachments.*
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetAttachments {

  @throws[Exception]
  private def getAttachments(): Unit = {
    val module = "Leads"
    val recordId: Long = 1055806000028638063L // Replace with actual record ID
    val attachmentsOperations = new AttachmentsOperations()
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetAttachmentsParam().fields, "id,file_name,size,created_time")
    paramInstance.add(new GetAttachmentsParam().page, 1)
    paramInstance.add(new GetAttachmentsParam().perPage, 10)
    //    paramInstance.add(new GetAttachmentsParam().ids, "1055806000028728001")
    val response: Option[APIResponse[ResponseHandler]] = attachmentsOperations.getAttachments(recordId, module, Some(paramInstance))
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
              val attachments: List[Attachment] = responseWrapper.getData().toList
              if (attachments != null && attachments.nonEmpty) {
                attachments.foreach { attachment =>
                  println(s"Attachment ID: ${attachment.getId()}")
                  println(s"File Name: ${attachment.getFileName()}")
                  println(s"File Size: ${attachment.getSize()}")
                  println(s"Created Time: ${attachment.getCreatedTime()}")
                  println(s"Modified Time: ${attachment.getModifiedTime()}")
                  val createdBy = attachment.getCreatedBy()
                  if (createdBy.isDefined) {
                    createdBy match {
                      case Some(created_by) =>
                        println(s"Created By User Id : ${created_by.getId()}")
                        println(s"Created By User Name : ${created_by.getName()}")
                    }
                  }
                  val modifiedBy = attachment.getModifiedBy()
                  if (modifiedBy.isDefined) {
                    modifiedBy match {
                      case Some(modified_by) =>
                        println(s"Modified By User Id : ${modified_by.getId()}")
                        println(s"Modified By User Name : ${modified_by.getName()}")
                    }
                  }
                  println("--------------------")
                }
              } else {
                println("No attachments found.")
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
      getAttachments()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}