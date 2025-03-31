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
 * Details of the status being created.
 */
@ApiModel(description = "Details of the status being created.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class StatusCreate {
  @JsonProperty("description")
  private String description;

  @JsonProperty("name")
  private String name;

  /**
   * The category of the status.
   */
  public enum StatusCategoryEnum {
    TODO("TODO"),
    
    IN_PROGRESS("IN_PROGRESS"),
    
    DONE("DONE");

    private String value;

    StatusCategoryEnum(String value) {
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
    public static StatusCategoryEnum fromValue(String value) {
      for (StatusCategoryEnum b : StatusCategoryEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("statusCategory")
  private StatusCategoryEnum statusCategory;

  public StatusCreate description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the status.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the status.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public StatusCreate name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the status.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the status.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StatusCreate statusCategory(StatusCategoryEnum statusCategory) {
    this.statusCategory = statusCategory;
    return this;
  }

   /**
   * The category of the status.
   * @return statusCategory
  **/
  @ApiModelProperty(required = true, value = "The category of the status.")
  public StatusCategoryEnum getStatusCategory() {
    return statusCategory;
  }

  public void setStatusCategory(StatusCategoryEnum statusCategory) {
    this.statusCategory = statusCategory;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusCreate statusCreate = (StatusCreate) o;
    return Objects.equals(this.description, statusCreate.description) &&
        Objects.equals(this.name, statusCreate.name) &&
        Objects.equals(this.statusCategory, statusCreate.statusCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, statusCategory);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusCreate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    statusCategory: ").append(toIndentedString(statusCategory)).append("\n");
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

