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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Details about the complexity of the analysed Jira expression.
 */
@ApiModel(description = "Details about the complexity of the analysed Jira expression.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class JiraExpressionComplexity {
  @JsonProperty("expensiveOperations")
  private String expensiveOperations;

  @JsonProperty("variables")
  private Map<String, String> variables = new HashMap<>();

  public JiraExpressionComplexity expensiveOperations(String expensiveOperations) {
    this.expensiveOperations = expensiveOperations;
    return this;
  }

   /**
   * Information that can be used to determine how many [expensive operations](https://developer.atlassian.com/cloud/jira/platform/jira-expressions/#expensive-operations) the evaluation of the expression will perform. This information may be a formula or number. For example:   *  &#x60;issues.map(i &#x3D;&gt; i.comments)&#x60; performs as many expensive operations as there are issues on the issues list. So this parameter returns &#x60;N&#x60;, where &#x60;N&#x60; is the size of issue list.  *  &#x60;new Issue(10010).comments&#x60; gets comments for one issue, so its complexity is &#x60;2&#x60; (&#x60;1&#x60; to retrieve issue 10010 from the database plus &#x60;1&#x60; to get its comments).
   * @return expensiveOperations
  **/
  @ApiModelProperty(required = true, value = "Information that can be used to determine how many [expensive operations](https://developer.atlassian.com/cloud/jira/platform/jira-expressions/#expensive-operations) the evaluation of the expression will perform. This information may be a formula or number. For example:   *  `issues.map(i => i.comments)` performs as many expensive operations as there are issues on the issues list. So this parameter returns `N`, where `N` is the size of issue list.  *  `new Issue(10010).comments` gets comments for one issue, so its complexity is `2` (`1` to retrieve issue 10010 from the database plus `1` to get its comments).")
  public String getExpensiveOperations() {
    return expensiveOperations;
  }

  public void setExpensiveOperations(String expensiveOperations) {
    this.expensiveOperations = expensiveOperations;
  }

  public JiraExpressionComplexity variables(Map<String, String> variables) {
    this.variables = variables;
    return this;
  }

  public JiraExpressionComplexity putVariablesItem(String key, String variablesItem) {
    if (this.variables == null) {
      this.variables = new HashMap<>();
    }
    this.variables.put(key, variablesItem);
    return this;
  }

   /**
   * Variables used in the formula, mapped to the parts of the expression they refer to.
   * @return variables
  **/
  @ApiModelProperty(value = "Variables used in the formula, mapped to the parts of the expression they refer to.")
  public Map<String, String> getVariables() {
    return variables;
  }

  public void setVariables(Map<String, String> variables) {
    this.variables = variables;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JiraExpressionComplexity jiraExpressionComplexity = (JiraExpressionComplexity) o;
    return Objects.equals(this.expensiveOperations, jiraExpressionComplexity.expensiveOperations) &&
        Objects.equals(this.variables, jiraExpressionComplexity.variables);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expensiveOperations, variables);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JiraExpressionComplexity {\n");
    
    sb.append("    expensiveOperations: ").append(toIndentedString(expensiveOperations)).append("\n");
    sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
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

