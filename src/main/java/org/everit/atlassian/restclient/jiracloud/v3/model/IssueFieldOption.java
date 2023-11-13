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
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueFieldOptionConfiguration;

/**
 * Details of the options for a select list issue field.
 */
@ApiModel(description = "Details of the options for a select list issue field.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class IssueFieldOption {
  @JsonProperty("config")
  private IssueFieldOptionConfiguration config;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("properties")
  private Map<String, Object> properties = new HashMap<>();

  @JsonProperty("value")
  private String value;

  public IssueFieldOption config(IssueFieldOptionConfiguration config) {
    this.config = config;
    return this;
  }

   /**
   * Get config
   * @return config
  **/
  @ApiModelProperty(value = "")
  public IssueFieldOptionConfiguration getConfig() {
    return config;
  }

  public void setConfig(IssueFieldOptionConfiguration config) {
    this.config = config;
  }

  public IssueFieldOption id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * The unique identifier for the option. This is only unique within the select field&#39;s set of options.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The unique identifier for the option. This is only unique within the select field's set of options.")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public IssueFieldOption properties(Map<String, Object> properties) {
    this.properties = properties;
    return this;
  }

  public IssueFieldOption putPropertiesItem(String key, Object propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }
    this.properties.put(key, propertiesItem);
    return this;
  }

   /**
   * The properties of the object, as arbitrary key-value pairs. These properties can be searched using JQL, if the extractions (see [Issue Field Option Property Index](https://developer.atlassian.com/cloud/jira/platform/modules/issue-field-option-property-index/)) are defined in the descriptor for the issue field module.
   * @return properties
  **/
  @ApiModelProperty(value = "The properties of the object, as arbitrary key-value pairs. These properties can be searched using JQL, if the extractions (see [Issue Field Option Property Index](https://developer.atlassian.com/cloud/jira/platform/modules/issue-field-option-property-index/)) are defined in the descriptor for the issue field module.")
  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }

  public IssueFieldOption value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The option&#39;s name, which is displayed in Jira.
   * @return value
  **/
  @ApiModelProperty(required = true, value = "The option's name, which is displayed in Jira.")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueFieldOption issueFieldOption = (IssueFieldOption) o;
    return Objects.equals(this.config, issueFieldOption.config) &&
        Objects.equals(this.id, issueFieldOption.id) &&
        Objects.equals(this.properties, issueFieldOption.properties) &&
        Objects.equals(this.value, issueFieldOption.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(config, id, properties, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueFieldOption {\n");
    
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

