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
import org.everit.atlassian.restclient.jiracloud.v3.model.NotificationSchemeEventTypeId;
import org.everit.atlassian.restclient.jiracloud.v3.model.NotificationSchemeNotificationDetails;

/**
 * Details of a notification scheme event.
 */
@ApiModel(description = "Details of a notification scheme event.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class NotificationSchemeEventDetails {
  @JsonProperty("event")
  private NotificationSchemeEventTypeId event;

  @JsonProperty("notifications")
  private List<NotificationSchemeNotificationDetails> notifications = new ArrayList<>();

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public NotificationSchemeEventDetails event(NotificationSchemeEventTypeId event) {
    this.event = event;
    return this;
  }

   /**
   * The ID of the event.
   * @return event
  **/
  @ApiModelProperty(required = true, value = "The ID of the event.")
  public NotificationSchemeEventTypeId getEvent() {
    return event;
  }

  public void setEvent(NotificationSchemeEventTypeId event) {
    this.event = event;
  }

  public NotificationSchemeEventDetails notifications(List<NotificationSchemeNotificationDetails> notifications) {
    this.notifications = notifications;
    return this;
  }

  public NotificationSchemeEventDetails addNotificationsItem(NotificationSchemeNotificationDetails notificationsItem) {
    this.notifications.add(notificationsItem);
    return this;
  }

   /**
   * The list of notifications mapped to a specified event.
   * @return notifications
  **/
  @ApiModelProperty(required = true, value = "The list of notifications mapped to a specified event.")
  public List<NotificationSchemeNotificationDetails> getNotifications() {
    return notifications;
  }

  public void setNotifications(List<NotificationSchemeNotificationDetails> notifications) {
    this.notifications = notifications;
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
    NotificationSchemeEventDetails notificationSchemeEventDetails = (NotificationSchemeEventDetails) o;
    return Objects.equals(this.event, notificationSchemeEventDetails.event) &&
        Objects.equals(this.notifications, notificationSchemeEventDetails.notifications) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, notifications, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationSchemeEventDetails {\n");
    
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    notifications: ").append(toIndentedString(notifications)).append("\n");
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

