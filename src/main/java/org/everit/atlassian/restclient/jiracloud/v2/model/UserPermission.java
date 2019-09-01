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
import java.util.HashMap;
import java.util.Map;

/**
 * Details of a permission and its availability to a user.
 */
@ApiModel(description = "Details of a permission and its availability to a user.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:56:58.037+02:00[Europe/Prague]")
public class UserPermission {
  @JsonProperty("id")
  private String id;

  @JsonProperty("key")
  private String key;

  @JsonProperty("name")
  private String name;

  /**
   * The type of the permission.
   */
  public enum TypeEnum {
    GLOBAL("GLOBAL"),
    
    PROJECT("PROJECT");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  @JsonProperty("description")
  private String description;

  @JsonProperty("havePermission")
  private Boolean havePermission;

  @JsonProperty("deprecatedKey")
  private Boolean deprecatedKey;

  private HashMap<String, Object> additionalProperties_ = new HashMap<String, Object>();

  public UserPermission id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the permission. Either &#x60;id&#x60; or &#x60;key&#x60; must be specified. Use [Get all permissions](#api-rest-api-2-permissions-get) to get the list of permissions.
   * @return id
  **/
  @ApiModelProperty(value = "The ID of the permission. Either `id` or `key` must be specified. Use [Get all permissions](#api-rest-api-2-permissions-get) to get the list of permissions.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserPermission key(String key) {
    this.key = key;
    return this;
  }

   /**
   * The key of the permission. Either &#x60;id&#x60; or &#x60;key&#x60; must be specified. Use [Get all permissions](#api-rest-api-2-permissions-get) to get the list of permissions.
   * @return key
  **/
  @ApiModelProperty(value = "The key of the permission. Either `id` or `key` must be specified. Use [Get all permissions](#api-rest-api-2-permissions-get) to get the list of permissions.")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public UserPermission name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the permission.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the permission.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserPermission type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The type of the permission.
   * @return type
  **/
  @ApiModelProperty(value = "The type of the permission.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public UserPermission description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the permission.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the permission.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UserPermission havePermission(Boolean havePermission) {
    this.havePermission = havePermission;
    return this;
  }

   /**
   * Indicates whether the permission is available to the user in the queried context.
   * @return havePermission
  **/
  @ApiModelProperty(value = "Indicates whether the permission is available to the user in the queried context.")
  public Boolean getHavePermission() {
    return havePermission;
  }

  public void setHavePermission(Boolean havePermission) {
    this.havePermission = havePermission;
  }

  public UserPermission deprecatedKey(Boolean deprecatedKey) {
    this.deprecatedKey = deprecatedKey;
    return this;
  }

   /**
   * Indicate whether the permission key is deprecated. Note that deprecated keys cannot be used in the &#x60;permissions parameter of Get my permissions. Deprecated keys are not returned by Get all permissions.&#x60;
   * @return deprecatedKey
  **/
  @ApiModelProperty(value = "Indicate whether the permission key is deprecated. Note that deprecated keys cannot be used in the `permissions parameter of Get my permissions. Deprecated keys are not returned by Get all permissions.`")
  public Boolean getDeprecatedKey() {
    return deprecatedKey;
  }

  public void setDeprecatedKey(Boolean deprecatedKey) {
    this.deprecatedKey = deprecatedKey;
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
    UserPermission userPermission = (UserPermission) o;
    return Objects.equals(this.id, userPermission.id) &&
        Objects.equals(this.key, userPermission.key) &&
        Objects.equals(this.name, userPermission.name) &&
        Objects.equals(this.type, userPermission.type) &&
        Objects.equals(this.description, userPermission.description) &&
        Objects.equals(this.havePermission, userPermission.havePermission) &&
        Objects.equals(this.deprecatedKey, userPermission.deprecatedKey) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, key, name, type, description, havePermission, deprecatedKey, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserPermission {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    havePermission: ").append(toIndentedString(havePermission)).append("\n");
    sb.append("    deprecatedKey: ").append(toIndentedString(deprecatedKey)).append("\n");
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

