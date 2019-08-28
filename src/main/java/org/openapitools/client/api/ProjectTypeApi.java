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

import org.openapitools.client.model.ProjectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class ProjectTypeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<ProjectType> returnType_getAccessibleProjectTypeByKey = new TypeReference<ProjectType>() {};


  private static final TypeReference<List<ProjectType>> returnType_getAllProjectTypes = new TypeReference<List<ProjectType>>() {};


  private static final TypeReference<ProjectType> returnType_getProjectTypeByKey = new TypeReference<ProjectType>() {};


  private final HttpClient httpClient;

  public ProjectTypeApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get accessible project type by key
   * <p>Returns a <a href=\"https://confluence.atlassian.com/x/Var1Nw\">project type</a> if it is accessible to the user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param projectTypeKey <p>The key of the project type.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectType&gt;
   */
  public Single<ProjectType> getAccessibleProjectTypeByKey(
    String projectTypeKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/type/{projectTypeKey}/accessible";
    if (projectTypeKey != null) {
      request.pathParams.put("projectTypeKey", String.valueOf(projectTypeKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAccessibleProjectTypeByKey);
  }

  /**
   * Get all project types
   * <p>Returns all <a href=\"https://confluence.atlassian.com/x/Var1Nw\">project types</a>, whether or not the instance has a valid license for each type.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ProjectType&gt;&gt;
   */
  public Single<List<ProjectType>> getAllProjectTypes(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/type";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllProjectTypes);
  }

  /**
   * Get project type by key
   * <p>Returns a <a href=\"https://confluence.atlassian.com/x/Var1Nw\">project type</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param projectTypeKey <p>The key of the project type.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectType&gt;
   */
  public Single<ProjectType> getProjectTypeByKey(
    String projectTypeKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/type/{projectTypeKey}";
    if (projectTypeKey != null) {
      request.pathParams.put("projectTypeKey", String.valueOf(projectTypeKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getProjectTypeByKey);
  }

}
