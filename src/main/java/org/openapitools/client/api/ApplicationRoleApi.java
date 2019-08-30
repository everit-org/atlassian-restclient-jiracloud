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

import org.openapitools.client.model.ApplicationRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationRoleApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<List<ApplicationRole>> returnType_getAllApplicationRoles = new TypeReference<List<ApplicationRole>>() {};

  private static final TypeReference<ApplicationRole> returnType_getApplicationRole = new TypeReference<ApplicationRole>() {};

  private final HttpClient httpClient;

  public ApplicationRoleApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get all application roles
   * <p>Returns all application roles. In Jira, application roles are managed using the <a href=\"https://confluence.atlassian.com/x/3YxjL\">Application access configuration</a> page.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ApplicationRole&gt;&gt;
   */
  public Single<List<ApplicationRole>> getAllApplicationRoles(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/applicationrole");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAllApplicationRoles);
  }

  /**
   * Get application role
   * <p>Returns an application role.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param key <p>The key of the application role. Use the <a href=\"#api-rest-api-3-applicationrole-get\">Get all application roles</a> operation to get the key for each application role.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ApplicationRole&gt;
   */
  public Single<ApplicationRole> getApplicationRole(
    String key, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/applicationrole/{key}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("key", String.valueOf(key));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getApplicationRole);
  }

}
