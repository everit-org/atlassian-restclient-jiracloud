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
import org.everit.atlassian.restclient.jiracloud.v2.model.FieldLastUsed;
import org.everit.atlassian.restclient.jiracloud.v2.model.JsonTypeBean;

/**
 * Details of a field.
 */
@ApiModel(description = "Details of a field.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class Field {
  @JsonProperty("contextsCount")
  private Long contextsCount;

  @JsonProperty("description")
  private String description;

  @JsonProperty("id")
  private String id;

  @JsonProperty("isLocked")
  private Boolean isLocked;

  @JsonProperty("isUnscreenable")
  private Boolean isUnscreenable;

  @JsonProperty("key")
  private String key;

  @JsonProperty("lastUsed")
  private FieldLastUsed lastUsed;

  @JsonProperty("name")
  private String name;

  @JsonProperty("projectsCount")
  private Long projectsCount;

  @JsonProperty("schema")
  private JsonTypeBean schema;

  @JsonProperty("screensCount")
  private Long screensCount;

  @JsonProperty("searcherKey")
  private String searcherKey;

  @JsonProperty("stableId")
  private String stableId;

  public Field contextsCount(Long contextsCount) {
    this.contextsCount = contextsCount;
    return this;
  }

   /**
   * Number of contexts where the field is used.
   * @return contextsCount
  **/
  @ApiModelProperty(value = "Number of contexts where the field is used.")
  public Long getContextsCount() {
    return contextsCount;
  }

  public void setContextsCount(Long contextsCount) {
    this.contextsCount = contextsCount;
  }

  public Field description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the field.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the field.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Field id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the field.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the field.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Field isLocked(Boolean isLocked) {
    this.isLocked = isLocked;
    return this;
  }

   /**
   * Whether the field is locked.
   * @return isLocked
  **/
  @ApiModelProperty(value = "Whether the field is locked.")
  public Boolean getIsLocked() {
    return isLocked;
  }

  public void setIsLocked(Boolean isLocked) {
    this.isLocked = isLocked;
  }

  public Field isUnscreenable(Boolean isUnscreenable) {
    this.isUnscreenable = isUnscreenable;
    return this;
  }

   /**
   * Whether the field is shown on screen or not.
   * @return isUnscreenable
  **/
  @ApiModelProperty(value = "Whether the field is shown on screen or not.")
  public Boolean getIsUnscreenable() {
    return isUnscreenable;
  }

  public void setIsUnscreenable(Boolean isUnscreenable) {
    this.isUnscreenable = isUnscreenable;
  }

  public Field key(String key) {
    this.key = key;
    return this;
  }

   /**
   * The key of the field.
   * @return key
  **/
  @ApiModelProperty(value = "The key of the field.")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Field lastUsed(FieldLastUsed lastUsed) {
    this.lastUsed = lastUsed;
    return this;
  }

   /**
   * Get lastUsed
   * @return lastUsed
  **/
  @ApiModelProperty(value = "")
  public FieldLastUsed getLastUsed() {
    return lastUsed;
  }

  public void setLastUsed(FieldLastUsed lastUsed) {
    this.lastUsed = lastUsed;
  }

  public Field name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the field.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the field.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Field projectsCount(Long projectsCount) {
    this.projectsCount = projectsCount;
    return this;
  }

   /**
   * Number of projects where the field is used.
   * @return projectsCount
  **/
  @ApiModelProperty(value = "Number of projects where the field is used.")
  public Long getProjectsCount() {
    return projectsCount;
  }

  public void setProjectsCount(Long projectsCount) {
    this.projectsCount = projectsCount;
  }

  public Field schema(JsonTypeBean schema) {
    this.schema = schema;
    return this;
  }

   /**
   * Get schema
   * @return schema
  **/
  @ApiModelProperty(required = true, value = "")
  public JsonTypeBean getSchema() {
    return schema;
  }

  public void setSchema(JsonTypeBean schema) {
    this.schema = schema;
  }

  public Field screensCount(Long screensCount) {
    this.screensCount = screensCount;
    return this;
  }

   /**
   * Number of screens where the field is used.
   * @return screensCount
  **/
  @ApiModelProperty(value = "Number of screens where the field is used.")
  public Long getScreensCount() {
    return screensCount;
  }

  public void setScreensCount(Long screensCount) {
    this.screensCount = screensCount;
  }

  public Field searcherKey(String searcherKey) {
    this.searcherKey = searcherKey;
    return this;
  }

   /**
   * The searcher key of the field. Returned for custom fields.
   * @return searcherKey
  **/
  @ApiModelProperty(value = "The searcher key of the field. Returned for custom fields.")
  public String getSearcherKey() {
    return searcherKey;
  }

  public void setSearcherKey(String searcherKey) {
    this.searcherKey = searcherKey;
  }

  public Field stableId(String stableId) {
    this.stableId = stableId;
    return this;
  }

   /**
   * The stable ID of the field.
   * @return stableId
  **/
  @ApiModelProperty(value = "The stable ID of the field.")
  public String getStableId() {
    return stableId;
  }

  public void setStableId(String stableId) {
    this.stableId = stableId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Field field = (Field) o;
    return Objects.equals(this.contextsCount, field.contextsCount) &&
        Objects.equals(this.description, field.description) &&
        Objects.equals(this.id, field.id) &&
        Objects.equals(this.isLocked, field.isLocked) &&
        Objects.equals(this.isUnscreenable, field.isUnscreenable) &&
        Objects.equals(this.key, field.key) &&
        Objects.equals(this.lastUsed, field.lastUsed) &&
        Objects.equals(this.name, field.name) &&
        Objects.equals(this.projectsCount, field.projectsCount) &&
        Objects.equals(this.schema, field.schema) &&
        Objects.equals(this.screensCount, field.screensCount) &&
        Objects.equals(this.searcherKey, field.searcherKey) &&
        Objects.equals(this.stableId, field.stableId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contextsCount, description, id, isLocked, isUnscreenable, key, lastUsed, name, projectsCount, schema, screensCount, searcherKey, stableId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Field {\n");
    
    sb.append("    contextsCount: ").append(toIndentedString(contextsCount)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isLocked: ").append(toIndentedString(isLocked)).append("\n");
    sb.append("    isUnscreenable: ").append(toIndentedString(isUnscreenable)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    lastUsed: ").append(toIndentedString(lastUsed)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    projectsCount: ").append(toIndentedString(projectsCount)).append("\n");
    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
    sb.append("    screensCount: ").append(toIndentedString(screensCount)).append("\n");
    sb.append("    searcherKey: ").append(toIndentedString(searcherKey)).append("\n");
    sb.append("    stableId: ").append(toIndentedString(stableId)).append("\n");
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

