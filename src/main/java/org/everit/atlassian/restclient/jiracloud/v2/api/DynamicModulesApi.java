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

import org.everit.atlassian.restclient.jiracloud.v2.model.ConnectModules;
import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicModulesApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<ConnectModules> returnType_getModules = new TypeReference<ConnectModules>() {};

  private final HttpClient httpClient;

  public DynamicModulesApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get modules
   * <p>Returns all modules registered dynamically by the calling app.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only Connect apps can make this request.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ConnectModules&gt;
   */
  public Single<ConnectModules> getModules(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/atlassian-connect/1/app/module/dynamic");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getModules);
  }

  /**
   * Register modules
   * <p>Registers a list of modules.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only Connect apps can make this request.</p> 
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable registerModules(
    ConnectModules requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/atlassian-connect/1/app/module/dynamic");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Remove modules
   * <p>Remove all or a list of modules registered by the calling app.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only Connect apps can make this request.</p> 
   * @param moduleKey <p>The key of the module to remove. To include multiple module keys, provide multiple copies of this parameter. For example, <code>moduleKey=dynamic-attachment-entity-property&amp;moduleKey=dynamic-select-field</code>. Nonexistent keys are ignored.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeModules(
    Optional<List<String>> moduleKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/atlassian-connect/1/app/module/dynamic");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (moduleKey.isPresent()) {
      queryParams.put("moduleKey", RestCallUtil.objectCollectionToStringCollection(moduleKey.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

}
