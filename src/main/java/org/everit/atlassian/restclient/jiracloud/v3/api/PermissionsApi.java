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

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Permissions> returnType_getAllPermissions = new TypeReference<Permissions>() {};

  private static final TypeReference<BulkPermissionGrants> returnType_getBulkPermissions = new TypeReference<BulkPermissionGrants>() {};

  private static final TypeReference<Permissions> returnType_getMyPermissions = new TypeReference<Permissions>() {};

  private static final TypeReference<PermittedProjects> returnType_getPermittedProjects = new TypeReference<PermittedProjects>() {};

  private final RestClient restClient;

  public PermissionsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get all permissions
   * Returns all permissions, including:   *  global permissions.  *  project permissions.  *  global permissions added by plugins.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllPermissions);
  }

  /**
   * Get bulk permissions
   * Returns:   *  for a list of global permissions, the global permissions granted to a user.  *  for a list of project permissions and lists of projects and issues, for each project permission a list of the projects and issues a user can access or manipulate.  If no account ID is provided, the operation returns details for the logged in user.  Note that:   *  Invalid project and issue IDs are ignored.  *  A maximum of 1000 projects and 1000 issues can be checked.  *  Null values in `globalPermissions`, `projectPermissions`, `projectPermissions.projects`, and `projectPermissions.issues` are ignored.  *  Empty strings in `projectPermissions.permissions` are ignored.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to check the permissions for other users, otherwise none. However, Connect apps can make a call from the app server to the product to obtain permission details for any user, without admin permission. This Connect app ability doesn't apply to calls made using AP.request() in a browser.
   * @param bulkPermissionsRequestBean Details of the permissions to check. (required)
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getBulkPermissions);
  }

  /**
   * Get my permissions
   * Returns a list of permissions indicating which permissions the user has. Details of the user's permissions can be obtained in a global, project, or issue context.  The user is reported as having a project permission:   *  in the global context, if the user has the project permission in any project.  *  for a project, where the project permission is determined using issue data, if the user meets the permission's criteria for any issue in the project. Otherwise, if the user has the project permission in the project.  *  for an issue, where a project permission is determined using issue data, if the user has the permission in the issue. Otherwise, if the user has the project permission in the project containing the issue.  This means that users may be shown as having an issue permission (such as EDIT\\_ISSUES) in the global context or a project context but may not have the permission for any or all issues. For example, if Reporters have the EDIT\\_ISSUES permission a user would be shown as having this permission in the global context or the context of a project, because any user can be a reporter. However, if they are not the user who reported the issue queried they would not have EDIT\\_ISSUES permission for that issue.  Global permissions are unaffected by context.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
   * @param projectKey The key of project. Ignored if `projectId` is provided. (optional)
   * @param projectId The ID of project. (optional)
   * @param issueKey The key of the issue. Ignored if `issueId` is provided. (optional)
   * @param issueId The ID of the issue. (optional)
   * @param permissions A list of permission keys. (Required) This parameter accepts a comma-separated list. To get the list of available permissions, use [Get all permissions](#api-rest-api-3-permissions-get). (optional)
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getMyPermissions);
  }

  /**
   * Get permitted projects
   * Returns all the projects where the user is granted a list of project permissions.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPermittedProjects);
  }

}
