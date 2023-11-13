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
import org.everit.atlassian.restclient.jiracloud.v3.model.NotificationScheme;
import org.everit.atlassian.restclient.jiracloud.v3.model.NotificationSchemeId;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanNotificationScheme;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanNotificationSchemeAndProjectMappingJsonBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueNotificationSchemesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_addNotifications = new TypeReference<Object>() {};

  private static final TypeReference<NotificationSchemeId> returnType_createNotificationScheme = new TypeReference<NotificationSchemeId>() {};

  private static final TypeReference<Object> returnType_deleteNotificationScheme = new TypeReference<Object>() {};

  private static final TypeReference<NotificationScheme> returnType_getNotificationScheme = new TypeReference<NotificationScheme>() {};

  private static final TypeReference<PageBeanNotificationSchemeAndProjectMappingJsonBean> returnType_getNotificationSchemeToProjectMappings = new TypeReference<PageBeanNotificationSchemeAndProjectMappingJsonBean>() {};

  private static final TypeReference<PageBeanNotificationScheme> returnType_getNotificationSchemes = new TypeReference<PageBeanNotificationScheme>() {};

  private static final TypeReference<Object> returnType_removeNotificationFromNotificationScheme = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateNotificationScheme = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueNotificationSchemesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add notifications to notification scheme
   * Adds notifications to a notification scheme. You can add up to 1000 notifications per request.  *Deprecated: The notification type `EmailAddress` is no longer supported in Cloud. Refer to the [changelog](https://developer.atlassian.com/cloud/jira/platform/changelog/#CHANGE-1031) for more details.*  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the notification scheme. (required)
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> addNotifications(
    String id, Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/notificationscheme/{id}/notification");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addNotifications);
  }

  /**
   * Create notification scheme
   * Creates a notification scheme with notifications. You can create up to 1000 notifications per request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;NotificationSchemeId&gt;
   */
  public Single<NotificationSchemeId> createNotificationScheme(
    Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/notificationscheme");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createNotificationScheme);
  }

  /**
   * Delete notification scheme
   * Deletes a notification scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param notificationSchemeId The ID of the notification scheme. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteNotificationScheme(
    String notificationSchemeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/notificationscheme/{notificationSchemeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("notificationSchemeId", String.valueOf(notificationSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteNotificationScheme);
  }

  /**
   * Get notification scheme
   * Returns a [notification scheme](https://confluence.atlassian.com/x/8YdKLg), including the list of events and the recipients who will receive notifications for those events.  **[Permissions](#permissions) required:** Permission to access Jira, however, the user must have permission to administer at least one project associated with the notification scheme.
   * @param id The ID of the notification scheme. Use [Get notification schemes paginated](#api-rest-api-3-notificationscheme-get) to get a list of notification scheme IDs. (required)
   * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `all` Returns all expandable information  *  `field` Returns information about any custom fields assigned to receive an event  *  `group` Returns information about any groups assigned to receive an event  *  `notificationSchemeEvents` Returns a list of event associations. This list is returned for all expandable information  *  `projectRole` Returns information about any project roles assigned to receive an event  *  `user` Returns information about any users assigned to receive an event (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;NotificationScheme&gt;
   */
  public Single<NotificationScheme> getNotificationScheme(
    Long id, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/notificationscheme/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getNotificationScheme);
  }

  /**
   * Get projects using notification schemes paginated
   * Returns a [paginated](#pagination) mapping of project that have notification scheme assigned. You can provide either one or multiple notification scheme IDs or project IDs to filter by. If you don't provide any, this will return a list of all mappings. Note that only company-managed (classic) projects are supported. This is because team-managed projects don't have a concept of a default notification scheme. The mappings are ordered by projectId.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param notificationSchemeId The list of notifications scheme IDs to be filtered out (optional, default to new ArrayList&lt;&gt;())
   * @param projectId The list of project IDs to be filtered out (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanNotificationSchemeAndProjectMappingJsonBean&gt;
   */
  public Single<PageBeanNotificationSchemeAndProjectMappingJsonBean> getNotificationSchemeToProjectMappings(
    Optional<String> startAt, Optional<String> maxResults, Optional<List<String>> notificationSchemeId, Optional<List<String>> projectId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/notificationscheme/project");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (notificationSchemeId.isPresent()) {
      queryParams.put("notificationSchemeId", RestClientUtil.objectCollectionToStringCollection(notificationSchemeId.get()));
    }
    if (projectId.isPresent()) {
      queryParams.put("projectId", RestClientUtil.objectCollectionToStringCollection(projectId.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getNotificationSchemeToProjectMappings);
  }

  /**
   * Get notification schemes paginated
   * Returns a [paginated](#pagination) list of [notification schemes](https://confluence.atlassian.com/x/8YdKLg) ordered by the display name.  *Note that you should allow for events without recipients to appear in responses.*  **[Permissions](#permissions) required:** Permission to access Jira, however, the user must have permission to administer at least one project associated with a notification scheme for it to be returned.
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param id The list of notification schemes IDs to be filtered by (optional, default to new ArrayList&lt;&gt;())
   * @param projectId The list of projects IDs to be filtered by (optional, default to new ArrayList&lt;&gt;())
   * @param onlyDefault When set to true, returns only the default notification scheme. If you provide project IDs not associated with the default, returns an empty page. The default value is false. (optional, default to false)
   * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `all` Returns all expandable information  *  `field` Returns information about any custom fields assigned to receive an event  *  `group` Returns information about any groups assigned to receive an event  *  `notificationSchemeEvents` Returns a list of event associations. This list is returned for all expandable information  *  `projectRole` Returns information about any project roles assigned to receive an event  *  `user` Returns information about any users assigned to receive an event (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanNotificationScheme&gt;
   */
  public Single<PageBeanNotificationScheme> getNotificationSchemes(
    Optional<String> startAt, Optional<String> maxResults, Optional<List<String>> id, Optional<List<String>> projectId, Optional<Boolean> onlyDefault, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/notificationscheme");

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
    if (onlyDefault.isPresent()) {
      queryParams.put("onlyDefault", Collections.singleton(String.valueOf(onlyDefault.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getNotificationSchemes);
  }

  /**
   * Remove notification from notification scheme
   * Removes a notification from a notification scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param notificationSchemeId The ID of the notification scheme. (required)
   * @param notificationId The ID of the notification. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> removeNotificationFromNotificationScheme(
    String notificationSchemeId, String notificationId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/notificationscheme/{notificationSchemeId}/notification/{notificationId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("notificationSchemeId", String.valueOf(notificationSchemeId));
    pathParams.put("notificationId", String.valueOf(notificationId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeNotificationFromNotificationScheme);
  }

  /**
   * Update notification scheme
   * Updates a notification scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the notification scheme. (required)
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateNotificationScheme(
    String id, Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/notificationscheme/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateNotificationScheme);
  }

}
