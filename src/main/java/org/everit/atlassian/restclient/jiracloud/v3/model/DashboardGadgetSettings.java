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


package org.everit.atlassian.restclient.jiracloud.v3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.everit.atlassian.restclient.jiracloud.v3.model.DashboardGadgetPosition;

/**
 * Details of the settings for a dashboard gadget.
 */
@ApiModel(description = "Details of the settings for a dashboard gadget.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class DashboardGadgetSettings {
  @JsonProperty("color")
  private String color;

  @JsonProperty("ignoreUriAndModuleKeyValidation")
  private Boolean ignoreUriAndModuleKeyValidation;

  @JsonProperty("moduleKey")
  private String moduleKey;

  @JsonProperty("position")
  private DashboardGadgetPosition position;

  @JsonProperty("title")
  private String title;

  @JsonProperty("uri")
  private String uri;

  public DashboardGadgetSettings color(String color) {
    this.color = color;
    return this;
  }

   /**
   * The color of the gadget. Should be one of &#x60;blue&#x60;, &#x60;red&#x60;, &#x60;yellow&#x60;, &#x60;green&#x60;, &#x60;cyan&#x60;, &#x60;purple&#x60;, &#x60;gray&#x60;, or &#x60;white&#x60;.
   * @return color
  **/
  @ApiModelProperty(value = "The color of the gadget. Should be one of `blue`, `red`, `yellow`, `green`, `cyan`, `purple`, `gray`, or `white`.")
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public DashboardGadgetSettings ignoreUriAndModuleKeyValidation(Boolean ignoreUriAndModuleKeyValidation) {
    this.ignoreUriAndModuleKeyValidation = ignoreUriAndModuleKeyValidation;
    return this;
  }

   /**
   * Whether to ignore the validation of module key and URI. For example, when a gadget is created that is a part of an application that isn&#39;t installed.
   * @return ignoreUriAndModuleKeyValidation
  **/
  @ApiModelProperty(value = "Whether to ignore the validation of module key and URI. For example, when a gadget is created that is a part of an application that isn't installed.")
  public Boolean getIgnoreUriAndModuleKeyValidation() {
    return ignoreUriAndModuleKeyValidation;
  }

  public void setIgnoreUriAndModuleKeyValidation(Boolean ignoreUriAndModuleKeyValidation) {
    this.ignoreUriAndModuleKeyValidation = ignoreUriAndModuleKeyValidation;
  }

  public DashboardGadgetSettings moduleKey(String moduleKey) {
    this.moduleKey = moduleKey;
    return this;
  }

   /**
   * The module key of the gadget type. Can&#39;t be provided with &#x60;uri&#x60;.
   * @return moduleKey
  **/
  @ApiModelProperty(value = "The module key of the gadget type. Can't be provided with `uri`.")
  public String getModuleKey() {
    return moduleKey;
  }

  public void setModuleKey(String moduleKey) {
    this.moduleKey = moduleKey;
  }

  public DashboardGadgetSettings position(DashboardGadgetPosition position) {
    this.position = position;
    return this;
  }

   /**
   * The position of the gadget. When the gadget is placed into the position, other gadgets in the same column are moved down to accommodate it.
   * @return position
  **/
  @ApiModelProperty(value = "The position of the gadget. When the gadget is placed into the position, other gadgets in the same column are moved down to accommodate it.")
  public DashboardGadgetPosition getPosition() {
    return position;
  }

  public void setPosition(DashboardGadgetPosition position) {
    this.position = position;
  }

  public DashboardGadgetSettings title(String title) {
    this.title = title;
    return this;
  }

   /**
   * The title of the gadget.
   * @return title
  **/
  @ApiModelProperty(value = "The title of the gadget.")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public DashboardGadgetSettings uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * The URI of the gadget type. Can&#39;t be provided with &#x60;moduleKey&#x60;.
   * @return uri
  **/
  @ApiModelProperty(value = "The URI of the gadget type. Can't be provided with `moduleKey`.")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardGadgetSettings dashboardGadgetSettings = (DashboardGadgetSettings) o;
    return Objects.equals(this.color, dashboardGadgetSettings.color) &&
        Objects.equals(this.ignoreUriAndModuleKeyValidation, dashboardGadgetSettings.ignoreUriAndModuleKeyValidation) &&
        Objects.equals(this.moduleKey, dashboardGadgetSettings.moduleKey) &&
        Objects.equals(this.position, dashboardGadgetSettings.position) &&
        Objects.equals(this.title, dashboardGadgetSettings.title) &&
        Objects.equals(this.uri, dashboardGadgetSettings.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, ignoreUriAndModuleKeyValidation, moduleKey, position, title, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardGadgetSettings {\n");
    
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    ignoreUriAndModuleKeyValidation: ").append(toIndentedString(ignoreUriAndModuleKeyValidation)).append("\n");
    sb.append("    moduleKey: ").append(toIndentedString(moduleKey)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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

