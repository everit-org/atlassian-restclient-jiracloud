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

import org.everit.atlassian.restclient.jiracloud.v3.model.AddSecuritySchemeLevelsRequestBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.AssociateSecuritySchemeWithProjectDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanIssueSecuritySchemeToProjectMapping;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanSecurityLevel;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanSecurityLevelMember;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanSecuritySchemeWithProjects;
import org.everit.atlassian.restclient.jiracloud.v3.model.SecurityScheme;
import org.everit.atlassian.restclient.jiracloud.v3.model.SecuritySchemeId;
import org.everit.atlassian.restclient.jiracloud.v3.model.SecuritySchemeMembersRequest;
import org.everit.atlassian.restclient.jiracloud.v3.model.SecuritySchemes;
import org.everit.atlassian.restclient.jiracloud.v3.model.TaskProgressBeanObject;
import org.everit.atlassian.restclient.jiracloud.v3.model.UpdateIssueSecuritySchemeRequestBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueSecuritySchemesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_addSecurityLevel = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_addSecurityLevelMembers = new TypeReference<Object>() {};

  private static final TypeReference<SecuritySchemeId> returnType_createIssueSecurityScheme = new TypeReference<SecuritySchemeId>() {};

  private static final TypeReference<Object> returnType_deleteSecurityScheme = new TypeReference<Object>() {};

  private static final TypeReference<SecurityScheme> returnType_getIssueSecurityScheme = new TypeReference<SecurityScheme>() {};

  private static final TypeReference<SecuritySchemes> returnType_getIssueSecuritySchemes = new TypeReference<SecuritySchemes>() {};

  private static final TypeReference<PageBeanSecurityLevelMember> returnType_getSecurityLevelMembers = new TypeReference<PageBeanSecurityLevelMember>() {};

  private static final TypeReference<PageBeanSecurityLevel> returnType_getSecurityLevels = new TypeReference<PageBeanSecurityLevel>() {};

  private static final TypeReference<Object> returnType_removeMemberFromSecurityLevel = new TypeReference<Object>() {};

  private static final TypeReference<PageBeanIssueSecuritySchemeToProjectMapping> returnType_searchProjectsUsingSecuritySchemes = new TypeReference<PageBeanIssueSecuritySchemeToProjectMapping>() {};

  private static final TypeReference<PageBeanSecuritySchemeWithProjects> returnType_searchSecuritySchemes = new TypeReference<PageBeanSecuritySchemeWithProjects>() {};

  private static final TypeReference<Object> returnType_setDefaultLevels = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateIssueSecurityScheme = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateSecurityLevel = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueSecuritySchemesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add issue security levels
   * Adds levels and levels' members to the issue security scheme. You can add up to 100 levels per request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param schemeId The ID of the issue security scheme. (required)
   * @param addSecuritySchemeLevelsRequestBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> addSecurityLevel(
    String schemeId, AddSecuritySchemeLevelsRequestBean addSecuritySchemeLevelsRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/{schemeId}/level");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("schemeId", String.valueOf(schemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(addSecuritySchemeLevelsRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addSecurityLevel);
  }

  /**
   * Add issue security level members
   * Adds members to the issue security level. You can add up to 100 members per request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param schemeId The ID of the issue security scheme. (required)
   * @param levelId The ID of the issue security level. (required)
   * @param securitySchemeMembersRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> addSecurityLevelMembers(
    String schemeId, String levelId, SecuritySchemeMembersRequest securitySchemeMembersRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/{schemeId}/level/{levelId}/member");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("schemeId", String.valueOf(schemeId));
    pathParams.put("levelId", String.valueOf(levelId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(securitySchemeMembersRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addSecurityLevelMembers);
  }

  /**
   * Associate security scheme to project
   * Associates an issue security scheme with a project and remaps security levels of issues to the new levels, if provided.  This operation is [asynchronous](#async). Follow the `location` link in the response to determine the status of the task and use [Get task](#api-rest-api-3-task-taskId-get) to obtain subsequent updates.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param associateSecuritySchemeWithProjectDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable associateSchemesToProjects(
    AssociateSecuritySchemeWithProjectDetails associateSecuritySchemeWithProjectDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/project");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(associateSecuritySchemeWithProjectDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Create issue security scheme
   * Creates a security scheme with security scheme levels and levels' members. You can create up to 100 security scheme levels and security scheme levels' members per request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SecuritySchemeId&gt;
   */
  public Single<SecuritySchemeId> createIssueSecurityScheme(
    Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createIssueSecurityScheme);
  }

  /**
   * Delete issue security scheme
   * Deletes an issue security scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param schemeId The ID of the issue security scheme. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteSecurityScheme(
    String schemeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/{schemeId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("schemeId", String.valueOf(schemeId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteSecurityScheme);
  }

  /**
   * Get issue security scheme
   * Returns an issue security scheme along with its security levels.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for a project that uses the requested issue security scheme.
   * @param id The ID of the issue security scheme. Use the [Get issue security schemes](#api-rest-api-3-issuesecurityschemes-get) operation to get a list of issue security scheme IDs. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SecurityScheme&gt;
   */
  public Single<SecurityScheme> getIssueSecurityScheme(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssueSecurityScheme);
  }

  /**
   * Get issue security schemes
   * Returns all [issue security schemes](https://confluence.atlassian.com/x/J4lKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SecuritySchemes&gt;
   */
  public Single<SecuritySchemes> getIssueSecuritySchemes(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssueSecuritySchemes);
  }

  /**
   * Get issue security level members
   * Returns a [paginated](#pagination) list of issue security level members.  Only issue security level members in the context of classic projects are returned.  Filtering using parameters is inclusive: if you specify both security scheme IDs and level IDs, the result will include all issue security level members from the specified schemes and levels.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param id The list of issue security level member IDs. To include multiple issue security level members separate IDs with an ampersand: `id=10000&id=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param schemeId The list of issue security scheme IDs. To include multiple issue security schemes separate IDs with an ampersand: `schemeId=10000&schemeId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param levelId The list of issue security level IDs. To include multiple issue security levels separate IDs with an ampersand: `levelId=10000&levelId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param expand Use expand to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `all` Returns all expandable information  *  `field` Returns information about the custom field granted the permission  *  `group` Returns information about the group that is granted the permission  *  `projectRole` Returns information about the project role granted the permission  *  `user` Returns information about the user who is granted the permission (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanSecurityLevelMember&gt;
   */
  public Single<PageBeanSecurityLevelMember> getSecurityLevelMembers(
    Optional<String> startAt, Optional<String> maxResults, Optional<List<String>> id, Optional<List<String>> schemeId, Optional<List<String>> levelId, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/level/member");

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
    if (schemeId.isPresent()) {
      queryParams.put("schemeId", RestClientUtil.objectCollectionToStringCollection(schemeId.get()));
    }
    if (levelId.isPresent()) {
      queryParams.put("levelId", RestClientUtil.objectCollectionToStringCollection(levelId.get()));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getSecurityLevelMembers);
  }

  /**
   * Get issue security levels
   * Returns a [paginated](#pagination) list of issue security levels.  Only issue security levels in the context of classic projects are returned.  Filtering using IDs is inclusive: if you specify both security scheme IDs and level IDs, the result will include both specified issue security levels and all issue security levels from the specified schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param id The list of issue security scheme level IDs. To include multiple issue security levels, separate IDs with an ampersand: `id=10000&id=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param schemeId The list of issue security scheme IDs. To include multiple issue security schemes, separate IDs with an ampersand: `schemeId=10000&schemeId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param onlyDefault When set to true, returns multiple default levels for each security scheme containing a default. If you provide scheme and level IDs not associated with the default, returns an empty page. The default value is false. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanSecurityLevel&gt;
   */
  public Single<PageBeanSecurityLevel> getSecurityLevels(
    Optional<String> startAt, Optional<String> maxResults, Optional<List<String>> id, Optional<List<String>> schemeId, Optional<Boolean> onlyDefault, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/level");

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
    if (schemeId.isPresent()) {
      queryParams.put("schemeId", RestClientUtil.objectCollectionToStringCollection(schemeId.get()));
    }
    if (onlyDefault.isPresent()) {
      queryParams.put("onlyDefault", Collections.singleton(String.valueOf(onlyDefault.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getSecurityLevels);
  }

  /**
   * Remove issue security level
   * Deletes an issue security level.  This operation is [asynchronous](#async). Follow the `location` link in the response to determine the status of the task and use [Get task](#api-rest-api-3-task-taskId-get) to obtain subsequent updates.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param schemeId The ID of the issue security scheme. (required)
   * @param levelId The ID of the issue security level to remove. (required)
   * @param replaceWith The ID of the issue security level that will replace the currently selected level. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeLevel(
    String schemeId, String levelId, Optional<String> replaceWith, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/{schemeId}/level/{levelId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("schemeId", String.valueOf(schemeId));
    pathParams.put("levelId", String.valueOf(levelId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (replaceWith.isPresent()) {
      queryParams.put("replaceWith", Collections.singleton(String.valueOf(replaceWith.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Remove member from issue security level
   * Removes an issue security level member from an issue security scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param schemeId The ID of the issue security scheme. (required)
   * @param levelId The ID of the issue security level. (required)
   * @param memberId The ID of the issue security level member to be removed. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> removeMemberFromSecurityLevel(
    String schemeId, String levelId, String memberId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/{schemeId}/level/{levelId}/member/{memberId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("schemeId", String.valueOf(schemeId));
    pathParams.put("levelId", String.valueOf(levelId));
    pathParams.put("memberId", String.valueOf(memberId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeMemberFromSecurityLevel);
  }

  /**
   * Get projects using issue security schemes
   * Returns a [paginated](#pagination) mapping of projects that are using security schemes. You can provide either one or multiple security scheme IDs or project IDs to filter by. If you don't provide any, this will return a list of all mappings. Only issue security schemes in the context of classic projects are supported. **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param issueSecuritySchemeId The list of security scheme IDs to be filtered out. (optional, default to new ArrayList&lt;&gt;())
   * @param projectId The list of project IDs to be filtered out. (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueSecuritySchemeToProjectMapping&gt;
   */
  public Single<PageBeanIssueSecuritySchemeToProjectMapping> searchProjectsUsingSecuritySchemes(
    Optional<String> startAt, Optional<String> maxResults, Optional<List<String>> issueSecuritySchemeId, Optional<List<String>> projectId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/project");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (issueSecuritySchemeId.isPresent()) {
      queryParams.put("issueSecuritySchemeId", RestClientUtil.objectCollectionToStringCollection(issueSecuritySchemeId.get()));
    }
    if (projectId.isPresent()) {
      queryParams.put("projectId", RestClientUtil.objectCollectionToStringCollection(projectId.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_searchProjectsUsingSecuritySchemes);
  }

  /**
   * Search issue security schemes
   * Returns a [paginated](#pagination) list of issue security schemes.   If you specify the project ID parameter, the result will contain issue security schemes and related project IDs you filter by. Use \\{@link IssueSecuritySchemeResource\\#searchProjectsUsingSecuritySchemes(String, String, Set, Set)\\} to obtain all projects related to scheme.  Only issue security schemes in the context of classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to &quot;0&quot;)
   * @param maxResults The maximum number of items to return per page. (optional, default to &quot;50&quot;)
   * @param id The list of issue security scheme IDs. To include multiple issue security scheme IDs, separate IDs with an ampersand: `id=10000&id=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param projectId The list of project IDs. To include multiple project IDs, separate IDs with an ampersand: `projectId=10000&projectId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanSecuritySchemeWithProjects&gt;
   */
  public Single<PageBeanSecuritySchemeWithProjects> searchSecuritySchemes(
    Optional<String> startAt, Optional<String> maxResults, Optional<List<String>> id, Optional<List<String>> projectId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/search");

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
    if (projectId.isPresent()) {
      queryParams.put("projectId", RestClientUtil.objectCollectionToStringCollection(projectId.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_searchSecuritySchemes);
  }

  /**
   * Set default issue security levels
   * Sets default issue security levels for schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setDefaultLevels(
    Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/level/default");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setDefaultLevels);
  }

  /**
   * Update issue security scheme
   * Updates the issue security scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the issue security scheme. (required)
   * @param updateIssueSecuritySchemeRequestBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateIssueSecurityScheme(
    String id, UpdateIssueSecuritySchemeRequestBean updateIssueSecuritySchemeRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(updateIssueSecuritySchemeRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateIssueSecurityScheme);
  }

  /**
   * Update issue security level
   * Updates the issue security level.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param schemeId The ID of the issue security scheme level belongs to. (required)
   * @param levelId The ID of the issue security level to update. (required)
   * @param requestBody  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateSecurityLevel(
    String schemeId, String levelId, Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issuesecurityschemes/{schemeId}/level/{levelId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("schemeId", String.valueOf(schemeId));
    pathParams.put("levelId", String.valueOf(levelId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateSecurityLevel);
  }

}
