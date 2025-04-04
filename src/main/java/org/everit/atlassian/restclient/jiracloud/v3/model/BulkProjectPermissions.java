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

/**
 * Details of project permissions and associated issues and projects to look up.
 */
@ApiModel(description = "Details of project permissions and associated issues and projects to look up.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class BulkProjectPermissions {
  @JsonProperty("issues")
  private List<Long> issues = new ArrayList<>();

  @JsonProperty("permissions")
  private List<String> permissions = new ArrayList<>();

  @JsonProperty("projects")
  private List<Long> projects = new ArrayList<>();

  public BulkProjectPermissions issues(List<Long> issues) {
    this.issues = issues;
    return this;
  }

  public BulkProjectPermissions addIssuesItem(Long issuesItem) {
    if (this.issues == null) {
      this.issues = new ArrayList<>();
    }
    this.issues.add(issuesItem);
    return this;
  }

   /**
   * List of issue IDs.
   * @return issues
  **/
  @ApiModelProperty(value = "List of issue IDs.")
  public List<Long> getIssues() {
    return issues;
  }

  public void setIssues(List<Long> issues) {
    this.issues = issues;
  }

  public BulkProjectPermissions permissions(List<String> permissions) {
    this.permissions = permissions;
    return this;
  }

  public BulkProjectPermissions addPermissionsItem(String permissionsItem) {
    this.permissions.add(permissionsItem);
    return this;
  }

   /**
   * List of project permissions.
   * @return permissions
  **/
  @ApiModelProperty(required = true, value = "List of project permissions.")
  public List<String> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<String> permissions) {
    this.permissions = permissions;
  }

  public BulkProjectPermissions projects(List<Long> projects) {
    this.projects = projects;
    return this;
  }

  public BulkProjectPermissions addProjectsItem(Long projectsItem) {
    if (this.projects == null) {
      this.projects = new ArrayList<>();
    }
    this.projects.add(projectsItem);
    return this;
  }

   /**
   * List of project IDs.
   * @return projects
  **/
  @ApiModelProperty(value = "List of project IDs.")
  public List<Long> getProjects() {
    return projects;
  }

  public void setProjects(List<Long> projects) {
    this.projects = projects;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkProjectPermissions bulkProjectPermissions = (BulkProjectPermissions) o;
    return Objects.equals(this.issues, bulkProjectPermissions.issues) &&
        Objects.equals(this.permissions, bulkProjectPermissions.permissions) &&
        Objects.equals(this.projects, bulkProjectPermissions.projects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issues, permissions, projects);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkProjectPermissions {\n");
    
    sb.append("    issues: ").append(toIndentedString(issues)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
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

