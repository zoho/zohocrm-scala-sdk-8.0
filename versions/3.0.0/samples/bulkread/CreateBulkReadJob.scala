package samples.bulkread

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.bulkread.{APIException, ActionHandler, ActionWrapper, BulkReadOperations, BodyWrapper, CallBack, Criteria, Query, SuccessResponse}
import com.zoho.crm.api.modules.MinifiedModule
import com.zoho.crm.api.fields.MinifiedField
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.{APIResponse, Choice}

import scala.collection.mutable.ArrayBuffer

object CreateBulkReadJob {

  private def createBulkReadJob(): Unit = {
    val bulkReadOperations = new BulkReadOperations()
    val requestWrapper = new BodyWrapper()
    
    // Set up callback
    val callback = new CallBack()
    callback.setUrl(Option("https://www.example.com/callback"))
    callback.setMethod(new Choice[String]("post"))
    requestWrapper.setCallback(Option(callback))
    
    // Set up query
    val query = new Query()
    val module = new MinifiedModule()
    module.setAPIName(Option("Leads"))
    query.setModule(Option(module))
    
    // Set field API names
    val fieldAPINames = new ArrayBuffer[String]()
    fieldAPINames.addOne("First_Name")
    fieldAPINames.addOne("Last_Name")
    fieldAPINames.addOne("Email")
    fieldAPINames.addOne("Phone")
    fieldAPINames.addOne("Company")
//    query.setFields(fieldAPINames)
    
    // Set page
    query.setPage(Option(1))
    
    // Set up criteria
    val criteria = new Criteria()
    criteria.setGroupOperator(new Choice[String]("or"))
    
    val criteriaList = new ArrayBuffer[Criteria]()
    
    // First group criteria
    val group1 = new Criteria()
    group1.setGroupOperator(new Choice[String]("and"))
    val groupList1 = new ArrayBuffer[Criteria]()
    
    val criteria1 = new Criteria()
    val field1 = new MinifiedField()
    field1.setAPIName(Option("Lead_Status"))
    criteria1.setField(Option(field1))
    criteria1.setComparator(new Choice[String]("equal"))
    criteria1.setValue("Not Contacted")
    groupList1.addOne(criteria1)
    
    val criteria2 = new Criteria()
    val field2 = new MinifiedField()
    field2.setAPIName(Option("Owner"))
    criteria2.setField(Option(field2))
    criteria2.setComparator(new Choice[String]("in"))
    val owners = new ArrayBuffer[String]()
    owners.addOne("1055806000000173001")
    criteria2.setValue(owners)
    groupList1.addOne(criteria2)
    
    group1.setGroup(groupList1)
    criteriaList.addOne(group1)
    
    // Second group criteria
    val group2 = new Criteria()
    group2.setGroupOperator(new Choice[String]("or"))
    val groupList2 = new ArrayBuffer[Criteria]()
    
    val criteria3 = new Criteria()
    val field3 = new MinifiedField()
    field3.setAPIName(Option("Company"))
    criteria3.setField(Option(field3))
    criteria3.setComparator(new Choice[String]("equal"))
    criteria3.setValue("Zoho Corporation")
    groupList2.addOne(criteria3)
    
    val criteria4 = new Criteria()
    val field4 = new MinifiedField()
    field4.setAPIName(Option("Created_Time"))
    criteria4.setField(Option(field4))
    criteria4.setComparator(new Choice[String]("between"))
    val createdTimeRange = new ArrayBuffer[String]()
    createdTimeRange.addOne("2024-01-01T00:00:00+05:30")
    createdTimeRange.addOne("2024-12-31T23:59:59+05:30")
    criteria4.setValue(createdTimeRange)
    groupList2.addOne(criteria4)
    
    group2.setGroup(groupList2)
    criteriaList.addOne(group2)
    
    criteria.setGroup(criteriaList)
    query.setCriteria(Option(criteria))
    requestWrapper.setQuery(Option(query))
    
    val response: Option[APIResponse[ActionHandler]] = bulkReadOperations.createBulkReadJob(requestWrapper)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getData()
                for (actionResponse <- actionResponses) {
                  actionResponse match {
                    case successResponse: SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus().getValue}")
                      println(s"Code: ${successResponse.getCode().getValue}")
                      println("Details: ")
                      successResponse.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"$key: $value")
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
                      println(s"Message: ${exception.getMessage()}")
                  }
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

      createBulkReadJob()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}