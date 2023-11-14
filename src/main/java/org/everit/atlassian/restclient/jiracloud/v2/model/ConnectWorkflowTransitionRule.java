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
import org.everit.atlassian.restclient.jiracloud.v2.model.RuleConfiguration;
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowTransition;

/**
 * A workflow transition rule.
 */
@ApiModel(description = "A workflow transition rule.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class ConnectWorkflowTransitionRule {
  @JsonProperty("configuration")
  private RuleConfiguration _configuration;

  @JsonProperty("id")
  private String id;

  @JsonProperty("key")
  private String key;

  @JsonProperty("transition")
  private WorkflowTransition transition;

  public ConnectWorkflowTransitionRule _configuration(RuleConfiguration _configuration) {
    this._configuration = _configuration;
    return this;
  }

   /**
   * Get _configuration
   * @return _configuration
  **/
  @ApiModelProperty(required = true, value = "")
  public RuleConfiguration getConfiguration() {
    return _configuration;
  }

  public void setConfiguration(RuleConfiguration _configuration) {
    this._configuration = _configuration;
  }

  public ConnectWorkflowTransitionRule id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the transition rule.
   * @return id
  **/
  @ApiModelProperty(example = "123", required = true, value = "The ID of the transition rule.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ConnectWorkflowTransitionRule key(String key) {
    this.key = key;
    return this;
  }

   /**
   * The key of the rule, as defined in the Connect app descriptor.
   * @return key
  **/
  @ApiModelProperty(example = "WorkflowKey", required = true, value = "The key of the rule, as defined in the Connect app descriptor.")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public ConnectWorkflowTransitionRule transition(WorkflowTransition transition) {
    this.transition = transition;
    return this;
  }

   /**
   * Get transition
   * @return transition
  **/
  @ApiModelProperty(value = "")
  public WorkflowTransition getTransition() {
    return transition;
  }

  public void setTransition(WorkflowTransition transition) {
    this.transition = transition;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectWorkflowTransitionRule connectWorkflowTransitionRule = (ConnectWorkflowTransitionRule) o;
    return Objects.equals(this._configuration, connectWorkflowTransitionRule._configuration) &&
        Objects.equals(this.id, connectWorkflowTransitionRule.id) &&
        Objects.equals(this.key, connectWorkflowTransitionRule.key) &&
        Objects.equals(this.transition, connectWorkflowTransitionRule.transition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_configuration, id, key, transition);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectWorkflowTransitionRule {\n");
    
    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    transition: ").append(toIndentedString(transition)).append("\n");
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

