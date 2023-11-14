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
import org.everit.atlassian.restclient.jiracloud.v2.model.AvatarUrlsBean;

/**
 * User details permitted by the user&#39;s Atlassian Account privacy settings. However, be aware of these exceptions:   *  User record deleted from Atlassian: This occurs as the result of a right to be forgotten request. In this case, &#x60;displayName&#x60; provides an indication and other parameters have default values or are blank (for example, email is blank).  *  User record corrupted: This occurs as a results of events such as a server import and can only happen to deleted users. In this case, &#x60;accountId&#x60; returns *unknown* and all other parameters have fallback values.  *  User record unavailable: This usually occurs due to an internal service outage. In this case, all parameters have fallback values.
 */
@ApiModel(description = "User details permitted by the user's Atlassian Account privacy settings. However, be aware of these exceptions:   *  User record deleted from Atlassian: This occurs as the result of a right to be forgotten request. In this case, `displayName` provides an indication and other parameters have default values or are blank (for example, email is blank).  *  User record corrupted: This occurs as a results of events such as a server import and can only happen to deleted users. In this case, `accountId` returns *unknown* and all other parameters have fallback values.  *  User record unavailable: This usually occurs due to an internal service outage. In this case, all parameters have fallback values.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class UserDetails {
  @JsonProperty("accountId")
  private String accountId;

  @JsonProperty("accountType")
  private String accountType;

  @JsonProperty("active")
  private Boolean active;

  @JsonProperty("avatarUrls")
  private AvatarUrlsBean avatarUrls;

  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("emailAddress")
  private String emailAddress;

  @JsonProperty("key")
  private String key;

  @JsonProperty("name")
  private String name;

  @JsonProperty("self")
  private String self;

  @JsonProperty("timeZone")
  private String timeZone;

  public UserDetails accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.
   * @return accountId
  **/
  @ApiModelProperty(value = "The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

   /**
   * The type of account represented by this user. This will be one of &#39;atlassian&#39; (normal users), &#39;app&#39; (application user) or &#39;customer&#39; (Jira Service Desk customer user)
   * @return accountType
  **/
  @ApiModelProperty(value = "The type of account represented by this user. This will be one of 'atlassian' (normal users), 'app' (application user) or 'customer' (Jira Service Desk customer user)")
  public String getAccountType() {
    return accountType;
  }

   /**
   * Whether the user is active.
   * @return active
  **/
  @ApiModelProperty(value = "Whether the user is active.")
  public Boolean getActive() {
    return active;
  }

   /**
   * The avatars of the user.
   * @return avatarUrls
  **/
  @ApiModelProperty(value = "The avatars of the user.")
  public AvatarUrlsBean getAvatarUrls() {
    return avatarUrls;
  }

   /**
   * The display name of the user. Depending on the user’s privacy settings, this may return an alternative value.
   * @return displayName
  **/
  @ApiModelProperty(value = "The display name of the user. Depending on the user’s privacy settings, this may return an alternative value.")
  public String getDisplayName() {
    return displayName;
  }

   /**
   * The email address of the user. Depending on the user’s privacy settings, this may be returned as null.
   * @return emailAddress
  **/
  @ApiModelProperty(value = "The email address of the user. Depending on the user’s privacy settings, this may be returned as null.")
  public String getEmailAddress() {
    return emailAddress;
  }

   /**
   * This property is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
   * @return key
  **/
  @ApiModelProperty(value = "This property is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.")
  public String getKey() {
    return key;
  }

   /**
   * This property is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
   * @return name
  **/
  @ApiModelProperty(value = "This property is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.")
  public String getName() {
    return name;
  }

   /**
   * The URL of the user.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the user.")
  public String getSelf() {
    return self;
  }

   /**
   * The time zone specified in the user&#39;s profile. Depending on the user’s privacy settings, this may be returned as null.
   * @return timeZone
  **/
  @ApiModelProperty(value = "The time zone specified in the user's profile. Depending on the user’s privacy settings, this may be returned as null.")
  public String getTimeZone() {
    return timeZone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDetails userDetails = (UserDetails) o;
    return Objects.equals(this.accountId, userDetails.accountId) &&
        Objects.equals(this.accountType, userDetails.accountType) &&
        Objects.equals(this.active, userDetails.active) &&
        Objects.equals(this.avatarUrls, userDetails.avatarUrls) &&
        Objects.equals(this.displayName, userDetails.displayName) &&
        Objects.equals(this.emailAddress, userDetails.emailAddress) &&
        Objects.equals(this.key, userDetails.key) &&
        Objects.equals(this.name, userDetails.name) &&
        Objects.equals(this.self, userDetails.self) &&
        Objects.equals(this.timeZone, userDetails.timeZone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountType, active, avatarUrls, displayName, emailAddress, key, name, self, timeZone);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDetails {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    avatarUrls: ").append(toIndentedString(avatarUrls)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
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

