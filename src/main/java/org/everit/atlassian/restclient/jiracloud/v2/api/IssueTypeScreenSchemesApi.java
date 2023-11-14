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

import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeIds;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeScreenSchemeDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeScreenSchemeId;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeScreenSchemeMappingDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeScreenSchemeProjectAssociation;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeScreenSchemeUpdateDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanIssueTypeScreenScheme;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanIssueTypeScreenSchemeItem;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanIssueTypeScreenSchemesProjects;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanProjectDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.UpdateDefaultScreenScheme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueTypeScreenSchemesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_appendMappingsForIssueTypeScreenScheme = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_assignIssueTypeScreenSchemeToProject = new TypeReference<Object>() {};

  private static final TypeReference<IssueTypeScreenSchemeId> returnType_createIssueTypeScreenScheme = new TypeReference<IssueTypeScreenSchemeId>() {};

  private static final TypeReference<Object> returnType_deleteIssueTypeScreenScheme = new TypeReference<Object>() {};

  private static final TypeReference<PageBeanIssueTypeScreenSchemeItem> returnType_getIssueTypeScreenSchemeMappings = new TypeReference<PageBeanIssueTypeScreenSchemeItem>() {};

  private static final TypeReference<PageBeanIssueTypeScreenSchemesProjects> returnType_getIssueTypeScreenSchemeProjectAssociations = new TypeReference<PageBeanIssueTypeScreenSchemesProjects>() {};

  private static final TypeReference<PageBeanIssueTypeScreenScheme> returnType_getIssueTypeScreenSchemes = new TypeReference<PageBeanIssueTypeScreenScheme>() {};

  private static final TypeReference<PageBeanProjectDetails> returnType_getProjectsForIssueTypeScreenScheme = new TypeReference<PageBeanProjectDetails>() {};

  private static final TypeReference<Object> returnType_removeMappingsFromIssueTypeScreenScheme = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateDefaultScreenScheme = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateIssueTypeScreenScheme = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueTypeScreenSchemesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Append mappings to issue type screen scheme
   * Appends issue type to screen scheme mappings to an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeScreenSchemeId The ID of the issue type screen scheme. (required)
   * @param issueTypeScreenSchemeMappingDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> appendMappingsForIssueTypeScreenScheme(
    String issueTypeScreenSchemeId, IssueTypeScreenSchemeMappingDetails issueTypeScreenSchemeMappingDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeScreenSchemeId", String.valueOf(issueTypeScreenSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeScreenSchemeMappingDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_appendMappingsForIssueTypeScreenScheme);
  }

  /**
   * Assign issue type screen scheme to project
   * Assigns an issue type screen scheme to a project.  Issue type screen schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeScreenSchemeProjectAssociation  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> assignIssueTypeScreenSchemeToProject(
    IssueTypeScreenSchemeProjectAssociation issueTypeScreenSchemeProjectAssociation, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme/project");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeScreenSchemeProjectAssociation));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_assignIssueTypeScreenSchemeToProject);
  }

  /**
   * Create issue type screen scheme
   * Creates an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeScreenSchemeDetails An issue type screen scheme bean. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeScreenSchemeId&gt;
   */
  public Single<IssueTypeScreenSchemeId> createIssueTypeScreenScheme(
    IssueTypeScreenSchemeDetails issueTypeScreenSchemeDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeScreenSchemeDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createIssueTypeScreenScheme);
  }

  /**
   * Delete issue type screen scheme
   * Deletes an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeScreenSchemeId The ID of the issue type screen scheme. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteIssueTypeScreenScheme(
    String issueTypeScreenSchemeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme/{issueTypeScreenSchemeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeScreenSchemeId", String.valueOf(issueTypeScreenSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteIssueTypeScreenScheme);
  }

  /**
   * Get issue type screen scheme items
   * Returns a [paginated](#pagination) list of issue type screen scheme items.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param issueTypeScreenSchemeId The list of issue type screen scheme IDs. To include multiple issue type screen schemes, separate IDs with ampersand: `issueTypeScreenSchemeId=10000&issueTypeScreenSchemeId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueTypeScreenSchemeItem&gt;
   */
  public Single<PageBeanIssueTypeScreenSchemeItem> getIssueTypeScreenSchemeMappings(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<Long>> issueTypeScreenSchemeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme/mapping");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (issueTypeScreenSchemeId.isPresent()) {
      queryParams.put("issueTypeScreenSchemeId", RestClientUtil.objectCollectionToStringCollection(issueTypeScreenSchemeId.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssueTypeScreenSchemeMappings);
  }

  /**
   * Get issue type screen schemes for projects
   * Returns a [paginated](#pagination) list of issue type screen schemes and, for each issue type screen scheme, a list of the projects that use it.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param projectId The list of project IDs. To include multiple projects, separate IDs with ampersand: `projectId=10000&projectId=10001`. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueTypeScreenSchemesProjects&gt;
   */
  public Single<PageBeanIssueTypeScreenSchemesProjects> getIssueTypeScreenSchemeProjectAssociations(
    List<Long> projectId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme/project");

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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssueTypeScreenSchemeProjectAssociations);
  }

  /**
   * Get issue type screen schemes
   * Returns a [paginated](#pagination) list of issue type screen schemes.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param id The list of issue type screen scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, `id=10000&id=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param queryString String used to perform a case-insensitive partial match with issue type screen scheme name. (optional, default to &quot;&quot;)
   * @param orderBy [Order](#ordering) the results by a field:   *  `name` Sorts by issue type screen scheme name.  *  `id` Sorts by issue type screen scheme ID. (optional, default to id)
   * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts `projects` that, for each issue type screen schemes, returns information about the projects the issue type screen scheme is assigned to. (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueTypeScreenScheme&gt;
   */
  public Single<PageBeanIssueTypeScreenScheme> getIssueTypeScreenSchemes(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<Long>> id, Optional<String> queryString, Optional<String> orderBy, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme");

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
    if (queryString.isPresent()) {
      queryParams.put("queryString", Collections.singleton(String.valueOf(queryString.get())));
    }
    if (orderBy.isPresent()) {
      queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssueTypeScreenSchemes);
  }

  /**
   * Get issue type screen scheme projects
   * Returns a [paginated](#pagination) list of projects associated with an issue type screen scheme.  Only company-managed projects associated with an issue type screen scheme are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeScreenSchemeId The ID of the issue type screen scheme. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param query  (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanProjectDetails&gt;
   */
  public Single<PageBeanProjectDetails> getProjectsForIssueTypeScreenScheme(
    Long issueTypeScreenSchemeId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<String> query, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme/{issueTypeScreenSchemeId}/project");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeScreenSchemeId", String.valueOf(issueTypeScreenSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getProjectsForIssueTypeScreenScheme);
  }

  /**
   * Remove mappings from issue type screen scheme
   * Removes issue type to screen scheme mappings from an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeScreenSchemeId The ID of the issue type screen scheme. (required)
   * @param issueTypeIds  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> removeMappingsFromIssueTypeScreenScheme(
    String issueTypeScreenSchemeId, IssueTypeIds issueTypeIds, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping/remove");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeScreenSchemeId", String.valueOf(issueTypeScreenSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeIds));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeMappingsFromIssueTypeScreenScheme);
  }

  /**
   * Update issue type screen scheme default screen scheme
   * Updates the default screen scheme of an issue type screen scheme. The default screen scheme is used for all unmapped issue types.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeScreenSchemeId The ID of the issue type screen scheme. (required)
   * @param updateDefaultScreenScheme  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateDefaultScreenScheme(
    String issueTypeScreenSchemeId, UpdateDefaultScreenScheme updateDefaultScreenScheme, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping/default");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeScreenSchemeId", String.valueOf(issueTypeScreenSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(updateDefaultScreenScheme));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateDefaultScreenScheme);
  }

  /**
   * Update issue type screen scheme
   * Updates an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param issueTypeScreenSchemeId The ID of the issue type screen scheme. (required)
   * @param issueTypeScreenSchemeUpdateDetails The issue type screen scheme update details. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateIssueTypeScreenScheme(
    String issueTypeScreenSchemeId, IssueTypeScreenSchemeUpdateDetails issueTypeScreenSchemeUpdateDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetypescreenscheme/{issueTypeScreenSchemeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueTypeScreenSchemeId", String.valueOf(issueTypeScreenSchemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeScreenSchemeUpdateDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateIssueTypeScreenScheme);
  }

}
