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

/**
 * Details of a project feature.
 */
@ApiModel(description = "Details of a project feature.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class ProjectFeature {
  @JsonProperty("feature")
  private String feature;

  @JsonProperty("imageUri")
  private String imageUri;

  @JsonProperty("localisedDescription")
  private String localisedDescription;

  @JsonProperty("localisedName")
  private String localisedName;

  @JsonProperty("prerequisites")
  private List<String> prerequisites = new ArrayList<>();

  @JsonProperty("projectId")
  private Long projectId;

  /**
   * The state of the feature. When updating the state of a feature, only ENABLED and DISABLED are supported. Responses can contain all values
   */
  public enum StateEnum {
    ENABLED("ENABLED"),
    
    DISABLED("DISABLED"),
    
    COMING_SOON("COMING_SOON");

    private String value;

    StateEnum(String value) {
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
    public static StateEnum fromValue(String value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("state")
  private StateEnum state;

  @JsonProperty("toggleLocked")
  private Boolean toggleLocked;

  public ProjectFeature feature(String feature) {
    this.feature = feature;
    return this;
  }

   /**
   * The key of the feature.
   * @return feature
  **/
  @ApiModelProperty(value = "The key of the feature.")
  public String getFeature() {
    return feature;
  }

  public void setFeature(String feature) {
    this.feature = feature;
  }

  public ProjectFeature imageUri(String imageUri) {
    this.imageUri = imageUri;
    return this;
  }

   /**
   * URI for the image representing the feature.
   * @return imageUri
  **/
  @ApiModelProperty(value = "URI for the image representing the feature.")
  public String getImageUri() {
    return imageUri;
  }

  public void setImageUri(String imageUri) {
    this.imageUri = imageUri;
  }

  public ProjectFeature localisedDescription(String localisedDescription) {
    this.localisedDescription = localisedDescription;
    return this;
  }

   /**
   * Localized display description for the feature.
   * @return localisedDescription
  **/
  @ApiModelProperty(value = "Localized display description for the feature.")
  public String getLocalisedDescription() {
    return localisedDescription;
  }

  public void setLocalisedDescription(String localisedDescription) {
    this.localisedDescription = localisedDescription;
  }

  public ProjectFeature localisedName(String localisedName) {
    this.localisedName = localisedName;
    return this;
  }

   /**
   * Localized display name for the feature.
   * @return localisedName
  **/
  @ApiModelProperty(value = "Localized display name for the feature.")
  public String getLocalisedName() {
    return localisedName;
  }

  public void setLocalisedName(String localisedName) {
    this.localisedName = localisedName;
  }

  public ProjectFeature prerequisites(List<String> prerequisites) {
    this.prerequisites = prerequisites;
    return this;
  }

  public ProjectFeature addPrerequisitesItem(String prerequisitesItem) {
    if (this.prerequisites == null) {
      this.prerequisites = new ArrayList<>();
    }
    this.prerequisites.add(prerequisitesItem);
    return this;
  }

   /**
   * List of keys of the features required to enable the feature.
   * @return prerequisites
  **/
  @ApiModelProperty(value = "List of keys of the features required to enable the feature.")
  public List<String> getPrerequisites() {
    return prerequisites;
  }

  public void setPrerequisites(List<String> prerequisites) {
    this.prerequisites = prerequisites;
  }

  public ProjectFeature projectId(Long projectId) {
    this.projectId = projectId;
    return this;
  }

   /**
   * The ID of the project.
   * @return projectId
  **/
  @ApiModelProperty(value = "The ID of the project.")
  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  public ProjectFeature state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * The state of the feature. When updating the state of a feature, only ENABLED and DISABLED are supported. Responses can contain all values
   * @return state
  **/
  @ApiModelProperty(value = "The state of the feature. When updating the state of a feature, only ENABLED and DISABLED are supported. Responses can contain all values")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public ProjectFeature toggleLocked(Boolean toggleLocked) {
    this.toggleLocked = toggleLocked;
    return this;
  }

   /**
   * Whether the state of the feature can be updated.
   * @return toggleLocked
  **/
  @ApiModelProperty(value = "Whether the state of the feature can be updated.")
  public Boolean getToggleLocked() {
    return toggleLocked;
  }

  public void setToggleLocked(Boolean toggleLocked) {
    this.toggleLocked = toggleLocked;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectFeature projectFeature = (ProjectFeature) o;
    return Objects.equals(this.feature, projectFeature.feature) &&
        Objects.equals(this.imageUri, projectFeature.imageUri) &&
        Objects.equals(this.localisedDescription, projectFeature.localisedDescription) &&
        Objects.equals(this.localisedName, projectFeature.localisedName) &&
        Objects.equals(this.prerequisites, projectFeature.prerequisites) &&
        Objects.equals(this.projectId, projectFeature.projectId) &&
        Objects.equals(this.state, projectFeature.state) &&
        Objects.equals(this.toggleLocked, projectFeature.toggleLocked);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feature, imageUri, localisedDescription, localisedName, prerequisites, projectId, state, toggleLocked);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectFeature {\n");
    
    sb.append("    feature: ").append(toIndentedString(feature)).append("\n");
    sb.append("    imageUri: ").append(toIndentedString(imageUri)).append("\n");
    sb.append("    localisedDescription: ").append(toIndentedString(localisedDescription)).append("\n");
    sb.append("    localisedName: ").append(toIndentedString(localisedName)).append("\n");
    sb.append("    prerequisites: ").append(toIndentedString(prerequisites)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    toggleLocked: ").append(toIndentedString(toggleLocked)).append("\n");
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

