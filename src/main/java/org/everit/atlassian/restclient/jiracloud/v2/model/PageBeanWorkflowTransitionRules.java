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
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowTransitionRules;

/**
 * A page of items.
 */
@ApiModel(description = "A page of items.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-01T13:56:58.037+02:00[Europe/Prague]")
public class PageBeanWorkflowTransitionRules {
  @JsonProperty("self")
  private URI self;

  @JsonProperty("nextPage")
  private URI nextPage;

  @JsonProperty("maxResults")
  private Integer maxResults;

  @JsonProperty("startAt")
  private Long startAt;

  @JsonProperty("total")
  private Long total;

  @JsonProperty("isLast")
  private Boolean isLast;

  @JsonProperty("values")
  private List<WorkflowTransitionRules> values = new ArrayList<>();

   /**
   * The URL of the page.
   * @return self
  **/
  @ApiModelProperty(value = "The URL of the page.")
  public URI getSelf() {
    return self;
  }

   /**
   * If there is another page of results, the URL of the next page.
   * @return nextPage
  **/
  @ApiModelProperty(value = "If there is another page of results, the URL of the next page.")
  public URI getNextPage() {
    return nextPage;
  }

   /**
   * The maximum number of items that could be returned.
   * @return maxResults
  **/
  @ApiModelProperty(value = "The maximum number of items that could be returned.")
  public Integer getMaxResults() {
    return maxResults;
  }

   /**
   * The index of the first item returned.
   * @return startAt
  **/
  @ApiModelProperty(value = "The index of the first item returned.")
  public Long getStartAt() {
    return startAt;
  }

   /**
   * The number of items returned.
   * @return total
  **/
  @ApiModelProperty(value = "The number of items returned.")
  public Long getTotal() {
    return total;
  }

   /**
   * Indicates whether this is the last page.
   * @return isLast
  **/
  @ApiModelProperty(value = "Indicates whether this is the last page.")
  public Boolean getIsLast() {
    return isLast;
  }

   /**
   * The list of items.
   * @return values
  **/
  @ApiModelProperty(value = "The list of items.")
  public List<WorkflowTransitionRules> getValues() {
    return values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageBeanWorkflowTransitionRules pageBeanWorkflowTransitionRules = (PageBeanWorkflowTransitionRules) o;
    return Objects.equals(this.self, pageBeanWorkflowTransitionRules.self) &&
        Objects.equals(this.nextPage, pageBeanWorkflowTransitionRules.nextPage) &&
        Objects.equals(this.maxResults, pageBeanWorkflowTransitionRules.maxResults) &&
        Objects.equals(this.startAt, pageBeanWorkflowTransitionRules.startAt) &&
        Objects.equals(this.total, pageBeanWorkflowTransitionRules.total) &&
        Objects.equals(this.isLast, pageBeanWorkflowTransitionRules.isLast) &&
        Objects.equals(this.values, pageBeanWorkflowTransitionRules.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, nextPage, maxResults, startAt, total, isLast, values);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageBeanWorkflowTransitionRules {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    nextPage: ").append(toIndentedString(nextPage)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    isLast: ").append(toIndentedString(isLast)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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

