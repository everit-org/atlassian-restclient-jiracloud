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
import org.openapitools.client.model.ProjectIssueCreateMetadata;

/**
 * The wrapper for the issue creation metadata for a list of projects.
 */
@ApiModel(description = "The wrapper for the issue creation metadata for a list of projects.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-08-30T01:56:21.684+02:00[Europe/Prague]")
public class IssueCreateMetadata {
  @JsonProperty("expand")
  private String expand;

  @JsonProperty("projects")
  private List<ProjectIssueCreateMetadata> projects = new ArrayList<>();

   /**
   * Expand options that include additional project details in the response.
   * @return expand
  **/
  @ApiModelProperty(value = "Expand options that include additional project details in the response.")
  public String getExpand() {
    return expand;
  }

   /**
   * List of projects and their issue creation metadata.
   * @return projects
  **/
  @ApiModelProperty(value = "List of projects and their issue creation metadata.")
  public List<ProjectIssueCreateMetadata> getProjects() {
    return projects;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueCreateMetadata issueCreateMetadata = (IssueCreateMetadata) o;
    return Objects.equals(this.expand, issueCreateMetadata.expand) &&
        Objects.equals(this.projects, issueCreateMetadata.projects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expand, projects);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueCreateMetadata {\n");
    sb.append("    expand: ").append(toIndentedString(expand)).append("\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
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
