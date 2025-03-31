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
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueFilterForBulkPropertySet;

/**
 * Bulk issue property update request details.
 */
@ApiModel(description = "Bulk issue property update request details.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class BulkIssuePropertyUpdateRequest {
  @JsonProperty("expression")
  private String expression;

  @JsonProperty("filter")
  private IssueFilterForBulkPropertySet filter;

  @JsonProperty("value")
  private Object value = null;

  public BulkIssuePropertyUpdateRequest expression(String expression) {
    this.expression = expression;
    return this;
  }

   /**
   * EXPERIMENTAL. The Jira expression to calculate the value of the property. The value of the expression must be an object that can be converted to JSON, such as a number, boolean, string, list, or map. The context variables available to the expression are &#x60;issue&#x60; and &#x60;user&#x60;. Issues for which the expression returns a value whose JSON representation is longer than 32768 characters are ignored.
   * @return expression
  **/
  @ApiModelProperty(value = "EXPERIMENTAL. The Jira expression to calculate the value of the property. The value of the expression must be an object that can be converted to JSON, such as a number, boolean, string, list, or map. The context variables available to the expression are `issue` and `user`. Issues for which the expression returns a value whose JSON representation is longer than 32768 characters are ignored.")
  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public BulkIssuePropertyUpdateRequest filter(IssueFilterForBulkPropertySet filter) {
    this.filter = filter;
    return this;
  }

   /**
   * The bulk operation filter.
   * @return filter
  **/
  @ApiModelProperty(value = "The bulk operation filter.")
  public IssueFilterForBulkPropertySet getFilter() {
    return filter;
  }

  public void setFilter(IssueFilterForBulkPropertySet filter) {
    this.filter = filter;
  }

  public BulkIssuePropertyUpdateRequest value(Object value) {
    this.value = value;
    return this;
  }

   /**
   * The value of the property. The value must be a [valid](https://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.
   * @return value
  **/
  @ApiModelProperty(value = "The value of the property. The value must be a [valid](https://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.")
  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
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
    BulkIssuePropertyUpdateRequest bulkIssuePropertyUpdateRequest = (BulkIssuePropertyUpdateRequest) o;
    return Objects.equals(this.expression, bulkIssuePropertyUpdateRequest.expression) &&
        Objects.equals(this.filter, bulkIssuePropertyUpdateRequest.filter) &&
        Objects.equals(this.value, bulkIssuePropertyUpdateRequest.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expression, filter, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkIssuePropertyUpdateRequest {\n");
    
    sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
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

