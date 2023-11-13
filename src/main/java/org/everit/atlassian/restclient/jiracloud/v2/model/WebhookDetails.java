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
 * A list of webhooks.
 */
@ApiModel(description = "A list of webhooks.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class WebhookDetails {
  /**
   * Gets or Sets events
   */
  public enum EventsEnum {
    JIRA_ISSUE_CREATED("jira:issue_created"),
    
    JIRA_ISSUE_UPDATED("jira:issue_updated"),
    
    JIRA_ISSUE_DELETED("jira:issue_deleted"),
    
    COMMENT_CREATED("comment_created"),
    
    COMMENT_UPDATED("comment_updated"),
    
    COMMENT_DELETED("comment_deleted"),
    
    ISSUE_PROPERTY_SET("issue_property_set"),
    
    ISSUE_PROPERTY_DELETED("issue_property_deleted");

    private String value;

    EventsEnum(String value) {
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
    public static EventsEnum fromValue(String value) {
      for (EventsEnum b : EventsEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("events")
  private List<EventsEnum> events = new ArrayList<>();

  @JsonProperty("fieldIdsFilter")
  private List<String> fieldIdsFilter = new ArrayList<>();

  @JsonProperty("issuePropertyKeysFilter")
  private List<String> issuePropertyKeysFilter = new ArrayList<>();

  @JsonProperty("jqlFilter")
  private String jqlFilter;

  public WebhookDetails events(List<EventsEnum> events) {
    this.events = events;
    return this;
  }

  public WebhookDetails addEventsItem(EventsEnum eventsItem) {
    this.events.add(eventsItem);
    return this;
  }

   /**
   * The Jira events that trigger the webhook.
   * @return events
  **/
  @ApiModelProperty(required = true, value = "The Jira events that trigger the webhook.")
  public List<EventsEnum> getEvents() {
    return events;
  }

  public void setEvents(List<EventsEnum> events) {
    this.events = events;
  }

  public WebhookDetails fieldIdsFilter(List<String> fieldIdsFilter) {
    this.fieldIdsFilter = fieldIdsFilter;
    return this;
  }

  public WebhookDetails addFieldIdsFilterItem(String fieldIdsFilterItem) {
    if (this.fieldIdsFilter == null) {
      this.fieldIdsFilter = new ArrayList<>();
    }
    this.fieldIdsFilter.add(fieldIdsFilterItem);
    return this;
  }

   /**
   * A list of field IDs. When the issue changelog contains any of the fields, the webhook &#x60;jira:issue_updated&#x60; is sent. If this parameter is not present, the app is notified about all field updates.
   * @return fieldIdsFilter
  **/
  @ApiModelProperty(value = "A list of field IDs. When the issue changelog contains any of the fields, the webhook `jira:issue_updated` is sent. If this parameter is not present, the app is notified about all field updates.")
  public List<String> getFieldIdsFilter() {
    return fieldIdsFilter;
  }

  public void setFieldIdsFilter(List<String> fieldIdsFilter) {
    this.fieldIdsFilter = fieldIdsFilter;
  }

  public WebhookDetails issuePropertyKeysFilter(List<String> issuePropertyKeysFilter) {
    this.issuePropertyKeysFilter = issuePropertyKeysFilter;
    return this;
  }

  public WebhookDetails addIssuePropertyKeysFilterItem(String issuePropertyKeysFilterItem) {
    if (this.issuePropertyKeysFilter == null) {
      this.issuePropertyKeysFilter = new ArrayList<>();
    }
    this.issuePropertyKeysFilter.add(issuePropertyKeysFilterItem);
    return this;
  }

   /**
   * A list of issue property keys. A change of those issue properties triggers the &#x60;issue_property_set&#x60; or &#x60;issue_property_deleted&#x60; webhooks. If this parameter is not present, the app is notified about all issue property updates.
   * @return issuePropertyKeysFilter
  **/
  @ApiModelProperty(value = "A list of issue property keys. A change of those issue properties triggers the `issue_property_set` or `issue_property_deleted` webhooks. If this parameter is not present, the app is notified about all issue property updates.")
  public List<String> getIssuePropertyKeysFilter() {
    return issuePropertyKeysFilter;
  }

  public void setIssuePropertyKeysFilter(List<String> issuePropertyKeysFilter) {
    this.issuePropertyKeysFilter = issuePropertyKeysFilter;
  }

  public WebhookDetails jqlFilter(String jqlFilter) {
    this.jqlFilter = jqlFilter;
    return this;
  }

   /**
   * The JQL filter that specifies which issues the webhook is sent for. Only a subset of JQL can be used. The supported elements are:   *  Fields: &#x60;issueKey&#x60;, &#x60;project&#x60;, &#x60;issuetype&#x60;, &#x60;status&#x60;, &#x60;assignee&#x60;, &#x60;reporter&#x60;, &#x60;issue.property&#x60;, and &#x60;cf[id]&#x60;. For custom fields (&#x60;cf[id]&#x60;), only the epic label custom field is supported.\&quot;.  *  Operators: &#x60;&#x3D;&#x60;, &#x60;!&#x3D;&#x60;, &#x60;IN&#x60;, and &#x60;NOT IN&#x60;.
   * @return jqlFilter
  **/
  @ApiModelProperty(required = true, value = "The JQL filter that specifies which issues the webhook is sent for. Only a subset of JQL can be used. The supported elements are:   *  Fields: `issueKey`, `project`, `issuetype`, `status`, `assignee`, `reporter`, `issue.property`, and `cf[id]`. For custom fields (`cf[id]`), only the epic label custom field is supported.\".  *  Operators: `=`, `!=`, `IN`, and `NOT IN`.")
  public String getJqlFilter() {
    return jqlFilter;
  }

  public void setJqlFilter(String jqlFilter) {
    this.jqlFilter = jqlFilter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookDetails webhookDetails = (WebhookDetails) o;
    return Objects.equals(this.events, webhookDetails.events) &&
        Objects.equals(this.fieldIdsFilter, webhookDetails.fieldIdsFilter) &&
        Objects.equals(this.issuePropertyKeysFilter, webhookDetails.issuePropertyKeysFilter) &&
        Objects.equals(this.jqlFilter, webhookDetails.jqlFilter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(events, fieldIdsFilter, issuePropertyKeysFilter, jqlFilter);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookDetails {\n");
    
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    fieldIdsFilter: ").append(toIndentedString(fieldIdsFilter)).append("\n");
    sb.append("    issuePropertyKeysFilter: ").append(toIndentedString(issuePropertyKeysFilter)).append("\n");
    sb.append("    jqlFilter: ").append(toIndentedString(jqlFilter)).append("\n");
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

