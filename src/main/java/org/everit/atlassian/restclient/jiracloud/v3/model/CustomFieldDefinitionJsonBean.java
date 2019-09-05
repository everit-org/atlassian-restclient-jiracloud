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


package org.everit.atlassian.restclient.jiracloud.v3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CustomFieldDefinitionJsonBean
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-05T12:17:37.034+02:00[Europe/Prague]")
public class CustomFieldDefinitionJsonBean {
  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  /**
   * The type of the custom field. For example, *com.atlassian.jira.plugin.system.customfieldtypes:grouppicker*.   *  &#x60;cascadingselect&#x60;: Allows multiple values to be selected using two select lists  *  &#x60;datepicker&#x60;: Stores a date using a picker control  *  &#x60;datetime&#x60;: Stores a date with a time component  *  &#x60;float&#x60;: Stores and validates a numeric (floating point) input  *  &#x60;grouppicker&#x60;: Stores a user group using a picker control  *  &#x60;importid&#x60;: A read-only field that stores the previous ID of the issue from the system that it was imported from  *  &#x60;labels&#x60;: Stores labels  *  &#x60;multicheckboxes&#x60;: Stores multiple values using checkboxes  *  &#x60;multigrouppicker&#x60;: Stores multiple user groups using a picker control  *  &#x60;multiselect&#x60;: Stores multiple values using a select list  *  &#x60;multiuserpicker&#x60;: Stores multiple users using a picker control  *  &#x60;multiversion&#x60;: Stores multiple versions from the versions available in a project using a picker control  *  &#x60;project&#x60;: Stores a project from a list of projects that the user is permitted to view  *  &#x60;radiobuttons&#x60;: Stores a value using radio buttons  *  &#x60;readonlyfield&#x60;: Stores a read-only text value, which can only be populated via the API  *  &#x60;select&#x60;: Stores a value from a configurable list of options  *  &#x60;textarea&#x60;: Stores a long text string using a multiline text area  *  &#x60;textfield&#x60;: Stores a text string using a single-line text box  *  &#x60;url&#x60;: Stores a URL  *  &#x60;userpicker&#x60;: Stores a user using a picker control  *  &#x60;version&#x60;: Stores a version using a picker control
   */
  public enum TypeEnum {
    CASCADINGSELECT("com.atlassian.jira.plugin.system.customfieldtypes:cascadingselect"),
    
    DATEPICKER("com.atlassian.jira.plugin.system.customfieldtypes:datepicker"),
    
    DATETIME("com.atlassian.jira.plugin.system.customfieldtypes:datetime"),
    
    FLOAT("com.atlassian.jira.plugin.system.customfieldtypes:float"),
    
    GROUPPICKER("com.atlassian.jira.plugin.system.customfieldtypes:grouppicker"),
    
    IMPORTID("com.atlassian.jira.plugin.system.customfieldtypes:importid"),
    
    LABELS("com.atlassian.jira.plugin.system.customfieldtypes:labels"),
    
    MULTICHECKBOXES("com.atlassian.jira.plugin.system.customfieldtypes:multicheckboxes"),
    
    MULTIGROUPPICKER("com.atlassian.jira.plugin.system.customfieldtypes:multigrouppicker"),
    
    MULTISELECT("com.atlassian.jira.plugin.system.customfieldtypes:multiselect"),
    
    MULTIUSERPICKER("com.atlassian.jira.plugin.system.customfieldtypes:multiuserpicker"),
    
    MULTIVERSION("com.atlassian.jira.plugin.system.customfieldtypes:multiversion"),
    
    PROJECT("com.atlassian.jira.plugin.system.customfieldtypes:project"),
    
    RADIOBUTTONS("com.atlassian.jira.plugin.system.customfieldtypes:radiobuttons"),
    
    READONLYFIELD("com.atlassian.jira.plugin.system.customfieldtypes:readonlyfield"),
    
    SELECT("com.atlassian.jira.plugin.system.customfieldtypes:select"),
    
    TEXTAREA("com.atlassian.jira.plugin.system.customfieldtypes:textarea"),
    
    TEXTFIELD("com.atlassian.jira.plugin.system.customfieldtypes:textfield"),
    
