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
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v3.model.SimpleLink;
import org.everit.atlassian.restclient.jiracloud.v3.model.VersionApprover;
import org.everit.atlassian.restclient.jiracloud.v3.model.VersionIssuesStatus;

/**
 * Details about a project version.
 */
@ApiModel(description = "Details about a project version.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class Version {
  @JsonProperty("approvers")
  private List<VersionApprover> approvers = new ArrayList<>();

  @JsonProperty("archived")
  private Boolean archived;

  @JsonProperty("description")
  private String description;

  @JsonProperty("driver")
  private String driver;

  @JsonProperty("expand")
  private String expand;

  @JsonProperty("id")
  private String id;

  @JsonProperty("issuesStatusForFixVersion")
  private VersionIssuesStatus issuesStatusForFixVersion;

  @JsonProperty("moveUnfixedIssuesTo")
  private URI moveUnfixedIssuesTo;

  @JsonProperty("name")
  private String name;

  @JsonProperty("operations")
  private List<SimpleLink> operations = new ArrayList<>();

  @JsonProperty("overdue")
  private Boolean overdue;

  @JsonProperty("project")
  private String project;

  @JsonProperty("projectId")
  private Long projectId;

  @JsonProperty("releaseDate")
  private LocalDate releaseDate;

  @JsonProperty("released")
  private Boolean released;

  @JsonProperty("self")
  private URI self;

  @JsonProperty("startDate")
  private LocalDate startDate;

  @JsonProperty("userReleaseDate")
  private String userReleaseDate;

  @JsonProperty("userStartDate")
  private String userStartDate;

   /**
   * If the expand option &#x60;approvers&#x60; is used, returns a list containing the approvers for this version.
   * @return approvers
  **/
  @ApiModelProperty(value = "If the expand option `approvers` is used, returns a list containing the approvers for this version.")
  public List<VersionApprover> getApprovers() {
    return approvers;
  }

  public Version archived(Boolean archived) {
    this.archived = archived;
    return this;
  }

   /**
   * Indicates that the version is archived. Optional when creating or updating a version.
   * @return archived
  **/
  @ApiModelProperty(value = "Indicates that the version is archived. Optional when creating or updating a version.")
  public Boolean getArchived() {
    return archived;
  }

  public void setArchived(Boolean archived) {
    this.archived = archived;
  }

  public Version description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the version. Optional when creating or updating a version. The maximum size is 16,384 bytes.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the version. Optional when creating or updating a version. The maximum size is 16,384 bytes.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

   /**
   * If the expand option &#x60;driver&#x60; is used, returns the Atlassian account ID of the driver.
   * @return driver
  **/
  @ApiModelProperty(value = "If the expand option `driver` is used, returns the Atlassian account ID of the driver.")
  public String getDriver() {
    return driver;
  }

  public Version expand(String expand) {
    this.expand = expand;
    return this;
  }

   /**
   * Use [expand](em&gt;#expansion) to include additional information about version in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;operations&#x60; Returns the list of operations available for this version.  *  &#x60;issuesstatus&#x60; Returns the count of issues in this version for each of the status categories *to do*, *in progress*, *done*, and *unmapped*. The *unmapped* property contains a count of issues with a status other than *to do*, *in progress*, and *done*.  *  &#x60;driver&#x60; Returns the Atlassian account ID of the version driver.  *  &#x60;approvers&#x60; Returns a list containing approvers for this version.  Optional for create and update.
   * @return expand
  **/
  @ApiModelProperty(value = "Use [expand](em>#expansion) to include additional information about version in the response. This parameter accepts a comma-separated list. Expand options include:   *  `operations` Returns the list of operations available for this version.  *  `issuesstatus` Returns the count of issues in this version for each of the status categories *to do*, *in progress*, *done*, and *unmapped*. The *unmapped* property contains a count of issues with a status other than *to do*, *in progress*, and *done*.  *  `driver` Returns the Atlassian account ID of the version driver.  *  `approvers` Returns a list containing approvers for this version.  Optional for create and update.")
  public String getExpand() {
    return expand;
  }

  public void setExpand(String expand) {
    this.expand = expand;
  }

   /**
   * The ID of the version.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the version.")
  public String getId() {
    return id;
  }

   /**
   * If the expand option &#x60;issuesstatus&#x60; is used, returns the count of issues in this version for each of the status categories *to do*, *in progress*, *done*, and *unmapped*. The *unmapped* property contains a count of issues with a status other than *to do*, *in progress*, and *done*.
   * @return issuesStatusForFixVersion
  **/
  @ApiModelProperty(value = "If the expand option `issuesstatus` is used, returns the count of issues in this version for each of the status categories *to do*, *in progress*, *done*, and *unmapped*. The *unmapped* property contains a count of issues with a status other than *to do*, *in progress*, and *done*.")
  public VersionIssuesStatus getIssuesStatusForFixVersion() {
    return issuesStatusForFixVersion;
  }

  public Version moveUnfixedIssuesTo(URI moveUnfixedIssuesTo) {
    this.moveUnfixedIssuesTo = moveUnfixedIssuesTo;
    return this;
  }

   /**
   * The URL of the self link to the version to which all unfixed issues are moved when a version is released. Not applicable when creating a version. Optional when updating a version.
   * @return moveUnfixedIssuesTo
  **/
  @ApiModelProperty(value = "The URL of the self link to the version to which all unfixed issues are moved when a version is released. Not applicable when creating a version. Optional when updating a version.")
  public URI getMoveUnfixedIssuesTo() {
    return moveUnfixedIssuesTo;
  }

  public void setMoveUnfixedIssuesTo(URI moveUnfixedIssuesTo) {
    this.moveUnfixedIssuesTo = moveUnfixedIssuesTo;
  }

  public Version name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The unique name of the version. Required when creating a version. Optional when updating a version. The maximum length is 255 characters.
   * @return name
  **/
  @ApiModelProperty(value = "The unique name of the version. Required when creating a version. Optional when updating a version. The maximum length is 255 characters.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

   /**
   * If the expand option &#x60;operations&#x60; is used, returns the list of operations available for this version.
   * @return operations
  **/
  @ApiModelProperty(value = "If the expand option `operations` is used, returns the list of operations available for this version.")
  public List<SimpleLink> getOperations() {
    return operations;
  }

   /**
   * Indicates that the version is overdue.
   * @return overdue
  **/
  @ApiModelProperty(value = "Indicates that the version is overdue.")
  public Boolean getOverdue() {
    return overdue;
  }

  public Version project(String project) {
    this.project = project;
    return this;
  }

   /**
   * Deprecated. Use &#x60;projectId&#x60;.
   * @return project
  **/
  @ApiModelProperty(value = "Deprecated. Use `projectId`.")
  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public Version projectId(Long projectId) {
    this.projectId = projectId;
    return this;
  }

   /**
   * The ID of the project to which this version is attached. Required when creating a version. Not applicable when updating a version.
   * @return projectId
  **/
  @ApiModelProperty(value = "The ID of the project to which this version is attached. Required when creating a version. Not applicable when updating a version.")
  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  public Version releaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

   /**
   * The release date of the version. Expressed in ISO 8601 format (yyyy-mm-dd). Optional when creating or updating a version.
   * @return releaseDate
  **/
  @ApiModelProperty(value = "The release date of the version. Expressed in ISO 8601 format (yyyy-mm-dd). Optional when creating or updating a version.")
  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Version released(Boolean released) {
    this.released = released;
    return this;
  }

   /**
   * Indicates that the version is released. If the version is released a request to release again is ignored. Not applicable when creating a version. Optional when updating a version.
   * @return released
  **/
  @ApiModelProperty(value = "Indicates that the version is released. If the version is released a request to release again is ignored. Not applicable when creating a version. Optional when updating a version.")
  public Boolean getReleased() {
    return released;
  }

  public void setReleased(Boolean released) {
    this.released = released;
  }

   /**
   * The URL of the version.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the version.")
  public URI getSelf() {
    return self;
  }

  public Version startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * The start date of the version. Expressed in ISO 8601 format (yyyy-mm-dd). Optional when creating or updating a version.
   * @return startDate
  **/
  @ApiModelProperty(value = "The start date of the version. Expressed in ISO 8601 format (yyyy-mm-dd). Optional when creating or updating a version.")
  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

   /**
   * The date on which work on this version is expected to finish, expressed in the instance&#39;s *Day/Month/Year Format* date format.
   * @return userReleaseDate
  **/
  @ApiModelProperty(value = "The date on which work on this version is expected to finish, expressed in the instance's *Day/Month/Year Format* date format.")
  public String getUserReleaseDate() {
    return userReleaseDate;
  }

   /**
   * The date on which work on this version is expected to start, expressed in the instance&#39;s *Day/Month/Year Format* date format.
   * @return userStartDate
  **/
  @ApiModelProperty(value = "The date on which work on this version is expected to start, expressed in the instance's *Day/Month/Year Format* date format.")
  public String getUserStartDate() {
    return userStartDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Version version = (Version) o;
    return Objects.equals(this.approvers, version.approvers) &&
        Objects.equals(this.archived, version.archived) &&
        Objects.equals(this.description, version.description) &&
        Objects.equals(this.driver, version.driver) &&
        Objects.equals(this.expand, version.expand) &&
        Objects.equals(this.id, version.id) &&
        Objects.equals(this.issuesStatusForFixVersion, version.issuesStatusForFixVersion) &&
        Objects.equals(this.moveUnfixedIssuesTo, version.moveUnfixedIssuesTo) &&
        Objects.equals(this.name, version.name) &&
        Objects.equals(this.operations, version.operations) &&
        Objects.equals(this.overdue, version.overdue) &&
        Objects.equals(this.project, version.project) &&
        Objects.equals(this.projectId, version.projectId) &&
        Objects.equals(this.releaseDate, version.releaseDate) &&
        Objects.equals(this.released, version.released) &&
        Objects.equals(this.self, version.self) &&
        Objects.equals(this.startDate, version.startDate) &&
        Objects.equals(this.userReleaseDate, version.userReleaseDate) &&
        Objects.equals(this.userStartDate, version.userStartDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(approvers, archived, description, driver, expand, id, issuesStatusForFixVersion, moveUnfixedIssuesTo, name, operations, overdue, project, projectId, releaseDate, released, self, startDate, userReleaseDate, userStartDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Version {\n");
    
    sb.append("    approvers: ").append(toIndentedString(approvers)).append("\n");
    sb.append("    archived: ").append(toIndentedString(archived)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    driver: ").append(toIndentedString(driver)).append("\n");
    sb.append("    expand: ").append(toIndentedString(expand)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    issuesStatusForFixVersion: ").append(toIndentedString(issuesStatusForFixVersion)).append("\n");
    sb.append("    moveUnfixedIssuesTo: ").append(toIndentedString(moveUnfixedIssuesTo)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
    sb.append("    overdue: ").append(toIndentedString(overdue)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    released: ").append(toIndentedString(released)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    userReleaseDate: ").append(toIndentedString(userReleaseDate)).append("\n");
    sb.append("    userStartDate: ").append(toIndentedString(userStartDate)).append("\n");
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

