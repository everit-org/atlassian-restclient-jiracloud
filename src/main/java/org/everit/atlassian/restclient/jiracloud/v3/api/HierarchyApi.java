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

import org.everit.atlassian.restclient.jiracloud.v3.model.HierarchyOutputFragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;HierarchyOutputFragment&gt;
   */
  public Single<HierarchyOutputFragment> getHierarchy(
    Long projectId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/{projectId}/hierarchy");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectId", String.valueOf(projectId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getHierarchy);
  }

}
