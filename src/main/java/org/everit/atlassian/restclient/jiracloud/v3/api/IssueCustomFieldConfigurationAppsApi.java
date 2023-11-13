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

import org.everit.atlassian.restclient.jiracloud.v3.model.CustomFieldConfigurations;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanContextualConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueCustomFieldConfigurationAppsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PageBeanContextualConfiguration> returnType_getCustomFieldConfiguration = new TypeReference<PageBeanContextualConfiguration>() {};

  private static final TypeReference<Object> returnType_updateCustomFieldConfiguration = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueCustomFieldConfigurationAppsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get custom field configurations
   * Returns a [paginated](#pagination) list of configurations for a custom field created by a [Forge app](https://developer.atlassian.com/platform/forge/).  The result can be filtered by one of these criteria:   *  `id`.  *  `fieldContextId`.  *  `issueId`.  *  `projectKeyOrId` and `issueTypeId`.  Otherwise, all configurations are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the Forge app that created the custom field.
   * @param fieldIdOrKey The ID or key of the custom field, for example `customfield_10000`. (required)
   * @param id The list of configuration IDs. To include multiple configurations, separate IDs with an ampersand: `id=10000&id=10001`. Can't be provided with `fieldContextId`, `issueId`, `projectKeyOrId`, or `issueTypeId`. (optional, default to new ArrayList&lt;&gt;())
   * @param fieldContextId The list of field context IDs. To include multiple field contexts, separate IDs with an ampersand: `fieldContextId=10000&fieldContextId=10001`. Can't be provided with `id`, `issueId`, `projectKeyOrId`, or `issueTypeId`. (optional, default to new ArrayList&lt;&gt;())
   * @param issueId The ID of the issue to filter results by. If the issue doesn't exist, an empty list is returned. Can't be provided with `projectKeyOrId`, or `issueTypeId`. (optional)
   * @param projectKeyOrId The ID or key of the project to filter results by. Must be provided with `issueTypeId`. Can't be provided with `issueId`. (optional)
   * @param issueTypeId The ID of the issue type to filter results by. Must be provided with `projectKeyOrId`. Can't be provided with `issueId`. (optional)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 100)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanContextualConfiguration&gt;
   */
  public Single<PageBeanContextualConfiguration> getCustomFieldConfiguration(
    String fieldIdOrKey, Optional<List<Long>> id, Optional<List<Long>> fieldContextId, Optional<Long> issueId, Optional<String> projectKeyOrId, Optional<String> issueTypeId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/app/field/{fieldIdOrKey}/context/configuration");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldIdOrKey", String.valueOf(fieldIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (id.isPresent()) {
      queryParams.put("id", RestClientUtil.objectCollectionToStringCollection(id.get()));
    }
    if (fieldContextId.isPresent()) {
      queryParams.put("fieldContextId", RestClientUtil.objectCollectionToStringCollection(fieldContextId.get()));
    }
    if (issueId.isPresent()) {
      queryParams.put("issueId", Collections.singleton(String.valueOf(issueId.get())));
    }
    if (projectKeyOrId.isPresent()) {
      queryParams.put("projectKeyOrId", Collections.singleton(String.valueOf(projectKeyOrId.get())));
    }
    if (issueTypeId.isPresent()) {
      queryParams.put("issueTypeId", Collections.singleton(String.valueOf(issueTypeId.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getCustomFieldConfiguration);
  }

  /**
   * Update custom field configurations
   * Update the configuration for contexts of a custom field created by a [Forge app](https://developer.atlassian.com/platform/forge/).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the Forge app that created the custom field.
   * @param fieldIdOrKey The ID or key of the custom field, for example `customfield_10000`. (required)
   * @param customFieldConfigurations  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateCustomFieldConfiguration(
    String fieldIdOrKey, CustomFieldConfigurations customFieldConfigurations, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/app/field/{fieldIdOrKey}/context/configuration");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldIdOrKey", String.valueOf(fieldIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(customFieldConfigurations));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateCustomFieldConfiguration);
  }

}
