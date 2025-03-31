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
import java.net.URI;

/**
 * Associated related work to a version
 */
@ApiModel(description = "Associated related work to a version")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class VersionRelatedWork {
  @JsonProperty("category")
  private String category;

  @JsonProperty("issueId")
  private Long issueId;

  @JsonProperty("relatedWorkId")
  private String relatedWorkId;

  @JsonProperty("title")
  private String title;

  @JsonProperty("url")
  private URI url;

  public VersionRelatedWork category(String category) {
    this.category = category;
    return this;
  }

   /**
   * The category of the related work
   * @return category
  **/
  @ApiModelProperty(required = true, value = "The category of the related work")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

   /**
   * The ID of the issue associated with the related work (if there is one). Cannot be updated via the Rest API.
   * @return issueId
  **/
  @ApiModelProperty(value = "The ID of the issue associated with the related work (if there is one). Cannot be updated via the Rest API.")
  public Long getIssueId() {
    return issueId;
  }

   /**
   * The id of the related work. For the native release note related work item, this will be null, and Rest API does not support updating it.
   * @return relatedWorkId
  **/
  @ApiModelProperty(value = "The id of the related work. For the native release note related work item, this will be null, and Rest API does not support updating it.")
  public String getRelatedWorkId() {
    return relatedWorkId;
  }

  public VersionRelatedWork title(String title) {
    this.title = title;
    return this;
  }

   /**
   * The title of the related work
   * @return title
  **/
  @ApiModelProperty(value = "The title of the related work")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public VersionRelatedWork url(URI url) {
    this.url = url;
    return this;
  }

   /**
   * The URL of the related work. Will be null for the native release note related work item, but is otherwise required.
   * @return url
  **/
  @ApiModelProperty(value = "The URL of the related work. Will be null for the native release note related work item, but is otherwise required.")
  public URI getUrl() {
    return url;
  }

  public void setUrl(URI url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionRelatedWork versionRelatedWork = (VersionRelatedWork) o;
    return Objects.equals(this.category, versionRelatedWork.category) &&
        Objects.equals(this.issueId, versionRelatedWork.issueId) &&
        Objects.equals(this.relatedWorkId, versionRelatedWork.relatedWorkId) &&
        Objects.equals(this.title, versionRelatedWork.title) &&
        Objects.equals(this.url, versionRelatedWork.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, issueId, relatedWorkId, title, url);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionRelatedWork {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    issueId: ").append(toIndentedString(issueId)).append("\n");
    sb.append("    relatedWorkId: ").append(toIndentedString(relatedWorkId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

