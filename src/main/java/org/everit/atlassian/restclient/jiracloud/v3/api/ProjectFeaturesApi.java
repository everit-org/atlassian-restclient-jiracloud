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

import org.everit.atlassian.restclient.jiracloud.v3.model.ContainerForProjectFeatures;
import org.everit.atlassian.restclient.jiracloud.v3.model.ProjectFeatureState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectFeaturesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<ContainerForProjectFeatures> returnType_getFeaturesForProject = new TypeReference<ContainerForProjectFeatures>() {};

  private static final TypeReference<ContainerForProjectFeatures> returnType_toggleFeatureForProject = new TypeReference<ContainerForProjectFeatures>() {};

  private final RestClient restClient;

  public ProjectFeaturesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get project features
   * Returns the list of features for a project.
   * @param projectIdOrKey The ID or (case-sensitive) key of the project. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ContainerForProjectFeatures&gt;
   */
  public Single<ContainerForProjectFeatures> getFeaturesForProject(
    String projectIdOrKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/{projectIdOrKey}/features");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getFeaturesForProject);
  }

  /**
   * Set project feature state
   * Sets the state of a project feature.
   * @param projectIdOrKey The ID or (case-sensitive) key of the project. (required)
   * @param featureKey The key of the feature. (required)
   * @param projectFeatureState Details of the feature state change. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ContainerForProjectFeatures&gt;
   */
  public Single<ContainerForProjectFeatures> toggleFeatureForProject(
    String projectIdOrKey, String featureKey, ProjectFeatureState projectFeatureState, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/project/{projectIdOrKey}/features/{featureKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    pathParams.put("featureKey", String.valueOf(featureKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(projectFeatureState));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_toggleFeatureForProject);
  }

}
