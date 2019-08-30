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

import org.everit.atlassian.restclient.jiracloud.v3.model.ActorsMap;
import org.everit.atlassian.restclient.jiracloud.v3.model.ProjectRole;
import org.everit.atlassian.restclient.jiracloud.v3.model.ProjectRoleActorsUpdateBean;
import java.net.URI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRoleApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<ProjectRole> returnType_addActorUsers = new TypeReference<ProjectRole>() {};

  private static final TypeReference<ProjectRole> returnType_getProjectRole = new TypeReference<ProjectRole>() {};

  private static final TypeReference<Map<String, URI>> returnType_getProjectRoles = new TypeReference<Map<String, URI>>() {};

  private static final TypeReference<ProjectRole> returnType_setActors = new TypeReference<ProjectRole>() {};

  private final HttpClient httpClient;

  public ProjectRoleApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Add actors to project role
   * <p>Adds actors to a project role for the project.</p> <p>To replace all actors for the project, use <a href=\"#api-rest-api-3-project-projectIdOrKey-role-id-put\">Set actors for project role</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project or <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param id <p>The ID of the project role. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param actorsMap <p>The groups or users to associate with the project role for this project. Provide the user account ID or group name.</p>  (required)
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_addActorUsers);
  }

  /**
   * Delete actors from project role
   * <p>Deletes actors from a project role for the project.</p> <p>To remove default actors from the project role, use <a href=\"#api-rest-api-3-role-id-actors-delete\">Delete default actors from project role This operation can be accessed anonymously. </a></p> <p><a href=\"#api-rest-api-3-role-id-actors-delete\"> </a><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project or <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param id <p>The ID of the project role. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param user <p>The user account ID of the user to remove from the project role.</p>  (optional)
   * @param group <p>The name of the group to remove from the project role.</p>  (optional)
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get project role for project
   * <p>Returns a project role's details and actors associated with the project. The list of actors is sorted by display name.</p> <p>To check whether a user belongs to a role based on their group memberships, use <a href=\"#api-rest-api-3-user-get\">Get user</a> with the <code>groups</code> expand parameter selected. Then check whether the user keys and groups match with the actors returned for the project.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project or <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param id <p>The ID of the project role. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectRole&gt;
   */
  public Single<ProjectRole> getProjectRole(
    String projectIdOrKey, Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getProjectRole);
  }

  /**
   * Get project roles for project
   * <p>Returns a list of <a href=\"https://confluence.atlassian.com/x/3odKLg\">project roles</a> for the project returning the name and self URL for each role.</p> <p>Note that all project roles are shared with all projects in Jira Cloud. See <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> for more information.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for any project on the site<em>Administer Jira</em> or <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Map&lt;String, URI&gt;&gt;
   */
  public Single<Map<String, URI>> getProjectRoles(
    String projectIdOrKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/{projectIdOrKey}/role");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getProjectRoles);
  }

  /**
   * Set actors for project role
   * <p>Sets the actors for a project role for a project, replacing all existing actors.</p> <p>To add actors to the project without overwriting the existing list, use <a href=\"#api-rest-api-3-project-projectIdOrKey-role-id-post\">Add actors to project role</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project or <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param id <p>The ID of the project role. Use <a href=\"#api-rest-api-3-role-get\">Get all project roles</a> to get a list of project role IDs.</p>  (required)
   * @param projectRoleActorsUpdateBean <p>The groups or users to associate with the project role for this project. Provide the user account ID or group name.</p>  (required)
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_setActors);
  }

}
