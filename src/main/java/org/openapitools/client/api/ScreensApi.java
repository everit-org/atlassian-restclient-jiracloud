package org.openapitools.client.api;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.atlassian.restclient.common.RestCallUtil;
import org.everit.atlassian.restclient.common.RestRequest;
import org.everit.atlassian.restclient.common.RestRequestEnhancer;

import org.everit.http.client.HttpClient;
import org.everit.http.client.HttpMethod;
import org.everit.http.client.HttpRequest;

import org.openapitools.client.model.AddFieldBean;
import org.openapitools.client.model.MoveFieldBean;
import org.openapitools.client.model.PageBeanScreen;
import org.openapitools.client.model.ScreenableField;
import org.openapitools.client.model.ScreenableTab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreensApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<Object> returnType_addFieldToDefaultScreen = new TypeReference<Object>() {};

  private static final TypeReference<ScreenableTab> returnType_addScreenTab = new TypeReference<ScreenableTab>() {};

  private static final TypeReference<ScreenableField> returnType_addScreenTabField = new TypeReference<ScreenableField>() {};

  private static final TypeReference<List<ScreenableField>> returnType_getAllScreenTabFields = new TypeReference<List<ScreenableField>>() {};

  private static final TypeReference<List<ScreenableTab>> returnType_getAllScreenTabs = new TypeReference<List<ScreenableTab>>() {};

  private static final TypeReference<PageBeanScreen> returnType_getAllScreens = new TypeReference<PageBeanScreen>() {};

  private static final TypeReference<List<ScreenableField>> returnType_getAvailableScreenFields = new TypeReference<List<ScreenableField>>() {};

  private static final TypeReference<Object> returnType_moveScreenTab = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_moveScreenTabField = new TypeReference<Object>() {};

  private static final TypeReference<ScreenableTab> returnType_renameScreenTab = new TypeReference<ScreenableTab>() {};

  private final HttpClient httpClient;

  public ScreensApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Add field to default screen
   * <p>Adds a field to the default tab of the default screen.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param fieldId <p>The ID of the field.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> addFieldToDefaultScreen(
    String fieldId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/addToDefault/{fieldId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldId", String.valueOf(fieldId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_addFieldToDefaultScreen);
  }

  /**
   * Create screen tab
   * <p>Creates a tab for a screen.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param screenableTab  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ScreenableTab&gt;
   */
  public Single<ScreenableTab> addScreenTab(
    Long screenId, ScreenableTab screenableTab, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/{screenId}/tabs");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(screenableTab));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_addScreenTab);
  }

  /**
   * Add screen tab field
   * <p>Adds a field to a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param addFieldBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ScreenableField&gt;
   */
  public Single<ScreenableField> addScreenTabField(
    Long screenId, Long tabId, AddFieldBean addFieldBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/{screenId}/tabs/{tabId}/fields");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(addFieldBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_addScreenTabField);
  }

  /**
   * Delete screen tab
   * <p>Deletes a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteScreenTab(
    Long screenId, Long tabId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/{screenId}/tabs/{tabId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get all screen tab fields
   * <p>Returns all fields for a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</li> <li><em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.</li> </ul> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param projectKey <p>The key of the project.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ScreenableField&gt;&gt;
   */
  public Single<List<ScreenableField>> getAllScreenTabFields(
    Long screenId, Long tabId, Optional<String> projectKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/{screenId}/tabs/{tabId}/fields");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (projectKey.isPresent()) {
      queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAllScreenTabFields);
  }

  /**
   * Get all screen tabs
   * <p>Returns the list of tabs for a screen.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</li> <li><em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.</li> </ul> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param projectKey <p>The key of the project.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ScreenableTab&gt;&gt;
   */
  public Single<List<ScreenableTab>> getAllScreenTabs(
    Long screenId, Optional<String> projectKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/{screenId}/tabs");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (projectKey.isPresent()) {
      queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAllScreenTabs);
  }

  /**
   * Get all screens
   * <p>Returns all screens.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>100</code>.</p>  (optional, default to 100)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanScreen&gt;
   */
  public Single<PageBeanScreen> getAllScreens(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens");

    Map<String, String> pathParams = new HashMap<>();
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAllScreens);
  }

  /**
   * Get available screen fields
   * <p>Returns the fields that can be added to a tab on a screen.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ScreenableField&gt;&gt;
   */
  public Single<List<ScreenableField>> getAvailableScreenFields(
    Long screenId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/{screenId}/availableFields");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAvailableScreenFields);
  }

  /**
   * Move screen tab
   * <p>Moves a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param pos <p>The position of tab. The base index is 0.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> moveScreenTab(
    Long screenId, Long tabId, Integer pos, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/{screenId}/tabs/{tabId}/move/{pos}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    pathParams.put("pos", String.valueOf(pos));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_moveScreenTab);
  }

  /**
   * Move screen tab field
   * <p>Moves a screen tab field.</p> <p>If <code>after</code> and <code>position</code> are provided in the request, <code>position</code> is ignored.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param id <p>The ID of the field.</p>  (required)
   * @param moveFieldBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> moveScreenTabField(
    Long screenId, Long tabId, String id, MoveFieldBean moveFieldBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}/move");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(moveFieldBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_moveScreenTabField);
  }

  /**
   * Remove screen tab field
   * <p>Removes a field from a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param id <p>The ID of the field.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeScreenTabField(
    Long screenId, Long tabId, String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Update screen tab
   * <p>Updates the name of a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param screenableTab  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ScreenableTab&gt;
   */
  public Single<ScreenableTab> renameScreenTab(
    Long screenId, Long tabId, ScreenableTab screenableTab, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/screens/{screenId}/tabs/{tabId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("screenId", String.valueOf(screenId));
    pathParams.put("tabId", String.valueOf(tabId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(screenableTab));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_renameScreenTab);
  }

}
