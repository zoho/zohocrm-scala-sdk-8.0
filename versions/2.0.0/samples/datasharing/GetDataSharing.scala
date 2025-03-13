package samples.datasharing

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.datasharing.{APIException, DataSharingOperations, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.USDataCenter

object GetDataSharing{

  @throws[Exception]
  def getDataSharing(): Unit = {
    val dataSharingOperations = new DataSharingOperations()
    val response = dataSharingOperations.getDataSharing()
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
                val dataSharingList = responseWrapper.getDataSharing()
                for (dataSharing <- dataSharingList) {
                  println(s"DataSharing PublicInPortals: ${dataSharing.getPublicInPortals()}")
                  println(s"DataSharing ShareType: ${dataSharing.getShareType().getValue}")

                  val module = dataSharing.getModule().get
                  if (module != null) {
                    println(s"DataSharing Module APIName: ${module.getAPIName()}")
                    println(s"DataSharing Module Id: ${module.getId()}")
                  }

                  println(s"DataSharing RuleComputationRunning: ${dataSharing.getRuleComputationRunning()}")
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
                println(s"Message: ${exception.getMessage().getValue}")

              case _ => println("Unexpected response type.")
            }
          } else {
            val responseObject = apiResponse.getModel
            val clazz = responseObject.getClass
            val fields = clazz.getDeclaredFields
            for (field <- fields) {
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: Environment = USDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("client_id")
        .clientSecret("client_secret")
        .grantToken("grant_token")
        .build()
      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      getDataSharing()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }

}