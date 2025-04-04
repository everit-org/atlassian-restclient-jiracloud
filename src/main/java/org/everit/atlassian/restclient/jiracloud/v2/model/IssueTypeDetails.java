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
import java.util.UUID;
import org.everit.atlassian.restclient.jiracloud.v2.model.Scope;

/**
 * Details about an issue type.
 */
@ApiModel(description = "Details about an issue type.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class IssueTypeDetails {
  @JsonProperty("avatarId")
  private Long avatarId;

  @JsonProperty("description")
  private String description;

  @JsonProperty("entityId")
  private UUID entityId;

  @JsonProperty("hierarchyLevel")
  private Integer hierarchyLevel;

  @JsonProperty("iconUrl")
  private String iconUrl;

  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("scope")
  private Scope scope;

  @JsonProperty("self")
  private String self;

  @JsonProperty("subtask")
  private Boolean subtask;

   /**
   * The ID of the issue type&#39;s avatar.
   * @return avatarId
  **/
  @ApiModelProperty(value = "The ID of the issue type's avatar.")
  public Long getAvatarId() {
    return avatarId;
  }

   /**
   * The description of the issue type.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the issue type.")
  public String getDescription() {
    return description;
  }

   /**
   * Unique ID for next-gen projects.
   * @return entityId
  **/
  @ApiModelProperty(value = "Unique ID for next-gen projects.")
  public UUID getEntityId() {
    return entityId;
  }

   /**
   * Hierarchy level of the issue type.
   * @return hierarchyLevel
  **/
  @ApiModelProperty(value = "Hierarchy level of the issue type.")
  public Integer getHierarchyLevel() {
    return hierarchyLevel;
  }

   /**
   * The URL of the issue type&#39;s avatar.
   * @return iconUrl
  **/
  @ApiModelProperty(value = "The URL of the issue type's avatar.")
  public String getIconUrl() {
    return iconUrl;
  }

   /**
   * The ID of the issue type.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the issue type.")
  public String getId() {
    return id;
  }

   /**
   * The name of the issue type.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the issue type.")
  public String getName() {
    return name;
  }

   /**
   * Details of the next-gen projects the issue type is available in.
   * @return scope
  **/
  @ApiModelProperty(value = "Details of the next-gen projects the issue type is available in.")
  public Scope getScope() {
    return scope;
  }

   /**
   * The URL of these issue type details.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of these issue type details.")
  public String getSelf() {
    return self;
  }

   /**
   * Whether this issue type is used to create subtasks.
   * @return subtask
  **/
  @ApiModelProperty(value = "Whether this issue type is used to create subtasks.")
  public Boolean getSubtask() {
    return subtask;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueTypeDetails issueTypeDetails = (IssueTypeDetails) o;
    return Objects.equals(this.avatarId, issueTypeDetails.avatarId) &&
        Objects.equals(this.description, issueTypeDetails.description) &&
        Objects.equals(this.entityId, issueTypeDetails.entityId) &&
        Objects.equals(this.hierarchyLevel, issueTypeDetails.hierarchyLevel) &&
        Objects.equals(this.iconUrl, issueTypeDetails.iconUrl) &&
        Objects.equals(this.id, issueTypeDetails.id) &&
        Objects.equals(this.name, issueTypeDetails.name) &&
        Objects.equals(this.scope, issueTypeDetails.scope) &&
        Objects.equals(this.self, issueTypeDetails.self) &&
        Objects.equals(this.subtask, issueTypeDetails.subtask);
  }

  @Override
  public int hashCode() {
    return Objects.hash(avatarId, description, entityId, hierarchyLevel, iconUrl, id, name, scope, self, subtask);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueTypeDetails {\n");
    
    sb.append("    avatarId: ").append(toIndentedString(avatarId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    entityId: ").append(toIndentedString(entityId)).append("\n");
    sb.append("    hierarchyLevel: ").append(toIndentedString(hierarchyLevel)).append("\n");
    sb.append("    iconUrl: ").append(toIndentedString(iconUrl)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    subtask: ").append(toIndentedString(subtask)).append("\n");
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

