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
import org.everit.atlassian.restclient.jiracloud.v2.model.SecurityLevel;

/**
 * Details about a security scheme.
 */
@ApiModel(description = "Details about a security scheme.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class SecurityScheme {
  @JsonProperty("defaultSecurityLevelId")
  private Long defaultSecurityLevelId;

  @JsonProperty("description")
  private String description;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("levels")
  private List<SecurityLevel> levels = new ArrayList<>();

  @JsonProperty("name")
  private String name;

  @JsonProperty("self")
  private String self;

   /**
   * The ID of the default security level.
   * @return defaultSecurityLevelId
  **/
  @ApiModelProperty(value = "The ID of the default security level.")
  public Long getDefaultSecurityLevelId() {
    return defaultSecurityLevelId;
  }

   /**
   * The description of the issue security scheme.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the issue security scheme.")
  public String getDescription() {
    return description;
  }

   /**
   * The ID of the issue security scheme.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the issue security scheme.")
  public Long getId() {
    return id;
  }

  public SecurityScheme levels(List<SecurityLevel> levels) {
    this.levels = levels;
    return this;
  }

  public SecurityScheme addLevelsItem(SecurityLevel levelsItem) {
    if (this.levels == null) {
      this.levels = new ArrayList<>();
    }
    this.levels.add(levelsItem);
    return this;
  }

   /**
   * Get levels
   * @return levels
  **/
  @ApiModelProperty(value = "")
  public List<SecurityLevel> getLevels() {
    return levels;
  }

  public void setLevels(List<SecurityLevel> levels) {
    this.levels = levels;
  }

   /**
   * The name of the issue security scheme.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the issue security scheme.")
  public String getName() {
    return name;
  }

   /**
   * The URL of the issue security scheme.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the issue security scheme.")
  public String getSelf() {
    return self;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecurityScheme securityScheme = (SecurityScheme) o;
    return Objects.equals(this.defaultSecurityLevelId, securityScheme.defaultSecurityLevelId) &&
        Objects.equals(this.description, securityScheme.description) &&
        Objects.equals(this.id, securityScheme.id) &&
        Objects.equals(this.levels, securityScheme.levels) &&
        Objects.equals(this.name, securityScheme.name) &&
        Objects.equals(this.self, securityScheme.self);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultSecurityLevelId, description, id, levels, name, self);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecurityScheme {\n");
    
    sb.append("    defaultSecurityLevelId: ").append(toIndentedString(defaultSecurityLevelId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    levels: ").append(toIndentedString(levels)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
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

