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
import java.util.HashMap;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v2.model.Icon;
import org.everit.atlassian.restclient.jiracloud.v2.model.Status;

/**
 * The linked item.
 */
@ApiModel(description = "The linked item.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class RemoteObject {
  @JsonProperty("icon")
  private Icon icon;

  @JsonProperty("status")
  private Status status;

  @JsonProperty("summary")
  private String summary;

  @JsonProperty("title")
  private String title;

  @JsonProperty("url")
  private String url;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public RemoteObject icon(Icon icon) {
    this.icon = icon;
    return this;
  }

   /**
   * Details of the icon for the item. If no icon is defined, the default link icon is used in Jira.
   * @return icon
  **/
  @ApiModelProperty(value = "Details of the icon for the item. If no icon is defined, the default link icon is used in Jira.")
  public Icon getIcon() {
    return icon;
  }

  public void setIcon(Icon icon) {
    this.icon = icon;
  }

  public RemoteObject status(Status status) {
    this.status = status;
    return this;
  }

   /**
   * The status of the item.
   * @return status
  **/
  @ApiModelProperty(value = "The status of the item.")
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public RemoteObject summary(String summary) {
    this.summary = summary;
    return this;
  }

   /**
   * The summary details of the item.
   * @return summary
  **/
  @ApiModelProperty(value = "The summary details of the item.")
  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public RemoteObject title(String title) {
    this.title = title;
    return this;
  }

   /**
   * The title of the item.
   * @return title
  **/
  @ApiModelProperty(required = true, value = "The title of the item.")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public RemoteObject url(String url) {
    this.url = url;
    return this;
  }

   /**
   * The URL of the item.
   * @return url
  **/
  @ApiModelProperty(required = true, value = "The URL of the item.")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @com.fasterxml.jackson.annotation.JsonAnyGetter
  public Map<String, Object> any() {
   return this.additionalProperties_;
  }

  @com.fasterxml.jackson.annotation.JsonAnySetter
  public void set(String name, Object value) {
   this.additionalProperties_.put(name, value);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RemoteObject remoteObject = (RemoteObject) o;
    return Objects.equals(this.icon, remoteObject.icon) &&
        Objects.equals(this.status, remoteObject.status) &&
        Objects.equals(this.summary, remoteObject.summary) &&
        Objects.equals(this.title, remoteObject.title) &&
        Objects.equals(this.url, remoteObject.url) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(icon, status, summary, title, url, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RemoteObject {\n");
    
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties_)).append("\n");
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

