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
 * SharePermissionInputBean
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class SharePermissionInputBean {
  @JsonProperty("accountId")
  private String accountId;

  @JsonProperty("groupId")
  private String groupId;

  @JsonProperty("groupname")
  private String groupname;

  @JsonProperty("projectId")
  private String projectId;

  @JsonProperty("projectRoleId")
  private String projectRoleId;

  @JsonProperty("rights")
  private Integer rights;

  /**
   * The type of the share permission.Specify the type as follows:   *  &#x60;user&#x60; Share with a user.  *  &#x60;group&#x60; Share with a group. Specify &#x60;groupname&#x60; as well.  *  &#x60;project&#x60; Share with a project. Specify &#x60;projectId&#x60; as well.  *  &#x60;projectRole&#x60; Share with a project role in a project. Specify &#x60;projectId&#x60; and &#x60;projectRoleId&#x60; as well.  *  &#x60;global&#x60; Share globally, including anonymous users. If set, this type overrides all existing share permissions and must be deleted before any non-global share permissions is set.  *  &#x60;authenticated&#x60; Share with all logged-in users. This shows as &#x60;loggedin&#x60; in the response. If set, this type overrides all existing share permissions and must be deleted before any non-global share permissions is set.
   */
  public enum TypeEnum {
    USER("user"),
    
    PROJECT("project"),
    
    GROUP("group"),
    
    PROJECTROLE("projectRole"),
    
    GLOBAL("global"),
    
    AUTHENTICATED("authenticated");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  public SharePermissionInputBean accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * The user account ID that the filter is shared with. For a request, specify the &#x60;accountId&#x60; property for the user.
   * @return accountId
  **/
  @ApiModelProperty(value = "The user account ID that the filter is shared with. For a request, specify the `accountId` property for the user.")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public SharePermissionInputBean groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * The ID of the group, which uniquely identifies the group across all Atlassian products.For example, *952d12c3-5b5b-4d04-bb32-44d383afc4b2*. Cannot be provided with &#x60;groupname&#x60;.
   * @return groupId
  **/
  @ApiModelProperty(value = "The ID of the group, which uniquely identifies the group across all Atlassian products.For example, *952d12c3-5b5b-4d04-bb32-44d383afc4b2*. Cannot be provided with `groupname`.")
  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public SharePermissionInputBean groupname(String groupname) {
    this.groupname = groupname;
    return this;
  }

   /**
   * The name of the group to share the filter with. Set &#x60;type&#x60; to &#x60;group&#x60;. Please note that the name of a group is mutable, to reliably identify a group use &#x60;groupId&#x60;.
   * @return groupname
  **/
  @ApiModelProperty(value = "The name of the group to share the filter with. Set `type` to `group`. Please note that the name of a group is mutable, to reliably identify a group use `groupId`.")
  public String getGroupname() {
    return groupname;
  }

  public void setGroupname(String groupname) {
    this.groupname = groupname;
  }

  public SharePermissionInputBean projectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

   /**
   * The ID of the project to share the filter with. Set &#x60;type&#x60; to &#x60;project&#x60;.
   * @return projectId
  **/
  @ApiModelProperty(value = "The ID of the project to share the filter with. Set `type` to `project`.")
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public SharePermissionInputBean projectRoleId(String projectRoleId) {
    this.projectRoleId = projectRoleId;
    return this;
  }

   /**
   * The ID of the project role to share the filter with. Set &#x60;type&#x60; to &#x60;projectRole&#x60; and the &#x60;projectId&#x60; for the project that the role is in.
   * @return projectRoleId
  **/
  @ApiModelProperty(value = "The ID of the project role to share the filter with. Set `type` to `projectRole` and the `projectId` for the project that the role is in.")
  public String getProjectRoleId() {
    return projectRoleId;
  }

  public void setProjectRoleId(String projectRoleId) {
    this.projectRoleId = projectRoleId;
  }

  public SharePermissionInputBean rights(Integer rights) {
    this.rights = rights;
    return this;
  }

   /**
   * The rights for the share permission.
   * @return rights
  **/
  @ApiModelProperty(value = "The rights for the share permission.")
  public Integer getRights() {
    return rights;
  }

  public void setRights(Integer rights) {
    this.rights = rights;
  }

  public SharePermissionInputBean type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The type of the share permission.Specify the type as follows:   *  &#x60;user&#x60; Share with a user.  *  &#x60;group&#x60; Share with a group. Specify &#x60;groupname&#x60; as well.  *  &#x60;project&#x60; Share with a project. Specify &#x60;projectId&#x60; as well.  *  &#x60;projectRole&#x60; Share with a project role in a project. Specify &#x60;projectId&#x60; and &#x60;projectRoleId&#x60; as well.  *  &#x60;global&#x60; Share globally, including anonymous users. If set, this type overrides all existing share permissions and must be deleted before any non-global share permissions is set.  *  &#x60;authenticated&#x60; Share with all logged-in users. This shows as &#x60;loggedin&#x60; in the response. If set, this type overrides all existing share permissions and must be deleted before any non-global share permissions is set.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The type of the share permission.Specify the type as follows:   *  `user` Share with a user.  *  `group` Share with a group. Specify `groupname` as well.  *  `project` Share with a project. Specify `projectId` as well.  *  `projectRole` Share with a project role in a project. Specify `projectId` and `projectRoleId` as well.  *  `global` Share globally, including anonymous users. If set, this type overrides all existing share permissions and must be deleted before any non-global share permissions is set.  *  `authenticated` Share with all logged-in users. This shows as `loggedin` in the response. If set, this type overrides all existing share permissions and must be deleted before any non-global share permissions is set.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SharePermissionInputBean sharePermissionInputBean = (SharePermissionInputBean) o;
    return Objects.equals(this.accountId, sharePermissionInputBean.accountId) &&
        Objects.equals(this.groupId, sharePermissionInputBean.groupId) &&
        Objects.equals(this.groupname, sharePermissionInputBean.groupname) &&
        Objects.equals(this.projectId, sharePermissionInputBean.projectId) &&
        Objects.equals(this.projectRoleId, sharePermissionInputBean.projectRoleId) &&
        Objects.equals(this.rights, sharePermissionInputBean.rights) &&
        Objects.equals(this.type, sharePermissionInputBean.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, groupId, groupname, projectId, projectRoleId, rights, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SharePermissionInputBean {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    groupname: ").append(toIndentedString(groupname)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    projectRoleId: ").append(toIndentedString(projectRoleId)).append("\n");
    sb.append("    rights: ").append(toIndentedString(rights)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

