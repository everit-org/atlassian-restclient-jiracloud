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

import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanResolutionJsonBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.ReorderIssueResolutionsRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.Resolution;
import org.everit.atlassian.restclient.jiracloud.v2.model.ResolutionId;
import org.everit.atlassian.restclient.jiracloud.v2.model.SetDefaultResolutionRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.TaskProgressBeanObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueResolutionsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<ResolutionId> returnType_createResolution = new TypeReference<ResolutionId>() {};

  private static final TypeReference<Resolution> returnType_getResolution = new TypeReference<Resolution>() {};

  private static final TypeReference<List<Resolution>> returnType_getResolutions = new TypeReference<List<Resolution>>() {};

  private static final TypeReference<Object> returnType_moveResolutions = new TypeReference<Object>() {};

  private static final TypeReference<PageBeanResolutionJsonBean> returnType_searchResolutions = new TypeReference<PageBeanResolutionJsonBean>() {};

  private static final TypeReference<Object> returnType_setDefaultResolution = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateResolution = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueResolutionsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create resolution
   * Creates an issue resolution.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ResolutionId&gt;
   */
  public Single<ResolutionId> createResolution(
    Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/resolution");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createResolution);
  }

  /**
   * Delete resolution
   * Deletes an issue resolution.  This operation is [asynchronous](#async). Follow the `location` link in the response to determine the status of the task and use [Get task](#api-rest-api-2-task-taskId-get) to obtain subsequent updates.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the issue resolution. (required)
   * @param replaceWith The ID of the issue resolution that will replace the currently selected resolution. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteResolution(
    String id, String replaceWith, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/resolution/{id}");

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
   * Get resolution
   * Returns an issue resolution value.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param id The ID of the issue resolution value. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Resolution&gt;
   */
  public Single<Resolution> getResolution(
    String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/resolution/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getResolution);
  }

  /**
   * Get resolutions
   * Returns a list of all issue resolution values.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Resolution&gt;&gt;
   * @deprecated
   */
  @Deprecated
  public Single<List<Resolution>> getResolutions(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/resolution");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getResolutions);
  }

  /**
   * Move resolutions
   * Changes the order of issue resolutions.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param reorderIssueResolutionsRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> moveResolutions(
    ReorderIssueResolutionsRequest reorderIssueResolutionsRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/resolution/move");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(reorderIssueResolutionsRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_moveResolutions);
  }

  /**
   * Search resolutions
   * Returns a [paginated](#pagination) list of resolutions. The list can contain all resolutions or a subset determined by any combination of these criteria:   *  a list of resolutions IDs.  *  whether the field configuration is a default. This returns resolutions from company-managed (classic) projects only, as there is no concept of default resolutions in team-managed projects.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param id The list of resolutions IDs to be filtered out (optional, default to new ArrayList&lt;&gt;())
   * @param onlyDefault When set to true, return default only, when IDs provided, if none of them is default, return empty page. Default value is false (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanResolutionJsonBean&gt;
   */
  public Single<PageBeanResolutionJsonBean> searchResolutions(
    Optional<String> startAt, Optional<String> maxResults, Optional<List<String>> id, Optional<Boolean> onlyDefault, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/resolution/search");

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
    if (onlyDefault.isPresent()) {
      queryParams.put("onlyDefault", Collections.singleton(String.valueOf(onlyDefault.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_searchResolutions);
  }

  /**
   * Set default resolution
   * Sets default issue resolution.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param setDefaultResolutionRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setDefaultResolution(
    SetDefaultResolutionRequest setDefaultResolutionRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/resolution/default");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(setDefaultResolutionRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setDefaultResolution);
  }

  /**
   * Update resolution
   * Updates an issue resolution.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the issue resolution. (required)
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateResolution(
    String id, Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/resolution/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateResolution);
  }

}
