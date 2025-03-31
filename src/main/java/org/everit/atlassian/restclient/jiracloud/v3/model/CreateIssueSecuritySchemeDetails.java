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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v3.model.SecuritySchemeLevelBean;

/**
 * Issue security scheme and it&#39;s details
 */
@ApiModel(description = "Issue security scheme and it's details")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class CreateIssueSecuritySchemeDetails {
  @JsonProperty("description")
  private String description;

  @JsonProperty("levels")
  private List<SecuritySchemeLevelBean> levels = new ArrayList<>();

  @JsonProperty("name")
  private String name;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public CreateIssueSecuritySchemeDetails description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the issue security scheme.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the issue security scheme.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreateIssueSecuritySchemeDetails levels(List<SecuritySchemeLevelBean> levels) {
    this.levels = levels;
    return this;
  }

  public CreateIssueSecuritySchemeDetails addLevelsItem(SecuritySchemeLevelBean levelsItem) {
    if (this.levels == null) {
      this.levels = new ArrayList<>();
    }
    this.levels.add(levelsItem);
    return this;
  }

   /**
   * The list of scheme levels which should be added to the security scheme.
   * @return levels
  **/
  @ApiModelProperty(value = "The list of scheme levels which should be added to the security scheme.")
  public List<SecuritySchemeLevelBean> getLevels() {
    return levels;
  }

  public void setLevels(List<SecuritySchemeLevelBean> levels) {
    this.levels = levels;
  }

  public CreateIssueSecuritySchemeDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the issue security scheme. Must be unique (case-insensitive).
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the issue security scheme. Must be unique (case-insensitive).")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
    CreateIssueSecuritySchemeDetails createIssueSecuritySchemeDetails = (CreateIssueSecuritySchemeDetails) o;
    return Objects.equals(this.description, createIssueSecuritySchemeDetails.description) &&
        Objects.equals(this.levels, createIssueSecuritySchemeDetails.levels) &&
        Objects.equals(this.name, createIssueSecuritySchemeDetails.name) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, levels, name, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateIssueSecuritySchemeDetails {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    levels: ").append(toIndentedString(levels)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

