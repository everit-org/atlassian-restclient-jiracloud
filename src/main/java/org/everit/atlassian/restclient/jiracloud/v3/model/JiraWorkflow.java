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
import org.everit.atlassian.restclient.jiracloud.v3.model.DocumentVersion;
import org.everit.atlassian.restclient.jiracloud.v3.model.ProjectIssueTypes;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowLayout;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowReferenceStatus;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowScope;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowTransitions;

/**
 * Details of a workflow.
 */
@ApiModel(description = "Details of a workflow.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class JiraWorkflow {
  @JsonProperty("created")
  private String created;

  @JsonProperty("description")
  private String description;

  @JsonProperty("id")
  private String id;

  @JsonProperty("isEditable")
  private Boolean isEditable;

  @JsonProperty("name")
  private String name;

  @JsonProperty("scope")
  private WorkflowScope scope;

  @JsonProperty("startPointLayout")
  private WorkflowLayout startPointLayout;

  @JsonProperty("statuses")
  private List<WorkflowReferenceStatus> statuses = new ArrayList<>();

  @JsonProperty("taskId")
  private String taskId;

  @JsonProperty("transitions")
  private List<WorkflowTransitions> transitions = new ArrayList<>();

  @JsonProperty("updated")
  private String updated;

  @JsonProperty("usages")
  private List<ProjectIssueTypes> usages = new ArrayList<>();

  @JsonProperty("version")
  private DocumentVersion version;

  public JiraWorkflow created(String created) {
    this.created = created;
    return this;
  }

   /**
   * The creation date of the workflow.
   * @return created
  **/
  @ApiModelProperty(value = "The creation date of the workflow.")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public JiraWorkflow description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the workflow.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the workflow.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public JiraWorkflow id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the workflow.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the workflow.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public JiraWorkflow isEditable(Boolean isEditable) {
    this.isEditable = isEditable;
    return this;
  }

   /**
   * Indicates if the workflow can be edited.
   * @return isEditable
  **/
  @ApiModelProperty(value = "Indicates if the workflow can be edited.")
  public Boolean getIsEditable() {
    return isEditable;
  }

  public void setIsEditable(Boolean isEditable) {
    this.isEditable = isEditable;
  }

  public JiraWorkflow name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the workflow.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the workflow.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public JiraWorkflow scope(WorkflowScope scope) {
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

  public JiraWorkflow startPointLayout(WorkflowLayout startPointLayout) {
    this.startPointLayout = startPointLayout;
    return this;
  }

   /**
   * Get startPointLayout
   * @return startPointLayout
  **/
  @ApiModelProperty(value = "")
  public WorkflowLayout getStartPointLayout() {
    return startPointLayout;
  }

  public void setStartPointLayout(WorkflowLayout startPointLayout) {
    this.startPointLayout = startPointLayout;
  }

  public JiraWorkflow statuses(List<WorkflowReferenceStatus> statuses) {
    this.statuses = statuses;
    return this;
  }

  public JiraWorkflow addStatusesItem(WorkflowReferenceStatus statusesItem) {
    if (this.statuses == null) {
      this.statuses = new ArrayList<>();
    }
    this.statuses.add(statusesItem);
    return this;
  }

   /**
   * The statuses referenced in this workflow.
   * @return statuses
  **/
  @ApiModelProperty(value = "The statuses referenced in this workflow.")
  public List<WorkflowReferenceStatus> getStatuses() {
    return statuses;
  }

  public void setStatuses(List<WorkflowReferenceStatus> statuses) {
    this.statuses = statuses;
  }

  public JiraWorkflow taskId(String taskId) {
    this.taskId = taskId;
    return this;
  }

   /**
   * If there is a current [asynchronous task](#async-operations) operation for this workflow.
   * @return taskId
  **/
  @ApiModelProperty(value = "If there is a current [asynchronous task](#async-operations) operation for this workflow.")
  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public JiraWorkflow transitions(List<WorkflowTransitions> transitions) {
    this.transitions = transitions;
    return this;
  }

  public JiraWorkflow addTransitionsItem(WorkflowTransitions transitionsItem) {
    if (this.transitions == null) {
      this.transitions = new ArrayList<>();
    }
    this.transitions.add(transitionsItem);
    return this;
  }

   /**
   * The transitions of the workflow. Note that a transition can have either the deprecated &#x60;to&#x60;/&#x60;from&#x60; fields or the &#x60;toStatusReference&#x60;/&#x60;links&#x60; fields, but never both nor a combination.
   * @return transitions
  **/
  @ApiModelProperty(value = "The transitions of the workflow. Note that a transition can have either the deprecated `to`/`from` fields or the `toStatusReference`/`links` fields, but never both nor a combination.")
  public List<WorkflowTransitions> getTransitions() {
    return transitions;
  }

  public void setTransitions(List<WorkflowTransitions> transitions) {
    this.transitions = transitions;
  }

  public JiraWorkflow updated(String updated) {
    this.updated = updated;
    return this;
  }

   /**
   * The last edited date of the workflow.
   * @return updated
  **/
  @ApiModelProperty(value = "The last edited date of the workflow.")
  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public JiraWorkflow usages(List<ProjectIssueTypes> usages) {
    this.usages = usages;
    return this;
  }

  public JiraWorkflow addUsagesItem(ProjectIssueTypes usagesItem) {
    if (this.usages == null) {
      this.usages = new ArrayList<>();
    }
    this.usages.add(usagesItem);
    return this;
  }

   /**
   * Deprecated. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/changelog/#CHANGE-2298) for details.  Use the optional &#x60;workflows.usages&#x60; expand to get additional information about the projects and issue types associated with the requested workflows.
   * @return usages
  **/
  @ApiModelProperty(value = "Deprecated. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/changelog/#CHANGE-2298) for details.  Use the optional `workflows.usages` expand to get additional information about the projects and issue types associated with the requested workflows.")
  public List<ProjectIssueTypes> getUsages() {
    return usages;
  }

  public void setUsages(List<ProjectIssueTypes> usages) {
    this.usages = usages;
  }

  public JiraWorkflow version(DocumentVersion version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public DocumentVersion getVersion() {
    return version;
  }

  public void setVersion(DocumentVersion version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JiraWorkflow jiraWorkflow = (JiraWorkflow) o;
    return Objects.equals(this.created, jiraWorkflow.created) &&
        Objects.equals(this.description, jiraWorkflow.description) &&
        Objects.equals(this.id, jiraWorkflow.id) &&
        Objects.equals(this.isEditable, jiraWorkflow.isEditable) &&
        Objects.equals(this.name, jiraWorkflow.name) &&
        Objects.equals(this.scope, jiraWorkflow.scope) &&
        Objects.equals(this.startPointLayout, jiraWorkflow.startPointLayout) &&
        Objects.equals(this.statuses, jiraWorkflow.statuses) &&
        Objects.equals(this.taskId, jiraWorkflow.taskId) &&
        Objects.equals(this.transitions, jiraWorkflow.transitions) &&
        Objects.equals(this.updated, jiraWorkflow.updated) &&
        Objects.equals(this.usages, jiraWorkflow.usages) &&
        Objects.equals(this.version, jiraWorkflow.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, description, id, isEditable, name, scope, startPointLayout, statuses, taskId, transitions, updated, usages, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JiraWorkflow {\n");
    
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isEditable: ").append(toIndentedString(isEditable)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    startPointLayout: ").append(toIndentedString(startPointLayout)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    transitions: ").append(toIndentedString(transitions)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    usages: ").append(toIndentedString(usages)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

