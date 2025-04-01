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

import org.everit.atlassian.restclient.jiracloud.v2.model.AvailableDashboardGadgetsResponse;
import org.everit.atlassian.restclient.jiracloud.v2.model.BulkEditShareableEntityRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.BulkEditShareableEntityResponse;
import org.everit.atlassian.restclient.jiracloud.v2.model.Dashboard;
import org.everit.atlassian.restclient.jiracloud.v2.model.DashboardDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.DashboardGadget;
import org.everit.atlassian.restclient.jiracloud.v2.model.DashboardGadgetResponse;
import org.everit.atlassian.restclient.jiracloud.v2.model.DashboardGadgetSettings;
import org.everit.atlassian.restclient.jiracloud.v2.model.DashboardGadgetUpdateRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.EntityProperty;
import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanDashboard;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageOfDashboards;
import org.everit.atlassian.restclient.jiracloud.v2.model.PropertyKeys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<DashboardGadget> returnType_addGadget = new TypeReference<DashboardGadget>() {};

  private static final TypeReference<BulkEditShareableEntityResponse> returnType_bulkEditDashboards = new TypeReference<BulkEditShareableEntityResponse>() {};

  private static final TypeReference<Dashboard> returnType_copyDashboard = new TypeReference<Dashboard>() {};

  private static final TypeReference<Dashboard> returnType_createDashboard = new TypeReference<Dashboard>() {};

  private static final TypeReference<Object> returnType_deleteDashboardItemProperty = new TypeReference<Object>() {};

  private static final TypeReference<AvailableDashboardGadgetsResponse> returnType_getAllAvailableDashboardGadgets = new TypeReference<AvailableDashboardGadgetsResponse>() {};

  private static final TypeReference<PageOfDashboards> returnType_getAllDashboards = new TypeReference<PageOfDashboards>() {};

  private static final TypeReference<DashboardGadgetResponse> returnType_getAllGadgets = new TypeReference<DashboardGadgetResponse>() {};

  private static final TypeReference<Dashboard> returnType_getDashboard = new TypeReference<Dashboard>() {};

  private static final TypeReference<EntityProperty> returnType_getDashboardItemProperty = new TypeReference<EntityProperty>() {};

  private static final TypeReference<PropertyKeys> returnType_getDashboardItemPropertyKeys = new TypeReference<PropertyKeys>() {};

  private static final TypeReference<PageBeanDashboard> returnType_getDashboardsPaginated = new TypeReference<PageBeanDashboard>() {};

  private static final TypeReference<Object> returnType_removeGadget = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_setDashboardItemProperty = new TypeReference<Object>() {};

  private static final TypeReference<Dashboard> returnType_updateDashboard = new TypeReference<Dashboard>() {};

  private static final TypeReference<Object> returnType_updateGadget = new TypeReference<Object>() {};

  private final RestClient restClient;

  public DashboardsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add gadget to dashboard
   * Adds a gadget to a dashboard.  **[Permissions](#permissions) required:** None.
   * @param dashboardId The ID of the dashboard. (required)
   * @param dashboardGadgetSettings  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;DashboardGadget&gt;
   */
  public Single<DashboardGadget> addGadget(
    Long dashboardId, DashboardGadgetSettings dashboardGadgetSettings, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{dashboardId}/gadget");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(dashboardGadgetSettings));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addGadget);
  }

  /**
   * Bulk edit dashboards
   * Bulk edit dashboards. Maximum number of dashboards to be edited at the same time is 100.  **[Permissions](#permissions) required:** None  The dashboards to be updated must be owned by the user, or the user must be an administrator.
   * @param bulkEditShareableEntityRequest The details of dashboards being updated in bulk. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;BulkEditShareableEntityResponse&gt;
   */
  public Single<BulkEditShareableEntityResponse> bulkEditDashboards(
    BulkEditShareableEntityRequest bulkEditShareableEntityRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/bulk/edit");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(bulkEditShareableEntityRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_bulkEditDashboards);
  }

  /**
   * Copy dashboard
   * Copies a dashboard. Any values provided in the `dashboard` parameter replace those in the copied dashboard.  **[Permissions](#permissions) required:** None  The dashboard to be copied must be owned by or shared with the user.
   * @param id  (required)
   * @param dashboardDetails Dashboard details. (required)
   * @param extendAdminPermissions Whether admin level permissions are used. It should only be true if the user has *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Dashboard&gt;
   */
  public Single<Dashboard> copyDashboard(
    String id, DashboardDetails dashboardDetails, Optional<Boolean> extendAdminPermissions, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{id}/copy");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (extendAdminPermissions.isPresent()) {
      queryParams.put("extendAdminPermissions", Collections.singleton(String.valueOf(extendAdminPermissions.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(dashboardDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_copyDashboard);
  }

  /**
   * Create dashboard
   * Creates a dashboard.  **[Permissions](#permissions) required:** None.
   * @param dashboardDetails Dashboard details. (required)
   * @param extendAdminPermissions Whether admin level permissions are used. It should only be true if the user has *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Dashboard&gt;
   */
  public Single<Dashboard> createDashboard(
    DashboardDetails dashboardDetails, Optional<Boolean> extendAdminPermissions, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (extendAdminPermissions.isPresent()) {
      queryParams.put("extendAdminPermissions", Collections.singleton(String.valueOf(extendAdminPermissions.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(dashboardDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createDashboard);
  }

  /**
   * Delete dashboard
   * Deletes a dashboard.  **[Permissions](#permissions) required:** None  The dashboard to be deleted must be owned by the user.
   * @param id The ID of the dashboard. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteDashboard(
    String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Delete dashboard item property
   * Deletes a dashboard item property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard.
   * @param dashboardId The ID of the dashboard. (required)
   * @param itemId The ID of the dashboard item. (required)
   * @param propertyKey The key of the dashboard item property. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteDashboardItemProperty(
    String dashboardId, String itemId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    pathParams.put("itemId", String.valueOf(itemId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_deleteDashboardItemProperty);
  }

  /**
   * Get available gadgets
   * Gets a list of all available gadgets that can be added to all dashboards.  **[Permissions](#permissions) required:** None.
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;AvailableDashboardGadgetsResponse&gt;
   */
  public Single<AvailableDashboardGadgetsResponse> getAllAvailableDashboardGadgets(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/gadgets");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllAvailableDashboardGadgets);
  }

  /**
   * Get all dashboards
   * Returns a list of dashboards owned by or shared with the user. The list may be filtered to include only favorite or owned dashboards.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
   * @param filter The filter applied to the list of dashboards. Valid values are:   *  `favourite` Returns dashboards the user has marked as favorite.  *  `my` Returns dashboards owned by the user. (optional)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0)
   * @param maxResults The maximum number of items to return per page. (optional, default to 20)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageOfDashboards&gt;
   */
  public Single<PageOfDashboards> getAllDashboards(
    Optional<String> filter, Optional<Integer> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (filter.isPresent()) {
      queryParams.put("filter", Collections.singleton(String.valueOf(filter.get())));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllDashboards);
  }

  /**
   * Get gadgets
   * Returns a list of dashboard gadgets on a dashboard.  This operation returns:   *  Gadgets from a list of IDs, when `id` is set.  *  Gadgets with a module key, when `moduleKey` is set.  *  Gadgets from a list of URIs, when `uri` is set.  *  All gadgets, when no other parameters are set.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
   * @param dashboardId The ID of the dashboard. (required)
   * @param moduleKey The list of gadgets module keys. To include multiple module keys, separate module keys with ampersand: `moduleKey=key:one&moduleKey=key:two`. (optional, default to new ArrayList&lt;&gt;())
   * @param uri The list of gadgets URIs. To include multiple URIs, separate URIs with ampersand: `uri=/rest/example/uri/1&uri=/rest/example/uri/2`. (optional, default to new ArrayList&lt;&gt;())
   * @param gadgetId The list of gadgets IDs. To include multiple IDs, separate IDs with ampersand: `gadgetId=10000&gadgetId=10001`. (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;DashboardGadgetResponse&gt;
   */
  public Single<DashboardGadgetResponse> getAllGadgets(
    Long dashboardId, Optional<List<String>> moduleKey, Optional<List<String>> uri, Optional<List<Long>> gadgetId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{dashboardId}/gadget");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (moduleKey.isPresent()) {
      queryParams.put("moduleKey", RestClientUtil.objectCollectionToStringCollection(moduleKey.get()));
    }
    if (uri.isPresent()) {
      queryParams.put("uri", RestClientUtil.objectCollectionToStringCollection(uri.get()));
    }
    if (gadgetId.isPresent()) {
      queryParams.put("gadgetId", RestClientUtil.objectCollectionToStringCollection(gadgetId.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllGadgets);
  }

  /**
   * Get dashboard
   * Returns a dashboard.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.  However, to get a dashboard, the dashboard must be shared with the user or the user must own it. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users.
   * @param id The ID of the dashboard. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Dashboard&gt;
   */
  public Single<Dashboard> getDashboard(
    String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getDashboard);
  }

  /**
   * Get dashboard item property
   * Returns the key and value of a dashboard item property.  A dashboard item enables an app to add user-specific information to a user dashboard. Dashboard items are exposed to users as gadgets that users can add to their dashboards. For more information on how users do this, see [Adding and customizing gadgets](https://confluence.atlassian.com/x/7AeiLQ).  When an app creates a dashboard item it registers a callback to receive the dashboard item ID. The callback fires whenever the item is rendered or, where the item is configurable, the user edits the item. The app then uses this resource to store the item's content or configuration details. For more information on working with dashboard items, see [ Building a dashboard item for a JIRA Connect add-on](https://developer.atlassian.com/server/jira/platform/guide-building-a-dashboard-item-for-a-jira-connect-add-on-33746254/) and the [Dashboard Item](https://developer.atlassian.com/cloud/jira/platform/modules/dashboard-item/) documentation.  There is no resource to set or get dashboard items.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard or have the dashboard shared with them. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users, and is accessible to anonymous users when Jira\\\\u2019s anonymous access is permitted.
   * @param dashboardId The ID of the dashboard. (required)
   * @param itemId The ID of the dashboard item. (required)
   * @param propertyKey The key of the dashboard item property. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getDashboardItemProperty(
    String dashboardId, String itemId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    pathParams.put("itemId", String.valueOf(itemId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getDashboardItemProperty);
  }

  /**
   * Get dashboard item property keys
   * Returns the keys of all properties for a dashboard item.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard or have the dashboard shared with them. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users, and is accessible to anonymous users when Jira\\\\u2019s anonymous access is permitted.
   * @param dashboardId The ID of the dashboard. (required)
   * @param itemId The ID of the dashboard item. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getDashboardItemPropertyKeys(
    String dashboardId, String itemId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{dashboardId}/items/{itemId}/properties");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    pathParams.put("itemId", String.valueOf(itemId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getDashboardItemPropertyKeys);
  }

  /**
   * Search for dashboards
   * Returns a [paginated](#pagination) list of dashboards. This operation is similar to [Get dashboards](#api-rest-api-2-dashboard-get) except that the results can be refined to include dashboards that have specific attributes. For example, dashboards with a particular name. When multiple attributes are specified only filters matching all attributes are returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The following dashboards that match the query parameters are returned:   *  Dashboards owned by the user. Not returned for anonymous users.  *  Dashboards shared with a group that the user is a member of. Not returned for anonymous users.  *  Dashboards shared with a private project that the user can browse. Not returned for anonymous users.  *  Dashboards shared with a public project.  *  Dashboards shared with the public.
   * @param dashboardName String used to perform a case-insensitive partial match with `name`. (optional)
   * @param accountId User account ID used to return dashboards with the matching `owner.accountId`. This parameter cannot be used with the `owner` parameter. (optional)
   * @param owner This parameter is deprecated because of privacy changes. Use `accountId` instead. See the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details. User name used to return dashboards with the matching `owner.name`. This parameter cannot be used with the `accountId` parameter. (optional)
   * @param groupname As a group's name can change, use of `groupId` is recommended. Group name used to return dashboards that are shared with a group that matches `sharePermissions.group.name`. This parameter cannot be used with the `groupId` parameter. (optional)
   * @param groupId Group ID used to return dashboards that are shared with a group that matches `sharePermissions.group.groupId`. This parameter cannot be used with the `groupname` parameter. (optional)
   * @param projectId Project ID used to returns dashboards that are shared with a project that matches `sharePermissions.project.id`. (optional)
   * @param orderBy [Order](#ordering) the results by a field:   *  `description` Sorts by dashboard description. Note that this sort works independently of whether the expand to display the description field is in use.  *  `favourite_count` Sorts by dashboard popularity.  *  `id` Sorts by dashboard ID.  *  `is_favourite` Sorts by whether the dashboard is marked as a favorite.  *  `name` Sorts by dashboard name.  *  `owner` Sorts by dashboard owner name. (optional, default to name)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param status The status to filter by. It may be active, archived or deleted. (optional, default to active)
   * @param expand Use [expand](#expansion) to include additional information about dashboard in the response. This parameter accepts a comma-separated list. Expand options include:   *  `description` Returns the description of the dashboard.  *  `owner` Returns the owner of the dashboard.  *  `viewUrl` Returns the URL that is used to view the dashboard.  *  `favourite` Returns `isFavourite`, an indicator of whether the user has set the dashboard as a favorite.  *  `favouritedCount` Returns `popularity`, a count of how many users have set this dashboard as a favorite.  *  `sharePermissions` Returns details of the share permissions defined for the dashboard.  *  `editPermissions` Returns details of the edit permissions defined for the dashboard.  *  `isWritable` Returns whether the current user has permission to edit the dashboard. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanDashboard&gt;
   */
  public Single<PageBeanDashboard> getDashboardsPaginated(
    Optional<String> dashboardName, Optional<String> accountId, Optional<String> owner, Optional<String> groupname, Optional<String> groupId, Optional<Long> projectId, Optional<String> orderBy, Optional<Long> startAt, Optional<Integer> maxResults, Optional<String> status, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (dashboardName.isPresent()) {
      queryParams.put("dashboardName", Collections.singleton(String.valueOf(dashboardName.get())));
    }
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (owner.isPresent()) {
      queryParams.put("owner", Collections.singleton(String.valueOf(owner.get())));
    }
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    if (groupId.isPresent()) {
      queryParams.put("groupId", Collections.singleton(String.valueOf(groupId.get())));
    }
    if (projectId.isPresent()) {
      queryParams.put("projectId", Collections.singleton(String.valueOf(projectId.get())));
    }
    if (orderBy.isPresent()) {
      queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (status.isPresent()) {
      queryParams.put("status", Collections.singleton(String.valueOf(status.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getDashboardsPaginated);
  }

  /**
   * Remove gadget from dashboard
   * Removes a dashboard gadget from a dashboard.  When a gadget is removed from a dashboard, other gadgets in the same column are moved up to fill the emptied position.  **[Permissions](#permissions) required:** None.
   * @param dashboardId The ID of the dashboard. (required)
   * @param gadgetId The ID of the gadget. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> removeGadget(
    Long dashboardId, Long gadgetId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{dashboardId}/gadget/{gadgetId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    pathParams.put("gadgetId", String.valueOf(gadgetId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeGadget);
  }

  /**
   * Set dashboard item property
   * Sets the value of a dashboard item property. Use this resource in apps to store custom data against a dashboard item.  A dashboard item enables an app to add user-specific information to a user dashboard. Dashboard items are exposed to users as gadgets that users can add to their dashboards. For more information on how users do this, see [Adding and customizing gadgets](https://confluence.atlassian.com/x/7AeiLQ).  When an app creates a dashboard item it registers a callback to receive the dashboard item ID. The callback fires whenever the item is rendered or, where the item is configurable, the user edits the item. The app then uses this resource to store the item's content or configuration details. For more information on working with dashboard items, see [ Building a dashboard item for a JIRA Connect add-on](https://developer.atlassian.com/server/jira/platform/guide-building-a-dashboard-item-for-a-jira-connect-add-on-33746254/) and the [Dashboard Item](https://developer.atlassian.com/cloud/jira/platform/modules/dashboard-item/) documentation.  There is no resource to set or get dashboard items.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard.
   * @param dashboardId The ID of the dashboard. (required)
   * @param itemId The ID of the dashboard item. (required)
   * @param propertyKey The key of the dashboard item property. The maximum length is 255 characters. For dashboard items with a spec URI and no complete module key, if the provided propertyKey is equal to \"config\", the request body's JSON must be an object with all keys and values as strings. (required)
   * @param body The value of the property. The value has to be a valid, non-empty [JSON](https://tools.ietf.org/html/rfc4627) value. The maximum length of the property value is 32768 bytes. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setDashboardItemProperty(
    String dashboardId, String itemId, String propertyKey, Object body, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    pathParams.put("itemId", String.valueOf(itemId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(body));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setDashboardItemProperty);
  }

  /**
   * Update dashboard
   * Updates a dashboard, replacing all the dashboard details with those provided.  **[Permissions](#permissions) required:** None  The dashboard to be updated must be owned by the user.
   * @param id The ID of the dashboard to update. (required)
   * @param dashboardDetails Replacement dashboard details. (required)
   * @param extendAdminPermissions Whether admin level permissions are used. It should only be true if the user has *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Dashboard&gt;
   */
  public Single<Dashboard> updateDashboard(
    String id, DashboardDetails dashboardDetails, Optional<Boolean> extendAdminPermissions, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (extendAdminPermissions.isPresent()) {
      queryParams.put("extendAdminPermissions", Collections.singleton(String.valueOf(extendAdminPermissions.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(dashboardDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateDashboard);
  }

  /**
   * Update gadget on dashboard
   * Changes the title, position, and color of the gadget on a dashboard.  **[Permissions](#permissions) required:** None.
   * @param dashboardId The ID of the dashboard. (required)
   * @param gadgetId The ID of the gadget. (required)
   * @param dashboardGadgetUpdateRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateGadget(
    Long dashboardId, Long gadgetId, DashboardGadgetUpdateRequest dashboardGadgetUpdateRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/dashboard/{dashboardId}/gadget/{gadgetId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    pathParams.put("gadgetId", String.valueOf(gadgetId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(dashboardGadgetUpdateRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateGadget);
  }

}
