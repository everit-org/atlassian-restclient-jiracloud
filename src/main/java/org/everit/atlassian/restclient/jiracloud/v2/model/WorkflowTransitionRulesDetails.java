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
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowId;

/**
 * Details about a workflow configuration update request.
 */
@ApiModel(description = "Details about a workflow configuration update request.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class WorkflowTransitionRulesDetails {
  @JsonProperty("workflowId")
  private WorkflowId workflowId;

  @JsonProperty("workflowRuleIds")
  private List<String> workflowRuleIds = new ArrayList<>();

  public WorkflowTransitionRulesDetails workflowId(WorkflowId workflowId) {
    this.workflowId = workflowId;
    return this;
  }

   /**
   * Get workflowId
   * @return workflowId
  **/
  @ApiModelProperty(required = true, value = "")
  public WorkflowId getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(WorkflowId workflowId) {
    this.workflowId = workflowId;
  }

  public WorkflowTransitionRulesDetails workflowRuleIds(List<String> workflowRuleIds) {
    this.workflowRuleIds = workflowRuleIds;
    return this;
  }

  public WorkflowTransitionRulesDetails addWorkflowRuleIdsItem(String workflowRuleIdsItem) {
    this.workflowRuleIds.add(workflowRuleIdsItem);
    return this;
  }

   /**
   * The list of connect workflow rule IDs.
   * @return workflowRuleIds
  **/
  @ApiModelProperty(required = true, value = "The list of connect workflow rule IDs.")
  public List<String> getWorkflowRuleIds() {
    return workflowRuleIds;
  }

  public void setWorkflowRuleIds(List<String> workflowRuleIds) {
    this.workflowRuleIds = workflowRuleIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowTransitionRulesDetails workflowTransitionRulesDetails = (WorkflowTransitionRulesDetails) o;
    return Objects.equals(this.workflowId, workflowTransitionRulesDetails.workflowId) &&
        Objects.equals(this.workflowRuleIds, workflowTransitionRulesDetails.workflowRuleIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workflowId, workflowRuleIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowTransitionRulesDetails {\n");
    
    sb.append("    workflowId: ").append(toIndentedString(workflowId)).append("\n");
    sb.append("    workflowRuleIds: ").append(toIndentedString(workflowRuleIds)).append("\n");
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

