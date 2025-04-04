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
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanIssueTypeScreenScheme;
import org.everit.atlassian.restclient.jiracloud.v2.model.ScreenTypes;

/**
 * A screen scheme.
 */
@ApiModel(description = "A screen scheme.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class ScreenScheme {
  @JsonProperty("description")
  private String description;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("issueTypeScreenSchemes")
  private PageBeanIssueTypeScreenScheme issueTypeScreenSchemes;

  @JsonProperty("name")
  private String name;

  @JsonProperty("screens")
  private ScreenTypes screens;

  public ScreenScheme description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the screen scheme.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the screen scheme.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ScreenScheme id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the screen scheme.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the screen scheme.")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ScreenScheme issueTypeScreenSchemes(PageBeanIssueTypeScreenScheme issueTypeScreenSchemes) {
    this.issueTypeScreenSchemes = issueTypeScreenSchemes;
    return this;
  }

   /**
   * Details of the issue type screen schemes associated with the screen scheme.
   * @return issueTypeScreenSchemes
  **/
  @ApiModelProperty(value = "Details of the issue type screen schemes associated with the screen scheme.")
  public PageBeanIssueTypeScreenScheme getIssueTypeScreenSchemes() {
    return issueTypeScreenSchemes;
  }

  public void setIssueTypeScreenSchemes(PageBeanIssueTypeScreenScheme issueTypeScreenSchemes) {
    this.issueTypeScreenSchemes = issueTypeScreenSchemes;
  }

  public ScreenScheme name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the screen scheme.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the screen scheme.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ScreenScheme screens(ScreenTypes screens) {
    this.screens = screens;
    return this;
  }

   /**
   * The IDs of the screens for the screen types of the screen scheme.
   * @return screens
  **/
  @ApiModelProperty(value = "The IDs of the screens for the screen types of the screen scheme.")
  public ScreenTypes getScreens() {
    return screens;
  }

  public void setScreens(ScreenTypes screens) {
    this.screens = screens;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScreenScheme screenScheme = (ScreenScheme) o;
    return Objects.equals(this.description, screenScheme.description) &&
        Objects.equals(this.id, screenScheme.id) &&
        Objects.equals(this.issueTypeScreenSchemes, screenScheme.issueTypeScreenSchemes) &&
        Objects.equals(this.name, screenScheme.name) &&
        Objects.equals(this.screens, screenScheme.screens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, id, issueTypeScreenSchemes, name, screens);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScreenScheme {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    issueTypeScreenSchemes: ").append(toIndentedString(issueTypeScreenSchemes)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    screens: ").append(toIndentedString(screens)).append("\n");
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

