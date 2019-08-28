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

import org.openapitools.client.model.HierarchyOutputFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class HierarchyApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<HierarchyOutputFragment> returnType_getHierarchy = new TypeReference<HierarchyOutputFragment>() {};


  private final HttpClient httpClient;

  public HierarchyApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get the hierarchy
   * <p>Get the project hierarchy.</p> 
   * @param projectId <p>The ID of the project.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;HierarchyOutputFragment&gt;
   */
  public Single<HierarchyOutputFragment> getHierarchy(
    Long projectId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectId}/hierarchy";
    if (projectId != null) {
      request.pathParams.put("projectId", String.valueOf(projectId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getHierarchy);
  }

}
