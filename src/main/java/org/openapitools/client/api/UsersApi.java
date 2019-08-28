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

import org.openapitools.client.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class UsersApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<List<User>> returnType_getAllUsers = new TypeReference<List<User>>() {};


  private final HttpClient httpClient;

  public UsersApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get all users
   * <p>Returns a list of all (active and inactive) users.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param startAt <p>The index of the first item to return.</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return.</p>  (optional, default to 50)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;User&gt;&gt;
   */
  public Single<List<User>> getAllUsers(
    Integer startAt, Integer maxResults, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/users/search";
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllUsers);
  }

}
