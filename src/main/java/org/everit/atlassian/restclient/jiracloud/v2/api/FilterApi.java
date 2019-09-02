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

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.restclient.RestCallUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;

import org.everit.http.client.HttpClient;
import org.everit.http.client.HttpMethod;
import org.everit.http.client.HttpRequest;

import org.everit.atlassian.restclient.jiracloud.v2.model.ColumnItem;
import org.everit.atlassian.restclient.jiracloud.v2.model.DefaultShareScope;
import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.Filter;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanFoundFilter;
import org.everit.atlassian.restclient.jiracloud.v2.model.SharePermission;
import org.everit.atlassian.restclient.jiracloud.v2.model.SharePermissionInputBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<List<SharePermission>> returnType_addSharePermission = new TypeReference<List<SharePermission>>() {};

  private static final TypeReference<Filter> returnType_createFilter = new TypeReference<Filter>() {};

  private static final TypeReference<Filter> returnType_deleteFavouriteForFilter = new TypeReference<Filter>() {};

  private static final TypeReference<List<ColumnItem>> returnType_getColumns = new TypeReference<List<ColumnItem>>() {};

  private static final TypeReference<DefaultShareScope> returnType_getDefaultShareScope = new TypeReference<DefaultShareScope>() {};

  private static final TypeReference<List<Filter>> returnType_getFavouriteFilters = new TypeReference<List<Filter>>() {};

  private static final TypeReference<Filter> returnType_getFilter = new TypeReference<Filter>() {};

  private static final TypeReference<List<Filter>> returnType_getFilters = new TypeReference<List<Filter>>() {};

  private static final TypeReference<PageBeanFoundFilter> returnType_getFiltersPaginated = new TypeReference<PageBeanFoundFilter>() {};

  private static final TypeReference<List<Filter>> returnType_getMyFilters = new TypeReference<List<Filter>>() {};

  private static final TypeReference<SharePermission> returnType_getSharePermission = new TypeReference<SharePermission>() {};

  private static final TypeReference<List<SharePermission>> returnType_getSharePermissions = new TypeReference<List<SharePermission>>() {};

  private static final TypeReference<Object> returnType_setColumns = new TypeReference<Object>() {};

  private static final TypeReference<DefaultShareScope> returnType_setDefaultShareScope = new TypeReference<DefaultShareScope>() {};

  private static final TypeReference<Filter> returnType_setFavouriteForFilter = new TypeReference<Filter>() {};

  private static final TypeReference<Filter> returnType_updateFilter = new TypeReference<Filter>() {};

  private final HttpClient httpClient;

  public FilterApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Add share permission
   * <p>Add a share permissions to a filter. If you add a global share permission (one for all logged-in users or the public) it will overwrite all share permissions for the filter.</p> <p>Be aware that this operation uses different objects for updating share permissions compared to <a href=\"#api-rest-api-2-filter-id-put\">Update filter</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Share dashboards and filters</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> and the user must own the filter.</p> 
   * @param id <p>The ID of the filter.</p>  (required)
   * @param sharePermissionInputBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;SharePermission&gt;&gt;
   */
  public Single<List<SharePermission>> addSharePermission(
    Long id, SharePermissionInputBean sharePermissionInputBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}/permission");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(sharePermissionInputBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_addSharePermission);
  }

  /**
   * Create filter
   * <p>Creates a filter. The filter is shared according to the <a href=\"#api-rest-api-2-filter-post\">default share scope</a>. The filter is not selected as a favorite.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param filter <p>The filter to create.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about filter in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>sharedUsers</code> Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don't specify <code>sharedUsers</code>, then the <code>sharedUsers</code> object is returned but it doesn't list any users. The list of users returned is limited to 1000, to access additional users append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 users, use <code>?expand=sharedUsers[1001:2000]</code>.</li> <li><code>subscriptions</code> Returns the users that are subscribed to the filter. If you don't specify <code>subscriptions</code>, the <code>subscriptions</code> object is returned but it doesn't list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 subscriptions, use <code>?expand=subscriptions[1001:2000]</code>.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Filter&gt;
   */
  public Single<Filter> createFilter(
    Filter filter, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(filter));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_createFilter);
  }

  /**
   * Remove filter as favorite
   * <p>Removes a filter as a favorite for the user. Note that this operation only removes filters visible to the user from the user's favorites list. For example, if the user favorites a public filter that is subsequently made private (and is therefore no longer visible on their favorites list) they cannot remove it from their favorites list.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param id <p>The ID of the filter.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about filter in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>sharedUsers</code> Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don't specify <code>sharedUsers</code>, then the <code>sharedUsers</code> object is returned but it doesn't list any users. The list of users returned is limited to 1000, to access additional users append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 users, use <code>?expand=sharedUsers[1001:2000]</code>.</li> <li><code>subscriptions</code> Returns the users that are subscribed to the filter. If you don't specify <code>subscriptions</code>, the <code>subscriptions</code> object is returned but it doesn't list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 subscriptions, use <code>?expand=subscriptions[1001:2000]</code>.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Filter&gt;
   */
  public Single<Filter> deleteFavouriteForFilter(
    Long id, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}/favourite");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_deleteFavouriteForFilter);
  }

  /**
   * Delete filter
   * <p>Delete a filter.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however filters can only be deleted by the creator of the filter or a user with <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the filter to delete.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteFilter(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Delete share permission
   * <p>Deletes a share permission from a filter.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira and the user must own the filter.</p> 
   * @param id <p>The ID of the filter.</p>  (required)
   * @param permissionId <p>The ID of the share permission.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteSharePermission(
    Long id, Long permissionId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}/permission/{permissionId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    pathParams.put("permissionId", String.valueOf(permissionId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get columns
   * <p>Returns the columns configured for a filter. The column configuration is used when the filter's results are viewed in <em>List View</em> with the <em>Columns</em> set to <em>Filter</em>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None, however, column details are only returned for:</p> <ul> <li>filters owned by the user.</li> <li>filters shared with a group that the user is a member of.</li> <li>filters shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>filters shared with a public project.</li> <li>filters shared with the public.</li> </ul> 
   * @param id <p>The ID of the filter.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ColumnItem&gt;&gt;
   */
  public Single<List<ColumnItem>> getColumns(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}/columns");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getColumns);
  }

  /**
   * Get default share scope
   * <p>Returns the default sharing settings for new filters and dashboards for a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;DefaultShareScope&gt;
   */
  public Single<DefaultShareScope> getDefaultShareScope(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/defaultShareScope");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getDefaultShareScope);
  }

  /**
   * Get favorite filters
   * <p>Returns the visible favorite filters of the user.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> A favorite filter is only visible to the user where the filter is:</p> <ul> <li>owned by the user.</li> <li>shared with a group that the user is a member of.</li> <li>shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>shared with a public project.</li> <li>shared with the public.</li> </ul> <p>For example, if the user favorites a public filter that is subsequently made private that filter is not returned by this operation.</p> 
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about filter in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>sharedUsers</code> Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don't specify <code>sharedUsers</code>, then the <code>sharedUsers</code> object is returned but it doesn't list any users. The list of users returned is limited to 1000, to access additional users append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 users, use <code>?expand=sharedUsers[1001:2000]</code>.</li> <li><code>subscriptions</code> Returns the users that are subscribed to the filter. If you don't specify <code>subscriptions</code>, the <code>subscriptions</code> object is returned but it doesn't list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 subscriptions, use <code>?expand=subscriptions[1001:2000]</code>.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Filter&gt;&gt;
   */
  public Single<List<Filter>> getFavouriteFilters(
    Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/favourite");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getFavouriteFilters);
  }

  /**
   * Get filter
   * <p>Returns a filter.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None, however, the filter is only returned where it is:</p> <ul> <li>owned by the user.</li> <li>shared with a group that the user is a member of.</li> <li>shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>shared with a public project.</li> <li>shared with the public.</li> </ul> 
   * @param id <p>The ID of the filter to return.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about filter in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>sharedUsers</code> Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don't specify <code>sharedUsers</code>, then the <code>sharedUsers</code> object is returned but it doesn't list any users. The list of users returned is limited to 1000, to access additional users append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 users, use <code>?expand=sharedUsers[1001:2000]</code>.</li> <li><code>subscriptions</code> Returns the users that are subscribed to the filter. If you don't specify <code>subscriptions</code>, the <code>subscriptions</code> object is returned but it doesn't list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 subscriptions, use <code>?expand=subscriptions[1001:2000]</code>.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Filter&gt;
   */
  public Single<Filter> getFilter(
    Long id, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getFilter);
  }

  /**
   * Get filters
   * <p>Returns all filters. Deprecated, use <a href=\"#api-rest-api-2-filter-search-get\"> Search for filters</a> that supports search and pagination.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None, however, only the following filters are returned:</p> <ul> <li>filters owned by the user.</li> <li>filters shared with a group that the user is a member of.</li> <li>filters shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>filters shared with a public project.</li> <li>filters shared with the public.</li> </ul> 
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about filter in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>sharedUsers</code> Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don't specify <code>sharedUsers</code>, then the <code>sharedUsers</code> object is returned but it doesn't list any users. The list of users returned is limited to 1000, to access additional users append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 users, use <code>?expand=sharedUsers[1001:2000]</code>.</li> <li><code>subscriptions</code> Returns the users that are subscribed to the filter. If you don't specify <code>subscriptions</code>, the <code>subscriptions</code> object is returned but it doesn't list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 subscriptions, use <code>?expand=subscriptions[1001:2000]</code>.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Filter&gt;&gt;
   * @deprecated
   */
  @Deprecated
  public Single<List<Filter>> getFilters(
    Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getFilters);
  }

  /**
   * Search for filters
   * <p>Searches for filters. This operation is similar to <a href=\"#api-rest-api-2-filter-get\">Get filters</a> except that the results can be refined to include filters that have specific attributes. For example, filters with a particular name. When multiple attributes are specified only filters matching all attributes are returned.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None, however, only the following filters that match the query parameters are returned:</p> <ul> <li>filters owned by the user.</li> <li>filters shared with a group that the user is a member of.</li> <li>filters shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>filters shared with a public project.</li> <li>filters shared with the public.</li> </ul> 
   * @param filterName <p>String used to perform a case-insensitive partial match with <code>name</code>.</p>  (optional)
   * @param accountId <p>User account ID used to return filters with the matching <code>owner.accountId</code>. This parameter cannot be used with <code>owner</code>.</p>  (optional)
   * @param owner <p>This parameter is deprecated because of privacy changes. Use <code>accountId</code> instead. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">migration guide</a> for details. User name used to return filters with the matching <code>owner.name</code>. This parameter cannot be used with <code>accountId</code>.</p>  (optional)
   * @param groupname <p>Group name used to returns filters that are shared with a group that matches <code>sharePermissions.group.groupname</code>.</p>  (optional)
   * @param projectId <p>Project ID used to returns filters that are shared with a project that matches <code>sharePermissions.project.id</code>.</p>  (optional)
   * @param orderBy <p><a href=\"#ordering\">Orders</a> the results using one of these filter properties:</p> <ul> <li><code>description</code> Orders by filter <code>description</code>. Note that this ordering works independently of whether the expand to display the description field is in use.</li> <li><code>favourite_count</code> Orders by <code>favouritedCount</code>.</li> <li><code>is_favourite</code> Orders by <code>favourite</code>.</li> <li><code>id</code> Orders by filter <code>id</code>.</li> <li><code>name</code> Orders by filter <code>name</code>.</li> <li><code>owner</code> Orders by <code>owner.accountId</code>.</li> </ul>  (optional, default to name)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>100</code>.</p>  (optional, default to 50)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about filter in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>description</code> Returns the description of the filter.</li> <li><code>favourite</code> Returns an indicator of whether the user has set the filter as a favorite.</li> <li><code>favouritedCount</code> Returns a count of how many users have set this filter as a favorite.</li> <li><code>jql</code> Returns the JQL query that the filter uses.</li> <li><code>owner</code> Returns the owner of the filter.</li> <li><code>searchUrl</code> Returns a URL to perform the filter's JQL query.</li> <li><code>sharePermissions</code> Returns the share permissions defined for the filter.</li> <li><code>subscriptions</code> Returns the users that are subscribed to the filter.</li> <li><code>viewUrl</code> Returns a URL to view the filter.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanFoundFilter&gt;
   */
  public Single<PageBeanFoundFilter> getFiltersPaginated(
    Optional<String> filterName, Optional<String> accountId, Optional<String> owner, Optional<String> groupname, Optional<Long> projectId, Optional<String> orderBy, Optional<Long> startAt, Optional<Integer> maxResults, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (filterName.isPresent()) {
      queryParams.put("filterName", Collections.singleton(String.valueOf(filterName.get())));
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
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getFiltersPaginated);
  }

  /**
   * Get my filters
   * <p>Returns the filters owned by the user. If <code>includeFavourites</code> is <code>true</code>, the user's visible favorite filters are also returned.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however, a favorite filters is only visible to the user where the filter is:</p> <ul> <li>owned by the user.</li> <li>shared with a group that the user is a member of.</li> <li>shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>shared with a public project.</li> <li>shared with the public.</li> </ul> <p>For example, if the user favorites a public filter that is subsequently made private that filter is not returned by this operation.</p> 
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about filter in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>sharedUsers</code> Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don't specify <code>sharedUsers</code>, then the <code>sharedUsers</code> object is returned but it doesn't list any users. The list of users returned is limited to 1000, to access additional users append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 users, use <code>?expand=sharedUsers[1001:2000]</code>.</li> <li><code>subscriptions</code> Returns the users that are subscribed to the filter. If you don't specify <code>subscriptions</code>, the <code>subscriptions</code> object is returned but it doesn't list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 subscriptions, use <code>?expand=subscriptions[1001:2000]</code>.</li> </ul>  (optional)
   * @param includeFavourites <p>Include the user's favorite filters in the response.</p>  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Filter&gt;&gt;
   */
  public Single<List<Filter>> getMyFilters(
    Optional<String> expand, Optional<Boolean> includeFavourites, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/my");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    if (includeFavourites.isPresent()) {
      queryParams.put("includeFavourites", Collections.singleton(String.valueOf(includeFavourites.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getMyFilters);
  }

  /**
   * Get share permission
   * <p>Returns a share permission for a filter. A filter can be shared with groups, projects, all logged-in users, or the public. Sharing with all logged-in users or the public is known as a global share permission.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None, however, a share permission is only returned for:</p> <ul> <li>filters owned by the user.</li> <li>filters shared with a group that the user is a member of.</li> <li>filters shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>filters shared with a public project.</li> <li>filters shared with the public.</li> </ul> 
   * @param id <p>The ID of the filter.</p>  (required)
   * @param permissionId <p>The ID of the share permission.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SharePermission&gt;
   */
  public Single<SharePermission> getSharePermission(
    Long id, Long permissionId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}/permission/{permissionId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    pathParams.put("permissionId", String.valueOf(permissionId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getSharePermission);
  }

  /**
   * Get share permissions
   * <p>Returns the share permissions for a filter. A filter can be shared with groups, projects, all logged-in users, or the public. Sharing with all logged-in users or the public is known as a global share permission.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None, however, share permissions are only returned for:</p> <ul> <li>filters owned by the user.</li> <li>filters shared with a group that the user is a member of.</li> <li>filters shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>filters shared with a public project.</li> <li>filters shared with the public.</li> </ul> 
   * @param id <p>The ID of the filter.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;SharePermission&gt;&gt;
   */
  public Single<List<SharePermission>> getSharePermissions(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}/permission");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getSharePermissions);
  }

  /**
   * Reset columns
   * <p>Reset the user's column configuration for the filter to the default.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however, columns are only reset for:</p> <ul> <li>filters owned by the user.</li> <li>filters shared with a group that the user is a member of.</li> <li>filters shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>filters shared with a public project.</li> <li>filters shared with the public.</li> </ul> 
   * @param id <p>The ID of the filter.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable resetColumns(
    Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}/columns");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Set columns
   * <p>Sets the columns for a filter. Only navigable fields can be set as columns. Use <a href=\"#api-rest-api-2-field-get\">Get fields</a> to get the list fields in Jira. A navigable field has <code>navigable</code> set to <code>true</code>.</p> <p>The parameters for this resource are expressed as HTML form data. For example, in curl:</p> <p><code>curl -X PUT -d columns=summary -d columns=description https://your-domain.atlassian.net/rest/api/2/filter/10000/columns</code></p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however, columns are only set for:</p> <ul> <li>filters owned by the user.</li> <li>filters shared with a group that the user is a member of.</li> <li>filters shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>filters shared with a public project.</li> <li>filters shared with the public.</li> </ul> 
   * @param id <p>The ID of the filter.</p>  (required)
   * @param requestBody <p>The IDs of the fields to set as columns. In the form data, specify each field as <code>columns=id</code>, where <code>id</code> is the <em>id</em> of a field (as seen in the response for <a href=\"#api-rest-api-&lt;ver&gt;-field-get\">Get fields</a>). For example, <code>columns=summary</code>.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setColumns(
    Long id, Optional<List<String>> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}/columns");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(requestBody);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_setColumns);
  }

  /**
   * Set default share scope
   * <p>Sets the default sharing for new filters and dashboards for a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param defaultShareScope  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;DefaultShareScope&gt;
   */
  public Single<DefaultShareScope> setDefaultShareScope(
    DefaultShareScope defaultShareScope, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/defaultShareScope");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(defaultShareScope));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_setDefaultShareScope);
  }

  /**
   * Add filter as favorite
   * <p>Add a filter as a favorite for the user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however, the user can only favorite:</p> <ul> <li>filters owned by the user.</li> <li>filters shared with a group that the user is a member of.</li> <li>filters shared with a private project that the user has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.</li> <li>filters shared with a public project.</li> <li>filters shared with the public.</li> </ul> 
   * @param id <p>The ID of the filter.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about filter in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>sharedUsers</code> Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don't specify <code>sharedUsers</code>, then the <code>sharedUsers</code> object is returned but it doesn't list any users. The list of users returned is limited to 1000, to access additional users append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 users, use <code>?expand=sharedUsers[1001:2000]</code>.</li> <li><code>subscriptions</code> Returns the users that are subscribed to the filter. If you don't specify <code>subscriptions</code>, the <code>subscriptions</code> object is returned but it doesn't list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 subscriptions, use <code>?expand=subscriptions[1001:2000]</code>.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Filter&gt;
   */
  public Single<Filter> setFavouriteForFilter(
    Long id, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}/favourite");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_setFavouriteForFilter);
  }

  /**
   * Update filter
   * <p>Updates a filter. Use this operation to update a filter's name, description, JQL, or sharing.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however the user must own the filter.</p> 
   * @param id <p>The ID of the filter to update.</p>  (required)
   * @param filter <p>The filter to update.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about filter in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>sharedUsers</code> Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don't specify <code>sharedUsers</code>, then the <code>sharedUsers</code> object is returned but it doesn't list any users. The list of users returned is limited to 1000, to access additional users append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 users, use <code>?expand=sharedUsers[1001:2000]</code>.</li> <li><code>subscriptions</code> Returns the users that are subscribed to the filter. If you don't specify <code>subscriptions</code>, the <code>subscriptions</code> object is returned but it doesn't list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append <code>[start-index:end-index]</code> to the expand request. For example, to access the next 1000 subscriptions, use <code>?expand=subscriptions[1001:2000]</code>.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Filter&gt;
   */
  public Single<Filter> updateFilter(
    Long id, Filter filter, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/filter/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(filter));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_updateFilter);
  }

}
