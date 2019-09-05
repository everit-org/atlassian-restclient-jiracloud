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

import org.everit.atlassian.restclient.jiracloud.v3.model.DeprecatedWorkflow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkflowsApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<List<DeprecatedWorkflow>> returnType_getAllWorkflows = new TypeReference<List<DeprecatedWorkflow>>() {};

  private final RestClient restClient;

  public WorkflowsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get all workflows
   * <p>Returns all workflows in Jira or a workflow. Deprecated, use <a href=\"#api-rest-api-3-workflow-search-get\">Get workflows paginated</a>.</p> <p>If the <code>workflowName</code> parameter is specified, the workflow is returned as an object (not in an array). Otherwise, an array of workflow objects is returned.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param workflowName <p>The name of the workflow to be returned. Only one workflow can be specified.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;DeprecatedWorkflow&gt;&gt;
   * @deprecated
   */
  @Deprecated
  public Single<List<DeprecatedWorkflow>> getAllWorkflows(
    Optional<String> workflowName, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflow");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (workflowName.isPresent()) {
      queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllWorkflows);
  }

}
