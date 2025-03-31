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
import java.util.ArrayList;
import java.util.List;

/**
 * Container for a list of webhook IDs.
 */
@ApiModel(description = "Container for a list of webhook IDs.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class ContainerForWebhookIDs {
  @JsonProperty("webhookIds")
  private List<Long> webhookIds = new ArrayList<>();

  public ContainerForWebhookIDs webhookIds(List<Long> webhookIds) {
    this.webhookIds = webhookIds;
    return this;
  }

  public ContainerForWebhookIDs addWebhookIdsItem(Long webhookIdsItem) {
    this.webhookIds.add(webhookIdsItem);
    return this;
  }

   /**
   * A list of webhook IDs.
   * @return webhookIds
  **/
  @ApiModelProperty(required = true, value = "A list of webhook IDs.")
  public List<Long> getWebhookIds() {
    return webhookIds;
  }

  public void setWebhookIds(List<Long> webhookIds) {
    this.webhookIds = webhookIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContainerForWebhookIDs containerForWebhookIDs = (ContainerForWebhookIDs) o;
    return Objects.equals(this.webhookIds, containerForWebhookIDs.webhookIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(webhookIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContainerForWebhookIDs {\n");
    
    sb.append("    webhookIds: ").append(toIndentedString(webhookIds)).append("\n");
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

