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
 * Details of a gadget.
 */
@ApiModel(description = "Details of a gadget.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class DashboardGadget {
  /**
   * The color of the gadget. Should be one of &#x60;blue&#x60;, &#x60;red&#x60;, &#x60;yellow&#x60;, &#x60;green&#x60;, &#x60;cyan&#x60;, &#x60;purple&#x60;, &#x60;gray&#x60;, or &#x60;white&#x60;.
   */
  public enum ColorEnum {
    BLUE("blue"),
    
    RED("red"),
    
    YELLOW("yellow"),
    
    GREEN("green"),
    
    CYAN("cyan"),
    
    PURPLE("purple"),
    
    GRAY("gray"),
    
    WHITE("white");

    private String value;

    ColorEnum(String value) {
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
    public static ColorEnum fromValue(String value) {
      for (ColorEnum b : ColorEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("color")
  private ColorEnum color;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("moduleKey")
  private String moduleKey;

  @JsonProperty("position")
  private DashboardGadgetPosition position;

  @JsonProperty("title")
  private String title;

  @JsonProperty("uri")
  private String uri;

   /**
   * The color of the gadget. Should be one of &#x60;blue&#x60;, &#x60;red&#x60;, &#x60;yellow&#x60;, &#x60;green&#x60;, &#x60;cyan&#x60;, &#x60;purple&#x60;, &#x60;gray&#x60;, or &#x60;white&#x60;.
   * @return color
  **/
  @ApiModelProperty(required = true, value = "The color of the gadget. Should be one of `blue`, `red`, `yellow`, `green`, `cyan`, `purple`, `gray`, or `white`.")
  public ColorEnum getColor() {
    return color;
  }

   /**
   * The ID of the gadget instance.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the gadget instance.")
  public Long getId() {
    return id;
  }

   /**
   * The module key of the gadget type.
   * @return moduleKey
  **/
  @ApiModelProperty(value = "The module key of the gadget type.")
  public String getModuleKey() {
    return moduleKey;
  }

   /**
   * The position of the gadget.
   * @return position
  **/
  @ApiModelProperty(required = true, value = "The position of the gadget.")
  public DashboardGadgetPosition getPosition() {
    return position;
  }

   /**
   * The title of the gadget.
   * @return title
  **/
  @ApiModelProperty(required = true, value = "The title of the gadget.")
  public String getTitle() {
    return title;
  }

   /**
   * The URI of the gadget type.
   * @return uri
  **/
  @ApiModelProperty(value = "The URI of the gadget type.")
  public String getUri() {
    return uri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardGadget dashboardGadget = (DashboardGadget) o;
    return Objects.equals(this.color, dashboardGadget.color) &&
        Objects.equals(this.id, dashboardGadget.id) &&
        Objects.equals(this.moduleKey, dashboardGadget.moduleKey) &&
        Objects.equals(this.position, dashboardGadget.position) &&
        Objects.equals(this.title, dashboardGadget.title) &&
        Objects.equals(this.uri, dashboardGadget.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, id, moduleKey, position, title, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardGadget {\n");
    
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

