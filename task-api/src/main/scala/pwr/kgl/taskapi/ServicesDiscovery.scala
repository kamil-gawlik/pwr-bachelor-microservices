package pwr.kgl.taskapi

import java.io.File
import java.net.URI

import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.core.io.FileSystemResource
import org.springframework.http.{HttpEntity, HttpHeaders, MediaType}
import org.springframework.stereotype.Service
import org.springframework.util.{LinkedMultiValueMap, MultiValueMap}
import org.springframework.web.client.RestTemplate
import org.springframework.web.multipart.MultipartFile

import scala.collection.JavaConverters._

@Service
class ServicesDiscovery(val dc: DiscoveryClient) {

  private val SERVICE_ENDPOINTS_DEFINITIONS: String = "/services"
  private val SERVICE_SINGLE_ENDPOINT_DEFINITION: String = "/services/%s"

  private lazy val rt = new RestTemplate();
  implicit val formats = DefaultFormats


  def getAllServicesNames: List[String] = dc.getServices().asScala.toList.filter(_ != "frontend").filter(_ != "task-api")

  //  def getRegisteredServices = getAllServicesNames.map {
  //    app => dc.getInstances(app).get(0)
  //  }

  def getRegisteredServiceUri(service: String): URI = {
    dc.getInstances(service).get(0).getUri
  }

  def getRegisteredServiceUris(service: String): List[URI] = {
    dc.getInstances(service).asScala.toList.map(s => s.getUri)
  }

  def getServiceEndpoints(service: String): Option[ServiceInformation] = {
    val url: String = getRegisteredServiceUri(service) + SERVICE_ENDPOINTS_DEFINITIONS
    var response: String = ""
    try {
      response = rt.getForObject(url, classOf[String])
    } catch {
      case _: Exception => println("No services available for %s, skipping".format(service));
        return None
    }
    return Some(parse(response).extract[ServiceInformation])
  }

  def getServiceSingleEndpoint(service: String, endpointName: String) = {
    val url = getRegisteredServiceUri(service) + SERVICE_SINGLE_ENDPOINT_DEFINITION.format(endpointName)
    val response = rt.getForObject(url, classOf[String])

    parse(response).extract[SingleEndpointConfiguration]
  }

  def getAllRegisteredServicesWithEndpoints: List[(String, ServiceInformation)] = {
    getAllServicesNames.flatMap { service =>
      getServiceEndpoints(service) match {
        case Some(endpoints) => Some(service -> endpoints)
        case _ => None
      }
    }
  }

  def getAllRegisteredServicesWithEndpointsNames: List[ShortInfo] = {
    getAllRegisteredServicesWithEndpoints.map { a =>
      val serviceName = a._1
      val endpointsNames = a._2.endpoints.map { endpoint: SingleEndpointConfiguration => endpoint.name }
      ShortInfo(serviceName, endpointsNames)
    }
  }

  def sendTask(service: String, endpointName: String, task: String) = {
    val url = "%s/%s".format(getRegisteredServiceUri(service), endpointName)
    val endpoint = getServiceSingleEndpoint(service, endpointName)
    endpoint.method.toLowerCase match {
      case "get" => rt.getForEntity(url, classOf[String])
      case "post" => {
        val headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)
        val entity = new HttpEntity[String](task, headers)
        rt.postForEntity(url, entity, classOf[String])
      }
      case _ => throw new NotImplementedError("No implementation for method %s".format(endpoint.method))
    }
  }

  def sendTask(service: String, endpointName: String, task: String, file: MultipartFile) = {
    val url = "%s/%s".format(getRegisteredServiceUri(service), endpointName)
    val lMap = new LinkedMultiValueMap[String, Object]
    if (file != null) {
      val tmpFile: File = createTmpFile(file)
      lMap.add("file", new FileSystemResource(tmpFile))
    }
    if (task != null) {
      lMap.add("task", task)
    }
    val headers = new HttpHeaders()
    headers.setContentType(MediaType.MULTIPART_FORM_DATA)
    val entity = new HttpEntity[MultiValueMap[String, Object]](lMap, headers)

    rt.postForEntity(url, entity, classOf[String])
  }

  def createTmpFile(file: MultipartFile): File = {
    val extension = "." + file.getOriginalFilename.split('.').last
    val tempFile: File = File.createTempFile("temp", extension)
    file.transferTo(tempFile)
    tempFile
  }
}



