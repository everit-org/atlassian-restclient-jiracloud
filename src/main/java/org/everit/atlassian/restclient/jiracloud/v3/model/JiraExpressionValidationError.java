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
 * Details about syntax and type errors. The error details apply to the entire expression, unless the object includes:   *  &#x60;line&#x60; and &#x60;column&#x60;  *  &#x60;expression&#x60;
 */
@ApiModel(description = "Details about syntax and type errors. The error details apply to the entire expression, unless the object includes:   *  `line` and `column`  *  `expression`")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class JiraExpressionValidationError {
  @JsonProperty("column")
  private Integer column;

  @JsonProperty("expression")
  private String expression;

  @JsonProperty("line")
  private Integer line;

  @JsonProperty("message")
  private String message;

  /**
   * The error type.
   */
  public enum TypeEnum {
    SYNTAX("syntax"),
    
    TYPE("type"),
    
    OTHER("other");

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
  private TypeEnum type;

  public JiraExpressionValidationError column(Integer column) {
    this.column = column;
    return this;
  }

   /**
   * The text column in which the error occurred.
   * @return column
  **/
  @ApiModelProperty(value = "The text column in which the error occurred.")
  public Integer getColumn() {
    return column;
  }

  public void setColumn(Integer column) {
    this.column = column;
  }

  public JiraExpressionValidationError expression(String expression) {
    this.expression = expression;
    return this;
  }

   /**
   * The part of the expression in which the error occurred.
   * @return expression
  **/
  @ApiModelProperty(value = "The part of the expression in which the error occurred.")
  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public JiraExpressionValidationError line(Integer line) {
    this.line = line;
    return this;
  }

   /**
   * The text line in which the error occurred.
   * @return line
  **/
  @ApiModelProperty(value = "The text line in which the error occurred.")
  public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public JiraExpressionValidationError message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Details about the error.
   * @return message
  **/
  @ApiModelProperty(example = "!, -, typeof, (, IDENTIFIER, null, true, false, NUMBER, STRING, TEMPLATE_LITERAL, new, [ or { expected, > encountered.", required = true, value = "Details about the error.")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public JiraExpressionValidationError type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The error type.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The error type.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JiraExpressionValidationError jiraExpressionValidationError = (JiraExpressionValidationError) o;
    return Objects.equals(this.column, jiraExpressionValidationError.column) &&
        Objects.equals(this.expression, jiraExpressionValidationError.expression) &&
        Objects.equals(this.line, jiraExpressionValidationError.line) &&
        Objects.equals(this.message, jiraExpressionValidationError.message) &&
        Objects.equals(this.type, jiraExpressionValidationError.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(column, expression, line, message, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JiraExpressionValidationError {\n");
    
    sb.append("    column: ").append(toIndentedString(column)).append("\n");
    sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

