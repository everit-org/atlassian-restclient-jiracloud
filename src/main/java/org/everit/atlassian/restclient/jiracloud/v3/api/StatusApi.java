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

import org.everit.atlassian.restclient.jiracloud.v3.model.JiraStatus;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageOfStatuses;
import org.everit.atlassian.restclient.jiracloud.v3.model.StatusCreateRequest;
import org.everit.atlassian.restclient.jiracloud.v3.model.StatusProjectIssueTypeUsageDTO;
import org.everit.atlassian.restclient.jiracloud.v3.model.StatusProjectUsageDTO;
import org.everit.atlassian.restclient.jiracloud.v3.model.StatusUpdateRequest;
import org.everit.atlassian.restclient.jiracloud.v3.model.StatusWorkflowUsageDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<List<JiraStatus>> returnType_createStatuses = new TypeReference<List<JiraStatus>>() {};

  private static final TypeReference<Object> returnType_deleteStatusesById = new TypeReference<Object>() {};

  private static final TypeReference<StatusProjectIssueTypeUsageDTO> returnType_getProjectIssueTypeUsagesForStatus = new TypeReference<StatusProjectIssueTypeUsageDTO>() {};

  private static final TypeReference<StatusProjectUsageDTO> returnType_getProjectUsagesForStatus = new TypeReference<StatusProjectUsageDTO>() {};

  private static final TypeReference<List<JiraStatus>> returnType_getStatusesById = new TypeReference<List<JiraStatus>>() {};

  private static final TypeReference<StatusWorkflowUsageDTO> returnType_getWorkflowUsagesForStatus = new TypeReference<StatusWorkflowUsageDTO>() {};

  private static final TypeReference<PageOfStatuses> returnType_search = new TypeReference<PageOfStatuses>() {};

  private static final TypeReference<Object> returnType_updateStatuses = new TypeReference<Object>() {};

  private final RestClient restClient;

  public StatusApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Bulk create statuses
   * Creates statuses for a global or project scope.  **[Permissions](#permissions) required:**   *  *Administer projects* [project permission.](https://confluence.atlassian.com/x/yodKLg)  *  *Administer Jira* [project permission.](https://confluence.atlassian.com/x/yodKLg)
   * @param statusCreateRequest Details of the statuses being created and their scope. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;JiraStatus&gt;&gt;
   */
  public Single<List<JiraStatus>> createStatuses(
    StatusCreateRequest statusCreateRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/statuses");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(statusCreateRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createStatuses);
  }

  /**
   * Bulk delete Statuses
   * Deletes statuses by ID.  **[Permissions](#permissions) required:**   *  *Administer projects* [project permission.](https://confluence.atlassian.com/x/yodKLg)  *  *Administer Jira* [project permission.](https://confluence.atlassian.com/x/yodKLg)
   * @param id The list of status IDs. To include multiple IDs, provide an ampersand-separated list. For example, id=10000&id=10001.  Min items `1`, Max items `50` (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteStatusesById(
    List<String> id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/statuses");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("id", RestClientUtil.objectCollectionToStringCollection(id));
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteStatusesById);
  }

  /**
   * Get issue type usages by status and project
   * Returns a page of issue types in a project using a given status.
   * @param statusId The statusId to fetch issue type usages for (required)
   * @param projectId The projectId to fetch issue type usages for (required)
   * @param nextPageToken The cursor for pagination (optional)
   * @param maxResults The maximum number of results to return. Must be an integer between 1 and 200. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;StatusProjectIssueTypeUsageDTO&gt;
   */
  public Single<StatusProjectIssueTypeUsageDTO> getProjectIssueTypeUsagesForStatus(
    String statusId, String projectId, Optional<String> nextPageToken, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/statuses/{statusId}/project/{projectId}/issueTypeUsages");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("statusId", String.valueOf(statusId));
    pathParams.put("projectId", String.valueOf(projectId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (nextPageToken.isPresent()) {
      queryParams.put("nextPageToken", Collections.singleton(String.valueOf(nextPageToken.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getProjectIssueTypeUsagesForStatus);
  }

  /**
   * Get project usages by status
   * Returns a page of projects using a given status.
   * @param statusId The statusId to fetch project usages for (required)
   * @param nextPageToken The cursor for pagination (optional)
   * @param maxResults The maximum number of results to return. Must be an integer between 1 and 200. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;StatusProjectUsageDTO&gt;
   */
  public Single<StatusProjectUsageDTO> getProjectUsagesForStatus(
    String statusId, Optional<String> nextPageToken, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/statuses/{statusId}/projectUsages");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("statusId", String.valueOf(statusId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (nextPageToken.isPresent()) {
      queryParams.put("nextPageToken", Collections.singleton(String.valueOf(nextPageToken.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getProjectUsagesForStatus);
  }

  /**
   * Bulk get statuses
   * Returns a list of the statuses specified by one or more status IDs.  **[Permissions](#permissions) required:**   *  *Administer projects* [project permission.](https://confluence.atlassian.com/x/yodKLg)  *  *Administer Jira* [project permission.](https://confluence.atlassian.com/x/yodKLg)
   * @param id The list of status IDs. To include multiple IDs, provide an ampersand-separated list. For example, id=10000&id=10001.  Min items `1`, Max items `50` (required)
   * @param expand Deprecated. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/changelog/#CHANGE-2298) for details.  Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `usages` Returns the project and issue types that use the status in their workflow.  *  `workflowUsages` Returns the workflows that use the status. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;JiraStatus&gt;&gt;
   */
  public Single<List<JiraStatus>> getStatusesById(
    List<String> id, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/statuses");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    queryParams.put("id", RestClientUtil.objectCollectionToStringCollection(id));
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getStatusesById);
  }

  /**
   * Get workflow usages by status
   * Returns a page of workflows using a given status.
   * @param statusId The statusId to fetch workflow usages for (required)
   * @param nextPageToken The cursor for pagination (optional)
   * @param maxResults The maximum number of results to return. Must be an integer between 1 and 200. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;StatusWorkflowUsageDTO&gt;
   */
  public Single<StatusWorkflowUsageDTO> getWorkflowUsagesForStatus(
    String statusId, Optional<String> nextPageToken, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/statuses/{statusId}/workflowUsages");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("statusId", String.valueOf(statusId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (nextPageToken.isPresent()) {
      queryParams.put("nextPageToken", Collections.singleton(String.valueOf(nextPageToken.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getWorkflowUsagesForStatus);
  }

  /**
   * Search statuses paginated
   * Returns a [paginated](https://developer.atlassian.com/cloud/jira/platform/rest/v3/intro/#pagination) list of statuses that match a search on name or project.  **[Permissions](#permissions) required:**   *  *Administer projects* [project permission.](https://confluence.atlassian.com/x/yodKLg)  *  *Administer Jira* [project permission.](https://confluence.atlassian.com/x/yodKLg)
   * @param expand Deprecated. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/changelog/#CHANGE-2298) for details.  Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `usages` Returns the project and issue types that use the status in their workflow.  *  `workflowUsages` Returns the workflows that use the status. (optional)
   * @param projectId The project the status is part of or null for global statuses. (optional)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 200)
   * @param searchString Term to match status names against or null to search for all statuses in the search scope. (optional)
   * @param statusCategory Category of the status to filter by. The supported values are: `TODO`, `IN_PROGRESS`, and `DONE`. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageOfStatuses&gt;
   */
  public Single<PageOfStatuses> search(
    Optional<String> expand, Optional<String> projectId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<String> searchString, Optional<String> statusCategory, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/statuses/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    if (projectId.isPresent()) {
      queryParams.put("projectId", Collections.singleton(String.valueOf(projectId.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (searchString.isPresent()) {
      queryParams.put("searchString", Collections.singleton(String.valueOf(searchString.get())));
    }
    if (statusCategory.isPresent()) {
      queryParams.put("statusCategory", Collections.singleton(String.valueOf(statusCategory.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_search);
  }

  /**
   * Bulk update statuses
   * Updates statuses by ID.  **[Permissions](#permissions) required:**   *  *Administer projects* [project permission.](https://confluence.atlassian.com/x/yodKLg)  *  *Administer Jira* [project permission.](https://confluence.atlassian.com/x/yodKLg)
   * @param statusUpdateRequest The list of statuses that will be updated. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateStatuses(
    StatusUpdateRequest statusUpdateRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/statuses");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(statusUpdateRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateStatuses);
  }

}
