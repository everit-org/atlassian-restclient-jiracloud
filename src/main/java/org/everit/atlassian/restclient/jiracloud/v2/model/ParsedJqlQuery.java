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
import org.everit.atlassian.restclient.jiracloud.v2.model.JqlQuery;

/**
 * Details of a parsed JQL query.
 */
@ApiModel(description = "Details of a parsed JQL query.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:30.184+02:00[Europe/Prague]")
public class ParsedJqlQuery {
  @JsonProperty("query")
  private String query;

  @JsonProperty("structure")
  private JqlQuery structure;

  @JsonProperty("errors")
  private List<String> errors = new ArrayList<>();

  public ParsedJqlQuery query(String query) {
    this.query = query;
    return this;
  }

   /**
   * The JQL query that was parsed and validated.
   * @return query
  **/
  @ApiModelProperty(required = true, value = "The JQL query that was parsed and validated.")
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public ParsedJqlQuery structure(JqlQuery structure) {
    this.structure = structure;
    return this;
  }

   /**
   * The syntax tree of the query. Empty if the query was invalid.
   * @return structure
  **/
  @ApiModelProperty(value = "The syntax tree of the query. Empty if the query was invalid.")
  public JqlQuery getStructure() {
    return structure;
  }

  public void setStructure(JqlQuery structure) {
    this.structure = structure;
  }

  public ParsedJqlQuery errors(List<String> errors) {
    this.errors = errors;
    return this;
  }

  public ParsedJqlQuery addErrorsItem(String errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

   /**
   * The list of syntax or validation errors.
   * @return errors
  **/
  @ApiModelProperty(value = "The list of syntax or validation errors.")
  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParsedJqlQuery parsedJqlQuery = (ParsedJqlQuery) o;
    return Objects.equals(this.query, parsedJqlQuery.query) &&
        Objects.equals(this.structure, parsedJqlQuery.structure) &&
        Objects.equals(this.errors, parsedJqlQuery.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, structure, errors);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParsedJqlQuery {\n");
    
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    structure: ").append(toIndentedString(structure)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

