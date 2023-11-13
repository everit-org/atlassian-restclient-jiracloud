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


package org.everit.atlassian.restclient.jiracloud.v2.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;
import org.everit.atlassian.restclient.jiracloud.v2.model.Scope;

/**
 * Details about a project role.
 */
@ApiModel(description = "Details about a project role.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class ProjectRoleDetails {
  @JsonProperty("admin")
  private Boolean admin;

  @JsonProperty("default")
  private Boolean _default;

  @JsonProperty("description")
  private String description;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("roleConfigurable")
  private Boolean roleConfigurable;

  @JsonProperty("scope")
  private Scope scope;

  @JsonProperty("self")
  private URI self;

  @JsonProperty("translatedName")
  private String translatedName;

   /**
   * Whether this role is the admin role for the project.
   * @return admin
  **/
  @ApiModelProperty(value = "Whether this role is the admin role for the project.")
  public Boolean getAdmin() {
    return admin;
  }

   /**
   * Whether this role is the default role for the project.
   * @return _default
  **/
  @ApiModelProperty(value = "Whether this role is the default role for the project.")
  public Boolean getDefault() {
    return _default;
  }

   /**
   * The description of the project role.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the project role.")
  public String getDescription() {
    return description;
  }

   /**
   * The ID of the project role.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the project role.")
  public Long getId() {
    return id;
  }

  public ProjectRoleDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the project role.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the project role.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

   /**
   * Whether the roles are configurable for this project.
   * @return roleConfigurable
  **/
  @ApiModelProperty(value = "Whether the roles are configurable for this project.")
  public Boolean getRoleConfigurable() {
    return roleConfigurable;
  }

   /**
   * The scope of the role. Indicated for roles associated with [next-gen projects](https://confluence.atlassian.com/x/loMyO).
   * @return scope
  **/
  @ApiModelProperty(value = "The scope of the role. Indicated for roles associated with [next-gen projects](https://confluence.atlassian.com/x/loMyO).")
  public Scope getScope() {
    return scope;
  }

   /**
   * The URL the project role details.
   * @return self
  **/
  @ApiModelProperty(value = "The URL the project role details.")
  public URI getSelf() {
    return self;
  }

  public ProjectRoleDetails translatedName(String translatedName) {
    this.translatedName = translatedName;
    return this;
  }

   /**
   * The translated name of the project role.
   * @return translatedName
  **/
  @ApiModelProperty(value = "The translated name of the project role.")
  public String getTranslatedName() {
    return translatedName;
  }

  public void setTranslatedName(String translatedName) {
    this.translatedName = translatedName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectRoleDetails projectRoleDetails = (ProjectRoleDetails) o;
    return Objects.equals(this.admin, projectRoleDetails.admin) &&
        Objects.equals(this._default, projectRoleDetails._default) &&
        Objects.equals(this.description, projectRoleDetails.description) &&
        Objects.equals(this.id, projectRoleDetails.id) &&
        Objects.equals(this.name, projectRoleDetails.name) &&
        Objects.equals(this.roleConfigurable, projectRoleDetails.roleConfigurable) &&
        Objects.equals(this.scope, projectRoleDetails.scope) &&
        Objects.equals(this.self, projectRoleDetails.self) &&
        Objects.equals(this.translatedName, projectRoleDetails.translatedName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(admin, _default, description, id, name, roleConfigurable, scope, self, translatedName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectRoleDetails {\n");
    
    sb.append("    admin: ").append(toIndentedString(admin)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    roleConfigurable: ").append(toIndentedString(roleConfigurable)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    translatedName: ").append(toIndentedString(translatedName)).append("\n");
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

