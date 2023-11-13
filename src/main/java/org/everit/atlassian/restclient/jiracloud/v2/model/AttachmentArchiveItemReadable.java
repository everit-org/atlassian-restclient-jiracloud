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


package org.everit.atlassian.restclient.jiracloud.v2.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Metadata for an item in an attachment archive.
 */
@ApiModel(description = "Metadata for an item in an attachment archive.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class AttachmentArchiveItemReadable {
  @JsonProperty("index")
  private Long index;

  @JsonProperty("label")
  private String label;

  @JsonProperty("mediaType")
  private String mediaType;

  @JsonProperty("path")
  private String path;

  @JsonProperty("size")
  private String size;

   /**
   * The position of the item within the archive.
   * @return index
  **/
  @ApiModelProperty(value = "The position of the item within the archive.")
  public Long getIndex() {
    return index;
  }

   /**
   * The label for the archive item.
   * @return label
  **/
  @ApiModelProperty(value = "The label for the archive item.")
  public String getLabel() {
    return label;
  }

   /**
   * The MIME type of the archive item.
   * @return mediaType
  **/
  @ApiModelProperty(value = "The MIME type of the archive item.")
  public String getMediaType() {
    return mediaType;
  }

   /**
   * The path of the archive item.
   * @return path
  **/
  @ApiModelProperty(value = "The path of the archive item.")
  public String getPath() {
    return path;
  }

   /**
   * The size of the archive item.
   * @return size
  **/
  @ApiModelProperty(value = "The size of the archive item.")
  public String getSize() {
    return size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachmentArchiveItemReadable attachmentArchiveItemReadable = (AttachmentArchiveItemReadable) o;
    return Objects.equals(this.index, attachmentArchiveItemReadable.index) &&
        Objects.equals(this.label, attachmentArchiveItemReadable.label) &&
        Objects.equals(this.mediaType, attachmentArchiveItemReadable.mediaType) &&
        Objects.equals(this.path, attachmentArchiveItemReadable.path) &&
        Objects.equals(this.size, attachmentArchiveItemReadable.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, label, mediaType, path, size);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentArchiveItemReadable {\n");
    
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    mediaType: ").append(toIndentedString(mediaType)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

