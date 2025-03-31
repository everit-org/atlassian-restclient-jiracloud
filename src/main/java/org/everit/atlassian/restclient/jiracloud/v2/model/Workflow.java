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


package org.everit.atlassian.restclient.jiracloud.v2.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.ProjectDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.PublishedWorkflowId;
import org.everit.atlassian.restclient.jiracloud.v2.model.Transition;
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowOperations;
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowSchemeIdName;
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowStatus;

/**
 * Details about a workflow.
 */
@ApiModel(description = "Details about a workflow.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class Workflow {
  @JsonProperty("created")
  private OffsetDateTime created;

  @JsonProperty("description")
  private String description;

  @JsonProperty("hasDraftWorkflow")
  private Boolean hasDraftWorkflow;

  @JsonProperty("id")
  private PublishedWorkflowId id;

  @JsonProperty("isDefault")
  private Boolean isDefault;

  @JsonProperty("operations")
  private WorkflowOperations operations;

  @JsonProperty("projects")
  private List<ProjectDetails> projects = new ArrayList<>();

  @JsonProperty("schemes")
  private List<WorkflowSchemeIdName> schemes = new ArrayList<>();

  @JsonProperty("statuses")
  private List<WorkflowStatus> statuses = new ArrayList<>();

  @JsonProperty("transitions")
  private List<Transition> transitions = new ArrayList<>();

  @JsonProperty("updated")
  private OffsetDateTime updated;

  public Workflow created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * The creation date of the workflow.
   * @return created
  **/
  @ApiModelProperty(value = "The creation date of the workflow.")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public Workflow description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the workflow.
   * @return description
  **/
  @ApiModelProperty(required = true, value = "The description of the workflow.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Workflow hasDraftWorkflow(Boolean hasDraftWorkflow) {
    this.hasDraftWorkflow = hasDraftWorkflow;
    return this;
  }

   /**
   * Whether the workflow has a draft version.
   * @return hasDraftWorkflow
  **/
  @ApiModelProperty(value = "Whether the workflow has a draft version.")
  public Boolean getHasDraftWorkflow() {
    return hasDraftWorkflow;
  }

  public void setHasDraftWorkflow(Boolean hasDraftWorkflow) {
    this.hasDraftWorkflow = hasDraftWorkflow;
  }

  public Workflow id(PublishedWorkflowId id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public PublishedWorkflowId getId() {
    return id;
  }

  public void setId(PublishedWorkflowId id) {
    this.id = id;
  }

  public Workflow isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

   /**
   * Whether this is the default workflow.
   * @return isDefault
  **/
  @ApiModelProperty(value = "Whether this is the default workflow.")
  public Boolean getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public Workflow operations(WorkflowOperations operations) {
    this.operations = operations;
    return this;
  }

   /**
   * Get operations
   * @return operations
  **/
  @ApiModelProperty(value = "")
  public WorkflowOperations getOperations() {
    return operations;
  }

  public void setOperations(WorkflowOperations operations) {
    this.operations = operations;
  }

  public Workflow projects(List<ProjectDetails> projects) {
    this.projects = projects;
    return this;
  }

  public Workflow addProjectsItem(ProjectDetails projectsItem) {
    if (this.projects == null) {
      this.projects = new ArrayList<>();
    }
    this.projects.add(projectsItem);
    return this;
  }

   /**
   * The projects the workflow is assigned to, through workflow schemes.
   * @return projects
  **/
  @ApiModelProperty(value = "The projects the workflow is assigned to, through workflow schemes.")
  public List<ProjectDetails> getProjects() {
    return projects;
  }

  public void setProjects(List<ProjectDetails> projects) {
    this.projects = projects;
  }

  public Workflow schemes(List<WorkflowSchemeIdName> schemes) {
    this.schemes = schemes;
    return this;
  }

  public Workflow addSchemesItem(WorkflowSchemeIdName schemesItem) {
    if (this.schemes == null) {
      this.schemes = new ArrayList<>();
    }
    this.schemes.add(schemesItem);
    return this;
  }

   /**
   * The workflow schemes the workflow is assigned to.
   * @return schemes
  **/
  @ApiModelProperty(value = "The workflow schemes the workflow is assigned to.")
  public List<WorkflowSchemeIdName> getSchemes() {
    return schemes;
  }

  public void setSchemes(List<WorkflowSchemeIdName> schemes) {
    this.schemes = schemes;
  }

  public Workflow statuses(List<WorkflowStatus> statuses) {
    this.statuses = statuses;
    return this;
  }

  public Workflow addStatusesItem(WorkflowStatus statusesItem) {
    if (this.statuses == null) {
      this.statuses = new ArrayList<>();
    }
    this.statuses.add(statusesItem);
    return this;
  }

   /**
   * The statuses of the workflow.
   * @return statuses
  **/
  @ApiModelProperty(value = "The statuses of the workflow.")
  public List<WorkflowStatus> getStatuses() {
    return statuses;
  }

  public void setStatuses(List<WorkflowStatus> statuses) {
    this.statuses = statuses;
  }

  public Workflow transitions(List<Transition> transitions) {
    this.transitions = transitions;
    return this;
  }

  public Workflow addTransitionsItem(Transition transitionsItem) {
    if (this.transitions == null) {
      this.transitions = new ArrayList<>();
    }
    this.transitions.add(transitionsItem);
    return this;
  }

   /**
   * The transitions of the workflow.
   * @return transitions
  **/
  @ApiModelProperty(value = "The transitions of the workflow.")
  public List<Transition> getTransitions() {
    return transitions;
  }

  public void setTransitions(List<Transition> transitions) {
    this.transitions = transitions;
  }

  public Workflow updated(OffsetDateTime updated) {
    this.updated = updated;
    return this;
  }

   /**
   * The last edited date of the workflow.
   * @return updated
  **/
  @ApiModelProperty(value = "The last edited date of the workflow.")
  public OffsetDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(OffsetDateTime updated) {
    this.updated = updated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Workflow workflow = (Workflow) o;
    return Objects.equals(this.created, workflow.created) &&
        Objects.equals(this.description, workflow.description) &&
        Objects.equals(this.hasDraftWorkflow, workflow.hasDraftWorkflow) &&
        Objects.equals(this.id, workflow.id) &&
        Objects.equals(this.isDefault, workflow.isDefault) &&
        Objects.equals(this.operations, workflow.operations) &&
        Objects.equals(this.projects, workflow.projects) &&
        Objects.equals(this.schemes, workflow.schemes) &&
        Objects.equals(this.statuses, workflow.statuses) &&
        Objects.equals(this.transitions, workflow.transitions) &&
        Objects.equals(this.updated, workflow.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, description, hasDraftWorkflow, id, isDefault, operations, projects, schemes, statuses, transitions, updated);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Workflow {\n");
    
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    hasDraftWorkflow: ").append(toIndentedString(hasDraftWorkflow)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
    sb.append("    schemes: ").append(toIndentedString(schemes)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
    sb.append("    transitions: ").append(toIndentedString(transitions)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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

