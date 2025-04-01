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
import org.everit.atlassian.restclient.jiracloud.v2.model.CustomContextVariable;
import org.everit.atlassian.restclient.jiracloud.v2.model.IdOrKeyBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.JexpIssues;

/**
 * JiraExpressionEvalContextBean
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class JiraExpressionEvalContextBean {
  @JsonProperty("board")
  private Long board;

  @JsonProperty("custom")
  private List<CustomContextVariable> custom = new ArrayList<>();

  @JsonProperty("customerRequest")
  private Long customerRequest;

  @JsonProperty("issue")
  private IdOrKeyBean issue;

  @JsonProperty("issues")
  private JexpIssues issues;

  @JsonProperty("project")
  private IdOrKeyBean project;

  @JsonProperty("serviceDesk")
  private Long serviceDesk;

  @JsonProperty("sprint")
  private Long sprint;

  public JiraExpressionEvalContextBean board(Long board) {
    this.board = board;
    return this;
  }

   /**
   * The ID of the board that is available under the &#x60;board&#x60; variable when evaluating the expression.
   * @return board
  **/
  @ApiModelProperty(value = "The ID of the board that is available under the `board` variable when evaluating the expression.")
  public Long getBoard() {
    return board;
  }

  public void setBoard(Long board) {
    this.board = board;
  }

  public JiraExpressionEvalContextBean custom(List<CustomContextVariable> custom) {
    this.custom = custom;
    return this;
  }

  public JiraExpressionEvalContextBean addCustomItem(CustomContextVariable customItem) {
    if (this.custom == null) {
      this.custom = new ArrayList<>();
    }
    this.custom.add(customItem);
    return this;
  }

   /**
   * Custom context variables and their types. These variable types are available for use in a custom context:   *  &#x60;user&#x60;: A [user](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#user) specified as an Atlassian account ID.  *  &#x60;issue&#x60;: An [issue](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#issue) specified by ID or key. All the fields of the issue object are available in the Jira expression.  *  &#x60;json&#x60;: A JSON object containing custom content.  *  &#x60;list&#x60;: A JSON list of &#x60;user&#x60;, &#x60;issue&#x60;, or &#x60;json&#x60; variable types.
   * @return custom
  **/
  @ApiModelProperty(value = "Custom context variables and their types. These variable types are available for use in a custom context:   *  `user`: A [user](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#user) specified as an Atlassian account ID.  *  `issue`: An [issue](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#issue) specified by ID or key. All the fields of the issue object are available in the Jira expression.  *  `json`: A JSON object containing custom content.  *  `list`: A JSON list of `user`, `issue`, or `json` variable types.")
  public List<CustomContextVariable> getCustom() {
    return custom;
  }

  public void setCustom(List<CustomContextVariable> custom) {
    this.custom = custom;
  }

  public JiraExpressionEvalContextBean customerRequest(Long customerRequest) {
    this.customerRequest = customerRequest;
    return this;
  }

   /**
   * The ID of the customer request that is available under the &#x60;customerRequest&#x60; variable when evaluating the expression. This is the same as the ID of the underlying Jira issue, but the customer request context variable will have a different type.
   * @return customerRequest
  **/
  @ApiModelProperty(value = "The ID of the customer request that is available under the `customerRequest` variable when evaluating the expression. This is the same as the ID of the underlying Jira issue, but the customer request context variable will have a different type.")
  public Long getCustomerRequest() {
    return customerRequest;
  }

  public void setCustomerRequest(Long customerRequest) {
    this.customerRequest = customerRequest;
  }

  public JiraExpressionEvalContextBean issue(IdOrKeyBean issue) {
    this.issue = issue;
    return this;
  }

   /**
   * The issue that is available under the &#x60;issue&#x60; variable when evaluating the expression.
   * @return issue
  **/
  @ApiModelProperty(value = "The issue that is available under the `issue` variable when evaluating the expression.")
  public IdOrKeyBean getIssue() {
    return issue;
  }

  public void setIssue(IdOrKeyBean issue) {
    this.issue = issue;
  }

  public JiraExpressionEvalContextBean issues(JexpIssues issues) {
    this.issues = issues;
    return this;
  }

   /**
   * The collection of issues that is available under the &#x60;issues&#x60; variable when evaluating the expression.
   * @return issues
  **/
  @ApiModelProperty(value = "The collection of issues that is available under the `issues` variable when evaluating the expression.")
  public JexpIssues getIssues() {
    return issues;
  }

  public void setIssues(JexpIssues issues) {
    this.issues = issues;
  }

  public JiraExpressionEvalContextBean project(IdOrKeyBean project) {
    this.project = project;
    return this;
  }

   /**
   * The project that is available under the &#x60;project&#x60; variable when evaluating the expression.
   * @return project
  **/
  @ApiModelProperty(value = "The project that is available under the `project` variable when evaluating the expression.")
  public IdOrKeyBean getProject() {
    return project;
  }

  public void setProject(IdOrKeyBean project) {
    this.project = project;
  }

  public JiraExpressionEvalContextBean serviceDesk(Long serviceDesk) {
    this.serviceDesk = serviceDesk;
    return this;
  }

   /**
   * The ID of the service desk that is available under the &#x60;serviceDesk&#x60; variable when evaluating the expression.
   * @return serviceDesk
  **/
  @ApiModelProperty(value = "The ID of the service desk that is available under the `serviceDesk` variable when evaluating the expression.")
  public Long getServiceDesk() {
    return serviceDesk;
  }

  public void setServiceDesk(Long serviceDesk) {
    this.serviceDesk = serviceDesk;
  }

  public JiraExpressionEvalContextBean sprint(Long sprint) {
    this.sprint = sprint;
    return this;
  }

   /**
   * The ID of the sprint that is available under the &#x60;sprint&#x60; variable when evaluating the expression.
   * @return sprint
  **/
  @ApiModelProperty(value = "The ID of the sprint that is available under the `sprint` variable when evaluating the expression.")
  public Long getSprint() {
    return sprint;
  }

  public void setSprint(Long sprint) {
    this.sprint = sprint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JiraExpressionEvalContextBean jiraExpressionEvalContextBean = (JiraExpressionEvalContextBean) o;
    return Objects.equals(this.board, jiraExpressionEvalContextBean.board) &&
        Objects.equals(this.custom, jiraExpressionEvalContextBean.custom) &&
        Objects.equals(this.customerRequest, jiraExpressionEvalContextBean.customerRequest) &&
        Objects.equals(this.issue, jiraExpressionEvalContextBean.issue) &&
        Objects.equals(this.issues, jiraExpressionEvalContextBean.issues) &&
        Objects.equals(this.project, jiraExpressionEvalContextBean.project) &&
        Objects.equals(this.serviceDesk, jiraExpressionEvalContextBean.serviceDesk) &&
        Objects.equals(this.sprint, jiraExpressionEvalContextBean.sprint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(board, custom, customerRequest, issue, issues, project, serviceDesk, sprint);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JiraExpressionEvalContextBean {\n");
    
    sb.append("    board: ").append(toIndentedString(board)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    customerRequest: ").append(toIndentedString(customerRequest)).append("\n");
    sb.append("    issue: ").append(toIndentedString(issue)).append("\n");
    sb.append("    issues: ").append(toIndentedString(issues)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    serviceDesk: ").append(toIndentedString(serviceDesk)).append("\n");
    sb.append("    sprint: ").append(toIndentedString(sprint)).append("\n");
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

