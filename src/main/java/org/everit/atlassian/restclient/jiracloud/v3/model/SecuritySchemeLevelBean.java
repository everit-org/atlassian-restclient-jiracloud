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
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v3.model.SecuritySchemeLevelMemberBean;

/**
 * SecuritySchemeLevelBean
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class SecuritySchemeLevelBean {
  @JsonProperty("description")
  private String description;

  @JsonProperty("isDefault")
  private Boolean isDefault;

  @JsonProperty("members")
  private List<SecuritySchemeLevelMemberBean> members = new ArrayList<>();

  @JsonProperty("name")
  private String name;

  public SecuritySchemeLevelBean description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the issue security scheme level.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the issue security scheme level.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SecuritySchemeLevelBean isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

   /**
   * Specifies whether the level is the default level. False by default.
   * @return isDefault
  **/
  @ApiModelProperty(value = "Specifies whether the level is the default level. False by default.")
  public Boolean getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public SecuritySchemeLevelBean members(List<SecuritySchemeLevelMemberBean> members) {
    this.members = members;
    return this;
  }

  public SecuritySchemeLevelBean addMembersItem(SecuritySchemeLevelMemberBean membersItem) {
    if (this.members == null) {
      this.members = new ArrayList<>();
    }
    this.members.add(membersItem);
    return this;
  }

   /**
   * The list of level members which should be added to the issue security scheme level.
   * @return members
  **/
  @ApiModelProperty(value = "The list of level members which should be added to the issue security scheme level.")
  public List<SecuritySchemeLevelMemberBean> getMembers() {
    return members;
  }

  public void setMembers(List<SecuritySchemeLevelMemberBean> members) {
    this.members = members;
  }

  public SecuritySchemeLevelBean name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the issue security scheme level. Must be unique.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the issue security scheme level. Must be unique.")
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
    SecuritySchemeLevelBean securitySchemeLevelBean = (SecuritySchemeLevelBean) o;
    return Objects.equals(this.description, securitySchemeLevelBean.description) &&
        Objects.equals(this.isDefault, securitySchemeLevelBean.isDefault) &&
        Objects.equals(this.members, securitySchemeLevelBean.members) &&
        Objects.equals(this.name, securitySchemeLevelBean.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, isDefault, members, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecuritySchemeLevelBean {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
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

