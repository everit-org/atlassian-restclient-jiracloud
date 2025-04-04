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
import java.util.UUID;
import org.everit.atlassian.restclient.jiracloud.v2.model.ServiceRegistryTier;

/**
 * ServiceRegistry
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class ServiceRegistry {
  @JsonProperty("description")
  private String description;

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("organizationId")
  private String organizationId;

  @JsonProperty("revision")
  private String revision;

  @JsonProperty("serviceTier")
  private ServiceRegistryTier serviceTier;

  public ServiceRegistry description(String description) {
    this.description = description;
    return this;
  }

   /**
   * service description
   * @return description
  **/
  @ApiModelProperty(value = "service description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceRegistry id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * service ID
   * @return id
  **/
  @ApiModelProperty(value = "service ID")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ServiceRegistry name(String name) {
    this.name = name;
    return this;
  }

   /**
   * service name
   * @return name
  **/
  @ApiModelProperty(value = "service name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceRegistry organizationId(String organizationId) {
    this.organizationId = organizationId;
    return this;
  }

   /**
   * organization ID
   * @return organizationId
  **/
  @ApiModelProperty(value = "organization ID")
  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  public ServiceRegistry revision(String revision) {
    this.revision = revision;
    return this;
  }

   /**
   * service revision
   * @return revision
  **/
  @ApiModelProperty(value = "service revision")
  public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public ServiceRegistry serviceTier(ServiceRegistryTier serviceTier) {
    this.serviceTier = serviceTier;
    return this;
  }

   /**
   * Get serviceTier
   * @return serviceTier
  **/
  @ApiModelProperty(value = "")
  public ServiceRegistryTier getServiceTier() {
    return serviceTier;
  }

  public void setServiceTier(ServiceRegistryTier serviceTier) {
    this.serviceTier = serviceTier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceRegistry serviceRegistry = (ServiceRegistry) o;
    return Objects.equals(this.description, serviceRegistry.description) &&
        Objects.equals(this.id, serviceRegistry.id) &&
        Objects.equals(this.name, serviceRegistry.name) &&
        Objects.equals(this.organizationId, serviceRegistry.organizationId) &&
        Objects.equals(this.revision, serviceRegistry.revision) &&
        Objects.equals(this.serviceTier, serviceRegistry.serviceTier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, id, name, organizationId, revision, serviceTier);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceRegistry {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
    sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
    sb.append("    serviceTier: ").append(toIndentedString(serviceTier)).append("\n");
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

