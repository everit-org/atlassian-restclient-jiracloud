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
package org.everit.atlassian.restclient.jiracloud.v2.api;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.jiracloud.v2.model.AddAtlassianTeamRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.CreatePlanOnlyTeamRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.GetAtlassianTeamResponse;
import org.everit.atlassian.restclient.jiracloud.v2.model.GetPlanOnlyTeamResponse;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageWithCursorGetTeamResponseForPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamsInPlanApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_addAtlassianTeam = new TypeReference<Object>() {};

  private static final TypeReference<Long> returnType_createPlanOnlyTeam = new TypeReference<Long>() {};

  private static final TypeReference<Object> returnType_deletePlanOnlyTeam = new TypeReference<Object>() {};

  private static final TypeReference<GetAtlassianTeamResponse> returnType_getAtlassianTeam = new TypeReference<GetAtlassianTeamResponse>() {};

  private static final TypeReference<GetPlanOnlyTeamResponse> returnType_getPlanOnlyTeam = new TypeReference<GetPlanOnlyTeamResponse>() {};

  private static final TypeReference<PageWithCursorGetTeamResponseForPage> returnType_getTeams = new TypeReference<PageWithCursorGetTeamResponseForPage>() {};

  private static final TypeReference<Object> returnType_removeAtlassianTeam = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateAtlassianTeam = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updatePlanOnlyTeam = new TypeReference<Object>() {};

  private final RestClient restClient;

  public TeamsInPlanApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add Atlassian team to plan
   * Adds an existing Atlassian team to a plan and configures their plannning settings.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param addAtlassianTeamRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> addAtlassianTeam(
    Long planId, AddAtlassianTeamRequest addAtlassianTeamRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/team/atlassian");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(addAtlassianTeamRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addAtlassianTeam);
  }

  /**
   * Create plan-only team
   * Creates a plan-only team and configures their planning settings.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param createPlanOnlyTeamRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Long&gt;
   */
  public Single<Long> createPlanOnlyTeam(
    Long planId, CreatePlanOnlyTeamRequest createPlanOnlyTeamRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/team/planonly");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(createPlanOnlyTeamRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createPlanOnlyTeam);
  }

  /**
   * Delete plan-only team
   * Deletes a plan-only team and their planning settings.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param planOnlyTeamId The ID of the plan-only team. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deletePlanOnlyTeam(
    Long planId, Long planOnlyTeamId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/team/planonly/{planOnlyTeamId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    pathParams.put("planOnlyTeamId", String.valueOf(planOnlyTeamId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deletePlanOnlyTeam);
  }

  /**
   * Get Atlassian team in plan
   * Returns planning settings for an Atlassian team in a plan.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param atlassianTeamId The ID of the Atlassian team. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;GetAtlassianTeamResponse&gt;
   */
  public Single<GetAtlassianTeamResponse> getAtlassianTeam(
    Long planId, String atlassianTeamId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/team/atlassian/{atlassianTeamId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    pathParams.put("atlassianTeamId", String.valueOf(atlassianTeamId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAtlassianTeam);
  }

  /**
   * Get plan-only team
   * Returns planning settings for a plan-only team.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param planOnlyTeamId The ID of the plan-only team. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;GetPlanOnlyTeamResponse&gt;
   */
  public Single<GetPlanOnlyTeamResponse> getPlanOnlyTeam(
    Long planId, Long planOnlyTeamId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/team/planonly/{planOnlyTeamId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    pathParams.put("planOnlyTeamId", String.valueOf(planOnlyTeamId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPlanOnlyTeam);
  }

  /**
   * Get teams in plan paginated
   * Returns a [paginated](#pagination) list of plan-only and Atlassian teams in a plan.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param cursor The cursor to start from. If not provided, the first page will be returned. (optional, default to &quot;&quot;)
   * @param maxResults The maximum number of plan teams to return per page. The maximum value is 50. The default value is 50. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageWithCursorGetTeamResponseForPage&gt;
   */
  public Single<PageWithCursorGetTeamResponseForPage> getTeams(
    Long planId, Optional<String> cursor, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/team");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (cursor.isPresent()) {
      queryParams.put("cursor", Collections.singleton(String.valueOf(cursor.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getTeams);
  }

  /**
   * Remove Atlassian team from plan
   * Removes an Atlassian team from a plan and deletes their planning settings.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param atlassianTeamId The ID of the Atlassian team. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> removeAtlassianTeam(
    Long planId, String atlassianTeamId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/team/atlassian/{atlassianTeamId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    pathParams.put("atlassianTeamId", String.valueOf(atlassianTeamId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeAtlassianTeam);
  }

  /**
   * Update Atlassian team in plan
   * Updates any of the following planning settings of an Atlassian team in a plan using [JSON Patch](https://datatracker.ietf.org/doc/html/rfc6902).   *  planningStyle  *  issueSourceId  *  sprintLength  *  capacity  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *Note that \"add\" operations do not respect array indexes in target locations. Call the \"Get Atlassian team in plan\" endpoint to find out the order of array elements.*
   * @param planId The ID of the plan. (required)
   * @param atlassianTeamId The ID of the Atlassian team. (required)
   * @param body  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateAtlassianTeam(
    Long planId, String atlassianTeamId, Object body, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/team/atlassian/{atlassianTeamId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    pathParams.put("atlassianTeamId", String.valueOf(atlassianTeamId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(body));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateAtlassianTeam);
  }

  /**
   * Update plan-only team
   * Updates any of the following planning settings of a plan-only team using [JSON Patch](https://datatracker.ietf.org/doc/html/rfc6902).   *  name  *  planningStyle  *  issueSourceId  *  sprintLength  *  capacity  *  memberAccountIds  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *Note that \"add\" operations do not respect array indexes in target locations. Call the \"Get plan-only team\" endpoint to find out the order of array elements.*
   * @param planId The ID of the plan. (required)
   * @param planOnlyTeamId The ID of the plan-only team. (required)
   * @param body  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updatePlanOnlyTeam(
    Long planId, Long planOnlyTeamId, Object body, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/team/planonly/{planOnlyTeamId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    pathParams.put("planOnlyTeamId", String.valueOf(planOnlyTeamId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(body));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updatePlanOnlyTeam);
  }

}
