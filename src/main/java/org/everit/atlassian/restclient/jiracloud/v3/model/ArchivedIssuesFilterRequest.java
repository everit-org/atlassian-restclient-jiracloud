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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v3.model.DateRangeFilterRequest;

/**
 * Details of a filter for exporting archived issues.
 */
@ApiModel(description = "Details of a filter for exporting archived issues.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class ArchivedIssuesFilterRequest {
  @JsonProperty("archivedBy")
  private List<String> archivedBy = new ArrayList<>();

  @JsonProperty("archivedDateRange")
  private DateRangeFilterRequest archivedDateRange;

  @JsonProperty("issueTypes")
  private List<String> issueTypes = new ArrayList<>();

  @JsonProperty("projects")
  private List<String> projects = new ArrayList<>();

  @JsonProperty("reporters")
  private List<String> reporters = new ArrayList<>();

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public ArchivedIssuesFilterRequest archivedBy(List<String> archivedBy) {
    this.archivedBy = archivedBy;
    return this;
  }

  public ArchivedIssuesFilterRequest addArchivedByItem(String archivedByItem) {
    if (this.archivedBy == null) {
      this.archivedBy = new ArrayList<>();
    }
    this.archivedBy.add(archivedByItem);
    return this;
  }

   /**
   * List archived issues archived by a specified account ID.
   * @return archivedBy
  **/
  @ApiModelProperty(value = "List archived issues archived by a specified account ID.")
  public List<String> getArchivedBy() {
    return archivedBy;
  }

  public void setArchivedBy(List<String> archivedBy) {
    this.archivedBy = archivedBy;
  }

  public ArchivedIssuesFilterRequest archivedDateRange(DateRangeFilterRequest archivedDateRange) {
    this.archivedDateRange = archivedDateRange;
    return this;
  }

   /**
   * Get archivedDateRange
   * @return archivedDateRange
  **/
  @ApiModelProperty(value = "")
  public DateRangeFilterRequest getArchivedDateRange() {
    return archivedDateRange;
  }

  public void setArchivedDateRange(DateRangeFilterRequest archivedDateRange) {
    this.archivedDateRange = archivedDateRange;
  }

  public ArchivedIssuesFilterRequest issueTypes(List<String> issueTypes) {
    this.issueTypes = issueTypes;
    return this;
  }

  public ArchivedIssuesFilterRequest addIssueTypesItem(String issueTypesItem) {
    if (this.issueTypes == null) {
      this.issueTypes = new ArrayList<>();
    }
    this.issueTypes.add(issueTypesItem);
    return this;
  }

   /**
   * List archived issues with a specified issue type ID.
   * @return issueTypes
  **/
  @ApiModelProperty(value = "List archived issues with a specified issue type ID.")
  public List<String> getIssueTypes() {
    return issueTypes;
  }

  public void setIssueTypes(List<String> issueTypes) {
    this.issueTypes = issueTypes;
  }

  public ArchivedIssuesFilterRequest projects(List<String> projects) {
    this.projects = projects;
    return this;
  }

  public ArchivedIssuesFilterRequest addProjectsItem(String projectsItem) {
    if (this.projects == null) {
      this.projects = new ArrayList<>();
    }
    this.projects.add(projectsItem);
    return this;
  }

   /**
   * List archived issues with a specified project key.
   * @return projects
  **/
  @ApiModelProperty(value = "List archived issues with a specified project key.")
  public List<String> getProjects() {
    return projects;
  }

  public void setProjects(List<String> projects) {
    this.projects = projects;
  }

  public ArchivedIssuesFilterRequest reporters(List<String> reporters) {
    this.reporters = reporters;
    return this;
  }

  public ArchivedIssuesFilterRequest addReportersItem(String reportersItem) {
    if (this.reporters == null) {
      this.reporters = new ArrayList<>();
    }
    this.reporters.add(reportersItem);
    return this;
  }

   /**
   * List archived issues where the reporter is a specified account ID.
   * @return reporters
  **/
  @ApiModelProperty(value = "List archived issues where the reporter is a specified account ID.")
  public List<String> getReporters() {
    return reporters;
  }

  public void setReporters(List<String> reporters) {
    this.reporters = reporters;
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
    ArchivedIssuesFilterRequest archivedIssuesFilterRequest = (ArchivedIssuesFilterRequest) o;
    return Objects.equals(this.archivedBy, archivedIssuesFilterRequest.archivedBy) &&
        Objects.equals(this.archivedDateRange, archivedIssuesFilterRequest.archivedDateRange) &&
        Objects.equals(this.issueTypes, archivedIssuesFilterRequest.issueTypes) &&
        Objects.equals(this.projects, archivedIssuesFilterRequest.projects) &&
        Objects.equals(this.reporters, archivedIssuesFilterRequest.reporters) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(archivedBy, archivedDateRange, issueTypes, projects, reporters, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArchivedIssuesFilterRequest {\n");
    
    sb.append("    archivedBy: ").append(toIndentedString(archivedBy)).append("\n");
    sb.append("    archivedDateRange: ").append(toIndentedString(archivedDateRange)).append("\n");
    sb.append("    issueTypes: ").append(toIndentedString(issueTypes)).append("\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
    sb.append("    reporters: ").append(toIndentedString(reporters)).append("\n");
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

