package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SingleEndpointConfiguration
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-21T16:14:04.338Z")

public class SingleEndpointConfiguration {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("path")
    private String path = null;

    /**
     * request type
     */
    public enum MethodEnum {
        GET("GET"),

        PUT("PUT"),

        POST("POST");

        private String value;

        MethodEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static MethodEnum fromValue(String text) {
            for (MethodEnum b : MethodEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("method")
    private MethodEnum method = null;

    @JsonProperty("input")
    private List<FieldDefinition> input = new ArrayList<FieldDefinition>();

    @JsonProperty("output")
    private List<FieldDefinition> output = new ArrayList<FieldDefinition>();

    @JsonProperty("consumes")
    private String consumes = null;

    @JsonProperty("produces")
    private String produces = null;

    public SingleEndpointConfiguration name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Short service name
     *
     * @return name
     **/
    @ApiModelProperty(required = true, value = "Short service name")
    @NotNull


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SingleEndpointConfiguration path(String path) {
        this.path = path;
        return this;
    }

    /**
     * relative path to enpoint
     *
     * @return path
     **/
    @ApiModelProperty(required = true, value = "relative path to enpoint")
    @NotNull


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public SingleEndpointConfiguration method(MethodEnum method) {
        this.method = method;
        return this;
    }

    /**
     * request type
     *
     * @return method
     **/
    @ApiModelProperty(required = true, value = "request type")
    @NotNull


    public MethodEnum getMethod() {
        return method;
    }

    public void setMethod(MethodEnum method) {
        this.method = method;
    }

    public SingleEndpointConfiguration input(List<FieldDefinition> input) {
        this.input = input;
        return this;
    }

    public SingleEndpointConfiguration addInputItem(FieldDefinition inputItem) {
        this.input.add(inputItem);
        return this;
    }

    /**
     * Detailed input descriptions
     *
     * @return input
     **/
    @ApiModelProperty(required = true, value = "Detailed input descriptions")
    @NotNull

    @Valid

    public List<FieldDefinition> getInput() {
        return input;
    }

    public void setInput(List<FieldDefinition> input) {
        this.input = input;
    }

    public SingleEndpointConfiguration output(List<FieldDefinition> output) {
        this.output = output;
        return this;
    }

    public SingleEndpointConfiguration addOutputItem(FieldDefinition outputItem) {
        this.output.add(outputItem);
        return this;
    }

    /**
     * Detailed input descriptions
     *
     * @return output
     **/
    @ApiModelProperty(required = true, value = "Detailed input descriptions")
    @NotNull

    @Valid

    public List<FieldDefinition> getOutput() {
        return output;
    }

    public void setOutput(List<FieldDefinition> output) {
        this.output = output;
    }


    public SingleEndpointConfiguration consumes(String consumes) {
        this.consumes = consumes;
        return this;
    }

    /**
     * Content type of consumed input - default \"application/json\"
     *
     * @return consumes
     **/
    @ApiModelProperty(value = "Content type of consumed input - default \"application/json\"")


    public String getConsumes() {
        return consumes;
    }

    public void setConsumes(String consumes) {
        this.consumes = consumes;
    }

    public SingleEndpointConfiguration produces(String produces) {
        this.produces = produces;
        return this;
    }

    /**
     * Content type of output - \"application/json\"
     *
     * @return produces
     **/
    @ApiModelProperty(value = "Content type of output - \"application/json\"")


    public String getProduces() {
        return produces;
    }

    public void setProduces(String produces) {
        this.produces = produces;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SingleEndpointConfiguration singleEndpointConfiguration = (SingleEndpointConfiguration) o;
        return Objects.equals(this.name, singleEndpointConfiguration.name) &&
                Objects.equals(this.path, singleEndpointConfiguration.path) &&
                Objects.equals(this.method, singleEndpointConfiguration.method) &&
                Objects.equals(this.input, singleEndpointConfiguration.input) &&
                Objects.equals(this.output, singleEndpointConfiguration.output) &&
                Objects.equals(this.consumes, singleEndpointConfiguration.consumes) &&
                Objects.equals(this.produces, singleEndpointConfiguration.produces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path, method, input, output, consumes, produces);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SingleEndpointConfiguration {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    input: ").append(toIndentedString(input)).append("\n");
        sb.append("    output: ").append(toIndentedString(output)).append("\n");
        sb.append("    consumes: ").append(toIndentedString(consumes)).append("\n");
        sb.append("    produces: ").append(toIndentedString(produces)).append("\n");
        sb.append("}");
        return sb.toString();
    }


    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

