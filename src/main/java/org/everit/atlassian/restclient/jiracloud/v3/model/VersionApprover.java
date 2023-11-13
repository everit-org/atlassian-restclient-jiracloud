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
import java.util.Map;

/**
 * Contains details about a version approver.
 */
@ApiModel(description = "Contains details about a version approver.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class VersionApprover {
  @JsonProperty("accountId")
  private String accountId;

  @JsonProperty("declineReason")
  private String declineReason;

  @JsonProperty("description")
  private String description;

  @JsonProperty("status")
  private String status;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

   /**
   * The Atlassian account ID of the approver.
   * @return accountId
  **/
  @ApiModelProperty(value = "The Atlassian account ID of the approver.")
  public String getAccountId() {
    return accountId;
  }

   /**
   * A description of why the user is declining the approval.
   * @return declineReason
  **/
  @ApiModelProperty(value = "A description of why the user is declining the approval.")
  public String getDeclineReason() {
    return declineReason;
  }

   /**
   * A description of what the user is approving within the specified version.
   * @return description
  **/
  @ApiModelProperty(value = "A description of what the user is approving within the specified version.")
  public String getDescription() {
    return description;
  }

   /**
   * The status of the approval, which can be *PENDING*, *APPROVED*, or *DECLINED*
   * @return status
  **/
  @ApiModelProperty(value = "The status of the approval, which can be *PENDING*, *APPROVED*, or *DECLINED*")
  public String getStatus() {
    return status;
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
    VersionApprover versionApprover = (VersionApprover) o;
    return Objects.equals(this.accountId, versionApprover.accountId) &&
        Objects.equals(this.declineReason, versionApprover.declineReason) &&
        Objects.equals(this.description, versionApprover.description) &&
        Objects.equals(this.status, versionApprover.status) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, declineReason, description, status, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionApprover {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    declineReason: ").append(toIndentedString(declineReason)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties_)).append("\n");
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

