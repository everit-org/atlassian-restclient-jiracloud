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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v3.model.JsonNode;

/**
 * An issue ID with entity property values. See [Entity properties](https://developer.atlassian.com/cloud/jira/platform/jira-entity-properties/) for more information.
 */
@ApiModel(description = "An issue ID with entity property values. See [Entity properties](https://developer.atlassian.com/cloud/jira/platform/jira-entity-properties/) for more information.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class IssueEntityPropertiesForMultiUpdate {
  @JsonProperty("issueID")
  private Long issueID;

  @JsonProperty("properties")
  private Map<String, JsonNode> properties = new HashMap<>();

  public IssueEntityPropertiesForMultiUpdate issueID(Long issueID) {
    this.issueID = issueID;
    return this;
  }

   /**
   * The ID of the issue.
   * @return issueID
  **/
  @ApiModelProperty(value = "The ID of the issue.")
  public Long getIssueID() {
    return issueID;
  }

  public void setIssueID(Long issueID) {
    this.issueID = issueID;
  }

  public IssueEntityPropertiesForMultiUpdate properties(Map<String, JsonNode> properties) {
    this.properties = properties;
    return this;
  }

  public IssueEntityPropertiesForMultiUpdate putPropertiesItem(String key, JsonNode propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }
    this.properties.put(key, propertiesItem);
    return this;
  }

   /**
   * Entity properties to set on the issue. The maximum length of an issue property value is 32768 characters.
   * @return properties
  **/
  @ApiModelProperty(value = "Entity properties to set on the issue. The maximum length of an issue property value is 32768 characters.")
  public Map<String, JsonNode> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, JsonNode> properties) {
    this.properties = properties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueEntityPropertiesForMultiUpdate issueEntityPropertiesForMultiUpdate = (IssueEntityPropertiesForMultiUpdate) o;
    return Objects.equals(this.issueID, issueEntityPropertiesForMultiUpdate.issueID) &&
        Objects.equals(this.properties, issueEntityPropertiesForMultiUpdate.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueID, properties);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueEntityPropertiesForMultiUpdate {\n");
    
    sb.append("    issueID: ").append(toIndentedString(issueID)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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

