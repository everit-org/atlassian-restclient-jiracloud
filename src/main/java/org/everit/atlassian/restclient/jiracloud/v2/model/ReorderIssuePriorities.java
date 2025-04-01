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

/**
 * Change the order of issue priorities.
 */
@ApiModel(description = "Change the order of issue priorities.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class ReorderIssuePriorities {
  @JsonProperty("after")
  private String after;

  @JsonProperty("ids")
  private List<String> ids = new ArrayList<>();

  @JsonProperty("position")
  private String position;

  public ReorderIssuePriorities after(String after) {
    this.after = after;
    return this;
  }

   /**
   * The ID of the priority. Required if &#x60;position&#x60; isn&#39;t provided.
   * @return after
  **/
  @ApiModelProperty(value = "The ID of the priority. Required if `position` isn't provided.")
  public String getAfter() {
    return after;
  }

  public void setAfter(String after) {
    this.after = after;
  }

  public ReorderIssuePriorities ids(List<String> ids) {
    this.ids = ids;
    return this;
  }

  public ReorderIssuePriorities addIdsItem(String idsItem) {
    this.ids.add(idsItem);
    return this;
  }

   /**
   * The list of issue IDs to be reordered. Cannot contain duplicates nor after ID.
   * @return ids
  **/
  @ApiModelProperty(required = true, value = "The list of issue IDs to be reordered. Cannot contain duplicates nor after ID.")
  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public ReorderIssuePriorities position(String position) {
    this.position = position;
    return this;
  }

   /**
   * The position for issue priorities to be moved to. Required if &#x60;after&#x60; isn&#39;t provided.
   * @return position
  **/
  @ApiModelProperty(value = "The position for issue priorities to be moved to. Required if `after` isn't provided.")
  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReorderIssuePriorities reorderIssuePriorities = (ReorderIssuePriorities) o;
    return Objects.equals(this.after, reorderIssuePriorities.after) &&
        Objects.equals(this.ids, reorderIssuePriorities.ids) &&
        Objects.equals(this.position, reorderIssuePriorities.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(after, ids, position);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReorderIssuePriorities {\n");
    
    sb.append("    after: ").append(toIndentedString(after)).append("\n");
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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

