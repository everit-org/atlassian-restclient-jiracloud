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

/**
 * IdSearchRequestBean
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class IdSearchRequestBean {
  @JsonProperty("jql")
  private String jql;

  @JsonProperty("maxResults")
  private Integer maxResults = 1000;

  @JsonProperty("nextPageToken")
  private String nextPageToken;

  public IdSearchRequestBean jql(String jql) {
    this.jql = jql;
    return this;
  }

   /**
   * A [JQL](https://confluence.atlassian.com/x/egORLQ) expression. Order by clauses are not allowed.
   * @return jql
  **/
  @ApiModelProperty(value = "A [JQL](https://confluence.atlassian.com/x/egORLQ) expression. Order by clauses are not allowed.")
  public String getJql() {
    return jql;
  }

  public void setJql(String jql) {
    this.jql = jql;
  }

  public IdSearchRequestBean maxResults(Integer maxResults) {
    this.maxResults = maxResults;
    return this;
  }

   /**
   * The maximum number of items to return per page.
   * @return maxResults
  **/
  @ApiModelProperty(value = "The maximum number of items to return per page.")
  public Integer getMaxResults() {
    return maxResults;
  }

  public void setMaxResults(Integer maxResults) {
    this.maxResults = maxResults;
  }

  public IdSearchRequestBean nextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
    return this;
  }

   /**
   * The continuation token to fetch the next page. This token is provided by the response of this endpoint.
   * @return nextPageToken
  **/
  @ApiModelProperty(value = "The continuation token to fetch the next page. This token is provided by the response of this endpoint.")
  public String getNextPageToken() {
    return nextPageToken;
  }

  public void setNextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdSearchRequestBean idSearchRequestBean = (IdSearchRequestBean) o;
    return Objects.equals(this.jql, idSearchRequestBean.jql) &&
        Objects.equals(this.maxResults, idSearchRequestBean.maxResults) &&
        Objects.equals(this.nextPageToken, idSearchRequestBean.nextPageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jql, maxResults, nextPageToken);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdSearchRequestBean {\n");
    
    sb.append("    jql: ").append(toIndentedString(jql)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    nextPageToken: ").append(toIndentedString(nextPageToken)).append("\n");
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

