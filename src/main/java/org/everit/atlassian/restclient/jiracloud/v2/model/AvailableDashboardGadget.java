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
 * The details of the available dashboard gadget.
 */
@ApiModel(description = "The details of the available dashboard gadget.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class AvailableDashboardGadget {
  @JsonProperty("moduleKey")
  private String moduleKey;

  @JsonProperty("title")
  private String title;

  @JsonProperty("uri")
  private String uri;

   /**
   * The module key of the gadget type.
   * @return moduleKey
  **/
  @ApiModelProperty(value = "The module key of the gadget type.")
  public String getModuleKey() {
    return moduleKey;
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
    AvailableDashboardGadget availableDashboardGadget = (AvailableDashboardGadget) o;
    return Objects.equals(this.moduleKey, availableDashboardGadget.moduleKey) &&
        Objects.equals(this.title, availableDashboardGadget.title) &&
        Objects.equals(this.uri, availableDashboardGadget.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(moduleKey, title, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableDashboardGadget {\n");
    
    sb.append("    moduleKey: ").append(toIndentedString(moduleKey)).append("\n");
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

