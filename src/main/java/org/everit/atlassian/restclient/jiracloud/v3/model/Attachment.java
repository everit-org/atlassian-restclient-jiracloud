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
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v3.model.UserDetails;

/**
 * Details about an attachment.
 */
@ApiModel(description = "Details about an attachment.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class Attachment {
  @JsonProperty("author")
  private UserDetails author;

  @JsonProperty("content")
  private String content;

  @JsonProperty("created")
  private OffsetDateTime created;

  @JsonProperty("filename")
  private String filename;

  @JsonProperty("id")
  private String id;

  @JsonProperty("mimeType")
  private String mimeType;

  @JsonProperty("self")
  private String self;

  @JsonProperty("size")
  private Long size;

  @JsonProperty("thumbnail")
  private String thumbnail;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

   /**
   * Details of the user who added the attachment.
   * @return author
  **/
  @ApiModelProperty(value = "Details of the user who added the attachment.")
  public UserDetails getAuthor() {
    return author;
  }

   /**
   * The content of the attachment.
   * @return content
  **/
  @ApiModelProperty(value = "The content of the attachment.")
  public String getContent() {
    return content;
  }

   /**
   * The datetime the attachment was created.
   * @return created
  **/
  @ApiModelProperty(value = "The datetime the attachment was created.")
  public OffsetDateTime getCreated() {
    return created;
  }

   /**
   * The file name of the attachment.
   * @return filename
  **/
  @ApiModelProperty(value = "The file name of the attachment.")
  public String getFilename() {
    return filename;
  }

   /**
   * The ID of the attachment.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the attachment.")
  public String getId() {
    return id;
  }

   /**
   * The MIME type of the attachment.
   * @return mimeType
  **/
  @ApiModelProperty(value = "The MIME type of the attachment.")
  public String getMimeType() {
    return mimeType;
  }

   /**
   * The URL of the attachment details response.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the attachment details response.")
  public String getSelf() {
    return self;
  }

   /**
   * The size of the attachment.
   * @return size
  **/
  @ApiModelProperty(value = "The size of the attachment.")
  public Long getSize() {
    return size;
  }

   /**
   * The URL of a thumbnail representing the attachment.
   * @return thumbnail
  **/
  @ApiModelProperty(value = "The URL of a thumbnail representing the attachment.")
  public String getThumbnail() {
    return thumbnail;
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
    Attachment attachment = (Attachment) o;
    return Objects.equals(this.author, attachment.author) &&
        Objects.equals(this.content, attachment.content) &&
        Objects.equals(this.created, attachment.created) &&
        Objects.equals(this.filename, attachment.filename) &&
        Objects.equals(this.id, attachment.id) &&
        Objects.equals(this.mimeType, attachment.mimeType) &&
        Objects.equals(this.self, attachment.self) &&
        Objects.equals(this.size, attachment.size) &&
        Objects.equals(this.thumbnail, attachment.thumbnail) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(author, content, created, filename, id, mimeType, self, size, thumbnail, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");
    
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
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

