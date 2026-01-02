package samples.bulkwrite

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.bulkwrite.{APIException, ActionResponse, BulkWriteOperations, CallBack, DefaultValue, FieldMapping, RequestWrapper, Resource, SuccessResponse}
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.fields.MinifiedField
import com.zoho.crm.api.util.{APIResponse, Choice}

import scala.collection.mutable.ArrayBuffer

object CreateBulkWriteJob {

  private def createBulkWriteJob(): Unit = {
    val bulkWriteOperations = new BulkWriteOperations()
    val requestWrapper = new RequestWrapper()
    
    // Set up callback URL
    val callback = new CallBack()
    callback.setUrl(Option("https://www.example.com/callback"))
    callback.setMethod(new Choice[String]("post"))
    requestWrapper.setCallback(Option(callback))
    
    // Set up operation type
    requestWrapper.setCharacterEncoding(Option("UTF-8"))
    requestWrapper.setOperation(new Choice[String]("insert")) // or "update", "upsert"
    
    // Set up resources
    val resources = new ArrayBuffer[Resource]()
    val resource = new Resource()
    
    // Set resource type and module
    resource.setType(new Choice[String]("data"))
    val module = new MinifiedModule()
    module.setAPIName(Option("Leads"))
    resource.setModule(Option(module))
    
    // Set file ID (from previous upload)
    resource.setFileId(Option("1055806000028745001")) // Replace with actual file ID from upload
    
    // Set ignore empty fields
    resource.setIgnoreEmpty(Option(true))
//    resource.setFindBy(Option("Email"))
    
    // Set up field mappings
    val fieldMappings = new ArrayBuffer[FieldMapping]()
    
    // First Name mapping
    val firstNameMapping = new FieldMapping()
    firstNameMapping.setAPIName(Option("First_Name"))
    firstNameMapping.setIndex(Option(0))
    
    val firstNameDefaultValue = new DefaultValue()
    firstNameDefaultValue.setValue("Unknown")
    firstNameMapping.setDefaultValue(Option(firstNameDefaultValue))
    fieldMappings.addOne(firstNameMapping)
    
    // Last Name mapping
    val lastNameMapping = new FieldMapping()
    lastNameMapping.setAPIName(Option("Last_Name"))
    lastNameMapping.setIndex(Option(1))
    fieldMappings.addOne(lastNameMapping)
    
    // Email mapping
    val emailMapping = new FieldMapping()
    emailMapping.setAPIName(Option("Email"))
    emailMapping.setIndex(Option(2))
    fieldMappings.addOne(emailMapping)
    
    // Company mapping
    val companyMapping = new FieldMapping()
    companyMapping.setAPIName(Option("Company"))
    companyMapping.setIndex(Option(3))
    
    val companyDefaultValue = new DefaultValue()
    companyDefaultValue.setValue("Default Company")
    companyMapping.setDefaultValue(Option(companyDefaultValue))
    fieldMappings.addOne(companyMapping)
    
    // Phone mapping
    val phoneMapping = new FieldMapping()
    phoneMapping.setAPIName(Option("Phone"))
    phoneMapping.setIndex(Option(4))
    fieldMappings.addOne(phoneMapping)
    
    resource.setFieldMappings(fieldMappings)
    resources.addOne(resource)
    requestWrapper.setResource(resources)

    val response: Option[APIResponse[ActionResponse]] = bulkWriteOperations.createBulkWriteJob(requestWrapper)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case successResponse: SuccessResponse =>
                println(s"Status: ${successResponse.getStatus().getValue}")
                println(s"Code: ${successResponse.getCode().getValue}")
                println("Details: ")
                successResponse.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                    if (key == "job_id") {
                      println(s"Bulk write job created successfully. Job ID: $value")
                    }
                  }
                }
                println(s"Message: ${successResponse.getMessage().getValue}")

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                println("Details: ")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage().getValue}")
                
              case _ =>
                println("Unexpected response type received")
            }
          } else {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            for (field <- fields) {
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

      createBulkWriteJob()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}