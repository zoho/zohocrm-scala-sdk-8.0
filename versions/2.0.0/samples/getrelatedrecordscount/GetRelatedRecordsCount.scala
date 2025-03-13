package samples.getrelatedrecordscount

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.getrelatedrecordscount.{APIException, ActionHandler, ActionResponse, ActionWrapper, BodyWrapper, GetRelatedRecordCount, GetRelatedRecordsCountOperations, RelatedList, SuccessResponse}
import com.zoho.crm.api.dc.{DataCenter, USDataCenter}
import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

object GetRelatedRecordsCount {

  @throws[Exception]
  def getRelatedRecordsCount(recordId: Long, moduleAPIName: String): Unit = {
    val getRelatedRecordsCountOperations = new GetRelatedRecordsCountOperations(recordId, moduleAPIName)
    val request = new BodyWrapper()
    val getRelatedRecordsCount = new ArrayBuffer[GetRelatedRecordCount]()

    val getRelatedRecordsCount1 = new GetRelatedRecordCount()
    val relatedList = new RelatedList()
    relatedList.setAPIName(Option("Notes"))
    relatedList.setId(Option(34770602197L))
    getRelatedRecordsCount1.setRelatedList(Option(relatedList))

    getRelatedRecordsCount.addOne(getRelatedRecordsCount1)
    request.setGetRelatedRecordsCount(getRelatedRecordsCount)

    val response = getRelatedRecordsCountOperations.getRelatedRecordsCount(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getGetRelatedRecordsCount
                actionResponses.foreach {
                  case successResponse: SuccessResponse =>
                    println(s"Count: ${successResponse.getCount}")
                    val relatedList = successResponse.getRelatedList
                    if (relatedList != null) {
                      println(s"RelatedList APIName: ${relatedList.get.getAPIName}")
                      println(s"RelatedList Id: ${relatedList.get.getId}")
                    }

                  case exception: APIException =>
                    println(s"Status: ${exception.getStatus.getValue}")
                    println(s"Code: ${exception.getCode.getValue}")
                    println("Details: ")
                    exception.getDetails.foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"$key: $value")
                      }
                    }
                    println(s"Message: ${exception.getMessage}")
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus.getValue}")
                println(s"Code: ${exception.getCode.getValue}")
                println("Details: ")
                exception.getDetails.foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage}")

              case _ => println("Unexpected response type.")
            }
          } else {
            val responseObject = apiResponse.getModel
            val clazz = responseObject.getClass
            val fields = clazz.getDeclaredFields
            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }

        case None => println("No response from GetRelatedRecordsCount API.")
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: DataCenter.Environment = USDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("Client_Id")
        .clientSecret("Client_Secret")
        .refreshToken("Refresh_Token")
        .build()

      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      val recordId: Long = 34770002L
      val moduleAPIName: String = "Leads"
      getRelatedRecordsCount(recordId, moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
