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
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.SecurityLevelMember;

/**
 * A page of items.
 */
@ApiModel(description = "A page of items.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class PageBeanSecurityLevelMember {
  @JsonProperty("isLast")
  private Boolean isLast;

  @JsonProperty("maxResults")
  private Integer maxResults;

  @JsonProperty("nextPage")
  private URI nextPage;

  @JsonProperty("self")
  private URI self;

  @JsonProperty("startAt")
  private Long startAt;

  @JsonProperty("total")
  private Long total;

  @JsonProperty("values")
  private List<SecurityLevelMember> values = new ArrayList<>();

   /**
   * Whether this is the last page.
   * @return isLast
  **/
  @ApiModelProperty(value = "Whether this is the last page.")
  public Boolean getIsLast() {
    return isLast;
  }

   /**
   * The maximum number of items that could be returned.
   * @return maxResults
  **/
  @ApiModelProperty(value = "The maximum number of items that could be returned.")
  public Integer getMaxResults() {
    return maxResults;
  }

   /**
   * If there is another page of results, the URL of the next page.
   * @return nextPage
  **/
  @ApiModelProperty(value = "If there is another page of results, the URL of the next page.")
  public URI getNextPage() {
    return nextPage;
  }

   /**
   * The URL of the page.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the page.")
  public URI getSelf() {
    return self;
  }

   /**
   * The index of the first item returned.
   * @return startAt
  **/
  @ApiModelProperty(value = "The index of the first item returned.")
  public Long getStartAt() {
    return startAt;
  }

   /**
   * The number of items returned.
   * @return total
  **/
  @ApiModelProperty(value = "The number of items returned.")
  public Long getTotal() {
    return total;
  }

   /**
   * The list of items.
   * @return values
  **/
  @ApiModelProperty(value = "The list of items.")
  public List<SecurityLevelMember> getValues() {
    return values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageBeanSecurityLevelMember pageBeanSecurityLevelMember = (PageBeanSecurityLevelMember) o;
    return Objects.equals(this.isLast, pageBeanSecurityLevelMember.isLast) &&
        Objects.equals(this.maxResults, pageBeanSecurityLevelMember.maxResults) &&
        Objects.equals(this.nextPage, pageBeanSecurityLevelMember.nextPage) &&
        Objects.equals(this.self, pageBeanSecurityLevelMember.self) &&
        Objects.equals(this.startAt, pageBeanSecurityLevelMember.startAt) &&
        Objects.equals(this.total, pageBeanSecurityLevelMember.total) &&
        Objects.equals(this.values, pageBeanSecurityLevelMember.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isLast, maxResults, nextPage, self, startAt, total, values);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageBeanSecurityLevelMember {\n");
    
    sb.append("    isLast: ").append(toIndentedString(isLast)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    nextPage: ").append(toIndentedString(nextPage)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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

