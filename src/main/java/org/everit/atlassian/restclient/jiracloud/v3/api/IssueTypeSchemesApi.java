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

import org.everit.atlassian.restclient.jiracloud.v3.model.IssueTypeIds;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueTypeSchemeDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueTypeSchemeID;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueTypeSchemeProjectAssociation;
import org.everit.atlassian.restclient.jiracloud.v3.model.IssueTypeSchemeUpdateDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.OrderOfIssueTypes;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanIssueTypeScheme;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanIssueTypeSchemeMapping;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanIssueTypeSchemeProjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueTypeSchemesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_addIssueTypesToIssueTypeScheme = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_assignIssueTypeSchemeToProject = new TypeReference<Object>() {};

  private static final TypeReference<IssueTypeSchemeID> returnType_createIssueTypeScheme = new TypeReference<IssueTypeSchemeID>() {};

  private static final TypeReference<Object> returnType_deleteIssueTypeScheme = new TypeReference<Object>() {};

  private static final TypeReference<PageBeanIssueTypeScheme> returnType_getAllIssueTypeSchemes = new TypeReference<PageBeanIssueTypeScheme>() {};

  private static final TypeReference<PageBeanIssueTypeSchemeProjects> returnType_getIssueTypeSchemeForProjects = new TypeReference<PageBeanIssueTypeSchemeProjects>() {};

  private static final TypeReference<PageBeanIssueTypeSchemeMapping> returnType_getIssueTypeSchemesMapping = new TypeReference<PageBeanIssueTypeSchemeMapping>() {};

  private static final TypeReference<Object> returnType_removeIssueTypeFromIssueTypeScheme = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_reorderIssueTypesInIssueTypeScheme = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateIssueTypeScheme = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueTypeSchemesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add issue types to issue type scheme
   * Adds issue types to an issue type scheme.  The added issue types are appended to the issue types list.  If any of the issue types exist in the issue type scheme, the operation fails and no issue types are added.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeSchemeId The ID of the issue type scheme. (required)
   * @param issueTypeIds  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> addIssueTypesToIssueTypeScheme(
    Long issueTypeSchemeId, IssueTypeIds issueTypeIds, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeSchemeId", String.valueOf(issueTypeSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeIds));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addIssueTypesToIssueTypeScheme);
  }

  /**
   * Assign issue type scheme to project
   * Assigns an issue type scheme to a project.  If any issues in the project are assigned issue types not present in the new scheme, the operation will fail. To complete the assignment those issues must be updated to use issue types in the new scheme.  Issue type schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeSchemeProjectAssociation  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> assignIssueTypeSchemeToProject(
    IssueTypeSchemeProjectAssociation issueTypeSchemeProjectAssociation, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuetypescheme/project");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeSchemeProjectAssociation));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_assignIssueTypeSchemeToProject);
  }

  /**
   * Create issue type scheme
   * Creates an issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeSchemeDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeSchemeID&gt;
   */
  public Single<IssueTypeSchemeID> createIssueTypeScheme(
    IssueTypeSchemeDetails issueTypeSchemeDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuetypescheme");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeSchemeDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createIssueTypeScheme);
  }

  /**
   * Delete issue type scheme
   * Deletes an issue type scheme.  Only issue type schemes used in classic projects can be deleted.  Any projects assigned to the scheme are reassigned to the default issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeSchemeId The ID of the issue type scheme. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteIssueTypeScheme(
    Long issueTypeSchemeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuetypescheme/{issueTypeSchemeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeSchemeId", String.valueOf(issueTypeSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteIssueTypeScheme);
  }

  /**
   * Get all issue type schemes
   * Returns a [paginated](#pagination) list of issue type schemes.  Only issue type schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param id The list of issue type schemes IDs. To include multiple IDs, provide an ampersand-separated list. For example, `id=10000&id=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param orderBy [Order](#ordering) the results by a field:   *  `name` Sorts by issue type scheme name.  *  `id` Sorts by issue type scheme ID. (optional, default to id)
   * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `projects` For each issue type schemes, returns information about the projects the issue type scheme is assigned to.  *  `issueTypes` For each issue type schemes, returns information about the issueTypes the issue type scheme have. (optional, default to &quot;&quot;)
   * @param queryString String used to perform a case-insensitive partial match with issue type scheme name. (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueTypeScheme&gt;
   */
  public Single<PageBeanIssueTypeScheme> getAllIssueTypeSchemes(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<Long>> id, Optional<String> orderBy, Optional<String> expand, Optional<String> queryString, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuetypescheme");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (id.isPresent()) {
      queryParams.put("id", RestClientUtil.objectCollectionToStringCollection(id.get()));
    }
    if (orderBy.isPresent()) {
      queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    if (queryString.isPresent()) {
      queryParams.put("queryString", Collections.singleton(String.valueOf(queryString.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllIssueTypeSchemes);
  }

  /**
   * Get issue type schemes for projects
   * Returns a [paginated](#pagination) list of issue type schemes and, for each issue type scheme, a list of the projects that use it.  Only issue type schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param projectId The list of project IDs. To include multiple project IDs, provide an ampersand-separated list. For example, `projectId=10000&projectId=10001`. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueTypeSchemeProjects&gt;
   */
  public Single<PageBeanIssueTypeSchemeProjects> getIssueTypeSchemeForProjects(
    List<Long> projectId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuetypescheme/project");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    queryParams.put("projectId", RestClientUtil.objectCollectionToStringCollection(projectId));
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssueTypeSchemeForProjects);
  }

  /**
   * Get issue type scheme items
   * Returns a [paginated](#pagination) list of issue type scheme items.  Only issue type scheme items used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param issueTypeSchemeId The list of issue type scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, `issueTypeSchemeId=10000&issueTypeSchemeId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueTypeSchemeMapping&gt;
   */
  public Single<PageBeanIssueTypeSchemeMapping> getIssueTypeSchemesMapping(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<Long>> issueTypeSchemeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuetypescheme/mapping");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (issueTypeSchemeId.isPresent()) {
      queryParams.put("issueTypeSchemeId", RestClientUtil.objectCollectionToStringCollection(issueTypeSchemeId.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssueTypeSchemesMapping);
  }

  /**
   * Remove issue type from issue type scheme
   * Removes an issue type from an issue type scheme.  This operation cannot remove:   *  any issue type used by issues.  *  any issue types from the default issue type scheme.  *  the last standard issue type from an issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeSchemeId The ID of the issue type scheme. (required)
   * @param issueTypeId The ID of the issue type. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> removeIssueTypeFromIssueTypeScheme(
    Long issueTypeSchemeId, Long issueTypeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype/{issueTypeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeSchemeId", String.valueOf(issueTypeSchemeId));
    pathParams.put("issueTypeId", String.valueOf(issueTypeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeIssueTypeFromIssueTypeScheme);
  }

  /**
   * Change order of issue types
   * Changes the order of issue types in an issue type scheme.  The request body parameters must meet the following requirements:   *  all of the issue types must belong to the issue type scheme.  *  either `after` or `position` must be provided.  *  the issue type in `after` must not be in the issue type list.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeSchemeId The ID of the issue type scheme. (required)
   * @param orderOfIssueTypes  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> reorderIssueTypesInIssueTypeScheme(
    Long issueTypeSchemeId, OrderOfIssueTypes orderOfIssueTypes, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype/move");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeSchemeId", String.valueOf(issueTypeSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(orderOfIssueTypes));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_reorderIssueTypesInIssueTypeScheme);
  }

  /**
   * Update issue type scheme
   * Updates an issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeSchemeId The ID of the issue type scheme. (required)
   * @param issueTypeSchemeUpdateDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateIssueTypeScheme(
    Long issueTypeSchemeId, IssueTypeSchemeUpdateDetails issueTypeSchemeUpdateDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuetypescheme/{issueTypeSchemeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeSchemeId", String.valueOf(issueTypeSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeSchemeUpdateDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateIssueTypeScheme);
  }

}
