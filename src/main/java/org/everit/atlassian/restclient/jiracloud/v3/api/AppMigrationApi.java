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

import org.everit.atlassian.restclient.jiracloud.v3.model.ConnectCustomFieldValues;
import org.everit.atlassian.restclient.jiracloud.v3.model.EntityPropertyDetails;
import java.util.UUID;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowRulesSearch;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorkflowRulesSearchDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppMigrationApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_appIssueFieldValueUpdateResourceUpdateIssueFieldsPut = new TypeReference<Object>() {};

  private static final TypeReference<WorkflowRulesSearchDetails> returnType_migrationResourceWorkflowRuleSearchPost = new TypeReference<WorkflowRulesSearchDetails>() {};

  private final RestClient restClient;

  public AppMigrationApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Bulk update custom field value
   * Updates the value of a custom field added by Connect apps on one or more issues. The values of up to 200 custom fields can be updated.  **[Permissions](#permissions) required:** Only Connect apps can make this request.
   * @param atlassianTransferId The ID of the transfer. (required)
   * @param connectCustomFieldValues  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> appIssueFieldValueUpdateResourceUpdateIssueFieldsPut(
      String atlassianTransferId, ConnectCustomFieldValues connectCustomFieldValues, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/atlassian-connect/1/migration/field");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    headers.put("Atlassian-Transfer-Id", atlassianTransferId);
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(connectCustomFieldValues));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_appIssueFieldValueUpdateResourceUpdateIssueFieldsPut);
  }

  /**
   * Bulk update entity properties
   * Updates the values of multiple entity properties for an object, up to 50 updates per request. This operation is for use by Connect apps during app migration.
   * @param atlassianTransferId The app migration transfer ID. (required)
   * @param entityType The type indicating the object that contains the entity properties. (required)
   * @param entityPropertyDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable migrationResourceUpdateEntityPropertiesValuePut(
      String atlassianTransferId, String entityType, List<EntityPropertyDetails> entityPropertyDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/atlassian-connect/1/migration/properties/{entityType}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("entityType", String.valueOf(entityType));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    headers.put("Atlassian-Transfer-Id", atlassianTransferId);
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(entityPropertyDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get workflow transition rule configurations
   * Returns configurations for workflow transition rules migrated from server to cloud and owned by the calling Connect app.
   * @param atlassianTransferId The app migration transfer ID. (required)
   * @param workflowRulesSearch  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowRulesSearchDetails&gt;
   */
  public Single<WorkflowRulesSearchDetails> migrationResourceWorkflowRuleSearchPost(
      String atlassianTransferId, WorkflowRulesSearch workflowRulesSearch, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/atlassian-connect/1/migration/workflow/rule/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    headers.put("Atlassian-Transfer-Id", atlassianTransferId);
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(workflowRulesSearch));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_migrationResourceWorkflowRuleSearchPost);
  }

}
