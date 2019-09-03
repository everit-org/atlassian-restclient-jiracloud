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
import java.util.ArrayList;
import java.util.List;

/**
 * List of issues and JQL queries.
 */
@ApiModel(description = "List of issues and JQL queries.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:56:58.037+02:00[Europe/Prague]")
public class IssuesAndJQLQueries {
  @JsonProperty("jqls")
  private List<String> jqls = new ArrayList<>();

  @JsonProperty("issueIds")
  private List<Long> issueIds = new ArrayList<>();

  public IssuesAndJQLQueries jqls(List<String> jqls) {
    this.jqls = jqls;
    return this;
  }

  public IssuesAndJQLQueries addJqlsItem(String jqlsItem) {
    this.jqls.add(jqlsItem);
    return this;
  }

   /**
   * A list of JQL queries.
   * @return jqls
  **/
  @ApiModelProperty(required = true, value = "A list of JQL queries.")
  public List<String> getJqls() {
    return jqls;
  }

  public void setJqls(List<String> jqls) {
    this.jqls = jqls;
  }

  public IssuesAndJQLQueries issueIds(List<Long> issueIds) {
    this.issueIds = issueIds;
    return this;
  }

  public IssuesAndJQLQueries addIssueIdsItem(Long issueIdsItem) {
    this.issueIds.add(issueIdsItem);
    return this;
  }

   /**
   * A list of issue IDs.
   * @return issueIds
  **/
  @ApiModelProperty(required = true, value = "A list of issue IDs.")
  public List<Long> getIssueIds() {
    return issueIds;
  }

  public void setIssueIds(List<Long> issueIds) {
    this.issueIds = issueIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssuesAndJQLQueries issuesAndJQLQueries = (IssuesAndJQLQueries) o;
    return Objects.equals(this.jqls, issuesAndJQLQueries.jqls) &&
        Objects.equals(this.issueIds, issuesAndJQLQueries.issueIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jqls, issueIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssuesAndJQLQueries {\n");
    sb.append("    jqls: ").append(toIndentedString(jqls)).append("\n");
    sb.append("    issueIds: ").append(toIndentedString(issueIds)).append("\n");
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
