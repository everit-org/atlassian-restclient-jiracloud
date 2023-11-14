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


package org.everit.atlassian.restclient.jiracloud.v3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * The list of required status mappings by workflow.
 */
@ApiModel(description = "The list of required status mappings by workflow.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class RequiredMappingByWorkflows {
  @JsonProperty("sourceWorkflowId")
  private String sourceWorkflowId;

  @JsonProperty("statusIds")
  private List<String> statusIds = new ArrayList<>();

  @JsonProperty("targetWorkflowId")
  private String targetWorkflowId;

  public RequiredMappingByWorkflows sourceWorkflowId(String sourceWorkflowId) {
    this.sourceWorkflowId = sourceWorkflowId;
    return this;
  }

   /**
   * The ID of the source workflow.
   * @return sourceWorkflowId
  **/
  @ApiModelProperty(value = "The ID of the source workflow.")
  public String getSourceWorkflowId() {
    return sourceWorkflowId;
  }

  public void setSourceWorkflowId(String sourceWorkflowId) {
    this.sourceWorkflowId = sourceWorkflowId;
  }

  public RequiredMappingByWorkflows statusIds(List<String> statusIds) {
    this.statusIds = statusIds;
    return this;
  }

  public RequiredMappingByWorkflows addStatusIdsItem(String statusIdsItem) {
    if (this.statusIds == null) {
      this.statusIds = new ArrayList<>();
    }
    this.statusIds.add(statusIdsItem);
    return this;
  }

   /**
   * The status IDs requiring mapping.
   * @return statusIds
  **/
  @ApiModelProperty(value = "The status IDs requiring mapping.")
  public List<String> getStatusIds() {
    return statusIds;
  }

  public void setStatusIds(List<String> statusIds) {
    this.statusIds = statusIds;
  }

  public RequiredMappingByWorkflows targetWorkflowId(String targetWorkflowId) {
    this.targetWorkflowId = targetWorkflowId;
    return this;
  }

   /**
   * The ID of the target workflow.
   * @return targetWorkflowId
  **/
  @ApiModelProperty(value = "The ID of the target workflow.")
  public String getTargetWorkflowId() {
    return targetWorkflowId;
  }

  public void setTargetWorkflowId(String targetWorkflowId) {
    this.targetWorkflowId = targetWorkflowId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequiredMappingByWorkflows requiredMappingByWorkflows = (RequiredMappingByWorkflows) o;
    return Objects.equals(this.sourceWorkflowId, requiredMappingByWorkflows.sourceWorkflowId) &&
        Objects.equals(this.statusIds, requiredMappingByWorkflows.statusIds) &&
        Objects.equals(this.targetWorkflowId, requiredMappingByWorkflows.targetWorkflowId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceWorkflowId, statusIds, targetWorkflowId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequiredMappingByWorkflows {\n");
    
    sb.append("    sourceWorkflowId: ").append(toIndentedString(sourceWorkflowId)).append("\n");
    sb.append("    statusIds: ").append(toIndentedString(statusIds)).append("\n");
    sb.append("    targetWorkflowId: ").append(toIndentedString(targetWorkflowId)).append("\n");
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

