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

/**
 * RichText
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class RichText {
  @JsonProperty("empty")
  private Boolean empty;

  @JsonProperty("emptyAdf")
  private Boolean emptyAdf;

  @JsonProperty("finalised")
  private Boolean finalised;

  @JsonProperty("valueSet")
  private Boolean valueSet;

  public RichText empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

   /**
   * Get empty
   * @return empty
  **/
  @ApiModelProperty(value = "")
  public Boolean getEmpty() {
    return empty;
  }

  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }

  public RichText emptyAdf(Boolean emptyAdf) {
    this.emptyAdf = emptyAdf;
    return this;
  }

   /**
   * Get emptyAdf
   * @return emptyAdf
  **/
  @ApiModelProperty(value = "")
  public Boolean getEmptyAdf() {
    return emptyAdf;
  }

  public void setEmptyAdf(Boolean emptyAdf) {
    this.emptyAdf = emptyAdf;
  }

  public RichText finalised(Boolean finalised) {
    this.finalised = finalised;
    return this;
  }

   /**
   * Get finalised
   * @return finalised
  **/
  @ApiModelProperty(value = "")
  public Boolean getFinalised() {
    return finalised;
  }

  public void setFinalised(Boolean finalised) {
    this.finalised = finalised;
  }

  public RichText valueSet(Boolean valueSet) {
    this.valueSet = valueSet;
    return this;
  }

   /**
   * Get valueSet
   * @return valueSet
  **/
  @ApiModelProperty(value = "")
  public Boolean getValueSet() {
    return valueSet;
  }

  public void setValueSet(Boolean valueSet) {
    this.valueSet = valueSet;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RichText richText = (RichText) o;
    return Objects.equals(this.empty, richText.empty) &&
        Objects.equals(this.emptyAdf, richText.emptyAdf) &&
        Objects.equals(this.finalised, richText.finalised) &&
        Objects.equals(this.valueSet, richText.valueSet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empty, emptyAdf, finalised, valueSet);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RichText {\n");
    
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
    sb.append("    emptyAdf: ").append(toIndentedString(emptyAdf)).append("\n");
    sb.append("    finalised: ").append(toIndentedString(finalised)).append("\n");
    sb.append("    valueSet: ").append(toIndentedString(valueSet)).append("\n");
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

