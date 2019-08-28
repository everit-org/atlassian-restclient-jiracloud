package org.openapitools.client.api;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.atlassian.restclient.common.RestCallUtil;
import org.everit.atlassian.restclient.common.RestRequest;
import org.everit.atlassian.restclient.common.RestRequestInterceptor;

import org.everit.http.client.HttpClient;
import org.everit.http.client.HttpMethod;
import org.everit.http.client.HttpRequest;

import org.openapitools.client.model.ColumnItem;
import org.openapitools.client.model.FoundUsers;
import org.openapitools.client.model.GroupName;
import org.openapitools.client.model.User;
import org.openapitools.client.model.UserWriteBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

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
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;User&gt;
   */
  public Single<User> createUser(
    UserWriteBean requestBody, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user";
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createUser);
  }

  /**
   * Find users assignable to issues
   * <p>Returns a list of users that can be assigned to an issue. Use this operation to find the list of users who can be assigned to:</p> <ul> <li>a new issue, by providing the <code>projectKeyOrId</code>.</li> <li>an updated issue, by providing the <code>issueKey</code>.</li> <li>to an issue during a transition (workflow action), by providing the <code>issueKey</code> and the transition id in <code>actionDescriptorId</code>. You can obtain the IDs of an issue's valid transitions using the <code>transitions</code> option in the <code>expand</code> parameter of <a href=\"#api-rest-api-3-issue-issueIdOrKey-get\"> Get issue</a>.</li> </ul> <p>In all these cases, you can pass an accountId to determine if a user can be assigned to an issue. The user is returned in the response if they can be assigned to the issue or issue transition.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param query <p>A query string that is matched against user attributes, such as <code>key</code>, <code>name</code>, <code>displayName</code>, and <code>emailAddress</code>, to find relevant users. The string can match any part of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>jane.johnson@example.com</em>. Required, unless <code>username</code> or <code>accountId</code> is specified.</p>  (optional)
   * @param sessionId <p>The sessionId of this request. SessionId is the same until the assignee is set.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param accountId <p>A query string that is matched against user accountId. The string must match the accountId exactly. Required, unless <code>query</code> is specified.</p>  (optional)
   * @param project <p>The project ID or project key (case sensitive). Required, unless <code>issueKey</code> is specified.</p>  (optional)
   * @param issueKey <p>The key of the issue. Required, unless <code>project</code> is specified.</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param actionDescriptorId <p>The ID of the transition.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> findAssignableUsers(
    String query, String sessionId, String username, String accountId, String project, String issueKey, Integer startAt, Integer maxResults, Integer actionDescriptorId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/assignable/search";
    if (query != null) {
      request.queryParams.put("query", Collections.singleton(String.valueOf(query)));
    }
    if (sessionId != null) {
      request.queryParams.put("sessionId", Collections.singleton(String.valueOf(sessionId)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (project != null) {
      request.queryParams.put("project", Collections.singleton(String.valueOf(project)));
    }
    if (issueKey != null) {
      request.queryParams.put("issueKey", Collections.singleton(String.valueOf(issueKey)));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (actionDescriptorId != null) {
      request.queryParams.put("actionDescriptorId", Collections.singleton(String.valueOf(actionDescriptorId)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_findAssignableUsers);
  }

  /**
   * Find users assignable to projects
   * <p>Returns a list of users who can be assigned issues in one or more projects. The list may be restricted to users whose attributes match a string.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param query <p>A query string that is matched against user attributes, such as <code>displayName</code> and <code>emailAddress</code>, to find relevant users. The string can match any part of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>jane.johnson@example.com</em>. Required, unless <code>accountId</code> is specified.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param accountId <p>A query string that is matched against user accountId. The string must match the accountId exactly. Required, unless <code>query</code> is specified.</p>  (optional)
   * @param projectKeys <p>A comma-separated list of project keys (case sensitive).</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> findBulkAssignableUsers(
    String query, String username, String accountId, String projectKeys, Integer startAt, Integer maxResults, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/assignable/multiProjectSearch";
    if (query != null) {
      request.queryParams.put("query", Collections.singleton(String.valueOf(query)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (projectKeys != null) {
      request.queryParams.put("projectKeys", Collections.singleton(String.valueOf(projectKeys)));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_findBulkAssignableUsers);
  }

  /**
   * Find users
   * <p>Returns a list of users that match the provided search string and property.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Anonymous calls or calls by users without the required permission return empty search results.</p> <p><strong>Note:</strong> This API is designed to return a small number of users with a flexible search query. As such, the sum of <code>startAt</code> and <code>maxResults</code> must be less than 1000. If the sum is greater, only results up to the 1000th result will be returned. If you wish to get a larger number of users, please use the get-all-users API (<code>/rest/api/3/users/search</code>) instead.</p> 
   * @param query <p>A query string that is matched against user attributes (<code>key</code>, <code>name</code>, <code>displayName</code>, and <code>emailAddress</code>) to find relevant users. The string can match any part of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>jane.johnson@example.com</em>. Required, unless <code>accountId</code> or <code>property</code> is specified.</p>  (optional)
   * @param username  (optional)
   * @param accountId <p>A query string that is matched against a user accountId. The string must match the accountId exactly. Required, unless <code>query</code> or <code>property</code> is specified.</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param includeActive  (optional, default to true)
   * @param includeInactive  (optional, default to false)
   * @param property <p>A query string used to search properties. Property keys are specified by path, so property keys containing dot (.) or equals (=) characters cannot be used. The query string cannot be specified using a JSON object. Example: To search for the value of <code>nested</code> from <code>{&quot;something&quot;:{&quot;nested&quot;:1,&quot;other&quot;:2}}</code> use <code>thepropertykey.something.nested=1</code>. Required, unless <code>accountId</code> or <code>query</code> are specified.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> findUsers(
    String query, String username, String accountId, Integer startAt, Integer maxResults, Boolean includeActive, Boolean includeInactive, String property, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/search";
    if (query != null) {
      request.queryParams.put("query", Collections.singleton(String.valueOf(query)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (includeActive != null) {
      request.queryParams.put("includeActive", Collections.singleton(String.valueOf(includeActive)));
    }
    if (includeInactive != null) {
      request.queryParams.put("includeInactive", Collections.singleton(String.valueOf(includeInactive)));
    }
    if (property != null) {
      request.queryParams.put("property", Collections.singleton(String.valueOf(property)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_findUsers);
  }

  /**
   * Find users for picker
   * <p>Returns a list of users whose attributes match the query term. The returned object includes the <code>html</code> field where the matched query term is highlighted with the HTML strong tag. A list of account IDs can be provided to exclude users from the results.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Anonymous calls and calls by users without the required permission return search results for an exact name match only.</p> 
   * @param query <p>A query string that is matched against user attributes, such as <code>key</code>, <code>name</code>, <code>displayName</code>, and <code>emailAddress</code>, to find relevant users. The string can match any part of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>jane.johnson@example.com</em>.</p>  (optional)
   * @param maxResults <p>The maximum number of items to return. The maximum is <code>1000</code>. The total number of matched users is returned in <code>total</code>.</p>  (optional, default to 50)
   * @param showAvatar <p>Include the URI to the user's avatar.</p>  (optional, default to false)
   * @param exclude <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param excludeAccountIds <p>A comma-separated list of account IDs to exclude from the search results. This parameter may be specified multiple times. For example, <code>excludeAccountIds=99:27935d01-92a7-4687-8272-a9b8d3b2ae2e,bd429c95-e27b-4423-a0bd-421cf3d69129&amp;excludeAccountIds=384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</code>. Cannot be provided with <code>exclude</code>.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param avatarSize  (optional)
   * @param excludeConnectUsers  (optional, default to false)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;FoundUsers&gt;
   */
  public Single<FoundUsers> findUsersForPicker(
    String query, Integer maxResults, Boolean showAvatar, List<String> exclude, List<String> excludeAccountIds, String avatarSize, Boolean excludeConnectUsers, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/picker";
    if (query != null) {
      request.queryParams.put("query", Collections.singleton(String.valueOf(query)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (showAvatar != null) {
      request.queryParams.put("showAvatar", Collections.singleton(String.valueOf(showAvatar)));
    }
    if (exclude != null) {
      request.queryParams.put("exclude", RestCallUtil.objectCollectionToStringCollection(exclude));
    }
    if (excludeAccountIds != null) {
      request.queryParams.put("excludeAccountIds", RestCallUtil.objectCollectionToStringCollection(excludeAccountIds));
    }
    if (avatarSize != null) {
      request.queryParams.put("avatarSize", Collections.singleton(String.valueOf(avatarSize)));
    }
    if (excludeConnectUsers != null) {
      request.queryParams.put("excludeConnectUsers", Collections.singleton(String.valueOf(excludeConnectUsers)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_findUsersForPicker);
  }

  /**
   * Find users with permissions
   * <p>Returns a list of users who fulfill these criteria:</p> <ul> <li>their user attributes match a search string.</li> <li>they have a set of permissions for a project or issue.</li> </ul> <p>If no search string is provided, a list of all users with the permissions is returned.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to get users for any project.</li> <li><em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for a project, to get users for that project.</li> </ul> 
   * @param query <p>A query string that is matched against user attributes, such as <code>displayName</code> and <code>emailAddress</code>, to find relevant users. The string can match any part of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>jane.johnson@example.com</em>. Required, unless <code>accountId</code> is specified.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param accountId <p>A query string that is matched against user accountId. The string must match the accountId exactly. Required, unless <code>query</code> is specified.</p>  (optional)
   * @param permissions <p>A comma-separated list of permissions. The valid permissions are:</p> <ul> <li>ASSIGNABLE_USER</li> <li>ASSIGN_ISSUE</li> <li>ATTACHMENT_DELETE_ALL</li> <li>ATTACHMENT_DELETE_OWN</li> <li>BROWSE</li> <li>CLOSE_ISSUE</li> <li>COMMENT_DELETE_ALL</li> <li>COMMENT_DELETE_OWN</li> <li>COMMENT_EDIT_ALL</li> <li>COMMENT_EDIT_OWN</li> <li>COMMENT_ISSUE</li> <li>CREATE_ATTACHMENT</li> <li>CREATE_ISSUE</li> <li>DELETE_ISSUE</li> <li>EDIT_ISSUE</li> <li>LINK_ISSUE</li> <li>MANAGE_WATCHER_LIST</li> <li>MODIFY_REPORTER</li> <li>MOVE_ISSUE</li> <li>PROJECT_ADMIN</li> <li>RESOLVE_ISSUE</li> <li>SCHEDULE_ISSUE</li> <li>SET_ISSUE_SECURITY</li> <li>TRANSITION_ISSUE</li> <li>VIEW_VERSION_CONTROL</li> <li>VIEW_VOTERS_AND_WATCHERS</li> <li>VIEW_WORKFLOW_READONLY</li> <li>WORKLOG_DELETE_ALL</li> <li>WORKLOG_DELETE_OWN</li> <li>WORKLOG_EDIT_ALL</li> <li>WORKLOG_EDIT_OWN</li> <li>WORK_ISSUE</li> </ul>  (optional)
   * @param issueKey <p>The issue key for the issue.</p>  (optional)
   * @param projectKey <p>The project key for the project (case sensitive).</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> findUsersWithAllPermissions(
    String query, String username, String accountId, String permissions, String issueKey, String projectKey, Integer startAt, Integer maxResults, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/permission/search";
    if (query != null) {
      request.queryParams.put("query", Collections.singleton(String.valueOf(query)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (permissions != null) {
      request.queryParams.put("permissions", Collections.singleton(String.valueOf(permissions)));
    }
    if (issueKey != null) {
      request.queryParams.put("issueKey", Collections.singleton(String.valueOf(issueKey)));
    }
    if (projectKey != null) {
      request.queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey)));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_findUsersWithAllPermissions);
  }

  /**
   * Find users with browse permission
   * <p>Returns a list of users who fulfill these criteria:</p> <ul> <li>their user attributes match a search string.</li> <li>they have permission to browse issues.</li> </ul> <p>Use this resource to find users who can browse:</p> <ul> <li>an issue, by providing the <code>issueKey</code>.</li> <li>any issue in a project, by providing the <code>projectKey</code>.</li> </ul> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Anonymous calls and calls by users without the required permission return empty search results.</p> 
   * @param query <p>A query string that is matched against user attributes, such as <code>displayName</code> and <code>emailAddress</code>, to find relevant users. The string can match any part of the attribute's value. For example, <em>query=john</em> matches a user with a <code>displayName</code> of <em>John Smith</em> and a user with an <code>emailAddress</code> of <em>jane.johnson@example.com</em>. Required, unless <code>accountId</code> is specified.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param accountId <p>A query string that is matched against user accountId. The string must match the accountId exactly. Required, unless <code>query</code> is specified.</p>  (optional)
   * @param issueKey <p>The issue key for the issue. Required, unless <code>projectKey</code> is specified.</p>  (optional)
   * @param projectKey <p>The project key for the project (case sensitive). Required, unless <code>issueKey</code> is specified.</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> findUsersWithBrowsePermission(
    String query, String username, String accountId, String issueKey, String projectKey, Integer startAt, Integer maxResults, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/viewissue/search";
    if (query != null) {
      request.queryParams.put("query", Collections.singleton(String.valueOf(query)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (issueKey != null) {
      request.queryParams.put("issueKey", Collections.singleton(String.valueOf(issueKey)));
    }
    if (projectKey != null) {
      request.queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey)));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_findUsersWithBrowsePermission);
  }

  /**
   * Get user
   * <p>Returns a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param key <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about users in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>groups</code> includes all groups and nested groups to which the user belongs.</li> <li><code>applicationRoles</code> includes details of all the applications to which the user has access.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;User&gt;
   */
  public Single<User> getUser(
    String accountId, String username, String key, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user";
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    if (key != null) {
      request.queryParams.put("key", Collections.singleton(String.valueOf(key)));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getUser);
  }

  /**
   * Get user default columns
   * <p>Returns the default <a href=\"https://confluence.atlassian.com/x/XYdKLg\">issue table columns</a> for the user. If an accountId is not passed in the request, the calling user's details are returned.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLgl\">global permission</a>, to get the column details for any user.</li> <li>Permission to access Jira, to get the calling user's column details.</li> </ul> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ColumnItem&gt;&gt;
   */
  public Single<List<ColumnItem>> getUserDefaultColumns(
    String accountId, String username, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/columns";
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getUserDefaultColumns);
  }

  /**
   * Get user groups
   * <p>Returns the groups to which a user belongs.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param key <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;GroupName&gt;&gt;
   */
  public Single<List<GroupName>> getUserGroups(
    String accountId, String username, String key, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/groups";
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    if (key != null) {
      request.queryParams.put("key", Collections.singleton(String.valueOf(key)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getUserGroups);
  }

  /**
   * Delete user
   * <p>Deletes a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Site administration (that is, membership of the <em>site-admin</em> <a href=\"https://confluence.atlassian.com/x/24xjL\">group</a>).</p> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param key <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeUser(
    String accountId, String username, String key, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user";
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    if (key != null) {
      request.queryParams.put("key", Collections.singleton(String.valueOf(key)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Reset user default columns
   * <p>Resets the default <a href=\"https://confluence.atlassian.com/x/XYdKLg\"> issue table columns</a> for the user to the system default. If an accountId is not passed, the calling user's default columns are reset.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to set the columns on any user.</li> <li>Permission to access Jira, to set the calling user's columns.</li> </ul> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable resetUserColumns(
    String accountId, String username, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/columns";
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Set user default columns
   * <p>Sets the default <a href=\"https://confluence.atlassian.com/x/XYdKLg\"> issue table columns</a> for the user. If an accountId is not passed, the calling user's default columns are set. If no column details are sent, then all default columns are removed.</p> <p>The parameters for this resource are expressed as HTML form data. For example, in curl:</p> <p><code>curl -X PUT -d columns=summary -d columns=description https://your-domain.atlassian.net/rest/api/3/user/columns?accountId=384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192'</code></p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to set the columns on any user.</li> <li>Permission to access Jira, to set the calling user's columns.</li> </ul> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>.</p>  (optional)
   * @param requestBody <p>The ID of a column to set. To set multiple columns, send multiple <code>columns</code> parameters.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setUserColumns(
    String accountId, List<String> requestBody, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/columns";
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_setUserColumns);
  }

}
