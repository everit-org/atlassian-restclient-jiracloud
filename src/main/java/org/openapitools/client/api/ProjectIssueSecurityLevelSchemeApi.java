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

import org.openapitools.client.model.SecurityScheme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectIssueSecurityLevelSchemeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<SecurityScheme> returnType_getIssueSecurityScheme = new TypeReference<SecurityScheme>() {};

  private final HttpClient httpClient;

  public ProjectIssueSecurityLevelSchemeApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get project issue security scheme
   * <p>Returns the <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue security scheme</a> associated with the project.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or the <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a>.</p> 
   * @param projectKeyOrId <p>The project ID or project key (case sensitive).</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SecurityScheme&gt;
   */
  public Single<SecurityScheme> getIssueSecurityScheme(
    String projectKeyOrId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/{projectKeyOrId}/issuesecuritylevelscheme");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectKeyOrId", String.valueOf(projectKeyOrId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getIssueSecurityScheme);
  }

}
