package pwr.kgl.taskapi

import org.json4s.NoTypeHints
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.write
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}


/**
  * Created by kgl on 03.10.17.
  */
@Controller
class ServicesInformations(val sd: ServicesDiscovery) {
  implicit val formats = Serialization.formats(NoTypeHints)

  @RequestMapping(value = Array("/services"), method = Array(RequestMethod.GET), produces = Array("application/json"))
  def testEndpoint: ResponseEntity[String] = {
    val res = write(sd.getAllServicesNames)
    new ResponseEntity(res, HttpStatus.OK)
  }

}
