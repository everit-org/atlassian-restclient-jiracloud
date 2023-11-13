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

/**
 * The details of a custom field context.
 */
@ApiModel(description = "The details of a custom field context.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class CustomFieldContext {
  @JsonProperty("description")
  private String description;

  @JsonProperty("id")
  private String id;

  @JsonProperty("isAnyIssueType")
  private Boolean isAnyIssueType;

  @JsonProperty("isGlobalContext")
  private Boolean isGlobalContext;

  @JsonProperty("name")
  private String name;

  public CustomFieldContext description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the context.
   * @return description
  **/
  @ApiModelProperty(required = true, value = "The description of the context.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CustomFieldContext id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the context.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the context.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CustomFieldContext isAnyIssueType(Boolean isAnyIssueType) {
    this.isAnyIssueType = isAnyIssueType;
    return this;
  }

   /**
   * Whether the context apply to all issue types.
   * @return isAnyIssueType
  **/
  @ApiModelProperty(required = true, value = "Whether the context apply to all issue types.")
  public Boolean getIsAnyIssueType() {
    return isAnyIssueType;
  }

  public void setIsAnyIssueType(Boolean isAnyIssueType) {
    this.isAnyIssueType = isAnyIssueType;
  }

  public CustomFieldContext isGlobalContext(Boolean isGlobalContext) {
    this.isGlobalContext = isGlobalContext;
    return this;
  }

   /**
   * Whether the context is global.
   * @return isGlobalContext
  **/
  @ApiModelProperty(required = true, value = "Whether the context is global.")
  public Boolean getIsGlobalContext() {
    return isGlobalContext;
  }

  public void setIsGlobalContext(Boolean isGlobalContext) {
    this.isGlobalContext = isGlobalContext;
  }

  public CustomFieldContext name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the context.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the context.")
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
    CustomFieldContext customFieldContext = (CustomFieldContext) o;
    return Objects.equals(this.description, customFieldContext.description) &&
        Objects.equals(this.id, customFieldContext.id) &&
        Objects.equals(this.isAnyIssueType, customFieldContext.isAnyIssueType) &&
        Objects.equals(this.isGlobalContext, customFieldContext.isGlobalContext) &&
        Objects.equals(this.name, customFieldContext.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, id, isAnyIssueType, isGlobalContext, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldContext {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isAnyIssueType: ").append(toIndentedString(isAnyIssueType)).append("\n");
    sb.append("    isGlobalContext: ").append(toIndentedString(isGlobalContext)).append("\n");
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

