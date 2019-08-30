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

import org.openapitools.client.model.ProjectIssueSecurityLevels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectSecurityLevelApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<ProjectIssueSecurityLevels> returnType_getSecurityLevelsForProject = new TypeReference<ProjectIssueSecurityLevels>() {};

  private final HttpClient httpClient;

  public ProjectSecurityLevelApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get project issue security levels
   * <p>Returns all <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue security</a> levels for the project that the user has access to.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> for the project, however, issue security levels are only returned for authenticated user with <em>Set Issue Security</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> for the project.</p> 
   * @param projectKeyOrId <p>The project ID or project key (case sensitive).</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectIssueSecurityLevels&gt;
   */
  public Single<ProjectIssueSecurityLevels> getSecurityLevelsForProject(
    String projectKeyOrId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/{projectKeyOrId}/securitylevel");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectKeyOrId", String.valueOf(projectKeyOrId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getSecurityLevelsForProject);
  }

}
