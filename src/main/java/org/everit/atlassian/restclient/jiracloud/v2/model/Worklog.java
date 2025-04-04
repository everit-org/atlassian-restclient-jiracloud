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
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v2.model.EntityProperty;
import org.everit.atlassian.restclient.jiracloud.v2.model.UserDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.Visibility;

/**
 * Details of a worklog.
 */
@ApiModel(description = "Details of a worklog.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class Worklog {
  @JsonProperty("author")
  private UserDetails author;

  @JsonProperty("comment")
  private String comment;

  @JsonProperty("created")
  private OffsetDateTime created;

  @JsonProperty("id")
  private String id;

  @JsonProperty("issueId")
  private String issueId;

  @JsonProperty("properties")
  private List<EntityProperty> properties = new ArrayList<>();

  @JsonProperty("self")
  private URI self;

  @JsonProperty("started")
  private OffsetDateTime started;

  @JsonProperty("timeSpent")
  private String timeSpent;

  @JsonProperty("timeSpentSeconds")
  private Long timeSpentSeconds;

  @JsonProperty("updateAuthor")
  private UserDetails updateAuthor;

  @JsonProperty("updated")
  private OffsetDateTime updated;

  @JsonProperty("visibility")
  private Visibility visibility;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

   /**
   * Details of the user who created the worklog.
   * @return author
  **/
  @ApiModelProperty(value = "Details of the user who created the worklog.")
  public UserDetails getAuthor() {
    return author;
  }

  public Worklog comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   * A comment about the worklog. Optional when creating or updating a worklog.
   * @return comment
  **/
  @ApiModelProperty(value = "A comment about the worklog. Optional when creating or updating a worklog.")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

   /**
   * The datetime on which the worklog was created.
   * @return created
  **/
  @ApiModelProperty(value = "The datetime on which the worklog was created.")
  public OffsetDateTime getCreated() {
    return created;
  }

   /**
   * The ID of the worklog record.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the worklog record.")
  public String getId() {
    return id;
  }

   /**
   * The ID of the issue this worklog is for.
   * @return issueId
  **/
  @ApiModelProperty(value = "The ID of the issue this worklog is for.")
  public String getIssueId() {
    return issueId;
  }

  public Worklog properties(List<EntityProperty> properties) {
    this.properties = properties;
    return this;
  }

  public Worklog addPropertiesItem(EntityProperty propertiesItem) {
    if (this.properties == null) {
      this.properties = new ArrayList<>();
    }
    this.properties.add(propertiesItem);
    return this;
  }

   /**
   * Details of properties for the worklog. Optional when creating or updating a worklog.
   * @return properties
  **/
  @ApiModelProperty(value = "Details of properties for the worklog. Optional when creating or updating a worklog.")
  public List<EntityProperty> getProperties() {
    return properties;
  }

  public void setProperties(List<EntityProperty> properties) {
    this.properties = properties;
  }

   /**
   * The URL of the worklog item.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the worklog item.")
  public URI getSelf() {
    return self;
  }

  public Worklog started(OffsetDateTime started) {
    this.started = started;
    return this;
  }

   /**
   * The datetime on which the worklog effort was started. Required when creating a worklog. Optional when updating a worklog.
   * @return started
  **/
  @ApiModelProperty(value = "The datetime on which the worklog effort was started. Required when creating a worklog. Optional when updating a worklog.")
  public OffsetDateTime getStarted() {
    return started;
  }

  public void setStarted(OffsetDateTime started) {
    this.started = started;
  }

  public Worklog timeSpent(String timeSpent) {
    this.timeSpent = timeSpent;
    return this;
  }

   /**
   * The time spent working on the issue as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). Required when creating a worklog if &#x60;timeSpentSeconds&#x60; isn&#39;t provided. Optional when updating a worklog. Cannot be provided if &#x60;timeSpentSecond&#x60; is provided.
   * @return timeSpent
  **/
  @ApiModelProperty(value = "The time spent working on the issue as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). Required when creating a worklog if `timeSpentSeconds` isn't provided. Optional when updating a worklog. Cannot be provided if `timeSpentSecond` is provided.")
  public String getTimeSpent() {
    return timeSpent;
  }

  public void setTimeSpent(String timeSpent) {
    this.timeSpent = timeSpent;
  }

  public Worklog timeSpentSeconds(Long timeSpentSeconds) {
    this.timeSpentSeconds = timeSpentSeconds;
    return this;
  }

   /**
   * The time in seconds spent working on the issue. Required when creating a worklog if &#x60;timeSpent&#x60; isn&#39;t provided. Optional when updating a worklog. Cannot be provided if &#x60;timeSpent&#x60; is provided.
   * @return timeSpentSeconds
  **/
  @ApiModelProperty(value = "The time in seconds spent working on the issue. Required when creating a worklog if `timeSpent` isn't provided. Optional when updating a worklog. Cannot be provided if `timeSpent` is provided.")
  public Long getTimeSpentSeconds() {
    return timeSpentSeconds;
  }

  public void setTimeSpentSeconds(Long timeSpentSeconds) {
    this.timeSpentSeconds = timeSpentSeconds;
  }

   /**
   * Details of the user who last updated the worklog.
   * @return updateAuthor
  **/
  @ApiModelProperty(value = "Details of the user who last updated the worklog.")
  public UserDetails getUpdateAuthor() {
    return updateAuthor;
  }

   /**
   * The datetime on which the worklog was last updated.
   * @return updated
  **/
  @ApiModelProperty(value = "The datetime on which the worklog was last updated.")
  public OffsetDateTime getUpdated() {
    return updated;
  }

  public Worklog visibility(Visibility visibility) {
    this.visibility = visibility;
    return this;
  }

   /**
   * Details about any restrictions in the visibility of the worklog. Optional when creating or updating a worklog.
   * @return visibility
  **/
  @ApiModelProperty(value = "Details about any restrictions in the visibility of the worklog. Optional when creating or updating a worklog.")
  public Visibility getVisibility() {
    return visibility;
  }

  public void setVisibility(Visibility visibility) {
    this.visibility = visibility;
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
    Worklog worklog = (Worklog) o;
    return Objects.equals(this.author, worklog.author) &&
        Objects.equals(this.comment, worklog.comment) &&
        Objects.equals(this.created, worklog.created) &&
        Objects.equals(this.id, worklog.id) &&
        Objects.equals(this.issueId, worklog.issueId) &&
        Objects.equals(this.properties, worklog.properties) &&
        Objects.equals(this.self, worklog.self) &&
        Objects.equals(this.started, worklog.started) &&
        Objects.equals(this.timeSpent, worklog.timeSpent) &&
        Objects.equals(this.timeSpentSeconds, worklog.timeSpentSeconds) &&
        Objects.equals(this.updateAuthor, worklog.updateAuthor) &&
        Objects.equals(this.updated, worklog.updated) &&
        Objects.equals(this.visibility, worklog.visibility) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(author, comment, created, id, issueId, properties, self, started, timeSpent, timeSpentSeconds, updateAuthor, updated, visibility, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Worklog {\n");
    
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    issueId: ").append(toIndentedString(issueId)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    started: ").append(toIndentedString(started)).append("\n");
    sb.append("    timeSpent: ").append(toIndentedString(timeSpent)).append("\n");
    sb.append("    timeSpentSeconds: ").append(toIndentedString(timeSpentSeconds)).append("\n");
    sb.append("    updateAuthor: ").append(toIndentedString(updateAuthor)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
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

