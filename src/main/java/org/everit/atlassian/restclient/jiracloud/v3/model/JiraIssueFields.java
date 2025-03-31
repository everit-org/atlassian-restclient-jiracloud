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
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraCascadingSelectField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraColorField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraDateField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraDateTimeField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraDurationField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraIssueTypeField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraLabelsField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraMultiSelectComponentField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraMultipleGroupPickerField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraMultipleSelectField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraMultipleSelectUserPickerField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraMultipleVersionPickerField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraNumberField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraPriorityField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraRichTextField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraSingleGroupPickerField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraSingleLineTextField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraSingleSelectField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraSingleSelectUserPickerField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraSingleVersionPickerField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraTimeTrackingField;
import org.everit.atlassian.restclient.jiracloud.v3.model.JiraUrlField;

/**
 * JiraIssueFields
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-31T17:15:41.549+02:00[Europe/Prague]")
public class JiraIssueFields {
  @JsonProperty("cascadingSelectFields")
  private List<JiraCascadingSelectField> cascadingSelectFields = new ArrayList<>();

  @JsonProperty("clearableNumberFields")
  private List<JiraNumberField> clearableNumberFields = new ArrayList<>();

  @JsonProperty("colorFields")
  private List<JiraColorField> colorFields = new ArrayList<>();

  @JsonProperty("datePickerFields")
  private List<JiraDateField> datePickerFields = new ArrayList<>();

  @JsonProperty("dateTimePickerFields")
  private List<JiraDateTimeField> dateTimePickerFields = new ArrayList<>();

  @JsonProperty("issueType")
  private JiraIssueTypeField issueType;

  @JsonProperty("labelsFields")
  private List<JiraLabelsField> labelsFields = new ArrayList<>();

  @JsonProperty("multipleGroupPickerFields")
  private List<JiraMultipleGroupPickerField> multipleGroupPickerFields = new ArrayList<>();

  @JsonProperty("multipleSelectClearableUserPickerFields")
  private List<JiraMultipleSelectUserPickerField> multipleSelectClearableUserPickerFields = new ArrayList<>();

  @JsonProperty("multipleSelectFields")
  private List<JiraMultipleSelectField> multipleSelectFields = new ArrayList<>();

  @JsonProperty("multipleVersionPickerFields")
  private List<JiraMultipleVersionPickerField> multipleVersionPickerFields = new ArrayList<>();

  @JsonProperty("multiselectComponents")
  private JiraMultiSelectComponentField multiselectComponents;

  @JsonProperty("originalEstimateField")
  private JiraDurationField originalEstimateField;

  @JsonProperty("priority")
  private JiraPriorityField priority;

  @JsonProperty("richTextFields")
  private List<JiraRichTextField> richTextFields = new ArrayList<>();

  @JsonProperty("singleGroupPickerFields")
  private List<JiraSingleGroupPickerField> singleGroupPickerFields = new ArrayList<>();

  @JsonProperty("singleLineTextFields")
  private List<JiraSingleLineTextField> singleLineTextFields = new ArrayList<>();

  @JsonProperty("singleSelectClearableUserPickerFields")
  private List<JiraSingleSelectUserPickerField> singleSelectClearableUserPickerFields = new ArrayList<>();

  @JsonProperty("singleSelectFields")
  private List<JiraSingleSelectField> singleSelectFields = new ArrayList<>();

  @JsonProperty("singleVersionPickerFields")
  private List<JiraSingleVersionPickerField> singleVersionPickerFields = new ArrayList<>();

  @JsonProperty("timeTrackingField")
  private JiraTimeTrackingField timeTrackingField;

  @JsonProperty("urlFields")
  private List<JiraUrlField> urlFields = new ArrayList<>();

  public JiraIssueFields cascadingSelectFields(List<JiraCascadingSelectField> cascadingSelectFields) {
    this.cascadingSelectFields = cascadingSelectFields;
    return this;
  }

  public JiraIssueFields addCascadingSelectFieldsItem(JiraCascadingSelectField cascadingSelectFieldsItem) {
    if (this.cascadingSelectFields == null) {
      this.cascadingSelectFields = new ArrayList<>();
    }
    this.cascadingSelectFields.add(cascadingSelectFieldsItem);
    return this;
  }

   /**
   * Add or clear a cascading select field:   *  To add, specify &#x60;optionId&#x60; for both parent and child.  *  To clear the child, set its &#x60;optionId&#x60; to null.  *  To clear both, set the parent&#39;s &#x60;optionId&#x60; to null.
   * @return cascadingSelectFields
  **/
  @ApiModelProperty(value = "Add or clear a cascading select field:   *  To add, specify `optionId` for both parent and child.  *  To clear the child, set its `optionId` to null.  *  To clear both, set the parent's `optionId` to null.")
  public List<JiraCascadingSelectField> getCascadingSelectFields() {
    return cascadingSelectFields;
  }

  public void setCascadingSelectFields(List<JiraCascadingSelectField> cascadingSelectFields) {
    this.cascadingSelectFields = cascadingSelectFields;
  }

  public JiraIssueFields clearableNumberFields(List<JiraNumberField> clearableNumberFields) {
    this.clearableNumberFields = clearableNumberFields;
    return this;
  }

  public JiraIssueFields addClearableNumberFieldsItem(JiraNumberField clearableNumberFieldsItem) {
    if (this.clearableNumberFields == null) {
      this.clearableNumberFields = new ArrayList<>();
    }
    this.clearableNumberFields.add(clearableNumberFieldsItem);
    return this;
  }

   /**
   * Add or clear a number field:   *  To add, specify a numeric &#x60;value&#x60;.  *  To clear, set &#x60;value&#x60; to &#x60;null&#x60;.
   * @return clearableNumberFields
  **/
  @ApiModelProperty(value = "Add or clear a number field:   *  To add, specify a numeric `value`.  *  To clear, set `value` to `null`.")
  public List<JiraNumberField> getClearableNumberFields() {
    return clearableNumberFields;
  }

  public void setClearableNumberFields(List<JiraNumberField> clearableNumberFields) {
    this.clearableNumberFields = clearableNumberFields;
  }

  public JiraIssueFields colorFields(List<JiraColorField> colorFields) {
    this.colorFields = colorFields;
    return this;
  }

  public JiraIssueFields addColorFieldsItem(JiraColorField colorFieldsItem) {
    if (this.colorFields == null) {
      this.colorFields = new ArrayList<>();
    }
    this.colorFields.add(colorFieldsItem);
    return this;
  }

   /**
   * Add or clear a color field:   *  To add, specify the color &#x60;name&#x60;. Available colors are: &#x60;purple&#x60;, &#x60;blue&#x60;, &#x60;green&#x60;, &#x60;teal&#x60;, &#x60;yellow&#x60;, &#x60;orange&#x60;, &#x60;grey&#x60;, &#x60;dark purple&#x60;, &#x60;dark blue&#x60;, &#x60;dark green&#x60;, &#x60;dark teal&#x60;, &#x60;dark yellow&#x60;, &#x60;dark orange&#x60;, &#x60;dark grey&#x60;.  *  To clear, set the color &#x60;name&#x60; to an empty string.
   * @return colorFields
  **/
  @ApiModelProperty(value = "Add or clear a color field:   *  To add, specify the color `name`. Available colors are: `purple`, `blue`, `green`, `teal`, `yellow`, `orange`, `grey`, `dark purple`, `dark blue`, `dark green`, `dark teal`, `dark yellow`, `dark orange`, `dark grey`.  *  To clear, set the color `name` to an empty string.")
  public List<JiraColorField> getColorFields() {
    return colorFields;
  }

  public void setColorFields(List<JiraColorField> colorFields) {
    this.colorFields = colorFields;
  }

  public JiraIssueFields datePickerFields(List<JiraDateField> datePickerFields) {
    this.datePickerFields = datePickerFields;
    return this;
  }

  public JiraIssueFields addDatePickerFieldsItem(JiraDateField datePickerFieldsItem) {
    if (this.datePickerFields == null) {
      this.datePickerFields = new ArrayList<>();
    }
    this.datePickerFields.add(datePickerFieldsItem);
    return this;
  }

   /**
   * Add or clear a date picker field:   *  To add, specify the date in &#x60;d/mmm/yy&#x60; format or ISO format &#x60;dd-mm-yyyy&#x60;.  *  To clear, set &#x60;formattedDate&#x60; to an empty string.
   * @return datePickerFields
  **/
  @ApiModelProperty(value = "Add or clear a date picker field:   *  To add, specify the date in `d/mmm/yy` format or ISO format `dd-mm-yyyy`.  *  To clear, set `formattedDate` to an empty string.")
  public List<JiraDateField> getDatePickerFields() {
    return datePickerFields;
  }

  public void setDatePickerFields(List<JiraDateField> datePickerFields) {
    this.datePickerFields = datePickerFields;
  }

  public JiraIssueFields dateTimePickerFields(List<JiraDateTimeField> dateTimePickerFields) {
    this.dateTimePickerFields = dateTimePickerFields;
    return this;
  }

  public JiraIssueFields addDateTimePickerFieldsItem(JiraDateTimeField dateTimePickerFieldsItem) {
    if (this.dateTimePickerFields == null) {
      this.dateTimePickerFields = new ArrayList<>();
    }
    this.dateTimePickerFields.add(dateTimePickerFieldsItem);
    return this;
  }

   /**
   * Add or clear the planned start date and time:   *  To add, specify the date and time in ISO format for &#x60;formattedDateTime&#x60;.  *  To clear, provide an empty string for &#x60;formattedDateTime&#x60;.
   * @return dateTimePickerFields
  **/
  @ApiModelProperty(value = "Add or clear the planned start date and time:   *  To add, specify the date and time in ISO format for `formattedDateTime`.  *  To clear, provide an empty string for `formattedDateTime`.")
  public List<JiraDateTimeField> getDateTimePickerFields() {
    return dateTimePickerFields;
  }

  public void setDateTimePickerFields(List<JiraDateTimeField> dateTimePickerFields) {
    this.dateTimePickerFields = dateTimePickerFields;
  }

  public JiraIssueFields issueType(JiraIssueTypeField issueType) {
    this.issueType = issueType;
    return this;
  }

   /**
   * Set the issue type field by providing an &#x60;issueTypeId&#x60;.
   * @return issueType
  **/
  @ApiModelProperty(value = "Set the issue type field by providing an `issueTypeId`.")
  public JiraIssueTypeField getIssueType() {
    return issueType;
  }

  public void setIssueType(JiraIssueTypeField issueType) {
    this.issueType = issueType;
  }

  public JiraIssueFields labelsFields(List<JiraLabelsField> labelsFields) {
    this.labelsFields = labelsFields;
    return this;
  }

  public JiraIssueFields addLabelsFieldsItem(JiraLabelsField labelsFieldsItem) {
    if (this.labelsFields == null) {
      this.labelsFields = new ArrayList<>();
    }
    this.labelsFields.add(labelsFieldsItem);
    return this;
  }

   /**
   * Edit a labels field:   *  Options include &#x60;ADD&#x60;, &#x60;REPLACE&#x60;, &#x60;REMOVE&#x60;, or &#x60;REMOVE_ALL&#x60; for bulk edits.  *  To clear labels, use the &#x60;REMOVE_ALL&#x60; option with an empty &#x60;labels&#x60; array.
   * @return labelsFields
  **/
  @ApiModelProperty(value = "Edit a labels field:   *  Options include `ADD`, `REPLACE`, `REMOVE`, or `REMOVE_ALL` for bulk edits.  *  To clear labels, use the `REMOVE_ALL` option with an empty `labels` array.")
  public List<JiraLabelsField> getLabelsFields() {
    return labelsFields;
  }

  public void setLabelsFields(List<JiraLabelsField> labelsFields) {
    this.labelsFields = labelsFields;
  }

  public JiraIssueFields multipleGroupPickerFields(List<JiraMultipleGroupPickerField> multipleGroupPickerFields) {
    this.multipleGroupPickerFields = multipleGroupPickerFields;
    return this;
  }

  public JiraIssueFields addMultipleGroupPickerFieldsItem(JiraMultipleGroupPickerField multipleGroupPickerFieldsItem) {
    if (this.multipleGroupPickerFields == null) {
      this.multipleGroupPickerFields = new ArrayList<>();
    }
    this.multipleGroupPickerFields.add(multipleGroupPickerFieldsItem);
    return this;
  }

   /**
   * Add or clear a multi-group picker field:   *  To add groups, provide an array of groups with &#x60;groupName&#x60;s.  *  To clear all groups, use an empty &#x60;groups&#x60; array.
   * @return multipleGroupPickerFields
  **/
  @ApiModelProperty(value = "Add or clear a multi-group picker field:   *  To add groups, provide an array of groups with `groupName`s.  *  To clear all groups, use an empty `groups` array.")
  public List<JiraMultipleGroupPickerField> getMultipleGroupPickerFields() {
    return multipleGroupPickerFields;
  }

  public void setMultipleGroupPickerFields(List<JiraMultipleGroupPickerField> multipleGroupPickerFields) {
    this.multipleGroupPickerFields = multipleGroupPickerFields;
  }

  public JiraIssueFields multipleSelectClearableUserPickerFields(List<JiraMultipleSelectUserPickerField> multipleSelectClearableUserPickerFields) {
    this.multipleSelectClearableUserPickerFields = multipleSelectClearableUserPickerFields;
    return this;
  }

  public JiraIssueFields addMultipleSelectClearableUserPickerFieldsItem(JiraMultipleSelectUserPickerField multipleSelectClearableUserPickerFieldsItem) {
    if (this.multipleSelectClearableUserPickerFields == null) {
      this.multipleSelectClearableUserPickerFields = new ArrayList<>();
    }
    this.multipleSelectClearableUserPickerFields.add(multipleSelectClearableUserPickerFieldsItem);
    return this;
  }

   /**
   * Assign or unassign multiple users to/from a field:   *  To assign, provide an array of user &#x60;accountId&#x60;s.  *  To clear, set &#x60;users&#x60; to &#x60;null&#x60;.
   * @return multipleSelectClearableUserPickerFields
  **/
  @ApiModelProperty(value = "Assign or unassign multiple users to/from a field:   *  To assign, provide an array of user `accountId`s.  *  To clear, set `users` to `null`.")
  public List<JiraMultipleSelectUserPickerField> getMultipleSelectClearableUserPickerFields() {
    return multipleSelectClearableUserPickerFields;
  }

  public void setMultipleSelectClearableUserPickerFields(List<JiraMultipleSelectUserPickerField> multipleSelectClearableUserPickerFields) {
    this.multipleSelectClearableUserPickerFields = multipleSelectClearableUserPickerFields;
  }

  public JiraIssueFields multipleSelectFields(List<JiraMultipleSelectField> multipleSelectFields) {
    this.multipleSelectFields = multipleSelectFields;
    return this;
  }

  public JiraIssueFields addMultipleSelectFieldsItem(JiraMultipleSelectField multipleSelectFieldsItem) {
    if (this.multipleSelectFields == null) {
      this.multipleSelectFields = new ArrayList<>();
    }
    this.multipleSelectFields.add(multipleSelectFieldsItem);
    return this;
  }

   /**
   * Add or clear a multi-select field:   *  To add, provide an array of options with &#x60;optionId&#x60;s.  *  To clear, use an empty &#x60;options&#x60; array.
   * @return multipleSelectFields
  **/
  @ApiModelProperty(value = "Add or clear a multi-select field:   *  To add, provide an array of options with `optionId`s.  *  To clear, use an empty `options` array.")
  public List<JiraMultipleSelectField> getMultipleSelectFields() {
    return multipleSelectFields;
  }

  public void setMultipleSelectFields(List<JiraMultipleSelectField> multipleSelectFields) {
    this.multipleSelectFields = multipleSelectFields;
  }

  public JiraIssueFields multipleVersionPickerFields(List<JiraMultipleVersionPickerField> multipleVersionPickerFields) {
    this.multipleVersionPickerFields = multipleVersionPickerFields;
    return this;
  }

  public JiraIssueFields addMultipleVersionPickerFieldsItem(JiraMultipleVersionPickerField multipleVersionPickerFieldsItem) {
    if (this.multipleVersionPickerFields == null) {
      this.multipleVersionPickerFields = new ArrayList<>();
    }
    this.multipleVersionPickerFields.add(multipleVersionPickerFieldsItem);
    return this;
  }

   /**
   * Edit a multi-version picker field like Fix Versions/Affects Versions:   *  Options include &#x60;ADD&#x60;, &#x60;REPLACE&#x60;, &#x60;REMOVE&#x60;, or &#x60;REMOVE_ALL&#x60; for bulk edits.  *  To clear the field, use the &#x60;REMOVE_ALL&#x60; option with an empty &#x60;versions&#x60; array.
   * @return multipleVersionPickerFields
  **/
  @ApiModelProperty(value = "Edit a multi-version picker field like Fix Versions/Affects Versions:   *  Options include `ADD`, `REPLACE`, `REMOVE`, or `REMOVE_ALL` for bulk edits.  *  To clear the field, use the `REMOVE_ALL` option with an empty `versions` array.")
  public List<JiraMultipleVersionPickerField> getMultipleVersionPickerFields() {
    return multipleVersionPickerFields;
  }

  public void setMultipleVersionPickerFields(List<JiraMultipleVersionPickerField> multipleVersionPickerFields) {
    this.multipleVersionPickerFields = multipleVersionPickerFields;
  }

  public JiraIssueFields multiselectComponents(JiraMultiSelectComponentField multiselectComponents) {
    this.multiselectComponents = multiselectComponents;
    return this;
  }

   /**
   * Edit a multi select components field:   *  Options include &#x60;ADD&#x60;, &#x60;REPLACE&#x60;, &#x60;REMOVE&#x60;, or &#x60;REMOVE_ALL&#x60; for bulk edits.  *  To clear, use the &#x60;REMOVE_ALL&#x60; option with an empty &#x60;components&#x60; array.
   * @return multiselectComponents
  **/
  @ApiModelProperty(value = "Edit a multi select components field:   *  Options include `ADD`, `REPLACE`, `REMOVE`, or `REMOVE_ALL` for bulk edits.  *  To clear, use the `REMOVE_ALL` option with an empty `components` array.")
  public JiraMultiSelectComponentField getMultiselectComponents() {
    return multiselectComponents;
  }

  public void setMultiselectComponents(JiraMultiSelectComponentField multiselectComponents) {
    this.multiselectComponents = multiselectComponents;
  }

  public JiraIssueFields originalEstimateField(JiraDurationField originalEstimateField) {
    this.originalEstimateField = originalEstimateField;
    return this;
  }

   /**
   * Edit the original estimate field.
   * @return originalEstimateField
  **/
  @ApiModelProperty(value = "Edit the original estimate field.")
  public JiraDurationField getOriginalEstimateField() {
    return originalEstimateField;
  }

  public void setOriginalEstimateField(JiraDurationField originalEstimateField) {
    this.originalEstimateField = originalEstimateField;
  }

  public JiraIssueFields priority(JiraPriorityField priority) {
    this.priority = priority;
    return this;
  }

   /**
   * Set the priority of an issue by specifying a &#x60;priorityId&#x60;.
   * @return priority
  **/
  @ApiModelProperty(value = "Set the priority of an issue by specifying a `priorityId`.")
  public JiraPriorityField getPriority() {
    return priority;
  }

  public void setPriority(JiraPriorityField priority) {
    this.priority = priority;
  }

  public JiraIssueFields richTextFields(List<JiraRichTextField> richTextFields) {
    this.richTextFields = richTextFields;
    return this;
  }

  public JiraIssueFields addRichTextFieldsItem(JiraRichTextField richTextFieldsItem) {
    if (this.richTextFields == null) {
      this.richTextFields = new ArrayList<>();
    }
    this.richTextFields.add(richTextFieldsItem);
    return this;
  }

   /**
   * Add or clear a rich text field:   *  To add, provide &#x60;adfValue&#x60;. Note that rich text fields only support ADF values.  *  To clear, use an empty &#x60;richText&#x60; object.  For ADF format details, refer to: [Atlassian Document Format](https://developer.atlassian.com/cloud/jira/platform/apis/document/structure).
   * @return richTextFields
  **/
  @ApiModelProperty(value = "Add or clear a rich text field:   *  To add, provide `adfValue`. Note that rich text fields only support ADF values.  *  To clear, use an empty `richText` object.  For ADF format details, refer to: [Atlassian Document Format](https://developer.atlassian.com/cloud/jira/platform/apis/document/structure).")
  public List<JiraRichTextField> getRichTextFields() {
    return richTextFields;
  }

  public void setRichTextFields(List<JiraRichTextField> richTextFields) {
    this.richTextFields = richTextFields;
  }

  public JiraIssueFields singleGroupPickerFields(List<JiraSingleGroupPickerField> singleGroupPickerFields) {
    this.singleGroupPickerFields = singleGroupPickerFields;
    return this;
  }

  public JiraIssueFields addSingleGroupPickerFieldsItem(JiraSingleGroupPickerField singleGroupPickerFieldsItem) {
    if (this.singleGroupPickerFields == null) {
      this.singleGroupPickerFields = new ArrayList<>();
    }
    this.singleGroupPickerFields.add(singleGroupPickerFieldsItem);
    return this;
  }

   /**
   * Add or clear a single group picker field:   *  To add, specify the group with &#x60;groupName&#x60;.  *  To clear, set &#x60;groupName&#x60; to an empty string.
   * @return singleGroupPickerFields
  **/
  @ApiModelProperty(value = "Add or clear a single group picker field:   *  To add, specify the group with `groupName`.  *  To clear, set `groupName` to an empty string.")
  public List<JiraSingleGroupPickerField> getSingleGroupPickerFields() {
    return singleGroupPickerFields;
  }

  public void setSingleGroupPickerFields(List<JiraSingleGroupPickerField> singleGroupPickerFields) {
    this.singleGroupPickerFields = singleGroupPickerFields;
  }

  public JiraIssueFields singleLineTextFields(List<JiraSingleLineTextField> singleLineTextFields) {
    this.singleLineTextFields = singleLineTextFields;
    return this;
  }

  public JiraIssueFields addSingleLineTextFieldsItem(JiraSingleLineTextField singleLineTextFieldsItem) {
    if (this.singleLineTextFields == null) {
      this.singleLineTextFields = new ArrayList<>();
    }
    this.singleLineTextFields.add(singleLineTextFieldsItem);
    return this;
  }

   /**
   * Add or clear a single line text field:   *  To add, provide the &#x60;text&#x60; value.  *  To clear, set &#x60;text&#x60; to an empty string.
   * @return singleLineTextFields
  **/
  @ApiModelProperty(value = "Add or clear a single line text field:   *  To add, provide the `text` value.  *  To clear, set `text` to an empty string.")
  public List<JiraSingleLineTextField> getSingleLineTextFields() {
    return singleLineTextFields;
  }

  public void setSingleLineTextFields(List<JiraSingleLineTextField> singleLineTextFields) {
    this.singleLineTextFields = singleLineTextFields;
  }

  public JiraIssueFields singleSelectClearableUserPickerFields(List<JiraSingleSelectUserPickerField> singleSelectClearableUserPickerFields) {
    this.singleSelectClearableUserPickerFields = singleSelectClearableUserPickerFields;
    return this;
  }

  public JiraIssueFields addSingleSelectClearableUserPickerFieldsItem(JiraSingleSelectUserPickerField singleSelectClearableUserPickerFieldsItem) {
    if (this.singleSelectClearableUserPickerFields == null) {
      this.singleSelectClearableUserPickerFields = new ArrayList<>();
    }
    this.singleSelectClearableUserPickerFields.add(singleSelectClearableUserPickerFieldsItem);
    return this;
  }

   /**
   * Edit assignment for single select user picker fields like Assignee/Reporter:   *  To assign an issue, specify the user&#39;s &#x60;accountId&#x60;.  *  To unassign an issue, set &#x60;user&#x60; to &#x60;null&#x60;.  *  For automatic assignment, set &#x60;accountId&#x60; to &#x60;-1&#x60;.
   * @return singleSelectClearableUserPickerFields
  **/
  @ApiModelProperty(value = "Edit assignment for single select user picker fields like Assignee/Reporter:   *  To assign an issue, specify the user's `accountId`.  *  To unassign an issue, set `user` to `null`.  *  For automatic assignment, set `accountId` to `-1`.")
  public List<JiraSingleSelectUserPickerField> getSingleSelectClearableUserPickerFields() {
    return singleSelectClearableUserPickerFields;
  }

  public void setSingleSelectClearableUserPickerFields(List<JiraSingleSelectUserPickerField> singleSelectClearableUserPickerFields) {
    this.singleSelectClearableUserPickerFields = singleSelectClearableUserPickerFields;
  }

  public JiraIssueFields singleSelectFields(List<JiraSingleSelectField> singleSelectFields) {
    this.singleSelectFields = singleSelectFields;
    return this;
  }

  public JiraIssueFields addSingleSelectFieldsItem(JiraSingleSelectField singleSelectFieldsItem) {
    if (this.singleSelectFields == null) {
      this.singleSelectFields = new ArrayList<>();
    }
    this.singleSelectFields.add(singleSelectFieldsItem);
    return this;
  }

   /**
   * Add or clear a single select field:   *  To add, specify the option with an &#x60;optionId&#x60;.  *  To clear, pass an option with &#x60;optionId&#x60; as &#x60;-1&#x60;.
   * @return singleSelectFields
  **/
  @ApiModelProperty(value = "Add or clear a single select field:   *  To add, specify the option with an `optionId`.  *  To clear, pass an option with `optionId` as `-1`.")
  public List<JiraSingleSelectField> getSingleSelectFields() {
    return singleSelectFields;
  }

  public void setSingleSelectFields(List<JiraSingleSelectField> singleSelectFields) {
    this.singleSelectFields = singleSelectFields;
  }

  public JiraIssueFields singleVersionPickerFields(List<JiraSingleVersionPickerField> singleVersionPickerFields) {
    this.singleVersionPickerFields = singleVersionPickerFields;
    return this;
  }

  public JiraIssueFields addSingleVersionPickerFieldsItem(JiraSingleVersionPickerField singleVersionPickerFieldsItem) {
    if (this.singleVersionPickerFields == null) {
      this.singleVersionPickerFields = new ArrayList<>();
    }
    this.singleVersionPickerFields.add(singleVersionPickerFieldsItem);
    return this;
  }

   /**
   * Add or clear a single version picker field:   *  To add, specify the version with a &#x60;versionId&#x60;.  *  To clear, set &#x60;versionId&#x60; to &#x60;-1&#x60;.
   * @return singleVersionPickerFields
  **/
  @ApiModelProperty(value = "Add or clear a single version picker field:   *  To add, specify the version with a `versionId`.  *  To clear, set `versionId` to `-1`.")
  public List<JiraSingleVersionPickerField> getSingleVersionPickerFields() {
    return singleVersionPickerFields;
  }

  public void setSingleVersionPickerFields(List<JiraSingleVersionPickerField> singleVersionPickerFields) {
    this.singleVersionPickerFields = singleVersionPickerFields;
  }

  public JiraIssueFields timeTrackingField(JiraTimeTrackingField timeTrackingField) {
    this.timeTrackingField = timeTrackingField;
    return this;
  }

   /**
   * Edit the time tracking field.
   * @return timeTrackingField
  **/
  @ApiModelProperty(value = "Edit the time tracking field.")
  public JiraTimeTrackingField getTimeTrackingField() {
    return timeTrackingField;
  }

  public void setTimeTrackingField(JiraTimeTrackingField timeTrackingField) {
    this.timeTrackingField = timeTrackingField;
  }

  public JiraIssueFields urlFields(List<JiraUrlField> urlFields) {
    this.urlFields = urlFields;
    return this;
  }

  public JiraIssueFields addUrlFieldsItem(JiraUrlField urlFieldsItem) {
    if (this.urlFields == null) {
      this.urlFields = new ArrayList<>();
    }
    this.urlFields.add(urlFieldsItem);
    return this;
  }

   /**
   * Add or clear a URL field:   *  To add, provide the &#x60;url&#x60; with the desired URL value.  *  To clear, set &#x60;url&#x60; to an empty string.
   * @return urlFields
  **/
  @ApiModelProperty(value = "Add or clear a URL field:   *  To add, provide the `url` with the desired URL value.  *  To clear, set `url` to an empty string.")
  public List<JiraUrlField> getUrlFields() {
    return urlFields;
  }

  public void setUrlFields(List<JiraUrlField> urlFields) {
    this.urlFields = urlFields;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JiraIssueFields jiraIssueFields = (JiraIssueFields) o;
    return Objects.equals(this.cascadingSelectFields, jiraIssueFields.cascadingSelectFields) &&
        Objects.equals(this.clearableNumberFields, jiraIssueFields.clearableNumberFields) &&
        Objects.equals(this.colorFields, jiraIssueFields.colorFields) &&
        Objects.equals(this.datePickerFields, jiraIssueFields.datePickerFields) &&
        Objects.equals(this.dateTimePickerFields, jiraIssueFields.dateTimePickerFields) &&
        Objects.equals(this.issueType, jiraIssueFields.issueType) &&
        Objects.equals(this.labelsFields, jiraIssueFields.labelsFields) &&
        Objects.equals(this.multipleGroupPickerFields, jiraIssueFields.multipleGroupPickerFields) &&
        Objects.equals(this.multipleSelectClearableUserPickerFields, jiraIssueFields.multipleSelectClearableUserPickerFields) &&
        Objects.equals(this.multipleSelectFields, jiraIssueFields.multipleSelectFields) &&
        Objects.equals(this.multipleVersionPickerFields, jiraIssueFields.multipleVersionPickerFields) &&
        Objects.equals(this.multiselectComponents, jiraIssueFields.multiselectComponents) &&
        Objects.equals(this.originalEstimateField, jiraIssueFields.originalEstimateField) &&
        Objects.equals(this.priority, jiraIssueFields.priority) &&
        Objects.equals(this.richTextFields, jiraIssueFields.richTextFields) &&
        Objects.equals(this.singleGroupPickerFields, jiraIssueFields.singleGroupPickerFields) &&
        Objects.equals(this.singleLineTextFields, jiraIssueFields.singleLineTextFields) &&
        Objects.equals(this.singleSelectClearableUserPickerFields, jiraIssueFields.singleSelectClearableUserPickerFields) &&
        Objects.equals(this.singleSelectFields, jiraIssueFields.singleSelectFields) &&
        Objects.equals(this.singleVersionPickerFields, jiraIssueFields.singleVersionPickerFields) &&
        Objects.equals(this.timeTrackingField, jiraIssueFields.timeTrackingField) &&
        Objects.equals(this.urlFields, jiraIssueFields.urlFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cascadingSelectFields, clearableNumberFields, colorFields, datePickerFields, dateTimePickerFields, issueType, labelsFields, multipleGroupPickerFields, multipleSelectClearableUserPickerFields, multipleSelectFields, multipleVersionPickerFields, multiselectComponents, originalEstimateField, priority, richTextFields, singleGroupPickerFields, singleLineTextFields, singleSelectClearableUserPickerFields, singleSelectFields, singleVersionPickerFields, timeTrackingField, urlFields);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JiraIssueFields {\n");
    
    sb.append("    cascadingSelectFields: ").append(toIndentedString(cascadingSelectFields)).append("\n");
    sb.append("    clearableNumberFields: ").append(toIndentedString(clearableNumberFields)).append("\n");
    sb.append("    colorFields: ").append(toIndentedString(colorFields)).append("\n");
    sb.append("    datePickerFields: ").append(toIndentedString(datePickerFields)).append("\n");
    sb.append("    dateTimePickerFields: ").append(toIndentedString(dateTimePickerFields)).append("\n");
    sb.append("    issueType: ").append(toIndentedString(issueType)).append("\n");
    sb.append("    labelsFields: ").append(toIndentedString(labelsFields)).append("\n");
    sb.append("    multipleGroupPickerFields: ").append(toIndentedString(multipleGroupPickerFields)).append("\n");
    sb.append("    multipleSelectClearableUserPickerFields: ").append(toIndentedString(multipleSelectClearableUserPickerFields)).append("\n");
    sb.append("    multipleSelectFields: ").append(toIndentedString(multipleSelectFields)).append("\n");
    sb.append("    multipleVersionPickerFields: ").append(toIndentedString(multipleVersionPickerFields)).append("\n");
    sb.append("    multiselectComponents: ").append(toIndentedString(multiselectComponents)).append("\n");
    sb.append("    originalEstimateField: ").append(toIndentedString(originalEstimateField)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    richTextFields: ").append(toIndentedString(richTextFields)).append("\n");
    sb.append("    singleGroupPickerFields: ").append(toIndentedString(singleGroupPickerFields)).append("\n");
    sb.append("    singleLineTextFields: ").append(toIndentedString(singleLineTextFields)).append("\n");
    sb.append("    singleSelectClearableUserPickerFields: ").append(toIndentedString(singleSelectClearableUserPickerFields)).append("\n");
    sb.append("    singleSelectFields: ").append(toIndentedString(singleSelectFields)).append("\n");
    sb.append("    singleVersionPickerFields: ").append(toIndentedString(singleVersionPickerFields)).append("\n");
    sb.append("    timeTrackingField: ").append(toIndentedString(timeTrackingField)).append("\n");
    sb.append("    urlFields: ").append(toIndentedString(urlFields)).append("\n");
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

