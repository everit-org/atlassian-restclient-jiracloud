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
import org.everit.atlassian.restclient.jiracloud.v2.model.IssuesMetaBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.JiraExpressionsComplexityBean;

/**
 * JiraExpressionEvaluationMetaDataBean
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class JiraExpressionEvaluationMetaDataBean {
  @JsonProperty("complexity")
  private JiraExpressionsComplexityBean complexity;

  @JsonProperty("issues")
  private IssuesMetaBean issues;

  public JiraExpressionEvaluationMetaDataBean complexity(JiraExpressionsComplexityBean complexity) {
    this.complexity = complexity;
    return this;
  }

   /**
   * Contains information about the expression complexity. For example, the number of steps it took to evaluate the expression.
   * @return complexity
  **/
  @ApiModelProperty(value = "Contains information about the expression complexity. For example, the number of steps it took to evaluate the expression.")
  public JiraExpressionsComplexityBean getComplexity() {
    return complexity;
  }

  public void setComplexity(JiraExpressionsComplexityBean complexity) {
    this.complexity = complexity;
  }

  public JiraExpressionEvaluationMetaDataBean issues(IssuesMetaBean issues) {
    this.issues = issues;
    return this;
  }

   /**
   * Contains information about the &#x60;issues&#x60; variable in the context. For example, is the issues were loaded with JQL, information about the page will be included here.
   * @return issues
  **/
  @ApiModelProperty(value = "Contains information about the `issues` variable in the context. For example, is the issues were loaded with JQL, information about the page will be included here.")
  public IssuesMetaBean getIssues() {
    return issues;
  }

  public void setIssues(IssuesMetaBean issues) {
    this.issues = issues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JiraExpressionEvaluationMetaDataBean jiraExpressionEvaluationMetaDataBean = (JiraExpressionEvaluationMetaDataBean) o;
    return Objects.equals(this.complexity, jiraExpressionEvaluationMetaDataBean.complexity) &&
        Objects.equals(this.issues, jiraExpressionEvaluationMetaDataBean.issues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(complexity, issues);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JiraExpressionEvaluationMetaDataBean {\n");
    
    sb.append("    complexity: ").append(toIndentedString(complexity)).append("\n");
    sb.append("    issues: ").append(toIndentedString(issues)).append("\n");
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

