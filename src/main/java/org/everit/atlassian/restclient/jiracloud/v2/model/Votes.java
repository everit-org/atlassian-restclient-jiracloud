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
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.User;

/**
 * The details of votes on an issue.
 */
@ApiModel(description = "The details of votes on an issue.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:30.184+02:00[Europe/Prague]")
public class Votes {
  @JsonProperty("self")
  private URI self;

  @JsonProperty("votes")
  private Long votes;

  @JsonProperty("hasVoted")
  private Boolean hasVoted;

  @JsonProperty("voters")
  private List<User> voters = new ArrayList<>();

   /**
   * The URL of these issue vote details.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of these issue vote details.")
  public URI getSelf() {
    return self;
  }

   /**
   * The number of votes on the issue.
   * @return votes
  **/
  @ApiModelProperty(value = "The number of votes on the issue.")
  public Long getVotes() {
    return votes;
  }

   /**
   * Indicates whether the user making this request has voted on the issue.
   * @return hasVoted
  **/
  @ApiModelProperty(value = "Indicates whether the user making this request has voted on the issue.")
  public Boolean getHasVoted() {
    return hasVoted;
  }

   /**
   * List of the users who have voted on this issue. An empty list is returned when the calling user doesn&#39;t have the *View voters and watchers* project permission.
   * @return voters
  **/
  @ApiModelProperty(value = "List of the users who have voted on this issue. An empty list is returned when the calling user doesn't have the *View voters and watchers* project permission.")
  public List<User> getVoters() {
    return voters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Votes votes = (Votes) o;
    return Objects.equals(this.self, votes.self) &&
        Objects.equals(this.votes, votes.votes) &&
        Objects.equals(this.hasVoted, votes.hasVoted) &&
        Objects.equals(this.voters, votes.voters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, votes, hasVoted, voters);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Votes {\n");
    
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    votes: ").append(toIndentedString(votes)).append("\n");
    sb.append("    hasVoted: ").append(toIndentedString(hasVoted)).append("\n");
    sb.append("    voters: ").append(toIndentedString(voters)).append("\n");
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

