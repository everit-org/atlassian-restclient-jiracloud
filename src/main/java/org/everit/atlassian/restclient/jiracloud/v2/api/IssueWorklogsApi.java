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

import org.everit.atlassian.restclient.jiracloud.v2.model.ChangedWorklogs;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageOfWorklogs;
import org.everit.atlassian.restclient.jiracloud.v2.model.Worklog;
import org.everit.atlassian.restclient.jiracloud.v2.model.WorklogIdsRequestBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueWorklogsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Worklog> returnType_addWorklog = new TypeReference<Worklog>() {};

  private static final TypeReference<ChangedWorklogs> returnType_getIdsOfWorklogsDeletedSince = new TypeReference<ChangedWorklogs>() {};

  private static final TypeReference<ChangedWorklogs> returnType_getIdsOfWorklogsModifiedSince = new TypeReference<ChangedWorklogs>() {};

  private static final TypeReference<PageOfWorklogs> returnType_getIssueWorklog = new TypeReference<PageOfWorklogs>() {};

  private static final TypeReference<Worklog> returnType_getWorklog = new TypeReference<Worklog>() {};

  private static final TypeReference<List<Worklog>> returnType_getWorklogsForIds = new TypeReference<List<Worklog>>() {};

  private static final TypeReference<Worklog> returnType_updateWorklog = new TypeReference<Worklog>() {};

  private final RestClient restClient;

  public IssueWorklogsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add worklog
   * Adds a worklog to an issue.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Work on issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param issueIdOrKey The ID or key the issue. (required)
   * @param requestBody  (required)
   * @param notifyUsers Whether users watching the issue are notified by email. (optional, default to true)
   * @param adjustEstimate Defines how to update the issue's time estimate, the options are:   *  `new` Sets the estimate to a specific value, defined in `newEstimate`.  *  `leave` Leaves the estimate unchanged.  *  `manual` Reduces the estimate by amount specified in `reduceBy`.  *  `auto` Reduces the estimate by the value of `timeSpent` in the worklog. (optional, default to auto)
   * @param newEstimate The value to set as the issue's remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when `adjustEstimate` is `new`. (optional)
   * @param reduceBy The amount to reduce the issue's remaining estimate by, as days (\\#d), hours (\\#h), or minutes (\\#m). For example, *2d*. Required when `adjustEstimate` is `manual`. (optional)
   * @param expand Use [expand](#expansion) to include additional information about work logs in the response. This parameter accepts `properties`, which returns worklog properties. (optional, default to &quot;&quot;)
   * @param overrideEditableFlag Whether the worklog entry should be added to the issue even if the issue is not editable, because jira.issue.editable set to false or missing. For example, the issue is closed. Connect and Forge app users with *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) can use this flag. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Worklog&gt;
   */
  public Single<Worklog> addWorklog(
    String issueIdOrKey, Map<String, Object> requestBody, Optional<Boolean> notifyUsers, Optional<String> adjustEstimate, Optional<String> newEstimate, Optional<String> reduceBy, Optional<String> expand, Optional<Boolean> overrideEditableFlag, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/worklog");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (notifyUsers.isPresent()) {
      queryParams.put("notifyUsers", Collections.singleton(String.valueOf(notifyUsers.get())));
    }
    if (adjustEstimate.isPresent()) {
      queryParams.put("adjustEstimate", Collections.singleton(String.valueOf(adjustEstimate.get())));
    }
    if (newEstimate.isPresent()) {
      queryParams.put("newEstimate", Collections.singleton(String.valueOf(newEstimate.get())));
    }
    if (reduceBy.isPresent()) {
      queryParams.put("reduceBy", Collections.singleton(String.valueOf(reduceBy.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    if (overrideEditableFlag.isPresent()) {
      queryParams.put("overrideEditableFlag", Collections.singleton(String.valueOf(overrideEditableFlag.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addWorklog);
  }

  /**
   * Delete worklog
   * Deletes a worklog from an issue.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Delete all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to delete any worklog or *Delete own worklogs* to delete worklogs created by the user,  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
   * @param issueIdOrKey The ID or key of the issue. (required)
   * @param id The ID of the worklog. (required)
   * @param notifyUsers Whether users watching the issue are notified by email. (optional, default to true)
   * @param adjustEstimate Defines how to update the issue's time estimate, the options are:   *  `new` Sets the estimate to a specific value, defined in `newEstimate`.  *  `leave` Leaves the estimate unchanged.  *  `manual` Increases the estimate by amount specified in `increaseBy`.  *  `auto` Reduces the estimate by the value of `timeSpent` in the worklog. (optional, default to auto)
   * @param newEstimate The value to set as the issue's remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when `adjustEstimate` is `new`. (optional)
   * @param increaseBy The amount to increase the issue's remaining estimate by, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when `adjustEstimate` is `manual`. (optional)
   * @param overrideEditableFlag Whether the work log entry should be added to the issue even if the issue is not editable, because jira.issue.editable set to false or missing. For example, the issue is closed. Connect and Forge app users with admin permission can use this flag. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteWorklog(
    String issueIdOrKey, String id, Optional<Boolean> notifyUsers, Optional<String> adjustEstimate, Optional<String> newEstimate, Optional<String> increaseBy, Optional<Boolean> overrideEditableFlag, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/worklog/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (notifyUsers.isPresent()) {
      queryParams.put("notifyUsers", Collections.singleton(String.valueOf(notifyUsers.get())));
    }
    if (adjustEstimate.isPresent()) {
      queryParams.put("adjustEstimate", Collections.singleton(String.valueOf(adjustEstimate.get())));
    }
    if (newEstimate.isPresent()) {
      queryParams.put("newEstimate", Collections.singleton(String.valueOf(newEstimate.get())));
    }
    if (increaseBy.isPresent()) {
      queryParams.put("increaseBy", Collections.singleton(String.valueOf(increaseBy.get())));
    }
    if (overrideEditableFlag.isPresent()) {
      queryParams.put("overrideEditableFlag", Collections.singleton(String.valueOf(overrideEditableFlag.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get IDs of deleted worklogs
   * Returns a list of IDs and delete timestamps for worklogs deleted after a date and time.  This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, `until` indicates the timestamp of the youngest item on the page. Also, `nextPage` provides the URL for the next page of worklogs. The `lastPage` parameter is set to true on the last page of worklogs.  This resource does not return worklogs deleted during the minute preceding the request.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param since The date and time, as a UNIX timestamp in milliseconds, after which deleted worklogs are returned. (optional, default to 0l)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ChangedWorklogs&gt;
   */
  public Single<ChangedWorklogs> getIdsOfWorklogsDeletedSince(
    Optional<Long> since, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/worklog/deleted");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (since.isPresent()) {
      queryParams.put("since", Collections.singleton(String.valueOf(since.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIdsOfWorklogsDeletedSince);
  }

  /**
   * Get IDs of updated worklogs
   * Returns a list of IDs and update timestamps for worklogs updated after a date and time.  This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, `until` indicates the timestamp of the youngest item on the page. Also, `nextPage` provides the URL for the next page of worklogs. The `lastPage` parameter is set to true on the last page of worklogs.  This resource does not return worklogs updated during the minute preceding the request.  **[Permissions](#permissions) required:** Permission to access Jira, however, worklogs are only returned where either of the following is true:   *  the worklog is set as *Viewable by All Users*.  *  the user is a member of a project role or group with permission to view the worklog.
   * @param since The date and time, as a UNIX timestamp in milliseconds, after which updated worklogs are returned. (optional, default to 0l)
   * @param expand Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts `properties` that returns the properties of each worklog. (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ChangedWorklogs&gt;
   */
  public Single<ChangedWorklogs> getIdsOfWorklogsModifiedSince(
    Optional<Long> since, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/worklog/updated");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (since.isPresent()) {
      queryParams.put("since", Collections.singleton(String.valueOf(since.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIdsOfWorklogsModifiedSince);
  }

  /**
   * Get issue worklogs
   * Returns worklogs for an issue, starting from the oldest worklog or from the worklog started on or after a date and time.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Workloads are only returned where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
   * @param issueIdOrKey The ID or key of the issue. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 5000)
   * @param startedAfter The worklog start date and time, as a UNIX timestamp in milliseconds, after which worklogs are returned. (optional)
   * @param startedBefore The worklog start date and time, as a UNIX timestamp in milliseconds, before which worklogs are returned. (optional)
   * @param expand Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts`properties`, which returns worklog properties. (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageOfWorklogs&gt;
   */
  public Single<PageOfWorklogs> getIssueWorklog(
    String issueIdOrKey, Optional<Long> startAt, Optional<Integer> maxResults, Optional<Long> startedAfter, Optional<Long> startedBefore, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/worklog");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (startedAfter.isPresent()) {
      queryParams.put("startedAfter", Collections.singleton(String.valueOf(startedAfter.get())));
    }
    if (startedBefore.isPresent()) {
      queryParams.put("startedBefore", Collections.singleton(String.valueOf(startedBefore.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssueWorklog);
  }

  /**
   * Get worklog
   * Returns a worklog.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
   * @param issueIdOrKey The ID or key of the issue. (required)
   * @param id The ID of the worklog. (required)
   * @param expand Use [expand](#expansion) to include additional information about work logs in the response. This parameter accepts  `properties`, which returns worklog properties. (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Worklog&gt;
   */
  public Single<Worklog> getWorklog(
    String issueIdOrKey, String id, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/worklog/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getWorklog);
  }

  /**
   * Get worklogs
   * Returns worklog details for a list of worklog IDs.  The returned list of worklogs is limited to 1000 items.  **[Permissions](#permissions) required:** Permission to access Jira, however, worklogs are only returned where either of the following is true:   *  the worklog is set as *Viewable by All Users*.  *  the user is a member of a project role or group with permission to view the worklog.
   * @param worklogIdsRequestBean A JSON object containing a list of worklog IDs. (required)
   * @param expand Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts `properties` that returns the properties of each worklog. (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Worklog&gt;&gt;
   */
  public Single<List<Worklog>> getWorklogsForIds(
    WorklogIdsRequestBean worklogIdsRequestBean, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/worklog/list");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(worklogIdsRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getWorklogsForIds);
  }

  /**
   * Update worklog
   * Updates a worklog.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to update any worklog or *Edit own worklogs* to update worklogs created by the user.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
   * @param issueIdOrKey The ID or key the issue. (required)
   * @param id The ID of the worklog. (required)
   * @param requestBody  (required)
   * @param notifyUsers Whether users watching the issue are notified by email. (optional, default to true)
   * @param adjustEstimate Defines how to update the issue's time estimate, the options are:   *  `new` Sets the estimate to a specific value, defined in `newEstimate`.  *  `leave` Leaves the estimate unchanged.  *  `auto` Updates the estimate by the difference between the original and updated value of `timeSpent` or `timeSpentSeconds`. (optional, default to auto)
   * @param newEstimate The value to set as the issue's remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when `adjustEstimate` is `new`. (optional)
   * @param expand Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts `properties`, which returns worklog properties. (optional, default to &quot;&quot;)
   * @param overrideEditableFlag Whether the worklog should be added to the issue even if the issue is not editable. For example, because the issue is closed. Connect and Forge app users with *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) can use this flag. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Worklog&gt;
   */
  public Single<Worklog> updateWorklog(
    String issueIdOrKey, String id, Map<String, Object> requestBody, Optional<Boolean> notifyUsers, Optional<String> adjustEstimate, Optional<String> newEstimate, Optional<String> expand, Optional<Boolean> overrideEditableFlag, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/worklog/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (notifyUsers.isPresent()) {
      queryParams.put("notifyUsers", Collections.singleton(String.valueOf(notifyUsers.get())));
    }
    if (adjustEstimate.isPresent()) {
      queryParams.put("adjustEstimate", Collections.singleton(String.valueOf(adjustEstimate.get())));
    }
    if (newEstimate.isPresent()) {
      queryParams.put("newEstimate", Collections.singleton(String.valueOf(newEstimate.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    if (overrideEditableFlag.isPresent()) {
      queryParams.put("overrideEditableFlag", Collections.singleton(String.valueOf(overrideEditableFlag.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateWorklog);
  }

}
