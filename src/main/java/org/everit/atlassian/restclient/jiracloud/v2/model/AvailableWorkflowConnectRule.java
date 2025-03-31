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


package org.everit.atlassian.restclient.jiracloud.v2.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The Connect provided ecosystem rules available.
 */
@ApiModel(description = "The Connect provided ecosystem rules available.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class AvailableWorkflowConnectRule {
  @JsonProperty("addonKey")
  private String addonKey;

  @JsonProperty("createUrl")
  private String createUrl;

  @JsonProperty("description")
  private String description;

  @JsonProperty("editUrl")
  private String editUrl;

  @JsonProperty("moduleKey")
  private String moduleKey;

  @JsonProperty("name")
  private String name;

  @JsonProperty("ruleKey")
  private String ruleKey;

  /**
   * The rule type.
   */
  public enum RuleTypeEnum {
    CONDITION("Condition"),
    
    VALIDATOR("Validator"),
    
    FUNCTION("Function"),
    
    SCREEN("Screen");

    private String value;

    RuleTypeEnum(String value) {
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
    public static RuleTypeEnum fromValue(String value) {
      for (RuleTypeEnum b : RuleTypeEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("ruleType")
  private RuleTypeEnum ruleType;

  @JsonProperty("viewUrl")
  private String viewUrl;

  public AvailableWorkflowConnectRule addonKey(String addonKey) {
    this.addonKey = addonKey;
    return this;
  }

   /**
   * The add-on providing the rule.
   * @return addonKey
  **/
  @ApiModelProperty(value = "The add-on providing the rule.")
  public String getAddonKey() {
    return addonKey;
  }

  public void setAddonKey(String addonKey) {
    this.addonKey = addonKey;
  }

  public AvailableWorkflowConnectRule createUrl(String createUrl) {
    this.createUrl = createUrl;
    return this;
  }

   /**
   * The URL creation path segment defined in the Connect module.
   * @return createUrl
  **/
  @ApiModelProperty(value = "The URL creation path segment defined in the Connect module.")
  public String getCreateUrl() {
    return createUrl;
  }

  public void setCreateUrl(String createUrl) {
    this.createUrl = createUrl;
  }

  public AvailableWorkflowConnectRule description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The rule description.
   * @return description
  **/
  @ApiModelProperty(value = "The rule description.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AvailableWorkflowConnectRule editUrl(String editUrl) {
    this.editUrl = editUrl;
    return this;
  }

   /**
   * The URL edit path segment defined in the Connect module.
   * @return editUrl
  **/
  @ApiModelProperty(value = "The URL edit path segment defined in the Connect module.")
  public String getEditUrl() {
    return editUrl;
  }

  public void setEditUrl(String editUrl) {
    this.editUrl = editUrl;
  }

  public AvailableWorkflowConnectRule moduleKey(String moduleKey) {
    this.moduleKey = moduleKey;
    return this;
  }

   /**
   * The module providing the rule.
   * @return moduleKey
  **/
  @ApiModelProperty(value = "The module providing the rule.")
  public String getModuleKey() {
    return moduleKey;
  }

  public void setModuleKey(String moduleKey) {
    this.moduleKey = moduleKey;
  }

  public AvailableWorkflowConnectRule name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The rule name.
   * @return name
  **/
  @ApiModelProperty(value = "The rule name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AvailableWorkflowConnectRule ruleKey(String ruleKey) {
    this.ruleKey = ruleKey;
    return this;
  }

   /**
   * The rule key.
   * @return ruleKey
  **/
  @ApiModelProperty(value = "The rule key.")
  public String getRuleKey() {
    return ruleKey;
  }

  public void setRuleKey(String ruleKey) {
    this.ruleKey = ruleKey;
  }

  public AvailableWorkflowConnectRule ruleType(RuleTypeEnum ruleType) {
    this.ruleType = ruleType;
    return this;
  }

   /**
   * The rule type.
   * @return ruleType
  **/
  @ApiModelProperty(value = "The rule type.")
  public RuleTypeEnum getRuleType() {
    return ruleType;
  }

  public void setRuleType(RuleTypeEnum ruleType) {
    this.ruleType = ruleType;
  }

  public AvailableWorkflowConnectRule viewUrl(String viewUrl) {
    this.viewUrl = viewUrl;
    return this;
  }

   /**
   * The URL view path segment defined in the Connect module.
   * @return viewUrl
  **/
  @ApiModelProperty(value = "The URL view path segment defined in the Connect module.")
  public String getViewUrl() {
    return viewUrl;
  }

  public void setViewUrl(String viewUrl) {
    this.viewUrl = viewUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableWorkflowConnectRule availableWorkflowConnectRule = (AvailableWorkflowConnectRule) o;
    return Objects.equals(this.addonKey, availableWorkflowConnectRule.addonKey) &&
        Objects.equals(this.createUrl, availableWorkflowConnectRule.createUrl) &&
        Objects.equals(this.description, availableWorkflowConnectRule.description) &&
        Objects.equals(this.editUrl, availableWorkflowConnectRule.editUrl) &&
        Objects.equals(this.moduleKey, availableWorkflowConnectRule.moduleKey) &&
        Objects.equals(this.name, availableWorkflowConnectRule.name) &&
        Objects.equals(this.ruleKey, availableWorkflowConnectRule.ruleKey) &&
        Objects.equals(this.ruleType, availableWorkflowConnectRule.ruleType) &&
        Objects.equals(this.viewUrl, availableWorkflowConnectRule.viewUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addonKey, createUrl, description, editUrl, moduleKey, name, ruleKey, ruleType, viewUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableWorkflowConnectRule {\n");
    
    sb.append("    addonKey: ").append(toIndentedString(addonKey)).append("\n");
    sb.append("    createUrl: ").append(toIndentedString(createUrl)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    editUrl: ").append(toIndentedString(editUrl)).append("\n");
    sb.append("    moduleKey: ").append(toIndentedString(moduleKey)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ruleKey: ").append(toIndentedString(ruleKey)).append("\n");
    sb.append("    ruleType: ").append(toIndentedString(ruleType)).append("\n");
    sb.append("    viewUrl: ").append(toIndentedString(viewUrl)).append("\n");
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

