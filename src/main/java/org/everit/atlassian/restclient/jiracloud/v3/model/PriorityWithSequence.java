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

/**
 * An issue priority with sequence information.
 */
@ApiModel(description = "An issue priority with sequence information.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class PriorityWithSequence {
  @JsonProperty("description")
  private String description;

  @JsonProperty("iconUrl")
  private String iconUrl;

  @JsonProperty("id")
  private String id;

  @JsonProperty("isDefault")
  private Boolean isDefault;

  @JsonProperty("name")
  private String name;

  @JsonProperty("self")
  private String self;

  @JsonProperty("sequence")
  private String sequence;

  @JsonProperty("statusColor")
  private String statusColor;

  public PriorityWithSequence description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the issue priority.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the issue priority.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PriorityWithSequence iconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
    return this;
  }

   /**
   * The URL of the icon for the issue priority.
   * @return iconUrl
  **/
  @ApiModelProperty(value = "The URL of the icon for the issue priority.")
  public String getIconUrl() {
    return iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  public PriorityWithSequence id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the issue priority.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the issue priority.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PriorityWithSequence isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

   /**
   * Whether this priority is the default.
   * @return isDefault
  **/
  @ApiModelProperty(value = "Whether this priority is the default.")
  public Boolean getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public PriorityWithSequence name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the issue priority.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the issue priority.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PriorityWithSequence self(String self) {
    this.self = self;
    return this;
  }

   /**
   * The URL of the issue priority.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the issue priority.")
  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }

  public PriorityWithSequence sequence(String sequence) {
    this.sequence = sequence;
    return this;
  }

   /**
   * The sequence of the issue priority.
   * @return sequence
  **/
  @ApiModelProperty(value = "The sequence of the issue priority.")
  public String getSequence() {
    return sequence;
  }

  public void setSequence(String sequence) {
    this.sequence = sequence;
  }

  public PriorityWithSequence statusColor(String statusColor) {
    this.statusColor = statusColor;
    return this;
  }

   /**
   * The color used to indicate the issue priority.
   * @return statusColor
  **/
  @ApiModelProperty(value = "The color used to indicate the issue priority.")
  public String getStatusColor() {
    return statusColor;
  }

  public void setStatusColor(String statusColor) {
    this.statusColor = statusColor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriorityWithSequence priorityWithSequence = (PriorityWithSequence) o;
    return Objects.equals(this.description, priorityWithSequence.description) &&
        Objects.equals(this.iconUrl, priorityWithSequence.iconUrl) &&
        Objects.equals(this.id, priorityWithSequence.id) &&
        Objects.equals(this.isDefault, priorityWithSequence.isDefault) &&
        Objects.equals(this.name, priorityWithSequence.name) &&
        Objects.equals(this.self, priorityWithSequence.self) &&
        Objects.equals(this.sequence, priorityWithSequence.sequence) &&
        Objects.equals(this.statusColor, priorityWithSequence.statusColor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, iconUrl, id, isDefault, name, self, sequence, statusColor);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriorityWithSequence {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    iconUrl: ").append(toIndentedString(iconUrl)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
    sb.append("    statusColor: ").append(toIndentedString(statusColor)).append("\n");
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

