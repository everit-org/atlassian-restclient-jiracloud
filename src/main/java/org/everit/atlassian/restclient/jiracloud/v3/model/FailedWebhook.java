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

/**
 * Details about a failed webhook.
 */
@ApiModel(description = "Details about a failed webhook.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:43.813+01:00[Europe/Prague]")
public class FailedWebhook {
  @JsonProperty("body")
  private String body;

  @JsonProperty("failureTime")
  private Long failureTime;

  @JsonProperty("id")
  private String id;

  @JsonProperty("url")
  private String url;

  public FailedWebhook body(String body) {
    this.body = body;
    return this;
  }

   /**
   * The webhook body.
   * @return body
  **/
  @ApiModelProperty(value = "The webhook body.")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public FailedWebhook failureTime(Long failureTime) {
    this.failureTime = failureTime;
    return this;
  }

   /**
   * The time the webhook was added to the list of failed webhooks (that is, the time of the last failed retry).
   * @return failureTime
  **/
  @ApiModelProperty(required = true, value = "The time the webhook was added to the list of failed webhooks (that is, the time of the last failed retry).")
  public Long getFailureTime() {
    return failureTime;
  }

  public void setFailureTime(Long failureTime) {
    this.failureTime = failureTime;
  }

  public FailedWebhook id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The webhook ID, as sent in the &#x60;X-Atlassian-Webhook-Identifier&#x60; header with the webhook.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The webhook ID, as sent in the `X-Atlassian-Webhook-Identifier` header with the webhook.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FailedWebhook url(String url) {
    this.url = url;
    return this;
  }

   /**
   * The original webhook destination.
   * @return url
  **/
  @ApiModelProperty(required = true, value = "The original webhook destination.")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedWebhook failedWebhook = (FailedWebhook) o;
    return Objects.equals(this.body, failedWebhook.body) &&
        Objects.equals(this.failureTime, failedWebhook.failureTime) &&
        Objects.equals(this.id, failedWebhook.id) &&
        Objects.equals(this.url, failedWebhook.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(body, failureTime, id, url);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedWebhook {\n");
    
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    failureTime: ").append(toIndentedString(failureTime)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

