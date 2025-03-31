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

import org.everit.atlassian.restclient.jiracloud.v3.model.BulkEditGetFields;
import org.everit.atlassian.restclient.jiracloud.v3.model.BulkOperationErrorResponse;
import org.everit.atlassian.restclient.jiracloud.v3.model.BulkOperationProgress;
import org.everit.atlassian.restclient.jiracloud.v3.model.BulkTransitionGetAvailableTransitions;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueBulkDeletePayload;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueBulkEditPayload;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueBulkMovePayload;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueBulkTransitionPayload;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueBulkWatchOrUnwatchPayload;
import org.everit.atlassian.restclient.jiracloud.v3.model.SubmittedBulkOperation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueBulkOperationsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<BulkTransitionGetAvailableTransitions> returnType_getAvailableTransitions = new TypeReference<BulkTransitionGetAvailableTransitions>() {};

  private static final TypeReference<BulkEditGetFields> returnType_getBulkEditableFields = new TypeReference<BulkEditGetFields>() {};

  private static final TypeReference<BulkOperationProgress> returnType_getBulkOperationProgress = new TypeReference<BulkOperationProgress>() {};

  private static final TypeReference<SubmittedBulkOperation> returnType_submitBulkDelete = new TypeReference<SubmittedBulkOperation>() {};

  private static final TypeReference<SubmittedBulkOperation> returnType_submitBulkEdit = new TypeReference<SubmittedBulkOperation>() {};

  private static final TypeReference<SubmittedBulkOperation> returnType_submitBulkMove = new TypeReference<SubmittedBulkOperation>() {};

  private static final TypeReference<SubmittedBulkOperation> returnType_submitBulkTransition = new TypeReference<SubmittedBulkOperation>() {};

  private static final TypeReference<SubmittedBulkOperation> returnType_submitBulkUnwatch = new TypeReference<SubmittedBulkOperation>() {};

  private static final TypeReference<SubmittedBulkOperation> returnType_submitBulkWatch = new TypeReference<SubmittedBulkOperation>() {};

  private final RestClient restClient;

  public IssueBulkOperationsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get available transitions
   * Use this API to retrieve a list of transitions available for the specified issues that can be used or bulk transition operations. You can submit either single or multiple issues in the query to obtain the available transitions.  The response will provide the available transitions for issues, organized by their respective workflows. **Only the transitions that are common among the issues within that workflow and do not involve any additional field updates will be included.** For bulk transitions that require additional field updates, please utilise the Jira Cloud UI.  You can request available transitions for up to 1,000 issues in a single operation. This API uses pagination to return responses, delivering 50 workflows at a time.  **[Permissions](#permissions) required:**   *  Global bulk change [permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-global-permissions/).  *  Transition [issues permission](https://support.atlassian.com/jira-cloud-administration/docs/permissions-for-company-managed-projects/#Transition-issues/) in all projects that contain the selected issues.  *  Browse [project permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in all projects that contain the selected issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param issueIdsOrKeys Comma (,) separated Ids or keys of the issues to get transitions available for them. (required)
   * @param endingBefore (Optional)The end cursor for use in pagination. (optional)
   * @param startingAfter (Optional)The start cursor for use in pagination. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;BulkTransitionGetAvailableTransitions&gt;
   */
  public Single<BulkTransitionGetAvailableTransitions> getAvailableTransitions(
    String issueIdsOrKeys, Optional<String> endingBefore, Optional<String> startingAfter, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/bulk/issues/transition");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("issueIdsOrKeys", Collections.singleton(String.valueOf(issueIdsOrKeys)));
    if (endingBefore.isPresent()) {
      queryParams.put("endingBefore", Collections.singleton(String.valueOf(endingBefore.get())));
    }
    if (startingAfter.isPresent()) {
      queryParams.put("startingAfter", Collections.singleton(String.valueOf(startingAfter.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAvailableTransitions);
  }

  /**
   * Get bulk editable fields
   * Use this API to get a list of fields visible to the user to perform bulk edit operations. You can pass single or multiple issues in the query to get eligible editable fields. This API uses pagination to return responses, delivering 50 fields at a time.  **[Permissions](#permissions) required:**   *  Global bulk change [permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-global-permissions/).  *  Browse [project permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in all projects that contain the selected issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  Depending on the field, any field-specific permissions required to edit it.
   * @param issueIdsOrKeys The IDs or keys of the issues to get editable fields from. (required)
   * @param searchText (Optional)The text to search for in the editable fields. (optional)
   * @param endingBefore (Optional)The end cursor for use in pagination. (optional)
   * @param startingAfter (Optional)The start cursor for use in pagination. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;BulkEditGetFields&gt;
   */
  public Single<BulkEditGetFields> getBulkEditableFields(
    String issueIdsOrKeys, Optional<String> searchText, Optional<String> endingBefore, Optional<String> startingAfter, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/bulk/issues/fields");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("issueIdsOrKeys", Collections.singleton(String.valueOf(issueIdsOrKeys)));
    if (searchText.isPresent()) {
      queryParams.put("searchText", Collections.singleton(String.valueOf(searchText.get())));
    }
    if (endingBefore.isPresent()) {
      queryParams.put("endingBefore", Collections.singleton(String.valueOf(endingBefore.get())));
    }
    if (startingAfter.isPresent()) {
      queryParams.put("startingAfter", Collections.singleton(String.valueOf(startingAfter.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getBulkEditableFields);
  }

  /**
   * Get bulk issue operation progress
   * Use this to get the progress state for the specified bulk operation `taskId`.  **[Permissions](#permissions) required:**   *  Global bulk change [permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-global-permissions/).  *  Administer Jira [global permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-global-permissions/), or be the creator of the task.  If the task is running, this resource will return:      {\"taskId\":\"10779\",\"status\":\"RUNNING\",\"progressPercent\":65,\"submittedBy\":{\"accountId\":\"5b10a2844c20165700ede21g\"},\"created\":1690180055963,\"started\":1690180056206,\"updated\":169018005829}  If the task has completed, then this resource will return:      {\"processedAccessibleIssues\":[10001,10002],\"created\":1709189449954,\"progressPercent\":100,\"started\":1709189450154,\"status\":\"COMPLETE\",\"submittedBy\":{\"accountId\":\"5b10a2844c20165700ede21g\"},\"invalidOrInaccessibleIssueCount\":0,\"taskId\":\"10000\",\"totalIssueCount\":2,\"updated\":1709189450354}  **Note:** You can view task progress for up to 14 days from creation.
   * @param taskId The ID of the task. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;BulkOperationProgress&gt;
   */
  public Single<BulkOperationProgress> getBulkOperationProgress(
    String taskId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/bulk/queue/{taskId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("taskId", String.valueOf(taskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getBulkOperationProgress);
  }

  /**
   * Bulk delete issues
   * Use this API to submit a bulk delete request. You can delete up to 1,000 issues in a single operation.  **[Permissions](#permissions) required:**   *  Global bulk change [permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-global-permissions/).  *  Delete [issues permission](https://support.atlassian.com/jira-cloud-administration/docs/permissions-for-company-managed-projects/#Delete-issues/) in all projects that contain the selected issues.  *  Browse [project permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in all projects that contain the selected issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param issueBulkDeletePayload The request body containing the issues to be deleted. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SubmittedBulkOperation&gt;
   */
  public Single<SubmittedBulkOperation> submitBulkDelete(
    IssueBulkDeletePayload issueBulkDeletePayload, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/bulk/issues/delete");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueBulkDeletePayload));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_submitBulkDelete);
  }

  /**
   * Bulk edit issues
   * Use this API to submit a bulk edit request and simultaneously edit multiple issues. There are limits applied to the number of issues and fields that can be edited. A single request can accommodate a maximum of 1000 issues (including subtasks) and 200 fields.  **[Permissions](#permissions) required:**   *  Global bulk change [permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-global-permissions/).  *  Browse [project permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in all projects that contain the selected issues.  *  Edit [issues permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in all projects that contain the selected issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param issueBulkEditPayload The request body containing the issues to be edited and the new field values. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SubmittedBulkOperation&gt;
   */
  public Single<SubmittedBulkOperation> submitBulkEdit(
    IssueBulkEditPayload issueBulkEditPayload, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/bulk/issues/fields");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueBulkEditPayload));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_submitBulkEdit);
  }

  /**
   * Bulk move issues
   * Use this API to submit a bulk issue move request. You can move multiple issues, but they must all be moved to and from a single project, issue type, and parent. You can't move more than 1000 issues (including subtasks) at once.  #### Scenarios: ####  This is an early version of the API and it doesn't have full feature parity with the Bulk Move UI experience.   *  Moving issue of type A to issue of type B in the same project or a different project: `SUPPORTED`  *  Moving multiple issues of type A in one project to multiple issues of type B in the same project or a different project: **`SUPPORTED`**  *  Moving a standard parent issue of type A with its multiple subtask issue types in one project to standard issue of type B and multiple subtask issue types in the same project or a different project: `SUPPORTED`  *  Moving an epic issue with its child issues to a different project without losing their relation: `NOT SUPPORTED`       (Workaround: Move them individually and stitch the relationship back with the Bulk Edit API)  #### Limits applied to bulk issue moves: ####  When using the bulk move, keep in mind that there are limits on the number of issues and fields you can include.   *  You can move up to 1,000 issues in a single operation, including any subtasks.  *  All issues must originate from the same project and share the same issue type and parent.  *  The total combined number of fields across all issues must not exceed 1,500,000. For example, if each issue includes 15,000 fields, then the maximum number of issues that can be moved is 100.  **[Permissions](#permissions) required:**   *  Global bulk change [permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-global-permissions/).  *  Move [issues permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in source projects.  *  Create [issues permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in destination projects.  *  Browse [project permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in destination projects, if moving subtasks only.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param issueBulkMovePayload  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SubmittedBulkOperation&gt;
   */
  public Single<SubmittedBulkOperation> submitBulkMove(
    IssueBulkMovePayload issueBulkMovePayload, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/bulk/issues/move");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueBulkMovePayload));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_submitBulkMove);
  }

  /**
   * Bulk transition issue statuses
   * Use this API to submit a bulk issue status transition request. You can transition multiple issues, alongside with their valid transition Ids. You can transition up to 1,000 issues in a single operation.  **[Permissions](#permissions) required:**   *  Global bulk change [permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-global-permissions/).  *  Transition [issues permission](https://support.atlassian.com/jira-cloud-administration/docs/permissions-for-company-managed-projects/#Transition-issues/) in all projects that contain the selected issues.  *  Browse [project permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in all projects that contain the selected issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param issueBulkTransitionPayload The request body containing the issues to be transitioned. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SubmittedBulkOperation&gt;
   */
  public Single<SubmittedBulkOperation> submitBulkTransition(
    IssueBulkTransitionPayload issueBulkTransitionPayload, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/bulk/issues/transition");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueBulkTransitionPayload));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_submitBulkTransition);
  }

  /**
   * Bulk unwatch issues
   * Use this API to submit a bulk unwatch request. You can unwatch up to 1,000 issues in a single operation.  **[Permissions](#permissions) required:**   *  Global bulk change [permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-global-permissions/).  *  Browse [project permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in all projects that contain the selected issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param issueBulkWatchOrUnwatchPayload The request body containing the issues to be unwatched. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SubmittedBulkOperation&gt;
   */
  public Single<SubmittedBulkOperation> submitBulkUnwatch(
    IssueBulkWatchOrUnwatchPayload issueBulkWatchOrUnwatchPayload, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/bulk/issues/unwatch");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueBulkWatchOrUnwatchPayload));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_submitBulkUnwatch);
  }

  /**
   * Bulk watch issues
   * Use this API to submit a bulk watch request. You can watch up to 1,000 issues in a single operation.  **[Permissions](#permissions) required:**   *  Global bulk change [permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-global-permissions/).  *  Browse [project permission](https://support.atlassian.com/jira-cloud-administration/docs/manage-project-permissions/) in all projects that contain the selected issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param issueBulkWatchOrUnwatchPayload The request body containing the issues to be watched. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SubmittedBulkOperation&gt;
   */
  public Single<SubmittedBulkOperation> submitBulkWatch(
    IssueBulkWatchOrUnwatchPayload issueBulkWatchOrUnwatchPayload, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/bulk/issues/watch");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueBulkWatchOrUnwatchPayload));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_submitBulkWatch);
  }

}
