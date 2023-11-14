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
 * The Atlassian provided system rules available.
 */
@ApiModel(description = "The Atlassian provided system rules available.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class AvailableWorkflowSystemRule {
  @JsonProperty("description")
  private String description;

  @JsonProperty("incompatibleRuleKeys")
  private List<String> incompatibleRuleKeys = new ArrayList<>();

  @JsonProperty("isAvailableForInitialTransition")
  private Boolean isAvailableForInitialTransition;

  @JsonProperty("isVisible")
  private Boolean isVisible;

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

  public AvailableWorkflowSystemRule description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The rule description.
   * @return description
  **/
  @ApiModelProperty(required = true, value = "The rule description.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AvailableWorkflowSystemRule incompatibleRuleKeys(List<String> incompatibleRuleKeys) {
    this.incompatibleRuleKeys = incompatibleRuleKeys;
    return this;
  }

  public AvailableWorkflowSystemRule addIncompatibleRuleKeysItem(String incompatibleRuleKeysItem) {
    this.incompatibleRuleKeys.add(incompatibleRuleKeysItem);
    return this;
  }

   /**
   * List of rules that conflict with this one.
   * @return incompatibleRuleKeys
  **/
  @ApiModelProperty(required = true, value = "List of rules that conflict with this one.")
  public List<String> getIncompatibleRuleKeys() {
    return incompatibleRuleKeys;
  }

  public void setIncompatibleRuleKeys(List<String> incompatibleRuleKeys) {
    this.incompatibleRuleKeys = incompatibleRuleKeys;
  }

  public AvailableWorkflowSystemRule isAvailableForInitialTransition(Boolean isAvailableForInitialTransition) {
    this.isAvailableForInitialTransition = isAvailableForInitialTransition;
    return this;
  }

   /**
   * Whether the rule can be added added to an initial transition.
   * @return isAvailableForInitialTransition
  **/
  @ApiModelProperty(required = true, value = "Whether the rule can be added added to an initial transition.")
  public Boolean getIsAvailableForInitialTransition() {
    return isAvailableForInitialTransition;
  }

  public void setIsAvailableForInitialTransition(Boolean isAvailableForInitialTransition) {
    this.isAvailableForInitialTransition = isAvailableForInitialTransition;
  }

  public AvailableWorkflowSystemRule isVisible(Boolean isVisible) {
    this.isVisible = isVisible;
    return this;
  }

   /**
   * Whether the rule is visible.
   * @return isVisible
  **/
  @ApiModelProperty(required = true, value = "Whether the rule is visible.")
  public Boolean getIsVisible() {
    return isVisible;
  }

  public void setIsVisible(Boolean isVisible) {
    this.isVisible = isVisible;
  }

  public AvailableWorkflowSystemRule name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The rule name.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The rule name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AvailableWorkflowSystemRule ruleKey(String ruleKey) {
    this.ruleKey = ruleKey;
    return this;
  }

   /**
   * The rule key.
   * @return ruleKey
  **/
  @ApiModelProperty(required = true, value = "The rule key.")
  public String getRuleKey() {
    return ruleKey;
  }

  public void setRuleKey(String ruleKey) {
    this.ruleKey = ruleKey;
  }

  public AvailableWorkflowSystemRule ruleType(RuleTypeEnum ruleType) {
    this.ruleType = ruleType;
    return this;
  }

   /**
   * The rule type.
   * @return ruleType
  **/
  @ApiModelProperty(required = true, value = "The rule type.")
  public RuleTypeEnum getRuleType() {
    return ruleType;
  }

  public void setRuleType(RuleTypeEnum ruleType) {
    this.ruleType = ruleType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableWorkflowSystemRule availableWorkflowSystemRule = (AvailableWorkflowSystemRule) o;
    return Objects.equals(this.description, availableWorkflowSystemRule.description) &&
        Objects.equals(this.incompatibleRuleKeys, availableWorkflowSystemRule.incompatibleRuleKeys) &&
        Objects.equals(this.isAvailableForInitialTransition, availableWorkflowSystemRule.isAvailableForInitialTransition) &&
        Objects.equals(this.isVisible, availableWorkflowSystemRule.isVisible) &&
        Objects.equals(this.name, availableWorkflowSystemRule.name) &&
        Objects.equals(this.ruleKey, availableWorkflowSystemRule.ruleKey) &&
        Objects.equals(this.ruleType, availableWorkflowSystemRule.ruleType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, incompatibleRuleKeys, isAvailableForInitialTransition, isVisible, name, ruleKey, ruleType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableWorkflowSystemRule {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    incompatibleRuleKeys: ").append(toIndentedString(incompatibleRuleKeys)).append("\n");
    sb.append("    isAvailableForInitialTransition: ").append(toIndentedString(isAvailableForInitialTransition)).append("\n");
    sb.append("    isVisible: ").append(toIndentedString(isVisible)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ruleKey: ").append(toIndentedString(ruleKey)).append("\n");
    sb.append("    ruleType: ").append(toIndentedString(ruleType)).append("\n");
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
