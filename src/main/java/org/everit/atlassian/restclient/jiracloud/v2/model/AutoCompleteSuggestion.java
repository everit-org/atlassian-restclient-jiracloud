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
 * A field auto-complete suggestion.
 */
@ApiModel(description = "A field auto-complete suggestion.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:56:58.037+02:00[Europe/Prague]")
public class AutoCompleteSuggestion {
  @JsonProperty("value")
  private String value;

  @JsonProperty("displayName")
  private String displayName;

  public AutoCompleteSuggestion value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The value of a suggested item.
   * @return value
  **/
  @ApiModelProperty(value = "The value of a suggested item.")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public AutoCompleteSuggestion displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * The display name of a suggested item. If &#x60;fieldValue&#x60; or &#x60;predicateValue&#x60; are provided, the matching text is highlighted with the HTML bold tag.
   * @return displayName
  **/
  @ApiModelProperty(value = "The display name of a suggested item. If `fieldValue` or `predicateValue` are provided, the matching text is highlighted with the HTML bold tag.")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AutoCompleteSuggestion autoCompleteSuggestion = (AutoCompleteSuggestion) o;
    return Objects.equals(this.value, autoCompleteSuggestion.value) &&
        Objects.equals(this.displayName, autoCompleteSuggestion.displayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, displayName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AutoCompleteSuggestion {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
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

