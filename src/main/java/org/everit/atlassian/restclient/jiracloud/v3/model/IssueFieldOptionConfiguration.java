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
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueFieldOptionScopeBean;

/**
 * Details of the projects the option is available in.
 */
@ApiModel(description = "Details of the projects the option is available in.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:37.034+02:00[Europe/Prague]")
public class IssueFieldOptionConfiguration {
  @JsonProperty("scope")
  private IssueFieldOptionScopeBean scope;

  /**
   * Gets or Sets attributes
   */
  public enum AttributesEnum {
    NOTSELECTABLE("notSelectable"),
    
    DEFAULTVALUE("defaultValue");

    private String value;

    AttributesEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AttributesEnum fromValue(String value) {
      for (AttributesEnum b : AttributesEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("attributes")
  private List<AttributesEnum> attributes = new ArrayList<>();

  public IssueFieldOptionConfiguration scope(IssueFieldOptionScopeBean scope) {
    this.scope = scope;
    return this;
  }

   /**
   * Defines the projects that the option is available in. If the scope is not defined, then the option is available in all projects.
   * @return scope
  **/
  @ApiModelProperty(value = "Defines the projects that the option is available in. If the scope is not defined, then the option is available in all projects.")
  public IssueFieldOptionScopeBean getScope() {
    return scope;
  }

  public void setScope(IssueFieldOptionScopeBean scope) {
    this.scope = scope;
  }

  public IssueFieldOptionConfiguration attributes(List<AttributesEnum> attributes) {
    this.attributes = attributes;
    return this;
  }

  public IssueFieldOptionConfiguration addAttributesItem(AttributesEnum attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

   /**
   * DEPRECATED
   * @return attributes
  **/
  @ApiModelProperty(value = "DEPRECATED")
  public List<AttributesEnum> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<AttributesEnum> attributes) {
    this.attributes = attributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueFieldOptionConfiguration issueFieldOptionConfiguration = (IssueFieldOptionConfiguration) o;
    return Objects.equals(this.scope, issueFieldOptionConfiguration.scope) &&
        Objects.equals(this.attributes, issueFieldOptionConfiguration.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scope, attributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueFieldOptionConfiguration {\n");
    
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
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

