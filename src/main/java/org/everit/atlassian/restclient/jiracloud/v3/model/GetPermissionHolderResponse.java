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

/**
 * GetPermissionHolderResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class GetPermissionHolderResponse {
  /**
   * The permission holder type. This is \&quot;Group\&quot; or \&quot;AccountId\&quot;.
   */
  public enum TypeEnum {
    GROUP("Group"),
    
    ACCOUNTID("AccountId");

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

  @JsonProperty("value")
  private String value;

  public GetPermissionHolderResponse type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The permission holder type. This is \&quot;Group\&quot; or \&quot;AccountId\&quot;.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The permission holder type. This is \"Group\" or \"AccountId\".")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public GetPermissionHolderResponse value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The permission holder value. This is a group name if the type is \&quot;Group\&quot; or an account ID if the type is \&quot;AccountId\&quot;.
   * @return value
  **/
  @ApiModelProperty(required = true, value = "The permission holder value. This is a group name if the type is \"Group\" or an account ID if the type is \"AccountId\".")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPermissionHolderResponse getPermissionHolderResponse = (GetPermissionHolderResponse) o;
    return Objects.equals(this.type, getPermissionHolderResponse.type) &&
        Objects.equals(this.value, getPermissionHolderResponse.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPermissionHolderResponse {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

