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

import org.openapitools.client.model.SystemAvatars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

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
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SystemAvatars&gt;
   */
  public Single<SystemAvatars> getAllSystemAvatars(
    String type, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/avatar/{type}/system";
    if (type != null) {
      request.pathParams.put("type", String.valueOf(type));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllSystemAvatars);
  }

}
