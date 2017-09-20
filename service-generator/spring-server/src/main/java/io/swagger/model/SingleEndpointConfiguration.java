package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.FieldDefinition;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SingleEndpointConfiguration
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-20T17:09:45.498Z")

public class SingleEndpointConfiguration   {
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

  @JsonProperty("fields")
  private List<FieldDefinition> fields = new ArrayList<FieldDefinition>();

  public SingleEndpointConfiguration path(String path) {
    this.path = path;
    return this;
  }

   /**
   * relative path to enpoint
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

  public SingleEndpointConfiguration fields(List<FieldDefinition> fields) {
    this.fields = fields;
    return this;
  }

  public SingleEndpointConfiguration addFieldsItem(FieldDefinition fieldsItem) {
    this.fields.add(fieldsItem);
    return this;
  }

   /**
   * Detailed filed descriptions
   * @return fields
  **/
  @ApiModelProperty(required = true, value = "Detailed filed descriptions")
  @NotNull

  @Valid

  public List<FieldDefinition> getFields() {
    return fields;
  }

  public void setFields(List<FieldDefinition> fields) {
    this.fields = fields;
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
    return Objects.equals(this.path, singleEndpointConfiguration.path) &&
        Objects.equals(this.method, singleEndpointConfiguration.method) &&
        Objects.equals(this.fields, singleEndpointConfiguration.fields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, method, fields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SingleEndpointConfiguration {\n");
    
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
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

