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
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraWorkflow;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraWorkflowStatus;

/**
 * Details of workflows and related statuses.
 */
@ApiModel(description = "Details of workflows and related statuses.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class WorkflowReadResponse {
  @JsonProperty("statuses")
  private List<JiraWorkflowStatus> statuses = new ArrayList<>();

  @JsonProperty("workflows")
  private List<JiraWorkflow> workflows = new ArrayList<>();

  public WorkflowReadResponse statuses(List<JiraWorkflowStatus> statuses) {
    this.statuses = statuses;
    return this;
  }

  public WorkflowReadResponse addStatusesItem(JiraWorkflowStatus statusesItem) {
    if (this.statuses == null) {
      this.statuses = new ArrayList<>();
    }
    this.statuses.add(statusesItem);
    return this;
  }

   /**
   * List of statuses.
   * @return statuses
  **/
  @ApiModelProperty(value = "List of statuses.")
  public List<JiraWorkflowStatus> getStatuses() {
    return statuses;
  }

  public void setStatuses(List<JiraWorkflowStatus> statuses) {
    this.statuses = statuses;
  }

  public WorkflowReadResponse workflows(List<JiraWorkflow> workflows) {
    this.workflows = workflows;
    return this;
  }

  public WorkflowReadResponse addWorkflowsItem(JiraWorkflow workflowsItem) {
    if (this.workflows == null) {
      this.workflows = new ArrayList<>();
    }
    this.workflows.add(workflowsItem);
    return this;
  }

   /**
   * List of workflows.
   * @return workflows
  **/
  @ApiModelProperty(value = "List of workflows.")
  public List<JiraWorkflow> getWorkflows() {
    return workflows;
  }

  public void setWorkflows(List<JiraWorkflow> workflows) {
    this.workflows = workflows;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowReadResponse workflowReadResponse = (WorkflowReadResponse) o;
    return Objects.equals(this.statuses, workflowReadResponse.statuses) &&
        Objects.equals(this.workflows, workflowReadResponse.workflows);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statuses, workflows);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowReadResponse {\n");
    
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
    sb.append("    workflows: ").append(toIndentedString(workflows)).append("\n");
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

