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
import org.everit.atlassian.restclient.jiracloud.v3.model.DashboardGadgetPosition;

/**
 * The details of the gadget to update.
 */
@ApiModel(description = "The details of the gadget to update.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class DashboardGadgetUpdateRequest {
  @JsonProperty("color")
  private String color;

  @JsonProperty("position")
  private DashboardGadgetPosition position;

  @JsonProperty("title")
  private String title;

  public DashboardGadgetUpdateRequest color(String color) {
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

  public DashboardGadgetUpdateRequest position(DashboardGadgetPosition position) {
    this.position = position;
    return this;
  }

   /**
   * The position of the gadget.
   * @return position
  **/
  @ApiModelProperty(value = "The position of the gadget.")
  public DashboardGadgetPosition getPosition() {
    return position;
  }

  public void setPosition(DashboardGadgetPosition position) {
    this.position = position;
  }

  public DashboardGadgetUpdateRequest title(String title) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardGadgetUpdateRequest dashboardGadgetUpdateRequest = (DashboardGadgetUpdateRequest) o;
    return Objects.equals(this.color, dashboardGadgetUpdateRequest.color) &&
        Objects.equals(this.position, dashboardGadgetUpdateRequest.position) &&
        Objects.equals(this.title, dashboardGadgetUpdateRequest.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, position, title);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardGadgetUpdateRequest {\n");
    
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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

