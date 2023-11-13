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
import org.everit.atlassian.restclient.jiracloud.v2.model.BulkOperationErrorResult;
import org.everit.atlassian.restclient.jiracloud.v2.model.CreatedIssue;

/**
 * Details about the issues created and the errors for requests that failed.
 */
@ApiModel(description = "Details about the issues created and the errors for requests that failed.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class CreatedIssues {
  @JsonProperty("errors")
  private List<BulkOperationErrorResult> errors = new ArrayList<>();

  @JsonProperty("issues")
  private List<CreatedIssue> issues = new ArrayList<>();

   /**
   * Error details for failed issue creation requests.
   * @return errors
  **/
  @ApiModelProperty(value = "Error details for failed issue creation requests.")
  public List<BulkOperationErrorResult> getErrors() {
    return errors;
  }

   /**
   * Details of the issues created.
   * @return issues
  **/
  @ApiModelProperty(value = "Details of the issues created.")
  public List<CreatedIssue> getIssues() {
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
    CreatedIssues createdIssues = (CreatedIssues) o;
    return Objects.equals(this.errors, createdIssues.errors) &&
        Objects.equals(this.issues, createdIssues.issues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors, issues);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatedIssues {\n");
    
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

