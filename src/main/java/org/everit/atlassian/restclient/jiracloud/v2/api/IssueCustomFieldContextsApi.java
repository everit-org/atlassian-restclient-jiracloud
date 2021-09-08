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

import org.everit.atlassian.restclient.jiracloud.v2.model.CreateCustomFieldContext;
import org.everit.atlassian.restclient.jiracloud.v2.model.CustomFieldContextDefaultValueUpdate;
import org.everit.atlassian.restclient.jiracloud.v2.model.CustomFieldContextUpdateDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeIDs;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanContextForProjectAndIssueType;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanCustomFieldContext;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanCustomFieldContextDefaultValue;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanCustomFieldContextProjectMapping;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanIssueTypeToContextMapping;
import org.everit.atlassian.restclient.jiracloud.v2.model.ProjectIds;
import org.everit.atlassian.restclient.jiracloud.v2.model.ProjectIssueTypeMappings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueCustomFieldContextsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_addIssueTypesToContext = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_assignProjectsToCustomFieldContext = new TypeReference<Object>() {};

  private static final TypeReference<CreateCustomFieldContext> returnType_createCustomFieldContext = new TypeReference<CreateCustomFieldContext>() {};

  private static final TypeReference<Object> returnType_deleteCustomFieldContext = new TypeReference<Object>() {};

  private static final TypeReference<PageBeanCustomFieldContext> returnType_getContextsForField = new TypeReference<PageBeanCustomFieldContext>() {};

  private static final TypeReference<PageBeanContextForProjectAndIssueType> returnType_getCustomFieldContextsForProjectsAndIssueTypes = new TypeReference<PageBeanContextForProjectAndIssueType>() {};

  private static final TypeReference<PageBeanCustomFieldContextDefaultValue> returnType_getDefaultValues = new TypeReference<PageBeanCustomFieldContextDefaultValue>() {};

  private static final TypeReference<PageBeanIssueTypeToContextMapping> returnType_getIssueTypeMappingsForContexts = new TypeReference<PageBeanIssueTypeToContextMapping>() {};

  private static final TypeReference<PageBeanCustomFieldContextProjectMapping> returnType_getProjectContextMapping = new TypeReference<PageBeanCustomFieldContextProjectMapping>() {};

  private static final TypeReference<Object> returnType_removeCustomFieldContextFromProjects = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_removeIssueTypesFromContext = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_setDefaultValues = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateCustomFieldContext = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueCustomFieldContextsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add issue types to context
   * Adds issue types to a custom field context, appending the issue types to the issue types list.  A custom field context without any issue types applies to all issue types. Adding issue types to such a custom field context would result in it applying to only the listed issue types.  If any of the issue types exists in the custom field context, the operation fails and no issue types are added.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. (required)
   * @param issueTypeIDs  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> addIssueTypesToContext(
    String fieldId, Long contextId, IssueTypeIDs issueTypeIDs, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/{contextId}/issuetype");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeIDs));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addIssueTypesToContext);
  }

  /**
   * Assign custom field context to projects
   * Assigns a custom field context to projects.  If any project in the request is assigned to any context of the custom field, the operation fails.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. (required)
   * @param projectIds  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> assignProjectsToCustomFieldContext(
    String fieldId, Long contextId, ProjectIds projectIds, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/{contextId}/project");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(projectIds));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_assignProjectsToCustomFieldContext);
  }

  /**
   * Create custom field context
   * Creates a custom field context.  If `projectIds` is empty, a global context is created. A global context is one that applies to all project. If `issueTypeIds` is empty, the context applies to all issue types.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param createCustomFieldContext  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CreateCustomFieldContext&gt;
   */
  public Single<CreateCustomFieldContext> createCustomFieldContext(
    String fieldId, CreateCustomFieldContext createCustomFieldContext, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(createCustomFieldContext));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createCustomFieldContext);
  }

  /**
   * Delete custom field context
   * Deletes a [ custom field context](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteCustomFieldContext(
    String fieldId, Long contextId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/{contextId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteCustomFieldContext);
  }

  /**
   * Get custom field contexts
   * Returns a [paginated](#pagination) list of [ contexts](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html) for a custom field. Contexts can be returned as follows:   *  With no other parameters set, all contexts.  *  By defining `id` only, all contexts from the list of IDs.  *  By defining `isAnyIssueType`, limit the list of contexts returned to either those that apply to all issue types (true) or those that apply to only a subset of issue types (false)  *  By defining `isGlobalContext`, limit the list of contexts return to either those that apply to all projects (global contexts) (true) or those that apply to only a subset of projects (false).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param isAnyIssueType Whether to return contexts that apply to all issue types. (optional)
   * @param isGlobalContext Whether to return contexts that apply to all projects. (optional)
   * @param contextId The list of context IDs. To include multiple contexts, separate IDs with ampersand: `contextId=10000&contextId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanCustomFieldContext&gt;
   */
  public Single<PageBeanCustomFieldContext> getContextsForField(
    String fieldId, Optional<Boolean> isAnyIssueType, Optional<Boolean> isGlobalContext, Optional<List<Long>> contextId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (isAnyIssueType.isPresent()) {
      queryParams.put("isAnyIssueType", Collections.singleton(String.valueOf(isAnyIssueType.get())));
    }
    if (isGlobalContext.isPresent()) {
      queryParams.put("isGlobalContext", Collections.singleton(String.valueOf(isGlobalContext.get())));
    }
    if (contextId.isPresent()) {
      queryParams.put("contextId", RestClientUtil.objectCollectionToStringCollection(contextId.get()));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getContextsForField);
  }

  /**
   * Get custom field contexts for projects and issue types
   * Returns a [paginated](#pagination) list of project and issue type mappings and, for each mapping, the ID of a [custom field context](https://confluence.atlassian.com/x/k44fOw) that applies to the project and issue type.  If there is no custom field context assigned to the project then, if present, the custom field context that applies to all projects is returned if it also applies to the issue type or all issue types. If a custom field context is not found, the returned custom field context ID is `null`.  Duplicate project and issue type mappings cannot be provided in the request.  The order of the returned values is the same as provided in the request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param projectIssueTypeMappings The list of project and issue type mappings. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanContextForProjectAndIssueType&gt;
   */
  public Single<PageBeanContextForProjectAndIssueType> getCustomFieldContextsForProjectsAndIssueTypes(
    String fieldId, ProjectIssueTypeMappings projectIssueTypeMappings, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/mapping");

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

    requestBuilder.requestBody(Optional.of(projectIssueTypeMappings));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getCustomFieldContextsForProjectsAndIssueTypes);
  }

  /**
   * Get custom field contexts default values
   * Returns a [paginated](#pagination) list of defaults for a custom field. The results can be filtered by `contextId`, otherwise all values are returned. If no defaults are set for a context, nothing is returned.   The returned object depends on type of the custom field:   *  `CustomFieldContextDefaultValueSingleOption` (type `option.single`) for single choice select lists and radio buttons.  *  `CustomFieldContextDefaultValueMultipleOption` (type `option.multiple`) for multiple choice select lists and checkboxes.  *  `CustomFieldContextDefaultValueCascadingOption` (type `option.cascading`) for cascading select lists.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field, for example `customfield\\_10000`. (required)
   * @param contextId The IDs of the contexts. (optional, default to new ArrayList&lt;&gt;())
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanCustomFieldContextDefaultValue&gt;
   */
  public Single<PageBeanCustomFieldContextDefaultValue> getDefaultValues(
    String fieldId, Optional<List<Long>> contextId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/defaultValue");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (contextId.isPresent()) {
      queryParams.put("contextId", RestClientUtil.objectCollectionToStringCollection(contextId.get()));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getDefaultValues);
  }

  /**
   * Get issue types for custom field context
   * Returns a [paginated](#pagination) list of context to issue type mappings for a custom field. Mappings are returned for all contexts or a list of contexts. Mappings are ordered first by context ID and then by issue type ID.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. To include multiple contexts, provide an ampersand-separated list. For example, `contextId=10001&contextId=10002`. (optional, default to new ArrayList&lt;&gt;())
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueTypeToContextMapping&gt;
   */
  public Single<PageBeanIssueTypeToContextMapping> getIssueTypeMappingsForContexts(
    String fieldId, Optional<List<Long>> contextId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/issuetypemapping");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (contextId.isPresent()) {
      queryParams.put("contextId", RestClientUtil.objectCollectionToStringCollection(contextId.get()));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssueTypeMappingsForContexts);
  }

  /**
   * Get project mappings for custom field context
   * Returns a [paginated](#pagination) list of context to project mappings for a custom field. The result can be filtered by `contextId`. Otherwise, all mappings are returned. Invalid IDs are ignored.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field, for example `customfield\\_10000`. (required)
   * @param contextId The list of context IDs. To include multiple context, separate IDs with ampersand: `contextId=10000&contextId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanCustomFieldContextProjectMapping&gt;
   */
  public Single<PageBeanCustomFieldContextProjectMapping> getProjectContextMapping(
    String fieldId, Optional<List<Long>> contextId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/projectmapping");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (contextId.isPresent()) {
      queryParams.put("contextId", RestClientUtil.objectCollectionToStringCollection(contextId.get()));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getProjectContextMapping);
  }

  /**
   * Remove custom field context from projects
   * Removes a custom field context from projects.  A custom field context without any projects applies to all projects. Removing all projects from a custom field context would result in it applying to all projects.  If any project in the request is not assigned to the context, or the operation would result in two global contexts for the field, the operation fails.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. (required)
   * @param projectIds  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> removeCustomFieldContextFromProjects(
    String fieldId, Long contextId, ProjectIds projectIds, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/{contextId}/project/remove");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(projectIds));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeCustomFieldContextFromProjects);
  }

  /**
   * Remove issue types from context
   * Removes issue types from a custom field context.  A custom field context without any issue types applies to all issue types.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. (required)
   * @param issueTypeIDs  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> removeIssueTypesFromContext(
    String fieldId, Long contextId, IssueTypeIDs issueTypeIDs, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/{contextId}/issuetype/remove");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeIDs));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeIssueTypesFromContext);
  }

  /**
   * Set custom field contexts default values
   * Sets default for contexts of a custom field. Default are defined using these objects:   *  `CustomFieldContextDefaultValueSingleOption` (type `option.single`) for single choice select lists and radio buttons.  *  `CustomFieldContextDefaultValueMultipleOption` (type `option.multiple`) for multiple choice select lists and checkboxes.  *  `CustomFieldContextDefaultValueCascadingOption` (type `option.cascading`) for cascading select lists.  Only one type of default object can be included in a request. To remove a default for a context, set the default parameter to `null`.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param customFieldContextDefaultValueUpdate  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setDefaultValues(
    String fieldId, CustomFieldContextDefaultValueUpdate customFieldContextDefaultValueUpdate, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/defaultValue");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(customFieldContextDefaultValueUpdate));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setDefaultValues);
  }

  /**
   * Update custom field context
   * Updates a [ custom field context](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldId The ID of the custom field. (required)
   * @param contextId The ID of the context. (required)
   * @param customFieldContextUpdateDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateCustomFieldContext(
    String fieldId, Long contextId, CustomFieldContextUpdateDetails customFieldContextUpdateDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/{fieldId}/context/{contextId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    pathParams.put("contextId", String.valueOf(contextId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(customFieldContextUpdateDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateCustomFieldContext);
  }

}
