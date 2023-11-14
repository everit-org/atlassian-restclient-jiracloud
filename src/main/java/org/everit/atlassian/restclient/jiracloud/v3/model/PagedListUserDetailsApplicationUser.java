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
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v3.model.UserDetails;

/**
 * A paged list. To access additional details append &#x60;[start-index:end-index]&#x60; to the expand request. For example, &#x60;?expand&#x3D;sharedUsers[10:40]&#x60; returns a list starting at item 10 and finishing at item 40.
 */
@ApiModel(description = "A paged list. To access additional details append `[start-index:end-index]` to the expand request. For example, `?expand=sharedUsers[10:40]` returns a list starting at item 10 and finishing at item 40.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class PagedListUserDetailsApplicationUser {
  @JsonProperty("end-index")
  private Integer endIndex;

  @JsonProperty("items")
  private List<UserDetails> items = new ArrayList<>();

  @JsonProperty("max-results")
  private Integer maxResults;

  @JsonProperty("size")
  private Integer size;

  @JsonProperty("start-index")
  private Integer startIndex;

   /**
   * The index of the last item returned on the page.
   * @return endIndex
  **/
  @ApiModelProperty(value = "The index of the last item returned on the page.")
  public Integer getEndIndex() {
    return endIndex;
  }

   /**
   * The list of items.
   * @return items
  **/
  @ApiModelProperty(value = "The list of items.")
  public List<UserDetails> getItems() {
    return items;
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
   * The number of items on the page.
   * @return size
  **/
  @ApiModelProperty(value = "The number of items on the page.")
  public Integer getSize() {
    return size;
  }

   /**
   * The index of the first item returned on the page.
   * @return startIndex
  **/
  @ApiModelProperty(value = "The index of the first item returned on the page.")
  public Integer getStartIndex() {
    return startIndex;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PagedListUserDetailsApplicationUser pagedListUserDetailsApplicationUser = (PagedListUserDetailsApplicationUser) o;
    return Objects.equals(this.endIndex, pagedListUserDetailsApplicationUser.endIndex) &&
        Objects.equals(this.items, pagedListUserDetailsApplicationUser.items) &&
        Objects.equals(this.maxResults, pagedListUserDetailsApplicationUser.maxResults) &&
        Objects.equals(this.size, pagedListUserDetailsApplicationUser.size) &&
        Objects.equals(this.startIndex, pagedListUserDetailsApplicationUser.startIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endIndex, items, maxResults, size, startIndex);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagedListUserDetailsApplicationUser {\n");
    
    sb.append("    endIndex: ").append(toIndentedString(endIndex)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    startIndex: ").append(toIndentedString(startIndex)).append("\n");
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

