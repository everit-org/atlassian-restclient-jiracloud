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

import org.everit.atlassian.restclient.jiracloud.v3.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanPriority;
import org.everit.atlassian.restclient.jiracloud.v3.model.Priority;
import org.everit.atlassian.restclient.jiracloud.v3.model.PriorityId;
import org.everit.atlassian.restclient.jiracloud.v3.model.ReorderIssuePriorities;
import org.everit.atlassian.restclient.jiracloud.v3.model.SetDefaultPriorityRequest;
import org.everit.atlassian.restclient.jiracloud.v3.model.TaskProgressBeanObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssuePrioritiesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PriorityId> returnType_createPriority = new TypeReference<PriorityId>() {};

  private static final TypeReference<List<Priority>> returnType_getPriorities = new TypeReference<List<Priority>>() {};

  private static final TypeReference<Priority> returnType_getPriority = new TypeReference<Priority>() {};

  private static final TypeReference<Object> returnType_movePriorities = new TypeReference<Object>() {};

  private static final TypeReference<PageBeanPriority> returnType_searchPriorities = new TypeReference<PageBeanPriority>() {};

  private static final TypeReference<Object> returnType_setDefaultPriority = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updatePriority = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssuePrioritiesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create priority
   * Creates an issue priority.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PriorityId&gt;
   */
  public Single<PriorityId> createPriority(
    Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priority");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createPriority);
  }

  /**
   * Delete priority
   * *Deprecated: please refer to the* [changelog](https://developer.atlassian.com/changelog/#CHANGE-1066) *for more details.*  Deletes an issue priority.  This operation is [asynchronous](#async). Follow the `location` link in the response to determine the status of the task and use [Get task](#api-rest-api-3-task-taskId-get) to obtain subsequent updates.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the issue priority. (required)
   * @param replaceWith The ID of the issue priority that will replace the currently selected resolution. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   * @deprecated
   */
  @Deprecated
  public Completable deletePriority(
    String id, String replaceWith, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priority/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("replaceWith", Collections.singleton(String.valueOf(replaceWith)));
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get priorities
   * Returns the list of all issue priorities.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Priority&gt;&gt;
   * @deprecated
   */
  @Deprecated
  public Single<List<Priority>> getPriorities(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priority");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPriorities);
  }

  /**
   * Get priority
   * Returns an issue priority.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param id The ID of the issue priority. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Priority&gt;
   */
  public Single<Priority> getPriority(
    String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priority/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPriority);
  }

  /**
   * Move priorities
   * Changes the order of issue priorities.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param reorderIssuePriorities  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> movePriorities(
    ReorderIssuePriorities reorderIssuePriorities, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priority/move");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(reorderIssuePriorities));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_movePriorities);
  }

  /**
   * Search priorities
   * Returns a [paginated](#pagination) list of priorities. The list can contain all priorities or a subset determined by any combination of these criteria:   *  a list of priority IDs. Any invalid priority IDs are ignored.  *  a list of project IDs. Only priorities that are available in these projects will be returned. Any invalid project IDs are ignored.  *  whether the field configuration is a default. This returns priorities from company-managed (classic) projects only, as there is no concept of default priorities in team-managed projects.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param id The list of priority IDs. To include multiple IDs, provide an ampersand-separated list. For example, `id=2&id=3`. (optional, default to new ArrayList&lt;&gt;())
   * @param projectId The list of projects IDs. To include multiple IDs, provide an ampersand-separated list. For example, `projectId=10010&projectId=10111`. (optional, default to new ArrayList&lt;&gt;())
   * @param priorityName The name of priority to search for. (optional, default to &quot;&quot;)
   * @param onlyDefault Whether only the default priority is returned. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanPriority&gt;
   */
  public Single<PageBeanPriority> searchPriorities(
    Optional<String> startAt, Optional<String> maxResults, Optional<List<String>> id, Optional<List<String>> projectId, Optional<String> priorityName, Optional<Boolean> onlyDefault, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priority/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (id.isPresent()) {
      queryParams.put("id", RestClientUtil.objectCollectionToStringCollection(id.get()));
    }
    if (projectId.isPresent()) {
      queryParams.put("projectId", RestClientUtil.objectCollectionToStringCollection(projectId.get()));
    }
    if (priorityName.isPresent()) {
      queryParams.put("priorityName", Collections.singleton(String.valueOf(priorityName.get())));
    }
    if (onlyDefault.isPresent()) {
      queryParams.put("onlyDefault", Collections.singleton(String.valueOf(onlyDefault.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_searchPriorities);
  }

  /**
   * Set default priority
   * Sets default issue priority.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param setDefaultPriorityRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setDefaultPriority(
    SetDefaultPriorityRequest setDefaultPriorityRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priority/default");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(setDefaultPriorityRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setDefaultPriority);
  }

  /**
   * Update priority
   * Updates an issue priority.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the issue priority. (required)
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updatePriority(
    String id, Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priority/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updatePriority);
  }

}
