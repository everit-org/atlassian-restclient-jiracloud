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
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueBulkTransitionForWorkflow;

/**
 * Bulk Transition Get Available Transitions Response.
 */
@ApiModel(description = "Bulk Transition Get Available Transitions Response.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class BulkTransitionGetAvailableTransitions {
  @JsonProperty("availableTransitions")
  private List<IssueBulkTransitionForWorkflow> availableTransitions = new ArrayList<>();

  @JsonProperty("endingBefore")
  private String endingBefore;

  @JsonProperty("startingAfter")
  private String startingAfter;

   /**
   * List of available transitions for bulk transition operation for requested issues grouped by workflow
   * @return availableTransitions
  **/
  @ApiModelProperty(value = "List of available transitions for bulk transition operation for requested issues grouped by workflow")
  public List<IssueBulkTransitionForWorkflow> getAvailableTransitions() {
    return availableTransitions;
  }

   /**
   * The end cursor for use in pagination.
   * @return endingBefore
  **/
  @ApiModelProperty(value = "The end cursor for use in pagination.")
  public String getEndingBefore() {
    return endingBefore;
  }

   /**
   * The start cursor for use in pagination.
   * @return startingAfter
  **/
  @ApiModelProperty(value = "The start cursor for use in pagination.")
  public String getStartingAfter() {
    return startingAfter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkTransitionGetAvailableTransitions bulkTransitionGetAvailableTransitions = (BulkTransitionGetAvailableTransitions) o;
    return Objects.equals(this.availableTransitions, bulkTransitionGetAvailableTransitions.availableTransitions) &&
        Objects.equals(this.endingBefore, bulkTransitionGetAvailableTransitions.endingBefore) &&
        Objects.equals(this.startingAfter, bulkTransitionGetAvailableTransitions.startingAfter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availableTransitions, endingBefore, startingAfter);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkTransitionGetAvailableTransitions {\n");
    
    sb.append("    availableTransitions: ").append(toIndentedString(availableTransitions)).append("\n");
    sb.append("    endingBefore: ").append(toIndentedString(endingBefore)).append("\n");
    sb.append("    startingAfter: ").append(toIndentedString(startingAfter)).append("\n");
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

