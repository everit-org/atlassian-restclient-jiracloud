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
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.AssociatedItemBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.ChangedValueBean;

/**
 * An audit record.
 */
@ApiModel(description = "An audit record.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class AuditRecordBean {
  @JsonProperty("associatedItems")
  private List<AssociatedItemBean> associatedItems = new ArrayList<>();

  @JsonProperty("authorKey")
  private String authorKey;

  @JsonProperty("category")
  private String category;

  @JsonProperty("changedValues")
  private List<ChangedValueBean> changedValues = new ArrayList<>();

  @JsonProperty("created")
  private OffsetDateTime created;

  @JsonProperty("description")
  private String description;

  @JsonProperty("eventSource")
  private String eventSource;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("objectItem")
  private AssociatedItemBean objectItem;

  @JsonProperty("remoteAddress")
  private String remoteAddress;

  @JsonProperty("summary")
  private String summary;

   /**
   * The list of items associated with the changed record.
   * @return associatedItems
  **/
  @ApiModelProperty(value = "The list of items associated with the changed record.")
  public List<AssociatedItemBean> getAssociatedItems() {
    return associatedItems;
  }

   /**
   * Deprecated, use &#x60;authorAccountId&#x60; instead. The key of the user who created the audit record.
   * @return authorKey
  **/
  @ApiModelProperty(value = "Deprecated, use `authorAccountId` instead. The key of the user who created the audit record.")
  public String getAuthorKey() {
    return authorKey;
  }

   /**
   * The category of the audit record. For a list of these categories, see the help article [Auditing in Jira applications](https://confluence.atlassian.com/x/noXKM).
   * @return category
  **/
  @ApiModelProperty(value = "The category of the audit record. For a list of these categories, see the help article [Auditing in Jira applications](https://confluence.atlassian.com/x/noXKM).")
  public String getCategory() {
    return category;
  }

   /**
   * The list of values changed in the record event.
   * @return changedValues
  **/
  @ApiModelProperty(value = "The list of values changed in the record event.")
  public List<ChangedValueBean> getChangedValues() {
    return changedValues;
  }

   /**
   * The date and time on which the audit record was created.
   * @return created
  **/
  @ApiModelProperty(value = "The date and time on which the audit record was created.")
  public OffsetDateTime getCreated() {
    return created;
  }

   /**
   * The description of the audit record.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the audit record.")
  public String getDescription() {
    return description;
  }

   /**
   * The event the audit record originated from.
   * @return eventSource
  **/
  @ApiModelProperty(value = "The event the audit record originated from.")
  public String getEventSource() {
    return eventSource;
  }

   /**
   * The ID of the audit record.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the audit record.")
  public Long getId() {
    return id;
  }

  public AuditRecordBean objectItem(AssociatedItemBean objectItem) {
    this.objectItem = objectItem;
    return this;
  }

   /**
   * Get objectItem
   * @return objectItem
  **/
  @ApiModelProperty(value = "")
  public AssociatedItemBean getObjectItem() {
    return objectItem;
  }

  public void setObjectItem(AssociatedItemBean objectItem) {
    this.objectItem = objectItem;
  }

   /**
   * The URL of the computer where the creation of the audit record was initiated.
   * @return remoteAddress
  **/
  @ApiModelProperty(value = "The URL of the computer where the creation of the audit record was initiated.")
  public String getRemoteAddress() {
    return remoteAddress;
  }

   /**
   * The summary of the audit record.
   * @return summary
  **/
  @ApiModelProperty(value = "The summary of the audit record.")
  public String getSummary() {
    return summary;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditRecordBean auditRecordBean = (AuditRecordBean) o;
    return Objects.equals(this.associatedItems, auditRecordBean.associatedItems) &&
        Objects.equals(this.authorKey, auditRecordBean.authorKey) &&
        Objects.equals(this.category, auditRecordBean.category) &&
        Objects.equals(this.changedValues, auditRecordBean.changedValues) &&
        Objects.equals(this.created, auditRecordBean.created) &&
        Objects.equals(this.description, auditRecordBean.description) &&
        Objects.equals(this.eventSource, auditRecordBean.eventSource) &&
        Objects.equals(this.id, auditRecordBean.id) &&
        Objects.equals(this.objectItem, auditRecordBean.objectItem) &&
        Objects.equals(this.remoteAddress, auditRecordBean.remoteAddress) &&
        Objects.equals(this.summary, auditRecordBean.summary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(associatedItems, authorKey, category, changedValues, created, description, eventSource, id, objectItem, remoteAddress, summary);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditRecordBean {\n");
    
    sb.append("    associatedItems: ").append(toIndentedString(associatedItems)).append("\n");
    sb.append("    authorKey: ").append(toIndentedString(authorKey)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    changedValues: ").append(toIndentedString(changedValues)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    eventSource: ").append(toIndentedString(eventSource)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    objectItem: ").append(toIndentedString(objectItem)).append("\n");
    sb.append("    remoteAddress: ").append(toIndentedString(remoteAddress)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
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

