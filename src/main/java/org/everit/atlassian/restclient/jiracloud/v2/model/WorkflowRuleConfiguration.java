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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The configuration of the rule.
 */
@ApiModel(description = "The configuration of the rule.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class WorkflowRuleConfiguration {
  @JsonProperty("id")
  private String id;

  @JsonProperty("parameters")
  private Map<String, String> parameters = new HashMap<>();

  @JsonProperty("ruleKey")
  private String ruleKey;

  public WorkflowRuleConfiguration id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the rule.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the rule.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public WorkflowRuleConfiguration parameters(Map<String, String> parameters) {
    this.parameters = parameters;
    return this;
  }

  public WorkflowRuleConfiguration putParametersItem(String key, String parametersItem) {
    if (this.parameters == null) {
      this.parameters = new HashMap<>();
    }
    this.parameters.put(key, parametersItem);
    return this;
  }

   /**
   * The parameters related to the rule.
   * @return parameters
  **/
  @ApiModelProperty(value = "The parameters related to the rule.")
  public Map<String, String> getParameters() {
    return parameters;
  }

  public void setParameters(Map<String, String> parameters) {
    this.parameters = parameters;
  }

  public WorkflowRuleConfiguration ruleKey(String ruleKey) {
    this.ruleKey = ruleKey;
    return this;
  }

   /**
   * The rule key of the rule.
   * @return ruleKey
  **/
  @ApiModelProperty(required = true, value = "The rule key of the rule.")
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
    WorkflowRuleConfiguration workflowRuleConfiguration = (WorkflowRuleConfiguration) o;
    return Objects.equals(this.id, workflowRuleConfiguration.id) &&
        Objects.equals(this.parameters, workflowRuleConfiguration.parameters) &&
        Objects.equals(this.ruleKey, workflowRuleConfiguration.ruleKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parameters, ruleKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowRuleConfiguration {\n");
    
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

