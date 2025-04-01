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
import org.everit.atlassian.restclient.jiracloud.v2.model.UiModificationContextDetails;

/**
 * The details of a UI modification.
 */
@ApiModel(description = "The details of a UI modification.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class UpdateUiModificationDetails {
  @JsonProperty("contexts")
  private List<UiModificationContextDetails> contexts = new ArrayList<>();

  @JsonProperty("data")
  private String data;

  @JsonProperty("description")
  private String description;

  @JsonProperty("name")
  private String name;

  public UpdateUiModificationDetails contexts(List<UiModificationContextDetails> contexts) {
    this.contexts = contexts;
    return this;
  }

  public UpdateUiModificationDetails addContextsItem(UiModificationContextDetails contextsItem) {
    if (this.contexts == null) {
      this.contexts = new ArrayList<>();
    }
    this.contexts.add(contextsItem);
    return this;
  }

   /**
   * List of contexts of the UI modification. The maximum number of contexts is 1000. If provided, replaces all existing contexts.
   * @return contexts
  **/
  @ApiModelProperty(value = "List of contexts of the UI modification. The maximum number of contexts is 1000. If provided, replaces all existing contexts.")
  public List<UiModificationContextDetails> getContexts() {
    return contexts;
  }

  public void setContexts(List<UiModificationContextDetails> contexts) {
    this.contexts = contexts;
  }

  public UpdateUiModificationDetails data(String data) {
    this.data = data;
    return this;
  }

   /**
   * The data of the UI modification. The maximum size of the data is 50000 characters.
   * @return data
  **/
  @ApiModelProperty(value = "The data of the UI modification. The maximum size of the data is 50000 characters.")
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public UpdateUiModificationDetails description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the UI modification. The maximum length is 255 characters.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the UI modification. The maximum length is 255 characters.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UpdateUiModificationDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the UI modification. The maximum length is 255 characters.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the UI modification. The maximum length is 255 characters.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUiModificationDetails updateUiModificationDetails = (UpdateUiModificationDetails) o;
    return Objects.equals(this.contexts, updateUiModificationDetails.contexts) &&
        Objects.equals(this.data, updateUiModificationDetails.data) &&
        Objects.equals(this.description, updateUiModificationDetails.description) &&
        Objects.equals(this.name, updateUiModificationDetails.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contexts, data, description, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUiModificationDetails {\n");
    
    sb.append("    contexts: ").append(toIndentedString(contexts)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

