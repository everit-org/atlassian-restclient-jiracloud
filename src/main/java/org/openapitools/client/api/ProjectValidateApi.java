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

import org.openapitools.client.model.ErrorCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class ProjectValidateApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<String> returnType_getValidProjectKey = new TypeReference<String>() {};


  private static final TypeReference<String> returnType_getValidProjectName = new TypeReference<String>() {};


  private static final TypeReference<ErrorCollection> returnType_validateProjectKey = new TypeReference<ErrorCollection>() {};


  private final HttpClient httpClient;

  public ProjectValidateApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get valid project key
   * <p>Validates a project key and, if the key is invalid or in use, generates a valid random string for the project key.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param key <p>The project key.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;String&gt;
   */
  public Single<String> getValidProjectKey(
    String key, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/projectvalidate/validProjectKey";
    if (key != null) {
      request.queryParams.put("key", Collections.singleton(String.valueOf(key)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getValidProjectKey);
  }

  /**
   * Get valid project name
   * <p>Checks that a project name isn't in use. If the name isn't in use, the passed string is returned. If the name is in use, this operation attempts to generate a valid project name based on the one supplied, usually by adding a sequence number. If a valid project name cannot be generated, a 404 response is returned.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param name <p>The project name.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;String&gt;
   */
  public Single<String> getValidProjectName(
    String name, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/projectvalidate/validProjectName";
    if (name != null) {
      request.queryParams.put("name", Collections.singleton(String.valueOf(name)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getValidProjectName);
  }

  /**
   * Validate project key
   * <p>Validates a project key by confirming the key is a valid string and not in use.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param key <p>The project key.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ErrorCollection&gt;
   */
  public Single<ErrorCollection> validateProjectKey(
    String key, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/projectvalidate/key";
    if (key != null) {
      request.queryParams.put("key", Collections.singleton(String.valueOf(key)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_validateProjectKey);
  }

}
