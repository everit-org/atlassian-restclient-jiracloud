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
import java.net.URI;
import org.everit.atlassian.restclient.jiracloud.v3.model.Fields;

/**
 * The ID or key of a linked issue.
 */
@ApiModel(description = "The ID or key of a linked issue.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class LinkedIssue {
  @JsonProperty("fields")
  private Fields fields;

  @JsonProperty("id")
  private String id;

  @JsonProperty("key")
  private String key;

  @JsonProperty("self")
  private URI self;

   /**
   * The fields associated with the issue.
   * @return fields
  **/
  @ApiModelProperty(value = "The fields associated with the issue.")
  public Fields getFields() {
    return fields;
  }

  public LinkedIssue id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of an issue. Required if &#x60;key&#x60; isn&#39;t provided.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of an issue. Required if `key` isn't provided.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LinkedIssue key(String key) {
    this.key = key;
    return this;
  }

   /**
   * The key of an issue. Required if &#x60;id&#x60; isn&#39;t provided.
   * @return key
  **/
  @ApiModelProperty(value = "The key of an issue. Required if `id` isn't provided.")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

   /**
   * The URL of the issue.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the issue.")
  public URI getSelf() {
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
    LinkedIssue linkedIssue = (LinkedIssue) o;
    return Objects.equals(this.fields, linkedIssue.fields) &&
        Objects.equals(this.id, linkedIssue.id) &&
        Objects.equals(this.key, linkedIssue.key) &&
        Objects.equals(this.self, linkedIssue.self);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fields, id, key, self);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinkedIssue {\n");
    
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
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

