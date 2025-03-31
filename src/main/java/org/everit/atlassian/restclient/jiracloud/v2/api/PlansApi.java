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

import org.everit.atlassian.restclient.jiracloud.v2.model.CreatePlanRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.DuplicatePlanRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.GetPlanResponse;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageWithCursorGetPlanResponseForPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlansApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_archivePlan = new TypeReference<Object>() {};

  private static final TypeReference<Long> returnType_createPlan = new TypeReference<Long>() {};

  private static final TypeReference<Long> returnType_duplicatePlan = new TypeReference<Long>() {};

  private static final TypeReference<GetPlanResponse> returnType_getPlan = new TypeReference<GetPlanResponse>() {};

  private static final TypeReference<PageWithCursorGetPlanResponseForPage> returnType_getPlans = new TypeReference<PageWithCursorGetPlanResponseForPage>() {};

  private static final TypeReference<Object> returnType_trashPlan = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updatePlan = new TypeReference<Object>() {};

  private final RestClient restClient;

  public PlansApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Archive plan
   * Archives a plan.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> archivePlan(
    Long planId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/archive");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_archivePlan);
  }

  /**
   * Create plan
   * Creates a plan.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param createPlanRequest  (required)
   * @param useGroupId Whether to accept group IDs instead of group names. Group names are deprecated. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Long&gt;
   */
  public Single<Long> createPlan(
    CreatePlanRequest createPlanRequest, Optional<Boolean> useGroupId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (useGroupId.isPresent()) {
      queryParams.put("useGroupId", Collections.singleton(String.valueOf(useGroupId.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(createPlanRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createPlan);
  }

  /**
   * Duplicate plan
   * Duplicates a plan.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param duplicatePlanRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Long&gt;
   */
  public Single<Long> duplicatePlan(
    Long planId, DuplicatePlanRequest duplicatePlanRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/duplicate");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(duplicatePlanRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_duplicatePlan);
  }

  /**
   * Get plan
   * Returns a plan.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param useGroupId Whether to return group IDs instead of group names. Group names are deprecated. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;GetPlanResponse&gt;
   */
  public Single<GetPlanResponse> getPlan(
    Long planId, Optional<Boolean> useGroupId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (useGroupId.isPresent()) {
      queryParams.put("useGroupId", Collections.singleton(String.valueOf(useGroupId.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPlan);
  }

  /**
   * Get plans paginated
   * Returns a [paginated](#pagination) list of plans.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param includeTrashed Whether to include trashed plans in the results. (optional, default to false)
   * @param includeArchived Whether to include archived plans in the results. (optional, default to false)
   * @param cursor The cursor to start from. If not provided, the first page will be returned. (optional, default to &quot;&quot;)
   * @param maxResults The maximum number of plans to return per page. The maximum value is 50. The default value is 50. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageWithCursorGetPlanResponseForPage&gt;
   */
  public Single<PageWithCursorGetPlanResponseForPage> getPlans(
    Optional<Boolean> includeTrashed, Optional<Boolean> includeArchived, Optional<String> cursor, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (includeTrashed.isPresent()) {
      queryParams.put("includeTrashed", Collections.singleton(String.valueOf(includeTrashed.get())));
    }
    if (includeArchived.isPresent()) {
      queryParams.put("includeArchived", Collections.singleton(String.valueOf(includeArchived.get())));
    }
    if (cursor.isPresent()) {
      queryParams.put("cursor", Collections.singleton(String.valueOf(cursor.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getPlans);
  }

  /**
   * Trash plan
   * Moves a plan to trash.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param planId The ID of the plan. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> trashPlan(
    Long planId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}/trash");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_trashPlan);
  }

  /**
   * Update plan
   * Updates any of the following details of a plan using [JSON Patch](https://datatracker.ietf.org/doc/html/rfc6902).   *  name  *  leadAccountId  *  scheduling           *  estimation with StoryPoints, Days or Hours as possible values      *  startDate                   *  type with DueDate, TargetStartDate, TargetEndDate or DateCustomField as possible values          *  dateCustomFieldId      *  endDate                   *  type with DueDate, TargetStartDate, TargetEndDate or DateCustomField as possible values          *  dateCustomFieldId      *  inferredDates with None, SprintDates or ReleaseDates as possible values      *  dependencies with Sequential or Concurrent as possible values  *  issueSources           *  type with Board, Project or Filter as possible values      *  value  *  exclusionRules           *  numberOfDaysToShowCompletedIssues      *  issueIds      *  workStatusIds      *  workStatusCategoryIds      *  issueTypeIds      *  releaseIds  *  crossProjectReleases           *  name      *  releaseIds  *  customFields           *  customFieldId      *  filter  *  permissions           *  type with View or Edit as possible values      *  holder                   *  type with Group or AccountId as possible values          *  value  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *Note that \"add\" operations do not respect array indexes in target locations. Call the \"Get plan\" endpoint to find out the order of array elements.*
   * @param planId The ID of the plan. (required)
   * @param body  (required)
   * @param useGroupId Whether to accept group IDs instead of group names. Group names are deprecated. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updatePlan(
    Long planId, Object body, Optional<Boolean> useGroupId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/plans/plan/{planId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("planId", String.valueOf(planId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (useGroupId.isPresent()) {
      queryParams.put("useGroupId", Collections.singleton(String.valueOf(useGroupId.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(body));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updatePlan);
  }

}
