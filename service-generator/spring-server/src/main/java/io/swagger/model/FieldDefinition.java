package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FieldDefinition
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-21T16:14:04.338Z")

public class FieldDefinition   {
  @JsonProperty("name")
  private String name = null;

  /**
   * Type of field
   */
  public enum TypeEnum {
    STRING("string"),
    
    INT("int"),
    
    FLOAT("float"),
    
    FILE("file");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("required")
  private Boolean required = null;

  @JsonProperty("additional_description")
  private String additionalDescription = null;

  public FieldDefinition name(String name) {
    this.name = name;
    return this;
  }

   /**
   * json field name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "json field name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FieldDefinition type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Type of field
   * @return type
  **/
  @ApiModelProperty(required = true, value = "Type of field")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public FieldDefinition required(Boolean required) {
    this.required = required;
    return this;
  }

   /**
   * is field required
   * @return required
  **/
  @ApiModelProperty(required = true, value = "is field required")
  @NotNull


  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public FieldDefinition additionalDescription(String additionalDescription) {
    this.additionalDescription = additionalDescription;
    return this;
  }

   /**
   * Get additionalDescription
   * @return additionalDescription
  **/
  @ApiModelProperty(value = "")


  public String getAdditionalDescription() {
    return additionalDescription;
  }

  public void setAdditionalDescription(String additionalDescription) {
    this.additionalDescription = additionalDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldDefinition fieldDefinition = (FieldDefinition) o;
    return Objects.equals(this.name, fieldDefinition.name) &&
        Objects.equals(this.type, fieldDefinition.type) &&
        Objects.equals(this.required, fieldDefinition.required) &&
        Objects.equals(this.additionalDescription, fieldDefinition.additionalDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, required, additionalDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldDefinition {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    additionalDescription: ").append(toIndentedString(additionalDescription)).append("\n");
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

