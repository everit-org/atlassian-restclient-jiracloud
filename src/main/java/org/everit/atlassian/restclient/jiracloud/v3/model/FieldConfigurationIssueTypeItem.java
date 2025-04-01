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
 * The field configuration for an issue type.
 */
@ApiModel(description = "The field configuration for an issue type.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class FieldConfigurationIssueTypeItem {
  @JsonProperty("fieldConfigurationId")
  private String fieldConfigurationId;

  @JsonProperty("fieldConfigurationSchemeId")
  private String fieldConfigurationSchemeId;

  @JsonProperty("issueTypeId")
  private String issueTypeId;

  public FieldConfigurationIssueTypeItem fieldConfigurationId(String fieldConfigurationId) {
    this.fieldConfigurationId = fieldConfigurationId;
    return this;
  }

   /**
   * The ID of the field configuration.
   * @return fieldConfigurationId
  **/
  @ApiModelProperty(required = true, value = "The ID of the field configuration.")
  public String getFieldConfigurationId() {
    return fieldConfigurationId;
  }

  public void setFieldConfigurationId(String fieldConfigurationId) {
    this.fieldConfigurationId = fieldConfigurationId;
  }

  public FieldConfigurationIssueTypeItem fieldConfigurationSchemeId(String fieldConfigurationSchemeId) {
    this.fieldConfigurationSchemeId = fieldConfigurationSchemeId;
    return this;
  }

   /**
   * The ID of the field configuration scheme.
   * @return fieldConfigurationSchemeId
  **/
  @ApiModelProperty(required = true, value = "The ID of the field configuration scheme.")
  public String getFieldConfigurationSchemeId() {
    return fieldConfigurationSchemeId;
  }

  public void setFieldConfigurationSchemeId(String fieldConfigurationSchemeId) {
    this.fieldConfigurationSchemeId = fieldConfigurationSchemeId;
  }

  public FieldConfigurationIssueTypeItem issueTypeId(String issueTypeId) {
    this.issueTypeId = issueTypeId;
    return this;
  }

   /**
   * The ID of the issue type or *default*. When set to *default* this field configuration issue type item applies to all issue types without a field configuration.
   * @return issueTypeId
  **/
  @ApiModelProperty(required = true, value = "The ID of the issue type or *default*. When set to *default* this field configuration issue type item applies to all issue types without a field configuration.")
  public String getIssueTypeId() {
    return issueTypeId;
  }

  public void setIssueTypeId(String issueTypeId) {
    this.issueTypeId = issueTypeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldConfigurationIssueTypeItem fieldConfigurationIssueTypeItem = (FieldConfigurationIssueTypeItem) o;
    return Objects.equals(this.fieldConfigurationId, fieldConfigurationIssueTypeItem.fieldConfigurationId) &&
        Objects.equals(this.fieldConfigurationSchemeId, fieldConfigurationIssueTypeItem.fieldConfigurationSchemeId) &&
        Objects.equals(this.issueTypeId, fieldConfigurationIssueTypeItem.issueTypeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldConfigurationId, fieldConfigurationSchemeId, issueTypeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldConfigurationIssueTypeItem {\n");
    
    sb.append("    fieldConfigurationId: ").append(toIndentedString(fieldConfigurationId)).append("\n");
    sb.append("    fieldConfigurationSchemeId: ").append(toIndentedString(fieldConfigurationSchemeId)).append("\n");
    sb.append("    issueTypeId: ").append(toIndentedString(issueTypeId)).append("\n");
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

