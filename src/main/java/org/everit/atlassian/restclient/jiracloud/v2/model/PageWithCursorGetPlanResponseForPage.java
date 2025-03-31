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
import org.everit.atlassian.restclient.jiracloud.v2.model.GetPlanResponseForPage;

/**
 * PageWithCursorGetPlanResponseForPage
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class PageWithCursorGetPlanResponseForPage {
  @JsonProperty("cursor")
  private String cursor;

  @JsonProperty("last")
  private Boolean last;

  @JsonProperty("nextPageCursor")
  private String nextPageCursor;

  @JsonProperty("size")
  private Integer size;

  @JsonProperty("total")
  private Long total;

  @JsonProperty("values")
  private List<GetPlanResponseForPage> values = new ArrayList<>();

  public PageWithCursorGetPlanResponseForPage cursor(String cursor) {
    this.cursor = cursor;
    return this;
  }

   /**
   * Get cursor
   * @return cursor
  **/
  @ApiModelProperty(value = "")
  public String getCursor() {
    return cursor;
  }

  public void setCursor(String cursor) {
    this.cursor = cursor;
  }

  public PageWithCursorGetPlanResponseForPage last(Boolean last) {
    this.last = last;
    return this;
  }

   /**
   * Get last
   * @return last
  **/
  @ApiModelProperty(value = "")
  public Boolean getLast() {
    return last;
  }

  public void setLast(Boolean last) {
    this.last = last;
  }

  public PageWithCursorGetPlanResponseForPage nextPageCursor(String nextPageCursor) {
    this.nextPageCursor = nextPageCursor;
    return this;
  }

   /**
   * Get nextPageCursor
   * @return nextPageCursor
  **/
  @ApiModelProperty(value = "")
  public String getNextPageCursor() {
    return nextPageCursor;
  }

  public void setNextPageCursor(String nextPageCursor) {
    this.nextPageCursor = nextPageCursor;
  }

  public PageWithCursorGetPlanResponseForPage size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @ApiModelProperty(value = "")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public PageWithCursorGetPlanResponseForPage total(Long total) {
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @ApiModelProperty(value = "")
  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public PageWithCursorGetPlanResponseForPage values(List<GetPlanResponseForPage> values) {
    this.values = values;
    return this;
  }

  public PageWithCursorGetPlanResponseForPage addValuesItem(GetPlanResponseForPage valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<>();
    }
    this.values.add(valuesItem);
    return this;
  }

   /**
   * Get values
   * @return values
  **/
  @ApiModelProperty(value = "")
  public List<GetPlanResponseForPage> getValues() {
    return values;
  }

  public void setValues(List<GetPlanResponseForPage> values) {
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
    PageWithCursorGetPlanResponseForPage pageWithCursorGetPlanResponseForPage = (PageWithCursorGetPlanResponseForPage) o;
    return Objects.equals(this.cursor, pageWithCursorGetPlanResponseForPage.cursor) &&
        Objects.equals(this.last, pageWithCursorGetPlanResponseForPage.last) &&
        Objects.equals(this.nextPageCursor, pageWithCursorGetPlanResponseForPage.nextPageCursor) &&
        Objects.equals(this.size, pageWithCursorGetPlanResponseForPage.size) &&
        Objects.equals(this.total, pageWithCursorGetPlanResponseForPage.total) &&
        Objects.equals(this.values, pageWithCursorGetPlanResponseForPage.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cursor, last, nextPageCursor, size, total, values);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageWithCursorGetPlanResponseForPage {\n");
    
    sb.append("    cursor: ").append(toIndentedString(cursor)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    nextPageCursor: ").append(toIndentedString(nextPageCursor)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

