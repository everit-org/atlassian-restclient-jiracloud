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

import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowTransitionProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkflowTransitionPropertiesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.com";

  private static final TypeReference<WorkflowTransitionProperty> returnType_createWorkflowTransitionProperty = new TypeReference<WorkflowTransitionProperty>() {};

  private static final TypeReference<WorkflowTransitionProperty> returnType_getWorkflowTransitionProperties = new TypeReference<WorkflowTransitionProperty>() {};

  private static final TypeReference<WorkflowTransitionProperty> returnType_updateWorkflowTransitionProperty = new TypeReference<WorkflowTransitionProperty>() {};

  private final RestClient restClient;

  public WorkflowTransitionPropertiesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create workflow transition property
   * Adds a property to a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition. (required)
   * @param key The key of the property being added, also known as the name of the property. Set this to the same value as the `key` defined in the request body. (required)
   * @param workflowName The name of the workflow that the transition belongs to. (required)
   * @param requestBody  (required)
   * @param workflowMode The workflow status. Set to *live* for inactive workflows or *draft* for draft workflows. Active workflows cannot be edited. (optional, default to live)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowTransitionProperty&gt;
   */
  public Single<WorkflowTransitionProperty> createWorkflowTransitionProperty(
    Long transitionId, String key, String workflowName, WorkflowTransitionProperty requestBody, Optional<String> workflowMode, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflow/transitions/{transitionId}/properties");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("transitionId", String.valueOf(transitionId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("key", Collections.singleton(String.valueOf(key)));
    queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    if (workflowMode.isPresent()) {
      queryParams.put("workflowMode", Collections.singleton(String.valueOf(workflowMode.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createWorkflowTransitionProperty);
  }

  /**
   * Delete workflow transition property
   * Deletes a property from a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition. (required)
   * @param key The name of the transition property to delete, also known as the name of the property. (required)
   * @param workflowName The name of the workflow that the transition belongs to. (required)
   * @param workflowMode The workflow status. Set to `live` for inactive workflows or `draft` for draft workflows. Active workflows cannot be edited. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteWorkflowTransitionProperty(
    Long transitionId, String key, String workflowName, Optional<String> workflowMode, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflow/transitions/{transitionId}/properties");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("transitionId", String.valueOf(transitionId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("key", Collections.singleton(String.valueOf(key)));
    queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    if (workflowMode.isPresent()) {
      queryParams.put("workflowMode", Collections.singleton(String.valueOf(workflowMode.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get workflow transition properties
   * Returns the properties on a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira administration console. The ID is shown next to the transition. (required)
   * @param workflowName The name of the workflow that the transition belongs to. (required)
   * @param includeReservedKeys Some properties with keys that have the *jira.* prefix are reserved, which means they are not editable. To include these properties in the results, set this parameter to *true*. (optional, default to false)
   * @param key The key of the property being returned, also known as the name of the property. If this parameter is not specified, all properties on the transition are returned. (optional)
   * @param workflowMode The workflow status. Set to *live* for active and inactive workflows, or *draft* for draft workflows. (optional, default to live)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowTransitionProperty&gt;
   */
  public Single<WorkflowTransitionProperty> getWorkflowTransitionProperties(
    Long transitionId, String workflowName, Optional<Boolean> includeReservedKeys, Optional<String> key, Optional<String> workflowMode, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflow/transitions/{transitionId}/properties");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("transitionId", String.valueOf(transitionId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (includeReservedKeys.isPresent()) {
      queryParams.put("includeReservedKeys", Collections.singleton(String.valueOf(includeReservedKeys.get())));
    }
    if (key.isPresent()) {
      queryParams.put("key", Collections.singleton(String.valueOf(key.get())));
    }
    queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    if (workflowMode.isPresent()) {
      queryParams.put("workflowMode", Collections.singleton(String.valueOf(workflowMode.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getWorkflowTransitionProperties);
  }

  /**
   * Update workflow transition property
   * Updates a workflow transition by changing the property value. Trying to update a property that does not exist results in a new property being added to the transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition. (required)
   * @param key The key of the property being updated, also known as the name of the property. Set this to the same value as the `key` defined in the request body. (required)
   * @param workflowName The name of the workflow that the transition belongs to. (required)
   * @param requestBody  (required)
   * @param workflowMode The workflow status. Set to `live` for inactive workflows or `draft` for draft workflows. Active workflows cannot be edited. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowTransitionProperty&gt;
   */
  public Single<WorkflowTransitionProperty> updateWorkflowTransitionProperty(
    Long transitionId, String key, String workflowName, WorkflowTransitionProperty requestBody, Optional<String> workflowMode, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflow/transitions/{transitionId}/properties");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("transitionId", String.valueOf(transitionId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("key", Collections.singleton(String.valueOf(key)));
    queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    if (workflowMode.isPresent()) {
      queryParams.put("workflowMode", Collections.singleton(String.valueOf(workflowMode.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateWorkflowTransitionProperty);
  }

}
