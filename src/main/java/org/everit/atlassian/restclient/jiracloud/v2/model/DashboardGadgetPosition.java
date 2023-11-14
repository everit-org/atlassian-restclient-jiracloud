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

/**
 * Details of a gadget position.
 */
@ApiModel(description = "Details of a gadget position.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-13T15:26:36.903+01:00[Europe/Prague]")
public class DashboardGadgetPosition {
  @JsonProperty("The column position of the gadget.")
  private Integer theColumnPositionOfTheGadget;

  @JsonProperty("The row position of the gadget.")
  private Integer theRowPositionOfTheGadget;

  public DashboardGadgetPosition theColumnPositionOfTheGadget(Integer theColumnPositionOfTheGadget) {
    this.theColumnPositionOfTheGadget = theColumnPositionOfTheGadget;
    return this;
  }

   /**
   * Get theColumnPositionOfTheGadget
   * @return theColumnPositionOfTheGadget
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getTheColumnPositionOfTheGadget() {
    return theColumnPositionOfTheGadget;
  }

  public void setTheColumnPositionOfTheGadget(Integer theColumnPositionOfTheGadget) {
    this.theColumnPositionOfTheGadget = theColumnPositionOfTheGadget;
  }

  public DashboardGadgetPosition theRowPositionOfTheGadget(Integer theRowPositionOfTheGadget) {
    this.theRowPositionOfTheGadget = theRowPositionOfTheGadget;
    return this;
  }

   /**
   * Get theRowPositionOfTheGadget
   * @return theRowPositionOfTheGadget
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getTheRowPositionOfTheGadget() {
    return theRowPositionOfTheGadget;
  }

  public void setTheRowPositionOfTheGadget(Integer theRowPositionOfTheGadget) {
    this.theRowPositionOfTheGadget = theRowPositionOfTheGadget;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardGadgetPosition dashboardGadgetPosition = (DashboardGadgetPosition) o;
    return Objects.equals(this.theColumnPositionOfTheGadget, dashboardGadgetPosition.theColumnPositionOfTheGadget) &&
        Objects.equals(this.theRowPositionOfTheGadget, dashboardGadgetPosition.theRowPositionOfTheGadget);
  }

  @Override
  public int hashCode() {
    return Objects.hash(theColumnPositionOfTheGadget, theRowPositionOfTheGadget);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardGadgetPosition {\n");
    
    sb.append("    theColumnPositionOfTheGadget: ").append(toIndentedString(theColumnPositionOfTheGadget)).append("\n");
    sb.append("    theRowPositionOfTheGadget: ").append(toIndentedString(theRowPositionOfTheGadget)).append("\n");
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

