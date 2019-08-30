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

import org.openapitools.client.model.IssueLinkType;
import org.openapitools.client.model.IssueLinkTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueLinkTypeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<IssueLinkType> returnType_createIssueLinkType = new TypeReference<IssueLinkType>() {};

  private static final TypeReference<IssueLinkType> returnType_getIssueLinkType = new TypeReference<IssueLinkType>() {};

  private static final TypeReference<IssueLinkTypes> returnType_getIssueLinkTypes = new TypeReference<IssueLinkTypes>() {};

  private static final TypeReference<IssueLinkType> returnType_updateIssueLinkType = new TypeReference<IssueLinkType>() {};

  private final HttpClient httpClient;

  public IssueLinkTypeApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Create issue link type
   * <p>Creates an issue link type. Use this operation to create descriptions of the reasons why issues are linked. The issue link type consists of a name and descriptions for a link's inward and outward relationships.</p> <p>To use this operation, the site must have <a href=\"https://confluence.atlassian.com/x/yoXKM\">issue linking</a> enabled.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param issueLinkType  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueLinkType&gt;
   */
  public Single<IssueLinkType> createIssueLinkType(
    IssueLinkType issueLinkType, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issueLinkType");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueLinkType));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_createIssueLinkType);
  }

  /**
   * Delete issue link type
   * <p>Deletes an issue link type.</p> <p>To use this operation, the site must have <a href=\"https://confluence.atlassian.com/x/yoXKM\">issue linking</a> enabled.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param issueLinkTypeId <p>The ID of the issue link type.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteIssueLinkType(
    String issueLinkTypeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issueLinkType/{issueLinkTypeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueLinkTypeId", String.valueOf(issueLinkTypeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get issue link type
   * <p>Returns an issue link type.</p> <p>To use this operation, the site must have <a href=\"https://confluence.atlassian.com/x/yoXKM\">issue linking</a> enabled.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for a project in the site.</p> 
   * @param issueLinkTypeId <p>The ID of the issue link type.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueLinkType&gt;
   */
  public Single<IssueLinkType> getIssueLinkType(
    String issueLinkTypeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issueLinkType/{issueLinkTypeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueLinkTypeId", String.valueOf(issueLinkTypeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getIssueLinkType);
  }

  /**
   * Get issue link types
   * <p>Returns a list of all issue link types.</p> <p>To use this operation, the site must have <a href=\"https://confluence.atlassian.com/x/yoXKM\">issue linking</a> enabled.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for a project in the site.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueLinkTypes&gt;
   */
  public Single<IssueLinkTypes> getIssueLinkTypes(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issueLinkType");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getIssueLinkTypes);
  }

  /**
   * Update issue link type
   * <p>Updates an issue link type.</p> <p>To use this operation, the site must have <a href=\"https://confluence.atlassian.com/x/yoXKM\">issue linking</a> enabled.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param issueLinkTypeId <p>The ID of the issue link type.</p>  (required)
   * @param issueLinkType  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueLinkType&gt;
   */
  public Single<IssueLinkType> updateIssueLinkType(
    String issueLinkTypeId, IssueLinkType issueLinkType, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issueLinkType/{issueLinkTypeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueLinkTypeId", String.valueOf(issueLinkTypeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueLinkType));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_updateIssueLinkType);
  }

}
