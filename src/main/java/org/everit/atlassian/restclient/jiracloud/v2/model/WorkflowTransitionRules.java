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
import org.everit.atlassian.restclient.jiracloud.v2.model.AppWorkflowTransitionRule;
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowId;

/**
 * A workflow with transition rules.
 */
@ApiModel(description = "A workflow with transition rules.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class WorkflowTransitionRules {
  @JsonProperty("conditions")
  private List<AppWorkflowTransitionRule> conditions = new ArrayList<>();

  @JsonProperty("postFunctions")
  private List<AppWorkflowTransitionRule> postFunctions = new ArrayList<>();

  @JsonProperty("validators")
  private List<AppWorkflowTransitionRule> validators = new ArrayList<>();

  @JsonProperty("workflowId")
  private WorkflowId workflowId;

  public WorkflowTransitionRules conditions(List<AppWorkflowTransitionRule> conditions) {
    this.conditions = conditions;
    return this;
  }

  public WorkflowTransitionRules addConditionsItem(AppWorkflowTransitionRule conditionsItem) {
    if (this.conditions == null) {
      this.conditions = new ArrayList<>();
    }
    this.conditions.add(conditionsItem);
    return this;
  }

   /**
   * The list of conditions within the workflow.
   * @return conditions
  **/
  @ApiModelProperty(value = "The list of conditions within the workflow.")
  public List<AppWorkflowTransitionRule> getConditions() {
    return conditions;
  }

  public void setConditions(List<AppWorkflowTransitionRule> conditions) {
    this.conditions = conditions;
  }

  public WorkflowTransitionRules postFunctions(List<AppWorkflowTransitionRule> postFunctions) {
    this.postFunctions = postFunctions;
    return this;
  }

  public WorkflowTransitionRules addPostFunctionsItem(AppWorkflowTransitionRule postFunctionsItem) {
    if (this.postFunctions == null) {
      this.postFunctions = new ArrayList<>();
    }
    this.postFunctions.add(postFunctionsItem);
    return this;
  }

   /**
   * The list of post functions within the workflow.
   * @return postFunctions
  **/
  @ApiModelProperty(value = "The list of post functions within the workflow.")
  public List<AppWorkflowTransitionRule> getPostFunctions() {
    return postFunctions;
  }

  public void setPostFunctions(List<AppWorkflowTransitionRule> postFunctions) {
    this.postFunctions = postFunctions;
  }

  public WorkflowTransitionRules validators(List<AppWorkflowTransitionRule> validators) {
    this.validators = validators;
    return this;
  }

  public WorkflowTransitionRules addValidatorsItem(AppWorkflowTransitionRule validatorsItem) {
    if (this.validators == null) {
      this.validators = new ArrayList<>();
    }
    this.validators.add(validatorsItem);
    return this;
  }

   /**
   * The list of validators within the workflow.
   * @return validators
  **/
  @ApiModelProperty(value = "The list of validators within the workflow.")
  public List<AppWorkflowTransitionRule> getValidators() {
    return validators;
  }

  public void setValidators(List<AppWorkflowTransitionRule> validators) {
    this.validators = validators;
  }

  public WorkflowTransitionRules workflowId(WorkflowId workflowId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowTransitionRules workflowTransitionRules = (WorkflowTransitionRules) o;
    return Objects.equals(this.conditions, workflowTransitionRules.conditions) &&
        Objects.equals(this.postFunctions, workflowTransitionRules.postFunctions) &&
        Objects.equals(this.validators, workflowTransitionRules.validators) &&
        Objects.equals(this.workflowId, workflowTransitionRules.workflowId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conditions, postFunctions, validators, workflowId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowTransitionRules {\n");
    
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("    postFunctions: ").append(toIndentedString(postFunctions)).append("\n");
    sb.append("    validators: ").append(toIndentedString(validators)).append("\n");
    sb.append("    workflowId: ").append(toIndentedString(workflowId)).append("\n");
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

