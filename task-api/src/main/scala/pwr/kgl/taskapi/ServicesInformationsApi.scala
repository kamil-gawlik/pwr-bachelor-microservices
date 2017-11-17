package pwr.kgl.taskapi

import com.sun.istack.internal.Nullable
import org.json4s.NoTypeHints
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.write
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._
import org.springframework.web.multipart.MultipartFile


/**
  * Created by kgl on 03.10.17.
  */
@Controller
class ServicesInformationsApi(val sd: ServicesDiscovery) {
  implicit val formats = Serialization.formats(NoTypeHints)

  @CrossOrigin
  @RequestMapping(value = Array("/services"), method = Array(RequestMethod.GET), produces = Array("application/json"))
  def getServicesNames: ResponseEntity[String] = {
    val res = write(sd.getAllRegisteredServicesWithEndpointsNames)
    new ResponseEntity(res, HttpStatus.OK)
  }

  @CrossOrigin
  @RequestMapping(value = Array("/services/{service}"), method = Array(RequestMethod.GET), produces = Array("application/json"))
  def getServiceEndpoints(@PathVariable service: String): ResponseEntity[String] = {
    val res = write(sd.getServiceEndpoints(service).getOrElse("No services available for %s service".format(service)))
    new ResponseEntity(res, HttpStatus.OK)
  }

  @CrossOrigin
  @RequestMapping(value = Array("/services/{service}/{endpointName}"), method = Array(RequestMethod.GET), produces = Array("application/json"))
  def getServiceEndpoint(@PathVariable service: String, @PathVariable endpointName: String): ResponseEntity[String] = {
    val res = write(sd.getServiceSingleEndpoint(service, endpointName))
    new ResponseEntity(res, HttpStatus.OK)
  }

  @CrossOrigin
  @RequestMapping(
    value = Array("/services/{service}/{endpointName}"),
    method = Array(RequestMethod.POST),
    produces = Array("application/json"),
    consumes = Array("application/json")
  )
  def sendTaskToEndpoint(@PathVariable service: String, @PathVariable endpointName: String,
                         @RequestPart task: String,
                         @RequestPart(required = false) @Nullable file: MultipartFile
                        ): ResponseEntity[String] = {
    sd.sendTask(service, endpointName, task)
  }

  @CrossOrigin
  @RequestMapping(
    value = Array("/services/{service}/{endpointName}"),
    method = Array(RequestMethod.POST),
    produces = Array("application/json"),
    consumes = Array("multipart/form-data")
  )
  def sendTaskToEndpointWithFile(@PathVariable service: String, @PathVariable endpointName: String,
                                 @RequestPart(required = false) @Nullable file: MultipartFile,
                                 @RequestPart(required = false) task: String,
                                ): ResponseEntity[String] = {
    sd.sendTask(service, endpointName, task, file)
  }

}
