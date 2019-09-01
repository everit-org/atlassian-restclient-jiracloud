package org.everit.atlassian.restclient.jiracloud.v3.api;

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

import org.everit.atlassian.restclient.jiracloud.v3.model.EntityProperty;
import org.everit.atlassian.restclient.jiracloud.v3.model.PropertyKeys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardItemPropertyApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<EntityProperty> returnType_getDashboardItemProperty = new TypeReference<EntityProperty>() {};

  private static final TypeReference<PropertyKeys> returnType_getDashboardItemPropertyKeys = new TypeReference<PropertyKeys>() {};

  private static final TypeReference<Object> returnType_setDashboardItemProperty = new TypeReference<Object>() {};

  private final HttpClient httpClient;

  public DashboardItemPropertyApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Delete dashboard item property
   * <p>Deletes a dashboard item property.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> The user must be the owner of the dashboard. Note, users with the <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> are considered owners of the System dashboard.</p> 
   * @param dashboardId <p>The ID of the dashboard.</p>  (required)
   * @param itemId <p>The ID of the dashboard item.</p>  (required)
   * @param propertyKey <p>The key of the dashboard item property.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteDashboardItemProperty(
    String dashboardId, String itemId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    pathParams.put("itemId", String.valueOf(itemId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get dashboard item property
   * <p>Returns the key and value of a dashboard item property.</p> <p>A dashboard item enables an app to add user-specific information to a user dashboard. Dashboard items are exposed to users as gadgets that users can add to their dashboards. For more information on how users do this, see <a href=\"https://confluence.atlassian.com/x/7AeiLQ\">Adding and customizing gadgets</a>.</p> <p>When an app creates a dashboard item it registers a callback to receive the dashboard item ID. The callback fires whenever the item is rendered or, where the item is configurable, the user edits the item. The app then uses this resource to store the item's content or configuration details. For more information on working with dashboard items, see <a href=\"https://developer.atlassian.com/server/jira/platform/guide-building-a-dashboard-item-for-a-jira-connect-add-on-33746254/\"> Building a dashboard item for a JIRA Connect add-on</a> and the <a href=\"https://developer.atlassian.com/cloud/jira/platform/modules/dashboard-item/\">Dashboard Item</a> documentation.</p> <p>There is no resource to set or get dashboard items.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> The user must be the owner of the dashboard or be shared the dashboard. Note, users with the <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users.</p> 
   * @param dashboardId <p>The ID of the dashboard.</p>  (required)
   * @param itemId <p>The ID of the dashboard item.</p>  (required)
   * @param propertyKey <p>The key of the dashboard item property.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getDashboardItemProperty(
    String dashboardId, String itemId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    pathParams.put("itemId", String.valueOf(itemId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getDashboardItemProperty);
  }

  /**
   * Get dashboard item property keys
   * <p>Returns the keys of all properties for a dashboard item.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> The user must be the owner of the dashboard or be shared the dashboard. Note, users with the <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users.</p> 
   * @param dashboardId <p>The ID of the dashboard.</p>  (required)
   * @param itemId <p>The ID of the dashboard item.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getDashboardItemPropertyKeys(
    String dashboardId, String itemId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("dashboardId", String.valueOf(dashboardId));
    pathParams.put("itemId", String.valueOf(itemId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getDashboardItemPropertyKeys);
  }

  /**
   * Set dashboard item property
   * <p>Sets the value of a dashboard item property. Use this resource in apps to store custom data against a dashboard item.</p> <p>A dashboard item enables an app to add user-specific information to a user dashboard. Dashboard items are exposed to users as gadgets that users can add to their dashboards. For more information on how users do this, see <a href=\"https://confluence.atlassian.com/x/7AeiLQ\">Adding and customizing gadgets</a>.</p> <p>When an app creates a dashboard item it registers a callback to receive the dashboard item ID. The callback fires whenever the item is rendered or, where the item is configurable, the user edits the item. The app then uses this resource to store the item's content or configuration details. For more information on working with dashboard items, see <a href=\"https://developer.atlassian.com/server/jira/platform/guide-building-a-dashboard-item-for-a-jira-connect-add-on-33746254/\"> Building a dashboard item for a JIRA Connect add-on</a> and the <a href=\"https://developer.atlassian.com/cloud/jira/platform/modules/dashboard-item/\">Dashboard Item</a> documentation.</p> <p>There is no resource to set or get dashboard items.</p> <p>The value of the request body must be a <a href=\"http://tools.ietf.org/html/rfc4627\">valid</a>, non-empty JSON blob. The maximum length is 32768 characters.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> The user must be the owner of the dashboard. Note, users with the <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> are considered owners of the System dashboard.</p> 
   * @param dashboardId <p>The ID of the dashboard.</p>  (required)
   * @param itemId <p>The ID of the dashboard item.</p>  (required)
   * @param propertyKey <p>The key of the dashboard item property. The maximum length is 255 characters.</p>  (required)
   * @param body  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setDashboardItemProperty(
    String dashboardId, String itemId, String propertyKey, Object body, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_setDashboardItemProperty);
  }

}
