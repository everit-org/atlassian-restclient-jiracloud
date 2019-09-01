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
import java.net.URI;

/**
 * MoveFieldBean
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:57:05.408+02:00[Europe/Prague]")
public class MoveFieldBean {
  @JsonProperty("after")
  private URI after;

  /**
   * The named position to which the screen tab field should be moved. Required if &#x60;after&#x60; isn&#39;t provided.
   */
  public enum PositionEnum {
    EARLIER("Earlier"),
    
    LATER("Later"),
    
    FIRST("First"),
    
    LAST("Last");

    private String value;

    PositionEnum(String value) {
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
    public static PositionEnum fromValue(String value) {
      for (PositionEnum b : PositionEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("position")
  private PositionEnum position;

  public MoveFieldBean after(URI after) {
    this.after = after;
    return this;
  }

   /**
   * The ID of the screen tab field after which to place the moved screen tab field. Required if &#x60;position&#x60; isn&#39;t provided.
   * @return after
  **/
  @ApiModelProperty(value = "The ID of the screen tab field after which to place the moved screen tab field. Required if `position` isn't provided.")
  public URI getAfter() {
    return after;
  }

  public void setAfter(URI after) {
    this.after = after;
  }

  public MoveFieldBean position(PositionEnum position) {
    this.position = position;
    return this;
  }

   /**
   * The named position to which the screen tab field should be moved. Required if &#x60;after&#x60; isn&#39;t provided.
   * @return position
  **/
  @ApiModelProperty(value = "The named position to which the screen tab field should be moved. Required if `after` isn't provided.")
  public PositionEnum getPosition() {
    return position;
  }

  public void setPosition(PositionEnum position) {
    this.position = position;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoveFieldBean moveFieldBean = (MoveFieldBean) o;
    return Objects.equals(this.after, moveFieldBean.after) &&
        Objects.equals(this.position, moveFieldBean.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(after, position);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoveFieldBean {\n");
    sb.append("    after: ").append(toIndentedString(after)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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

