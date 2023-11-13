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

import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanScreenScheme;
import org.everit.atlassian.restclient.jiracloud.v3.model.ScreenSchemeDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.ScreenSchemeId;
import org.everit.atlassian.restclient.jiracloud.v3.model.UpdateScreenSchemeDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreenSchemesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<ScreenSchemeId> returnType_createScreenScheme = new TypeReference<ScreenSchemeId>() {};

  private static final TypeReference<PageBeanScreenScheme> returnType_getScreenSchemes = new TypeReference<PageBeanScreenScheme>() {};

  private static final TypeReference<Object> returnType_updateScreenScheme = new TypeReference<Object>() {};

  private final RestClient restClient;

  public ScreenSchemesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create screen scheme
   * Creates a screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenSchemeDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ScreenSchemeId&gt;
   */
  public Single<ScreenSchemeId> createScreenScheme(
    ScreenSchemeDetails screenSchemeDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screenscheme");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(screenSchemeDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createScreenScheme);
  }

  /**
   * Delete screen scheme
   * Deletes a screen scheme. A screen scheme cannot be deleted if it is used in an issue type screen scheme.  Only screens schemes used in classic projects can be deleted.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenSchemeId The ID of the screen scheme. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteScreenScheme(
    String screenSchemeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screenscheme/{screenSchemeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenSchemeId", String.valueOf(screenSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get screen schemes
   * Returns a [paginated](#pagination) list of screen schemes.  Only screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 25)
   * @param id The list of screen scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, `id=10000&id=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param expand Use [expand](#expansion) include additional information in the response. This parameter accepts `issueTypeScreenSchemes` that, for each screen schemes, returns information about the issue type screen scheme the screen scheme is assigned to. (optional, default to &quot;&quot;)
   * @param queryString String used to perform a case-insensitive partial match with screen scheme name. (optional, default to &quot;&quot;)
   * @param orderBy [Order](#ordering) the results by a field:   *  `id` Sorts by screen scheme ID.  *  `name` Sorts by screen scheme name. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanScreenScheme&gt;
   */
  public Single<PageBeanScreenScheme> getScreenSchemes(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<Long>> id, Optional<String> expand, Optional<String> queryString, Optional<String> orderBy, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screenscheme");

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
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    if (queryString.isPresent()) {
      queryParams.put("queryString", Collections.singleton(String.valueOf(queryString.get())));
    }
    if (orderBy.isPresent()) {
      queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getScreenSchemes);
  }

  /**
   * Update screen scheme
   * Updates a screen scheme. Only screen schemes used in classic projects can be updated.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenSchemeId The ID of the screen scheme. (required)
   * @param updateScreenSchemeDetails The screen scheme update details. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateScreenScheme(
    String screenSchemeId, UpdateScreenSchemeDetails updateScreenSchemeDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screenscheme/{screenSchemeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenSchemeId", String.valueOf(screenSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(updateScreenSchemeDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateScreenScheme);
  }

}
