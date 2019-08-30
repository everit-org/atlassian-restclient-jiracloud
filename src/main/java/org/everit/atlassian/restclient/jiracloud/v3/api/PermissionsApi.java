package org.everit.atlassian.restclient.jiracloud.v3.api;

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

import org.everit.atlassian.restclient.jiracloud.v3.model.BulkPermissionGrants;
import org.everit.atlassian.restclient.jiracloud.v3.model.BulkPermissionsRequestBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v3.model.Permissions;
import org.everit.atlassian.restclient.jiracloud.v3.model.PermissionsKeysBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.PermittedProjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionsApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<Permissions> returnType_getAllPermissions = new TypeReference<Permissions>() {};

  private static final TypeReference<BulkPermissionGrants> returnType_getBulkPermissions = new TypeReference<BulkPermissionGrants>() {};

  private static final TypeReference<Permissions> returnType_getMyPermissions = new TypeReference<Permissions>() {};

  private static final TypeReference<PermittedProjects> returnType_getPermittedProjects = new TypeReference<PermittedProjects>() {};

  private final HttpClient httpClient;

  public PermissionsApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get all permissions
   * <p>Returns all permissions, including:</p> <ul> <li>global permissions.</li> <li>project permissions.</li> <li>global permissions added by plugins.</li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Permissions&gt;
   */
  public Single<Permissions> getAllPermissions(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/permissions");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAllPermissions);
  }

  /**
   * Get bulk permissions
   * <p>Returns:</p> <ul> <li>for a list of global permissions, the global permissions granted to the user.</li> <li>for a list of project permissions and lists of projects and issues, for each project permission a list of the projects and issues the user can access or manipulate.</li> </ul> <p>Note that:</p> <ul> <li>Invalid project and issue IDs are ignored.</li> <li>A maximum of 1000 projects and 1000 issues can be checked.</li> </ul> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param bulkPermissionsRequestBean <p>Details of the permissions to check.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;BulkPermissionGrants&gt;
   */
  public Single<BulkPermissionGrants> getBulkPermissions(
    BulkPermissionsRequestBean bulkPermissionsRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/permissions/check");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(bulkPermissionsRequestBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getBulkPermissions);
  }

  /**
   * Get my permissions
   * <p>Returns a list of permissions indicating which permissions the user has. Details of the user's permissions can be obtained in a global, project, or issue context.</p> <p>The user is reported as having a project permission:</p> <ul> <li>in the global context, if the user has the project permission in any project.</li> <li>for a project, where the project permission is determined using issue data, if the user meets the permission's criteria for any issue in the project. Otherwise, if the user has the project permission in the project.</li> <li>for an issue, where a project permission is determined using issue data, if the user has the permission in the issue. Otherwise, if the user has the project permission in the project containing the issue.</li> </ul> <p>This means that users may be shown as having an issue permission (such as EDIT_ISSUE) in the global context or a project context but may not have the permission for any or all issues. For example, if Reporters have the EDIT_ISSUE permission a user would be shown as having this permission in the global context or the context of a project, because any user can be a reporter. However, if they are not the user who reported the issue queried they would not have EDIT_ISSUE permission for that issue.</p> <p>Global permissions are unaffected by context.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param projectKey <p>The key of project. Ignored if <code>projectId</code> is provided.</p>  (optional)
   * @param projectId <p>The ID of project.</p>  (optional)
   * @param issueKey <p>The key of the issue. Ignored if <code>issueId</code> is provided.</p>  (optional)
   * @param issueId <p>The ID of the issue.</p>  (optional)
   * @param permissions <p>A comma-separated list of permission keys. <a href=\"https://developer.atlassian.com/cloud/jira/platform/change-notice-get-my-permissions-requires-permissions-query-parameter/\"> Omitting this parameter is <strong>deprecated</strong>.</a> To get the list of available permissions, use <a href=\"#api-rest-api-3-permissions-get\">Get all permissions</a>. Note that deprecated keys cannot be used. Deprecated keys are not returned by <a href=\"#api-rest-api-3-permissions-get\">Get all permissions</a> but are returned by this operation if <code>permissions</code> is omitted.</p>  (optional)
   * @param projectUuid  (optional)
   * @param projectConfigurationUuid  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Permissions&gt;
   */
  public Single<Permissions> getMyPermissions(
    Optional<String> projectKey, Optional<String> projectId, Optional<String> issueKey, Optional<String> issueId, Optional<String> permissions, Optional<String> projectUuid, Optional<String> projectConfigurationUuid, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/mypermissions");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (projectKey.isPresent()) {
      queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey.get())));
    }
    if (projectId.isPresent()) {
      queryParams.put("projectId", Collections.singleton(String.valueOf(projectId.get())));
    }
    if (issueKey.isPresent()) {
      queryParams.put("issueKey", Collections.singleton(String.valueOf(issueKey.get())));
    }
    if (issueId.isPresent()) {
      queryParams.put("issueId", Collections.singleton(String.valueOf(issueId.get())));
    }
    if (permissions.isPresent()) {
      queryParams.put("permissions", Collections.singleton(String.valueOf(permissions.get())));
    }
    if (projectUuid.isPresent()) {
      queryParams.put("projectUuid", Collections.singleton(String.valueOf(projectUuid.get())));
    }
    if (projectConfigurationUuid.isPresent()) {
      queryParams.put("projectConfigurationUuid", Collections.singleton(String.valueOf(projectConfigurationUuid.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getMyPermissions);
  }

  /**
   * Get permitted projects
   * <p>Returns all the projects where the user is granted a list of project permissions.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param permissionsKeysBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PermittedProjects&gt;
   */
  public Single<PermittedProjects> getPermittedProjects(
    PermissionsKeysBean permissionsKeysBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/permissions/project");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(permissionsKeysBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getPermittedProjects);
  }

}
