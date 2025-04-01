/*
 * Copyright © 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * The Jira Cloud platform REST API
 * Jira Cloud platform REST API documentation
 *
 * The version of the OpenAPI document: 1001.0.0-SNAPSHOT-636312f2dc6e26921216979d4ae12655beeff255
 * Contact: ecosystem@atlassian.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.everit.atlassian.restclient.jiracloud.v3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowSchemeAssociation;

/**
 * The request payload to get the required mappings for updating a workflow scheme.
 */
@ApiModel(description = "The request payload to get the required mappings for updating a workflow scheme.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class WorkflowSchemeUpdateRequiredMappingsRequest {
  @JsonProperty("defaultWorkflowId")
  private String defaultWorkflowId;

  @JsonProperty("id")
  private String id;

  @JsonProperty("workflowsForIssueTypes")
  private List<WorkflowSchemeAssociation> workflowsForIssueTypes = new ArrayList<>();

  public WorkflowSchemeUpdateRequiredMappingsRequest defaultWorkflowId(String defaultWorkflowId) {
    this.defaultWorkflowId = defaultWorkflowId;
    return this;
  }

   /**
   * The ID of the new default workflow for this workflow scheme. Only used in global-scoped workflow schemes. If it isn&#39;t specified, is set to *Jira Workflow (jira)*.
   * @return defaultWorkflowId
  **/
  @ApiModelProperty(value = "The ID of the new default workflow for this workflow scheme. Only used in global-scoped workflow schemes. If it isn't specified, is set to *Jira Workflow (jira)*.")
  public String getDefaultWorkflowId() {
    return defaultWorkflowId;
  }

  public void setDefaultWorkflowId(String defaultWorkflowId) {
    this.defaultWorkflowId = defaultWorkflowId;
  }

  public WorkflowSchemeUpdateRequiredMappingsRequest id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the workflow scheme.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the workflow scheme.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public WorkflowSchemeUpdateRequiredMappingsRequest workflowsForIssueTypes(List<WorkflowSchemeAssociation> workflowsForIssueTypes) {
    this.workflowsForIssueTypes = workflowsForIssueTypes;
    return this;
  }

  public WorkflowSchemeUpdateRequiredMappingsRequest addWorkflowsForIssueTypesItem(WorkflowSchemeAssociation workflowsForIssueTypesItem) {
    this.workflowsForIssueTypes.add(workflowsForIssueTypesItem);
    return this;
  }

   /**
   * The new workflow to issue type mappings for this workflow scheme.
   * @return workflowsForIssueTypes
  **/
  @ApiModelProperty(required = true, value = "The new workflow to issue type mappings for this workflow scheme.")
  public List<WorkflowSchemeAssociation> getWorkflowsForIssueTypes() {
    return workflowsForIssueTypes;
  }

  public void setWorkflowsForIssueTypes(List<WorkflowSchemeAssociation> workflowsForIssueTypes) {
    this.workflowsForIssueTypes = workflowsForIssueTypes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowSchemeUpdateRequiredMappingsRequest workflowSchemeUpdateRequiredMappingsRequest = (WorkflowSchemeUpdateRequiredMappingsRequest) o;
    return Objects.equals(this.defaultWorkflowId, workflowSchemeUpdateRequiredMappingsRequest.defaultWorkflowId) &&
        Objects.equals(this.id, workflowSchemeUpdateRequiredMappingsRequest.id) &&
        Objects.equals(this.workflowsForIssueTypes, workflowSchemeUpdateRequiredMappingsRequest.workflowsForIssueTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultWorkflowId, id, workflowsForIssueTypes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowSchemeUpdateRequiredMappingsRequest {\n");
    
    sb.append("    defaultWorkflowId: ").append(toIndentedString(defaultWorkflowId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    workflowsForIssueTypes: ").append(toIndentedString(workflowsForIssueTypes)).append("\n");
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

