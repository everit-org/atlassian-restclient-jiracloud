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

import org.everit.atlassian.restclient.jiracloud.v3.model.DefaultWorkflow;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueTypeWorkflowMapping;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueTypesWorkflowMapping;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanWorkflowScheme;
import org.everit.atlassian.restclient.jiracloud.v3.model.TaskProgressBeanObject;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowScheme;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowSchemeProjectUsageDTO;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowSchemeReadRequest;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowSchemeReadResponse;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowSchemeUpdateRequiredMappingsRequest;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowSchemeUpdateRequiredMappingsResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkflowSchemesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<WorkflowScheme> returnType_createWorkflowScheme = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_deleteDefaultWorkflow = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<Object> returnType_deleteWorkflowScheme = new TypeReference<Object>() {};

  private static final TypeReference<WorkflowScheme> returnType_deleteWorkflowSchemeIssueType = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<PageBeanWorkflowScheme> returnType_getAllWorkflowSchemes = new TypeReference<PageBeanWorkflowScheme>() {};

  private static final TypeReference<DefaultWorkflow> returnType_getDefaultWorkflow = new TypeReference<DefaultWorkflow>() {};

  private static final TypeReference<WorkflowSchemeProjectUsageDTO> returnType_getProjectUsagesForWorkflowScheme = new TypeReference<WorkflowSchemeProjectUsageDTO>() {};

  private static final TypeReference<IssueTypesWorkflowMapping> returnType_getWorkflow = new TypeReference<IssueTypesWorkflowMapping>() {};

  private static final TypeReference<WorkflowScheme> returnType_getWorkflowScheme = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<IssueTypeWorkflowMapping> returnType_getWorkflowSchemeIssueType = new TypeReference<IssueTypeWorkflowMapping>() {};

  private static final TypeReference<List<WorkflowSchemeReadResponse>> returnType_readWorkflowSchemes = new TypeReference<List<WorkflowSchemeReadResponse>>() {};

  private static final TypeReference<WorkflowScheme> returnType_setWorkflowSchemeIssueType = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateDefaultWorkflow = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<Object> returnType_updateSchemes = new TypeReference<Object>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateWorkflowMapping = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateWorkflowScheme = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowSchemeUpdateRequiredMappingsResponse> returnType_updateWorkflowSchemeMappings = new TypeReference<WorkflowSchemeUpdateRequiredMappingsResponse>() {};

  private final RestClient restClient;

  public WorkflowSchemesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create workflow scheme
   * Creates a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param workflowScheme  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> createWorkflowScheme(
    WorkflowScheme workflowScheme, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(workflowScheme));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createWorkflowScheme);
  }

  /**
   * Delete default workflow
   * Resets the default workflow for a workflow scheme. That is, the default workflow is set to Jira's system workflow (the *jira* workflow).  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set `updateDraftIfNeeded` to `true` and a draft workflow scheme is created or updated with the default workflow reset. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. (required)
   * @param updateDraftIfNeeded Set to true to create or update the draft of a workflow scheme and delete the mapping from the draft, when the workflow scheme cannot be edited. Defaults to `false`. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> deleteDefaultWorkflow(
    Long id, Optional<Boolean> updateDraftIfNeeded, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}/default");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (updateDraftIfNeeded.isPresent()) {
      queryParams.put("updateDraftIfNeeded", Collections.singleton(String.valueOf(updateDraftIfNeeded.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteDefaultWorkflow);
  }

  /**
   * Delete issue types for workflow in workflow scheme
   * Deletes the workflow-issue type mapping for a workflow in a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set `updateDraftIfNeeded` to `true` and a draft workflow scheme is created or updated with the workflow-issue type mapping deleted. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. (required)
   * @param workflowName The name of the workflow. (required)
   * @param updateDraftIfNeeded Set to true to create or update the draft of a workflow scheme and delete the mapping from the draft, when the workflow scheme cannot be edited. Defaults to `false`. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteWorkflowMapping(
    Long id, String workflowName, Optional<Boolean> updateDraftIfNeeded, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}/workflow");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    if (updateDraftIfNeeded.isPresent()) {
      queryParams.put("updateDraftIfNeeded", Collections.singleton(String.valueOf(updateDraftIfNeeded.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Delete workflow scheme
   * Deletes a workflow scheme. Note that a workflow scheme cannot be deleted if it is active (that is, being used by at least one project).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as `schemeId`. For example, *schemeId=10301*. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteWorkflowScheme(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteWorkflowScheme);
  }

  /**
   * Delete workflow for issue type in workflow scheme
   * Deletes the issue type-workflow mapping for an issue type in a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set `updateDraftIfNeeded` to `true` and a draft workflow scheme is created or updated with the issue type-workflow mapping deleted. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. (required)
   * @param issueType The ID of the issue type. (required)
   * @param updateDraftIfNeeded Set to true to create or update the draft of a workflow scheme and update the mapping in the draft, when the workflow scheme cannot be edited. Defaults to `false`. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> deleteWorkflowSchemeIssueType(
    Long id, String issueType, Optional<Boolean> updateDraftIfNeeded, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}/issuetype/{issueType}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    pathParams.put("issueType", String.valueOf(issueType));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (updateDraftIfNeeded.isPresent()) {
      queryParams.put("updateDraftIfNeeded", Collections.singleton(String.valueOf(updateDraftIfNeeded.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteWorkflowSchemeIssueType);
  }

  /**
   * Get all workflow schemes
   * Returns a [paginated](#pagination) list of all workflow schemes, not including draft workflow schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanWorkflowScheme&gt;
   */
  public Single<PageBeanWorkflowScheme> getAllWorkflowSchemes(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme");

    Map<String, String> pathParams = new HashMap<>();
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllWorkflowSchemes);
  }

  /**
   * Get default workflow
   * Returns the default workflow for a workflow scheme. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has *All Unassigned Issue Types* listed in its issue types for the workflow scheme in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. (required)
   * @param returnDraftIfExists Set to `true` to return the default workflow for the workflow scheme's draft rather than scheme itself. If the workflow scheme does not have a draft, then the default workflow for the workflow scheme is returned. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;DefaultWorkflow&gt;
   */
  public Single<DefaultWorkflow> getDefaultWorkflow(
    Long id, Optional<Boolean> returnDraftIfExists, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}/default");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (returnDraftIfExists.isPresent()) {
      queryParams.put("returnDraftIfExists", Collections.singleton(String.valueOf(returnDraftIfExists.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getDefaultWorkflow);
  }

  /**
   * Get projects which are using a given workflow scheme
   * Returns a page of projects using a given workflow scheme.
   * @param workflowSchemeId The workflow scheme ID (required)
   * @param nextPageToken The cursor for pagination (optional)
   * @param maxResults The maximum number of results to return. Must be an integer between 1 and 200. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowSchemeProjectUsageDTO&gt;
   */
  public Single<WorkflowSchemeProjectUsageDTO> getProjectUsagesForWorkflowScheme(
    String workflowSchemeId, Optional<String> nextPageToken, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{workflowSchemeId}/projectUsages");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("workflowSchemeId", String.valueOf(workflowSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (nextPageToken.isPresent()) {
      queryParams.put("nextPageToken", Collections.singleton(String.valueOf(nextPageToken.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getProjectUsagesForWorkflowScheme);
  }

  /**
   * Get issue types for workflows in workflow scheme
   * Returns the workflow-issue type mappings for a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. (required)
   * @param workflowName The name of a workflow in the scheme. Limits the results to the workflow-issue type mapping for the specified workflow. (optional)
   * @param returnDraftIfExists Returns the mapping from the workflow scheme's draft rather than the workflow scheme, if set to true. If no draft exists, the mapping from the workflow scheme is returned. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypesWorkflowMapping&gt;
   */
  public Single<IssueTypesWorkflowMapping> getWorkflow(
    Long id, Optional<String> workflowName, Optional<Boolean> returnDraftIfExists, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}/workflow");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (workflowName.isPresent()) {
      queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName.get())));
    }
    if (returnDraftIfExists.isPresent()) {
      queryParams.put("returnDraftIfExists", Collections.singleton(String.valueOf(returnDraftIfExists.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getWorkflow);
  }

  /**
   * Get workflow scheme
   * Returns a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as `schemeId`. For example, *schemeId=10301*. (required)
   * @param returnDraftIfExists Returns the workflow scheme's draft rather than scheme itself, if set to true. If the workflow scheme does not have a draft, then the workflow scheme is returned. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> getWorkflowScheme(
    Long id, Optional<Boolean> returnDraftIfExists, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (returnDraftIfExists.isPresent()) {
      queryParams.put("returnDraftIfExists", Collections.singleton(String.valueOf(returnDraftIfExists.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getWorkflowScheme);
  }

  /**
   * Get workflow for issue type in workflow scheme
   * Returns the issue type-workflow mapping for an issue type in a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. (required)
   * @param issueType The ID of the issue type. (required)
   * @param returnDraftIfExists Returns the mapping from the workflow scheme's draft rather than the workflow scheme, if set to true. If no draft exists, the mapping from the workflow scheme is returned. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeWorkflowMapping&gt;
   */
  public Single<IssueTypeWorkflowMapping> getWorkflowSchemeIssueType(
    Long id, String issueType, Optional<Boolean> returnDraftIfExists, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}/issuetype/{issueType}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    pathParams.put("issueType", String.valueOf(issueType));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (returnDraftIfExists.isPresent()) {
      queryParams.put("returnDraftIfExists", Collections.singleton(String.valueOf(returnDraftIfExists.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getWorkflowSchemeIssueType);
  }

  /**
   * Bulk get workflow schemes
   * Returns a list of workflow schemes by providing workflow scheme IDs or project IDs.  **[Permissions](#permissions) required:**   *  *Administer Jira* global permission to access all, including project-scoped, workflow schemes  *  *Administer projects* project permissions to access project-scoped workflow schemes
   * @param workflowSchemeReadRequest  (required)
   * @param expand Deprecated. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/changelog/#CHANGE-2298) for details.  Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `workflows.usages` Returns the project and issue types that each workflow in the workflow scheme is associated with. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;WorkflowSchemeReadResponse&gt;&gt;
   */
  public Single<List<WorkflowSchemeReadResponse>> readWorkflowSchemes(
    WorkflowSchemeReadRequest workflowSchemeReadRequest, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/read");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(workflowSchemeReadRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_readWorkflowSchemes);
  }

  /**
   * Set workflow for issue type in workflow scheme
   * Sets the workflow for an issue type in a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set `updateDraftIfNeeded` to `true` in the request body and a draft workflow scheme is created or updated with the new issue type-workflow mapping. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. (required)
   * @param issueType The ID of the issue type. (required)
   * @param issueTypeWorkflowMapping The issue type-project mapping. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> setWorkflowSchemeIssueType(
    Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}/issuetype/{issueType}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    pathParams.put("issueType", String.valueOf(issueType));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeWorkflowMapping));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setWorkflowSchemeIssueType);
  }

  /**
   * Update default workflow
   * Sets the default workflow for a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set `updateDraftIfNeeded` to `true` in the request object and a draft workflow scheme is created or updated with the new default workflow. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. (required)
   * @param defaultWorkflow The new default workflow. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> updateDefaultWorkflow(
    Long id, DefaultWorkflow defaultWorkflow, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}/default");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(defaultWorkflow));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateDefaultWorkflow);
  }

  /**
   * Update workflow scheme
   * Updates company-managed and team-managed project workflow schemes. This API doesn't have a concept of draft, so any changes made to a workflow scheme are immediately available. When changing the available statuses for issue types, an [asynchronous task](#async) migrates the issues as defined in the provided mappings.  **[Permissions](#permissions) required:**   *  *Administer Jira* project permission to update all, including global-scoped, workflow schemes.  *  *Administer projects* project permission to update project-scoped workflow schemes.
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateSchemes(
    Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/update");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateSchemes);
  }

  /**
   * Set issue types for workflow in workflow scheme
   * Sets the issue types for a workflow in a workflow scheme. The workflow can also be set as the default workflow for the workflow scheme. Unmapped issues types are mapped to the default workflow.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set `updateDraftIfNeeded` to `true` in the request body and a draft workflow scheme is created or updated with the new workflow-issue types mappings. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. (required)
   * @param workflowName The name of the workflow. (required)
   * @param issueTypesWorkflowMapping  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> updateWorkflowMapping(
    Long id, String workflowName, IssueTypesWorkflowMapping issueTypesWorkflowMapping, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}/workflow");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypesWorkflowMapping));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateWorkflowMapping);
  }

  /**
   * Classic update workflow scheme
   * Updates a company-manged project workflow scheme, including the name, default workflow, issue type to project mappings, and more. If the workflow scheme is active (that is, being used by at least one project), then a draft workflow scheme is created or updated instead, provided that `updateDraftIfNeeded` is set to `true`.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as `schemeId`. For example, *schemeId=10301*. (required)
   * @param workflowScheme  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> updateWorkflowScheme(
    Long id, WorkflowScheme workflowScheme, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(workflowScheme));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateWorkflowScheme);
  }

  /**
   * Get required status mappings for workflow scheme update
   * Gets the required status mappings for the desired changes to a workflow scheme. The results are provided per issue type and workflow. When updating a workflow scheme, status mappings can be provided per issue type, per workflow, or both.  **[Permissions](#permissions) required:**   *  *Administer Jira* permission to update all, including global-scoped, workflow schemes.  *  *Administer projects* project permission to update project-scoped workflow schemes.
   * @param workflowSchemeUpdateRequiredMappingsRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowSchemeUpdateRequiredMappingsResponse&gt;
   */
  public Single<WorkflowSchemeUpdateRequiredMappingsResponse> updateWorkflowSchemeMappings(
    WorkflowSchemeUpdateRequiredMappingsRequest workflowSchemeUpdateRequiredMappingsRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/update/mappings");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(workflowSchemeUpdateRequiredMappingsRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateWorkflowSchemeMappings);
  }

}
