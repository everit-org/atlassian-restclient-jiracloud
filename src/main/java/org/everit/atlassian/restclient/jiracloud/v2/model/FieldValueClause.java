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
import org.everit.atlassian.restclient.jiracloud.v2.model.JqlQueryClauseOperand;
import org.everit.atlassian.restclient.jiracloud.v2.model.JqlQueryField;

/**
 * A clause that asserts the current value of a field. For example, &#x60;summary ~ test&#x60;.
 */
@ApiModel(description = "A clause that asserts the current value of a field. For example, `summary ~ test`.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class FieldValueClause {
  @JsonProperty("field")
  private JqlQueryField field;

  @JsonProperty("operand")
  private JqlQueryClauseOperand operand;

  /**
   * The operator between the field and operand.
   */
  public enum OperatorEnum {
    EQUAL("="),
    
    NOT_EQUAL("!="),
    
    GREATER_THAN(">"),
    
    LESS_THAN("<"),
    
    GREATER_THAN_OR_EQUAL_TO(">="),
    
    LESS_THAN_OR_EQUAL_TO("<="),
    
    IN("in"),
    
    NOT_IN("not in"),
    
    TILDE("~"),
    
    _("~="),
    
    IS("is"),
    
    IS_NOT("is not");

    private String value;

    OperatorEnum(String value) {
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
    public static OperatorEnum fromValue(String value) {
      for (OperatorEnum b : OperatorEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("operator")
  private OperatorEnum operator;

  public FieldValueClause field(JqlQueryField field) {
    this.field = field;
    return this;
  }

   /**
   * Get field
   * @return field
  **/
  @ApiModelProperty(required = true, value = "")
  public JqlQueryField getField() {
    return field;
  }

  public void setField(JqlQueryField field) {
    this.field = field;
  }

  public FieldValueClause operand(JqlQueryClauseOperand operand) {
    this.operand = operand;
    return this;
  }

   /**
   * Get operand
   * @return operand
  **/
  @ApiModelProperty(required = true, value = "")
  public JqlQueryClauseOperand getOperand() {
    return operand;
  }

  public void setOperand(JqlQueryClauseOperand operand) {
    this.operand = operand;
  }

  public FieldValueClause operator(OperatorEnum operator) {
    this.operator = operator;
    return this;
  }

   /**
   * The operator between the field and operand.
   * @return operator
  **/
  @ApiModelProperty(required = true, value = "The operator between the field and operand.")
  public OperatorEnum getOperator() {
    return operator;
  }

  public void setOperator(OperatorEnum operator) {
    this.operator = operator;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldValueClause fieldValueClause = (FieldValueClause) o;
    return Objects.equals(this.field, fieldValueClause.field) &&
        Objects.equals(this.operand, fieldValueClause.operand) &&
        Objects.equals(this.operator, fieldValueClause.operator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, operand, operator);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldValueClause {\n");
    
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    operand: ").append(toIndentedString(operand)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
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

