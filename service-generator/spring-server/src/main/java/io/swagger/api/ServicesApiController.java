package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.model.ServiceInformation;
import io.swagger.model.SingleEndpointConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-21T16:14:04.338Z")

@Controller
public class ServicesApiController implements ServicesApi {

    @Autowired
    ServiceInformation serviceInformation;

    public ResponseEntity<SingleEndpointConfiguration> funcfuncId(@ApiParam(value = "ID of func to return", required = true) @PathVariable("service_name") String serviceName) {
        // do some magic!
        Optional<SingleEndpointConfiguration> conf = serviceInformation.getEndpoints()
                .stream()
                .filter(e -> e.getName().toLowerCase().equals(serviceName.toLowerCase()))
                .findFirst();

        if(!conf.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SingleEndpointConfiguration>(conf.get(), HttpStatus.OK);
    }

    public ResponseEntity<ServiceInformation> servicesGet() {
        // do some magic!
        return new ResponseEntity<ServiceInformation>(serviceInformation, HttpStatus.OK);
    }

}
