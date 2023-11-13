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
import org.everit.atlassian.restclient.jiracloud.v3.model.ContextualConfiguration;

/**
 * Details of configurations for a custom field.
 */
@ApiModel(description = "Details of configurations for a custom field.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class CustomFieldConfigurations {
  @JsonProperty("configurations")
  private List<ContextualConfiguration> configurations = new ArrayList<>();

  public CustomFieldConfigurations configurations(List<ContextualConfiguration> configurations) {
    this.configurations = configurations;
    return this;
  }

  public CustomFieldConfigurations addConfigurationsItem(ContextualConfiguration configurationsItem) {
    this.configurations.add(configurationsItem);
    return this;
  }

   /**
   * The list of custom field configuration details.
   * @return configurations
  **/
  @ApiModelProperty(required = true, value = "The list of custom field configuration details.")
  public List<ContextualConfiguration> getConfigurations() {
    return configurations;
  }

  public void setConfigurations(List<ContextualConfiguration> configurations) {
    this.configurations = configurations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomFieldConfigurations customFieldConfigurations = (CustomFieldConfigurations) o;
    return Objects.equals(this.configurations, customFieldConfigurations.configurations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(configurations);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldConfigurations {\n");
    
    sb.append("    configurations: ").append(toIndentedString(configurations)).append("\n");
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

