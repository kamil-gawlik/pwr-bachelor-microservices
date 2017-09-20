package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.model.ServiceInformation;
import io.swagger.model.SingleEndpointConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-20T17:09:45.498Z")

@Controller
public class InfoApiController implements InfoApi {


    public @ResponseBody ResponseEntity<SingleEndpointConfiguration> funcfuncId(@ApiParam(value = "ID of func to return",required=true ) @PathVariable("funcId") Long funcId) {
        // do some magic!
        return new ResponseEntity<SingleEndpointConfiguration>(HttpStatus.OK);
    }

    public @ResponseBody
    ResponseEntity<ServiceInformation> infoGet() {
        // do some magic!
        return new ResponseEntity<ServiceInformation>(new ServiceInformation(), HttpStatus.OK);
    }

}
