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
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeScreenScheme;

/**
 * Issue type screen scheme with a list of the projects that use it.
 */
@ApiModel(description = "Issue type screen scheme with a list of the projects that use it.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class IssueTypeScreenSchemesProjects {
  @JsonProperty("issueTypeScreenScheme")
  private IssueTypeScreenScheme issueTypeScreenScheme;

  @JsonProperty("projectIds")
  private List<String> projectIds = new ArrayList<>();

  public IssueTypeScreenSchemesProjects issueTypeScreenScheme(IssueTypeScreenScheme issueTypeScreenScheme) {
    this.issueTypeScreenScheme = issueTypeScreenScheme;
    return this;
  }

   /**
   * Details of an issue type screen scheme.
   * @return issueTypeScreenScheme
  **/
  @ApiModelProperty(required = true, value = "Details of an issue type screen scheme.")
  public IssueTypeScreenScheme getIssueTypeScreenScheme() {
    return issueTypeScreenScheme;
  }

  public void setIssueTypeScreenScheme(IssueTypeScreenScheme issueTypeScreenScheme) {
    this.issueTypeScreenScheme = issueTypeScreenScheme;
  }

  public IssueTypeScreenSchemesProjects projectIds(List<String> projectIds) {
    this.projectIds = projectIds;
    return this;
  }

  public IssueTypeScreenSchemesProjects addProjectIdsItem(String projectIdsItem) {
    this.projectIds.add(projectIdsItem);
    return this;
  }

   /**
   * The IDs of the projects using the issue type screen scheme.
   * @return projectIds
  **/
  @ApiModelProperty(required = true, value = "The IDs of the projects using the issue type screen scheme.")
  public List<String> getProjectIds() {
    return projectIds;
  }

  public void setProjectIds(List<String> projectIds) {
    this.projectIds = projectIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueTypeScreenSchemesProjects issueTypeScreenSchemesProjects = (IssueTypeScreenSchemesProjects) o;
    return Objects.equals(this.issueTypeScreenScheme, issueTypeScreenSchemesProjects.issueTypeScreenScheme) &&
        Objects.equals(this.projectIds, issueTypeScreenSchemesProjects.projectIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueTypeScreenScheme, projectIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueTypeScreenSchemesProjects {\n");
    
    sb.append("    issueTypeScreenScheme: ").append(toIndentedString(issueTypeScreenScheme)).append("\n");
    sb.append("    projectIds: ").append(toIndentedString(projectIds)).append("\n");
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

