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
import org.everit.atlassian.restclient.jiracloud.v3.model.SharePermission;

/**
 * Details of a dashboard.
 */
@ApiModel(description = "Details of a dashboard.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class DashboardDetails {
  @JsonProperty("description")
  private String description;

  @JsonProperty("editPermissions")
  private List<SharePermission> editPermissions = new ArrayList<>();

  @JsonProperty("name")
  private String name;

  @JsonProperty("sharePermissions")
  private List<SharePermission> sharePermissions = new ArrayList<>();

  public DashboardDetails description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the dashboard.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the dashboard.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DashboardDetails editPermissions(List<SharePermission> editPermissions) {
    this.editPermissions = editPermissions;
    return this;
  }

  public DashboardDetails addEditPermissionsItem(SharePermission editPermissionsItem) {
    this.editPermissions.add(editPermissionsItem);
    return this;
  }

   /**
   * The edit permissions for the dashboard.
   * @return editPermissions
  **/
  @ApiModelProperty(required = true, value = "The edit permissions for the dashboard.")
  public List<SharePermission> getEditPermissions() {
    return editPermissions;
  }

  public void setEditPermissions(List<SharePermission> editPermissions) {
    this.editPermissions = editPermissions;
  }

  public DashboardDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the dashboard.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the dashboard.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DashboardDetails sharePermissions(List<SharePermission> sharePermissions) {
    this.sharePermissions = sharePermissions;
    return this;
  }

  public DashboardDetails addSharePermissionsItem(SharePermission sharePermissionsItem) {
    this.sharePermissions.add(sharePermissionsItem);
    return this;
  }

   /**
   * The share permissions for the dashboard.
   * @return sharePermissions
  **/
  @ApiModelProperty(required = true, value = "The share permissions for the dashboard.")
  public List<SharePermission> getSharePermissions() {
    return sharePermissions;
  }

  public void setSharePermissions(List<SharePermission> sharePermissions) {
    this.sharePermissions = sharePermissions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardDetails dashboardDetails = (DashboardDetails) o;
    return Objects.equals(this.description, dashboardDetails.description) &&
        Objects.equals(this.editPermissions, dashboardDetails.editPermissions) &&
        Objects.equals(this.name, dashboardDetails.name) &&
        Objects.equals(this.sharePermissions, dashboardDetails.sharePermissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, editPermissions, name, sharePermissions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardDetails {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    editPermissions: ").append(toIndentedString(editPermissions)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sharePermissions: ").append(toIndentedString(sharePermissions)).append("\n");
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

