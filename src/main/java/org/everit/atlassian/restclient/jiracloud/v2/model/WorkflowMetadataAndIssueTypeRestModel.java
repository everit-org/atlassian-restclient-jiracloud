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
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowMetadataRestModel;

/**
 * The workflow metadata and issue type IDs which use this workflow.
 */
@ApiModel(description = "The workflow metadata and issue type IDs which use this workflow.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class WorkflowMetadataAndIssueTypeRestModel {
  @JsonProperty("issueTypeIds")
  private List<String> issueTypeIds = new ArrayList<>();

  @JsonProperty("workflow")
  private WorkflowMetadataRestModel workflow;

  public WorkflowMetadataAndIssueTypeRestModel issueTypeIds(List<String> issueTypeIds) {
    this.issueTypeIds = issueTypeIds;
    return this;
  }

  public WorkflowMetadataAndIssueTypeRestModel addIssueTypeIdsItem(String issueTypeIdsItem) {
    this.issueTypeIds.add(issueTypeIdsItem);
    return this;
  }

   /**
   * The list of issue type IDs for the mapping.
   * @return issueTypeIds
  **/
  @ApiModelProperty(required = true, value = "The list of issue type IDs for the mapping.")
  public List<String> getIssueTypeIds() {
    return issueTypeIds;
  }

  public void setIssueTypeIds(List<String> issueTypeIds) {
    this.issueTypeIds = issueTypeIds;
  }

  public WorkflowMetadataAndIssueTypeRestModel workflow(WorkflowMetadataRestModel workflow) {
    this.workflow = workflow;
    return this;
  }

   /**
   * Get workflow
   * @return workflow
  **/
  @ApiModelProperty(required = true, value = "")
  public WorkflowMetadataRestModel getWorkflow() {
    return workflow;
  }

  public void setWorkflow(WorkflowMetadataRestModel workflow) {
    this.workflow = workflow;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowMetadataAndIssueTypeRestModel workflowMetadataAndIssueTypeRestModel = (WorkflowMetadataAndIssueTypeRestModel) o;
    return Objects.equals(this.issueTypeIds, workflowMetadataAndIssueTypeRestModel.issueTypeIds) &&
        Objects.equals(this.workflow, workflowMetadataAndIssueTypeRestModel.workflow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueTypeIds, workflow);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowMetadataAndIssueTypeRestModel {\n");
    
    sb.append("    issueTypeIds: ").append(toIndentedString(issueTypeIds)).append("\n");
    sb.append("    workflow: ").append(toIndentedString(workflow)).append("\n");
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
