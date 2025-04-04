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
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v3.model.CustomFieldReplacement;

/**
 * DeleteAndReplaceVersionBean
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class DeleteAndReplaceVersionBean {
  @JsonProperty("customFieldReplacementList")
  private List<CustomFieldReplacement> customFieldReplacementList = new ArrayList<>();

  @JsonProperty("moveAffectedIssuesTo")
  private Long moveAffectedIssuesTo;

  @JsonProperty("moveFixIssuesTo")
  private Long moveFixIssuesTo;

  public DeleteAndReplaceVersionBean customFieldReplacementList(List<CustomFieldReplacement> customFieldReplacementList) {
    this.customFieldReplacementList = customFieldReplacementList;
    return this;
  }

  public DeleteAndReplaceVersionBean addCustomFieldReplacementListItem(CustomFieldReplacement customFieldReplacementListItem) {
    if (this.customFieldReplacementList == null) {
      this.customFieldReplacementList = new ArrayList<>();
    }
    this.customFieldReplacementList.add(customFieldReplacementListItem);
    return this;
  }

   /**
   * An array of custom field IDs (&#x60;customFieldId&#x60;) and version IDs (&#x60;moveTo&#x60;) to update when the fields contain the deleted version.
   * @return customFieldReplacementList
  **/
  @ApiModelProperty(value = "An array of custom field IDs (`customFieldId`) and version IDs (`moveTo`) to update when the fields contain the deleted version.")
  public List<CustomFieldReplacement> getCustomFieldReplacementList() {
    return customFieldReplacementList;
  }

  public void setCustomFieldReplacementList(List<CustomFieldReplacement> customFieldReplacementList) {
    this.customFieldReplacementList = customFieldReplacementList;
  }

  public DeleteAndReplaceVersionBean moveAffectedIssuesTo(Long moveAffectedIssuesTo) {
    this.moveAffectedIssuesTo = moveAffectedIssuesTo;
    return this;
  }

   /**
   * The ID of the version to update &#x60;affectedVersion&#x60; to when the field contains the deleted version.
   * @return moveAffectedIssuesTo
  **/
  @ApiModelProperty(value = "The ID of the version to update `affectedVersion` to when the field contains the deleted version.")
  public Long getMoveAffectedIssuesTo() {
    return moveAffectedIssuesTo;
  }

  public void setMoveAffectedIssuesTo(Long moveAffectedIssuesTo) {
    this.moveAffectedIssuesTo = moveAffectedIssuesTo;
  }

  public DeleteAndReplaceVersionBean moveFixIssuesTo(Long moveFixIssuesTo) {
    this.moveFixIssuesTo = moveFixIssuesTo;
    return this;
  }

   /**
   * The ID of the version to update &#x60;fixVersion&#x60; to when the field contains the deleted version.
   * @return moveFixIssuesTo
  **/
  @ApiModelProperty(value = "The ID of the version to update `fixVersion` to when the field contains the deleted version.")
  public Long getMoveFixIssuesTo() {
    return moveFixIssuesTo;
  }

  public void setMoveFixIssuesTo(Long moveFixIssuesTo) {
    this.moveFixIssuesTo = moveFixIssuesTo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteAndReplaceVersionBean deleteAndReplaceVersionBean = (DeleteAndReplaceVersionBean) o;
    return Objects.equals(this.customFieldReplacementList, deleteAndReplaceVersionBean.customFieldReplacementList) &&
        Objects.equals(this.moveAffectedIssuesTo, deleteAndReplaceVersionBean.moveAffectedIssuesTo) &&
        Objects.equals(this.moveFixIssuesTo, deleteAndReplaceVersionBean.moveFixIssuesTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customFieldReplacementList, moveAffectedIssuesTo, moveFixIssuesTo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteAndReplaceVersionBean {\n");
    
    sb.append("    customFieldReplacementList: ").append(toIndentedString(customFieldReplacementList)).append("\n");
    sb.append("    moveAffectedIssuesTo: ").append(toIndentedString(moveAffectedIssuesTo)).append("\n");
    sb.append("    moveFixIssuesTo: ").append(toIndentedString(moveFixIssuesTo)).append("\n");
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

