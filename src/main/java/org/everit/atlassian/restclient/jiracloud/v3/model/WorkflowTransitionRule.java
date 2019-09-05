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


package org.everit.atlassian.restclient.jiracloud.v3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A workflow transition rule.
 */
@ApiModel(description = "A workflow transition rule.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:37.034+02:00[Europe/Prague]")
public class WorkflowTransitionRule {
  @JsonProperty("type")
  private String type;

  @JsonProperty("configuration")
  private Object _configuration = null;

  public WorkflowTransitionRule type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The type of the transition rule.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The type of the transition rule.")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public WorkflowTransitionRule _configuration(Object _configuration) {
    this._configuration = _configuration;
    return this;
  }

   /**
   * The configuration of the transition rule. This is currently returned only for some of the rule types. Availability of this property is subject to change.
   * @return _configuration
  **/
  @ApiModelProperty(value = "The configuration of the transition rule. This is currently returned only for some of the rule types. Availability of this property is subject to change.")
  public Object getConfiguration() {
    return _configuration;
  }

  public void setConfiguration(Object _configuration) {
    this._configuration = _configuration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowTransitionRule workflowTransitionRule = (WorkflowTransitionRule) o;
    return Objects.equals(this.type, workflowTransitionRule.type) &&
        Objects.equals(this._configuration, workflowTransitionRule._configuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, _configuration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowTransitionRule {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
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

