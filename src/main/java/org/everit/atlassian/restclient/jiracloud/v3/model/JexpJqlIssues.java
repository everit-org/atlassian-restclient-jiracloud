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

/**
 * The JQL specifying the issues available in the evaluated Jira expression under the &#x60;issues&#x60; context variable. Not all issues returned by the JQL query are loaded, only those described by the &#x60;startAt&#x60; and &#x60;maxResults&#x60; properties. To determine whether it is necessary to iterate to ensure all the issues returned by the JQL query are evaluated, inspect &#x60;meta.issues.jql.count&#x60; in the response.
 */
@ApiModel(description = "The JQL specifying the issues available in the evaluated Jira expression under the `issues` context variable. Not all issues returned by the JQL query are loaded, only those described by the `startAt` and `maxResults` properties. To determine whether it is necessary to iterate to ensure all the issues returned by the JQL query are evaluated, inspect `meta.issues.jql.count` in the response.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class JexpJqlIssues {
  @JsonProperty("maxResults")
  private Integer maxResults;

  @JsonProperty("query")
  private String query;

  @JsonProperty("startAt")
  private Long startAt;

  /**
   * Determines how to validate the JQL query and treat the validation results.
   */
  public enum ValidationEnum {
    STRICT("strict"),
    
    WARN("warn"),
    
    NONE("none");

    private String value;

    ValidationEnum(String value) {
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
    public static ValidationEnum fromValue(String value) {
      for (ValidationEnum b : ValidationEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("validation")
  private ValidationEnum validation = ValidationEnum.STRICT;

  public JexpJqlIssues maxResults(Integer maxResults) {
    this.maxResults = maxResults;
    return this;
  }

   /**
   * The maximum number of issues to return from the JQL query. Inspect &#x60;meta.issues.jql.maxResults&#x60; in the response to ensure the maximum value has not been exceeded.
   * @return maxResults
  **/
  @ApiModelProperty(value = "The maximum number of issues to return from the JQL query. Inspect `meta.issues.jql.maxResults` in the response to ensure the maximum value has not been exceeded.")
  public Integer getMaxResults() {
    return maxResults;
  }

  public void setMaxResults(Integer maxResults) {
    this.maxResults = maxResults;
  }

  public JexpJqlIssues query(String query) {
    this.query = query;
    return this;
  }

   /**
   * The JQL query.
   * @return query
  **/
  @ApiModelProperty(value = "The JQL query.")
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public JexpJqlIssues startAt(Long startAt) {
    this.startAt = startAt;
    return this;
  }

   /**
   * The index of the first issue to return from the JQL query.
   * @return startAt
  **/
  @ApiModelProperty(value = "The index of the first issue to return from the JQL query.")
  public Long getStartAt() {
    return startAt;
  }

  public void setStartAt(Long startAt) {
    this.startAt = startAt;
  }

  public JexpJqlIssues validation(ValidationEnum validation) {
    this.validation = validation;
    return this;
  }

   /**
   * Determines how to validate the JQL query and treat the validation results.
   * @return validation
  **/
  @ApiModelProperty(value = "Determines how to validate the JQL query and treat the validation results.")
  public ValidationEnum getValidation() {
    return validation;
  }

  public void setValidation(ValidationEnum validation) {
    this.validation = validation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JexpJqlIssues jexpJqlIssues = (JexpJqlIssues) o;
    return Objects.equals(this.maxResults, jexpJqlIssues.maxResults) &&
        Objects.equals(this.query, jexpJqlIssues.query) &&
        Objects.equals(this.startAt, jexpJqlIssues.startAt) &&
        Objects.equals(this.validation, jexpJqlIssues.validation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxResults, query, startAt, validation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JexpJqlIssues {\n");
    
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    validation: ").append(toIndentedString(validation)).append("\n");
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

