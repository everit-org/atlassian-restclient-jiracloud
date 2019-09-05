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


package org.everit.atlassian.restclient.jiracloud.v2.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.everit.atlassian.restclient.jiracloud.v2.model.Scope;

/**
 * Details about a workflow.
 */
@ApiModel(description = "Details about a workflow.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:30.184+02:00[Europe/Prague]")
public class DeprecatedWorkflow {
  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("lastModifiedDate")
  private String lastModifiedDate;

  @JsonProperty("lastModifiedUser")
  private String lastModifiedUser;

  @JsonProperty("lastModifiedUserAccountId")
  private String lastModifiedUserAccountId;

  @JsonProperty("steps")
  private Integer steps;

  @JsonProperty("scope")
  private Scope scope;

  @JsonProperty("default")
  private Boolean _default;

   /**
   * The name of the workflow.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the workflow.")
  public String getName() {
    return name;
  }

   /**
   * The description of the workflow.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the workflow.")
  public String getDescription() {
    return description;
  }

   /**
   * The datetime the workflow was last modified.
   * @return lastModifiedDate
  **/
  @ApiModelProperty(value = "The datetime the workflow was last modified.")
  public String getLastModifiedDate() {
    return lastModifiedDate;
  }

   /**
   * This property is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
   * @return lastModifiedUser
  **/
  @ApiModelProperty(value = "This property is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.")
  public String getLastModifiedUser() {
    return lastModifiedUser;
  }

   /**
   * The account ID of the user that last modified the workflow.
   * @return lastModifiedUserAccountId
  **/
  @ApiModelProperty(value = "The account ID of the user that last modified the workflow.")
  public String getLastModifiedUserAccountId() {
    return lastModifiedUserAccountId;
  }

   /**
   * The number of steps included in the workflow.
   * @return steps
  **/
  @ApiModelProperty(value = "The number of steps included in the workflow.")
  public Integer getSteps() {
    return steps;
  }

   /**
   * The scope where this workflow applies
   * @return scope
  **/
  @ApiModelProperty(value = "The scope where this workflow applies")
  public Scope getScope() {
    return scope;
  }

  public DeprecatedWorkflow _default(Boolean _default) {
    this._default = _default;
    return this;
  }

   /**
   * Get _default
   * @return _default
  **/
  @ApiModelProperty(value = "")
  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeprecatedWorkflow deprecatedWorkflow = (DeprecatedWorkflow) o;
    return Objects.equals(this.name, deprecatedWorkflow.name) &&
        Objects.equals(this.description, deprecatedWorkflow.description) &&
        Objects.equals(this.lastModifiedDate, deprecatedWorkflow.lastModifiedDate) &&
        Objects.equals(this.lastModifiedUser, deprecatedWorkflow.lastModifiedUser) &&
        Objects.equals(this.lastModifiedUserAccountId, deprecatedWorkflow.lastModifiedUserAccountId) &&
        Objects.equals(this.steps, deprecatedWorkflow.steps) &&
        Objects.equals(this.scope, deprecatedWorkflow.scope) &&
        Objects.equals(this._default, deprecatedWorkflow._default);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, lastModifiedDate, lastModifiedUser, lastModifiedUserAccountId, steps, scope, _default);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeprecatedWorkflow {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastModifiedDate: ").append(toIndentedString(lastModifiedDate)).append("\n");
    sb.append("    lastModifiedUser: ").append(toIndentedString(lastModifiedUser)).append("\n");
    sb.append("    lastModifiedUserAccountId: ").append(toIndentedString(lastModifiedUserAccountId)).append("\n");
    sb.append("    steps: ").append(toIndentedString(steps)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
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

