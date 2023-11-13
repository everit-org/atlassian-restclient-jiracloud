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
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeScreenSchemeMapping;

/**
 * The details of an issue type screen scheme.
 */
@ApiModel(description = "The details of an issue type screen scheme.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class IssueTypeScreenSchemeDetails {
  @JsonProperty("description")
  private String description;

  @JsonProperty("issueTypeMappings")
  private List<IssueTypeScreenSchemeMapping> issueTypeMappings = new ArrayList<>();

  @JsonProperty("name")
  private String name;

  public IssueTypeScreenSchemeDetails description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the issue type screen scheme. The maximum length is 255 characters.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the issue type screen scheme. The maximum length is 255 characters.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public IssueTypeScreenSchemeDetails issueTypeMappings(List<IssueTypeScreenSchemeMapping> issueTypeMappings) {
    this.issueTypeMappings = issueTypeMappings;
    return this;
  }

  public IssueTypeScreenSchemeDetails addIssueTypeMappingsItem(IssueTypeScreenSchemeMapping issueTypeMappingsItem) {
    this.issueTypeMappings.add(issueTypeMappingsItem);
    return this;
  }

   /**
   * The IDs of the screen schemes for the issue type IDs and *default*. A *default* entry is required to create an issue type screen scheme, it defines the mapping for all issue types without a screen scheme.
   * @return issueTypeMappings
  **/
  @ApiModelProperty(required = true, value = "The IDs of the screen schemes for the issue type IDs and *default*. A *default* entry is required to create an issue type screen scheme, it defines the mapping for all issue types without a screen scheme.")
  public List<IssueTypeScreenSchemeMapping> getIssueTypeMappings() {
    return issueTypeMappings;
  }

  public void setIssueTypeMappings(List<IssueTypeScreenSchemeMapping> issueTypeMappings) {
    this.issueTypeMappings = issueTypeMappings;
  }

  public IssueTypeScreenSchemeDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the issue type screen scheme. The name must be unique. The maximum length is 255 characters.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the issue type screen scheme. The name must be unique. The maximum length is 255 characters.")
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
    IssueTypeScreenSchemeDetails issueTypeScreenSchemeDetails = (IssueTypeScreenSchemeDetails) o;
    return Objects.equals(this.description, issueTypeScreenSchemeDetails.description) &&
        Objects.equals(this.issueTypeMappings, issueTypeScreenSchemeDetails.issueTypeMappings) &&
        Objects.equals(this.name, issueTypeScreenSchemeDetails.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, issueTypeMappings, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueTypeScreenSchemeDetails {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    issueTypeMappings: ").append(toIndentedString(issueTypeMappings)).append("\n");
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

