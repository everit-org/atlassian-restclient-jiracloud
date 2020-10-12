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

public class WorkflowSchemeDraftsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.com";

  private static final TypeReference<WorkflowScheme> returnType_createWorkflowSchemeDraftFromParent = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_deleteDraftDefaultWorkflow = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_deleteWorkflowSchemeDraftIssueType = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<DefaultWorkflow> returnType_getDraftDefaultWorkflow = new TypeReference<DefaultWorkflow>() {};

  private static final TypeReference<IssueTypesWorkflowMapping> returnType_getDraftWorkflow = new TypeReference<IssueTypesWorkflowMapping>() {};

  private static final TypeReference<WorkflowScheme> returnType_getWorkflowSchemeDraft = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<IssueTypeWorkflowMapping> returnType_getWorkflowSchemeDraftIssueType = new TypeReference<IssueTypeWorkflowMapping>() {};

  private static final TypeReference<WorkflowScheme> returnType_setWorkflowSchemeDraftIssueType = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateDraftDefaultWorkflow = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateDraftWorkflowMapping = new TypeReference<WorkflowScheme>() {};

  private static final TypeReference<WorkflowScheme> returnType_updateWorkflowSchemeDraft = new TypeReference<WorkflowScheme>() {};

  private final RestClient restClient;

  public WorkflowSchemeDraftsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create draft workflow scheme
   * Create a draft workflow scheme from an active workflow scheme, by copying the active workflow scheme. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the active workflow scheme that the draft is created from. (required)
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
   * Delete draft default workflow
   * Resets the default workflow for a workflow scheme's draft. That is, the default workflow is set to Jira's system workflow (the *jira* workflow).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme that the draft belongs to. (required)
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
   * Deletes the workflow-issue type mapping for a workflow in a workflow scheme's draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme that the draft belongs to. (required)
   * @param workflowName The name of the workflow. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteDraftWorkflowMapping(
    Long id, String workflowName, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/workflow");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Delete draft workflow scheme
   * Deletes a draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the active workflow scheme that the draft was created from. (required)
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
   * Deletes the issue type-workflow mapping for an issue type in a workflow scheme's draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme that the draft belongs to. (required)
   * @param issueType The ID of the issue type. (required)
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
   * Get draft default workflow
   * Returns the default workflow for a workflow scheme's draft. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has *All Unassigned Issue Types* listed in its issue types for the workflow scheme in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme that the draft belongs to. (required)
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
   * Returns the workflow-issue type mappings for a workflow scheme's draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme that the draft belongs to. (required)
   * @param workflowName The name of a workflow in the scheme. Limits the results to the workflow-issue type mapping for the specified workflow. (optional)
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
   * Get draft workflow scheme
   * Returns the draft workflow scheme for an active workflow scheme. Draft workflow schemes allow changes to be made to the active workflow schemes: When an active workflow scheme is updated, a draft copy is created. The draft is modified, then the changes in the draft are copied back to the active workflow scheme. See [Configuring workflow schemes](https://confluence.atlassian.com/x/tohKLg) for more information.   Note that:   *  Only active workflow schemes can have draft workflow schemes.  *  An active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the active workflow scheme that the draft was created from. (required)
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
   * Returns the issue type-workflow mapping for an issue type in a workflow scheme's draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme that the draft belongs to. (required)
   * @param issueType The ID of the issue type. (required)
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
   * Set workflow for issue type in draft workflow scheme
   * Sets the workflow for an issue type in a workflow scheme's draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme that the draft belongs to. (required)
   * @param issueType The ID of the issue type. (required)
   * @param issueTypeWorkflowMapping The issue type-project mapping. (required)
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
   * Update draft default workflow
   * Sets the default workflow for a workflow scheme's draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme that the draft belongs to. (required)
   * @param defaultWorkflow The object for the new default workflow. (required)
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
   * Sets the issue types for a workflow in a workflow scheme's draft. The workflow can also be set as the default workflow for the draft workflow scheme. Unmapped issues types are mapped to the default workflow.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the workflow scheme that the draft belongs to. (required)
   * @param workflowName The name of the workflow. (required)
   * @param issueTypesWorkflowMapping  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowScheme&gt;
   */
  public Single<WorkflowScheme> updateDraftWorkflowMapping(
    Long id, String workflowName, IssueTypesWorkflowMapping issueTypesWorkflowMapping, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/workflowscheme/{id}/draft/workflow");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypesWorkflowMapping));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateDraftWorkflowMapping);
  }

  /**
   * Update draft workflow scheme
   * Updates a draft workflow scheme. If a draft workflow scheme does not exist for the active workflow scheme, then a draft is created. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the active workflow scheme that the draft was created from. (required)
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
