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

import org.everit.atlassian.restclient.jiracloud.v3.model.ProjectRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRoleDetailsApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<List<ProjectRole>> returnType_getProjectRoleDetails = new TypeReference<List<ProjectRole>>() {};

  private final HttpClient httpClient;

  public ProjectRoleDetailsApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get project role details
   * <p>Returns all <a href=\"https://confluence.atlassian.com/x/3odKLg\">project roles</a> and the details for each role. Note that the list of project roles is common to all projects.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param currentMember <p>Whether the roles should be filtered to include only those the user is assigned to.</p>  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ProjectRole&gt;&gt;
   */
  public Single<List<ProjectRole>> getProjectRoleDetails(
    String projectIdOrKey, Optional<Boolean> currentMember, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/{projectIdOrKey}/roledetails");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (currentMember.isPresent()) {
      queryParams.put("currentMember", Collections.singleton(String.valueOf(currentMember.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getProjectRoleDetails);
  }

}
