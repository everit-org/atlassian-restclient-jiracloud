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
 * CreatePlanOnlyTeamRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class CreatePlanOnlyTeamRequest {
  @JsonProperty("capacity")
  private Double capacity;

  @JsonProperty("issueSourceId")
  private Long issueSourceId;

  @JsonProperty("memberAccountIds")
  private List<String> memberAccountIds = new ArrayList<>();

  @JsonProperty("name")
  private String name;

  /**
   * The planning style for the plan-only team. This must be \&quot;Scrum\&quot; or \&quot;Kanban\&quot;.
   */
  public enum PlanningStyleEnum {
    SCRUM("Scrum"),
    
    KANBAN("Kanban");

    private String value;

    PlanningStyleEnum(String value) {
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
    public static PlanningStyleEnum fromValue(String value) {
      for (PlanningStyleEnum b : PlanningStyleEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("planningStyle")
  private PlanningStyleEnum planningStyle;

  @JsonProperty("sprintLength")
  private Long sprintLength;

  public CreatePlanOnlyTeamRequest capacity(Double capacity) {
    this.capacity = capacity;
    return this;
  }

   /**
   * The capacity for the plan-only team.
   * @return capacity
  **/
  @ApiModelProperty(value = "The capacity for the plan-only team.")
  public Double getCapacity() {
    return capacity;
  }

  public void setCapacity(Double capacity) {
    this.capacity = capacity;
  }

  public CreatePlanOnlyTeamRequest issueSourceId(Long issueSourceId) {
    this.issueSourceId = issueSourceId;
    return this;
  }

   /**
   * The ID of the issue source for the plan-only team.
   * @return issueSourceId
  **/
  @ApiModelProperty(value = "The ID of the issue source for the plan-only team.")
  public Long getIssueSourceId() {
    return issueSourceId;
  }

  public void setIssueSourceId(Long issueSourceId) {
    this.issueSourceId = issueSourceId;
  }

  public CreatePlanOnlyTeamRequest memberAccountIds(List<String> memberAccountIds) {
    this.memberAccountIds = memberAccountIds;
    return this;
  }

  public CreatePlanOnlyTeamRequest addMemberAccountIdsItem(String memberAccountIdsItem) {
    if (this.memberAccountIds == null) {
      this.memberAccountIds = new ArrayList<>();
    }
    this.memberAccountIds.add(memberAccountIdsItem);
    return this;
  }

   /**
   * The account IDs of the plan-only team members.
   * @return memberAccountIds
  **/
  @ApiModelProperty(value = "The account IDs of the plan-only team members.")
  public List<String> getMemberAccountIds() {
    return memberAccountIds;
  }

  public void setMemberAccountIds(List<String> memberAccountIds) {
    this.memberAccountIds = memberAccountIds;
  }

  public CreatePlanOnlyTeamRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The plan-only team name.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The plan-only team name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreatePlanOnlyTeamRequest planningStyle(PlanningStyleEnum planningStyle) {
    this.planningStyle = planningStyle;
    return this;
  }

   /**
   * The planning style for the plan-only team. This must be \&quot;Scrum\&quot; or \&quot;Kanban\&quot;.
   * @return planningStyle
  **/
  @ApiModelProperty(required = true, value = "The planning style for the plan-only team. This must be \"Scrum\" or \"Kanban\".")
  public PlanningStyleEnum getPlanningStyle() {
    return planningStyle;
  }

  public void setPlanningStyle(PlanningStyleEnum planningStyle) {
    this.planningStyle = planningStyle;
  }

  public CreatePlanOnlyTeamRequest sprintLength(Long sprintLength) {
    this.sprintLength = sprintLength;
    return this;
  }

   /**
   * The sprint length for the plan-only team.
   * @return sprintLength
  **/
  @ApiModelProperty(value = "The sprint length for the plan-only team.")
  public Long getSprintLength() {
    return sprintLength;
  }

  public void setSprintLength(Long sprintLength) {
    this.sprintLength = sprintLength;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatePlanOnlyTeamRequest createPlanOnlyTeamRequest = (CreatePlanOnlyTeamRequest) o;
    return Objects.equals(this.capacity, createPlanOnlyTeamRequest.capacity) &&
        Objects.equals(this.issueSourceId, createPlanOnlyTeamRequest.issueSourceId) &&
        Objects.equals(this.memberAccountIds, createPlanOnlyTeamRequest.memberAccountIds) &&
        Objects.equals(this.name, createPlanOnlyTeamRequest.name) &&
        Objects.equals(this.planningStyle, createPlanOnlyTeamRequest.planningStyle) &&
        Objects.equals(this.sprintLength, createPlanOnlyTeamRequest.sprintLength);
  }

  @Override
  public int hashCode() {
    return Objects.hash(capacity, issueSourceId, memberAccountIds, name, planningStyle, sprintLength);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePlanOnlyTeamRequest {\n");
    
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    issueSourceId: ").append(toIndentedString(issueSourceId)).append("\n");
    sb.append("    memberAccountIds: ").append(toIndentedString(memberAccountIds)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    planningStyle: ").append(toIndentedString(planningStyle)).append("\n");
    sb.append("    sprintLength: ").append(toIndentedString(sprintLength)).append("\n");
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

