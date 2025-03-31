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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v2.model.DocumentVersion;
import org.everit.atlassian.restclient.jiracloud.v2.model.StatusLayoutUpdate;
import org.everit.atlassian.restclient.jiracloud.v2.model.StatusMappingDTO;
import org.everit.atlassian.restclient.jiracloud.v2.model.StatusMigration;
import org.everit.atlassian.restclient.jiracloud.v2.model.TransitionUpdateDTO;
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowLayout;

/**
 * The details of the workflows to update.
 */
@ApiModel(description = "The details of the workflows to update.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class WorkflowUpdate {
  @JsonProperty("defaultStatusMappings")
  private List<StatusMigration> defaultStatusMappings = new ArrayList<>();

  @JsonProperty("description")
  private String description;

  @JsonProperty("id")
  private String id;

  @JsonProperty("startPointLayout")
  private WorkflowLayout startPointLayout;

  @JsonProperty("statusMappings")
  private List<StatusMappingDTO> statusMappings = new ArrayList<>();

  @JsonProperty("statuses")
  private List<StatusLayoutUpdate> statuses = new ArrayList<>();

  @JsonProperty("transitions")
  private List<TransitionUpdateDTO> transitions = new ArrayList<>();

  @JsonProperty("version")
  private DocumentVersion version;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public WorkflowUpdate defaultStatusMappings(List<StatusMigration> defaultStatusMappings) {
    this.defaultStatusMappings = defaultStatusMappings;
    return this;
  }

  public WorkflowUpdate addDefaultStatusMappingsItem(StatusMigration defaultStatusMappingsItem) {
    if (this.defaultStatusMappings == null) {
      this.defaultStatusMappings = new ArrayList<>();
    }
    this.defaultStatusMappings.add(defaultStatusMappingsItem);
    return this;
  }

   /**
   * The mapping of old to new status ID.
   * @return defaultStatusMappings
  **/
  @ApiModelProperty(value = "The mapping of old to new status ID.")
  public List<StatusMigration> getDefaultStatusMappings() {
    return defaultStatusMappings;
  }

  public void setDefaultStatusMappings(List<StatusMigration> defaultStatusMappings) {
    this.defaultStatusMappings = defaultStatusMappings;
  }

  public WorkflowUpdate description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The new description for this workflow.
   * @return description
  **/
  @ApiModelProperty(value = "The new description for this workflow.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public WorkflowUpdate id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of this workflow.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of this workflow.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public WorkflowUpdate startPointLayout(WorkflowLayout startPointLayout) {
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

  public WorkflowUpdate statusMappings(List<StatusMappingDTO> statusMappings) {
    this.statusMappings = statusMappings;
    return this;
  }

  public WorkflowUpdate addStatusMappingsItem(StatusMappingDTO statusMappingsItem) {
    if (this.statusMappings == null) {
      this.statusMappings = new ArrayList<>();
    }
    this.statusMappings.add(statusMappingsItem);
    return this;
  }

   /**
   * The mapping of old to new status ID for a specific project and issue type.
   * @return statusMappings
  **/
  @ApiModelProperty(value = "The mapping of old to new status ID for a specific project and issue type.")
  public List<StatusMappingDTO> getStatusMappings() {
    return statusMappings;
  }

  public void setStatusMappings(List<StatusMappingDTO> statusMappings) {
    this.statusMappings = statusMappings;
  }

  public WorkflowUpdate statuses(List<StatusLayoutUpdate> statuses) {
    this.statuses = statuses;
    return this;
  }

  public WorkflowUpdate addStatusesItem(StatusLayoutUpdate statusesItem) {
    this.statuses.add(statusesItem);
    return this;
  }

   /**
   * The statuses associated with this workflow.
   * @return statuses
  **/
  @ApiModelProperty(required = true, value = "The statuses associated with this workflow.")
  public List<StatusLayoutUpdate> getStatuses() {
    return statuses;
  }

  public void setStatuses(List<StatusLayoutUpdate> statuses) {
    this.statuses = statuses;
  }

  public WorkflowUpdate transitions(List<TransitionUpdateDTO> transitions) {
    this.transitions = transitions;
    return this;
  }

  public WorkflowUpdate addTransitionsItem(TransitionUpdateDTO transitionsItem) {
    this.transitions.add(transitionsItem);
    return this;
  }

   /**
   * The transitions of this workflow.
   * @return transitions
  **/
  @ApiModelProperty(required = true, value = "The transitions of this workflow.")
  public List<TransitionUpdateDTO> getTransitions() {
    return transitions;
  }

  public void setTransitions(List<TransitionUpdateDTO> transitions) {
    this.transitions = transitions;
  }

  public WorkflowUpdate version(DocumentVersion version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(required = true, value = "")
  public DocumentVersion getVersion() {
    return version;
  }

  public void setVersion(DocumentVersion version) {
    this.version = version;
  }


  @com.fasterxml.jackson.annotation.JsonAnyGetter
  public Map<String, Object> any() {
   return this.additionalProperties_;
  }

  @com.fasterxml.jackson.annotation.JsonAnySetter
  public void set(String name, Object value) {
   this.additionalProperties_.put(name, value);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowUpdate workflowUpdate = (WorkflowUpdate) o;
    return Objects.equals(this.defaultStatusMappings, workflowUpdate.defaultStatusMappings) &&
        Objects.equals(this.description, workflowUpdate.description) &&
        Objects.equals(this.id, workflowUpdate.id) &&
        Objects.equals(this.startPointLayout, workflowUpdate.startPointLayout) &&
        Objects.equals(this.statusMappings, workflowUpdate.statusMappings) &&
        Objects.equals(this.statuses, workflowUpdate.statuses) &&
        Objects.equals(this.transitions, workflowUpdate.transitions) &&
        Objects.equals(this.version, workflowUpdate.version) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultStatusMappings, description, id, startPointLayout, statusMappings, statuses, transitions, version, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowUpdate {\n");
    
    sb.append("    defaultStatusMappings: ").append(toIndentedString(defaultStatusMappings)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    startPointLayout: ").append(toIndentedString(startPointLayout)).append("\n");
    sb.append("    statusMappings: ").append(toIndentedString(statusMappings)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
    sb.append("    transitions: ").append(toIndentedString(transitions)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties_)).append("\n");
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

