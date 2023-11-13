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

import org.everit.atlassian.restclient.jiracloud.v2.model.ScreenableTab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreenTabsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<ScreenableTab> returnType_addScreenTab = new TypeReference<ScreenableTab>() {};

  private static final TypeReference<List<ScreenableTab>> returnType_getAllScreenTabs = new TypeReference<List<ScreenableTab>>() {};

  private static final TypeReference<Object> returnType_moveScreenTab = new TypeReference<Object>() {};

  private static final TypeReference<ScreenableTab> returnType_renameScreenTab = new TypeReference<ScreenableTab>() {};

  private final RestClient restClient;

  public ScreenTabsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create screen tab
   * Creates a tab for a screen.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenId The ID of the screen. (required)
   * @param screenableTab  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ScreenableTab&gt;
   */
  public Single<ScreenableTab> addScreenTab(
    Long screenId, ScreenableTab screenableTab, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/screens/{screenId}/tabs");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(screenableTab));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addScreenTab);
  }

  /**
   * Delete screen tab
   * Deletes a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenId The ID of the screen. (required)
   * @param tabId The ID of the screen tab. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteScreenTab(
    Long screenId, Long tabId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/screens/{screenId}/tabs/{tabId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get all screen tabs
   * Returns the list of tabs for a screen.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.
   * @param screenId The ID of the screen. (required)
   * @param projectKey The key of the project. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ScreenableTab&gt;&gt;
   */
  public Single<List<ScreenableTab>> getAllScreenTabs(
    Long screenId, Optional<String> projectKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/screens/{screenId}/tabs");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (projectKey.isPresent()) {
      queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllScreenTabs);
  }

  /**
   * Get bulk screen tabs
   * Returns the list of tabs for a bulk of screens.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenId The list of screen IDs. To include multiple screen IDs, provide an ampersand-separated list. For example, `screenId=10000&screenId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param tabId The list of tab IDs. To include multiple tab IDs, provide an ampersand-separated list. For example, `tabId=10000&tabId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResult The maximum number of items to return per page. The maximum number is 100, (optional, default to 100)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable getBulkScreenTabs(
    Optional<List<Long>> screenId, Optional<List<Long>> tabId, Optional<Long> startAt, Optional<Integer> maxResult, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/screens/tabs");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (screenId.isPresent()) {
      queryParams.put("screenId", RestClientUtil.objectCollectionToStringCollection(screenId.get()));
    }
    if (tabId.isPresent()) {
      queryParams.put("tabId", RestClientUtil.objectCollectionToStringCollection(tabId.get()));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResult.isPresent()) {
      queryParams.put("maxResult", Collections.singleton(String.valueOf(maxResult.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Move screen tab
   * Moves a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenId The ID of the screen. (required)
   * @param tabId The ID of the screen tab. (required)
   * @param pos The position of tab. The base index is 0. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> moveScreenTab(
    Long screenId, Long tabId, Integer pos, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/screens/{screenId}/tabs/{tabId}/move/{pos}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    pathParams.put("pos", String.valueOf(pos));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_moveScreenTab);
  }

  /**
   * Update screen tab
   * Updates the name of a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenId The ID of the screen. (required)
   * @param tabId The ID of the screen tab. (required)
   * @param screenableTab  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ScreenableTab&gt;
   */
  public Single<ScreenableTab> renameScreenTab(
    Long screenId, Long tabId, ScreenableTab screenableTab, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/screens/{screenId}/tabs/{tabId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(screenableTab));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_renameScreenTab);
  }

}
