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
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v3.model.ScreenID;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowRules;

/**
 * Details of a workflow transition.
 */
@ApiModel(description = "Details of a workflow transition.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:57:05.408+02:00[Europe/Prague]")
public class Transition {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("from")
  private List<String> from = new ArrayList<>();

  @JsonProperty("to")
  private String to;

  /**
   * The type of the transition.
   */
  public enum TypeEnum {
    GLOBAL("global"),
    
    INITIAL("initial"),
    
    DIRECTED("directed");

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

  @JsonProperty("screen")
  private ScreenID screen;

  @JsonProperty("rules")
  private WorkflowRules rules;

  public Transition id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the transition.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the transition.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Transition name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the transition.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the transition.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Transition description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the transition.
   * @return description
  **/
  @ApiModelProperty(required = true, value = "The description of the transition.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Transition from(List<String> from) {
    this.from = from;
    return this;
  }

  public Transition addFromItem(String fromItem) {
    this.from.add(fromItem);
    return this;
  }

   /**
   * The list of statuses from which the transition can be taken.
   * @return from
  **/
  @ApiModelProperty(required = true, value = "The list of statuses from which the transition can be taken.")
  public List<String> getFrom() {
    return from;
  }

  public void setFrom(List<String> from) {
    this.from = from;
  }

  public Transition to(String to) {
    this.to = to;
    return this;
  }

   /**
   * The status to which the transition leads.
   * @return to
  **/
  @ApiModelProperty(required = true, value = "The status to which the transition leads.")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Transition type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The type of the transition.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The type of the transition.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Transition screen(ScreenID screen) {
    this.screen = screen;
    return this;
  }

   /**
   * Get screen
   * @return screen
  **/
  @ApiModelProperty(value = "")
  public ScreenID getScreen() {
    return screen;
  }

  public void setScreen(ScreenID screen) {
    this.screen = screen;
  }

  public Transition rules(WorkflowRules rules) {
    this.rules = rules;
    return this;
  }

   /**
   * Get rules
   * @return rules
  **/
  @ApiModelProperty(value = "")
  public WorkflowRules getRules() {
    return rules;
  }

  public void setRules(WorkflowRules rules) {
    this.rules = rules;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transition transition = (Transition) o;
    return Objects.equals(this.id, transition.id) &&
        Objects.equals(this.name, transition.name) &&
        Objects.equals(this.description, transition.description) &&
        Objects.equals(this.from, transition.from) &&
        Objects.equals(this.to, transition.to) &&
        Objects.equals(this.type, transition.type) &&
        Objects.equals(this.screen, transition.screen) &&
        Objects.equals(this.rules, transition.rules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, from, to, type, screen, rules);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transition {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    screen: ").append(toIndentedString(screen)).append("\n");
    sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
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

