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
 * IssueFieldOptionCreateBean
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:57:05.408+02:00[Europe/Prague]")
public class IssueFieldOptionCreateBean {
  @JsonProperty("value")
  private String value;

  @JsonProperty("properties")
  private Map<String, Object> properties = new HashMap<>();

  @JsonProperty("config")
  private IssueFieldOptionConfiguration config;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public IssueFieldOptionCreateBean value(String value) {
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

  public IssueFieldOptionCreateBean properties(Map<String, Object> properties) {
    this.properties = properties;
    return this;
  }

  public IssueFieldOptionCreateBean putPropertiesItem(String key, Object propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }
    this.properties.put(key, propertiesItem);
    return this;
  }

   /**
   * The properties of the option as arbitrary key-value pairs. These properties can be searched using JQL, if the extractions (see https://developer.atlassian.com/cloud/jira/platform/modules/issue-field-option-property-index/) are defined in the descriptor for the issue field module.
   * @return properties
  **/
  @ApiModelProperty(value = "The properties of the option as arbitrary key-value pairs. These properties can be searched using JQL, if the extractions (see https://developer.atlassian.com/cloud/jira/platform/modules/issue-field-option-property-index/) are defined in the descriptor for the issue field module.")
  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }

  public IssueFieldOptionCreateBean config(IssueFieldOptionConfiguration config) {
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


  @com.fasterxml.jackson.annotation.JsonAnyGetter
  public Map<String, Object> any() {
   return this.additionalProperties_;
  }

  @com.fasterxml.jackson.annotation.JsonAnySetter
  public void set(String name, Object value) {
   this.additionalProperties_.put(name, value);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueFieldOptionCreateBean issueFieldOptionCreateBean = (IssueFieldOptionCreateBean) o;
    return Objects.equals(this.value, issueFieldOptionCreateBean.value) &&
        Objects.equals(this.properties, issueFieldOptionCreateBean.properties) &&
        Objects.equals(this.config, issueFieldOptionCreateBean.config) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, properties, config, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueFieldOptionCreateBean {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
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

