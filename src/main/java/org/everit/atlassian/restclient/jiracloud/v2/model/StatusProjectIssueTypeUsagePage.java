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
import org.everit.atlassian.restclient.jiracloud.v2.model.StatusProjectIssueTypeUsage;

/**
 * A page of issue types.
 */
@ApiModel(description = "A page of issue types.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class StatusProjectIssueTypeUsagePage {
  @JsonProperty("nextPageToken")
  private String nextPageToken;

  @JsonProperty("values")
  private List<StatusProjectIssueTypeUsage> values = new ArrayList<>();

  public StatusProjectIssueTypeUsagePage nextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
    return this;
  }

   /**
   * Page token for the next page of issue type usages.
   * @return nextPageToken
  **/
  @ApiModelProperty(value = "Page token for the next page of issue type usages.")
  public String getNextPageToken() {
    return nextPageToken;
  }

  public void setNextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
  }

  public StatusProjectIssueTypeUsagePage values(List<StatusProjectIssueTypeUsage> values) {
    this.values = values;
    return this;
  }

  public StatusProjectIssueTypeUsagePage addValuesItem(StatusProjectIssueTypeUsage valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<>();
    }
    this.values.add(valuesItem);
    return this;
  }

   /**
   * The list of issue types.
   * @return values
  **/
  @ApiModelProperty(value = "The list of issue types.")
  public List<StatusProjectIssueTypeUsage> getValues() {
    return values;
  }

  public void setValues(List<StatusProjectIssueTypeUsage> values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusProjectIssueTypeUsagePage statusProjectIssueTypeUsagePage = (StatusProjectIssueTypeUsagePage) o;
    return Objects.equals(this.nextPageToken, statusProjectIssueTypeUsagePage.nextPageToken) &&
        Objects.equals(this.values, statusProjectIssueTypeUsagePage.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextPageToken, values);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusProjectIssueTypeUsagePage {\n");
    
    sb.append("    nextPageToken: ").append(toIndentedString(nextPageToken)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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

