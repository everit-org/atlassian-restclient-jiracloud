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

import org.everit.atlassian.restclient.jiracloud.v2.model.AssociateFieldConfigurationsWithIssueTypesRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.FieldConfiguration;
import org.everit.atlassian.restclient.jiracloud.v2.model.FieldConfigurationDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.FieldConfigurationItemsDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.FieldConfigurationScheme;
import org.everit.atlassian.restclient.jiracloud.v2.model.FieldConfigurationSchemeProjectAssociation;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeIdsToRemove;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanFieldConfigurationDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanFieldConfigurationIssueTypeItem;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanFieldConfigurationItem;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanFieldConfigurationScheme;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanFieldConfigurationSchemeProjects;
import org.everit.atlassian.restclient.jiracloud.v2.model.UpdateFieldConfigurationSchemeDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueFieldConfigurationsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_assignFieldConfigurationSchemeToProject = new TypeReference<Object>() {};

  private static final TypeReference<FieldConfiguration> returnType_createFieldConfiguration = new TypeReference<FieldConfiguration>() {};

  private static final TypeReference<FieldConfigurationScheme> returnType_createFieldConfigurationScheme = new TypeReference<FieldConfigurationScheme>() {};

  private static final TypeReference<Object> returnType_deleteFieldConfiguration = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_deleteFieldConfigurationScheme = new TypeReference<Object>() {};

  private static final TypeReference<PageBeanFieldConfigurationScheme> returnType_getAllFieldConfigurationSchemes = new TypeReference<PageBeanFieldConfigurationScheme>() {};

  private static final TypeReference<PageBeanFieldConfigurationDetails> returnType_getAllFieldConfigurations = new TypeReference<PageBeanFieldConfigurationDetails>() {};

  private static final TypeReference<PageBeanFieldConfigurationItem> returnType_getFieldConfigurationItems = new TypeReference<PageBeanFieldConfigurationItem>() {};

  private static final TypeReference<PageBeanFieldConfigurationIssueTypeItem> returnType_getFieldConfigurationSchemeMappings = new TypeReference<PageBeanFieldConfigurationIssueTypeItem>() {};

  private static final TypeReference<PageBeanFieldConfigurationSchemeProjects> returnType_getFieldConfigurationSchemeProjectMapping = new TypeReference<PageBeanFieldConfigurationSchemeProjects>() {};

  private static final TypeReference<Object> returnType_removeIssueTypesFromGlobalFieldConfigurationScheme = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_setFieldConfigurationSchemeMapping = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateFieldConfiguration = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateFieldConfigurationItems = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateFieldConfigurationScheme = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueFieldConfigurationsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Assign field configuration scheme to project
   * Assigns a field configuration scheme to a project. If the field configuration scheme ID is `null`, the operation assigns the default field configuration scheme.  Field configuration schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldConfigurationSchemeProjectAssociation  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> assignFieldConfigurationSchemeToProject(
    FieldConfigurationSchemeProjectAssociation fieldConfigurationSchemeProjectAssociation, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfigurationscheme/project");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(fieldConfigurationSchemeProjectAssociation));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_assignFieldConfigurationSchemeToProject);
  }

  /**
   * Create field configuration
   * Creates a field configuration. The field configuration is created with the same field properties as the default configuration, with all the fields being optional.  This operation can only create configurations for use in company-managed (classic) projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldConfigurationDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;FieldConfiguration&gt;
   */
  public Single<FieldConfiguration> createFieldConfiguration(
    FieldConfigurationDetails fieldConfigurationDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfiguration");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(fieldConfigurationDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createFieldConfiguration);
  }

  /**
   * Create field configuration scheme
   * Creates a field configuration scheme.  This operation can only create field configuration schemes used in company-managed (classic) projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param updateFieldConfigurationSchemeDetails The details of the field configuration scheme. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;FieldConfigurationScheme&gt;
   */
  public Single<FieldConfigurationScheme> createFieldConfigurationScheme(
    UpdateFieldConfigurationSchemeDetails updateFieldConfigurationSchemeDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfigurationscheme");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(updateFieldConfigurationSchemeDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createFieldConfigurationScheme);
  }

  /**
   * Delete field configuration
   * Deletes a field configuration.  This operation can only delete configurations used in company-managed (classic) projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the field configuration. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteFieldConfiguration(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfiguration/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteFieldConfiguration);
  }

  /**
   * Delete field configuration scheme
   * Deletes a field configuration scheme.  This operation can only delete field configuration schemes used in company-managed (classic) projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the field configuration scheme. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteFieldConfigurationScheme(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfigurationscheme/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteFieldConfigurationScheme);
  }

  /**
   * Get all field configuration schemes
   * Returns a [paginated](#pagination) list of field configuration schemes.  Only field configuration schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param id The list of field configuration scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, `id=10000&id=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanFieldConfigurationScheme&gt;
   */
  public Single<PageBeanFieldConfigurationScheme> getAllFieldConfigurationSchemes(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<Long>> id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfigurationscheme");

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
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllFieldConfigurationSchemes);
  }

  /**
   * Get all field configurations
   * Returns a [paginated](#pagination) list of field configurations. The list can be for all field configurations or a subset determined by any combination of these criteria:   *  a list of field configuration item IDs.  *  whether the field configuration is a default.  *  whether the field configuration name or description contains a query string.  Only field configurations used in company-managed (classic) projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param id The list of field configuration IDs. To include multiple IDs, provide an ampersand-separated list. For example, `id=10000&id=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param isDefault If *true* returns default field configurations only. (optional, default to false)
   * @param query The query string used to match against field configuration names and descriptions. (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanFieldConfigurationDetails&gt;
   */
  public Single<PageBeanFieldConfigurationDetails> getAllFieldConfigurations(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<Long>> id, Optional<Boolean> isDefault, Optional<String> query, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfiguration");

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
    if (isDefault.isPresent()) {
      queryParams.put("isDefault", Collections.singleton(String.valueOf(isDefault.get())));
    }
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllFieldConfigurations);
  }

  /**
   * Get field configuration items
   * Returns a [paginated](#pagination) list of all fields for a configuration.  Only the fields from configurations used in company-managed (classic) projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the field configuration. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanFieldConfigurationItem&gt;
   */
  public Single<PageBeanFieldConfigurationItem> getFieldConfigurationItems(
    Long id, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfiguration/{id}/fields");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getFieldConfigurationItems);
  }

  /**
   * Get field configuration issue type items
   * Returns a [paginated](#pagination) list of field configuration issue type items.  Only items used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param fieldConfigurationSchemeId The list of field configuration scheme IDs. To include multiple field configuration schemes separate IDs with ampersand: `fieldConfigurationSchemeId=10000&fieldConfigurationSchemeId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanFieldConfigurationIssueTypeItem&gt;
   */
  public Single<PageBeanFieldConfigurationIssueTypeItem> getFieldConfigurationSchemeMappings(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<Long>> fieldConfigurationSchemeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfigurationscheme/mapping");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (fieldConfigurationSchemeId.isPresent()) {
      queryParams.put("fieldConfigurationSchemeId", RestClientUtil.objectCollectionToStringCollection(fieldConfigurationSchemeId.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getFieldConfigurationSchemeMappings);
  }

  /**
   * Get field configuration schemes for projects
   * Returns a [paginated](#pagination) list of field configuration schemes and, for each scheme, a list of the projects that use it.  The list is sorted by field configuration scheme ID. The first item contains the list of project IDs assigned to the default field configuration scheme.  Only field configuration schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param projectId The list of project IDs. To include multiple projects, separate IDs with ampersand: `projectId=10000&projectId=10001`. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanFieldConfigurationSchemeProjects&gt;
   */
  public Single<PageBeanFieldConfigurationSchemeProjects> getFieldConfigurationSchemeProjectMapping(
    List<Long> projectId, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfigurationscheme/project");

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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getFieldConfigurationSchemeProjectMapping);
  }

  /**
   * Remove issue types from field configuration scheme
   * Removes issue types from the field configuration scheme.  This operation can only modify field configuration schemes used in company-managed (classic) projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the field configuration scheme. (required)
   * @param issueTypeIdsToRemove The issue type IDs to remove. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> removeIssueTypesFromGlobalFieldConfigurationScheme(
    Long id, IssueTypeIdsToRemove issueTypeIdsToRemove, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfigurationscheme/{id}/mapping/delete");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeIdsToRemove));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeIssueTypesFromGlobalFieldConfigurationScheme);
  }

  /**
   * Assign issue types to field configurations
   * Assigns issue types to field configurations on field configuration scheme.  This operation can only modify field configuration schemes used in company-managed (classic) projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the field configuration scheme. (required)
   * @param associateFieldConfigurationsWithIssueTypesRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setFieldConfigurationSchemeMapping(
    Long id, AssociateFieldConfigurationsWithIssueTypesRequest associateFieldConfigurationsWithIssueTypesRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfigurationscheme/{id}/mapping");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(associateFieldConfigurationsWithIssueTypesRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setFieldConfigurationSchemeMapping);
  }

  /**
   * Update field configuration
   * Updates a field configuration. The name and the description provided in the request override the existing values.  This operation can only update configurations used in company-managed (classic) projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the field configuration. (required)
   * @param fieldConfigurationDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateFieldConfiguration(
    Long id, FieldConfigurationDetails fieldConfigurationDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfiguration/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(fieldConfigurationDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateFieldConfiguration);
  }

  /**
   * Update field configuration items
   * Updates fields in a field configuration. The properties of the field configuration fields provided override the existing values.  This operation can only update field configurations used in company-managed (classic) projects.  The operation can set the renderer for text fields to the default text renderer (`text-renderer`) or wiki style renderer (`wiki-renderer`). However, the renderer cannot be updated for fields using the autocomplete renderer (`autocomplete-renderer`).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the field configuration. (required)
   * @param fieldConfigurationItemsDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateFieldConfigurationItems(
    Long id, FieldConfigurationItemsDetails fieldConfigurationItemsDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfiguration/{id}/fields");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(fieldConfigurationItemsDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateFieldConfigurationItems);
  }

  /**
   * Update field configuration scheme
   * Updates a field configuration scheme.  This operation can only update field configuration schemes used in company-managed (classic) projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param id The ID of the field configuration scheme. (required)
   * @param updateFieldConfigurationSchemeDetails The details of the field configuration scheme. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateFieldConfigurationScheme(
    Long id, UpdateFieldConfigurationSchemeDetails updateFieldConfigurationSchemeDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/fieldconfigurationscheme/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(updateFieldConfigurationSchemeDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateFieldConfigurationScheme);
  }

}
