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
 * Details of the name, description, and default issue type for an issue type scheme.
 */
@ApiModel(description = "Details of the name, description, and default issue type for an issue type scheme.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class IssueTypeSchemeUpdateDetails {
  @JsonProperty("defaultIssueTypeId")
  private String defaultIssueTypeId;

  @JsonProperty("description")
  private String description;

  @JsonProperty("name")
  private String name;

  public IssueTypeSchemeUpdateDetails defaultIssueTypeId(String defaultIssueTypeId) {
    this.defaultIssueTypeId = defaultIssueTypeId;
    return this;
  }

   /**
   * The ID of the default issue type of the issue type scheme.
   * @return defaultIssueTypeId
  **/
  @ApiModelProperty(value = "The ID of the default issue type of the issue type scheme.")
  public String getDefaultIssueTypeId() {
    return defaultIssueTypeId;
  }

  public void setDefaultIssueTypeId(String defaultIssueTypeId) {
    this.defaultIssueTypeId = defaultIssueTypeId;
  }

  public IssueTypeSchemeUpdateDetails description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the issue type scheme. The maximum length is 4000 characters.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the issue type scheme. The maximum length is 4000 characters.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public IssueTypeSchemeUpdateDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the issue type scheme. The name must be unique. The maximum length is 255 characters.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the issue type scheme. The name must be unique. The maximum length is 255 characters.")
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
    IssueTypeSchemeUpdateDetails issueTypeSchemeUpdateDetails = (IssueTypeSchemeUpdateDetails) o;
    return Objects.equals(this.defaultIssueTypeId, issueTypeSchemeUpdateDetails.defaultIssueTypeId) &&
        Objects.equals(this.description, issueTypeSchemeUpdateDetails.description) &&
        Objects.equals(this.name, issueTypeSchemeUpdateDetails.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultIssueTypeId, description, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueTypeSchemeUpdateDetails {\n");
    
    sb.append("    defaultIssueTypeId: ").append(toIndentedString(defaultIssueTypeId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

