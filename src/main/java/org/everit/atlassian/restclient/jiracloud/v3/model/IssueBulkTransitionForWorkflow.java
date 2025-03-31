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
import org.everit.atlassian.restclient.jiracloud.v3.model.SimplifiedIssueTransition;

/**
 * IssueBulkTransitionForWorkflow
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class IssueBulkTransitionForWorkflow {
  @JsonProperty("isTransitionsFiltered")
  private Boolean isTransitionsFiltered;

  @JsonProperty("issues")
  private List<String> issues = new ArrayList<>();

  @JsonProperty("transitions")
  private List<SimplifiedIssueTransition> transitions = new ArrayList<>();

   /**
   * Indicates whether all the transitions of this workflow are available in the transitions list or not.
   * @return isTransitionsFiltered
  **/
  @ApiModelProperty(value = "Indicates whether all the transitions of this workflow are available in the transitions list or not.")
  public Boolean getIsTransitionsFiltered() {
    return isTransitionsFiltered;
  }

   /**
   * List of issue keys from the request which are associated with this workflow.
   * @return issues
  **/
  @ApiModelProperty(value = "List of issue keys from the request which are associated with this workflow.")
  public List<String> getIssues() {
    return issues;
  }

   /**
   * List of transitions available for issues from the request which are associated with this workflow.   **This list includes only those transitions that are common across the issues in this workflow and do not involve any additional field updates.** 
   * @return transitions
  **/
  @ApiModelProperty(value = "List of transitions available for issues from the request which are associated with this workflow.   **This list includes only those transitions that are common across the issues in this workflow and do not involve any additional field updates.** ")
  public List<SimplifiedIssueTransition> getTransitions() {
    return transitions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueBulkTransitionForWorkflow issueBulkTransitionForWorkflow = (IssueBulkTransitionForWorkflow) o;
    return Objects.equals(this.isTransitionsFiltered, issueBulkTransitionForWorkflow.isTransitionsFiltered) &&
        Objects.equals(this.issues, issueBulkTransitionForWorkflow.issues) &&
        Objects.equals(this.transitions, issueBulkTransitionForWorkflow.transitions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isTransitionsFiltered, issues, transitions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueBulkTransitionForWorkflow {\n");
    
    sb.append("    isTransitionsFiltered: ").append(toIndentedString(isTransitionsFiltered)).append("\n");
    sb.append("    issues: ").append(toIndentedString(issues)).append("\n");
    sb.append("    transitions: ").append(toIndentedString(transitions)).append("\n");
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

