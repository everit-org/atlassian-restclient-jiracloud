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
import org.openapitools.client.model.SecuritySchemes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueSecuritySchemeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<SecurityScheme> returnType_getIssueSecurityScheme = new TypeReference<SecurityScheme>() {};

  private static final TypeReference<SecuritySchemes> returnType_getIssueSecuritySchemes = new TypeReference<SecuritySchemes>() {};

  private final HttpClient httpClient;

  public IssueSecuritySchemeApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get issue security scheme
   * <p>Returns an issue security scheme along with its security levels.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</li> <li><em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for a project that uses the requested issue security scheme.</li> </ul> 
   * @param id <p>The ID of the issue security scheme. Use the <a href=\"#api-rest-api-3-issuesecurityschemes-get\">Get issue security schemes</a> operation to get a list of issue security scheme IDs.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SecurityScheme&gt;
   */
  public Single<SecurityScheme> getIssueSecurityScheme(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getIssueSecurityScheme);
  }

  /**
   * Get issue security schemes
   * <p>Returns all <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue security schemes</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SecuritySchemes&gt;
   */
  public Single<SecuritySchemes> getIssueSecuritySchemes(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getIssueSecuritySchemes);
  }

}
