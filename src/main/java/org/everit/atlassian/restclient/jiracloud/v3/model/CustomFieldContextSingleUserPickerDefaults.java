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
import org.everit.atlassian.restclient.jiracloud.v3.model.UserFilter;

/**
 * Defaults for a User Picker (single) custom field.
 */
@ApiModel(description = "Defaults for a User Picker (single) custom field.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class CustomFieldContextSingleUserPickerDefaults {
  @JsonProperty("accountId")
  private String accountId;

  @JsonProperty("contextId")
  private String contextId;

  @JsonProperty("type")
  private String type;

  @JsonProperty("userFilter")
  private UserFilter userFilter;

  public CustomFieldContextSingleUserPickerDefaults accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * The ID of the default user.
   * @return accountId
  **/
  @ApiModelProperty(required = true, value = "The ID of the default user.")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public CustomFieldContextSingleUserPickerDefaults contextId(String contextId) {
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

  public CustomFieldContextSingleUserPickerDefaults type(String type) {
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

  public CustomFieldContextSingleUserPickerDefaults userFilter(UserFilter userFilter) {
    this.userFilter = userFilter;
    return this;
  }

   /**
   * Get userFilter
   * @return userFilter
  **/
  @ApiModelProperty(required = true, value = "")
  public UserFilter getUserFilter() {
    return userFilter;
  }

  public void setUserFilter(UserFilter userFilter) {
    this.userFilter = userFilter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomFieldContextSingleUserPickerDefaults customFieldContextSingleUserPickerDefaults = (CustomFieldContextSingleUserPickerDefaults) o;
    return Objects.equals(this.accountId, customFieldContextSingleUserPickerDefaults.accountId) &&
        Objects.equals(this.contextId, customFieldContextSingleUserPickerDefaults.contextId) &&
        Objects.equals(this.type, customFieldContextSingleUserPickerDefaults.type) &&
        Objects.equals(this.userFilter, customFieldContextSingleUserPickerDefaults.userFilter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, contextId, type, userFilter);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldContextSingleUserPickerDefaults {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    contextId: ").append(toIndentedString(contextId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    userFilter: ").append(toIndentedString(userFilter)).append("\n");
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

