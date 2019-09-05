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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowId;

/**
 * Details of any errors encountered while updating workflow transition rules for a workflow.
 */
@ApiModel(description = "Details of any errors encountered while updating workflow transition rules for a workflow.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:30.184+02:00[Europe/Prague]")
public class WorkflowTransitionRulesUpdateErrorDetails {
  @JsonProperty("workflowId")
  private WorkflowId workflowId;

  @JsonProperty("ruleUpdateErrors")
  private Map<String, List<String>> ruleUpdateErrors = new HashMap<>();

  @JsonProperty("updateErrors")
  private List<String> updateErrors = new ArrayList<>();

  public WorkflowTransitionRulesUpdateErrorDetails workflowId(WorkflowId workflowId) {
    this.workflowId = workflowId;
    return this;
  }

   /**
   * Get workflowId
   * @return workflowId
  **/
  @ApiModelProperty(value = "")
  public WorkflowId getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(WorkflowId workflowId) {
    this.workflowId = workflowId;
  }

  public WorkflowTransitionRulesUpdateErrorDetails ruleUpdateErrors(Map<String, List<String>> ruleUpdateErrors) {
    this.ruleUpdateErrors = ruleUpdateErrors;
    return this;
  }

  public WorkflowTransitionRulesUpdateErrorDetails putRuleUpdateErrorsItem(String key, List<String> ruleUpdateErrorsItem) {
    this.ruleUpdateErrors.put(key, ruleUpdateErrorsItem);
    return this;
  }

   /**
   * A list of transition rule update errors, indexed by the transition rule ID. Any transition rule that appears here wasn&#39;t updated.
   * @return ruleUpdateErrors
  **/
  @ApiModelProperty(required = true, value = "A list of transition rule update errors, indexed by the transition rule ID. Any transition rule that appears here wasn't updated.")
  public Map<String, List<String>> getRuleUpdateErrors() {
    return ruleUpdateErrors;
  }

  public void setRuleUpdateErrors(Map<String, List<String>> ruleUpdateErrors) {
    this.ruleUpdateErrors = ruleUpdateErrors;
  }

  public WorkflowTransitionRulesUpdateErrorDetails updateErrors(List<String> updateErrors) {
    this.updateErrors = updateErrors;
    return this;
  }

  public WorkflowTransitionRulesUpdateErrorDetails addUpdateErrorsItem(String updateErrorsItem) {
    if (this.updateErrors == null) {
      this.updateErrors = new ArrayList<>();
    }
    this.updateErrors.add(updateErrorsItem);
    return this;
  }

   /**
   * The list of errors that specify why the workflow update failed. The workflow was not updated if the list contains any entries.
   * @return updateErrors
  **/
  @ApiModelProperty(value = "The list of errors that specify why the workflow update failed. The workflow was not updated if the list contains any entries.")
  public List<String> getUpdateErrors() {
    return updateErrors;
  }

  public void setUpdateErrors(List<String> updateErrors) {
    this.updateErrors = updateErrors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowTransitionRulesUpdateErrorDetails workflowTransitionRulesUpdateErrorDetails = (WorkflowTransitionRulesUpdateErrorDetails) o;
    return Objects.equals(this.workflowId, workflowTransitionRulesUpdateErrorDetails.workflowId) &&
        Objects.equals(this.ruleUpdateErrors, workflowTransitionRulesUpdateErrorDetails.ruleUpdateErrors) &&
        Objects.equals(this.updateErrors, workflowTransitionRulesUpdateErrorDetails.updateErrors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workflowId, ruleUpdateErrors, updateErrors);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowTransitionRulesUpdateErrorDetails {\n");
    
    sb.append("    workflowId: ").append(toIndentedString(workflowId)).append("\n");
    sb.append("    ruleUpdateErrors: ").append(toIndentedString(ruleUpdateErrors)).append("\n");
    sb.append("    updateErrors: ").append(toIndentedString(updateErrors)).append("\n");
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

