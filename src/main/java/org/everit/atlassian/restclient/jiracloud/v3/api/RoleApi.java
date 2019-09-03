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

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.restclient.RestCallUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;

import org.everit.http.client.HttpClient;
import org.everit.http.client.HttpMethod;
import org.everit.http.client.HttpRequest;

import org.everit.atlassian.restclient.jiracloud.v3.model.ActorInputBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.CreateUpdateRoleRequestBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.ProjectRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<ProjectRole> returnType_addProjectRoleActorsToRole = new TypeReference<ProjectRole>() {};

  private static final TypeReference<ProjectRole> returnType_createProjectRole = new TypeReference<ProjectRole>() {};

  private static final TypeReference<ProjectRole> returnType_deleteProjectRoleActorsFromRole = new TypeReference<ProjectRole>() {};

  private static final TypeReference<ProjectRole> returnType_fullyUpdateProjectRole = new TypeReference<ProjectRole>() {};

  private static final TypeReference<List<ProjectRole>> returnType_getAllProjectRoles = new TypeReference<List<ProjectRole>>() {};

  private static final TypeReference<ProjectRole> returnType_getProjectRoleActorsForRole = new TypeReference<ProjectRole>() {};

  private static final TypeReference<ProjectRole> returnType_getProjectRoleById = new TypeReference<ProjectRole>() {};

  private static final TypeReference<ProjectRole> returnType_partialUpdateProjectRole = new TypeReference<ProjectRole>() {};

  private final HttpClient httpClient;

  public RoleApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Add default actors to project role
   * <p>Adds <a href=\"#api-rest-api-3-resolution-get\">default actors</a> to a role. You may add groups or users, but you cannot add groups and users in the same request.</p> <p>Changing a project role's default actors does not affect project role members for projects already created.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the project role. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param actorInputBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectRole&gt;
   */
  public Single<ProjectRole> addProjectRoleActorsToRole(
    Long id, ActorInputBean actorInputBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/role/{id}/actors");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(actorInputBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_addProjectRoleActorsToRole);
  }

  /**
   * Create project role
   * <p>Creates a new project role with no <a href=\"#api-rest-api-3-resolution-get\">default actors</a>. You can use the <a href=\"#api-rest-api-3-role-id-actors-post\">Add default actors to project role</a> operation to add default actors to the project role after creating it.</p> <p><em>Note that although a new project role is available to all projects upon creation, any default actors that are associated with the project role are not added to projects that existed prior to the role being created.</em>&lt;</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param createUpdateRoleRequestBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectRole&gt;
   */
  public Single<ProjectRole> createProjectRole(
    CreateUpdateRoleRequestBean createUpdateRoleRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/role");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(createUpdateRoleRequestBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_createProjectRole);
  }

  /**
   * Delete project role
   * <p>Deletes a project role. You must specify a replacement project role if you wish to delete a project role that is in use.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the project role to delete. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param swap <p>The ID of the project role that will replace the one being deleted.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteProjectRole(
    Long id, Optional<Long> swap, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/role/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (swap.isPresent()) {
      queryParams.put("swap", Collections.singleton(String.valueOf(swap.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Delete default actors from project role
   * <p>Deletes the <a href=\"#api-rest-api-3-resolution-get\">default actors</a> from a project role. You may delete a group or user, but you cannot delete a group and a user in the same request.</p> <p>Changing a project role's default actors does not affect project role members for projects already created.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the project role. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param user <p>The user account ID of the user to remove as a default actor.</p>  (optional)
   * @param group <p>The group name of the group to be removed as a default actor.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectRole&gt;
   */
  public Single<ProjectRole> deleteProjectRoleActorsFromRole(
    Long id, Optional<String> user, Optional<String> group, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/role/{id}/actors");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (user.isPresent()) {
      queryParams.put("user", Collections.singleton(String.valueOf(user.get())));
    }
    if (group.isPresent()) {
      queryParams.put("group", Collections.singleton(String.valueOf(group.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_deleteProjectRoleActorsFromRole);
  }

  /**
   * Fully update project role
   * <p>Updates the project role's name and description. You must include both a name and a description in the request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the project role. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param createUpdateRoleRequestBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectRole&gt;
   */
  public Single<ProjectRole> fullyUpdateProjectRole(
    Long id, CreateUpdateRoleRequestBean createUpdateRoleRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/role/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(createUpdateRoleRequestBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_fullyUpdateProjectRole);
  }

  /**
   * Get all project roles
   * <p>Gets a list of all project roles, complete with project role details and default actors.</p> <h3>About project roles</h3> <p><a href=\"https://confluence.atlassian.com/x/3odKLg\">Project roles</a> are a flexible way to to associate users and groups with projects. In Jira Cloud, the list of project roles is shared globally with all projects, but each project can have a different set of actors associated with it (unlike groups, which have the same membership throughout all Jira applications).</p> <p>Project roles are used in <a href=\"#api-rest-api-3-permissionscheme-get\">permission schemes</a>, <a href=\"#api-rest-api-3-notificationscheme-get\">email notification schemes</a>, <a href=\"#api-rest-api-3-issuesecurityschemes-get\">issue security levels</a>, <a href=\"#api-rest-api-3-comment-list-post\">comment visibility</a>, and workflow conditions.</p> <h4>Members and actors</h4> <p>In the Jira REST API, a member of a project role is called an <em>actor</em>. An <em>actor</em> is a group or user associated with a project role.</p> <p>Actors may be set as <a href=\"https://confluence.atlassian.com/x/3odKLg#Managingprojectroles-Specifying'defaultmembers'foraprojectrole\">default members</a> of the project role or set at the project level:</p> <ul> <li>Default actors: Users and groups that are assigned to the project role for all newly created projects. The default actors can be removed at the project level later if desired.</li> <li>Actors: Users and groups that are associated with a project role for a project, which may differ from the default actors. This enables you to assign a user to different roles in different projects.</li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ProjectRole&gt;&gt;
   */
  public Single<List<ProjectRole>> getAllProjectRoles(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/role");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAllProjectRoles);
  }

  /**
   * Get default actors for project role
   * <p>Returns the <a href=\"#api-rest-api-3-resolution-get\">default actors</a> for the project role.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the project role. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectRole&gt;
   */
  public Single<ProjectRole> getProjectRoleActorsForRole(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/role/{id}/actors");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getProjectRoleActorsForRole);
  }

  /**
   * Get project role by ID
   * <p>Gets the project role details and the default actors associated with the role. The list of default actors is sorted by display name.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the project role. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectRole&gt;
   */
  public Single<ProjectRole> getProjectRoleById(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/role/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getProjectRoleById);
  }

  /**
   * Partial update project role
   * <p>Updates either the project role's name or its description.</p> <p>You cannot update both the name and description at the same time using this operation. If you send a request with a name and a description only the name is updated.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the project role. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param createUpdateRoleRequestBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectRole&gt;
   */
  public Single<ProjectRole> partialUpdateProjectRole(
    Long id, CreateUpdateRoleRequestBean createUpdateRoleRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/role/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(createUpdateRoleRequestBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_partialUpdateProjectRole);
  }

}
