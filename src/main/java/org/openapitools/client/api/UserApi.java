package org.openapitools.client.api;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.atlassian.restclient.common.RestCallUtil;
import org.everit.atlassian.restclient.common.RestRequest;
import org.everit.atlassian.restclient.common.RestRequestEnhancer;

import org.everit.http.client.HttpClient;
import org.everit.http.client.HttpMethod;
import org.everit.http.client.HttpRequest;

import org.openapitools.client.model.ColumnItem;
import org.openapitools.client.model.FoundUsers;
import org.openapitools.client.model.GroupName;
import org.openapitools.client.model.User;
import org.openapitools.client.model.UserWriteBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<User> returnType_createUser = new TypeReference<User>() {};

  private static final TypeReference<List<User>> returnType_findAssignableUsers = new TypeReference<List<User>>() {};

  private static final TypeReference<List<User>> returnType_findBulkAssignableUsers = new TypeReference<List<User>>() {};

  private static final TypeReference<List<User>> returnType_findUsers = new TypeReference<List<User>>() {};

  private static final TypeReference<FoundUsers> returnType_findUsersForPicker = new TypeReference<FoundUsers>() {};

  private static final TypeReference<List<User>> returnType_findUsersWithAllPermissions = new TypeReference<List<User>>() {};

  private static final TypeReference<List<User>> returnType_findUsersWithBrowsePermission = new TypeReference<List<User>>() {};

  private static final TypeReference<User> returnType_getUser = new TypeReference<User>() {};

  private static final TypeReference<List<ColumnItem>> returnType_getUserDefaultColumns = new TypeReference<List<ColumnItem>>() {};

  private static final TypeReference<List<GroupName>> returnType_getUserGroups = new TypeReference<List<GroupName>>() {};

  private static final TypeReference<Object> returnType_setUserColumns = new TypeReference<Object>() {};

  private final HttpClient httpClient;

  public UserApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Create user
   * <p>Creates a user. This resource is retained for legacy compatibility. As soon as a more suitable alternative is available this resource will be deprecated.</p> <p>The option is provided to set or generate a password for the user. When using the option to generate a password, by omitting <code>password</code> from the request, include <code>&quot;notification&quot;: &quot;true&quot;</code> to ensure the user is sent an email advising them that their account is created. This email includes a link for the user to set their password. If the notification isn't sent for a generated password, the user will need to be sent a reset password request from Jira.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;User&gt;
   */
  public Single<User> createUser(
    UserWriteBean requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_createUser);
  }

  /**
   * Find users assignable to issues
   * <p>Returns a list of users that can be assigned to an issue. Use this operation to find the list of users who can be assigned to:</p> <ul> <li>a new issue, by providing the <code>projectKeyOrId</code>.</li> <li>an updated issue, by providing the <code>issueKey</code>.</li> <li>to an issue during a transition (workflow action), by providing the <code>issueKey</code> and the transition id in <code>actionDescriptorId</code>. You can obtain the IDs of an issue's valid transitions using the <code>transitions</code> option in the <code>expand</code> parameter of <a href=\"#api-rest-api-3-issue-issueIdOrKey-get\"> Get issue</a>.</li> </ul> <p>In all these cases, you can pass an accountId to determine if a user can be assigned to an issue. The user is returned in the response if they can be assigned to the issue or issue transition.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param query <p>A query string that is matched against user attributes, such as <code>displayName</code>, and <code>emailAddress</code>, to find relevant users. The string can match the prefix of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>johnson@example.com</em>. Required, unless <code>username</code> or <code>accountId</code> is specified.</p>  (optional)
   * @param sessionId <p>The sessionId of this request. SessionId is the same until the assignee is set.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param accountId <p>A query string that is matched against user accountId. The string must match the accountId exactly. Required, unless <code>query</code> is specified.</p>  (optional)
   * @param project <p>The project ID or project key (case sensitive). Required, unless <code>issueKey</code> is specified.</p>  (optional)
   * @param issueKey <p>The key of the issue. Required, unless <code>project</code> is specified.</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param actionDescriptorId <p>The ID of the transition.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> findAssignableUsers(
    Optional<String> query, Optional<String> sessionId, Optional<String> username, Optional<String> accountId, Optional<String> project, Optional<String> issueKey, Optional<Integer> startAt, Optional<Integer> maxResults, Optional<Integer> actionDescriptorId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/assignable/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (sessionId.isPresent()) {
      queryParams.put("sessionId", Collections.singleton(String.valueOf(sessionId.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (project.isPresent()) {
      queryParams.put("project", Collections.singleton(String.valueOf(project.get())));
    }
    if (issueKey.isPresent()) {
      queryParams.put("issueKey", Collections.singleton(String.valueOf(issueKey.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (actionDescriptorId.isPresent()) {
      queryParams.put("actionDescriptorId", Collections.singleton(String.valueOf(actionDescriptorId.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_findAssignableUsers);
  }

  /**
   * Find users assignable to projects
   * <p>Returns a list of users who can be assigned issues in one or more projects. The list may be restricted to users whose attributes match a string.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param query <p>A query string that is matched against user attributes, such as <code>displayName</code> and <code>emailAddress</code>, to find relevant users. The string can match the prefix of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>johnson@example.com</em>. Required, unless <code>accountId</code> is specified.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param accountId <p>A query string that is matched against user accountId. The string must match the accountId exactly. Required, unless <code>query</code> is specified.</p>  (optional)
   * @param projectKeys <p>A comma-separated list of project keys (case sensitive).</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> findBulkAssignableUsers(
    Optional<String> query, Optional<String> username, Optional<String> accountId, Optional<String> projectKeys, Optional<Integer> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/assignable/multiProjectSearch");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (projectKeys.isPresent()) {
      queryParams.put("projectKeys", Collections.singleton(String.valueOf(projectKeys.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_findBulkAssignableUsers);
  }

  /**
   * Find users
   * <p>Returns a list of users that match the provided search string and property.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Anonymous calls or calls by users without the required permission return empty search results.</p> <p><strong>Note:</strong> This API is designed to return a small number of users with a flexible search query. As such, the sum of <code>startAt</code> and <code>maxResults</code> must be less than 1000. If the sum is greater, only results up to the 1000th result will be returned. If you wish to get a larger number of users, please use the get-all-users API (<code>/rest/api/3/users/search</code>) instead.</p> 
   * @param query <p>A query string that is matched against user attributes ( <code>displayName</code>, and <code>emailAddress</code>) to find relevant users. The string can match the prefix of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>johnson@example.com</em>. Required, unless <code>accountId</code> or <code>property</code> is specified.</p>  (optional)
   * @param username  (optional)
   * @param accountId <p>A query string that is matched against a user accountId. The string must match the accountId exactly. Required, unless <code>query</code> or <code>property</code> is specified.</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param property <p>A query string used to search properties. Property keys are specified by path, so property keys containing dot (.) or equals (=) characters cannot be used. The query string cannot be specified using a JSON object. Example: To search for the value of <code>nested</code> from <code>{&quot;something&quot;:{&quot;nested&quot;:1,&quot;other&quot;:2}}</code> use <code>thepropertykey.something.nested=1</code>. Required, unless <code>accountId</code> or <code>query</code> are specified.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> findUsers(
    Optional<String> query, Optional<String> username, Optional<String> accountId, Optional<Integer> startAt, Optional<Integer> maxResults, Optional<String> property, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (property.isPresent()) {
      queryParams.put("property", Collections.singleton(String.valueOf(property.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_findUsers);
  }

  /**
   * Find users for picker
   * <p>Returns a list of users whose attributes match the query term. The returned object includes the <code>html</code> field where the matched query term is highlighted with the HTML strong tag. A list of account IDs can be provided to exclude users from the results.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Anonymous calls and calls by users without the required permission return search results for an exact name match only.</p> 
   * @param query <p>A query string that is matched against user attributes, such as <code>displayName</code>, and <code>emailAddress</code>, to find relevant users. The string can match the prefix of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>johnson@example.com</em>.</p>  (optional)
   * @param maxResults <p>The maximum number of items to return. The maximum is <code>1000</code>. The total number of matched users is returned in <code>total</code>.</p>  (optional, default to 50)
   * @param showAvatar <p>Include the URI to the user's avatar.</p>  (optional, default to false)
   * @param exclude <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param excludeAccountIds <p>A comma-separated list of account IDs to exclude from the search results. This parameter may be specified multiple times. For example, <code>excludeAccountIds=99:27935d01-92a7-4687-8272-a9b8d3b2ae2e,bd429c95-e27b-4423-a0bd-421cf3d69129&amp;excludeAccountIds=384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</code>. Cannot be provided with <code>exclude</code>.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param avatarSize  (optional)
   * @param excludeConnectUsers  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;FoundUsers&gt;
   */
  public Single<FoundUsers> findUsersForPicker(
    Optional<String> query, Optional<Integer> maxResults, Optional<Boolean> showAvatar, Optional<List<String>> exclude, Optional<List<String>> excludeAccountIds, Optional<String> avatarSize, Optional<Boolean> excludeConnectUsers, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/picker");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (showAvatar.isPresent()) {
      queryParams.put("showAvatar", Collections.singleton(String.valueOf(showAvatar.get())));
    }
    if (exclude.isPresent()) {
      queryParams.put("exclude", RestCallUtil.objectCollectionToStringCollection(exclude.get()));
    }
    if (excludeAccountIds.isPresent()) {
      queryParams.put("excludeAccountIds", RestCallUtil.objectCollectionToStringCollection(excludeAccountIds.get()));
    }
    if (avatarSize.isPresent()) {
      queryParams.put("avatarSize", Collections.singleton(String.valueOf(avatarSize.get())));
    }
    if (excludeConnectUsers.isPresent()) {
      queryParams.put("excludeConnectUsers", Collections.singleton(String.valueOf(excludeConnectUsers.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_findUsersForPicker);
  }

  /**
   * Find users with permissions
   * <p>Returns a list of users who fulfill these criteria:</p> <ul> <li>their user attributes match a search string.</li> <li>they have a set of permissions for a project or issue.</li> </ul> <p>If no search string is provided, a list of all users with the permissions is returned.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to get users for any project.</li> <li><em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for a project, to get users for that project.</li> </ul> 
   * @param query <p>A query string that is matched against user attributes, such as <code>displayName</code> and <code>emailAddress</code>, to find relevant users. The string can match the prefix of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>johnson@example.com</em>. Required, unless <code>accountId</code> is specified.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param accountId <p>A query string that is matched against user accountId. The string must match the accountId exactly. Required, unless <code>query</code> is specified.</p>  (optional)
   * @param permissions <p>A comma-separated list of permissions. The valid permissions are:</p> <ul> <li>ASSIGNABLE_USER</li> <li>ASSIGN_ISSUE</li> <li>ATTACHMENT_DELETE_ALL</li> <li>ATTACHMENT_DELETE_OWN</li> <li>BROWSE</li> <li>CLOSE_ISSUE</li> <li>COMMENT_DELETE_ALL</li> <li>COMMENT_DELETE_OWN</li> <li>COMMENT_EDIT_ALL</li> <li>COMMENT_EDIT_OWN</li> <li>COMMENT_ISSUE</li> <li>CREATE_ATTACHMENT</li> <li>CREATE_ISSUE</li> <li>DELETE_ISSUE</li> <li>EDIT_ISSUE</li> <li>LINK_ISSUE</li> <li>MANAGE_WATCHER_LIST</li> <li>MODIFY_REPORTER</li> <li>MOVE_ISSUE</li> <li>PROJECT_ADMIN</li> <li>RESOLVE_ISSUE</li> <li>SCHEDULE_ISSUE</li> <li>SET_ISSUE_SECURITY</li> <li>TRANSITION_ISSUE</li> <li>VIEW_VERSION_CONTROL</li> <li>VIEW_VOTERS_AND_WATCHERS</li> <li>VIEW_WORKFLOW_READONLY</li> <li>WORKLOG_DELETE_ALL</li> <li>WORKLOG_DELETE_OWN</li> <li>WORKLOG_EDIT_ALL</li> <li>WORKLOG_EDIT_OWN</li> <li>WORK_ISSUE</li> </ul>  (optional)
   * @param issueKey <p>The issue key for the issue.</p>  (optional)
   * @param projectKey <p>The project key for the project (case sensitive).</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> findUsersWithAllPermissions(
    Optional<String> query, Optional<String> username, Optional<String> accountId, Optional<String> permissions, Optional<String> issueKey, Optional<String> projectKey, Optional<Integer> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/permission/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (permissions.isPresent()) {
      queryParams.put("permissions", Collections.singleton(String.valueOf(permissions.get())));
    }
    if (issueKey.isPresent()) {
      queryParams.put("issueKey", Collections.singleton(String.valueOf(issueKey.get())));
    }
    if (projectKey.isPresent()) {
      queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_findUsersWithAllPermissions);
  }

  /**
   * Find users with browse permission
   * <p>Returns a list of users who fulfill these criteria:</p> <ul> <li>their user attributes match a search string.</li> <li>they have permission to browse issues.</li> </ul> <p>Use this resource to find users who can browse:</p> <ul> <li>an issue, by providing the <code>issueKey</code>.</li> <li>any issue in a project, by providing the <code>projectKey</code>.</li> </ul> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Anonymous calls and calls by users without the required permission return empty search results.</p> 
   * @param query <p>A query string that is matched against user attributes, such as <code>displayName</code> and <code>emailAddress</code>, to find relevant users. The string can match the prefix of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>johnson@example.com</em>. Required, unless <code>accountId</code> is specified.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param accountId <p>A query string that is matched against user accountId. The string must match the accountId exactly. Required, unless <code>query</code> is specified.</p>  (optional)
   * @param issueKey <p>The issue key for the issue. Required, unless <code>projectKey</code> is specified.</p>  (optional)
   * @param projectKey <p>The project key for the project (case sensitive). Required, unless <code>issueKey</code> is specified.</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> findUsersWithBrowsePermission(
    Optional<String> query, Optional<String> username, Optional<String> accountId, Optional<String> issueKey, Optional<String> projectKey, Optional<Integer> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/viewissue/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (issueKey.isPresent()) {
      queryParams.put("issueKey", Collections.singleton(String.valueOf(issueKey.get())));
    }
    if (projectKey.isPresent()) {
      queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_findUsersWithBrowsePermission);
  }

  /**
   * Get user
   * <p>Returns a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide\">deprecation notice</a> for details.</p>  (optional)
   * @param key <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide\">deprecation notice</a> for details.</p>  (optional)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about users in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>groups</code> includes all groups and nested groups to which the user belongs.</li> <li><code>applicationRoles</code> includes details of all the applications to which the user has access.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;User&gt;
   */
  public Single<User> getUser(
    Optional<String> accountId, Optional<String> username, Optional<String> key, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    if (key.isPresent()) {
      queryParams.put("key", Collections.singleton(String.valueOf(key.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getUser);
  }

  /**
   * Get user default columns
   * <p>Returns the default <a href=\"https://confluence.atlassian.com/x/XYdKLg\">issue table columns</a> for the user. If an accountId is not passed in the request, the calling user's details are returned.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLgl\">global permission</a>, to get the column details for any user.</li> <li>Permission to access Jira, to get the calling user's column details.</li> </ul> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ColumnItem&gt;&gt;
   */
  public Single<List<ColumnItem>> getUserDefaultColumns(
    Optional<String> accountId, Optional<String> username, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/columns");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getUserDefaultColumns);
  }

  /**
   * Get user groups
   * <p>Returns the groups to which a user belongs.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param key <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;GroupName&gt;&gt;
   */
  public Single<List<GroupName>> getUserGroups(
    Optional<String> accountId, Optional<String> username, Optional<String> key, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/groups");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    if (key.isPresent()) {
      queryParams.put("key", Collections.singleton(String.valueOf(key.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getUserGroups);
  }

  /**
   * Delete user
   * <p>Deletes a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Site administration (that is, membership of the <em>site-admin</em> <a href=\"https://confluence.atlassian.com/x/24xjL\">group</a>).</p> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param key <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeUser(
    Optional<String> accountId, Optional<String> username, Optional<String> key, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    if (key.isPresent()) {
      queryParams.put("key", Collections.singleton(String.valueOf(key.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Reset user default columns
   * <p>Resets the default <a href=\"https://confluence.atlassian.com/x/XYdKLg\"> issue table columns</a> for the user to the system default. If an accountId is not passed, the calling user's default columns are reset.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to set the columns on any user.</li> <li>Permission to access Jira, to set the calling user's columns.</li> </ul> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable resetUserColumns(
    Optional<String> accountId, Optional<String> username, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/columns");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Set user default columns
   * <p>Sets the default <a href=\"https://confluence.atlassian.com/x/XYdKLg\"> issue table columns</a> for the user. If an accountId is not passed, the calling user's default columns are set. If no column details are sent, then all default columns are removed.</p> <p>The parameters for this resource are expressed as HTML form data. For example, in curl:</p> <p><code>curl -X PUT -d columns=summary -d columns=description https://your-domain.atlassian.net/rest/api/3/user/columns?accountId=384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192'</code></p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to set the columns on any user.</li> <li>Permission to access Jira, to set the calling user's columns.</li> </ul> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>.</p>  (optional)
   * @param requestBody <p>The ID of a column to set. To set multiple columns, send multiple <code>columns</code> parameters.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setUserColumns(
    Optional<String> accountId, Optional<List<String>> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/columns");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(requestBody);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_setUserColumns);
  }

}
