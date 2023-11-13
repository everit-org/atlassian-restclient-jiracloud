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
 * Details of an issue type.
 */
@ApiModel(description = "Details of an issue type.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class IssueTypeInfo {
  @JsonProperty("avatarId")
  private Long avatarId;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

   /**
   * The avatar of the issue type.
   * @return avatarId
  **/
  @ApiModelProperty(value = "The avatar of the issue type.")
  public Long getAvatarId() {
    return avatarId;
  }

   /**
   * The ID of the issue type.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the issue type.")
  public Long getId() {
    return id;
  }

   /**
   * The name of the issue type.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the issue type.")
  public String getName() {
    return name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueTypeInfo issueTypeInfo = (IssueTypeInfo) o;
    return Objects.equals(this.avatarId, issueTypeInfo.avatarId) &&
        Objects.equals(this.id, issueTypeInfo.id) &&
        Objects.equals(this.name, issueTypeInfo.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(avatarId, id, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueTypeInfo {\n");
    
    sb.append("    avatarId: ").append(toIndentedString(avatarId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

