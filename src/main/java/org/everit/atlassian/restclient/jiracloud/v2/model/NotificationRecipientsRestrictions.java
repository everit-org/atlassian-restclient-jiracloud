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
import org.everit.atlassian.restclient.jiracloud.v2.model.GroupName;
import org.everit.atlassian.restclient.jiracloud.v2.model.RestrictedPermission;

/**
 * Details of the group membership or permissions needed to receive the notification.
 */
@ApiModel(description = "Details of the group membership or permissions needed to receive the notification.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class NotificationRecipientsRestrictions {
  @JsonProperty("groupIds")
  private List<String> groupIds = new ArrayList<>();

  @JsonProperty("groups")
  private List<GroupName> groups = new ArrayList<>();

  @JsonProperty("permissions")
  private List<RestrictedPermission> permissions = new ArrayList<>();

  public NotificationRecipientsRestrictions groupIds(List<String> groupIds) {
    this.groupIds = groupIds;
    return this;
  }

  public NotificationRecipientsRestrictions addGroupIdsItem(String groupIdsItem) {
    if (this.groupIds == null) {
      this.groupIds = new ArrayList<>();
    }
    this.groupIds.add(groupIdsItem);
    return this;
  }

   /**
   * List of groupId memberships required to receive the notification.
   * @return groupIds
  **/
  @ApiModelProperty(value = "List of groupId memberships required to receive the notification.")
  public List<String> getGroupIds() {
    return groupIds;
  }

  public void setGroupIds(List<String> groupIds) {
    this.groupIds = groupIds;
  }

  public NotificationRecipientsRestrictions groups(List<GroupName> groups) {
    this.groups = groups;
    return this;
  }

  public NotificationRecipientsRestrictions addGroupsItem(GroupName groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * List of group memberships required to receive the notification.
   * @return groups
  **/
  @ApiModelProperty(value = "List of group memberships required to receive the notification.")
  public List<GroupName> getGroups() {
    return groups;
  }

  public void setGroups(List<GroupName> groups) {
    this.groups = groups;
  }

  public NotificationRecipientsRestrictions permissions(List<RestrictedPermission> permissions) {
    this.permissions = permissions;
    return this;
  }

  public NotificationRecipientsRestrictions addPermissionsItem(RestrictedPermission permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

   /**
   * List of permissions required to receive the notification.
   * @return permissions
  **/
  @ApiModelProperty(value = "List of permissions required to receive the notification.")
  public List<RestrictedPermission> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<RestrictedPermission> permissions) {
    this.permissions = permissions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationRecipientsRestrictions notificationRecipientsRestrictions = (NotificationRecipientsRestrictions) o;
    return Objects.equals(this.groupIds, notificationRecipientsRestrictions.groupIds) &&
        Objects.equals(this.groups, notificationRecipientsRestrictions.groups) &&
        Objects.equals(this.permissions, notificationRecipientsRestrictions.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupIds, groups, permissions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationRecipientsRestrictions {\n");
    
    sb.append("    groupIds: ").append(toIndentedString(groupIds)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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

