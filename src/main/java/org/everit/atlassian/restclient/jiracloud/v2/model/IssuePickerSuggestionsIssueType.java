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
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.SuggestedIssue;

/**
 * A type of issue suggested for use in auto-completion.
 */
@ApiModel(description = "A type of issue suggested for use in auto-completion.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:30.184+02:00[Europe/Prague]")
public class IssuePickerSuggestionsIssueType {
  @JsonProperty("label")
  private String label;

  @JsonProperty("sub")
  private String sub;

  @JsonProperty("id")
  private String id;

  @JsonProperty("msg")
  private String msg;

  @JsonProperty("issues")
  private List<SuggestedIssue> issues = new ArrayList<>();

   /**
   * The label of the type of issues suggested for use in auto-completion.
   * @return label
  **/
  @ApiModelProperty(value = "The label of the type of issues suggested for use in auto-completion.")
  public String getLabel() {
    return label;
  }

   /**
   * If issue suggestions are found, returns a message indicating the number of issues suggestions found and returned.
   * @return sub
  **/
  @ApiModelProperty(value = "If issue suggestions are found, returns a message indicating the number of issues suggestions found and returned.")
  public String getSub() {
    return sub;
  }

   /**
   * The ID of the type of issues suggested for use in auto-completion.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the type of issues suggested for use in auto-completion.")
  public String getId() {
    return id;
  }

   /**
   * If no issue suggestions are found, returns a message indicating no suggestions were found,
   * @return msg
  **/
  @ApiModelProperty(value = "If no issue suggestions are found, returns a message indicating no suggestions were found,")
  public String getMsg() {
    return msg;
  }

   /**
   * A list of issues suggested for use in auto-completion.
   * @return issues
  **/
  @ApiModelProperty(value = "A list of issues suggested for use in auto-completion.")
  public List<SuggestedIssue> getIssues() {
    return issues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssuePickerSuggestionsIssueType issuePickerSuggestionsIssueType = (IssuePickerSuggestionsIssueType) o;
    return Objects.equals(this.label, issuePickerSuggestionsIssueType.label) &&
        Objects.equals(this.sub, issuePickerSuggestionsIssueType.sub) &&
        Objects.equals(this.id, issuePickerSuggestionsIssueType.id) &&
        Objects.equals(this.msg, issuePickerSuggestionsIssueType.msg) &&
        Objects.equals(this.issues, issuePickerSuggestionsIssueType.issues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, sub, id, msg, issues);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssuePickerSuggestionsIssueType {\n");
    
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
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

