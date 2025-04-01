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
 * Details of the group associated with the role.
 */
@ApiModel(description = "Details of the group associated with the role.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class ProjectRoleGroup {
  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("groupId")
  private String groupId;

  @JsonProperty("name")
  private String name;

  public ProjectRoleGroup displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * The display name of the group.
   * @return displayName
  **/
  @ApiModelProperty(value = "The display name of the group.")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public ProjectRoleGroup groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * The ID of the group.
   * @return groupId
  **/
  @ApiModelProperty(value = "The ID of the group.")
  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public ProjectRoleGroup name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the group. As a group&#39;s name can change, use of &#x60;groupId&#x60; is recommended to identify the group.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the group. As a group's name can change, use of `groupId` is recommended to identify the group.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectRoleGroup projectRoleGroup = (ProjectRoleGroup) o;
    return Objects.equals(this.displayName, projectRoleGroup.displayName) &&
        Objects.equals(this.groupId, projectRoleGroup.groupId) &&
        Objects.equals(this.name, projectRoleGroup.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, groupId, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectRoleGroup {\n");
    
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

