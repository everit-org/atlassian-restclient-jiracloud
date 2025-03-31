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

/**
 * The default value for a project custom field.
 */
@ApiModel(description = "The default value for a project custom field.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class CustomFieldContextDefaultValueProject {
  @JsonProperty("contextId")
  private String contextId;

  @JsonProperty("projectId")
  private String projectId;

  @JsonProperty("type")
  private String type;

  public CustomFieldContextDefaultValueProject contextId(String contextId) {
    this.contextId = contextId;
    return this;
  }

   /**
   * The ID of the context.
   * @return contextId
  **/
  @ApiModelProperty(required = true, value = "The ID of the context.")
  public String getContextId() {
    return contextId;
  }

  public void setContextId(String contextId) {
    this.contextId = contextId;
  }

  public CustomFieldContextDefaultValueProject projectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

   /**
   * The ID of the default project.
   * @return projectId
  **/
  @ApiModelProperty(required = true, value = "The ID of the default project.")
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public CustomFieldContextDefaultValueProject type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
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
    CustomFieldContextDefaultValueProject customFieldContextDefaultValueProject = (CustomFieldContextDefaultValueProject) o;
    return Objects.equals(this.contextId, customFieldContextDefaultValueProject.contextId) &&
        Objects.equals(this.projectId, customFieldContextDefaultValueProject.projectId) &&
        Objects.equals(this.type, customFieldContextDefaultValueProject.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contextId, projectId, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldContextDefaultValueProject {\n");
    
    sb.append("    contextId: ").append(toIndentedString(contextId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
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

