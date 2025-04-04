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
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowCreate;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowScope;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowStatusUpdate;

/**
 * The create workflows payload.
 */
@ApiModel(description = "The create workflows payload.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class WorkflowCreateRequest {
  @JsonProperty("scope")
  private WorkflowScope scope;

  @JsonProperty("statuses")
  private List<WorkflowStatusUpdate> statuses = new ArrayList<>();

  @JsonProperty("workflows")
  private List<WorkflowCreate> workflows = new ArrayList<>();

  public WorkflowCreateRequest scope(WorkflowScope scope) {
    this.scope = scope;
    return this;
  }

   /**
   * Get scope
   * @return scope
  **/
  @ApiModelProperty(value = "")
  public WorkflowScope getScope() {
    return scope;
  }

  public void setScope(WorkflowScope scope) {
    this.scope = scope;
  }

  public WorkflowCreateRequest statuses(List<WorkflowStatusUpdate> statuses) {
    this.statuses = statuses;
    return this;
  }

  public WorkflowCreateRequest addStatusesItem(WorkflowStatusUpdate statusesItem) {
    if (this.statuses == null) {
      this.statuses = new ArrayList<>();
    }
    this.statuses.add(statusesItem);
    return this;
  }

   /**
   * The statuses to associate with the workflows.
   * @return statuses
  **/
  @ApiModelProperty(value = "The statuses to associate with the workflows.")
  public List<WorkflowStatusUpdate> getStatuses() {
    return statuses;
  }

  public void setStatuses(List<WorkflowStatusUpdate> statuses) {
    this.statuses = statuses;
  }

  public WorkflowCreateRequest workflows(List<WorkflowCreate> workflows) {
    this.workflows = workflows;
    return this;
  }

  public WorkflowCreateRequest addWorkflowsItem(WorkflowCreate workflowsItem) {
    if (this.workflows == null) {
      this.workflows = new ArrayList<>();
    }
    this.workflows.add(workflowsItem);
    return this;
  }

   /**
   * The details of the workflows to create.
   * @return workflows
  **/
  @ApiModelProperty(value = "The details of the workflows to create.")
  public List<WorkflowCreate> getWorkflows() {
    return workflows;
  }

  public void setWorkflows(List<WorkflowCreate> workflows) {
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
    WorkflowCreateRequest workflowCreateRequest = (WorkflowCreateRequest) o;
    return Objects.equals(this.scope, workflowCreateRequest.scope) &&
        Objects.equals(this.statuses, workflowCreateRequest.statuses) &&
        Objects.equals(this.workflows, workflowCreateRequest.workflows);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scope, statuses, workflows);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowCreateRequest {\n");
    
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
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

