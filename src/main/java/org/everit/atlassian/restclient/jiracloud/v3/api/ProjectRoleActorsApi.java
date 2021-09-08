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

import org.everit.atlassian.restclient.jiracloud.v3.model.ActorInputBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.ActorsMap;
import org.everit.atlassian.restclient.jiracloud.v3.model.ProjectRole;
import org.everit.atlassian.restclient.jiracloud.v3.model.ProjectRoleActorsUpdateBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRoleActorsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<ProjectRole> returnType_addActorUsers = new TypeReference<ProjectRole>() {};

  private static final TypeReference<ProjectRole> returnType_addProjectRoleActorsToRole = new TypeReference<ProjectRole>() {};

  private static final TypeReference<ProjectRole> returnType_deleteProjectRoleActorsFromRole = new TypeReference<ProjectRole>() {};

  private static final TypeReference<ProjectRole> returnType_getProjectRoleActorsForRole = new TypeReference<ProjectRole>() {};

  private static final TypeReference<ProjectRole> returnType_setActors = new TypeReference<ProjectRole>() {};

  private final RestClient restClient;

  public ProjectRoleActorsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add actors to project role
   * Adds actors to a project role for the project.  To replace all actors for the project, use [Set actors for project role](#api-rest-api-3-project-projectIdOrKey-role-id-put).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param projectIdOrKey The project ID or project key (case sensitive). (required)
   * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. (required)
   * @param actorsMap The groups or users to associate with the project role for this project. Provide the user account ID or group name. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectRole&gt;
   */
  public Single<ProjectRole> addActorUsers(
    String projectIdOrKey, Long id, ActorsMap actorsMap, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/{projectIdOrKey}/role/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(actorsMap));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addActorUsers);
  }

  /**
   * Add default actors to project role
   * Adds [default actors](#api-rest-api-3-resolution-get) to a role. You may add groups or users, but you cannot add groups and users in the same request.  Changing a project role's default actors does not affect project role members for projects already created.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. (required)
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addProjectRoleActorsToRole);
  }

  /**
   * Delete actors from project role
   * Deletes actors from a project role for the project.  To remove default actors from the project role, use [Delete default actors from project role](#api-rest-api-3-role-id-actors-delete).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param projectIdOrKey The project ID or project key (case sensitive). (required)
   * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. (required)
   * @param user The user account ID of the user to remove from the project role. (optional)
   * @param group The name of the group to remove from the project role. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteActor(
    String projectIdOrKey, Long id, Optional<String> user, Optional<String> group, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/{projectIdOrKey}/role/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Delete default actors from project role
   * Deletes the [default actors](#api-rest-api-3-resolution-get) from a project role. You may delete a group or user, but you cannot delete a group and a user in the same request.  Changing a project role's default actors does not affect project role members for projects already created.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. (required)
   * @param user The user account ID of the user to remove as a default actor. (optional)
   * @param group The group name of the group to be removed as a default actor. (optional)
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteProjectRoleActorsFromRole);
  }

  /**
   * Get default actors for project role
   * Returns the [default actors](#api-rest-api-3-resolution-get) for the project role.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. (required)
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getProjectRoleActorsForRole);
  }

  /**
   * Set actors for project role
   * Sets the actors for a project role for a project, replacing all existing actors.  To add actors to the project without overwriting the existing list, use [Add actors to project role](#api-rest-api-3-project-projectIdOrKey-role-id-post).  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param projectIdOrKey The project ID or project key (case sensitive). (required)
   * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. (required)
   * @param projectRoleActorsUpdateBean The groups or users to associate with the project role for this project. Provide the user account ID or group name. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectRole&gt;
   */
  public Single<ProjectRole> setActors(
    String projectIdOrKey, Long id, ProjectRoleActorsUpdateBean projectRoleActorsUpdateBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/{projectIdOrKey}/role/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(projectRoleActorsUpdateBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setActors);
  }

}
