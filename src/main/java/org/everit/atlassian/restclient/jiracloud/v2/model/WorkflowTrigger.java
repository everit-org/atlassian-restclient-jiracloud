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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The trigger configuration associated with a workflow.
 */
@ApiModel(description = "The trigger configuration associated with a workflow.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class WorkflowTrigger {
  @JsonProperty("id")
  private String id;

  @JsonProperty("parameters")
  private Map<String, String> parameters = new HashMap<>();

  @JsonProperty("ruleKey")
  private String ruleKey;

  public WorkflowTrigger id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the trigger.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the trigger.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public WorkflowTrigger parameters(Map<String, String> parameters) {
    this.parameters = parameters;
    return this;
  }

  public WorkflowTrigger putParametersItem(String key, String parametersItem) {
    this.parameters.put(key, parametersItem);
    return this;
  }

   /**
   * The parameters of the trigger.
   * @return parameters
  **/
  @ApiModelProperty(required = true, value = "The parameters of the trigger.")
  public Map<String, String> getParameters() {
    return parameters;
  }

  public void setParameters(Map<String, String> parameters) {
    this.parameters = parameters;
  }

  public WorkflowTrigger ruleKey(String ruleKey) {
    this.ruleKey = ruleKey;
    return this;
  }

   /**
   * The rule key of the trigger.
   * @return ruleKey
  **/
  @ApiModelProperty(required = true, value = "The rule key of the trigger.")
  public String getRuleKey() {
    return ruleKey;
  }

  public void setRuleKey(String ruleKey) {
    this.ruleKey = ruleKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowTrigger workflowTrigger = (WorkflowTrigger) o;
    return Objects.equals(this.id, workflowTrigger.id) &&
        Objects.equals(this.parameters, workflowTrigger.parameters) &&
        Objects.equals(this.ruleKey, workflowTrigger.ruleKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parameters, ruleKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowTrigger {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    ruleKey: ").append(toIndentedString(ruleKey)).append("\n");
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

