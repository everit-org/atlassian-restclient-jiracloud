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
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.FunctionOperand;
import org.everit.atlassian.restclient.jiracloud.v2.model.KeywordOperand;
import org.everit.atlassian.restclient.jiracloud.v2.model.ValueOperand;

/**
 * An operand that can be part of a list operand.
 */
@ApiModel(description = "An operand that can be part of a list operand.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:56:58.037+02:00[Europe/Prague]")
public class JqlQueryUnitaryOperand {
  @JsonProperty("value")
  private String value;

  @JsonProperty("function")
  private String function;

  @JsonProperty("arguments")
  private List<String> arguments = new ArrayList<>();

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

  public JqlQueryUnitaryOperand arguments(List<String> arguments) {
    this.arguments = arguments;
    return this;
  }

  public JqlQueryUnitaryOperand addArgumentsItem(String argumentsItem) {
    if (this.arguments == null) {
      this.arguments = new ArrayList<>();
    }
    this.arguments.add(argumentsItem);
    return this;
  }

   /**
   * The list of function arguments.
   * @return arguments
  **/
  @ApiModelProperty(value = "The list of function arguments.")
  public List<String> getArguments() {
    return arguments;
  }

  public void setArguments(List<String> arguments) {
    this.arguments = arguments;
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
    return Objects.equals(this.value, jqlQueryUnitaryOperand.value) &&
        Objects.equals(this.function, jqlQueryUnitaryOperand.function) &&
        Objects.equals(this.arguments, jqlQueryUnitaryOperand.arguments) &&
        Objects.equals(this.keyword, jqlQueryUnitaryOperand.keyword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, function, arguments, keyword);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JqlQueryUnitaryOperand {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    function: ").append(toIndentedString(function)).append("\n");
    sb.append("    arguments: ").append(toIndentedString(arguments)).append("\n");
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

