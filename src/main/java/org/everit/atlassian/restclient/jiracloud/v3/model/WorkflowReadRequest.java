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
 * The version of the OpenAPI document: 1001.0.0-SNAPSHOT
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
import org.everit.atlassian.restclient.jiracloud.v3.model.ProjectAndIssueTypePair;

/**
 * WorkflowReadRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class WorkflowReadRequest {
  @JsonProperty("projectAndIssueTypes")
  private List<ProjectAndIssueTypePair> projectAndIssueTypes = new ArrayList<>();

  @JsonProperty("workflowIds")
  private List<String> workflowIds = new ArrayList<>();

  @JsonProperty("workflowNames")
  private List<String> workflowNames = new ArrayList<>();

  public WorkflowReadRequest projectAndIssueTypes(List<ProjectAndIssueTypePair> projectAndIssueTypes) {
    this.projectAndIssueTypes = projectAndIssueTypes;
    return this;
  }

  public WorkflowReadRequest addProjectAndIssueTypesItem(ProjectAndIssueTypePair projectAndIssueTypesItem) {
    if (this.projectAndIssueTypes == null) {
      this.projectAndIssueTypes = new ArrayList<>();
    }
    this.projectAndIssueTypes.add(projectAndIssueTypesItem);
    return this;
  }

   /**
   * The list of projects and issue types to query.
   * @return projectAndIssueTypes
  **/
  @ApiModelProperty(value = "The list of projects and issue types to query.")
  public List<ProjectAndIssueTypePair> getProjectAndIssueTypes() {
    return projectAndIssueTypes;
  }

  public void setProjectAndIssueTypes(List<ProjectAndIssueTypePair> projectAndIssueTypes) {
    this.projectAndIssueTypes = projectAndIssueTypes;
  }

  public WorkflowReadRequest workflowIds(List<String> workflowIds) {
    this.workflowIds = workflowIds;
    return this;
  }

  public WorkflowReadRequest addWorkflowIdsItem(String workflowIdsItem) {
    if (this.workflowIds == null) {
      this.workflowIds = new ArrayList<>();
    }
    this.workflowIds.add(workflowIdsItem);
    return this;
  }

   /**
   * The list of workflow IDs to query.
   * @return workflowIds
  **/
  @ApiModelProperty(value = "The list of workflow IDs to query.")
  public List<String> getWorkflowIds() {
    return workflowIds;
  }

  public void setWorkflowIds(List<String> workflowIds) {
    this.workflowIds = workflowIds;
  }

  public WorkflowReadRequest workflowNames(List<String> workflowNames) {
    this.workflowNames = workflowNames;
    return this;
  }

  public WorkflowReadRequest addWorkflowNamesItem(String workflowNamesItem) {
    if (this.workflowNames == null) {
      this.workflowNames = new ArrayList<>();
    }
    this.workflowNames.add(workflowNamesItem);
    return this;
  }

   /**
   * The list of workflow names to query.
   * @return workflowNames
  **/
  @ApiModelProperty(value = "The list of workflow names to query.")
  public List<String> getWorkflowNames() {
    return workflowNames;
  }

  public void setWorkflowNames(List<String> workflowNames) {
    this.workflowNames = workflowNames;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowReadRequest workflowReadRequest = (WorkflowReadRequest) o;
    return Objects.equals(this.projectAndIssueTypes, workflowReadRequest.projectAndIssueTypes) &&
        Objects.equals(this.workflowIds, workflowReadRequest.workflowIds) &&
        Objects.equals(this.workflowNames, workflowReadRequest.workflowNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectAndIssueTypes, workflowIds, workflowNames);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowReadRequest {\n");
    
    sb.append("    projectAndIssueTypes: ").append(toIndentedString(projectAndIssueTypes)).append("\n");
    sb.append("    workflowIds: ").append(toIndentedString(workflowIds)).append("\n");
    sb.append("    workflowNames: ").append(toIndentedString(workflowNames)).append("\n");
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
