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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.everit.atlassian.restclient.jiracloud.v2.model.GroupName;
import org.everit.atlassian.restclient.jiracloud.v2.model.UserDetails;

/**
 * Details of the users and groups to receive the notification.
 */
@ApiModel(description = "Details of the users and groups to receive the notification.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:56:58.037+02:00[Europe/Prague]")
public class NotificationRecipients {
  @JsonProperty("reporter")
  private Boolean reporter;

  @JsonProperty("assignee")
  private Boolean assignee;

  @JsonProperty("watchers")
  private Boolean watchers;

  @JsonProperty("voters")
  private Boolean voters;

  @JsonProperty("users")
  private List<UserDetails> users = new ArrayList<>();

  @JsonProperty("groups")
  private List<GroupName> groups = new ArrayList<>();

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public NotificationRecipients reporter(Boolean reporter) {
    this.reporter = reporter;
    return this;
  }

   /**
   * Indicates whether the notification should be sent to the issue&#39;s reporter.
   * @return reporter
  **/
  @ApiModelProperty(value = "Indicates whether the notification should be sent to the issue's reporter.")
  public Boolean getReporter() {
    return reporter;
  }

  public void setReporter(Boolean reporter) {
    this.reporter = reporter;
  }

  public NotificationRecipients assignee(Boolean assignee) {
    this.assignee = assignee;
    return this;
  }

   /**
   * Indicates whether the notification should be sent to the issue&#39;s assignees.
   * @return assignee
  **/
  @ApiModelProperty(value = "Indicates whether the notification should be sent to the issue's assignees.")
  public Boolean getAssignee() {
    return assignee;
  }

  public void setAssignee(Boolean assignee) {
    this.assignee = assignee;
  }

  public NotificationRecipients watchers(Boolean watchers) {
    this.watchers = watchers;
    return this;
  }

   /**
   * Indicates whether the notification should be sent to the issue&#39;s watchers.
   * @return watchers
  **/
  @ApiModelProperty(value = "Indicates whether the notification should be sent to the issue's watchers.")
  public Boolean getWatchers() {
    return watchers;
  }

  public void setWatchers(Boolean watchers) {
    this.watchers = watchers;
  }

  public NotificationRecipients voters(Boolean voters) {
    this.voters = voters;
    return this;
  }

   /**
   * Indicates whether the notification should be sent to the issue&#39;s voters.
   * @return voters
  **/
  @ApiModelProperty(value = "Indicates whether the notification should be sent to the issue's voters.")
  public Boolean getVoters() {
    return voters;
  }

  public void setVoters(Boolean voters) {
    this.voters = voters;
  }

  public NotificationRecipients users(List<UserDetails> users) {
    this.users = users;
    return this;
  }

  public NotificationRecipients addUsersItem(UserDetails usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

   /**
   * List of users to receive the notification.
   * @return users
  **/
  @ApiModelProperty(value = "List of users to receive the notification.")
  public List<UserDetails> getUsers() {
    return users;
  }

  public void setUsers(List<UserDetails> users) {
    this.users = users;
  }

  public NotificationRecipients groups(List<GroupName> groups) {
    this.groups = groups;
    return this;
  }

  public NotificationRecipients addGroupsItem(GroupName groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * List of groups to receive the notification.
   * @return groups
  **/
  @ApiModelProperty(value = "List of groups to receive the notification.")
  public List<GroupName> getGroups() {
    return groups;
  }

  public void setGroups(List<GroupName> groups) {
    this.groups = groups;
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
    NotificationRecipients notificationRecipients = (NotificationRecipients) o;
    return Objects.equals(this.reporter, notificationRecipients.reporter) &&
        Objects.equals(this.assignee, notificationRecipients.assignee) &&
        Objects.equals(this.watchers, notificationRecipients.watchers) &&
        Objects.equals(this.voters, notificationRecipients.voters) &&
        Objects.equals(this.users, notificationRecipients.users) &&
        Objects.equals(this.groups, notificationRecipients.groups) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reporter, assignee, watchers, voters, users, groups, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationRecipients {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    reporter: ").append(toIndentedString(reporter)).append("\n");
    sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
    sb.append("    watchers: ").append(toIndentedString(watchers)).append("\n");
    sb.append("    voters: ").append(toIndentedString(voters)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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

