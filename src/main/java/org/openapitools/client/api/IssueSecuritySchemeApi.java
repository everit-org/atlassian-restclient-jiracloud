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

import org.openapitools.client.model.SecurityScheme;
import org.openapitools.client.model.SecuritySchemes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

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
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SecurityScheme&gt;
   */
  public Single<SecurityScheme> getIssueSecurityScheme(
    Long id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuesecurityschemes/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueSecurityScheme);
  }

  /**
   * Get issue security schemes
   * <p>Returns all <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue security schemes</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SecuritySchemes&gt;
   */
  public Single<SecuritySchemes> getIssueSecuritySchemes(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuesecurityschemes";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueSecuritySchemes);
  }

}
