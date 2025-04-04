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

/**
 * UserBeanAvatarUrls
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class UserBeanAvatarUrls {
  @JsonProperty("16x16")
  private URI _16x16;

  @JsonProperty("24x24")
  private URI _24x24;

  @JsonProperty("32x32")
  private URI _32x32;

  @JsonProperty("48x48")
  private URI _48x48;

  public UserBeanAvatarUrls _16x16(URI _16x16) {
    this._16x16 = _16x16;
    return this;
  }

   /**
   * The URL of the user&#39;s 16x16 pixel avatar.
   * @return _16x16
  **/
  @ApiModelProperty(value = "The URL of the user's 16x16 pixel avatar.")
  public URI get16x16() {
    return _16x16;
  }

  public void set16x16(URI _16x16) {
    this._16x16 = _16x16;
  }

  public UserBeanAvatarUrls _24x24(URI _24x24) {
    this._24x24 = _24x24;
    return this;
  }

   /**
   * The URL of the user&#39;s 24x24 pixel avatar.
   * @return _24x24
  **/
  @ApiModelProperty(value = "The URL of the user's 24x24 pixel avatar.")
  public URI get24x24() {
    return _24x24;
  }

  public void set24x24(URI _24x24) {
    this._24x24 = _24x24;
  }

  public UserBeanAvatarUrls _32x32(URI _32x32) {
    this._32x32 = _32x32;
    return this;
  }

   /**
   * The URL of the user&#39;s 32x32 pixel avatar.
   * @return _32x32
  **/
  @ApiModelProperty(value = "The URL of the user's 32x32 pixel avatar.")
  public URI get32x32() {
    return _32x32;
  }

  public void set32x32(URI _32x32) {
    this._32x32 = _32x32;
  }

  public UserBeanAvatarUrls _48x48(URI _48x48) {
    this._48x48 = _48x48;
    return this;
  }

   /**
   * The URL of the user&#39;s 48x48 pixel avatar.
   * @return _48x48
  **/
  @ApiModelProperty(value = "The URL of the user's 48x48 pixel avatar.")
  public URI get48x48() {
    return _48x48;
  }

  public void set48x48(URI _48x48) {
    this._48x48 = _48x48;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserBeanAvatarUrls userBeanAvatarUrls = (UserBeanAvatarUrls) o;
    return Objects.equals(this._16x16, userBeanAvatarUrls._16x16) &&
        Objects.equals(this._24x24, userBeanAvatarUrls._24x24) &&
        Objects.equals(this._32x32, userBeanAvatarUrls._32x32) &&
        Objects.equals(this._48x48, userBeanAvatarUrls._48x48);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_16x16, _24x24, _32x32, _48x48);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBeanAvatarUrls {\n");
    
    sb.append("    _16x16: ").append(toIndentedString(_16x16)).append("\n");
    sb.append("    _24x24: ").append(toIndentedString(_24x24)).append("\n");
    sb.append("    _32x32: ").append(toIndentedString(_32x32)).append("\n");
    sb.append("    _48x48: ").append(toIndentedString(_48x48)).append("\n");
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

