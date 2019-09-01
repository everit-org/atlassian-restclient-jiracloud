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
 * Details about the replacement for a deleted version.
 */
@ApiModel(description = "Details about the replacement for a deleted version.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:56:58.037+02:00[Europe/Prague]")
public class CustomFieldReplacement {
  @JsonProperty("customFieldId")
  private Long customFieldId;

  @JsonProperty("moveTo")
  private Long moveTo;

  public CustomFieldReplacement customFieldId(Long customFieldId) {
    this.customFieldId = customFieldId;
    return this;
  }

   /**
   * The ID of the custom field in which to replace the version number.
   * @return customFieldId
  **/
  @ApiModelProperty(value = "The ID of the custom field in which to replace the version number.")
  public Long getCustomFieldId() {
    return customFieldId;
  }

  public void setCustomFieldId(Long customFieldId) {
    this.customFieldId = customFieldId;
  }

  public CustomFieldReplacement moveTo(Long moveTo) {
    this.moveTo = moveTo;
    return this;
  }

   /**
   * The version number to use as a replacement for the deleted version.
   * @return moveTo
  **/
  @ApiModelProperty(value = "The version number to use as a replacement for the deleted version.")
  public Long getMoveTo() {
    return moveTo;
  }

  public void setMoveTo(Long moveTo) {
    this.moveTo = moveTo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomFieldReplacement customFieldReplacement = (CustomFieldReplacement) o;
    return Objects.equals(this.customFieldId, customFieldReplacement.customFieldId) &&
        Objects.equals(this.moveTo, customFieldReplacement.moveTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customFieldId, moveTo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldReplacement {\n");
    sb.append("    customFieldId: ").append(toIndentedString(customFieldId)).append("\n");
    sb.append("    moveTo: ").append(toIndentedString(moveTo)).append("\n");
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

