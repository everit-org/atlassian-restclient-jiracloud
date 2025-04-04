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
import org.everit.atlassian.restclient.jiracloud.v2.model.FieldDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.GroupName;
import org.everit.atlassian.restclient.jiracloud.v2.model.ProjectRole;
import org.everit.atlassian.restclient.jiracloud.v2.model.UserDetails;

/**
 * Details about a notification associated with an event.
 */
@ApiModel(description = "Details about a notification associated with an event.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class EventNotification {
  @JsonProperty("emailAddress")
  private String emailAddress;

  @JsonProperty("expand")
  private String expand;

  @JsonProperty("field")
  private FieldDetails field;

  @JsonProperty("group")
  private GroupName group;

  @JsonProperty("id")
  private Long id;

  /**
   * Identifies the recipients of the notification.
   */
  public enum NotificationTypeEnum {
    CURRENTASSIGNEE("CurrentAssignee"),
    
    REPORTER("Reporter"),
    
    CURRENTUSER("CurrentUser"),
    
    PROJECTLEAD("ProjectLead"),
    
    COMPONENTLEAD("ComponentLead"),
    
    USER("User"),
    
    GROUP("Group"),
    
    PROJECTROLE("ProjectRole"),
    
    EMAILADDRESS("EmailAddress"),
    
    ALLWATCHERS("AllWatchers"),
    
    USERCUSTOMFIELD("UserCustomField"),
    
    GROUPCUSTOMFIELD("GroupCustomField");

    private String value;

    NotificationTypeEnum(String value) {
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
    public static NotificationTypeEnum fromValue(String value) {
      for (NotificationTypeEnum b : NotificationTypeEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("notificationType")
  private NotificationTypeEnum notificationType;

  @JsonProperty("parameter")
  private String parameter;

  @JsonProperty("projectRole")
  private ProjectRole projectRole;

  @JsonProperty("recipient")
  private String recipient;

  @JsonProperty("user")
  private UserDetails user;

  public EventNotification emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

   /**
   * The email address.
   * @return emailAddress
  **/
  @ApiModelProperty(value = "The email address.")
  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public EventNotification expand(String expand) {
    this.expand = expand;
    return this;
  }

   /**
   * Expand options that include additional event notification details in the response.
   * @return expand
  **/
  @ApiModelProperty(value = "Expand options that include additional event notification details in the response.")
  public String getExpand() {
    return expand;
  }

  public void setExpand(String expand) {
    this.expand = expand;
  }

  public EventNotification field(FieldDetails field) {
    this.field = field;
    return this;
  }

   /**
   * The custom user or group field.
   * @return field
  **/
  @ApiModelProperty(value = "The custom user or group field.")
  public FieldDetails getField() {
    return field;
  }

  public void setField(FieldDetails field) {
    this.field = field;
  }

  public EventNotification group(GroupName group) {
    this.group = group;
    return this;
  }

   /**
   * The specified group.
   * @return group
  **/
  @ApiModelProperty(value = "The specified group.")
  public GroupName getGroup() {
    return group;
  }

  public void setGroup(GroupName group) {
    this.group = group;
  }

  public EventNotification id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the notification.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the notification.")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EventNotification notificationType(NotificationTypeEnum notificationType) {
    this.notificationType = notificationType;
    return this;
  }

   /**
   * Identifies the recipients of the notification.
   * @return notificationType
  **/
  @ApiModelProperty(value = "Identifies the recipients of the notification.")
  public NotificationTypeEnum getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(NotificationTypeEnum notificationType) {
    this.notificationType = notificationType;
  }

  public EventNotification parameter(String parameter) {
    this.parameter = parameter;
    return this;
  }

   /**
   * As a group&#39;s name can change, use of &#x60;recipient&#x60; is recommended. The identifier associated with the &#x60;notificationType&#x60; value that defines the receiver of the notification, where the receiver isn&#39;t implied by &#x60;notificationType&#x60; value. So, when &#x60;notificationType&#x60; is:   *  &#x60;User&#x60; The &#x60;parameter&#x60; is the user account ID.  *  &#x60;Group&#x60; The &#x60;parameter&#x60; is the group name.  *  &#x60;ProjectRole&#x60; The &#x60;parameter&#x60; is the project role ID.  *  &#x60;UserCustomField&#x60; The &#x60;parameter&#x60; is the ID of the custom field.  *  &#x60;GroupCustomField&#x60; The &#x60;parameter&#x60; is the ID of the custom field.
   * @return parameter
  **/
  @ApiModelProperty(value = "As a group's name can change, use of `recipient` is recommended. The identifier associated with the `notificationType` value that defines the receiver of the notification, where the receiver isn't implied by `notificationType` value. So, when `notificationType` is:   *  `User` The `parameter` is the user account ID.  *  `Group` The `parameter` is the group name.  *  `ProjectRole` The `parameter` is the project role ID.  *  `UserCustomField` The `parameter` is the ID of the custom field.  *  `GroupCustomField` The `parameter` is the ID of the custom field.")
  public String getParameter() {
    return parameter;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  public EventNotification projectRole(ProjectRole projectRole) {
    this.projectRole = projectRole;
    return this;
  }

   /**
   * The specified project role.
   * @return projectRole
  **/
  @ApiModelProperty(value = "The specified project role.")
  public ProjectRole getProjectRole() {
    return projectRole;
  }

  public void setProjectRole(ProjectRole projectRole) {
    this.projectRole = projectRole;
  }

  public EventNotification recipient(String recipient) {
    this.recipient = recipient;
    return this;
  }

   /**
   * The identifier associated with the &#x60;notificationType&#x60; value that defines the receiver of the notification, where the receiver isn&#39;t implied by the &#x60;notificationType&#x60; value. So, when &#x60;notificationType&#x60; is:   *  &#x60;User&#x60;, &#x60;recipient&#x60; is the user account ID.  *  &#x60;Group&#x60;, &#x60;recipient&#x60; is the group ID.  *  &#x60;ProjectRole&#x60;, &#x60;recipient&#x60; is the project role ID.  *  &#x60;UserCustomField&#x60;, &#x60;recipient&#x60; is the ID of the custom field.  *  &#x60;GroupCustomField&#x60;, &#x60;recipient&#x60; is the ID of the custom field.
   * @return recipient
  **/
  @ApiModelProperty(value = "The identifier associated with the `notificationType` value that defines the receiver of the notification, where the receiver isn't implied by the `notificationType` value. So, when `notificationType` is:   *  `User`, `recipient` is the user account ID.  *  `Group`, `recipient` is the group ID.  *  `ProjectRole`, `recipient` is the project role ID.  *  `UserCustomField`, `recipient` is the ID of the custom field.  *  `GroupCustomField`, `recipient` is the ID of the custom field.")
  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public EventNotification user(UserDetails user) {
    this.user = user;
    return this;
  }

   /**
   * The specified user.
   * @return user
  **/
  @ApiModelProperty(value = "The specified user.")
  public UserDetails getUser() {
    return user;
  }

  public void setUser(UserDetails user) {
    this.user = user;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventNotification eventNotification = (EventNotification) o;
    return Objects.equals(this.emailAddress, eventNotification.emailAddress) &&
        Objects.equals(this.expand, eventNotification.expand) &&
        Objects.equals(this.field, eventNotification.field) &&
        Objects.equals(this.group, eventNotification.group) &&
        Objects.equals(this.id, eventNotification.id) &&
        Objects.equals(this.notificationType, eventNotification.notificationType) &&
        Objects.equals(this.parameter, eventNotification.parameter) &&
        Objects.equals(this.projectRole, eventNotification.projectRole) &&
        Objects.equals(this.recipient, eventNotification.recipient) &&
        Objects.equals(this.user, eventNotification.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailAddress, expand, field, group, id, notificationType, parameter, projectRole, recipient, user);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventNotification {\n");
    
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    expand: ").append(toIndentedString(expand)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
    sb.append("    parameter: ").append(toIndentedString(parameter)).append("\n");
    sb.append("    projectRole: ").append(toIndentedString(projectRole)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

