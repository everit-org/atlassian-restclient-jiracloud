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
import org.everit.atlassian.restclient.jiracloud.v2.model.GetPermissionHolderResponse;

/**
 * GetPermissionResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class GetPermissionResponse {
  @JsonProperty("holder")
  private GetPermissionHolderResponse holder;

  /**
   * The permission type. This is \&quot;View\&quot; or \&quot;Edit\&quot;.
   */
  public enum TypeEnum {
    VIEW("View"),
    
    EDIT("Edit");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  public GetPermissionResponse holder(GetPermissionHolderResponse holder) {
    this.holder = holder;
    return this;
  }

   /**
   * The permission holder.
   * @return holder
  **/
  @ApiModelProperty(required = true, value = "The permission holder.")
  public GetPermissionHolderResponse getHolder() {
    return holder;
  }

  public void setHolder(GetPermissionHolderResponse holder) {
    this.holder = holder;
  }

  public GetPermissionResponse type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The permission type. This is \&quot;View\&quot; or \&quot;Edit\&quot;.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The permission type. This is \"View\" or \"Edit\".")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPermissionResponse getPermissionResponse = (GetPermissionResponse) o;
    return Objects.equals(this.holder, getPermissionResponse.holder) &&
        Objects.equals(this.type, getPermissionResponse.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(holder, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPermissionResponse {\n");
    
    sb.append("    holder: ").append(toIndentedString(holder)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

