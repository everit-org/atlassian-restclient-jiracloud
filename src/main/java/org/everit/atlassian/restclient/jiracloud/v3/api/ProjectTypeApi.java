/*
 * Copyright © 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.atlassian.restclient.jiracloud.v3.api;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.jiracloud.v3.model.ProjectType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectTypeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<ProjectType> returnType_getAccessibleProjectTypeByKey = new TypeReference<ProjectType>() {};

  private static final TypeReference<List<ProjectType>> returnType_getAllProjectTypes = new TypeReference<List<ProjectType>>() {};

  private static final TypeReference<ProjectType> returnType_getProjectTypeByKey = new TypeReference<ProjectType>() {};

  private final RestClient restClient;

  public ProjectTypeApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get accessible project type by key
   * <p>Returns a <a href=\"https://confluence.atlassian.com/x/Var1Nw\">project type</a> if it is accessible to the user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param projectTypeKey <p>The key of the project type.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectType&gt;
   */
  public Single<ProjectType> getAccessibleProjectTypeByKey(
    String projectTypeKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/type/{projectTypeKey}/accessible");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectTypeKey", String.valueOf(projectTypeKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAccessibleProjectTypeByKey);
  }

  /**
   * Get all project types
   * <p>Returns all <a href=\"https://confluence.atlassian.com/x/Var1Nw\">project types</a>, whether or not the instance has a valid license for each type.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ProjectType&gt;&gt;
   */
  public Single<List<ProjectType>> getAllProjectTypes(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/type");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllProjectTypes);
  }

  /**
   * Get project type by key
   * <p>Returns a <a href=\"https://confluence.atlassian.com/x/Var1Nw\">project type</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param projectTypeKey <p>The key of the project type.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectType&gt;
   */
  public Single<ProjectType> getProjectTypeByKey(
    String projectTypeKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/type/{projectTypeKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectTypeKey", String.valueOf(projectTypeKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getProjectTypeByKey);
  }

}
