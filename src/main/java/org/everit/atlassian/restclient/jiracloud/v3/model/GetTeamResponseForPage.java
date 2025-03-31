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
 * GetTeamResponseForPage
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class GetTeamResponseForPage {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  /**
   * The team type. This is \&quot;PlanOnly\&quot; or \&quot;Atlassian\&quot;.
   */
  public enum TypeEnum {
    PLANONLY("PlanOnly"),
    
    ATLASSIAN("Atlassian");

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

  public GetTeamResponseForPage id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The team ID.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The team ID.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GetTeamResponseForPage name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The team name. This is returned if the type is \&quot;PlanOnly\&quot;.
   * @return name
  **/
  @ApiModelProperty(value = "The team name. This is returned if the type is \"PlanOnly\".")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetTeamResponseForPage type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The team type. This is \&quot;PlanOnly\&quot; or \&quot;Atlassian\&quot;.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The team type. This is \"PlanOnly\" or \"Atlassian\".")
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
    GetTeamResponseForPage getTeamResponseForPage = (GetTeamResponseForPage) o;
    return Objects.equals(this.id, getTeamResponseForPage.id) &&
        Objects.equals(this.name, getTeamResponseForPage.name) &&
        Objects.equals(this.type, getTeamResponseForPage.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTeamResponseForPage {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

