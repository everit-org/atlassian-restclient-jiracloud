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

import org.everit.atlassian.restclient.jiracloud.v2.model.DefaultWorkflow;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeWorkflowMapping;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypesWorkflowMapping;
import org.everit.atlassian.restclient.jiracloud.v2.model.WorkflowScheme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkflowSchemeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<WorkflowScheme> returnType_createWorkflowScheme = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_createWorkflowSchemeDraftFromParent = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_deleteDefaultWorkflow = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_deleteDraftDefaultWorkflow = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_deleteWorkflowSchemeDraftIssueType = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_deleteWorkflowSchemeIssueType = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<DefaultWorkflow> returnType_getDefaultWorkflow = new TypeReference<DefaultWorkflow>() {};

  private static final TypeReference<DefaultWorkflow> returnType_getDraftDefaultWorkflow = new TypeReference<DefaultWorkflow>() {};

  private static final TypeReference<IssueTypesWorkflowMapping> returnType_getDraftWorkflow = new TypeReference<IssueTypesWorkflowMapping>() {};

  private static final TypeReference<IssueTypesWorkflowMapping> returnType_getWorkflow = new TypeReference<IssueTypesWorkflowMapping>() {};

  private static final TypeReference<WorkflowScheme> returnType_getWorkflowScheme = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_getWorkflowSchemeDraft = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<IssueTypeWorkflowMapping> returnType_getWorkflowSchemeDraftIssueType = new TypeReference<IssueTypeWorkflowMapping>() {};

  private static final TypeReference<IssueTypeWorkflowMapping> returnType_getWorkflowSchemeIssueType = new TypeReference<IssueTypeWorkflowMapping>() {};

  private static final TypeReference<WorkflowScheme> returnType_setWorkflowSchemeDraftIssueType = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_setWorkflowSchemeIssueType = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateDefaultWorkflow = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateDraftDefaultWorkflow = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateDraftWorkflowMapping = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateWorkflowMapping = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateWorkflowScheme = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateWorkflowSchemeDraft = new TypeReference<WorkflowScheme>() {};

  private final RestClient restClient;

  public WorkflowSchemeApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create workflow scheme
   * <p>Creates a workflow scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param workflowScheme  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> createWorkflowScheme(
    WorkflowScheme workflowScheme, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme");

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
   * Create draft workflow scheme
   * <p>Create a draft workflow scheme from an active workflow scheme, by copying the active workflow scheme. Note that an active workflow scheme can only have one draft workflow scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the active workflow scheme that the draft is created from.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> createWorkflowSchemeDraftFromParent(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/createdraft");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createWorkflowSchemeDraftFromParent);
  }

  /**
   * Delete default workflow
   * <p>Resets the default workflow for a workflow scheme. That is, the default workflow is set to Jira's system workflow (the <em>jira</em> workflow).</p> <p>Note that active workflow schemes cannot be edited. If the workflow scheme is active, set <code>updateDraftIfNeeded</code> to <code>true</code> and a draft workflow scheme is created or updated with the default workflow reset. The draft workflow scheme can be published in Jira.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme.</p>  (required)
   * @param updateDraftIfNeeded <p>Set to true to create or update the draft of a workflow scheme and delete the mapping from the draft, when the workflow scheme cannot be edited. Defaults to <code>false</code>.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> deleteDefaultWorkflow(
    Long id, Optional<Boolean> updateDraftIfNeeded, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/default");

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
   * Delete draft default workflow
   * <p>Resets the default workflow for a workflow scheme's draft. That is, the default workflow is set to Jira's system workflow (the <em>jira</em> workflow).</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme that the draft belongs to.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> deleteDraftDefaultWorkflow(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/default");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteDraftDefaultWorkflow);
  }

  /**
   * Delete issue types for workflow in draft workflow scheme
   * <p>Deletes the workflow-issue type mapping for a workflow in a workflow scheme's draft.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme that the draft belongs to.</p>  (required)
   * @param workflowName <p>The name of the workflow.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteDraftWorkflowMapping(
    Long id, Optional<String> workflowName, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/workflow");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (workflowName.isPresent()) {
      queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Delete issue types for workflow in workflow scheme
   * <p>Deletes the workflow-issue type mapping for a workflow in a workflow scheme.</p> <p>Note that active workflow schemes cannot be edited. If the workflow scheme is active, set <code>updateDraftIfNeeded</code> to <code>true</code> and a draft workflow scheme is created or updated with the workflow-issue type mapping deleted. The draft workflow scheme can be published in Jira.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme.</p>  (required)
   * @param workflowName <p>The name of the workflow.</p>  (optional)
   * @param updateDraftIfNeeded <p>Set to true to create or update the draft of a workflow scheme and delete the mapping from the draft, when the workflow scheme cannot be edited. Defaults to <code>false</code>.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteWorkflowMapping(
    Long id, Optional<String> workflowName, Optional<Boolean> updateDraftIfNeeded, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/workflow");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (workflowName.isPresent()) {
      queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName.get())));
    }
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
   * <p>Deletes a workflow scheme. Note that a workflow scheme cannot be deleted if it is active (that is, being used by at least one project).</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as <code>schemeId</code>. For example, <em>schemeId=10301</em>.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteWorkflowScheme(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Delete draft workflow scheme
   * <p>Deletes a draft workflow scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the active workflow scheme that the draft was created from.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteWorkflowSchemeDraft(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Delete workflow for issue type in draft workflow scheme
   * <p>Deletes the issue type-workflow mapping for an issue type in a workflow scheme's draft.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme that the draft belongs to.</p>  (required)
   * @param issueType <p>The ID of the issue type.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> deleteWorkflowSchemeDraftIssueType(
    Long id, String issueType, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/issuetype/{issueType}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    pathParams.put("issueType", String.valueOf(issueType));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteWorkflowSchemeDraftIssueType);
  }

  /**
   * Delete workflow for issue type in workflow scheme
   * <p>Deletes the issue type-workflow mapping for an issue type in a workflow scheme.</p> <p>Note that active workflow schemes cannot be edited. If the workflow scheme is active, set <code>updateDraftIfNeeded</code> to <code>true</code> and a draft workflow scheme is created or updated with the issue type-workflow mapping deleted. The draft workflow scheme can be published in Jira.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme.</p>  (required)
   * @param issueType <p>The ID of the issue type.</p>  (required)
   * @param updateDraftIfNeeded <p>Set to true to create or update the draft of a workflow scheme and update the mapping in the draft, when the workflow scheme cannot be edited. Defaults to <code>false</code>.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> deleteWorkflowSchemeIssueType(
    Long id, String issueType, Optional<Boolean> updateDraftIfNeeded, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/issuetype/{issueType}");

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
   * Get default workflow
   * <p>Returns the default workflow for a workflow scheme. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has <em>All Unassigned Issue Types</em> listed in its issue types for the workflow scheme in Jira.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme.</p>  (required)
   * @param returnDraftIfExists <p>Set to <code>true</code> to return the default workflow for the workflow scheme's draft rather than scheme itself. If the workflow scheme does not have a draft, then the default workflow for the workflow scheme is returned.</p>  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;DefaultWorkflow&gt;
   */
  public Single<DefaultWorkflow> getDefaultWorkflow(
    Long id, Optional<Boolean> returnDraftIfExists, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/default");

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
   * Get draft default workflow
   * <p>Returns the default workflow for a workflow scheme's draft. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has <em>All Unassigned Issue Types</em> listed in its issue types for the workflow scheme in Jira.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme that the draft belongs to.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;DefaultWorkflow&gt;
   */
  public Single<DefaultWorkflow> getDraftDefaultWorkflow(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/default");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getDraftDefaultWorkflow);
  }

  /**
   * Get issue types for workflows in draft workflow scheme
   * <p>Returns the workflow-issue type mappings for a workflow scheme's draft.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme that the draft belongs to.</p>  (required)
   * @param workflowName <p>The name of a workflow in the scheme. Limits the results to the workflow-issue type mapping for the specified workflow.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypesWorkflowMapping&gt;
   */
  public Single<IssueTypesWorkflowMapping> getDraftWorkflow(
    Long id, Optional<String> workflowName, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/workflow");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (workflowName.isPresent()) {
      queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getDraftWorkflow);
  }

  /**
   * Get issue types for workflows in workflow scheme
   * <p>Returns the workflow-issue type mappings for a workflow scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme.</p>  (required)
   * @param workflowName <p>The name of a workflow in the scheme. Limits the results to the workflow-issue type mapping for the specified workflow.</p>  (optional)
   * @param returnDraftIfExists <p>Returns the mapping from the workflow scheme's draft rather than the workflow scheme, if set to true. If no draft exists, the mapping from the workflow scheme is returned.</p>  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypesWorkflowMapping&gt;
   */
  public Single<IssueTypesWorkflowMapping> getWorkflow(
    Long id, Optional<String> workflowName, Optional<Boolean> returnDraftIfExists, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/workflow");

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
   * <p>Returns a workflow scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as <code>schemeId</code>. For example, <em>schemeId=10301</em>.</p>  (required)
   * @param returnDraftIfExists <p>Returns the workflow scheme's draft rather than scheme itself, if set to true. If the workflow scheme does not have a draft, then the workflow scheme is returned.</p>  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> getWorkflowScheme(
    Long id, Optional<Boolean> returnDraftIfExists, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}");

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
   * Get draft workflow scheme
   * <p>Returns the draft workflow scheme for an active workflow scheme. Draft workflow schemes allow changes to be made to the active workflow schemes: When an active workflow scheme is updated, a draft copy is created. The draft is modified, then the changes in the draft are copied back to the active workflow scheme. See <a href=\"https://confluence.atlassian.com/x/tohKLg\">Configuring workflow schemes</a> for more information.<br /> Note that:</p> <ul> <li>Only active workflow schemes can have draft workflow schemes.</li> <li>An active workflow scheme can only have one draft workflow scheme.</li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the active workflow scheme that the draft was created from.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> getWorkflowSchemeDraft(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getWorkflowSchemeDraft);
  }

  /**
   * Get workflow for issue type in draft workflow scheme
   * <p>Returns the issue type-workflow mapping for an issue type in a workflow scheme's draft.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme that the draft belongs to.</p>  (required)
   * @param issueType <p>The ID of the issue type.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeWorkflowMapping&gt;
   */
  public Single<IssueTypeWorkflowMapping> getWorkflowSchemeDraftIssueType(
    Long id, String issueType, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/issuetype/{issueType}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    pathParams.put("issueType", String.valueOf(issueType));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getWorkflowSchemeDraftIssueType);
  }

  /**
   * Get workflow for issue type in workflow scheme
   * <p>Returns the issue type-workflow mapping for an issue type in a workflow scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme.</p>  (required)
   * @param issueType <p>The ID of the issue type.</p>  (required)
   * @param returnDraftIfExists <p>Returns the mapping from the workflow scheme's draft rather than the workflow scheme, if set to true. If no draft exists, the mapping from the workflow scheme is returned.</p>  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeWorkflowMapping&gt;
   */
  public Single<IssueTypeWorkflowMapping> getWorkflowSchemeIssueType(
    Long id, String issueType, Optional<Boolean> returnDraftIfExists, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/issuetype/{issueType}");

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
   * Set workflow for issue type in draft workflow scheme
   * <p>Sets the workflow for an issue type in a workflow scheme's draft.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme that the draft belongs to.</p>  (required)
   * @param issueType <p>The ID of the issue type.</p>  (required)
   * @param issueTypeWorkflowMapping <p>The issue type-project mapping.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> setWorkflowSchemeDraftIssueType(
    Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/issuetype/{issueType}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    pathParams.put("issueType", String.valueOf(issueType));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeWorkflowMapping));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setWorkflowSchemeDraftIssueType);
  }

  /**
   * Set workflow for issue type in workflow scheme
   * <p>Sets the workflow for an issue type in a workflow scheme.</p> <p>Note that active workflow schemes cannot be edited. If the workflow scheme is active, set <code>updateDraftIfNeeded</code> to <code>true</code> in the request body and a draft workflow scheme is created or updated with the new issue type-workflow mapping. The draft workflow scheme can be published in Jira.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme.</p>  (required)
   * @param issueType <p>The ID of the issue type.</p>  (required)
   * @param issueTypeWorkflowMapping <p>The issue type-project mapping.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> setWorkflowSchemeIssueType(
    Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/issuetype/{issueType}");

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
   * <p>Sets the default workflow for a workflow scheme.</p> <p>Note that active workflow schemes cannot be edited. If the workflow scheme is active, set <code>updateDraftIfNeeded</code> to <code>true</code> in the request object and a draft workflow scheme is created or updated with the new default workflow. The draft workflow scheme can be published in Jira.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme.</p>  (required)
   * @param defaultWorkflow <p>The new default workflow.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> updateDefaultWorkflow(
    Long id, DefaultWorkflow defaultWorkflow, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/default");

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
   * Update draft default workflow
   * <p>Sets the default workflow for a workflow scheme's draft.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme that the draft belongs to.</p>  (required)
   * @param defaultWorkflow <p>The object for the new default workflow.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> updateDraftDefaultWorkflow(
    Long id, DefaultWorkflow defaultWorkflow, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/default");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(defaultWorkflow));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateDraftDefaultWorkflow);
  }

  /**
   * Set issue types for workflow in workflow scheme
   * <p>Sets the issue types for a workflow in a workflow scheme's draft. The workflow can also be set as the default workflow for the draft workflow scheme. Unmapped issues types are mapped to the default workflow.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme that the draft belongs to.</p>  (required)
   * @param issueTypesWorkflowMapping  (required)
   * @param workflowName <p>The name of the workflow.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> updateDraftWorkflowMapping(
    Long id, IssueTypesWorkflowMapping issueTypesWorkflowMapping, Optional<String> workflowName, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/workflow");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (workflowName.isPresent()) {
      queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypesWorkflowMapping));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateDraftWorkflowMapping);
  }

  /**
   * Set issue types for workflow in workflow scheme
   * <p>Sets the issue types for a workflow in a workflow scheme. The workflow can also be set as the default workflow for the workflow scheme. Unmapped issues types are mapped to the default workflow.</p> <p>Note that active workflow schemes cannot be edited. If the workflow scheme is active, set <code>updateDraftIfNeeded</code> to <code>true</code> in the request body and a draft workflow scheme is created or updated with the new workflow-issue types mappings. The draft workflow scheme can be published in Jira.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme.</p>  (required)
   * @param issueTypesWorkflowMapping  (required)
   * @param workflowName <p>The name of the workflow.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> updateWorkflowMapping(
    Long id, IssueTypesWorkflowMapping issueTypesWorkflowMapping, Optional<String> workflowName, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/workflow");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (workflowName.isPresent()) {
      queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypesWorkflowMapping));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateWorkflowMapping);
  }

  /**
   * Update workflow scheme
   * <p>Updates a workflow scheme, including the name, default workflow, issue type to project mappings, and more. If the workflow scheme is active (that is, being used by at least one project), then a draft workflow scheme is created or updated instead, provided that <code>updateDraftIfNeeded</code> is set to <code>true</code>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as <code>schemeId</code>. For example, <em>schemeId=10301</em>.</p>  (required)
   * @param workflowScheme  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> updateWorkflowScheme(
    Long id, WorkflowScheme workflowScheme, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}");

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
   * Update draft workflow scheme
   * <p>Updates a draft workflow scheme. If a draft workflow scheme does not exist for the active workflow scheme, then a draft is created. Note that an active workflow scheme can only have one draft workflow scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the active workflow scheme that the draft was created from.</p>  (required)
   * @param workflowScheme  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> updateWorkflowSchemeDraft(
    Long id, WorkflowScheme workflowScheme, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(workflowScheme));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateWorkflowSchemeDraft);
  }

}
