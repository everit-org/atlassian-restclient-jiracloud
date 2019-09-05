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
import java.util.UUID;
import org.everit.atlassian.restclient.jiracloud.v3.model.Scope;

/**
 * Details about an issue type.
 */
@ApiModel(description = "Details about an issue type.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:37.034+02:00[Europe/Prague]")
public class IssueTypeBean {
  @JsonProperty("self")
  private String self;

  @JsonProperty("id")
  private String id;

  @JsonProperty("description")
  private String description;

  @JsonProperty("iconUrl")
  private String iconUrl;

  @JsonProperty("name")
  private String name;

  @JsonProperty("subtask")
  private Boolean subtask;

  @JsonProperty("avatarId")
  private Long avatarId;

  @JsonProperty("entityId")
  private UUID entityId;

  @JsonProperty("scope")
  private Scope scope;

   /**
   * The URL of these issue type details.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of these issue type details.")
  public String getSelf() {
    return self;
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
   * The description of the issue type.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the issue type.")
  public String getDescription() {
    return description;
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
   * The name of the issue type.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the issue type.")
  public String getName() {
    return name;
  }

   /**
   * Indicates whether this issue type is used to create subtasks.
   * @return subtask
  **/
  @ApiModelProperty(value = "Indicates whether this issue type is used to create subtasks.")
  public Boolean getSubtask() {
    return subtask;
  }

   /**
   * The ID of the issue type&#39;s avatar.
   * @return avatarId
  **/
  @ApiModelProperty(value = "The ID of the issue type's avatar.")
  public Long getAvatarId() {
    return avatarId;
  }

   /**
   * project unique ID for next-gen entities
   * @return entityId
  **/
  @ApiModelProperty(value = "project unique ID for next-gen entities")
  public UUID getEntityId() {
    return entityId;
  }

   /**
   * Details of the next-gen projects the issue type is available in.
   * @return scope
  **/
  @ApiModelProperty(value = "Details of the next-gen projects the issue type is available in.")
  public Scope getScope() {
    return scope;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueTypeBean issueTypeBean = (IssueTypeBean) o;
    return Objects.equals(this.self, issueTypeBean.self) &&
        Objects.equals(this.id, issueTypeBean.id) &&
        Objects.equals(this.description, issueTypeBean.description) &&
        Objects.equals(this.iconUrl, issueTypeBean.iconUrl) &&
        Objects.equals(this.name, issueTypeBean.name) &&
        Objects.equals(this.subtask, issueTypeBean.subtask) &&
        Objects.equals(this.avatarId, issueTypeBean.avatarId) &&
        Objects.equals(this.entityId, issueTypeBean.entityId) &&
        Objects.equals(this.scope, issueTypeBean.scope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, id, description, iconUrl, name, subtask, avatarId, entityId, scope);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueTypeBean {\n");
    
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    iconUrl: ").append(toIndentedString(iconUrl)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    subtask: ").append(toIndentedString(subtask)).append("\n");
    sb.append("    avatarId: ").append(toIndentedString(avatarId)).append("\n");
    sb.append("    entityId: ").append(toIndentedString(entityId)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
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

