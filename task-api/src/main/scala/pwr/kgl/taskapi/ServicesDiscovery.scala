package pwr.kgl.taskapi

import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.stereotype.Service
import scala.collection.JavaConverters._

@Service
class ServicesDiscovery(val dc: DiscoveryClient) {

  private val SERVICE_ENPOINTS_DEFINITIONS :String = "/services"
  private val SERVICE_SINGLE_ENPOINT_DEFINITION :String = "/services/%s"

  def getAllServicesNames: List[String] = dc.getServices().asScala.toList

  def getRegisteredServices() = {
    val appsNames: List[String] = getAllServicesNames
    appsNames.map {
      app =>
        val i = dc.getInstances(app).get(0)
    }
  }

  def getServiceEnpoints(service: String) = {
    val url = dc.getInstances(service).get(0).getUri+SERVICE_ENPOINTS_DEFINITIONS

  }
  def getServiceSingleEnpoint(service: String, enpointName: String) = {
    val url = dc.getInstances(service).get(0).getUri+SERVICE_SINGLE_ENPOINT_DEFINITION.format(enpointName)

  }
}




