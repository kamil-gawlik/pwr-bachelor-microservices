package pwr.kgl.taskapi

import org.json4s.NoTypeHints
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.write
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._


/**
  * Created by kgl on 03.10.17.
  */
@Controller
class ServicesInformationsApi(val sd: ServicesDiscovery) {
  implicit val formats = Serialization.formats(NoTypeHints)

  @RequestMapping(value = Array("/services"), method = Array(RequestMethod.GET), produces = Array("application/json"))
  def getServicesNames: ResponseEntity[String] = {
    val res = write(sd.getAllRegisteredServicesWithEndpointsNames)
    new ResponseEntity(res, HttpStatus.OK)
  }

  @RequestMapping(value = Array("/services/{service}"), method = Array(RequestMethod.GET), produces = Array("application/json"))
  def getServiceEndpoints(@PathVariable service: String): ResponseEntity[String] = {
    val res = write(sd.getServiceEndpoints(service))
    new ResponseEntity(res, HttpStatus.OK)
  }

  @RequestMapping(value = Array("/services/{service}/{endpointName}"), method = Array(RequestMethod.GET), produces = Array("application/json"))
  def getServiceEndpoint(@PathVariable service: String, @PathVariable endpointName: String): ResponseEntity[String] = {
    val res = write(sd.getServiceSingleEndpoint(service, endpointName))
    new ResponseEntity(res, HttpStatus.OK)
  }

  @RequestMapping(value = Array("/services/{service}/{endpointName}"), method = Array(RequestMethod.POST), produces = Array("application/json"), consumes = Array("application/json"))
  def sendTaskToEndpoint(@PathVariable service: String, @PathVariable endpointName: String, @RequestBody task: String ): ResponseEntity[String] = {
    val res = sd.sendTask(service, endpointName, task)
    res
  }
}
