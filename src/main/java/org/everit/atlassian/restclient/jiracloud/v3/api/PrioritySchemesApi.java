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

import org.everit.atlassian.restclient.jiracloud.v3.model.CreatePrioritySchemeDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanPrioritySchemeWithPaginatedPrioritiesAndProjects;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanPriorityWithSequence;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanProject;
import org.everit.atlassian.restclient.jiracloud.v3.model.PrioritySchemeId;
import org.everit.atlassian.restclient.jiracloud.v3.model.SuggestedMappingsRequestBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.UpdatePrioritySchemeRequestBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.UpdatePrioritySchemeResponseBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrioritySchemesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PrioritySchemeId> returnType_createPriorityScheme = new TypeReference<PrioritySchemeId>() {};

  private static final TypeReference<Object> returnType_deletePriorityScheme = new TypeReference<Object>() {};

  private static final TypeReference<PageBeanPriorityWithSequence> returnType_getAvailablePrioritiesByPriorityScheme = new TypeReference<PageBeanPriorityWithSequence>() {};

  private static final TypeReference<PageBeanPriorityWithSequence> returnType_getPrioritiesByPriorityScheme = new TypeReference<PageBeanPriorityWithSequence>() {};

  private static final TypeReference<PageBeanPrioritySchemeWithPaginatedPrioritiesAndProjects> returnType_getPrioritySchemes = new TypeReference<PageBeanPrioritySchemeWithPaginatedPrioritiesAndProjects>() {};

  private static final TypeReference<PageBeanProject> returnType_getProjectsByPriorityScheme = new TypeReference<PageBeanProject>() {};

  private static final TypeReference<PageBeanPriorityWithSequence> returnType_suggestedPrioritiesForMappings = new TypeReference<PageBeanPriorityWithSequence>() {};

  private static final TypeReference<UpdatePrioritySchemeResponseBean> returnType_updatePriorityScheme = new TypeReference<UpdatePrioritySchemeResponseBean>() {};

  private final RestClient restClient;

  public PrioritySchemesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create priority scheme
   * Creates a new priority scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param createPrioritySchemeDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PrioritySchemeId&gt;
   */
  public Single<PrioritySchemeId> createPriorityScheme(
    CreatePrioritySchemeDetails createPrioritySchemeDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priorityscheme");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(createPrioritySchemeDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createPriorityScheme);
  }

  /**
   * Delete priority scheme
   * Deletes a priority scheme.  This operation is only available for priority schemes without any associated projects. Any associated projects must be removed from the priority scheme before this operation can be performed.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param schemeId The priority scheme ID. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deletePriorityScheme(
    Long schemeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priorityscheme/{schemeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("schemeId", String.valueOf(schemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deletePriorityScheme);
  }

  /**
   * Get available priorities by priority scheme
   * Returns a [paginated](#pagination) list of priorities available for adding to a priority scheme.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param schemeId The priority scheme ID. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param query The string to query priorities on by name. (optional, default to &quot;&quot;)
   * @param exclude A list of priority IDs to exclude from the results. (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanPriorityWithSequence&gt;
   */
  public Single<PageBeanPriorityWithSequence> getAvailablePrioritiesByPriorityScheme(
    String schemeId, Optional<String> startAt, Optional<String> maxResults, Optional<String> query, Optional<List<String>> exclude, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priorityscheme/priorities/available");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    queryParams.put("schemeId", Collections.singleton(String.valueOf(schemeId)));
    if (exclude.isPresent()) {
      queryParams.put("exclude", RestClientUtil.objectCollectionToStringCollection(exclude.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAvailablePrioritiesByPriorityScheme);
  }

  /**
   * Get priorities by priority scheme
   * Returns a [paginated](#pagination) list of priorities by scheme.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param schemeId The priority scheme ID. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanPriorityWithSequence&gt;
   */
  public Single<PageBeanPriorityWithSequence> getPrioritiesByPriorityScheme(
    String schemeId, Optional<String> startAt, Optional<String> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priorityscheme/{schemeId}/priorities");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("schemeId", String.valueOf(schemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPrioritiesByPriorityScheme);
  }

  /**
   * Get priority schemes
   * Returns a [paginated](#pagination) list of priority schemes.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param priorityId A set of priority IDs to filter by. To include multiple IDs, provide an ampersand-separated list. For example, `priorityId=10000&priorityId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param schemeId A set of priority scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, `schemeId=10000&schemeId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param schemeName The name of scheme to search for. (optional, default to &quot;&quot;)
   * @param onlyDefault Whether only the default priority is returned. (optional, default to false)
   * @param orderBy The ordering to return the priority schemes by. (optional, default to +name)
   * @param expand A comma separated list of additional information to return. \"priorities\" will return priorities associated with the priority scheme. \"projects\" will return projects associated with the priority scheme. `expand=priorities,projects`. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanPrioritySchemeWithPaginatedPrioritiesAndProjects&gt;
   */
  public Single<PageBeanPrioritySchemeWithPaginatedPrioritiesAndProjects> getPrioritySchemes(
    Optional<String> startAt, Optional<String> maxResults, Optional<List<Long>> priorityId, Optional<List<Long>> schemeId, Optional<String> schemeName, Optional<Boolean> onlyDefault, Optional<String> orderBy, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priorityscheme");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (priorityId.isPresent()) {
      queryParams.put("priorityId", RestClientUtil.objectCollectionToStringCollection(priorityId.get()));
    }
    if (schemeId.isPresent()) {
      queryParams.put("schemeId", RestClientUtil.objectCollectionToStringCollection(schemeId.get()));
    }
    if (schemeName.isPresent()) {
      queryParams.put("schemeName", Collections.singleton(String.valueOf(schemeName.get())));
    }
    if (onlyDefault.isPresent()) {
      queryParams.put("onlyDefault", Collections.singleton(String.valueOf(onlyDefault.get())));
    }
    if (orderBy.isPresent()) {
      queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPrioritySchemes);
  }

  /**
   * Get projects by priority scheme
   * Returns a [paginated](#pagination) list of projects by scheme.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param schemeId The priority scheme ID. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param projectId The project IDs to filter by. For example, `projectId=10000&projectId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param query The string to query projects on by name. (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanProject&gt;
   */
  public Single<PageBeanProject> getProjectsByPriorityScheme(
    String schemeId, Optional<String> startAt, Optional<String> maxResults, Optional<List<Long>> projectId, Optional<String> query, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priorityscheme/{schemeId}/projects");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("schemeId", String.valueOf(schemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (projectId.isPresent()) {
      queryParams.put("projectId", RestClientUtil.objectCollectionToStringCollection(projectId.get()));
    }
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getProjectsByPriorityScheme);
  }

  /**
   * Suggested priorities for mappings
   * Returns a [paginated](#pagination) list of priorities that would require mapping, given a change in priorities or projects associated with a priority scheme.  **[Permissions](#permissions) required:** Permission to access Jira.
   * @param suggestedMappingsRequestBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanPriorityWithSequence&gt;
   */
  public Single<PageBeanPriorityWithSequence> suggestedPrioritiesForMappings(
    SuggestedMappingsRequestBean suggestedMappingsRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priorityscheme/mappings");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(suggestedMappingsRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_suggestedPrioritiesForMappings);
  }

  /**
   * Update priority scheme
   * Updates a priority scheme. This includes its details, the lists of priorities and projects in it  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param schemeId The ID of the priority scheme. (required)
   * @param updatePrioritySchemeRequestBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;UpdatePrioritySchemeResponseBean&gt;
   */
  public Single<UpdatePrioritySchemeResponseBean> updatePriorityScheme(
    Long schemeId, UpdatePrioritySchemeRequestBean updatePrioritySchemeRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/priorityscheme/{schemeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("schemeId", String.valueOf(schemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(updatePrioritySchemeRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updatePriorityScheme);
  }

}
