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
import java.util.ArrayList;
import java.util.List;
import org.everit.atlassian.restclient.jiracloud.v2.model.AuditRecordBean;

/**
 * Container for a list of audit records.
 */
@ApiModel(description = "Container for a list of audit records.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-28T14:12:34.799+01:00[Europe/Prague]")
public class AuditRecords {
  @JsonProperty("offset")
  private Integer offset;

  @JsonProperty("limit")
  private Integer limit;

  @JsonProperty("total")
  private Long total;

  @JsonProperty("records")
  private List<AuditRecordBean> records = new ArrayList<>();

   /**
   * The number of audit items skipped before the first item in this list.
   * @return offset
  **/
  @ApiModelProperty(value = "The number of audit items skipped before the first item in this list.")
  public Integer getOffset() {
    return offset;
  }

   /**
   * The requested or default limit on the number of audit items to be returned.
   * @return limit
  **/
  @ApiModelProperty(value = "The requested or default limit on the number of audit items to be returned.")
  public Integer getLimit() {
    return limit;
  }

   /**
   * The total number of audit items returned.
   * @return total
  **/
  @ApiModelProperty(value = "The total number of audit items returned.")
  public Long getTotal() {
    return total;
  }

   /**
   * The list of audit items.
   * @return records
  **/
  @ApiModelProperty(value = "The list of audit items.")
  public List<AuditRecordBean> getRecords() {
    return records;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditRecords auditRecords = (AuditRecords) o;
    return Objects.equals(this.offset, auditRecords.offset) &&
        Objects.equals(this.limit, auditRecords.limit) &&
        Objects.equals(this.total, auditRecords.total) &&
        Objects.equals(this.records, auditRecords.records);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset, limit, total, records);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditRecords {\n");
    
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    records: ").append(toIndentedString(records)).append("\n");
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

