/*
 * The Jira Cloud platform REST API
 * Jira Cloud platform REST API documentation
 *
 * The version of the OpenAPI document: 1001.0.0-SNAPSHOT
 * Contact: ecosystem@atlassian.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.WorkflowSchemeAssociations;

/**
 * A container for a list of workflow schemes together with the projects they are associated with.
 */
@ApiModel(description = "A container for a list of workflow schemes together with the projects they are associated with.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-08-30T01:56:21.684+02:00[Europe/Prague]")
public class ContainerOfWorkflowSchemeAssociations {
  @JsonProperty("values")
  private List<WorkflowSchemeAssociations> values = new ArrayList<>();

  public ContainerOfWorkflowSchemeAssociations values(List<WorkflowSchemeAssociations> values) {
    this.values = values;
    return this;
  }

  public ContainerOfWorkflowSchemeAssociations addValuesItem(WorkflowSchemeAssociations valuesItem) {
    this.values.add(valuesItem);
    return this;
  }

   /**
   * A list of workflow schemes together with projects they are associated with.
   * @return values
  **/
  @ApiModelProperty(required = true, value = "A list of workflow schemes together with projects they are associated with.")
  public List<WorkflowSchemeAssociations> getValues() {
    return values;
  }

  public void setValues(List<WorkflowSchemeAssociations> values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContainerOfWorkflowSchemeAssociations containerOfWorkflowSchemeAssociations = (ContainerOfWorkflowSchemeAssociations) o;
    return Objects.equals(this.values, containerOfWorkflowSchemeAssociations.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContainerOfWorkflowSchemeAssociations {\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
