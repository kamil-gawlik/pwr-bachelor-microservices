package io.swagger.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.FieldDefinition;
import io.swagger.model.ServiceInformation;
import io.swagger.model.SingleEndpointConfiguration;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by kgl on 21.09.17.
 */

@Controller
public class BaseMathApi {

    BaseMathApi(@Autowired ServiceInformation serviceInformation) {
        serviceInformation
                .addEndpointsItem(this.SQRT)
                .addEndpointsItem(this.ADD)
                .addEndpointsItem(this.SQRT_FILE)
        ;
    }

    public static final String SQRT_PATH = "/sqrt";
    private static final SingleEndpointConfiguration SQRT = new SingleEndpointConfiguration()
            .path(SQRT_PATH).name("sqrt").method(SingleEndpointConfiguration.MethodEnum.POST)
            .addInputItem(new FieldDefinition().name("val").type(FieldDefinition.TypeEnum.FLOAT).required(true))
            .addOutputItem(new FieldDefinition().name("res").type(FieldDefinition.TypeEnum.FLOAT).required(true));

    @Data
    static class SqrtJson {
        Float val;
    }

    @Data
    @Builder
    static class SqrtResponse {
        Float res;
    }

    @RequestMapping(value = SQRT_PATH,
            consumes = {"application/json"},
            produces = {"application/json"},
            method = RequestMethod.POST
    )
    public ResponseEntity<SqrtResponse> sqrt(@RequestBody SqrtJson json) {
        if (json.val != null) {
            Float result = new Float(Math.sqrt(json.val));
            return new ResponseEntity<>(SqrtResponse.builder().res(result).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }


    private static final SingleEndpointConfiguration SQRT_FILE = new SingleEndpointConfiguration()
            .path(SQRT_PATH).name("sqrt-file").method(SingleEndpointConfiguration.MethodEnum.POST)
            .consumes("multipart/form-data")
            .produces("application/json")
            .addInputItem(new FieldDefinition().name("file").type(FieldDefinition.TypeEnum.FILE).required(true).additionalDescription("File contain only number"))
            .addInputItem(new FieldDefinition().name("round").type(FieldDefinition.TypeEnum.INT).required(false).additionalDescription("Round result (1-true, 0-false)."))
            .addOutputItem(new FieldDefinition().name("res").type(FieldDefinition.TypeEnum.FILE).required(true));


    @RequestMapping(value = SQRT_PATH,
            consumes = {"multipart/form-data"},
            produces = {"application/json"},
            method = RequestMethod.POST
    )
    public ResponseEntity<SqrtResponse> sqrtForFile(@RequestPart MultipartFile file, @RequestPart(required = false) String task) throws IOException {
        Float result;
        String content = new String(file.getBytes(), "UTF-8").trim();
        result = new Float(Math.sqrt(Double.parseDouble(content)));
        if (task != null) {
            JsonNode json = new ObjectMapper().readTree(task);
            Integer round = Integer.parseInt(json.get("round").asText());
            String formater = "%."+round+"f";
            if (round!=null) {
                result = Float.parseFloat(String.format(formater,result));
            }
        }
        return new ResponseEntity<>(SqrtResponse.builder().res(result).build(), HttpStatus.OK);
    }


    public static final String ADD_PATH = "/add";
    private static final SingleEndpointConfiguration ADD = new SingleEndpointConfiguration()
            .path(ADD_PATH).name("add").method(SingleEndpointConfiguration.MethodEnum.POST)
            .addInputItem(new FieldDefinition().name("val1").type(FieldDefinition.TypeEnum.INT).required(true))
            .addInputItem(new FieldDefinition().name("val2").type(FieldDefinition.TypeEnum.INT).required(true))
            .addOutputItem(new FieldDefinition().name("res").type(FieldDefinition.TypeEnum.INT).required(true));

    @Data
    static class AddJson {
        Integer val1;
        Integer val2;
    }

    @Data
    @Builder
    static class AddReponse {
        Integer res;
    }

    @RequestMapping(value = ADD_PATH,
            consumes = {"application/json"},
            produces = {"application/json"},
            method = RequestMethod.POST
    )
    public ResponseEntity<AddReponse> add(@RequestBody AddJson json) {
        Integer result = json.val1 + json.val2;
        return new ResponseEntity<>(AddReponse.builder().res(result).build(), HttpStatus.OK);
    }


}
