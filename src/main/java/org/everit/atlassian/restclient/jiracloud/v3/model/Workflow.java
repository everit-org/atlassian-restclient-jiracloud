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
import org.everit.atlassian.restclient.jiracloud.v3.model.PublishedWorkflowId;
import org.everit.atlassian.restclient.jiracloud.v3.model.Transition;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowStatus;

/**
 * Details about a workflow.
 */
@ApiModel(description = "Details about a workflow.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:37.034+02:00[Europe/Prague]")
public class Workflow {
  @JsonProperty("id")
  private PublishedWorkflowId id;

  @JsonProperty("description")
  private String description;

  @JsonProperty("transitions")
  private List<Transition> transitions = new ArrayList<>();

  @JsonProperty("statuses")
  private List<WorkflowStatus> statuses = new ArrayList<>();

  public Workflow id(PublishedWorkflowId id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public PublishedWorkflowId getId() {
    return id;
  }

  public void setId(PublishedWorkflowId id) {
    this.id = id;
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Workflow workflow = (Workflow) o;
    return Objects.equals(this.id, workflow.id) &&
        Objects.equals(this.description, workflow.description) &&
        Objects.equals(this.transitions, workflow.transitions) &&
        Objects.equals(this.statuses, workflow.statuses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, transitions, statuses);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Workflow {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    transitions: ").append(toIndentedString(transitions)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
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

