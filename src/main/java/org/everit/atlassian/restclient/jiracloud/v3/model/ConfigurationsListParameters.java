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

/**
 * List of custom fields identifiers which will be used to filter configurations
 */
@ApiModel(description = "List of custom fields identifiers which will be used to filter configurations")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class ConfigurationsListParameters {
  @JsonProperty("fieldIdsOrKeys")
  private List<String> fieldIdsOrKeys = new ArrayList<>();

  public ConfigurationsListParameters fieldIdsOrKeys(List<String> fieldIdsOrKeys) {
    this.fieldIdsOrKeys = fieldIdsOrKeys;
    return this;
  }

  public ConfigurationsListParameters addFieldIdsOrKeysItem(String fieldIdsOrKeysItem) {
    this.fieldIdsOrKeys.add(fieldIdsOrKeysItem);
    return this;
  }

   /**
   * List of IDs or keys of the custom fields. It can be a mix of IDs and keys in the same query.
   * @return fieldIdsOrKeys
  **/
  @ApiModelProperty(required = true, value = "List of IDs or keys of the custom fields. It can be a mix of IDs and keys in the same query.")
  public List<String> getFieldIdsOrKeys() {
    return fieldIdsOrKeys;
  }

  public void setFieldIdsOrKeys(List<String> fieldIdsOrKeys) {
    this.fieldIdsOrKeys = fieldIdsOrKeys;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigurationsListParameters configurationsListParameters = (ConfigurationsListParameters) o;
    return Objects.equals(this.fieldIdsOrKeys, configurationsListParameters.fieldIdsOrKeys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldIdsOrKeys);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigurationsListParameters {\n");
    
    sb.append("    fieldIdsOrKeys: ").append(toIndentedString(fieldIdsOrKeys)).append("\n");
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

