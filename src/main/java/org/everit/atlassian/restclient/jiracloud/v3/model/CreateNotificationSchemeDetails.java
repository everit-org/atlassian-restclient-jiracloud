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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v3.model.NotificationSchemeEventDetails;

/**
 * Details of an notification scheme.
 */
@ApiModel(description = "Details of an notification scheme.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class CreateNotificationSchemeDetails {
  @JsonProperty("description")
  private String description;

  @JsonProperty("name")
  private String name;

  @JsonProperty("notificationSchemeEvents")
  private List<NotificationSchemeEventDetails> notificationSchemeEvents = new ArrayList<>();

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public CreateNotificationSchemeDetails description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the notification scheme.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the notification scheme.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreateNotificationSchemeDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the notification scheme. Must be unique (case-insensitive).
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the notification scheme. Must be unique (case-insensitive).")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateNotificationSchemeDetails notificationSchemeEvents(List<NotificationSchemeEventDetails> notificationSchemeEvents) {
    this.notificationSchemeEvents = notificationSchemeEvents;
    return this;
  }

  public CreateNotificationSchemeDetails addNotificationSchemeEventsItem(NotificationSchemeEventDetails notificationSchemeEventsItem) {
    if (this.notificationSchemeEvents == null) {
      this.notificationSchemeEvents = new ArrayList<>();
    }
    this.notificationSchemeEvents.add(notificationSchemeEventsItem);
    return this;
  }

   /**
   * The list of notifications which should be added to the notification scheme.
   * @return notificationSchemeEvents
  **/
  @ApiModelProperty(value = "The list of notifications which should be added to the notification scheme.")
  public List<NotificationSchemeEventDetails> getNotificationSchemeEvents() {
    return notificationSchemeEvents;
  }

  public void setNotificationSchemeEvents(List<NotificationSchemeEventDetails> notificationSchemeEvents) {
    this.notificationSchemeEvents = notificationSchemeEvents;
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
    CreateNotificationSchemeDetails createNotificationSchemeDetails = (CreateNotificationSchemeDetails) o;
    return Objects.equals(this.description, createNotificationSchemeDetails.description) &&
        Objects.equals(this.name, createNotificationSchemeDetails.name) &&
        Objects.equals(this.notificationSchemeEvents, createNotificationSchemeDetails.notificationSchemeEvents) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, notificationSchemeEvents, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateNotificationSchemeDetails {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notificationSchemeEvents: ").append(toIndentedString(notificationSchemeEvents)).append("\n");
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

