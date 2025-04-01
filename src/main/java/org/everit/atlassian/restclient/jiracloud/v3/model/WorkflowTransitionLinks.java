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
 * The statuses the transition can start from, and the mapping of ports between the statuses.
 */
@ApiModel(description = "The statuses the transition can start from, and the mapping of ports between the statuses.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class WorkflowTransitionLinks {
  @JsonProperty("fromPort")
  private Integer fromPort;

  @JsonProperty("fromStatusReference")
  private String fromStatusReference;

  @JsonProperty("toPort")
  private Integer toPort;

  public WorkflowTransitionLinks fromPort(Integer fromPort) {
    this.fromPort = fromPort;
    return this;
  }

   /**
   * The port that the transition starts from.
   * @return fromPort
  **/
  @ApiModelProperty(value = "The port that the transition starts from.")
  public Integer getFromPort() {
    return fromPort;
  }

  public void setFromPort(Integer fromPort) {
    this.fromPort = fromPort;
  }

  public WorkflowTransitionLinks fromStatusReference(String fromStatusReference) {
    this.fromStatusReference = fromStatusReference;
    return this;
  }

   /**
   * The status that the transition starts from.
   * @return fromStatusReference
  **/
  @ApiModelProperty(value = "The status that the transition starts from.")
  public String getFromStatusReference() {
    return fromStatusReference;
  }

  public void setFromStatusReference(String fromStatusReference) {
    this.fromStatusReference = fromStatusReference;
  }

  public WorkflowTransitionLinks toPort(Integer toPort) {
    this.toPort = toPort;
    return this;
  }

   /**
   * The port that the transition goes to.
   * @return toPort
  **/
  @ApiModelProperty(value = "The port that the transition goes to.")
  public Integer getToPort() {
    return toPort;
  }

  public void setToPort(Integer toPort) {
    this.toPort = toPort;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowTransitionLinks workflowTransitionLinks = (WorkflowTransitionLinks) o;
    return Objects.equals(this.fromPort, workflowTransitionLinks.fromPort) &&
        Objects.equals(this.fromStatusReference, workflowTransitionLinks.fromStatusReference) &&
        Objects.equals(this.toPort, workflowTransitionLinks.toPort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromPort, fromStatusReference, toPort);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowTransitionLinks {\n");
    
    sb.append("    fromPort: ").append(toIndentedString(fromPort)).append("\n");
    sb.append("    fromStatusReference: ").append(toIndentedString(fromStatusReference)).append("\n");
    sb.append("    toPort: ").append(toIndentedString(toPort)).append("\n");
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

