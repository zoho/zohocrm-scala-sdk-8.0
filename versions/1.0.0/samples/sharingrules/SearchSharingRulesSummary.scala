package samples.sharingrules

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.sharingrules.{APIException, Criteria, FiltersBody, Module, RulesSummary, SharingRulesOperations, SummaryResponseHandler, SummaryResponseWrapper}
import com.zoho.crm.api.util.{APIResponse, Model}

import java.lang.reflect.Field
import scala.collection.mutable.ArrayBuffer

object SearchSharingRulesSummary {

  def searchSharingRulesSummary(moduleAPIName: String): Unit = {
    val sharingRulesOperations = new SharingRulesOperations(Option(moduleAPIName))
    val request = new FiltersBody
    val criteria = new Criteria
    criteria.setGroupOperator(Option("and"))
    val group = new ArrayBuffer[Criteria]()

    // Group 1: shared_from.type
    val groupCriteria1 = new Criteria
    val field1 = new com.zoho.crm.api.sharingrules.Field
    field1.setAPIName(Option("shared_from.type"))
    groupCriteria1.setField(Option(field1))
    groupCriteria1.setValue("${EMPTY}")
    groupCriteria1.setComparator(Option("equal"))
    group.addOne(groupCriteria1)

    // Group 2: superiors_allowed
    val groupCriteria2 = new Criteria
    val field2 = new com.zoho.crm.api.sharingrules.Field
    field2.setAPIName(Option("superiors_allowed"))
    groupCriteria2.setField(Option(field2))
    groupCriteria2.setValue("false")
    groupCriteria2.setComparator(Option("equal"))
    group.addOne(groupCriteria2)

    // Group 3: status
    val groupCriteria3 = new Criteria
    val field3 = new com.zoho.crm.api.sharingrules.Field
    field3.setAPIName(Option("status"))
    groupCriteria3.setField(Option(field3))
    groupCriteria3.setValue("active")
    groupCriteria3.setComparator(Option("equal"))
    group.addOne(groupCriteria3)

    // Group 4 (OR condition)
    val groupCriteria4 = new Criteria
    groupCriteria4.setGroupOperator(Option("or"))
    val group4 = new ArrayBuffer[Criteria]

    // Group 4.1
    val group4Criteria1 = new Criteria
    group4Criteria1.setGroupOperator(Option("and"))
    val group41 = new ArrayBuffer[Criteria]

    val group41Criteria1 = new Criteria
    val group41Criteria1field1 = new com.zoho.crm.api.sharingrules.Field
    group41Criteria1field1.setAPIName(Option("shared_to.resource.id"))
    group41Criteria1.setField(Option(group41Criteria1field1))
    group41Criteria1.setValue(List(11111777078L, 11111777098L))
    group41Criteria1.setComparator(Option("in"))
    group41.addOne(group41Criteria1)

    val group41Criteria2 = new Criteria
    val group41Criteria1field2 = new com.zoho.crm.api.sharingrules.Field
    group41Criteria1field2.setAPIName(Option("shared_to.type"))
    group41Criteria2.setField(Option(group41Criteria1field2))
    group41Criteria2.setValue("groups")
    group41Criteria2.setComparator(Option("equal"))
    group41.addOne(group41Criteria2)

    group4Criteria1.setGroup(group41)
    group4.addOne(group4Criteria1)

    // Group 4.2
    val group4Criteria2 = new Criteria
    group4Criteria2.setGroupOperator(Option("and"))
    val group42 = new ArrayBuffer[Criteria]

    val group42Criteria1 = new Criteria
    val group42Criteria1field1 = new com.zoho.crm.api.sharingrules.Field
    group42Criteria1field1.setAPIName(Option("shared_to.resource.id"))
    group42Criteria1.setField(Option(group42Criteria1field1))
    group42Criteria1.setValue(List(11111777078L, 11111777098L))
    group42Criteria1.setComparator(Option("in"))
    group42.addOne(group42Criteria1)

    val group42Criteria2 = new Criteria
    val group42Criteria1field2 = new com.zoho.crm.api.sharingrules.Field
    group42Criteria1field2.setAPIName(Option("shared_to.type"))
    group42Criteria2.setField(Option(group42Criteria1field2))
    group42Criteria2.setValue("roles")
    group42Criteria2.setComparator(Option("equal"))
    group42.addOne(group42Criteria2)

    group4Criteria2.setGroup(group42)
    group4.addOne(group4Criteria2)

    groupCriteria4.setGroup(group4)
    group.addOne(groupCriteria4)

    criteria.setGroup(group)
    request.setFilters(ArrayBuffer(criteria))

    val response = sharingRulesOperations.searchSharingRulesSummary(request)

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
              case responseWrapper: SummaryResponseWrapper =>
                val rulesSummary = responseWrapper.getSharingRulesSummary
                rulesSummary.foreach { ruleSummary =>
                  val module = ruleSummary.getModule.get
                  if (module != null) {
                    println(s"RulesSummary Module APIName: ${module.getAPIName}")
                    println(s"RulesSummary Module Id: ${module.getId}")
                  }
                  println(s"RulesSummary RuleComputationStatus: ${ruleSummary.getRuleComputationStatus}")
                  println(s"RulesSummary RuleCount: ${ruleSummary.getRuleCount}")
                }
              case exception: APIException =>
                println(s"Status: ${exception.getStatus.getValue}")
                println(s"Code: ${exception.getCode.getValue}")
                println("Details:")
                exception.getDetails.foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage}")
            }
          } else if (apiResponse.getStatusCode != 204) {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}:${field.get(responseObject)}")
            }
          }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    try {
      val environment = USDataCenter.PRODUCTION
      val token = new OAuthToken.Builder()
        .clientID("Client_Id")
        .clientSecret("Client_Secret")
        .refreshToken("Refresh_Token")
        .build()

      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      val moduleAPIName = "Leads"
      searchSharingRulesSummary(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
