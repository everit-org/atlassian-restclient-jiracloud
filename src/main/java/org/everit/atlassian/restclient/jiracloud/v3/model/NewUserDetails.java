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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The user details.
 */
@ApiModel(description = "The user details.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class NewUserDetails {
  @JsonProperty("applicationKeys")
  private List<String> applicationKeys = new ArrayList<>();

  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("emailAddress")
  private String emailAddress;

  @JsonProperty("key")
  private String key;

  @JsonProperty("name")
  private String name;

  @JsonProperty("password")
  private String password;

  @JsonProperty("products")
  private List<String> products = new ArrayList<>();

  @JsonProperty("self")
  private String self;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public NewUserDetails applicationKeys(List<String> applicationKeys) {
    this.applicationKeys = applicationKeys;
    return this;
  }

  public NewUserDetails addApplicationKeysItem(String applicationKeysItem) {
    if (this.applicationKeys == null) {
      this.applicationKeys = new ArrayList<>();
    }
    this.applicationKeys.add(applicationKeysItem);
    return this;
  }

   /**
   * Deprecated, do not use.
   * @return applicationKeys
  **/
  @ApiModelProperty(value = "Deprecated, do not use.")
  public List<String> getApplicationKeys() {
    return applicationKeys;
  }

  public void setApplicationKeys(List<String> applicationKeys) {
    this.applicationKeys = applicationKeys;
  }

  public NewUserDetails displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * This property is no longer available. If the user has an Atlassian account, their display name is not changed. If the user does not have an Atlassian account, they are sent an email asking them set up an account.
   * @return displayName
  **/
  @ApiModelProperty(value = "This property is no longer available. If the user has an Atlassian account, their display name is not changed. If the user does not have an Atlassian account, they are sent an email asking them set up an account.")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public NewUserDetails emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

   /**
   * The email address for the user.
   * @return emailAddress
  **/
  @ApiModelProperty(required = true, value = "The email address for the user.")
  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public NewUserDetails key(String key) {
    this.key = key;
    return this;
  }

   /**
   * This property is no longer available. See the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
   * @return key
  **/
  @ApiModelProperty(value = "This property is no longer available. See the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public NewUserDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * This property is no longer available. See the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
   * @return name
  **/
  @ApiModelProperty(value = "This property is no longer available. See the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NewUserDetails password(String password) {
    this.password = password;
    return this;
  }

   /**
   * This property is no longer available. If the user has an Atlassian account, their password is not changed. If the user does not have an Atlassian account, they are sent an email asking them set up an account.
   * @return password
  **/
  @ApiModelProperty(value = "This property is no longer available. If the user has an Atlassian account, their password is not changed. If the user does not have an Atlassian account, they are sent an email asking them set up an account.")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public NewUserDetails products(List<String> products) {
    this.products = products;
    return this;
  }

  public NewUserDetails addProductsItem(String productsItem) {
    this.products.add(productsItem);
    return this;
  }

   /**
   * Products the new user has access to. Valid products are: jira-core, jira-servicedesk, jira-product-discovery, jira-software. To create a user without product access, set this field to be an empty array.
   * @return products
  **/
  @ApiModelProperty(required = true, value = "Products the new user has access to. Valid products are: jira-core, jira-servicedesk, jira-product-discovery, jira-software. To create a user without product access, set this field to be an empty array.")
  public List<String> getProducts() {
    return products;
  }

  public void setProducts(List<String> products) {
    this.products = products;
  }

   /**
   * The URL of the user.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the user.")
  public String getSelf() {
    return self;
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
    NewUserDetails newUserDetails = (NewUserDetails) o;
    return Objects.equals(this.applicationKeys, newUserDetails.applicationKeys) &&
        Objects.equals(this.displayName, newUserDetails.displayName) &&
        Objects.equals(this.emailAddress, newUserDetails.emailAddress) &&
        Objects.equals(this.key, newUserDetails.key) &&
        Objects.equals(this.name, newUserDetails.name) &&
        Objects.equals(this.password, newUserDetails.password) &&
        Objects.equals(this.products, newUserDetails.products) &&
        Objects.equals(this.self, newUserDetails.self) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationKeys, displayName, emailAddress, key, name, password, products, self, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewUserDetails {\n");
    
    sb.append("    applicationKeys: ").append(toIndentedString(applicationKeys)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
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

