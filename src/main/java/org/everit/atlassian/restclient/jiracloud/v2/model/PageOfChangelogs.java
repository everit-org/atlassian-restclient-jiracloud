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
import org.everit.atlassian.restclient.jiracloud.v2.model.Changelog;

/**
 * A page of changelogs.
 */
@ApiModel(description = "A page of changelogs.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:30.184+02:00[Europe/Prague]")
public class PageOfChangelogs {
  @JsonProperty("startAt")
  private Integer startAt;

  @JsonProperty("maxResults")
  private Integer maxResults;

  @JsonProperty("total")
  private Integer total;

  @JsonProperty("histories")
  private List<Changelog> histories = new ArrayList<>();

   /**
   * The index of the first item returned on the page.
   * @return startAt
  **/
  @ApiModelProperty(value = "The index of the first item returned on the page.")
  public Integer getStartAt() {
    return startAt;
  }

   /**
   * The maximum number of results that could be on the page.
   * @return maxResults
  **/
  @ApiModelProperty(value = "The maximum number of results that could be on the page.")
  public Integer getMaxResults() {
    return maxResults;
  }

   /**
   * The number of results on the page.
   * @return total
  **/
  @ApiModelProperty(value = "The number of results on the page.")
  public Integer getTotal() {
    return total;
  }

   /**
   * The list of changelogs.
   * @return histories
  **/
  @ApiModelProperty(value = "The list of changelogs.")
  public List<Changelog> getHistories() {
    return histories;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageOfChangelogs pageOfChangelogs = (PageOfChangelogs) o;
    return Objects.equals(this.startAt, pageOfChangelogs.startAt) &&
        Objects.equals(this.maxResults, pageOfChangelogs.maxResults) &&
        Objects.equals(this.total, pageOfChangelogs.total) &&
        Objects.equals(this.histories, pageOfChangelogs.histories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startAt, maxResults, total, histories);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageOfChangelogs {\n");
    
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    histories: ").append(toIndentedString(histories)).append("\n");
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

