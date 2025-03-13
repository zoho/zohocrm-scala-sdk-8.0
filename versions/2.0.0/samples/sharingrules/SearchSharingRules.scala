package samples.sharingrules

import java.lang.reflect.Field
import java.util.{ArrayList, Arrays, List, Map}
import com.zoho.api.authenticator.OAuthToken
import com.zoho.api.authenticator.Token
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.sharingrules.SharingRulesOperations.GetSharingRulesParam
import com.zoho.crm.api.sharingrules._
import com.zoho.crm.api.util.{APIResponse, Model}

import scala.collection.mutable.ArrayBuffer

object SearchSharingRules {

  def searchSharingRules(moduleAPIName: String): Unit = {
    val sharingRulesOperations = new SharingRulesOperations(Option(moduleAPIName))
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetSharingRulesParam().page, 1)
    paramInstance.add(new GetSharingRulesParam().perPage, 5)

    val filtersBody = new FiltersBody()
    val criteria = new Criteria()
    criteria.setGroupOperator(Option("and"))
    val group = new ArrayBuffer[Criteria]()

    val groupCriteria1 = new Criteria()
    val field1 = new com.zoho.crm.api.sharingrules.Field()
    field1.setAPIName(Option("shared_from.type"))
    groupCriteria1.setField(Option(field1))
    groupCriteria1.setValue(Option("${EMPTY}"))
    groupCriteria1.setComparator(Option("equal"))
    group.addOne(groupCriteria1)

    val groupCriteria2 = new Criteria()
    val field2 = new com.zoho.crm.api.sharingrules.Field()
    field2.setAPIName(Option("superiors_allowed"))
    groupCriteria2.setField(Option(field2))
    groupCriteria2.setValue(Option("false"))
    groupCriteria2.setComparator(Option("equal"))
    group.addOne(groupCriteria2)

    val groupCriteria3 = new Criteria()
    val field3 = new com.zoho.crm.api.sharingrules.Field()
    field3.setAPIName(Option("status"))
    groupCriteria3.setField(Option(field3))
    groupCriteria3.setValue("active")
    groupCriteria3.setComparator(Option("equal"))
    group.addOne(groupCriteria3)

    val groupCriteria4 = new Criteria()
    groupCriteria4.setGroupOperator(Option("or"))

    val group4 = new ArrayBuffer[Criteria]()

    val group4Criteria1 = new Criteria()
    group4Criteria1.setGroupOperator(Option("and"))

    val group41 = new ArrayBuffer[Criteria]()

    val group41Criteria1 = new Criteria()
    val group41Criteria1field1 = new com.zoho.crm.api.sharingrules.Field()
    group41Criteria1field1.setAPIName(Option("shared_to.resource.id"))
    group41Criteria1.setField(Option(group41Criteria1field1))
    group41Criteria1.setValue(Array(1111078L, 111117098L))
    group41Criteria1.setComparator(Option("in"))
    group41.addOne(group41Criteria1)

    val group41Criteria2 = new Criteria()
    val group41Criteria1field2 = new com.zoho.crm.api.sharingrules.Field()
    group41Criteria1field2.setAPIName(Option("shared_to.type"))
    group41Criteria2.setField(Option(group41Criteria1field2))
    group41Criteria2.setValue("groups")
    group41Criteria2.setComparator(Option("equal"))
    group41.addOne(group41Criteria2)

    group4Criteria1.setGroup(group41)
    group4.addOne(group4Criteria1)

    val group4Criteria2 = new Criteria()
    group4Criteria2.setGroupOperator(Option("and"))

    val group42 = new ArrayBuffer[Criteria]()

    val group42Criteria1 = new Criteria()
    val group42Criteria1field1 = new com.zoho.crm.api.sharingrules.Field()
    group42Criteria1field1.setAPIName(Option("shared_to.resource.id"))
    group42Criteria1.setField(Option(group42Criteria1field1))
    group42Criteria1.setValue(Array(111117078L, 111198L))
    group42.addOne(group42Criteria1)

    val group42Criteria2 = new Criteria()
    val group42Criteria1field2 = new com.zoho.crm.api.sharingrules.Field()
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
    filtersBody.setFilters(ArrayBuffer(criteria))

    val response = sharingRulesOperations.searchSharingRules(filtersBody, Option(paramInstance))

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
                val sharingRules = responseWrapper.getSharingRules()
                sharingRules.foreach { sharingRule =>
                  Option(sharingRule.getModule.get).foreach { module =>
                    println(s"SharingRules Module APIName: ${module.getAPIName}")
                    println(s"SharingRules Module Name: ${module.getName}")
                    println(s"SharingRules Module Id: ${module.getId}")
                  }
                  println(s"SharingRules SuperiorsAllowed: ${sharingRule.getSuperiorsAllowed}")
                  println(s"SharingRules Type: ${sharingRule.getType.getValue}")
                  Option(sharingRule.getSharedTo.get).foreach { sharedTo =>
                    Option(sharedTo.getResource.get).foreach { resource =>
                      println(s"SharingRules SharedTo Resource Name: ${resource.getName}")
                      println(s"SharingRules SharedTo Resource Id: ${resource.getId}")
                    }
                    println(s"SharingRules SharedTo Type: ${sharedTo.getType}")
                    println(s"SharingRules SharedTo Subordinates: ${sharedTo.getSubordinates}")
                  }
                  Option(sharingRule.getSharedFrom.get).foreach { sharedFrom =>
                    Option(sharedFrom.getResource.get).foreach { resource =>
                      println(s"SharingRules SharedFrom Resource Name: ${resource.getName}")
                      println(s"SharingRules SharedFrom Resource Id: ${resource.getId}")
                    }
                    println(s"SharingRules SharedFrom Type: ${sharedFrom.getType}")
                    println(s"SharingRules SharedFrom Subordinates: ${sharedFrom.getSubordinates}")
                  }
                  println(s"SharingRules PermissionType: ${sharingRule.getPermissionType.getValue}")
                  println(s"SharingRules Name: ${sharingRule.getName}")
                  println(s"SharingRules Id: ${sharingRule.getId}")
                  println(s"SharingRules Status: ${sharingRule.getStatus.getValue}")
                  println(s"SharingRules MatchLimitExceeded: ${sharingRule.getMatchLimitExceeded}")
                }

                val info = responseWrapper.getInfo.get
                println(s"SharingRules Info PerPage: ${info.getPerPage}")
                println(s"SharingRules Info Count: ${info.getCount}")
                println(s"SharingRules Info Page: ${info.getPage}")
                println(s"SharingRules Info MoreRecords: ${info.getMoreRecords}")

              case exception: APIException =>
                println(s"Status: ${exception.getStatus.getValue}")
                println(s"Code: ${exception.getCode.getValue}")
                println("Details: ")
                exception.getDetails.foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage.getValue}")
            }
          } else if (apiResponse.getStatusCode != 204) {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
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
      searchSharingRules(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