    URL("com.atlassian.jira.plugin.system.customfieldtypes:url"),
    
    USERPICKER("com.atlassian.jira.plugin.system.customfieldtypes:userpicker"),
    
    VERSION("com.atlassian.jira.plugin.system.customfieldtypes:version");

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

  /**
   * The searcher defines the way the field is searched in Jira. For example, *com.atlassian.jira.plugin.system.customfieldtypes:grouppickersearcher*.   The search UI (basic search and JQL search) will display different operations and values for the field, based on the field searcher. You must specify a searcher that is valid for the field type, as listed below (abbreviated values shown):   *  &#x60;cascadingselect&#x60;: &#x60;cascadingselectsearcher&#x60;  *  &#x60;datepicker&#x60;: &#x60;daterange&#x60;  *  &#x60;datetime&#x60;: &#x60;datetimerange&#x60;  *  &#x60;float&#x60;: &#x60;exactnumber&#x60; or &#x60;numberrange&#x60;  *  &#x60;grouppicker&#x60;: &#x60;grouppickersearcher&#x60;  *  &#x60;importid&#x60;: &#x60;exactnumber&#x60; or &#x60;numberrange&#x60;  *  &#x60;labels&#x60;: &#x60;labelsearcher&#x60;  *  &#x60;multicheckboxes&#x60;: &#x60;multiselectsearcher&#x60;  *  &#x60;multigrouppicker&#x60;: &#x60;multiselectsearcher&#x60;  *  &#x60;multiselect&#x60;: &#x60;multiselectsearcher&#x60;  *  &#x60;multiuserpicker&#x60;: &#x60;userpickergroupsearcher&#x60;  *  &#x60;multiversion&#x60;: &#x60;versionsearcher&#x60;  *  &#x60;project&#x60;: &#x60;projectsearcher&#x60;  *  &#x60;radiobuttons&#x60;: &#x60;multiselectsearcher&#x60;  *  &#x60;readonlyfield&#x60;: &#x60;textsearcher&#x60;  *  &#x60;select&#x60;: &#x60;multiselectsearcher&#x60;  *  &#x60;textarea&#x60;: &#x60;textsearcher&#x60;  *  &#x60;textfield&#x60;: &#x60;textsearcher&#x60;  *  &#x60;url&#x60;: &#x60;exacttextsearcher&#x60;  *  &#x60;userpicker&#x60;: &#x60;userpickergroupsearcher&#x60;  *  &#x60;version&#x60;: &#x60;versionsearcher&#x60;
   */
  public enum SearcherKeyEnum {
    CASCADINGSELECTSEARCHER("com.atlassian.jira.plugin.system.customfieldtypes:cascadingselectsearcher"),
    
    DATERANGE("com.atlassian.jira.plugin.system.customfieldtypes:daterange"),
    
    DATETIMERANGE("com.atlassian.jira.plugin.system.customfieldtypes:datetimerange"),
    
    EXACTNUMBER("com.atlassian.jira.plugin.system.customfieldtypes:exactnumber"),
    
    EXACTTEXTSEARCHER("com.atlassian.jira.plugin.system.customfieldtypes:exacttextsearcher"),
    
    GROUPPICKERSEARCHER("com.atlassian.jira.plugin.system.customfieldtypes:grouppickersearcher"),
    
    LABELSEARCHER("com.atlassian.jira.plugin.system.customfieldtypes:labelsearcher"),
    
    MULTISELECTSEARCHER("com.atlassian.jira.plugin.system.customfieldtypes:multiselectsearcher"),
    
    NUMBERRANGE("com.atlassian.jira.plugin.system.customfieldtypes:numberrange"),
    
    PROJECTSEARCHER("com.atlassian.jira.plugin.system.customfieldtypes:projectsearcher"),
    
    TEXTSEARCHER("com.atlassian.jira.plugin.system.customfieldtypes:textsearcher"),
    
    USERPICKERGROUPSEARCHER("com.atlassian.jira.plugin.system.customfieldtypes:userpickergroupsearcher"),
    
    VERSIONSEARCHER("com.atlassian.jira.plugin.system.customfieldtypes:versionsearcher");

    private String value;

