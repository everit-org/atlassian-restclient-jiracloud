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
package org.everit.atlassian.restclient.jiracloud.v2.api;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.jiracloud.v2.model.BulkCreateCustomFieldOptionRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.CustomFieldOption;
import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.OrderOfCustomFieldOptions;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanCustomFieldContextOption;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanCustomFieldOptionDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.UpdateCustomFieldOption;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueCustomFieldOptionsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.com";

  private static final TypeReference<Object> returnType_createCustomFieldOptions = new TypeReference<Object>() {};

  private static final TypeReference<CustomFieldOption> returnType_getCustomFieldOption = new TypeReference<CustomFieldOption>() {};

  private static final TypeReference<PageBeanCustomFieldContextOption> returnType_getOptionsForContext = new TypeReference<PageBeanCustomFieldContextOption>() {};

  private static final TypeReference<PageBeanCustomFieldOptionDetails> returnType_getOptionsForField = new TypeReference<PageBeanCustomFieldOptionDetails>() {};

  private static final TypeReference<Object> returnType_reorderCustomFieldOptions = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateCustomFieldOptions = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueCustomFieldOptionsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create custom field options
   * Creates options and, where the custom select field is of the type *Select List (cascading)*, cascading options for a custom select field. The options are added to the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. (required)
   * @param bulkCreateCustomFieldOptionRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> createCustomFieldOptions(
    Long fieldId, BulkCreateCustomFieldOptionRequest bulkCreateCustomFieldOptionRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/customField/{fieldId}/option");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(bulkCreateCustomFieldOptionRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createCustomFieldOptions);
  }

  /**
   * Delete custom field option (context)
   * Deletes a custom field option.  Options with cascading options cannot be deleted without deleting the cascading options first.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. (required)
   * @param contextId The ID of the context from which an option should be deleted. (required)
   * @param optionId The ID of the option to delete. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteCustomFieldOption(
    Long fieldId, Long contextId, Long optionId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/customField/{fieldId}/context/{contextId}/option/{optionId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    pathParams.put("optionId", String.valueOf(optionId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get custom field option
   * Returns a custom field option. For example, an option in a select list.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The custom field option is returned as follows:   *  if the user has the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  if the user has the *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for at least one project the custom field is used in, and the field is visible in at least one layout the user has permission to view.
   * @param id The ID of the custom field option. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CustomFieldOption&gt;
   */
  public Single<CustomFieldOption> getCustomFieldOption(
    String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/customFieldOption/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getCustomFieldOption);
  }

  /**
   * Get options for field (context)
   * Returns a [paginated](#pagination) list of all custom field option for a context. Options are returned first then cascading options, in the order they display in Jira.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. (required)
   * @param contextId The ID of the context. (required)
   * @param optionId The ID of the option. (optional)
   * @param onlyOptions Whether only options are returned. (optional, default to false)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 1000)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanCustomFieldContextOption&gt;
   */
  public Single<PageBeanCustomFieldContextOption> getOptionsForContext(
    Long fieldId, Long contextId, Optional<Long> optionId, Optional<Boolean> onlyOptions, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/customField/{fieldId}/context/{contextId}/option");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (optionId.isPresent()) {
      queryParams.put("optionId", Collections.singleton(String.valueOf(optionId.get())));
    }
    if (onlyOptions.isPresent()) {
      queryParams.put("onlyOptions", Collections.singleton(String.valueOf(onlyOptions.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getOptionsForContext);
  }

  /**
   * Get options for field
   * Returns a [paginated](#pagination) list of options and, where the custom select field is of the type *Select List (cascading)*, cascading options for custom select fields. Cascading options are included in the item count when determining pagination. Only options from the global context are returned.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 1000)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanCustomFieldOptionDetails&gt;
   */
  public Single<PageBeanCustomFieldOptionDetails> getOptionsForField(
    Long fieldId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/customField/{fieldId}/option");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getOptionsForField);
  }

  /**
   * Reorder options (context)
   * Changes the order of custom field options or cascading options in a context.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. (required)
   * @param contextId The ID of the context. (required)
   * @param orderOfCustomFieldOptions  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> reorderCustomFieldOptions(
    Long fieldId, Long contextId, OrderOfCustomFieldOptions orderOfCustomFieldOptions, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/customField/{fieldId}/context/{contextId}/option/move");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(orderOfCustomFieldOptions));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_reorderCustomFieldOptions);
  }

  /**
   * Update custom field options
   * Updates the options on a custom select field. Where an updated option is in use on an issue, the value on the issue is also updated. Options that are not found are ignored. A maximum of 1000 options, including sub-options of *Select List (cascading)* fields, can be updated per request. The options are updated on the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. (required)
   * @param updateCustomFieldOption  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateCustomFieldOptions(
    Long fieldId, UpdateCustomFieldOption updateCustomFieldOption, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/customField/{fieldId}/option");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(updateCustomFieldOption));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateCustomFieldOptions);
  }

}
