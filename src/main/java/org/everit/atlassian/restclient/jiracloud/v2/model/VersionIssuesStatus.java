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
import java.util.HashMap;
import java.util.Map;

/**
 * Counts of the number of issues in various statuses.
 */
@ApiModel(description = "Counts of the number of issues in various statuses.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class VersionIssuesStatus {
  @JsonProperty("done")
  private Long done;

  @JsonProperty("inProgress")
  private Long inProgress;

  @JsonProperty("toDo")
  private Long toDo;

  @JsonProperty("unmapped")
  private Long unmapped;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

   /**
   * Count of issues with status *done*.
   * @return done
  **/
  @ApiModelProperty(value = "Count of issues with status *done*.")
  public Long getDone() {
    return done;
  }

   /**
   * Count of issues with status *in progress*.
   * @return inProgress
  **/
  @ApiModelProperty(value = "Count of issues with status *in progress*.")
  public Long getInProgress() {
    return inProgress;
  }

   /**
   * Count of issues with status *to do*.
   * @return toDo
  **/
  @ApiModelProperty(value = "Count of issues with status *to do*.")
  public Long getToDo() {
    return toDo;
  }

   /**
   * Count of issues with a status other than *to do*, *in progress*, and *done*.
   * @return unmapped
  **/
  @ApiModelProperty(value = "Count of issues with a status other than *to do*, *in progress*, and *done*.")
  public Long getUnmapped() {
    return unmapped;
  }


  @com.fasterxml.jackson.annotation.JsonAnyGetter
  public Map<String, Object> any() {
   return this.additionalProperties_;
  }

  @com.fasterxml.jackson.annotation.JsonAnySetter
  public void set(String name, Object value) {
   this.additionalProperties_.put(name, value);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionIssuesStatus versionIssuesStatus = (VersionIssuesStatus) o;
    return Objects.equals(this.done, versionIssuesStatus.done) &&
        Objects.equals(this.inProgress, versionIssuesStatus.inProgress) &&
        Objects.equals(this.toDo, versionIssuesStatus.toDo) &&
        Objects.equals(this.unmapped, versionIssuesStatus.unmapped) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(done, inProgress, toDo, unmapped, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionIssuesStatus {\n");
    
    sb.append("    done: ").append(toIndentedString(done)).append("\n");
    sb.append("    inProgress: ").append(toIndentedString(inProgress)).append("\n");
    sb.append("    toDo: ").append(toIndentedString(toDo)).append("\n");
    sb.append("    unmapped: ").append(toIndentedString(unmapped)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties_)).append("\n");
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

