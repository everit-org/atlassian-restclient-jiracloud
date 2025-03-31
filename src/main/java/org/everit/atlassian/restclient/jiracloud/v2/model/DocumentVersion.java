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

/**
 * The current version details of this workflow scheme.
 */
@ApiModel(description = "The current version details of this workflow scheme.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class DocumentVersion {
  @JsonProperty("id")
  private String id;

  @JsonProperty("versionNumber")
  private Long versionNumber;

  public DocumentVersion id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The version UUID.
   * @return id
  **/
  @ApiModelProperty(value = "The version UUID.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DocumentVersion versionNumber(Long versionNumber) {
    this.versionNumber = versionNumber;
    return this;
  }

   /**
   * The version number.
   * @return versionNumber
  **/
  @ApiModelProperty(value = "The version number.")
  public Long getVersionNumber() {
    return versionNumber;
  }

  public void setVersionNumber(Long versionNumber) {
    this.versionNumber = versionNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentVersion documentVersion = (DocumentVersion) o;
    return Objects.equals(this.id, documentVersion.id) &&
        Objects.equals(this.versionNumber, documentVersion.versionNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, versionNumber);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentVersion {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    versionNumber: ").append(toIndentedString(versionNumber)).append("\n");
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

