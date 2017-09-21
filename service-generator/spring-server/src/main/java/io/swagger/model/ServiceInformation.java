package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ServiceInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-21T16:14:04.338Z")
@Component
public class ServiceInformation   {
  @JsonProperty("endpoints")
  private List<SingleEndpointConfiguration> endpoints = new ArrayList<SingleEndpointConfiguration>();

  public ServiceInformation endpoints(List<SingleEndpointConfiguration> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public ServiceInformation addEndpointsItem(SingleEndpointConfiguration endpointsItem) {
    this.endpoints.add(endpointsItem);
    return this;
  }

   /**
   * Get endpoints
   * @return endpoints
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<SingleEndpointConfiguration> getEndpoints() {
    return endpoints;
  }

  public void setEndpoints(List<SingleEndpointConfiguration> endpoints) {
    this.endpoints = endpoints;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceInformation serviceInformation = (ServiceInformation) o;
    return Objects.equals(this.endpoints, serviceInformation.endpoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpoints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceInformation {\n");
    
    sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
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

