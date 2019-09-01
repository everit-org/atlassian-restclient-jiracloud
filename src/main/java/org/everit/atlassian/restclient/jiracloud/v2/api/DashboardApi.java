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

import org.everit.atlassian.restclient.jiracloud.v2.model.Dashboard;
import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanDashboard;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageOfDashboards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<PageOfDashboards> returnType_getAllDashboards = new TypeReference<PageOfDashboards>() {};

  private static final TypeReference<Dashboard> returnType_getDashboard = new TypeReference<Dashboard>() {};

  private static final TypeReference<PageBeanDashboard> returnType_getDashboardsPaginated = new TypeReference<PageBeanDashboard>() {};

  private final HttpClient httpClient;

  public DashboardApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get all dashboards
   * <p>Returns a list of dashboards owned by or shared with the user. The list may be filtered to include only favorite or owned dashboards.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param filter <p>The filter applied to the list of dashboards. Valid values are:</p> <ul> <li><code>favourite</code> Returns dashboards the user has marked as favorite.</li> <li><code>my</code> Returns dashboards owned by the user.</li> </ul>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 20)
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAllDashboards);
  }

  /**
   * Get dashboard
   * <p>Returns a dashboard.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> <p>However, to get a dashboard, the dashboard must be shared with the user or the user must own it. Note, users with the <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users.</p> 
   * @param id <p>The ID of the dashboard.</p>  (required)
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getDashboard);
  }

  /**
   * Search for dashboards
   * <p>Searches for dashboards. This operation is similar to <a href=\"#api-rest-api-2-dashboard-get\">Get dashboards</a> except that the results can be refined to include dashboards that have specific attributes. For example, dashboards with a particular name. When multiple attributes are specified only filters matching all attributes are returned.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> The following dashboards that match the query parameters are returned:</p> <ul> <li>Dashboards owned by the user. Not returned for anonymous users.</li> <li>Dashboards shared with a group that the user is a member of. Not returned for anonymous users.</li> <li>Dashboards shared with a private project that the user can browse. Not returned for anonymous users.</li> <li>Dashboards shared with a public project.</li> <li>Dashboards shared with the public.</li> </ul> 
   * @param dashboardName <p>String used to perform a case-insensitive partial match with <code>name</code>.</p>  (optional)
   * @param accountId <p>User account ID used to return dashboards with the matching <code>owner.accountId</code>. This parameter cannot be used with the <code>owner</code> parameter.</p>  (optional)
   * @param owner <p>This parameter is deprecated because of privacy changes. Use <code>accountId</code> instead. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">migration guide</a> for details. User name used to return dashboards with the matching <code>owner.name</code>. This parameter cannot be used with the <code>accountId</code> parameter.</p>  (optional)
   * @param groupname <p>Group name used to returns dashboards that are shared with a group that matches <code>sharePermissions.group.name</code>.</p>  (optional)
   * @param projectId <p>Project ID used to returns dashboards that are shared with a project that matches <code>sharePermissions.project.id</code>.</p>  (optional)
   * @param orderBy <p><a href=\"#ordering\">Orders</a> the results using one of these dashboard properties:</p> <ul> <li><code>id</code> Orders by dashboard <code>id</code>.</li> <li><code>name</code> Orders by dashboard <code>name</code>.</li> <li><code>description</code> Orders by dashboard <code>description</code>. Note that this sort works independently of whether the expand to display the description field is in use.</li> <li><code>owner</code> Orders by owner <code>name</code>.</li> <li><code>favourite_count</code> Orders by <code>popularity</code>.</li> <li><code>is_favourite</code> Orders by <code>isFavourite</code>.</li> </ul>  (optional, default to name)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>100</code>.</p>  (optional, default to 50)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about dashboard in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>description</code> Returns the description of the dashboard.</li> <li><code>owner</code> Returns the owner of the dashboard.</li> <li><code>viewUrl</code> Returns the URL that is used to view the dashboard.</li> <li><code>favourite</code> Returns <code>isFavourite</code>, an indicator of whether the user has set the dashboard as a favorite.</li> <li><code>favouritedCount</code> Returns <code>popularity</code>, a count of how many users have set this dashboard as a favorite.</li> <li><code>sharePermissions</code> Returns details of the share permissions defined for the dashboard.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanDashboard&gt;
   */
  public Single<PageBeanDashboard> getDashboardsPaginated(
    Optional<String> dashboardName, Optional<String> accountId, Optional<String> owner, Optional<String> groupname, Optional<Long> projectId, Optional<String> orderBy, Optional<Long> startAt, Optional<Integer> maxResults, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getDashboardsPaginated);
  }

}
