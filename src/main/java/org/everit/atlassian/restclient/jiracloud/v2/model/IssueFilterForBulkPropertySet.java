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
import java.util.ArrayList;
import java.util.List;

/**
 * Bulk operation filter details.
 */
@ApiModel(description = "Bulk operation filter details.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class IssueFilterForBulkPropertySet {
  @JsonProperty("currentValue")
  private Object currentValue = null;

  @JsonProperty("entityIds")
  private List<Long> entityIds = new ArrayList<>();

  @JsonProperty("hasProperty")
  private Boolean hasProperty;

  public IssueFilterForBulkPropertySet currentValue(Object currentValue) {
    this.currentValue = currentValue;
    return this;
  }

   /**
   * The value of properties to perform the bulk operation on.
   * @return currentValue
  **/
  @ApiModelProperty(value = "The value of properties to perform the bulk operation on.")
  public Object getCurrentValue() {
    return currentValue;
  }

  public void setCurrentValue(Object currentValue) {
    this.currentValue = currentValue;
  }

  public IssueFilterForBulkPropertySet entityIds(List<Long> entityIds) {
    this.entityIds = entityIds;
    return this;
  }

  public IssueFilterForBulkPropertySet addEntityIdsItem(Long entityIdsItem) {
    if (this.entityIds == null) {
      this.entityIds = new ArrayList<>();
    }
    this.entityIds.add(entityIdsItem);
    return this;
  }

   /**
   * List of issues to perform the bulk operation on.
   * @return entityIds
  **/
  @ApiModelProperty(value = "List of issues to perform the bulk operation on.")
  public List<Long> getEntityIds() {
    return entityIds;
  }

  public void setEntityIds(List<Long> entityIds) {
    this.entityIds = entityIds;
  }

  public IssueFilterForBulkPropertySet hasProperty(Boolean hasProperty) {
    this.hasProperty = hasProperty;
    return this;
  }

   /**
   * Whether the bulk operation occurs only when the property is present on or absent from an issue.
   * @return hasProperty
  **/
  @ApiModelProperty(value = "Whether the bulk operation occurs only when the property is present on or absent from an issue.")
  public Boolean getHasProperty() {
    return hasProperty;
  }

  public void setHasProperty(Boolean hasProperty) {
    this.hasProperty = hasProperty;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueFilterForBulkPropertySet issueFilterForBulkPropertySet = (IssueFilterForBulkPropertySet) o;
    return Objects.equals(this.currentValue, issueFilterForBulkPropertySet.currentValue) &&
        Objects.equals(this.entityIds, issueFilterForBulkPropertySet.entityIds) &&
        Objects.equals(this.hasProperty, issueFilterForBulkPropertySet.hasProperty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentValue, entityIds, hasProperty);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueFilterForBulkPropertySet {\n");
    
    sb.append("    currentValue: ").append(toIndentedString(currentValue)).append("\n");
    sb.append("    entityIds: ").append(toIndentedString(entityIds)).append("\n");
    sb.append("    hasProperty: ").append(toIndentedString(hasProperty)).append("\n");
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

