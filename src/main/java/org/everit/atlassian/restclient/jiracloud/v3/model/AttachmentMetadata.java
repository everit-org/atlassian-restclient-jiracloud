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
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v3.model.User;

/**
 * Metadata for an issue attachment.
 */
@ApiModel(description = "Metadata for an issue attachment.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:57:05.408+02:00[Europe/Prague]")
public class AttachmentMetadata {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("self")
  private URI self;

  @JsonProperty("filename")
  private String filename;

  @JsonProperty("author")
  private User author;

  @JsonProperty("created")
  private OffsetDateTime created;

  @JsonProperty("size")
  private Long size;

  @JsonProperty("mimeType")
  private String mimeType;

  @JsonProperty("properties")
  private Map<String, Object> properties = new HashMap<>();

  @JsonProperty("content")
  private String content;

  @JsonProperty("thumbnail")
  private String thumbnail;

   /**
   * The ID of the attachment.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the attachment.")
  public Long getId() {
    return id;
  }

   /**
   * The URL of the attachment metadata details.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the attachment metadata details.")
  public URI getSelf() {
    return self;
  }

   /**
   * The name of the attachment file.
   * @return filename
  **/
  @ApiModelProperty(value = "The name of the attachment file.")
  public String getFilename() {
    return filename;
  }

   /**
   * Details of the user who attached the file.
   * @return author
  **/
  @ApiModelProperty(value = "Details of the user who attached the file.")
  public User getAuthor() {
    return author;
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
   * The size of the attachment.
   * @return size
  **/
  @ApiModelProperty(value = "The size of the attachment.")
  public Long getSize() {
    return size;
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
   * Additional properties of the attachment.
   * @return properties
  **/
  @ApiModelProperty(value = "Additional properties of the attachment.")
  public Map<String, Object> getProperties() {
    return properties;
  }

   /**
   * The URL of the attachment.
   * @return content
  **/
  @ApiModelProperty(value = "The URL of the attachment.")
  public String getContent() {
    return content;
  }

   /**
   * The URL of a thumbnail representing the attachment.
   * @return thumbnail
  **/
  @ApiModelProperty(value = "The URL of a thumbnail representing the attachment.")
  public String getThumbnail() {
    return thumbnail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachmentMetadata attachmentMetadata = (AttachmentMetadata) o;
    return Objects.equals(this.id, attachmentMetadata.id) &&
        Objects.equals(this.self, attachmentMetadata.self) &&
        Objects.equals(this.filename, attachmentMetadata.filename) &&
        Objects.equals(this.author, attachmentMetadata.author) &&
        Objects.equals(this.created, attachmentMetadata.created) &&
        Objects.equals(this.size, attachmentMetadata.size) &&
        Objects.equals(this.mimeType, attachmentMetadata.mimeType) &&
        Objects.equals(this.properties, attachmentMetadata.properties) &&
        Objects.equals(this.content, attachmentMetadata.content) &&
        Objects.equals(this.thumbnail, attachmentMetadata.thumbnail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, self, filename, author, created, size, mimeType, properties, content, thumbnail);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentMetadata {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
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

