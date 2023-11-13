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
import org.everit.atlassian.restclient.jiracloud.v2.model.StatusMigration;

/**
 * The mapping of old to new status ID for a specific project and issue type.
 */
@ApiModel(description = "The mapping of old to new status ID for a specific project and issue type.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class StatusMappingDTO {
  @JsonProperty("issueTypeId")
  private String issueTypeId;

  @JsonProperty("projectId")
  private String projectId;

  @JsonProperty("statusMigrations")
  private List<StatusMigration> statusMigrations = new ArrayList<>();

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public StatusMappingDTO issueTypeId(String issueTypeId) {
    this.issueTypeId = issueTypeId;
    return this;
  }

   /**
   * The issue type for the status mapping.
   * @return issueTypeId
  **/
  @ApiModelProperty(required = true, value = "The issue type for the status mapping.")
  public String getIssueTypeId() {
    return issueTypeId;
  }

  public void setIssueTypeId(String issueTypeId) {
    this.issueTypeId = issueTypeId;
  }

  public StatusMappingDTO projectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

   /**
   * The project for the status mapping.
   * @return projectId
  **/
  @ApiModelProperty(required = true, value = "The project for the status mapping.")
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public StatusMappingDTO statusMigrations(List<StatusMigration> statusMigrations) {
    this.statusMigrations = statusMigrations;
    return this;
  }

  public StatusMappingDTO addStatusMigrationsItem(StatusMigration statusMigrationsItem) {
    this.statusMigrations.add(statusMigrationsItem);
    return this;
  }

   /**
   * The list of old and new status ID mappings for the specified project and issue type.
   * @return statusMigrations
  **/
  @ApiModelProperty(required = true, value = "The list of old and new status ID mappings for the specified project and issue type.")
  public List<StatusMigration> getStatusMigrations() {
    return statusMigrations;
  }

  public void setStatusMigrations(List<StatusMigration> statusMigrations) {
    this.statusMigrations = statusMigrations;
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
    StatusMappingDTO statusMappingDTO = (StatusMappingDTO) o;
    return Objects.equals(this.issueTypeId, statusMappingDTO.issueTypeId) &&
        Objects.equals(this.projectId, statusMappingDTO.projectId) &&
        Objects.equals(this.statusMigrations, statusMappingDTO.statusMigrations) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueTypeId, projectId, statusMigrations, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusMappingDTO {\n");
    
    sb.append("    issueTypeId: ").append(toIndentedString(issueTypeId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    statusMigrations: ").append(toIndentedString(statusMigrations)).append("\n");
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

