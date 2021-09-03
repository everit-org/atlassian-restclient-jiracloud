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

import org.everit.atlassian.restclient.jiracloud.v2.model.AddFieldBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.MoveFieldBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.ScreenableField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreenTabFieldsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<ScreenableField> returnType_addScreenTabField = new TypeReference<ScreenableField>() {};

  private static final TypeReference<List<ScreenableField>> returnType_getAllScreenTabFields = new TypeReference<List<ScreenableField>>() {};

  private static final TypeReference<Object> returnType_moveScreenTabField = new TypeReference<Object>() {};

  private final RestClient restClient;

  public ScreenTabFieldsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add screen tab field
   * Adds a field to a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenId The ID of the screen. (required)
   * @param tabId The ID of the screen tab. (required)
   * @param addFieldBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ScreenableField&gt;
   */
  public Single<ScreenableField> addScreenTabField(
    Long screenId, Long tabId, AddFieldBean addFieldBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/screens/{screenId}/tabs/{tabId}/fields");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(addFieldBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addScreenTabField);
  }

  /**
   * Get all screen tab fields
   * Returns all fields for a screen tab.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.
   * @param screenId The ID of the screen. (required)
   * @param tabId The ID of the screen tab. (required)
   * @param projectKey The key of the project. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ScreenableField&gt;&gt;
   */
  public Single<List<ScreenableField>> getAllScreenTabFields(
    Long screenId, Long tabId, Optional<String> projectKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/screens/{screenId}/tabs/{tabId}/fields");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (projectKey.isPresent()) {
      queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllScreenTabFields);
  }

  /**
   * Move screen tab field
   * Moves a screen tab field.  If `after` and `position` are provided in the request, `position` is ignored.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenId The ID of the screen. (required)
   * @param tabId The ID of the screen tab. (required)
   * @param id The ID of the field. (required)
   * @param moveFieldBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> moveScreenTabField(
    Long screenId, Long tabId, String id, MoveFieldBean moveFieldBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/screens/{screenId}/tabs/{tabId}/fields/{id}/move");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(moveFieldBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_moveScreenTabField);
  }

  /**
   * Remove screen tab field
   * Removes a field from a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param screenId The ID of the screen. (required)
   * @param tabId The ID of the screen tab. (required)
   * @param id The ID of the field. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeScreenTabField(
    Long screenId, Long tabId, String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/screens/{screenId}/tabs/{tabId}/fields/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

}
