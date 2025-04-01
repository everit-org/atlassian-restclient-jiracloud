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
import java.util.ArrayList;
import java.util.List;

/**
 * List of string of inputs
 */
@ApiModel(description = "List of string of inputs")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class MandatoryFieldValue {
  @JsonProperty("retain")
  private Boolean retain = true;

  /**
   * Will treat as &#x60;MandatoryFieldValue&#x60; if type is &#x60;raw&#x60; or &#x60;empty&#x60;
   */
  public enum TypeEnum {
    ADF("adf"),
    
    RAW("raw");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type = TypeEnum.RAW;

  @JsonProperty("value")
  private List<String> value = new ArrayList<>();

  public MandatoryFieldValue retain(Boolean retain) {
    this.retain = retain;
    return this;
  }

   /**
   * If &#x60;true&#x60;, will try to retain original non-null issue field values on move.
   * @return retain
  **/
  @ApiModelProperty(value = "If `true`, will try to retain original non-null issue field values on move.")
  public Boolean getRetain() {
    return retain;
  }

  public void setRetain(Boolean retain) {
    this.retain = retain;
  }

  public MandatoryFieldValue type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Will treat as &#x60;MandatoryFieldValue&#x60; if type is &#x60;raw&#x60; or &#x60;empty&#x60;
   * @return type
  **/
  @ApiModelProperty(value = "Will treat as `MandatoryFieldValue` if type is `raw` or `empty`")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public MandatoryFieldValue value(List<String> value) {
    this.value = value;
    return this;
  }

  public MandatoryFieldValue addValueItem(String valueItem) {
    this.value.add(valueItem);
    return this;
  }

   /**
   * Value for each field. Provide a &#x60;list of strings&#x60; for non-ADF fields.
   * @return value
  **/
  @ApiModelProperty(required = true, value = "Value for each field. Provide a `list of strings` for non-ADF fields.")
  public List<String> getValue() {
    return value;
  }

  public void setValue(List<String> value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MandatoryFieldValue mandatoryFieldValue = (MandatoryFieldValue) o;
    return Objects.equals(this.retain, mandatoryFieldValue.retain) &&
        Objects.equals(this.type, mandatoryFieldValue.type) &&
        Objects.equals(this.value, mandatoryFieldValue.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(retain, type, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MandatoryFieldValue {\n");
    
    sb.append("    retain: ").append(toIndentedString(retain)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

