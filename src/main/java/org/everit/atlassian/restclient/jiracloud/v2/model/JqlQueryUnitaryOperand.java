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
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.FunctionOperand;
import org.everit.atlassian.restclient.jiracloud.v2.model.KeywordOperand;
import org.everit.atlassian.restclient.jiracloud.v2.model.ValueOperand;

/**
 * An operand that can be part of a list operand.
 */
@ApiModel(description = "An operand that can be part of a list operand.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class JqlQueryUnitaryOperand {
  @JsonProperty("encodedValue")
  private String encodedValue;

  @JsonProperty("value")
  private String value;

  @JsonProperty("arguments")
  private List<String> arguments = new ArrayList<>();

  @JsonProperty("encodedOperand")
  private String encodedOperand;

  @JsonProperty("function")
  private String function;

  /**
   * The keyword that is the operand value.
   */
  public enum KeywordEnum {
    EMPTY("empty");

    private String value;

    KeywordEnum(String value) {
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
    public static KeywordEnum fromValue(String value) {
      for (KeywordEnum b : KeywordEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("keyword")
  private KeywordEnum keyword;

  public JqlQueryUnitaryOperand encodedValue(String encodedValue) {
    this.encodedValue = encodedValue;
    return this;
  }

   /**
   * Encoded value, which can be used directly in a JQL query.
   * @return encodedValue
  **/
  @ApiModelProperty(value = "Encoded value, which can be used directly in a JQL query.")
  public String getEncodedValue() {
    return encodedValue;
  }

  public void setEncodedValue(String encodedValue) {
    this.encodedValue = encodedValue;
  }

  public JqlQueryUnitaryOperand value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The operand value.
   * @return value
  **/
  @ApiModelProperty(required = true, value = "The operand value.")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public JqlQueryUnitaryOperand arguments(List<String> arguments) {
    this.arguments = arguments;
    return this;
  }

  public JqlQueryUnitaryOperand addArgumentsItem(String argumentsItem) {
    this.arguments.add(argumentsItem);
    return this;
  }

   /**
   * The list of function arguments.
   * @return arguments
  **/
  @ApiModelProperty(required = true, value = "The list of function arguments.")
  public List<String> getArguments() {
    return arguments;
  }

  public void setArguments(List<String> arguments) {
    this.arguments = arguments;
  }

  public JqlQueryUnitaryOperand encodedOperand(String encodedOperand) {
    this.encodedOperand = encodedOperand;
    return this;
  }

   /**
   * Encoded operand, which can be used directly in a JQL query.
   * @return encodedOperand
  **/
  @ApiModelProperty(value = "Encoded operand, which can be used directly in a JQL query.")
  public String getEncodedOperand() {
    return encodedOperand;
  }

  public void setEncodedOperand(String encodedOperand) {
    this.encodedOperand = encodedOperand;
  }

  public JqlQueryUnitaryOperand function(String function) {
    this.function = function;
    return this;
  }

   /**
   * The name of the function.
   * @return function
  **/
  @ApiModelProperty(required = true, value = "The name of the function.")
  public String getFunction() {
    return function;
  }

  public void setFunction(String function) {
    this.function = function;
  }

  public JqlQueryUnitaryOperand keyword(KeywordEnum keyword) {
    this.keyword = keyword;
    return this;
  }

   /**
   * The keyword that is the operand value.
   * @return keyword
  **/
  @ApiModelProperty(required = true, value = "The keyword that is the operand value.")
  public KeywordEnum getKeyword() {
    return keyword;
  }

  public void setKeyword(KeywordEnum keyword) {
    this.keyword = keyword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JqlQueryUnitaryOperand jqlQueryUnitaryOperand = (JqlQueryUnitaryOperand) o;
    return Objects.equals(this.encodedValue, jqlQueryUnitaryOperand.encodedValue) &&
        Objects.equals(this.value, jqlQueryUnitaryOperand.value) &&
        Objects.equals(this.arguments, jqlQueryUnitaryOperand.arguments) &&
        Objects.equals(this.encodedOperand, jqlQueryUnitaryOperand.encodedOperand) &&
        Objects.equals(this.function, jqlQueryUnitaryOperand.function) &&
        Objects.equals(this.keyword, jqlQueryUnitaryOperand.keyword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encodedValue, value, arguments, encodedOperand, function, keyword);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JqlQueryUnitaryOperand {\n");
    
    sb.append("    encodedValue: ").append(toIndentedString(encodedValue)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    arguments: ").append(toIndentedString(arguments)).append("\n");
    sb.append("    encodedOperand: ").append(toIndentedString(encodedOperand)).append("\n");
    sb.append("    function: ").append(toIndentedString(function)).append("\n");
    sb.append("    keyword: ").append(toIndentedString(keyword)).append("\n");
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

