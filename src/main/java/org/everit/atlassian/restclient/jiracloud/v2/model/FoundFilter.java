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
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.FilterSubscription;
import org.everit.atlassian.restclient.jiracloud.v2.model.SharePermission;
import org.everit.atlassian.restclient.jiracloud.v2.model.User;

/**
 * Details of a filter identified as part of a search.
 */
@ApiModel(description = "Details of a filter identified as part of a search.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:56:58.037+02:00[Europe/Prague]")
public class FoundFilter {
  @JsonProperty("self")
  private URI self;

  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("owner")
  private User owner;

  @JsonProperty("jql")
  private String jql;

  @JsonProperty("viewUrl")
  private URI viewUrl;

  @JsonProperty("searchUrl")
  private URI searchUrl;

  @JsonProperty("favourite")
  private Boolean favourite;

  @JsonProperty("favouritedCount")
  private Long favouritedCount;

  @JsonProperty("sharePermissions")
  private List<SharePermission> sharePermissions = new ArrayList<>();

  @JsonProperty("subscriptions")
  private List<FilterSubscription> subscriptions = new ArrayList<>();

   /**
   * The URL of the filter.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the filter.")
  public URI getSelf() {
    return self;
  }

   /**
   * The unique identifier for the filter.
   * @return id
  **/
  @ApiModelProperty(value = "The unique identifier for the filter.")
  public String getId() {
    return id;
  }

  public FoundFilter name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the filter. Must be unique.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the filter. Must be unique.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FoundFilter description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A description of the filter.
   * @return description
  **/
  @ApiModelProperty(value = "A description of the filter.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

   /**
   * The user who owns the filter. This is defaulted to the creator of the filter, however Jira administrators can change the owner of a shared filter in the admin settings.
   * @return owner
  **/
  @ApiModelProperty(value = "The user who owns the filter. This is defaulted to the creator of the filter, however Jira administrators can change the owner of a shared filter in the admin settings.")
  public User getOwner() {
    return owner;
  }

   /**
   * The JQL query for the filter. For example, *project &#x3D; SSP AND issuetype &#x3D; Bug*.
   * @return jql
  **/
  @ApiModelProperty(value = "The JQL query for the filter. For example, *project = SSP AND issuetype = Bug*.")
  public String getJql() {
    return jql;
  }

   /**
   * A URL to view the filter results in Jira, using the ID of the filter. For example, *https://your-domain.atlassian.net/issues/?filter&#x3D;10100*.
   * @return viewUrl
  **/
  @ApiModelProperty(value = "A URL to view the filter results in Jira, using the ID of the filter. For example, *https://your-domain.atlassian.net/issues/?filter=10100*.")
  public URI getViewUrl() {
    return viewUrl;
  }

   /**
   * A URL to view the filter results in Jira, using the [Search for issues using JQL](#api-rest-api-2-filter-search-get) operation with the filter&#39;s JQL string to return the filter results. For example, *https://your-domain.atlassian.net/rest/api/2/search?jql&#x3D;project+%3D+SSP+AND+issuetype+%3D+Bug*.
   * @return searchUrl
  **/
  @ApiModelProperty(value = "A URL to view the filter results in Jira, using the [Search for issues using JQL](#api-rest-api-2-filter-search-get) operation with the filter's JQL string to return the filter results. For example, *https://your-domain.atlassian.net/rest/api/2/search?jql=project+%3D+SSP+AND+issuetype+%3D+Bug*.")
  public URI getSearchUrl() {
    return searchUrl;
  }

   /**
   * Indicates whether the filter is selected as a favorite by any users, not including the filter owner.
   * @return favourite
  **/
  @ApiModelProperty(value = "Indicates whether the filter is selected as a favorite by any users, not including the filter owner.")
  public Boolean getFavourite() {
    return favourite;
  }

   /**
   * The count of how many users have selected this filter as a favorite, including the filter owner.
   * @return favouritedCount
  **/
  @ApiModelProperty(value = "The count of how many users have selected this filter as a favorite, including the filter owner.")
  public Long getFavouritedCount() {
    return favouritedCount;
  }

  public FoundFilter sharePermissions(List<SharePermission> sharePermissions) {
    this.sharePermissions = sharePermissions;
    return this;
  }

  public FoundFilter addSharePermissionsItem(SharePermission sharePermissionsItem) {
    if (this.sharePermissions == null) {
      this.sharePermissions = new ArrayList<>();
    }
    this.sharePermissions.add(sharePermissionsItem);
    return this;
  }

   /**
   * The groups and projects that the filter is shared with. This can be specified when updating a filter, but not when creating a filter.
   * @return sharePermissions
  **/
  @ApiModelProperty(value = "The groups and projects that the filter is shared with. This can be specified when updating a filter, but not when creating a filter.")
  public List<SharePermission> getSharePermissions() {
    return sharePermissions;
  }

  public void setSharePermissions(List<SharePermission> sharePermissions) {
    this.sharePermissions = sharePermissions;
  }

   /**
   * The users that are subscribed to the filter.
   * @return subscriptions
  **/
  @ApiModelProperty(value = "The users that are subscribed to the filter.")
  public List<FilterSubscription> getSubscriptions() {
    return subscriptions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoundFilter foundFilter = (FoundFilter) o;
    return Objects.equals(this.self, foundFilter.self) &&
        Objects.equals(this.id, foundFilter.id) &&
        Objects.equals(this.name, foundFilter.name) &&
        Objects.equals(this.description, foundFilter.description) &&
        Objects.equals(this.owner, foundFilter.owner) &&
        Objects.equals(this.jql, foundFilter.jql) &&
        Objects.equals(this.viewUrl, foundFilter.viewUrl) &&
        Objects.equals(this.searchUrl, foundFilter.searchUrl) &&
        Objects.equals(this.favourite, foundFilter.favourite) &&
        Objects.equals(this.favouritedCount, foundFilter.favouritedCount) &&
        Objects.equals(this.sharePermissions, foundFilter.sharePermissions) &&
        Objects.equals(this.subscriptions, foundFilter.subscriptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, id, name, description, owner, jql, viewUrl, searchUrl, favourite, favouritedCount, sharePermissions, subscriptions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoundFilter {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    jql: ").append(toIndentedString(jql)).append("\n");
    sb.append("    viewUrl: ").append(toIndentedString(viewUrl)).append("\n");
    sb.append("    searchUrl: ").append(toIndentedString(searchUrl)).append("\n");
    sb.append("    favourite: ").append(toIndentedString(favourite)).append("\n");
    sb.append("    favouritedCount: ").append(toIndentedString(favouritedCount)).append("\n");
    sb.append("    sharePermissions: ").append(toIndentedString(sharePermissions)).append("\n");
    sb.append("    subscriptions: ").append(toIndentedString(subscriptions)).append("\n");
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

