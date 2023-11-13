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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowLayout;

/**
 * The statuses associated with this workflow.
 */
@ApiModel(description = "The statuses associated with this workflow.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class StatusLayoutUpdate {
  @JsonProperty("layout")
  private WorkflowLayout layout;

  @JsonProperty("properties")
  private Map<String, String> properties = new HashMap<>();

  @JsonProperty("statusReference")
  private String statusReference;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public StatusLayoutUpdate layout(WorkflowLayout layout) {
    this.layout = layout;
    return this;
  }

   /**
   * Get layout
   * @return layout
  **/
  @ApiModelProperty(value = "")
  public WorkflowLayout getLayout() {
    return layout;
  }

  public void setLayout(WorkflowLayout layout) {
    this.layout = layout;
  }

  public StatusLayoutUpdate properties(Map<String, String> properties) {
    this.properties = properties;
    return this;
  }

  public StatusLayoutUpdate putPropertiesItem(String key, String propertiesItem) {
    this.properties.put(key, propertiesItem);
    return this;
  }

   /**
   * The properties for this status layout.
   * @return properties
  **/
  @ApiModelProperty(required = true, value = "The properties for this status layout.")
  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  public StatusLayoutUpdate statusReference(String statusReference) {
    this.statusReference = statusReference;
    return this;
  }

   /**
   * A unique ID which the status will use to refer to this layout configuration.
   * @return statusReference
  **/
  @ApiModelProperty(required = true, value = "A unique ID which the status will use to refer to this layout configuration.")
  public String getStatusReference() {
    return statusReference;
  }

  public void setStatusReference(String statusReference) {
    this.statusReference = statusReference;
  }


  @com.fasterxml.jackson.annotation.JsonAnyGetter
  public Map<String, Object> any() {
   return this.additionalProperties_;
  }

  @com.fasterxml.jackson.annotation.JsonAnySetter
  public void set(String name, Object value) {
   this.additionalProperties_.put(name, value);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusLayoutUpdate statusLayoutUpdate = (StatusLayoutUpdate) o;
    return Objects.equals(this.layout, statusLayoutUpdate.layout) &&
        Objects.equals(this.properties, statusLayoutUpdate.properties) &&
        Objects.equals(this.statusReference, statusLayoutUpdate.statusReference) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(layout, properties, statusReference, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusLayoutUpdate {\n");
    
    sb.append("    layout: ").append(toIndentedString(layout)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    statusReference: ").append(toIndentedString(statusReference)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties_)).append("\n");
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

