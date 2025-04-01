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
import java.util.ArrayList;
import java.util.List;

/**
 * A webhook.
 */
@ApiModel(description = "A webhook.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class Webhook {
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

  @JsonProperty("expirationDate")
  private Long expirationDate;

  @JsonProperty("fieldIdsFilter")
  private List<String> fieldIdsFilter = new ArrayList<>();

  @JsonProperty("id")
  private Long id;

  @JsonProperty("issuePropertyKeysFilter")
  private List<String> issuePropertyKeysFilter = new ArrayList<>();

  @JsonProperty("jqlFilter")
  private String jqlFilter;

  public Webhook events(List<EventsEnum> events) {
    this.events = events;
    return this;
  }

  public Webhook addEventsItem(EventsEnum eventsItem) {
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

   /**
   * The date after which the webhook is no longer sent. Use [Extend webhook life](https://developer.atlassian.com/cloud/jira/platform/rest/v3/api-group-webhooks/#api-rest-api-3-webhook-refresh-put) to extend the date.
   * @return expirationDate
  **/
  @ApiModelProperty(value = "The date after which the webhook is no longer sent. Use [Extend webhook life](https://developer.atlassian.com/cloud/jira/platform/rest/v3/api-group-webhooks/#api-rest-api-3-webhook-refresh-put) to extend the date.")
  public Long getExpirationDate() {
    return expirationDate;
  }

  public Webhook fieldIdsFilter(List<String> fieldIdsFilter) {
    this.fieldIdsFilter = fieldIdsFilter;
    return this;
  }

  public Webhook addFieldIdsFilterItem(String fieldIdsFilterItem) {
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

  public Webhook id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the webhook.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the webhook.")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Webhook issuePropertyKeysFilter(List<String> issuePropertyKeysFilter) {
    this.issuePropertyKeysFilter = issuePropertyKeysFilter;
    return this;
  }

  public Webhook addIssuePropertyKeysFilterItem(String issuePropertyKeysFilterItem) {
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

  public Webhook jqlFilter(String jqlFilter) {
    this.jqlFilter = jqlFilter;
    return this;
  }

   /**
   * The JQL filter that specifies which issues the webhook is sent for.
   * @return jqlFilter
  **/
  @ApiModelProperty(required = true, value = "The JQL filter that specifies which issues the webhook is sent for.")
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
    Webhook webhook = (Webhook) o;
    return Objects.equals(this.events, webhook.events) &&
        Objects.equals(this.expirationDate, webhook.expirationDate) &&
        Objects.equals(this.fieldIdsFilter, webhook.fieldIdsFilter) &&
        Objects.equals(this.id, webhook.id) &&
        Objects.equals(this.issuePropertyKeysFilter, webhook.issuePropertyKeysFilter) &&
        Objects.equals(this.jqlFilter, webhook.jqlFilter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(events, expirationDate, fieldIdsFilter, id, issuePropertyKeysFilter, jqlFilter);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Webhook {\n");
    
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
    sb.append("    fieldIdsFilter: ").append(toIndentedString(fieldIdsFilter)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

