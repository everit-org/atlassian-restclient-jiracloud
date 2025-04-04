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
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueError;

/**
 * The list of requested issues &amp; fields.
 */
@ApiModel(description = "The list of requested issues & fields.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class BulkIssueResults {
  @JsonProperty("issueErrors")
  private List<IssueError> issueErrors = new ArrayList<>();

  @JsonProperty("issues")
  private List<IssueBean> issues = new ArrayList<>();

   /**
   * When Jira can&#39;t return an issue enumerated in a request due to a retriable error or payload constraint, we&#39;ll return the respective issue ID with a corresponding error message. This list is empty when there are no errors Issues which aren&#39;t found or that the user doesn&#39;t have permission to view won&#39;t be returned in this list.
   * @return issueErrors
  **/
  @ApiModelProperty(value = "When Jira can't return an issue enumerated in a request due to a retriable error or payload constraint, we'll return the respective issue ID with a corresponding error message. This list is empty when there are no errors Issues which aren't found or that the user doesn't have permission to view won't be returned in this list.")
  public List<IssueError> getIssueErrors() {
    return issueErrors;
  }

   /**
   * The list of issues.
   * @return issues
  **/
  @ApiModelProperty(value = "The list of issues.")
  public List<IssueBean> getIssues() {
    return issues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkIssueResults bulkIssueResults = (BulkIssueResults) o;
    return Objects.equals(this.issueErrors, bulkIssueResults.issueErrors) &&
        Objects.equals(this.issues, bulkIssueResults.issues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueErrors, issues);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkIssueResults {\n");
    
    sb.append("    issueErrors: ").append(toIndentedString(issueErrors)).append("\n");
    sb.append("    issues: ").append(toIndentedString(issues)).append("\n");
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

