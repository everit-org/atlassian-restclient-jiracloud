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
import org.everit.atlassian.restclient.jiracloud.v2.model.PriorityMapping;

/**
 * Details of a new priority scheme
 */
@ApiModel(description = "Details of a new priority scheme")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class CreatePrioritySchemeDetails {
  @JsonProperty("defaultPriorityId")
  private Long defaultPriorityId;

  @JsonProperty("description")
  private String description;

  @JsonProperty("mappings")
  private PriorityMapping mappings;

  @JsonProperty("name")
  private String name;

  @JsonProperty("priorityIds")
  private List<Long> priorityIds = new ArrayList<>();

  @JsonProperty("projectIds")
  private List<Long> projectIds = new ArrayList<>();

  public CreatePrioritySchemeDetails defaultPriorityId(Long defaultPriorityId) {
    this.defaultPriorityId = defaultPriorityId;
    return this;
  }

   /**
   * The ID of the default priority for the priority scheme.
   * @return defaultPriorityId
  **/
  @ApiModelProperty(required = true, value = "The ID of the default priority for the priority scheme.")
  public Long getDefaultPriorityId() {
    return defaultPriorityId;
  }

  public void setDefaultPriorityId(Long defaultPriorityId) {
    this.defaultPriorityId = defaultPriorityId;
  }

  public CreatePrioritySchemeDetails description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the priority scheme.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the priority scheme.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreatePrioritySchemeDetails mappings(PriorityMapping mappings) {
    this.mappings = mappings;
    return this;
  }

   /**
   * Instructions to migrate the priorities of issues.  &#x60;in&#x60; mappings are used to migrate the priorities of issues to priorities used within the priority scheme.  &#x60;out&#x60; mappings are used to migrate the priorities of issues to priorities not used within the priority scheme.   *  When **priorities** are **added** to the new priority scheme, no mapping needs to be provided as the new priorities are not used by any issues.  *  When **priorities** are **removed** from the new priority scheme, no mapping needs to be provided as the removed priorities are not used by any issues.  *  When **projects** are **added** to the priority scheme, the priorities of issues in those projects might need to be migrated to new priorities used by the priority scheme. This can occur when the current scheme does not use all the priorities in the project(s)&#39; priority scheme(s).           *  An &#x60;in&#x60; mapping must be provided for each of these priorities.  *  When **projects** are **removed** from the priority scheme, no mapping needs to be provided as the removed projects are not using the priorities of the new priority scheme.  For more information on &#x60;in&#x60; and &#x60;out&#x60; mappings, see the child properties documentation for the &#x60;PriorityMapping&#x60; object below.
   * @return mappings
  **/
  @ApiModelProperty(value = "Instructions to migrate the priorities of issues.  `in` mappings are used to migrate the priorities of issues to priorities used within the priority scheme.  `out` mappings are used to migrate the priorities of issues to priorities not used within the priority scheme.   *  When **priorities** are **added** to the new priority scheme, no mapping needs to be provided as the new priorities are not used by any issues.  *  When **priorities** are **removed** from the new priority scheme, no mapping needs to be provided as the removed priorities are not used by any issues.  *  When **projects** are **added** to the priority scheme, the priorities of issues in those projects might need to be migrated to new priorities used by the priority scheme. This can occur when the current scheme does not use all the priorities in the project(s)' priority scheme(s).           *  An `in` mapping must be provided for each of these priorities.  *  When **projects** are **removed** from the priority scheme, no mapping needs to be provided as the removed projects are not using the priorities of the new priority scheme.  For more information on `in` and `out` mappings, see the child properties documentation for the `PriorityMapping` object below.")
  public PriorityMapping getMappings() {
    return mappings;
  }

  public void setMappings(PriorityMapping mappings) {
    this.mappings = mappings;
  }

  public CreatePrioritySchemeDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the priority scheme. Must be unique.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the priority scheme. Must be unique.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreatePrioritySchemeDetails priorityIds(List<Long> priorityIds) {
    this.priorityIds = priorityIds;
    return this;
  }

  public CreatePrioritySchemeDetails addPriorityIdsItem(Long priorityIdsItem) {
    this.priorityIds.add(priorityIdsItem);
    return this;
  }

   /**
   * The IDs of priorities in the scheme.
   * @return priorityIds
  **/
  @ApiModelProperty(required = true, value = "The IDs of priorities in the scheme.")
  public List<Long> getPriorityIds() {
    return priorityIds;
  }

  public void setPriorityIds(List<Long> priorityIds) {
    this.priorityIds = priorityIds;
  }

  public CreatePrioritySchemeDetails projectIds(List<Long> projectIds) {
    this.projectIds = projectIds;
    return this;
  }

  public CreatePrioritySchemeDetails addProjectIdsItem(Long projectIdsItem) {
    if (this.projectIds == null) {
      this.projectIds = new ArrayList<>();
    }
    this.projectIds.add(projectIdsItem);
    return this;
  }

   /**
   * The IDs of projects that will use the priority scheme.
   * @return projectIds
  **/
  @ApiModelProperty(value = "The IDs of projects that will use the priority scheme.")
  public List<Long> getProjectIds() {
    return projectIds;
  }

  public void setProjectIds(List<Long> projectIds) {
    this.projectIds = projectIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatePrioritySchemeDetails createPrioritySchemeDetails = (CreatePrioritySchemeDetails) o;
    return Objects.equals(this.defaultPriorityId, createPrioritySchemeDetails.defaultPriorityId) &&
        Objects.equals(this.description, createPrioritySchemeDetails.description) &&
        Objects.equals(this.mappings, createPrioritySchemeDetails.mappings) &&
        Objects.equals(this.name, createPrioritySchemeDetails.name) &&
        Objects.equals(this.priorityIds, createPrioritySchemeDetails.priorityIds) &&
        Objects.equals(this.projectIds, createPrioritySchemeDetails.projectIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultPriorityId, description, mappings, name, priorityIds, projectIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePrioritySchemeDetails {\n");
    
    sb.append("    defaultPriorityId: ").append(toIndentedString(defaultPriorityId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    mappings: ").append(toIndentedString(mappings)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    priorityIds: ").append(toIndentedString(priorityIds)).append("\n");
    sb.append("    projectIds: ").append(toIndentedString(projectIds)).append("\n");
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

