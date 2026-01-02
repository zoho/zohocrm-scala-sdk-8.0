package samples.features

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.features.{APIException, FeaturesOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.{Initializer, dc}
import com.zoho.crm.api.util.{APIResponse, Model}

object GetDataEnrichment {

  @throws[Exception]
  def getDataEnrichment(): Unit = {
    val featuresOperations = new FeaturesOperations()
    val response: Option[APIResponse[ResponseHandler]] = featuresOperations.getDataEnrichment()

    if (response != null) {
      response match {
        case Some(apiResponse)=>
        println(s"Status Code: ${apiResponse.getStatusCode}")

        apiResponse.getStatusCode match {
          case 204 => println("No Content")
          case 304 => println("Not Modified")
          case _ =>
            if (apiResponse.isExpected) {
              apiResponse.getObject match {
                case responseWrapper: ResponseWrapper =>
                  val features = responseWrapper.getFeatures()
                  if (features != null) {
                    features.foreach { feature =>
                      val components = feature.getComponents()
                      if (components != null) {
                        components.foreach { component =>
                          println(s"Feature Component APIName : ${component.getAPIName()}")
                          println(s"Feature Component ModuleSupported : ${component.getModuleSupported()}")

                          Option(component.getDetails()).foreach { detail =>
                            detail match {
                              case Some(detail_1)=>
                                Option(detail_1.getLimits()).foreach {
                                  case Some(limit1) =>
                                    println(s"Feature Component Detail Limit EditionLimit: ${limit1.getEditionLimit()}")
                                    println(s"Feature Component Detail Limit Total: ${limit1.getTotal()}")
                                }
                                Option(detail_1.getUsedCount()).foreach {
                                  case Some(usedCount)=>
                                    println(s"Feature Component Detail UsedCount EditionLimit: ${usedCount.getEditionLimit()}")
                                    println(s"Feature Component Detail UsedCount Total: ${usedCount.getTotal()}")
                                }
                            }
                            println(s"Feature Component FeatureLabel : ${component.getFeatureLabel()}")
                          }
                        }
                      }

                      println(s"Feature APIName : ${feature.getAPIName()}")
                      val parentFeature = feature.getParentFeature()
                      if (parentFeature != null && parentFeature.isDefined){
                        parentFeature match{
                          case Some(parentFeature_1) =>
                            println(s"Feature ParentFeature APIName: ${parentFeature_1.getAPIName()}")
                        }
                      }
                      println(s"Feature ModuleSupported : ${feature.getModuleSupported()}")

                      Option(feature.getDetails()).foreach {
                        case Some(detail)=>
                          if (detail.getLimits().isDefined) {
                            Option(detail.getLimits()).foreach {
                              case Some(limit) =>
                                println(s"Feature Detail Limit EditionLimit: ${limit.getEditionLimit()}")
                                println(s"Feature Detail Limit Total: ${limit.getTotal()}")
                            }
                          }
                          if (detail.getUsedCount().isDefined) {
                            Option(detail.getUsedCount()).foreach {
                              case Some(usedCount) =>
                                println(s"Feature Component Detail UsedCount EditionLimit: ${usedCount.getEditionLimit()}")
                                println(s"Feature Component Detail UsedCount Total: ${usedCount.getTotal()}")
                            }
                          }
                      }

                      println(s"Feature FeatureLabel : ${feature.getFeatureLabel()}")
                    }
                  }

                case apiException: APIException =>
                  println(s"Status: ${apiException.getStatus().getValue}")
                  println(s"Code: ${apiException.getCode().getValue}")
                  println("Details: ")
                  apiException.getDetails().foreach { details =>
                    details.foreach { case (key, value) =>
                      println(s"$key: $value")
                    }
                  }
                  println(s"Message: ${apiException.getMessage()}")

                case _ =>
                  val responseObject: Any = apiResponse.getModel
                  val fields = responseObject.getClass.getDeclaredFields
                  fields.foreach { field =>
                    field.setAccessible(true)
                    println(s"${field.getName}: ${field.get(responseObject)}")
                  }
              }
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
      getDataEnrichment()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
