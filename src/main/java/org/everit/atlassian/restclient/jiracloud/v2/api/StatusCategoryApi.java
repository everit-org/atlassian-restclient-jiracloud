package org.everit.atlassian.restclient.jiracloud.v2.api;

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

import org.everit.atlassian.restclient.jiracloud.v2.model.StatusCategory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusCategoryApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<List<StatusCategory>> returnType_getStatusCategories = new TypeReference<List<StatusCategory>>() {};

  private static final TypeReference<StatusCategory> returnType_getStatusCategory = new TypeReference<StatusCategory>() {};

  private final HttpClient httpClient;

  public StatusCategoryApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get all status categories
   * <p>Returns a list of all status categories.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;StatusCategory&gt;&gt;
   */
  public Single<List<StatusCategory>> getStatusCategories(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/statuscategory");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getStatusCategories);
  }

  /**
   * Get status category
   * <p>Returns a status category. Status categories provided a mechanism for categorizing <a href=\"#api-rest-api-2-status-idOrName-get\">statuses</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param idOrKey <p>The ID or key of the status category.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;StatusCategory&gt;
   */
  public Single<StatusCategory> getStatusCategory(
    String idOrKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/statuscategory/{idOrKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("idOrKey", String.valueOf(idOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getStatusCategory);
  }

}
