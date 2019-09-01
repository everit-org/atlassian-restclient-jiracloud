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


package org.everit.atlassian.restclient.jiracloud.v2.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Details about the mapping between issue types and a workflow.
 */
@ApiModel(description = "Details about the mapping between issue types and a workflow.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:56:58.037+02:00[Europe/Prague]")
public class IssueTypesWorkflowMapping {
  @JsonProperty("workflow")
  private String workflow;

  @JsonProperty("issueTypes")
  private List<String> issueTypes = new ArrayList<>();

  @JsonProperty("defaultMapping")
  private Boolean defaultMapping;

  @JsonProperty("updateDraftIfNeeded")
  private Boolean updateDraftIfNeeded;

  public IssueTypesWorkflowMapping workflow(String workflow) {
    this.workflow = workflow;
    return this;
  }

   /**
   * The name of the workflow. Optional if updating the workflow-issue types mapping.
   * @return workflow
  **/
  @ApiModelProperty(value = "The name of the workflow. Optional if updating the workflow-issue types mapping.")
  public String getWorkflow() {
    return workflow;
  }

  public void setWorkflow(String workflow) {
    this.workflow = workflow;
  }

  public IssueTypesWorkflowMapping issueTypes(List<String> issueTypes) {
    this.issueTypes = issueTypes;
    return this;
  }

  public IssueTypesWorkflowMapping addIssueTypesItem(String issueTypesItem) {
    if (this.issueTypes == null) {
      this.issueTypes = new ArrayList<>();
    }
    this.issueTypes.add(issueTypesItem);
    return this;
  }

   /**
   * The list of issue type IDs.
   * @return issueTypes
  **/
  @ApiModelProperty(value = "The list of issue type IDs.")
  public List<String> getIssueTypes() {
    return issueTypes;
  }

  public void setIssueTypes(List<String> issueTypes) {
    this.issueTypes = issueTypes;
  }

  public IssueTypesWorkflowMapping defaultMapping(Boolean defaultMapping) {
    this.defaultMapping = defaultMapping;
    return this;
  }

   /**
   * Indicates whether the workflow is the default workflow for the workflow scheme.
   * @return defaultMapping
  **/
  @ApiModelProperty(value = "Indicates whether the workflow is the default workflow for the workflow scheme.")
  public Boolean getDefaultMapping() {
    return defaultMapping;
  }

  public void setDefaultMapping(Boolean defaultMapping) {
    this.defaultMapping = defaultMapping;
  }

  public IssueTypesWorkflowMapping updateDraftIfNeeded(Boolean updateDraftIfNeeded) {
    this.updateDraftIfNeeded = updateDraftIfNeeded;
    return this;
  }

   /**
   * Indicates whether a draft workflow scheme is created or updated when updating an active workflow scheme. The draft is updated with the new workflow-issue types mapping. Defaults to &#x60;false&#x60;.
   * @return updateDraftIfNeeded
  **/
  @ApiModelProperty(value = "Indicates whether a draft workflow scheme is created or updated when updating an active workflow scheme. The draft is updated with the new workflow-issue types mapping. Defaults to `false`.")
  public Boolean getUpdateDraftIfNeeded() {
    return updateDraftIfNeeded;
  }

  public void setUpdateDraftIfNeeded(Boolean updateDraftIfNeeded) {
    this.updateDraftIfNeeded = updateDraftIfNeeded;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueTypesWorkflowMapping issueTypesWorkflowMapping = (IssueTypesWorkflowMapping) o;
    return Objects.equals(this.workflow, issueTypesWorkflowMapping.workflow) &&
        Objects.equals(this.issueTypes, issueTypesWorkflowMapping.issueTypes) &&
        Objects.equals(this.defaultMapping, issueTypesWorkflowMapping.defaultMapping) &&
        Objects.equals(this.updateDraftIfNeeded, issueTypesWorkflowMapping.updateDraftIfNeeded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workflow, issueTypes, defaultMapping, updateDraftIfNeeded);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueTypesWorkflowMapping {\n");
    sb.append("    workflow: ").append(toIndentedString(workflow)).append("\n");
    sb.append("    issueTypes: ").append(toIndentedString(issueTypes)).append("\n");
    sb.append("    defaultMapping: ").append(toIndentedString(defaultMapping)).append("\n");
    sb.append("    updateDraftIfNeeded: ").append(toIndentedString(updateDraftIfNeeded)).append("\n");
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

