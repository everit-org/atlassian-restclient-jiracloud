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

import org.everit.atlassian.restclient.jiracloud.v3.model.SystemAvatars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvatarApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<SystemAvatars> returnType_getAllSystemAvatars = new TypeReference<SystemAvatars>() {};

  private final HttpClient httpClient;

  public AvatarApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get system avatars by type
   * <p>Returns a list of system avatar details by owner type, where the owner types are issue type, project, or user.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param type <p>The avatar type.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SystemAvatars&gt;
   */
  public Single<SystemAvatars> getAllSystemAvatars(
    String type, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/avatar/{type}/system");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("type", String.valueOf(type));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAllSystemAvatars);
  }

}