    SearcherKeyEnum(String value) {
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
    public static SearcherKeyEnum fromValue(String value) {
      for (SearcherKeyEnum b : SearcherKeyEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("searcherKey")
  private SearcherKeyEnum searcherKey;

  public CustomFieldDefinitionJsonBean name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the custom field, which is displayed in Jira. This is not the unique identifier.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the custom field, which is displayed in Jira. This is not the unique identifier.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomFieldDefinitionJsonBean description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the custom field, which is displayed in Jira.
   * @return description
  **/
  @ApiModelProperty(value = "The description of the custom field, which is displayed in Jira.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CustomFieldDefinitionJsonBean type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The type of the custom field. For example, *com.atlassian.jira.plugin.system.customfieldtypes:grouppicker*.   *  &#x60;cascadingselect&#x60;: Allows multiple values to be selected using two select lists  *  &#x60;datepicker&#x60;: Stores a date using a picker control  *  &#x60;datetime&#x60;: Stores a date with a time component  *  &#x60;float&#x60;: Stores and validates a numeric (floating point) input  *  &#x60;grouppicker&#x60;: Stores a user group using a picker control  *  &#x60;importid&#x60;: A read-only field that stores the previous ID of the issue from the system that it was imported from  *  &#x60;labels&#x60;: Stores labels  *  &#x60;multicheckboxes&#x60;: Stores multiple values using checkboxes  *  &#x60;multigrouppicker&#x60;: Stores multiple user groups using a picker control  *  &#x60;multiselect&#x60;: Stores multiple values using a select list  *  &#x60;multiuserpicker&#x60;: Stores multiple users using a picker control  *  &#x60;multiversion&#x60;: Stores multiple versions from the versions available in a project using a picker control  *  &#x60;project&#x60;: Stores a project from a list of projects that the user is permitted to view  *  &#x60;radiobuttons&#x60;: Stores a value using radio buttons  *  &#x60;readonlyfield&#x60;: Stores a read-only text value, which can only be populated via the API  *  &#x60;select&#x60;: Stores a value from a configurable list of options  *  &#x60;textarea&#x60;: Stores a long text string using a multiline text area  *  &#x60;textfield&#x60;: Stores a text string using a single-line text box  *  &#x60;url&#x60;: Stores a URL  *  &#x60;userpicker&#x60;: Stores a user using a picker control  *  &#x60;version&#x60;: Stores a version using a picker control
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The type of the custom field. For example, *com.atlassian.jira.plugin.system.customfieldtypes:grouppicker*.   *  `cascadingselect`: Allows multiple values to be selected using two select lists  *  `datepicker`: Stores a date using a picker control  *  `datetime`: Stores a date with a time component  *  `float`: Stores and validates a numeric (floating point) input  *  `grouppicker`: Stores a user group using a picker control  *  `importid`: A read-only field that stores the previous ID of the issue from the system that it was imported from  *  `labels`: Stores labels  *  `multicheckboxes`: Stores multiple values using checkboxes  *  `multigrouppicker`: Stores multiple user groups using a picker control  *  `multiselect`: Stores multiple values using a select list  *  `multiuserpicker`: Stores multiple users using a picker control  *  `multiversion`: Stores multiple versions from the versions available in a project using a picker control  *  `project`: Stores a project from a list of projects that the user is permitted to view  *  `radiobuttons`: Stores a value using radio buttons  *  `readonlyfield`: Stores a read-only text value, which can only be populated via the API  *  `select`: Stores a value from a configurable list of options  *  `textarea`: Stores a long text string using a multiline text area  *  `textfield`: Stores a text string using a single-line text box  *  `url`: Stores a URL  *  `userpicker`: Stores a user using a picker control  *  `version`: Stores a version using a picker control")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public CustomFieldDefinitionJsonBean searcherKey(SearcherKeyEnum searcherKey) {
    this.searcherKey = searcherKey;
    return this;
  }

   /**
   * The searcher defines the way the field is searched in Jira. For example, *com.atlassian.jira.plugin.system.customfieldtypes:grouppickersearcher*.   The search UI (basic search and JQL search) will display different operations and values for the field, based on the field searcher. You must specify a searcher that is valid for the field type, as listed below (abbreviated values shown):   *  &#x60;cascadingselect&#x60;: &#x60;cascadingselectsearcher&#x60;  *  &#x60;datepicker&#x60;: &#x60;daterange&#x60;  *  &#x60;datetime&#x60;: &#x60;datetimerange&#x60;  *  &#x60;float&#x60;: &#x60;exactnumber&#x60; or &#x60;numberrange&#x60;  *  &#x60;grouppicker&#x60;: &#x60;grouppickersearcher&#x60;  *  &#x60;importid&#x60;: &#x60;exactnumber&#x60; or &#x60;numberrange&#x60;  *  &#x60;labels&#x60;: &#x60;labelsearcher&#x60;  *  &#x60;multicheckboxes&#x60;: &#x60;multiselectsearcher&#x60;  *  &#x60;multigrouppicker&#x60;: &#x60;multiselectsearcher&#x60;  *  &#x60;multiselect&#x60;: &#x60;multiselectsearcher&#x60;  *  &#x60;multiuserpicker&#x60;: &#x60;userpickergroupsearcher&#x60;  *  &#x60;multiversion&#x60;: &#x60;versionsearcher&#x60;  *  &#x60;project&#x60;: &#x60;projectsearcher&#x60;  *  &#x60;radiobuttons&#x60;: &#x60;multiselectsearcher&#x60;  *  &#x60;readonlyfield&#x60;: &#x60;textsearcher&#x60;  *  &#x60;select&#x60;: &#x60;multiselectsearcher&#x60;  *  &#x60;textarea&#x60;: &#x60;textsearcher&#x60;  *  &#x60;textfield&#x60;: &#x60;textsearcher&#x60;  *  &#x60;url&#x60;: &#x60;exacttextsearcher&#x60;  *  &#x60;userpicker&#x60;: &#x60;userpickergroupsearcher&#x60;  *  &#x60;version&#x60;: &#x60;versionsearcher&#x60;
   * @return searcherKey
  **/
  @ApiModelProperty(required = true, value = "The searcher defines the way the field is searched in Jira. For example, *com.atlassian.jira.plugin.system.customfieldtypes:grouppickersearcher*.   The search UI (basic search and JQL search) will display different operations and values for the field, based on the field searcher. You must specify a searcher that is valid for the field type, as listed below (abbreviated values shown):   *  `cascadingselect`: `cascadingselectsearcher`  *  `datepicker`: `daterange`  *  `datetime`: `datetimerange`  *  `float`: `exactnumber` or `numberrange`  *  `grouppicker`: `grouppickersearcher`  *  `importid`: `exactnumber` or `numberrange`  *  `labels`: `labelsearcher`  *  `multicheckboxes`: `multiselectsearcher`  *  `multigrouppicker`: `multiselectsearcher`  *  `multiselect`: `multiselectsearcher`  *  `multiuserpicker`: `userpickergroupsearcher`  *  `multiversion`: `versionsearcher`  *  `project`: `projectsearcher`  *  `radiobuttons`: `multiselectsearcher`  *  `readonlyfield`: `textsearcher`  *  `select`: `multiselectsearcher`  *  `textarea`: `textsearcher`  *  `textfield`: `textsearcher`  *  `url`: `exacttextsearcher`  *  `userpicker`: `userpickergroupsearcher`  *  `version`: `versionsearcher`")
  public SearcherKeyEnum getSearcherKey() {
    return searcherKey;
  }

  public void setSearcherKey(SearcherKeyEnum searcherKey) {
    this.searcherKey = searcherKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomFieldDefinitionJsonBean customFieldDefinitionJsonBean = (CustomFieldDefinitionJsonBean) o;
    return Objects.equals(this.name, customFieldDefinitionJsonBean.name) &&
        Objects.equals(this.description, customFieldDefinitionJsonBean.description) &&
        Objects.equals(this.type, customFieldDefinitionJsonBean.type) &&
        Objects.equals(this.searcherKey, customFieldDefinitionJsonBean.searcherKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, type, searcherKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldDefinitionJsonBean {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    searcherKey: ").append(toIndentedString(searcherKey)).append("\n");
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

