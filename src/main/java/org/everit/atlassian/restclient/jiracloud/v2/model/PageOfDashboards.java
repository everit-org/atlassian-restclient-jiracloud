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
import org.everit.atlassian.restclient.jiracloud.v2.model.Dashboard;

/**
 * A page containing dashboard details.
 */
@ApiModel(description = "A page containing dashboard details.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class PageOfDashboards {
  @JsonProperty("dashboards")
  private List<Dashboard> dashboards = new ArrayList<>();

  @JsonProperty("maxResults")
  private Integer maxResults;

  @JsonProperty("next")
  private String next;

  @JsonProperty("prev")
  private String prev;

  @JsonProperty("startAt")
  private Integer startAt;

  @JsonProperty("total")
  private Integer total;

   /**
   * List of dashboards.
   * @return dashboards
  **/
  @ApiModelProperty(value = "List of dashboards.")
  public List<Dashboard> getDashboards() {
    return dashboards;
  }

   /**
   * The maximum number of results that could be on the page.
   * @return maxResults
  **/
  @ApiModelProperty(value = "The maximum number of results that could be on the page.")
  public Integer getMaxResults() {
    return maxResults;
  }

   /**
   * The URL of the next page of results, if any.
   * @return next
  **/
  @ApiModelProperty(value = "The URL of the next page of results, if any.")
  public String getNext() {
    return next;
  }

   /**
   * The URL of the previous page of results, if any.
   * @return prev
  **/
  @ApiModelProperty(value = "The URL of the previous page of results, if any.")
  public String getPrev() {
    return prev;
  }

   /**
   * The index of the first item returned on the page.
   * @return startAt
  **/
  @ApiModelProperty(value = "The index of the first item returned on the page.")
  public Integer getStartAt() {
    return startAt;
  }

   /**
   * The number of results on the page.
   * @return total
  **/
  @ApiModelProperty(value = "The number of results on the page.")
  public Integer getTotal() {
    return total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageOfDashboards pageOfDashboards = (PageOfDashboards) o;
    return Objects.equals(this.dashboards, pageOfDashboards.dashboards) &&
        Objects.equals(this.maxResults, pageOfDashboards.maxResults) &&
        Objects.equals(this.next, pageOfDashboards.next) &&
        Objects.equals(this.prev, pageOfDashboards.prev) &&
        Objects.equals(this.startAt, pageOfDashboards.startAt) &&
        Objects.equals(this.total, pageOfDashboards.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dashboards, maxResults, next, prev, startAt, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageOfDashboards {\n");
    
    sb.append("    dashboards: ").append(toIndentedString(dashboards)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

