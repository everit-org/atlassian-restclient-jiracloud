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
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueTypeDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.User;

/**
 * Details about a workflow scheme.
 */
@ApiModel(description = "Details about a workflow scheme.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class WorkflowScheme {
  @JsonProperty("defaultWorkflow")
  private String defaultWorkflow;

  @JsonProperty("description")
  private String description;

  @JsonProperty("draft")
  private Boolean draft;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("issueTypeMappings")
  private Map<String, String> issueTypeMappings = new HashMap<>();

  @JsonProperty("issueTypes")
  private Map<String, IssueTypeDetails> issueTypes = new HashMap<>();

  @JsonProperty("lastModified")
  private String lastModified;

  @JsonProperty("lastModifiedUser")
  private User lastModifiedUser;

  @JsonProperty("name")
  private String name;

  @JsonProperty("originalDefaultWorkflow")
  private String originalDefaultWorkflow;

  @JsonProperty("originalIssueTypeMappings")
  private Map<String, String> originalIssueTypeMappings = new HashMap<>();

  @JsonProperty("self")
  private URI self;

  @JsonProperty("updateDraftIfNeeded")
  private Boolean updateDraftIfNeeded;

  public WorkflowScheme defaultWorkflow(String defaultWorkflow) {
    this.defaultWorkflow = defaultWorkflow;
    return this;
  }

   /**
   * The name of the default workflow for the workflow scheme. The default workflow has *All Unassigned Issue Types* assigned to it in Jira. If &#x60;defaultWorkflow&#x60; is not specified when creating a workflow scheme, it is set to *Jira Workflow (jira)*.
   * @return defaultWorkflow
  **/
  @ApiModelProperty(value = "The name of the default workflow for the workflow scheme. The default workflow has *All Unassigned Issue Types* assigned to it in Jira. If `defaultWorkflow` is not specified when creating a workflow scheme, it is set to *Jira Workflow (jira)*.")
  public String getDefaultWorkflow() {
    return defaultWorkflow;
  }

  public void setDefaultWorkflow(String defaultWorkflow) {
    this.defaultWorkflow = defaultWorkflow;
  }

  public WorkflowScheme description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the workflow scheme.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the workflow scheme.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

   /**
   * Whether the workflow scheme is a draft or not.
   * @return draft
  **/
  @ApiModelProperty(value = "Whether the workflow scheme is a draft or not.")
  public Boolean getDraft() {
    return draft;
  }

   /**
   * The ID of the workflow scheme.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the workflow scheme.")
  public Long getId() {
    return id;
  }

  public WorkflowScheme issueTypeMappings(Map<String, String> issueTypeMappings) {
    this.issueTypeMappings = issueTypeMappings;
    return this;
  }

  public WorkflowScheme putIssueTypeMappingsItem(String key, String issueTypeMappingsItem) {
    if (this.issueTypeMappings == null) {
      this.issueTypeMappings = new HashMap<>();
    }
    this.issueTypeMappings.put(key, issueTypeMappingsItem);
    return this;
  }

   /**
   * The issue type to workflow mappings, where each mapping is an issue type ID and workflow name pair. Note that an issue type can only be mapped to one workflow in a workflow scheme.
   * @return issueTypeMappings
  **/
  @ApiModelProperty(value = "The issue type to workflow mappings, where each mapping is an issue type ID and workflow name pair. Note that an issue type can only be mapped to one workflow in a workflow scheme.")
  public Map<String, String> getIssueTypeMappings() {
    return issueTypeMappings;
  }

  public void setIssueTypeMappings(Map<String, String> issueTypeMappings) {
    this.issueTypeMappings = issueTypeMappings;
  }

   /**
   * The issue types available in Jira.
   * @return issueTypes
  **/
  @ApiModelProperty(value = "The issue types available in Jira.")
  public Map<String, IssueTypeDetails> getIssueTypes() {
    return issueTypes;
  }

   /**
   * The date-time that the draft workflow scheme was last modified. A modification is a change to the issue type-project mappings only. This property does not apply to non-draft workflows.
   * @return lastModified
  **/
  @ApiModelProperty(value = "The date-time that the draft workflow scheme was last modified. A modification is a change to the issue type-project mappings only. This property does not apply to non-draft workflows.")
  public String getLastModified() {
    return lastModified;
  }

   /**
   * The user that last modified the draft workflow scheme. A modification is a change to the issue type-project mappings only. This property does not apply to non-draft workflows.
   * @return lastModifiedUser
  **/
  @ApiModelProperty(value = "The user that last modified the draft workflow scheme. A modification is a change to the issue type-project mappings only. This property does not apply to non-draft workflows.")
  public User getLastModifiedUser() {
    return lastModifiedUser;
  }

  public WorkflowScheme name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the workflow scheme. The name must be unique. The maximum length is 255 characters. Required when creating a workflow scheme.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the workflow scheme. The name must be unique. The maximum length is 255 characters. Required when creating a workflow scheme.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

   /**
   * For draft workflow schemes, this property is the name of the default workflow for the original workflow scheme. The default workflow has *All Unassigned Issue Types* assigned to it in Jira.
   * @return originalDefaultWorkflow
  **/
  @ApiModelProperty(value = "For draft workflow schemes, this property is the name of the default workflow for the original workflow scheme. The default workflow has *All Unassigned Issue Types* assigned to it in Jira.")
  public String getOriginalDefaultWorkflow() {
    return originalDefaultWorkflow;
  }

   /**
   * For draft workflow schemes, this property is the issue type to workflow mappings for the original workflow scheme, where each mapping is an issue type ID and workflow name pair. Note that an issue type can only be mapped to one workflow in a workflow scheme.
   * @return originalIssueTypeMappings
  **/
  @ApiModelProperty(value = "For draft workflow schemes, this property is the issue type to workflow mappings for the original workflow scheme, where each mapping is an issue type ID and workflow name pair. Note that an issue type can only be mapped to one workflow in a workflow scheme.")
  public Map<String, String> getOriginalIssueTypeMappings() {
    return originalIssueTypeMappings;
  }

   /**
   * Get self
   * @return self
  **/
  @ApiModelProperty(value = "")
  public URI getSelf() {
    return self;
  }

  public WorkflowScheme updateDraftIfNeeded(Boolean updateDraftIfNeeded) {
    this.updateDraftIfNeeded = updateDraftIfNeeded;
    return this;
  }

   /**
   * Whether to create or update a draft workflow scheme when updating an active workflow scheme. An active workflow scheme is a workflow scheme that is used by at least one project. The following examples show how this property works:   *  Update an active workflow scheme with &#x60;updateDraftIfNeeded&#x60; set to &#x60;true&#x60;: If a draft workflow scheme exists, it is updated. Otherwise, a draft workflow scheme is created.  *  Update an active workflow scheme with &#x60;updateDraftIfNeeded&#x60; set to &#x60;false&#x60;: An error is returned, as active workflow schemes cannot be updated.  *  Update an inactive workflow scheme with &#x60;updateDraftIfNeeded&#x60; set to &#x60;true&#x60;: The workflow scheme is updated, as inactive workflow schemes do not require drafts to update.  Defaults to &#x60;false&#x60;.
   * @return updateDraftIfNeeded
  **/
  @ApiModelProperty(value = "Whether to create or update a draft workflow scheme when updating an active workflow scheme. An active workflow scheme is a workflow scheme that is used by at least one project. The following examples show how this property works:   *  Update an active workflow scheme with `updateDraftIfNeeded` set to `true`: If a draft workflow scheme exists, it is updated. Otherwise, a draft workflow scheme is created.  *  Update an active workflow scheme with `updateDraftIfNeeded` set to `false`: An error is returned, as active workflow schemes cannot be updated.  *  Update an inactive workflow scheme with `updateDraftIfNeeded` set to `true`: The workflow scheme is updated, as inactive workflow schemes do not require drafts to update.  Defaults to `false`.")
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
    WorkflowScheme workflowScheme = (WorkflowScheme) o;
    return Objects.equals(this.defaultWorkflow, workflowScheme.defaultWorkflow) &&
        Objects.equals(this.description, workflowScheme.description) &&
        Objects.equals(this.draft, workflowScheme.draft) &&
        Objects.equals(this.id, workflowScheme.id) &&
        Objects.equals(this.issueTypeMappings, workflowScheme.issueTypeMappings) &&
        Objects.equals(this.issueTypes, workflowScheme.issueTypes) &&
        Objects.equals(this.lastModified, workflowScheme.lastModified) &&
        Objects.equals(this.lastModifiedUser, workflowScheme.lastModifiedUser) &&
        Objects.equals(this.name, workflowScheme.name) &&
        Objects.equals(this.originalDefaultWorkflow, workflowScheme.originalDefaultWorkflow) &&
        Objects.equals(this.originalIssueTypeMappings, workflowScheme.originalIssueTypeMappings) &&
        Objects.equals(this.self, workflowScheme.self) &&
        Objects.equals(this.updateDraftIfNeeded, workflowScheme.updateDraftIfNeeded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultWorkflow, description, draft, id, issueTypeMappings, issueTypes, lastModified, lastModifiedUser, name, originalDefaultWorkflow, originalIssueTypeMappings, self, updateDraftIfNeeded);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowScheme {\n");
    
    sb.append("    defaultWorkflow: ").append(toIndentedString(defaultWorkflow)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    draft: ").append(toIndentedString(draft)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    issueTypeMappings: ").append(toIndentedString(issueTypeMappings)).append("\n");
    sb.append("    issueTypes: ").append(toIndentedString(issueTypes)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    lastModifiedUser: ").append(toIndentedString(lastModifiedUser)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    originalDefaultWorkflow: ").append(toIndentedString(originalDefaultWorkflow)).append("\n");
    sb.append("    originalIssueTypeMappings: ").append(toIndentedString(originalIssueTypeMappings)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
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

