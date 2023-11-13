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

import org.everit.atlassian.restclient.jiracloud.v3.model.CreateUiModificationDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanUiModificationDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.UiModificationIdentifiers;
import org.everit.atlassian.restclient.jiracloud.v3.model.UpdateUiModificationDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UiModificationsAppsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<UiModificationIdentifiers> returnType_createUiModification = new TypeReference<UiModificationIdentifiers>() {};

  private static final TypeReference<Object> returnType_deleteUiModification = new TypeReference<Object>() {};

  private static final TypeReference<PageBeanUiModificationDetails> returnType_getUiModifications = new TypeReference<PageBeanUiModificationDetails>() {};

  private static final TypeReference<Object> returnType_updateUiModification = new TypeReference<Object>() {};

  private final RestClient restClient;

  public UiModificationsAppsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create UI modification
   * Creates a UI modification. UI modification can only be created by Forge apps.  Each app can define up to 3000 UI modifications. Each UI modification can define up to 1000 contexts. The same context can be assigned to maximum 100 UI modifications.  **[Permissions](#permissions) required:**   *  *None* if the UI modification is created without contexts.  *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for one or more projects, if the UI modification is created with contexts.
   * @param createUiModificationDetails Details of the UI modification. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;UiModificationIdentifiers&gt;
   */
  public Single<UiModificationIdentifiers> createUiModification(
    CreateUiModificationDetails createUiModificationDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/uiModifications");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(createUiModificationDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createUiModification);
  }

  /**
   * Delete UI modification
   * Deletes a UI modification. All the contexts that belong to the UI modification are deleted too. UI modification can only be deleted by Forge apps.  **[Permissions](#permissions) required:** None.
   * @param uiModificationId The ID of the UI modification. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteUiModification(
    String uiModificationId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/uiModifications/{uiModificationId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("uiModificationId", String.valueOf(uiModificationId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteUiModification);
  }

  /**
   * Get UI modifications
   * Gets UI modifications. UI modifications can only be retrieved by Forge apps.  **[Permissions](#permissions) required:** None.
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param expand Use expand to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `data` Returns UI modification data.  *  `contexts` Returns UI modification contexts. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanUiModificationDetails&gt;
   */
  public Single<PageBeanUiModificationDetails> getUiModifications(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/uiModifications");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getUiModifications);
  }

  /**
   * Update UI modification
   * Updates a UI modification. UI modification can only be updated by Forge apps.  Each UI modification can define up to 1000 contexts. The same context can be assigned to maximum 100 UI modifications.  **[Permissions](#permissions) required:**   *  *None* if the UI modification is created without contexts.  *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for one or more projects, if the UI modification is created with contexts.
   * @param uiModificationId The ID of the UI modification. (required)
   * @param updateUiModificationDetails Details of the UI modification. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateUiModification(
    String uiModificationId, UpdateUiModificationDetails updateUiModificationDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/uiModifications/{uiModificationId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("uiModificationId", String.valueOf(uiModificationId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(updateUiModificationDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateUiModification);
  }

}
