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

import org.openapitools.client.model.SecurityLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class IssueSecurityLevelApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<SecurityLevel> returnType_getIssueSecurityLevel = new TypeReference<SecurityLevel>() {};


  private final HttpClient httpClient;

  public IssueSecurityLevelApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get issue security level
   * <p>Returns details of an issue security level.</p> <p>Use <a href=\"#api-rest-api-3-issuesecurityschemes-id-get\">Get issue security scheme</a> to obtain the IDs of issue security levels associated with the issue security scheme.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param id <p>The ID of the issue security level.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SecurityLevel&gt;
   */
  public Single<SecurityLevel> getIssueSecurityLevel(
    String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/securitylevel/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueSecurityLevel);
  }

}
