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
 * Details of a field that can be used in advanced searches.
 */
@ApiModel(description = "Details of a field that can be used in advanced searches.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:14.708+02:00[Europe/Prague]")
public class FieldReferenceData {
  /**
   * Whether the field provide auto-complete suggestions.
   */
  public enum AutoEnum {
    TRUE("true"),
    
    FALSE("false");

    private String value;

    AutoEnum(String value) {
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
    public static AutoEnum fromValue(String value) {
      for (AutoEnum b : AutoEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("auto")
  private AutoEnum auto;

  @JsonProperty("cfid")
  private String cfid;

  /**
   * Whether this field has been deprecated.
   */
  public enum DeprecatedEnum {
    TRUE("true"),
    
    FALSE("false");

    private String value;

    DeprecatedEnum(String value) {
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
    public static DeprecatedEnum fromValue(String value) {
      for (DeprecatedEnum b : DeprecatedEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("deprecated")
  private DeprecatedEnum deprecated;

  @JsonProperty("deprecatedSearcherKey")
  private String deprecatedSearcherKey;

  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("operators")
  private List<String> operators = new ArrayList<>();

  /**
   * Whether the field can be used in a query&#39;s &#x60;ORDER BY&#x60; clause.
   */
  public enum OrderableEnum {
    TRUE("true"),
    
    FALSE("false");

    private String value;

    OrderableEnum(String value) {
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
    public static OrderableEnum fromValue(String value) {
      for (OrderableEnum b : OrderableEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("orderable")
  private OrderableEnum orderable;

  /**
   * Whether the content of this field can be searched.
   */
  public enum SearchableEnum {
    TRUE("true"),
    
    FALSE("false");

    private String value;

    SearchableEnum(String value) {
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
    public static SearchableEnum fromValue(String value) {
      for (SearchableEnum b : SearchableEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("searchable")
  private SearchableEnum searchable;

  @JsonProperty("types")
  private List<String> types = new ArrayList<>();

  @JsonProperty("value")
  private String value;

  public FieldReferenceData auto(AutoEnum auto) {
    this.auto = auto;
    return this;
  }

   /**
   * Whether the field provide auto-complete suggestions.
   * @return auto
  **/
  @ApiModelProperty(value = "Whether the field provide auto-complete suggestions.")
  public AutoEnum getAuto() {
    return auto;
  }

  public void setAuto(AutoEnum auto) {
    this.auto = auto;
  }

  public FieldReferenceData cfid(String cfid) {
    this.cfid = cfid;
    return this;
  }

   /**
   * If the item is a custom field, the ID of the custom field.
   * @return cfid
  **/
  @ApiModelProperty(value = "If the item is a custom field, the ID of the custom field.")
  public String getCfid() {
    return cfid;
  }

  public void setCfid(String cfid) {
    this.cfid = cfid;
  }

  public FieldReferenceData deprecated(DeprecatedEnum deprecated) {
    this.deprecated = deprecated;
    return this;
  }

   /**
   * Whether this field has been deprecated.
   * @return deprecated
  **/
  @ApiModelProperty(value = "Whether this field has been deprecated.")
  public DeprecatedEnum getDeprecated() {
    return deprecated;
  }

  public void setDeprecated(DeprecatedEnum deprecated) {
    this.deprecated = deprecated;
  }

  public FieldReferenceData deprecatedSearcherKey(String deprecatedSearcherKey) {
    this.deprecatedSearcherKey = deprecatedSearcherKey;
    return this;
  }

   /**
   * The searcher key of the field, only passed when the field is deprecated.
   * @return deprecatedSearcherKey
  **/
  @ApiModelProperty(value = "The searcher key of the field, only passed when the field is deprecated.")
  public String getDeprecatedSearcherKey() {
    return deprecatedSearcherKey;
  }

  public void setDeprecatedSearcherKey(String deprecatedSearcherKey) {
    this.deprecatedSearcherKey = deprecatedSearcherKey;
  }

  public FieldReferenceData displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * The display name contains the following:   *  for system fields, the field name. For example, &#x60;Summary&#x60;.  *  for collapsed custom fields, the field name followed by a hyphen and then the field name and field type. For example, &#x60;Component - Component[Dropdown]&#x60;.  *  for other custom fields, the field name followed by a hyphen and then the custom field ID. For example, &#x60;Component - cf[10061]&#x60;.
   * @return displayName
  **/
  @ApiModelProperty(value = "The display name contains the following:   *  for system fields, the field name. For example, `Summary`.  *  for collapsed custom fields, the field name followed by a hyphen and then the field name and field type. For example, `Component - Component[Dropdown]`.  *  for other custom fields, the field name followed by a hyphen and then the custom field ID. For example, `Component - cf[10061]`.")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public FieldReferenceData operators(List<String> operators) {
    this.operators = operators;
    return this;
  }

  public FieldReferenceData addOperatorsItem(String operatorsItem) {
    if (this.operators == null) {
      this.operators = new ArrayList<>();
    }
    this.operators.add(operatorsItem);
    return this;
  }

   /**
   * The valid search operators for the field.
   * @return operators
  **/
  @ApiModelProperty(value = "The valid search operators for the field.")
  public List<String> getOperators() {
    return operators;
  }

  public void setOperators(List<String> operators) {
    this.operators = operators;
  }

  public FieldReferenceData orderable(OrderableEnum orderable) {
    this.orderable = orderable;
    return this;
  }

   /**
   * Whether the field can be used in a query&#39;s &#x60;ORDER BY&#x60; clause.
   * @return orderable
  **/
  @ApiModelProperty(value = "Whether the field can be used in a query's `ORDER BY` clause.")
  public OrderableEnum getOrderable() {
    return orderable;
  }

  public void setOrderable(OrderableEnum orderable) {
    this.orderable = orderable;
  }

  public FieldReferenceData searchable(SearchableEnum searchable) {
    this.searchable = searchable;
    return this;
  }

   /**
   * Whether the content of this field can be searched.
   * @return searchable
  **/
  @ApiModelProperty(value = "Whether the content of this field can be searched.")
  public SearchableEnum getSearchable() {
    return searchable;
  }

  public void setSearchable(SearchableEnum searchable) {
    this.searchable = searchable;
  }

  public FieldReferenceData types(List<String> types) {
    this.types = types;
    return this;
  }

  public FieldReferenceData addTypesItem(String typesItem) {
    if (this.types == null) {
      this.types = new ArrayList<>();
    }
    this.types.add(typesItem);
    return this;
  }

   /**
   * The data types of items in the field.
   * @return types
  **/
  @ApiModelProperty(value = "The data types of items in the field.")
  public List<String> getTypes() {
    return types;
  }

  public void setTypes(List<String> types) {
    this.types = types;
  }

  public FieldReferenceData value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The field identifier.
   * @return value
  **/
  @ApiModelProperty(value = "The field identifier.")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldReferenceData fieldReferenceData = (FieldReferenceData) o;
    return Objects.equals(this.auto, fieldReferenceData.auto) &&
        Objects.equals(this.cfid, fieldReferenceData.cfid) &&
        Objects.equals(this.deprecated, fieldReferenceData.deprecated) &&
        Objects.equals(this.deprecatedSearcherKey, fieldReferenceData.deprecatedSearcherKey) &&
        Objects.equals(this.displayName, fieldReferenceData.displayName) &&
        Objects.equals(this.operators, fieldReferenceData.operators) &&
        Objects.equals(this.orderable, fieldReferenceData.orderable) &&
        Objects.equals(this.searchable, fieldReferenceData.searchable) &&
        Objects.equals(this.types, fieldReferenceData.types) &&
        Objects.equals(this.value, fieldReferenceData.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(auto, cfid, deprecated, deprecatedSearcherKey, displayName, operators, orderable, searchable, types, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldReferenceData {\n");
    
    sb.append("    auto: ").append(toIndentedString(auto)).append("\n");
    sb.append("    cfid: ").append(toIndentedString(cfid)).append("\n");
    sb.append("    deprecated: ").append(toIndentedString(deprecated)).append("\n");
    sb.append("    deprecatedSearcherKey: ").append(toIndentedString(deprecatedSearcherKey)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    operators: ").append(toIndentedString(operators)).append("\n");
    sb.append("    orderable: ").append(toIndentedString(orderable)).append("\n");
    sb.append("    searchable: ").append(toIndentedString(searchable)).append("\n");
    sb.append("    types: ").append(toIndentedString(types)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

