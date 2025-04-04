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

import org.everit.atlassian.restclient.jiracloud.v2.model.IdSearchRequestBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.IdSearchResults;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueMatches;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssuePickerSuggestions;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssuesAndJQLQueries;
import org.everit.atlassian.restclient.jiracloud.v2.model.JQLCountRequestBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.JQLCountResultsBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.SearchAndReconcileRequestBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.SearchAndReconcileResults;
import org.everit.atlassian.restclient.jiracloud.v2.model.SearchRequestBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.SearchResults;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueSearchApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<JQLCountResultsBean> returnType_countIssues = new TypeReference<JQLCountResultsBean>() {};

  private static final TypeReference<IssuePickerSuggestions> returnType_getIssuePickerResource = new TypeReference<IssuePickerSuggestions>() {};

  private static final TypeReference<IssueMatches> returnType_matchIssues = new TypeReference<IssueMatches>() {};

  private static final TypeReference<SearchAndReconcileResults> returnType_searchAndReconsileIssuesUsingJql = new TypeReference<SearchAndReconcileResults>() {};

  private static final TypeReference<SearchAndReconcileResults> returnType_searchAndReconsileIssuesUsingJqlPost = new TypeReference<SearchAndReconcileResults>() {};

  private static final TypeReference<IdSearchResults> returnType_searchForIssuesIds = new TypeReference<IdSearchResults>() {};

  private static final TypeReference<SearchResults> returnType_searchForIssuesUsingJql = new TypeReference<SearchResults>() {};

  private static final TypeReference<SearchResults> returnType_searchForIssuesUsingJqlPost = new TypeReference<SearchResults>() {};

  private final RestClient restClient;

  public IssueSearchApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Count issues using JQL
   * Provide an estimated count of the issues that match the [JQL](https://confluence.atlassian.com/x/egORLQ). Recent updates might not be immediately visible in the returned output. This endpoint requires JQL to be bounded.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issues are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param jqLCountRequestBean A JSON object containing the search request. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;JQLCountResultsBean&gt;
   */
  public Single<JQLCountResultsBean> countIssues(
    JQLCountRequestBean jqLCountRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/search/approximate-count");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(jqLCountRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_countIssues);
  }

  /**
   * Get issue picker suggestions
   * Returns lists of issues matching a query string. Use this resource to provide auto-completion suggestions when the user is looking for an issue using a word or string.  This operation returns two lists:   *  `History Search` which includes issues from the user's history of created, edited, or viewed issues that contain the string in the `query` parameter.  *  `Current Search` which includes issues that match the JQL expression in `currentJQL` and contain the string in the `query` parameter.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
   * @param query A string to match against text fields in the issue such as title, description, or comments. (optional)
   * @param currentJQL A JQL query defining a list of issues to search for the query term. Note that `username` and `userkey` cannot be used as search terms for this parameter, due to privacy reasons. Use `accountId` instead. (optional)
   * @param currentIssueKey The key of an issue to exclude from search results. For example, the issue the user is viewing when they perform this query. (optional)
   * @param currentProjectId The ID of a project that suggested issues must belong to. (optional)
   * @param showSubTasks Indicate whether to include subtasks in the suggestions list. (optional)
   * @param showSubTaskParent When `currentIssueKey` is a subtask, whether to include the parent issue in the suggestions if it matches the query. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssuePickerSuggestions&gt;
   */
  public Single<IssuePickerSuggestions> getIssuePickerResource(
    Optional<String> query, Optional<String> currentJQL, Optional<String> currentIssueKey, Optional<String> currentProjectId, Optional<Boolean> showSubTasks, Optional<Boolean> showSubTaskParent, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/picker");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (currentJQL.isPresent()) {
      queryParams.put("currentJQL", Collections.singleton(String.valueOf(currentJQL.get())));
    }
    if (currentIssueKey.isPresent()) {
      queryParams.put("currentIssueKey", Collections.singleton(String.valueOf(currentIssueKey.get())));
    }
    if (currentProjectId.isPresent()) {
      queryParams.put("currentProjectId", Collections.singleton(String.valueOf(currentProjectId.get())));
    }
    if (showSubTasks.isPresent()) {
      queryParams.put("showSubTasks", Collections.singleton(String.valueOf(showSubTasks.get())));
    }
    if (showSubTaskParent.isPresent()) {
      queryParams.put("showSubTaskParent", Collections.singleton(String.valueOf(showSubTaskParent.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssuePickerResource);
  }

  /**
   * Check issues against JQL
   * Checks whether one or more issues would be returned by one or more JQL queries.  **[Permissions](#permissions) required:** None, however, issues are only matched against JQL queries where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param issuesAndJQLQueries  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueMatches&gt;
   */
  public Single<IssueMatches> matchIssues(
    IssuesAndJQLQueries issuesAndJQLQueries, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/jql/match");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issuesAndJQLQueries));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_matchIssues);
  }

  /**
   * Search for issues using JQL enhanced search (GET)
   * Searches for issues using [JQL](https://confluence.atlassian.com/x/egORLQ). Recent updates might not be immediately visible in the returned search results. If you need [read-after-write](https://developer.atlassian.com/cloud/jira/platform/search-and-reconcile/) consistency, you can utilize the `reconcileIssues` parameter to ensure stronger consistency assurances. This operation can be accessed anonymously.  If the JQL query expression is too large to be encoded as a query parameter, use the [POST](#api-rest-api-2-search-post) version of this resource.  **[Permissions](#permissions) required:** Issues are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param jql A [JQL](https://confluence.atlassian.com/x/egORLQ) expression. For performance reasons, this parameter requires a bounded query. A bounded query is a query with a search restriction.   *  Example of an unbounded query: `order by key desc`.  *  Example of a bounded query: `assignee = currentUser() order by key`.  Additionally, `orderBy` clause can contain a maximum of 7 fields. (optional)
   * @param nextPageToken The token for a page to fetch that is not the first page. The first page has a `nextPageToken` of `null`. Use the `nextPageToken` to fetch the next page of issues.  Note: The `nextPageToken` field is **not included** in the response for the last page, indicating there is no next page. (optional)
   * @param maxResults The maximum number of items to return per page. To manage page size, API may return fewer items per page where a large number of fields are requested. The greatest number of items returned per page is achieved when requesting `id` or `key` only. It returns max 5000 issues. (optional, default to 50)
   * @param fields A list of fields to return for each issue, use it to retrieve a subset of fields. This parameter accepts a comma-separated list. Expand options include:   *  `*all` Returns all fields.  *  `*navigable` Returns navigable fields.  *  `id` Returns only issue IDs.  *  Any issue field, prefixed with a minus to exclude.  The default is `id`.  Examples:   *  `summary,comment` Returns only the summary and comments fields only.  *  `-description` Returns all navigable (default) fields except description.  *  `*all,-comment` Returns all fields except comments.  Multiple `fields` parameters can be included in a request.  Note: By default, this resource returns IDs only. This differs from [GET issue](#api-rest-api-2-issue-issueIdOrKey-get) where the default is all fields. (optional, default to new ArrayList&lt;&gt;())
   * @param expand Use [expand](#expansion) to include additional information about issues in the response. Note that, unlike the majority of instances where `expand` is specified, `expand` is defined as a comma-delimited string of values. The expand options are:   *  `renderedFields` Returns field values rendered in HTML format.  *  `names` Returns the display name of each field.  *  `schema` Returns the schema describing a field type.  *  `transitions` Returns all possible transitions for the issue.  *  `operations` Returns all possible operations for the issue.  *  `editmeta` Returns information about how each field can be edited.  *  `changelog` Returns a list of recent updates to an issue, sorted by date, starting from the most recent.  *  `versionedRepresentations` Instead of `fields`, returns `versionedRepresentations` a JSON array containing each version of a field's value, with the highest numbered item representing the most recent version.  Examples: `\"names,changelog\"` Returns the display name of each field as well as a list of recent updates to an issue. (optional)
   * @param properties A list of up to 5 issue properties to include in the results. This parameter accepts a comma-separated list. (optional, default to new ArrayList&lt;&gt;())
   * @param fieldsByKeys Reference fields by their key (rather than ID). The default is `false`. (optional, default to false)
   * @param failFast Fail this request early if we can't retrieve all field data. (optional, default to false)
   * @param reconcileIssues Strong consistency issue ids to be reconciled with search results. Accepts max 50 ids. All issues must exist. (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SearchAndReconcileResults&gt;
   */
  public Single<SearchAndReconcileResults> searchAndReconsileIssuesUsingJql(
    Optional<String> jql, Optional<String> nextPageToken, Optional<Integer> maxResults, Optional<List<String>> fields, Optional<String> expand, Optional<List<String>> properties, Optional<Boolean> fieldsByKeys, Optional<Boolean> failFast, Optional<List<Long>> reconcileIssues, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/search/jql");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (jql.isPresent()) {
      queryParams.put("jql", Collections.singleton(String.valueOf(jql.get())));
    }
    if (nextPageToken.isPresent()) {
      queryParams.put("nextPageToken", Collections.singleton(String.valueOf(nextPageToken.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (fields.isPresent()) {
      queryParams.put("fields", RestClientUtil.objectCollectionToStringCollection(fields.get()));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    if (properties.isPresent()) {
      queryParams.put("properties", RestClientUtil.objectCollectionToStringCollection(properties.get()));
    }
    if (fieldsByKeys.isPresent()) {
      queryParams.put("fieldsByKeys", Collections.singleton(String.valueOf(fieldsByKeys.get())));
    }
    if (failFast.isPresent()) {
      queryParams.put("failFast", Collections.singleton(String.valueOf(failFast.get())));
    }
    if (reconcileIssues.isPresent()) {
      queryParams.put("reconcileIssues", RestClientUtil.objectCollectionToStringCollection(reconcileIssues.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_searchAndReconsileIssuesUsingJql);
  }

  /**
   * Search for issues using JQL enhanced search (POST)
   * Searches for issues using [JQL](https://confluence.atlassian.com/x/egORLQ). Recent updates might not be immediately visible in the returned search results. If you need [read-after-write](https://developer.atlassian.com/cloud/jira/platform/search-and-reconcile/) consistency, you can utilize the `reconcileIssues` parameter to ensure stronger consistency assurances. This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issues are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param searchAndReconcileRequestBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SearchAndReconcileResults&gt;
   */
  public Single<SearchAndReconcileResults> searchAndReconsileIssuesUsingJqlPost(
    SearchAndReconcileRequestBean searchAndReconcileRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/search/jql");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(searchAndReconcileRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_searchAndReconsileIssuesUsingJqlPost);
  }

  /**
   * Search issue IDs using JQL
   * Searches for IDs of issues using [JQL](https://confluence.atlassian.com/x/egORLQ).  Use the [Search](#api-rest-api-2-search-post) endpoint if you need to fetch more than just issue IDs. The Search endpoint returns more information, but may take much longer to respond to requests. This is because it uses a different mechanism for ordering results than this endpoint and doesn't provide the total number of results for your query.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issues are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param idSearchRequestBean A JSON object containing the search request. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IdSearchResults&gt;
   * @deprecated
   */
  @Deprecated
  public Single<IdSearchResults> searchForIssuesIds(
    IdSearchRequestBean idSearchRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/search/id");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(idSearchRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_searchForIssuesIds);
  }

  /**
   * Search for issues using JQL (GET)
   * Searches for issues using [JQL](https://confluence.atlassian.com/x/egORLQ).  If the JQL query expression is too large to be encoded as a query parameter, use the [POST](#api-rest-api-2-search-post) version of this resource.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issues are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param jql The [JQL](https://confluence.atlassian.com/x/egORLQ) that defines the search. Note:   *  If no JQL expression is provided, all issues are returned.  *  `username` and `userkey` cannot be used as search terms due to privacy reasons. Use `accountId` instead.  *  If a user has hidden their email address in their user profile, partial matches of the email address will not find the user. An exact match is required. (optional)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0)
   * @param maxResults The maximum number of items to return per page. To manage page size, Jira may return fewer items per page where a large number of fields are requested. The greatest number of items returned per page is achieved when requesting `id` or `key` only. (optional, default to 50)
   * @param validateQuery Determines how to validate the JQL query and treat the validation results. Supported values are:   *  `strict` Returns a 400 response code if any errors are found, along with a list of all errors (and warnings).  *  `warn` Returns all errors as warnings.  *  `none` No validation is performed.  *  `true` *Deprecated* A legacy synonym for `strict`.  *  `false` *Deprecated* A legacy synonym for `warn`.  Note: If the JQL is not correctly formed a 400 response code is returned, regardless of the `validateQuery` value. (optional, default to strict)
   * @param fields A list of fields to return for each issue, use it to retrieve a subset of fields. This parameter accepts a comma-separated list. Expand options include:   *  `*all` Returns all fields.  *  `*navigable` Returns navigable fields.  *  Any issue field, prefixed with a minus to exclude.  Examples:   *  `summary,comment` Returns only the summary and comments fields.  *  `-description` Returns all navigable (default) fields except description.  *  `*all,-comment` Returns all fields except comments.  This parameter may be specified multiple times. For example, `fields=field1,field2&fields=field3`.  Note: All navigable fields are returned by default. This differs from [GET issue](#api-rest-api-2-issue-issueIdOrKey-get) where the default is all fields. (optional, default to new ArrayList&lt;&gt;())
   * @param expand Use [expand](#expansion) to include additional information about issues in the response. This parameter accepts a comma-separated list. Expand options include:   *  `renderedFields` Returns field values rendered in HTML format.  *  `names` Returns the display name of each field.  *  `schema` Returns the schema describing a field type.  *  `transitions` Returns all possible transitions for the issue.  *  `operations` Returns all possible operations for the issue.  *  `editmeta` Returns information about how each field can be edited.  *  `changelog` Returns a list of recent updates to an issue, sorted by date, starting from the most recent.  *  `versionedRepresentations` Instead of `fields`, returns `versionedRepresentations` a JSON array containing each version of a field's value, with the highest numbered item representing the most recent version. (optional)
   * @param properties A list of issue property keys for issue properties to include in the results. This parameter accepts a comma-separated list. Multiple properties can also be provided using an ampersand separated list. For example, `properties=prop1,prop2&properties=prop3`. A maximum of 5 issue property keys can be specified. (optional, default to new ArrayList&lt;&gt;())
   * @param fieldsByKeys Reference fields by their key (rather than ID). (optional, default to false)
   * @param failFast Whether to fail the request quickly in case of an error while loading fields for an issue. For `failFast=true`, if one field fails, the entire operation fails. For `failFast=false`, the operation will continue even if a field fails. It will return a valid response, but without values for the failed field(s). (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SearchResults&gt;
   * @deprecated
   */
  @Deprecated
  public Single<SearchResults> searchForIssuesUsingJql(
    Optional<String> jql, Optional<Integer> startAt, Optional<Integer> maxResults, Optional<String> validateQuery, Optional<List<String>> fields, Optional<String> expand, Optional<List<String>> properties, Optional<Boolean> fieldsByKeys, Optional<Boolean> failFast, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (jql.isPresent()) {
      queryParams.put("jql", Collections.singleton(String.valueOf(jql.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (validateQuery.isPresent()) {
      queryParams.put("validateQuery", Collections.singleton(String.valueOf(validateQuery.get())));
    }
    if (fields.isPresent()) {
      queryParams.put("fields", RestClientUtil.objectCollectionToStringCollection(fields.get()));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    if (properties.isPresent()) {
      queryParams.put("properties", RestClientUtil.objectCollectionToStringCollection(properties.get()));
    }
    if (fieldsByKeys.isPresent()) {
      queryParams.put("fieldsByKeys", Collections.singleton(String.valueOf(fieldsByKeys.get())));
    }
    if (failFast.isPresent()) {
      queryParams.put("failFast", Collections.singleton(String.valueOf(failFast.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_searchForIssuesUsingJql);
  }

  /**
   * Search for issues using JQL (POST)
   * Searches for issues using [JQL](https://confluence.atlassian.com/x/egORLQ).  There is a [GET](#api-rest-api-2-search-get) version of this resource that can be used for smaller JQL query expressions.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issues are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param searchRequestBean A JSON object containing the search request. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SearchResults&gt;
   * @deprecated
   */
  @Deprecated
  public Single<SearchResults> searchForIssuesUsingJqlPost(
    SearchRequestBean searchRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(searchRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_searchForIssuesUsingJqlPost);
  }

}
