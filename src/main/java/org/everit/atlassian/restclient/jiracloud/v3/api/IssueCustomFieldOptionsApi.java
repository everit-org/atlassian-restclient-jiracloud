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
package org.everit.atlassian.restclient.jiracloud.v3.api;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.jiracloud.v3.model.BulkCustomFieldOptionCreateRequest;
import org.everit.atlassian.restclient.jiracloud.v3.model.BulkCustomFieldOptionUpdateRequest;
import org.everit.atlassian.restclient.jiracloud.v3.model.CustomFieldCreatedContextOptionsList;
import org.everit.atlassian.restclient.jiracloud.v3.model.CustomFieldOption;
import org.everit.atlassian.restclient.jiracloud.v3.model.CustomFieldUpdatedContextOptionsList;
import org.everit.atlassian.restclient.jiracloud.v3.model.OrderOfCustomFieldOptions;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanCustomFieldContextOption;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueCustomFieldOptionsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<CustomFieldCreatedContextOptionsList> returnType_createCustomFieldOption = new TypeReference<CustomFieldCreatedContextOptionsList>() {};

  private static final TypeReference<CustomFieldOption> returnType_getCustomFieldOption = new TypeReference<CustomFieldOption>() {};

  private static final TypeReference<PageBeanCustomFieldContextOption> returnType_getOptionsForContext = new TypeReference<PageBeanCustomFieldContextOption>() {};

  private static final TypeReference<Object> returnType_reorderCustomFieldOptions = new TypeReference<Object>() {};

  private static final TypeReference<CustomFieldUpdatedContextOptionsList> returnType_updateCustomFieldOption = new TypeReference<CustomFieldUpdatedContextOptionsList>() {};

  private final RestClient restClient;

  public IssueCustomFieldOptionsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create custom field options (context)
   * Creates options and, where the custom select field is of the type Select List (cascading), cascading options for a custom select field. The options are added to a context of the field.  The maximum number of options that can be created per request is 1000 and each field can have a maximum of 10000 options.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. (required)
   * @param bulkCustomFieldOptionCreateRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CustomFieldCreatedContextOptionsList&gt;
   */
  public Single<CustomFieldCreatedContextOptionsList> createCustomFieldOption(
    String fieldId, Long contextId, BulkCustomFieldOptionCreateRequest bulkCustomFieldOptionCreateRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/field/{fieldId}/context/{contextId}/option");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(bulkCustomFieldOptionCreateRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createCustomFieldOption);
  }

  /**
   * Delete custom field options (context)
   * Deletes a custom field option.  Options with cascading options cannot be deleted without deleting the cascading options first.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context from which an option should be deleted. (required)
   * @param optionId The ID of the option to delete. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteCustomFieldOption(
    String fieldId, Long contextId, Long optionId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/field/{fieldId}/context/{contextId}/option/{optionId}");

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
        .path("/rest/api/3/customFieldOption/{id}");

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
   * Get custom field options (context)
   * Returns a [paginated](#pagination) list of all custom field option for a context. Options are returned first then cascading options, in the order they display in Jira.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. (required)
   * @param optionId The ID of the option. (optional)
   * @param onlyOptions Whether only options are returned. (optional, default to false)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 100)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanCustomFieldContextOption&gt;
   */
  public Single<PageBeanCustomFieldContextOption> getOptionsForContext(
    String fieldId, Long contextId, Optional<Long> optionId, Optional<Boolean> onlyOptions, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/field/{fieldId}/context/{contextId}/option");

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
   * Reorder custom field options (context)
   * Changes the order of custom field options or cascading options in a context.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. (required)
   * @param orderOfCustomFieldOptions  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> reorderCustomFieldOptions(
    String fieldId, Long contextId, OrderOfCustomFieldOptions orderOfCustomFieldOptions, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/field/{fieldId}/context/{contextId}/option/move");

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
   * Update custom field options (context)
   * Updates the options of a custom field.  If any of the options are not found, no options are updated. Options where the values in the request match the current values aren't updated and aren't reported in the response.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. (required)
   * @param bulkCustomFieldOptionUpdateRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CustomFieldUpdatedContextOptionsList&gt;
   */
  public Single<CustomFieldUpdatedContextOptionsList> updateCustomFieldOption(
    String fieldId, Long contextId, BulkCustomFieldOptionUpdateRequest bulkCustomFieldOptionUpdateRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/field/{fieldId}/context/{contextId}/option");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(bulkCustomFieldOptionUpdateRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateCustomFieldOption);
  }

}
