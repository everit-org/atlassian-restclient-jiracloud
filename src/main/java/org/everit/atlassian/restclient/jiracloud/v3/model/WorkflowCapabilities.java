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
import org.everit.atlassian.restclient.jiracloud.v3.model.AvailableWorkflowConnectRule;
import org.everit.atlassian.restclient.jiracloud.v3.model.AvailableWorkflowForgeRule;
import org.everit.atlassian.restclient.jiracloud.v3.model.AvailableWorkflowSystemRule;
import org.everit.atlassian.restclient.jiracloud.v3.model.AvailableWorkflowTriggers;

/**
 * WorkflowCapabilities
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class WorkflowCapabilities {
  @JsonProperty("connectRules")
  private List<AvailableWorkflowConnectRule> connectRules = new ArrayList<>();

  /**
   * The scope of the workflow capabilities. &#x60;GLOBAL&#x60; for company-managed projects and &#x60;PROJECT&#x60; for team-managed projects.
   */
  public enum EditorScopeEnum {
    PROJECT("PROJECT"),
    
    GLOBAL("GLOBAL");

    private String value;

    EditorScopeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EditorScopeEnum fromValue(String value) {
      for (EditorScopeEnum b : EditorScopeEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("editorScope")
  private EditorScopeEnum editorScope;

  @JsonProperty("forgeRules")
  private List<AvailableWorkflowForgeRule> forgeRules = new ArrayList<>();

  /**
   * Gets or Sets projectTypes
   */
  public enum ProjectTypesEnum {
    SOFTWARE("software"),
    
    SERVICE_DESK("service_desk"),
    
    PRODUCT_DISCOVERY("product_discovery"),
    
    BUSINESS("business"),
    
    UNKNOWN("unknown");

    private String value;

    ProjectTypesEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProjectTypesEnum fromValue(String value) {
      for (ProjectTypesEnum b : ProjectTypesEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("projectTypes")
  private List<ProjectTypesEnum> projectTypes = new ArrayList<>();

  @JsonProperty("systemRules")
  private List<AvailableWorkflowSystemRule> systemRules = new ArrayList<>();

  @JsonProperty("triggerRules")
  private List<AvailableWorkflowTriggers> triggerRules = new ArrayList<>();

  public WorkflowCapabilities connectRules(List<AvailableWorkflowConnectRule> connectRules) {
    this.connectRules = connectRules;
    return this;
  }

  public WorkflowCapabilities addConnectRulesItem(AvailableWorkflowConnectRule connectRulesItem) {
    if (this.connectRules == null) {
      this.connectRules = new ArrayList<>();
    }
    this.connectRules.add(connectRulesItem);
    return this;
  }

   /**
   * The Connect provided ecosystem rules available.
   * @return connectRules
  **/
  @ApiModelProperty(value = "The Connect provided ecosystem rules available.")
  public List<AvailableWorkflowConnectRule> getConnectRules() {
    return connectRules;
  }

  public void setConnectRules(List<AvailableWorkflowConnectRule> connectRules) {
    this.connectRules = connectRules;
  }

  public WorkflowCapabilities editorScope(EditorScopeEnum editorScope) {
    this.editorScope = editorScope;
    return this;
  }

   /**
   * The scope of the workflow capabilities. &#x60;GLOBAL&#x60; for company-managed projects and &#x60;PROJECT&#x60; for team-managed projects.
   * @return editorScope
  **/
  @ApiModelProperty(value = "The scope of the workflow capabilities. `GLOBAL` for company-managed projects and `PROJECT` for team-managed projects.")
  public EditorScopeEnum getEditorScope() {
    return editorScope;
  }

  public void setEditorScope(EditorScopeEnum editorScope) {
    this.editorScope = editorScope;
  }

  public WorkflowCapabilities forgeRules(List<AvailableWorkflowForgeRule> forgeRules) {
    this.forgeRules = forgeRules;
    return this;
  }

  public WorkflowCapabilities addForgeRulesItem(AvailableWorkflowForgeRule forgeRulesItem) {
    if (this.forgeRules == null) {
      this.forgeRules = new ArrayList<>();
    }
    this.forgeRules.add(forgeRulesItem);
    return this;
  }

   /**
   * The Forge provided ecosystem rules available.
   * @return forgeRules
  **/
  @ApiModelProperty(value = "The Forge provided ecosystem rules available.")
  public List<AvailableWorkflowForgeRule> getForgeRules() {
    return forgeRules;
  }

  public void setForgeRules(List<AvailableWorkflowForgeRule> forgeRules) {
    this.forgeRules = forgeRules;
  }

  public WorkflowCapabilities projectTypes(List<ProjectTypesEnum> projectTypes) {
    this.projectTypes = projectTypes;
    return this;
  }

  public WorkflowCapabilities addProjectTypesItem(ProjectTypesEnum projectTypesItem) {
    if (this.projectTypes == null) {
      this.projectTypes = new ArrayList<>();
    }
    this.projectTypes.add(projectTypesItem);
    return this;
  }

   /**
   * The types of projects that this capability set is available for.
   * @return projectTypes
  **/
  @ApiModelProperty(value = "The types of projects that this capability set is available for.")
  public List<ProjectTypesEnum> getProjectTypes() {
    return projectTypes;
  }

  public void setProjectTypes(List<ProjectTypesEnum> projectTypes) {
    this.projectTypes = projectTypes;
  }

  public WorkflowCapabilities systemRules(List<AvailableWorkflowSystemRule> systemRules) {
    this.systemRules = systemRules;
    return this;
  }

  public WorkflowCapabilities addSystemRulesItem(AvailableWorkflowSystemRule systemRulesItem) {
    if (this.systemRules == null) {
      this.systemRules = new ArrayList<>();
    }
    this.systemRules.add(systemRulesItem);
    return this;
  }

   /**
   * The Atlassian provided system rules available.
   * @return systemRules
  **/
  @ApiModelProperty(value = "The Atlassian provided system rules available.")
  public List<AvailableWorkflowSystemRule> getSystemRules() {
    return systemRules;
  }

  public void setSystemRules(List<AvailableWorkflowSystemRule> systemRules) {
    this.systemRules = systemRules;
  }

  public WorkflowCapabilities triggerRules(List<AvailableWorkflowTriggers> triggerRules) {
    this.triggerRules = triggerRules;
    return this;
  }

  public WorkflowCapabilities addTriggerRulesItem(AvailableWorkflowTriggers triggerRulesItem) {
    if (this.triggerRules == null) {
      this.triggerRules = new ArrayList<>();
    }
    this.triggerRules.add(triggerRulesItem);
    return this;
  }

   /**
   * The trigger rules available.
   * @return triggerRules
  **/
  @ApiModelProperty(value = "The trigger rules available.")
  public List<AvailableWorkflowTriggers> getTriggerRules() {
    return triggerRules;
  }

  public void setTriggerRules(List<AvailableWorkflowTriggers> triggerRules) {
    this.triggerRules = triggerRules;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowCapabilities workflowCapabilities = (WorkflowCapabilities) o;
    return Objects.equals(this.connectRules, workflowCapabilities.connectRules) &&
        Objects.equals(this.editorScope, workflowCapabilities.editorScope) &&
        Objects.equals(this.forgeRules, workflowCapabilities.forgeRules) &&
        Objects.equals(this.projectTypes, workflowCapabilities.projectTypes) &&
        Objects.equals(this.systemRules, workflowCapabilities.systemRules) &&
        Objects.equals(this.triggerRules, workflowCapabilities.triggerRules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connectRules, editorScope, forgeRules, projectTypes, systemRules, triggerRules);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowCapabilities {\n");
    
    sb.append("    connectRules: ").append(toIndentedString(connectRules)).append("\n");
    sb.append("    editorScope: ").append(toIndentedString(editorScope)).append("\n");
    sb.append("    forgeRules: ").append(toIndentedString(forgeRules)).append("\n");
    sb.append("    projectTypes: ").append(toIndentedString(projectTypes)).append("\n");
    sb.append("    systemRules: ").append(toIndentedString(systemRules)).append("\n");
    sb.append("    triggerRules: ").append(toIndentedString(triggerRules)).append("\n");
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

