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
import org.everit.atlassian.restclient.jiracloud.v3.model.StatusProjectIssueTypeUsagePage;

/**
 * The issue types using this status in a project.
 */
@ApiModel(description = "The issue types using this status in a project.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class StatusProjectIssueTypeUsageDTO {
  @JsonProperty("issueTypes")
  private StatusProjectIssueTypeUsagePage issueTypes;

  @JsonProperty("projectId")
  private String projectId;

  @JsonProperty("statusId")
  private String statusId;

  public StatusProjectIssueTypeUsageDTO issueTypes(StatusProjectIssueTypeUsagePage issueTypes) {
    this.issueTypes = issueTypes;
    return this;
  }

   /**
   * Get issueTypes
   * @return issueTypes
  **/
  @ApiModelProperty(value = "")
  public StatusProjectIssueTypeUsagePage getIssueTypes() {
    return issueTypes;
  }

  public void setIssueTypes(StatusProjectIssueTypeUsagePage issueTypes) {
    this.issueTypes = issueTypes;
  }

  public StatusProjectIssueTypeUsageDTO projectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

   /**
   * The project ID.
   * @return projectId
  **/
  @ApiModelProperty(value = "The project ID.")
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public StatusProjectIssueTypeUsageDTO statusId(String statusId) {
    this.statusId = statusId;
    return this;
  }

   /**
   * The status ID.
   * @return statusId
  **/
  @ApiModelProperty(value = "The status ID.")
  public String getStatusId() {
    return statusId;
  }

  public void setStatusId(String statusId) {
    this.statusId = statusId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusProjectIssueTypeUsageDTO statusProjectIssueTypeUsageDTO = (StatusProjectIssueTypeUsageDTO) o;
    return Objects.equals(this.issueTypes, statusProjectIssueTypeUsageDTO.issueTypes) &&
        Objects.equals(this.projectId, statusProjectIssueTypeUsageDTO.projectId) &&
        Objects.equals(this.statusId, statusProjectIssueTypeUsageDTO.statusId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueTypes, projectId, statusId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusProjectIssueTypeUsageDTO {\n");
    
    sb.append("    issueTypes: ").append(toIndentedString(issueTypes)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    statusId: ").append(toIndentedString(statusId)).append("\n");
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

