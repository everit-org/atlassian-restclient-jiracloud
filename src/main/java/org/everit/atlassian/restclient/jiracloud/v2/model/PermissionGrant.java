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
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v2.model.PermissionHolder;

/**
 * Details about a permission granted to a user or group.
 */
@ApiModel(description = "Details about a permission granted to a user or group.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class PermissionGrant {
  @JsonProperty("holder")
  private PermissionHolder holder;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("permission")
  private String permission;

  @JsonProperty("self")
  private URI self;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public PermissionGrant holder(PermissionHolder holder) {
    this.holder = holder;
    return this;
  }

   /**
   * The user or group being granted the permission. It consists of a &#x60;type&#x60;, a type-dependent &#x60;parameter&#x60; and a type-dependent &#x60;value&#x60;. See [Holder object](../api-group-permission-schemes/#holder-object) in *Get all permission schemes* for more information.
   * @return holder
  **/
  @ApiModelProperty(value = "The user or group being granted the permission. It consists of a `type`, a type-dependent `parameter` and a type-dependent `value`. See [Holder object](../api-group-permission-schemes/#holder-object) in *Get all permission schemes* for more information.")
  public PermissionHolder getHolder() {
    return holder;
  }

  public void setHolder(PermissionHolder holder) {
    this.holder = holder;
  }

   /**
   * The ID of the permission granted details.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the permission granted details.")
  public Long getId() {
    return id;
  }

  public PermissionGrant permission(String permission) {
    this.permission = permission;
    return this;
  }

   /**
   * The permission to grant. This permission can be one of the built-in permissions or a custom permission added by an app. See [Built-in permissions](../api-group-permission-schemes/#built-in-permissions) in *Get all permission schemes* for more information about the built-in permissions. See the [project permission](https://developer.atlassian.com/cloud/jira/platform/modules/project-permission/) and [global permission](https://developer.atlassian.com/cloud/jira/platform/modules/global-permission/) module documentation for more information about custom permissions.
   * @return permission
  **/
  @ApiModelProperty(value = "The permission to grant. This permission can be one of the built-in permissions or a custom permission added by an app. See [Built-in permissions](../api-group-permission-schemes/#built-in-permissions) in *Get all permission schemes* for more information about the built-in permissions. See the [project permission](https://developer.atlassian.com/cloud/jira/platform/modules/project-permission/) and [global permission](https://developer.atlassian.com/cloud/jira/platform/modules/global-permission/) module documentation for more information about custom permissions.")
  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

   /**
   * The URL of the permission granted details.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the permission granted details.")
  public URI getSelf() {
    return self;
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
    PermissionGrant permissionGrant = (PermissionGrant) o;
    return Objects.equals(this.holder, permissionGrant.holder) &&
        Objects.equals(this.id, permissionGrant.id) &&
        Objects.equals(this.permission, permissionGrant.permission) &&
        Objects.equals(this.self, permissionGrant.self) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(holder, id, permission, self, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PermissionGrant {\n");
    
    sb.append("    holder: ").append(toIndentedString(holder)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
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

