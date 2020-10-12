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

import org.everit.atlassian.restclient.jiracloud.v3.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanWorkflowTransitionRules;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowTransitionRulesUpdate;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowTransitionRulesUpdateErrors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkflowTransitionRulesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.com";

  private static final TypeReference<PageBeanWorkflowTransitionRules> returnType_getWorkflowTransitionRuleConfigurations = new TypeReference<PageBeanWorkflowTransitionRules>() {};

  private static final TypeReference<WorkflowTransitionRulesUpdateErrors> returnType_updateWorkflowTransitionRuleConfigurations = new TypeReference<WorkflowTransitionRulesUpdateErrors>() {};

  private final RestClient restClient;

  public WorkflowTransitionRulesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get workflow transition rule configurations
   * Returns a [paginated](#pagination) list of workflows with transition rules. The workflows can be filtered to return only those containing workflow transition rules:   *  of one or more transition rule types, such as [workflow post functions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-post-function/).  *  matching one or more transition rule keys.  Only workflows containing transition rules created by the calling Connect app are returned. However, if a workflow is returned all transition rules that match the filters are returned for that workflow.  Due to server-side optimizations, workflows with an empty list of rules may be returned; these workflows can be ignored.  **[Permissions](#permissions) required:** Only Connect apps can use this operation.
   * @param types The types of the transition rules to return. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 10)
   * @param keys The transition rule class keys, as defined in the Connect app descriptor, of the transition rules to return. (optional, default to new ArrayList&lt;&gt;())
   * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts `transition`, which, for each rule, returns information about the transition the rule is assigned to. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanWorkflowTransitionRules&gt;
   */
  public Single<PageBeanWorkflowTransitionRules> getWorkflowTransitionRuleConfigurations(
    List<String> types, Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<String>> keys, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflow/rule/config");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    queryParams.put("types", RestClientUtil.objectCollectionToStringCollection(types));
    if (keys.isPresent()) {
      queryParams.put("keys", RestClientUtil.objectCollectionToStringCollection(keys.get()));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getWorkflowTransitionRuleConfigurations);
  }

  /**
   * Update workflow transition rule configurations
   * Updates configuration of workflow transition rules. The following rule types are supported:   *  [post functions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-post-function/)  *  [conditions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-condition/)  *  [validators](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-validator/)  Only rules created by the calling Connect app can be updated.  **[Permissions](#permissions) required:** Only Connect apps can use this operation.
   * @param workflowTransitionRulesUpdate  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowTransitionRulesUpdateErrors&gt;
   */
  public Single<WorkflowTransitionRulesUpdateErrors> updateWorkflowTransitionRuleConfigurations(
    WorkflowTransitionRulesUpdate workflowTransitionRulesUpdate, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflow/rule/config");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(workflowTransitionRulesUpdate));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateWorkflowTransitionRuleConfigurations);
  }

}
