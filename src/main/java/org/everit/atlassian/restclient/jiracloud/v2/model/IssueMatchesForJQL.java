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
import java.util.List;

/**
 * A list of the issues matched to a JQL query or details of errors encountered during matching.
 */
@ApiModel(description = "A list of the issues matched to a JQL query or details of errors encountered during matching.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class IssueMatchesForJQL {
  @JsonProperty("errors")
  private List<String> errors = new ArrayList<>();

  @JsonProperty("matchedIssues")
  private List<Long> matchedIssues = new ArrayList<>();

  public IssueMatchesForJQL errors(List<String> errors) {
    this.errors = errors;
    return this;
  }

  public IssueMatchesForJQL addErrorsItem(String errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }

   /**
   * A list of errors.
   * @return errors
  **/
  @ApiModelProperty(required = true, value = "A list of errors.")
  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public IssueMatchesForJQL matchedIssues(List<Long> matchedIssues) {
    this.matchedIssues = matchedIssues;
    return this;
  }

  public IssueMatchesForJQL addMatchedIssuesItem(Long matchedIssuesItem) {
    this.matchedIssues.add(matchedIssuesItem);
    return this;
  }

   /**
   * A list of issue IDs.
   * @return matchedIssues
  **/
  @ApiModelProperty(required = true, value = "A list of issue IDs.")
  public List<Long> getMatchedIssues() {
    return matchedIssues;
  }

  public void setMatchedIssues(List<Long> matchedIssues) {
    this.matchedIssues = matchedIssues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueMatchesForJQL issueMatchesForJQL = (IssueMatchesForJQL) o;
    return Objects.equals(this.errors, issueMatchesForJQL.errors) &&
        Objects.equals(this.matchedIssues, issueMatchesForJQL.matchedIssues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors, matchedIssues);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueMatchesForJQL {\n");
    
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    matchedIssues: ").append(toIndentedString(matchedIssues)).append("\n");
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

