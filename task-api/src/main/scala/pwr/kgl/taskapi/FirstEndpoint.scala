package pwr.kgl.taskapi

import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

/**
  * Created by kgl on 03.10.17.
  */
@Controller
class FirstEndpoint {

  @RequestMapping(value = Array("/test"), method = Array(RequestMethod.GET))
  def testEndpoint: ResponseEntity[String] = {
    return new ResponseEntity[String]("test", HttpStatus.OK)
  }
}
