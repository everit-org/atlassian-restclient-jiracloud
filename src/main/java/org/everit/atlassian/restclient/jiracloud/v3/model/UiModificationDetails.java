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
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v3.model.UiModificationContextDetails;

/**
 * The details of a UI modification.
 */
@ApiModel(description = "The details of a UI modification.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class UiModificationDetails {
  @JsonProperty("contexts")
  private List<UiModificationContextDetails> contexts = new ArrayList<>();

  @JsonProperty("data")
  private String data;

  @JsonProperty("description")
  private String description;

  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("self")
  private String self;

   /**
   * List of contexts of the UI modification. The maximum number of contexts is 1000.
   * @return contexts
  **/
  @ApiModelProperty(value = "List of contexts of the UI modification. The maximum number of contexts is 1000.")
  public List<UiModificationContextDetails> getContexts() {
    return contexts;
  }

   /**
   * The data of the UI modification. The maximum size of the data is 50000 characters.
   * @return data
  **/
  @ApiModelProperty(value = "The data of the UI modification. The maximum size of the data is 50000 characters.")
  public String getData() {
    return data;
  }

   /**
   * The description of the UI modification. The maximum length is 255 characters.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the UI modification. The maximum length is 255 characters.")
  public String getDescription() {
    return description;
  }

   /**
   * The ID of the UI modification.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the UI modification.")
  public String getId() {
    return id;
  }

   /**
   * The name of the UI modification. The maximum length is 255 characters.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the UI modification. The maximum length is 255 characters.")
  public String getName() {
    return name;
  }

   /**
   * The URL of the UI modification.
   * @return self
  **/
  @ApiModelProperty(required = true, value = "The URL of the UI modification.")
  public String getSelf() {
    return self;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UiModificationDetails uiModificationDetails = (UiModificationDetails) o;
    return Objects.equals(this.contexts, uiModificationDetails.contexts) &&
        Objects.equals(this.data, uiModificationDetails.data) &&
        Objects.equals(this.description, uiModificationDetails.description) &&
        Objects.equals(this.id, uiModificationDetails.id) &&
        Objects.equals(this.name, uiModificationDetails.name) &&
        Objects.equals(this.self, uiModificationDetails.self);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contexts, data, description, id, name, self);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UiModificationDetails {\n");
    
    sb.append("    contexts: ").append(toIndentedString(contexts)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
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

