package samples.profile

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.profiles.{APIException, ProfilesOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetProfile {

  @throws[Exception]
  private def getProfile(): Unit = {
    val profilesOperations = new ProfilesOperations()
    val profileId = 1055806000000026011L // Replace with actual profile ID
    
    val response: Option[APIResponse[ResponseHandler]] = profilesOperations.getProfile(profileId)

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
                val profiles = responseWrapper.getProfiles()
                if (profiles != null && profiles.nonEmpty) {
                  val profile = profiles.head // Get the single profile
                  
                  println(s"Profile ID: ${profile.getId()}")
                  
                  if (profile.getName().isDefined) {
                    println(s"Profile Name: ${profile.getName().get}")
                  }
                  if (profile.getCategory().isDefined) {
                    println(s"Profile Category: ${profile.getCategory().get}")
                  }
                  if (profile.getDescription().isDefined) {
                    println(s"Profile Description: ${profile.getDescription().get}")
                  }
                  if (profile.getCreatedTime().isDefined) {
                    println(s"Profile Created Time: ${profile.getCreatedTime().get}")
                  }
                  if (profile.getModifiedTime().isDefined) {
                    println(s"Profile Modified Time: ${profile.getModifiedTime().get}")
                  }
                  if (profile.getCreatedBy().isDefined) {
                    val createdBy = profile.getCreatedBy().get
                    println(s"Profile Created By - ID: ${createdBy.getId()}")
                    if (createdBy.getName().isDefined) {
                      println(s"Profile Created By - Name: ${createdBy.getName().get}")
                    }
                  }
                  if (profile.getModifiedBy().isDefined) {
                    val modifiedBy = profile.getModifiedBy().get
                    println(s"Profile Modified By - ID: ${modifiedBy.getId()}")
                    if (modifiedBy.getName().isDefined) {
                      println(s"Profile Modified By - Name: ${modifiedBy.getName().get}")
                    }
                  }
                  if (profile.getDefault().isDefined) {
                    println(s"Profile Default: ${profile.getDefault().get}")
                  }
                  if (profile.getDisplayLabel().isDefined) {
                    println(s"Profile Display Label: ${profile.getDisplayLabel().get}")
                  }
                  if (profile.getCustom().isDefined) {
                    println(s"Profile Custom: ${profile.getCustom().get}")
                  }
                  
                  // Profile permissions
                  if (profile.getPermissionsDetails() != null && profile.getPermissionsDetails().nonEmpty) {
                    println("Profile Permissions:")
                    profile.getPermissionsDetails().foreach { permission =>
                      println(s"  Permission Id: ${permission.getId()}")
                      println(s"  Permission Name: ${permission.getName()}")
                      println(s"  Permission DisplayLabel: ${permission.getDisplayLabel()}")
                    }
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

      getProfile()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}