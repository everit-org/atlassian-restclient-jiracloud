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

/**
 * The default value for a Forge date time custom field.
 */
@ApiModel(description = "The default value for a Forge date time custom field.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class CustomFieldContextDefaultValueForgeDateTimeField {
  @JsonProperty("contextId")
  private String contextId;

  @JsonProperty("dateTime")
  private String dateTime;

  @JsonProperty("type")
  private String type;

  @JsonProperty("useCurrent")
  private Boolean useCurrent = false;

  public CustomFieldContextDefaultValueForgeDateTimeField contextId(String contextId) {
    this.contextId = contextId;
    return this;
  }

   /**
   * The ID of the context.
   * @return contextId
  **/
  @ApiModelProperty(required = true, value = "The ID of the context.")
  public String getContextId() {
    return contextId;
  }

  public void setContextId(String contextId) {
    this.contextId = contextId;
  }

  public CustomFieldContextDefaultValueForgeDateTimeField dateTime(String dateTime) {
    this.dateTime = dateTime;
    return this;
  }

   /**
   * The default date-time in ISO format. Ignored if &#x60;useCurrent&#x60; is true.
   * @return dateTime
  **/
  @ApiModelProperty(value = "The default date-time in ISO format. Ignored if `useCurrent` is true.")
  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }

  public CustomFieldContextDefaultValueForgeDateTimeField type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CustomFieldContextDefaultValueForgeDateTimeField useCurrent(Boolean useCurrent) {
    this.useCurrent = useCurrent;
    return this;
  }

   /**
   * Whether to use the current date.
   * @return useCurrent
  **/
  @ApiModelProperty(value = "Whether to use the current date.")
  public Boolean getUseCurrent() {
    return useCurrent;
  }

  public void setUseCurrent(Boolean useCurrent) {
    this.useCurrent = useCurrent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomFieldContextDefaultValueForgeDateTimeField customFieldContextDefaultValueForgeDateTimeField = (CustomFieldContextDefaultValueForgeDateTimeField) o;
    return Objects.equals(this.contextId, customFieldContextDefaultValueForgeDateTimeField.contextId) &&
        Objects.equals(this.dateTime, customFieldContextDefaultValueForgeDateTimeField.dateTime) &&
        Objects.equals(this.type, customFieldContextDefaultValueForgeDateTimeField.type) &&
        Objects.equals(this.useCurrent, customFieldContextDefaultValueForgeDateTimeField.useCurrent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contextId, dateTime, type, useCurrent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldContextDefaultValueForgeDateTimeField {\n");
    
    sb.append("    contextId: ").append(toIndentedString(contextId)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    useCurrent: ").append(toIndentedString(useCurrent)).append("\n");
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

