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


package org.everit.atlassian.restclient.jiracloud.v3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Details of an avatar.
 */
@ApiModel(description = "Details of an avatar.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class Avatar {
  @JsonProperty("fileName")
  private String fileName;

  @JsonProperty("id")
  private String id;

  @JsonProperty("isDeletable")
  private Boolean isDeletable;

  @JsonProperty("isSelected")
  private Boolean isSelected;

  @JsonProperty("isSystemAvatar")
  private Boolean isSystemAvatar;

  @JsonProperty("owner")
  private String owner;

  @JsonProperty("urls")
  private Map<String, URI> urls = new HashMap<>();

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

   /**
   * The file name of the avatar icon. Returned for system avatars.
   * @return fileName
  **/
  @ApiModelProperty(value = "The file name of the avatar icon. Returned for system avatars.")
  public String getFileName() {
    return fileName;
  }

  public Avatar id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the avatar.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the avatar.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

   /**
   * Whether the avatar can be deleted.
   * @return isDeletable
  **/
  @ApiModelProperty(value = "Whether the avatar can be deleted.")
  public Boolean getIsDeletable() {
    return isDeletable;
  }

   /**
   * Whether the avatar is used in Jira. For example, shown as a project&#39;s avatar.
   * @return isSelected
  **/
  @ApiModelProperty(value = "Whether the avatar is used in Jira. For example, shown as a project's avatar.")
  public Boolean getIsSelected() {
    return isSelected;
  }

   /**
   * Whether the avatar is a system avatar.
   * @return isSystemAvatar
  **/
  @ApiModelProperty(value = "Whether the avatar is a system avatar.")
  public Boolean getIsSystemAvatar() {
    return isSystemAvatar;
  }

   /**
   * The owner of the avatar. For a system avatar the owner is null (and nothing is returned). For non-system avatars this is the appropriate identifier, such as the ID for a project or the account ID for a user.
   * @return owner
  **/
  @ApiModelProperty(value = "The owner of the avatar. For a system avatar the owner is null (and nothing is returned). For non-system avatars this is the appropriate identifier, such as the ID for a project or the account ID for a user.")
  public String getOwner() {
    return owner;
  }

   /**
   * The list of avatar icon URLs.
   * @return urls
  **/
  @ApiModelProperty(value = "The list of avatar icon URLs.")
  public Map<String, URI> getUrls() {
    return urls;
  }


  @com.fasterxml.jackson.annotation.JsonAnyGetter
  public Map<String, Object> any() {
   return this.additionalProperties_;
  }

  @com.fasterxml.jackson.annotation.JsonAnySetter
  public void set(String name, Object value) {
   this.additionalProperties_.put(name, value);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Avatar avatar = (Avatar) o;
    return Objects.equals(this.fileName, avatar.fileName) &&
        Objects.equals(this.id, avatar.id) &&
        Objects.equals(this.isDeletable, avatar.isDeletable) &&
        Objects.equals(this.isSelected, avatar.isSelected) &&
        Objects.equals(this.isSystemAvatar, avatar.isSystemAvatar) &&
        Objects.equals(this.owner, avatar.owner) &&
        Objects.equals(this.urls, avatar.urls) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileName, id, isDeletable, isSelected, isSystemAvatar, owner, urls, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Avatar {\n");
    
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isDeletable: ").append(toIndentedString(isDeletable)).append("\n");
    sb.append("    isSelected: ").append(toIndentedString(isSelected)).append("\n");
    sb.append("    isSystemAvatar: ").append(toIndentedString(isSystemAvatar)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties_)).append("\n");
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

