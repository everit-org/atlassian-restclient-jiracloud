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


package org.everit.atlassian.restclient.jiracloud.v3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.everit.atlassian.restclient.jiracloud.v3.model.JqlQueryOrderByClause;

/**
 * A parsed JQL query.
 */
@ApiModel(description = "A parsed JQL query.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:57:05.408+02:00[Europe/Prague]")
public class JqlQuery {
  @JsonProperty("where")
  private Object where = null;

  @JsonProperty("orderBy")
  private JqlQueryOrderByClause orderBy;

  public JqlQuery where(Object where) {
    this.where = where;
    return this;
  }

   /**
   * A JQL query clause.
   * @return where
  **/
  @ApiModelProperty(value = "A JQL query clause.")
  public Object getWhere() {
    return where;
  }

  public void setWhere(Object where) {
    this.where = where;
  }

  public JqlQuery orderBy(JqlQueryOrderByClause orderBy) {
    this.orderBy = orderBy;
    return this;
  }

   /**
   * Get orderBy
   * @return orderBy
  **/
  @ApiModelProperty(value = "")
  public JqlQueryOrderByClause getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(JqlQueryOrderByClause orderBy) {
    this.orderBy = orderBy;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JqlQuery jqlQuery = (JqlQuery) o;
    return Objects.equals(this.where, jqlQuery.where) &&
        Objects.equals(this.orderBy, jqlQuery.orderBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(where, orderBy);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JqlQuery {\n");
    sb.append("    where: ").append(toIndentedString(where)).append("\n");
    sb.append("    orderBy: ").append(toIndentedString(orderBy)).append("\n");
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

