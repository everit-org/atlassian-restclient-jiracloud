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

import org.everit.atlassian.restclient.jiracloud.v2.model.JqlFunctionPrecomputationGetByIdRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.JqlFunctionPrecomputationGetByIdResponse;
import org.everit.atlassian.restclient.jiracloud.v2.model.JqlFunctionPrecomputationUpdateErrorResponse;
import org.everit.atlassian.restclient.jiracloud.v2.model.JqlFunctionPrecomputationUpdateRequestBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.JqlFunctionPrecomputationUpdateResponse;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBean2JqlFunctionPrecomputationBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JqlFunctionsAppsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PageBean2JqlFunctionPrecomputationBean> returnType_getPrecomputations = new TypeReference<PageBean2JqlFunctionPrecomputationBean>() {};

  private static final TypeReference<JqlFunctionPrecomputationGetByIdResponse> returnType_getPrecomputationsByID = new TypeReference<JqlFunctionPrecomputationGetByIdResponse>() {};

  private static final TypeReference<JqlFunctionPrecomputationUpdateResponse> returnType_updatePrecomputations = new TypeReference<JqlFunctionPrecomputationUpdateResponse>() {};

  private final RestClient restClient;

  public JqlFunctionsAppsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get precomputations (apps)
   * Returns the list of a function's precomputations along with information about when they were created, updated, and last used. Each precomputation has a `value` \\- the JQL fragment to replace the custom function clause with.  **[Permissions](#permissions) required:** This API is only accessible to apps and apps can only inspect their own functions.  The new `read:app-data:jira` OAuth scope is 100% optional now, and not using it won't break your app. However, we recommend adding it to your app's scope list because we will eventually make it mandatory.
   * @param functionKey The function key in format:   *  Forge: `ari:cloud:ecosystem::extension/[App ID]/[Environment ID]/static/[Function key from manifest]`  *  Connect: `[App key]__[Module key]` (optional, default to new ArrayList&lt;&gt;())
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 100)
   * @param orderBy [Order](#ordering) the results by a field:   *  `functionKey` Sorts by the functionKey.  *  `used` Sorts by the used timestamp.  *  `created` Sorts by the created timestamp.  *  `updated` Sorts by the updated timestamp. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBean2JqlFunctionPrecomputationBean&gt;
   */
  public Single<PageBean2JqlFunctionPrecomputationBean> getPrecomputations(
    Optional<List<String>> functionKey, Optional<Long> startAt, Optional<Integer> maxResults, Optional<String> orderBy, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/jql/function/computation");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (functionKey.isPresent()) {
      queryParams.put("functionKey", RestClientUtil.objectCollectionToStringCollection(functionKey.get()));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (orderBy.isPresent()) {
      queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPrecomputations);
  }

  /**
   * Get precomputations by ID (apps)
   * Returns function precomputations by IDs, along with information about when they were created, updated, and last used. Each precomputation has a `value` \\- the JQL fragment to replace the custom function clause with.  **[Permissions](#permissions) required:** This API is only accessible to apps and apps can only inspect their own functions.  The new `read:app-data:jira` OAuth scope is 100% optional now, and not using it won't break your app. However, we recommend adding it to your app's scope list because we will eventually make it mandatory.
   * @param jqlFunctionPrecomputationGetByIdRequest  (required)
   * @param orderBy [Order](#ordering) the results by a field:   *  `functionKey` Sorts by the functionKey.  *  `used` Sorts by the used timestamp.  *  `created` Sorts by the created timestamp.  *  `updated` Sorts by the updated timestamp. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;JqlFunctionPrecomputationGetByIdResponse&gt;
   */
  public Single<JqlFunctionPrecomputationGetByIdResponse> getPrecomputationsByID(
    JqlFunctionPrecomputationGetByIdRequest jqlFunctionPrecomputationGetByIdRequest, Optional<String> orderBy, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/jql/function/computation/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (orderBy.isPresent()) {
      queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(jqlFunctionPrecomputationGetByIdRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPrecomputationsByID);
  }

  /**
   * Update precomputations (apps)
   * Update the precomputation value of a function created by a Forge/Connect app.  **[Permissions](#permissions) required:** An API for apps to update their own precomputations.  The new `write:app-data:jira` OAuth scope is 100% optional now, and not using it won't break your app. However, we recommend adding it to your app's scope list because we will eventually make it mandatory.
   * @param jqlFunctionPrecomputationUpdateRequestBean  (required)
   * @param skipNotFoundPrecomputations  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;JqlFunctionPrecomputationUpdateResponse&gt;
   */
  public Single<JqlFunctionPrecomputationUpdateResponse> updatePrecomputations(
    JqlFunctionPrecomputationUpdateRequestBean jqlFunctionPrecomputationUpdateRequestBean, Optional<Boolean> skipNotFoundPrecomputations, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/jql/function/computation");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (skipNotFoundPrecomputations.isPresent()) {
      queryParams.put("skipNotFoundPrecomputations", Collections.singleton(String.valueOf(skipNotFoundPrecomputations.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(jqlFunctionPrecomputationUpdateRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updatePrecomputations);
  }

}
