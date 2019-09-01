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
import org.everit.atlassian.restclient.jiracloud.v3.model.GroupName;
import org.everit.atlassian.restclient.jiracloud.v3.model.RestrictedPermission;

/**
 * Details of the group membership or permissions needed to receive the notification.
 */
@ApiModel(description = "Details of the group membership or permissions needed to receive the notification.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:57:05.408+02:00[Europe/Prague]")
public class NotificationRecipientsRestrictions {
  @JsonProperty("groups")
  private List<GroupName> groups = new ArrayList<>();

  @JsonProperty("permissions")
  private List<RestrictedPermission> permissions = new ArrayList<>();

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
    return Objects.equals(this.groups, notificationRecipientsRestrictions.groups) &&
        Objects.equals(this.permissions, notificationRecipientsRestrictions.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groups, permissions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationRecipientsRestrictions {\n");
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

