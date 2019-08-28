package org.openapitools.client.api;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.atlassian.restclient.common.RestCallUtil;
import org.everit.atlassian.restclient.common.RestRequest;
import org.everit.atlassian.restclient.common.RestRequestInterceptor;

import org.everit.http.client.HttpClient;
import org.everit.http.client.HttpMethod;
import org.everit.http.client.HttpRequest;

import org.openapitools.client.model.AddFieldBean;
import org.openapitools.client.model.MoveFieldBean;
import org.openapitools.client.model.PageBeanScreen;
import org.openapitools.client.model.ScreenableField;
import org.openapitools.client.model.ScreenableTab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

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
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> addFieldToDefaultScreen(
    String fieldId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/addToDefault/{fieldId}";
    if (fieldId != null) {
      request.pathParams.put("fieldId", String.valueOf(fieldId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_addFieldToDefaultScreen);
  }

  /**
   * Create screen tab
   * <p>Creates a tab for a screen.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param screenableTab  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ScreenableTab&gt;
   */
  public Single<ScreenableTab> addScreenTab(
    Long screenId, ScreenableTab screenableTab, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/{screenId}/tabs";
    if (screenId != null) {
      request.pathParams.put("screenId", String.valueOf(screenId));
    }
      request.requestBody = Optional.ofNullable(screenableTab);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_addScreenTab);
  }

  /**
   * Add screen tab field
   * <p>Adds a field to a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param addFieldBean  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ScreenableField&gt;
   */
  public Single<ScreenableField> addScreenTabField(
    Long screenId, Long tabId, AddFieldBean addFieldBean, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields";
    if (screenId != null) {
      request.pathParams.put("screenId", String.valueOf(screenId));
    }
    if (tabId != null) {
      request.pathParams.put("tabId", String.valueOf(tabId));
    }
      request.requestBody = Optional.ofNullable(addFieldBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_addScreenTabField);
  }

  /**
   * Delete screen tab
   * <p>Deletes a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteScreenTab(
    Long screenId, Long tabId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/{screenId}/tabs/{tabId}";
    if (screenId != null) {
      request.pathParams.put("screenId", String.valueOf(screenId));
    }
    if (tabId != null) {
      request.pathParams.put("tabId", String.valueOf(tabId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Get all screen tab fields
   * <p>Returns all fields for a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</li> <li><em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.</li> </ul> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param projectKey <p>The key of the project.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ScreenableField&gt;&gt;
   */
  public Single<List<ScreenableField>> getAllScreenTabFields(
    Long screenId, Long tabId, String projectKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields";
    if (screenId != null) {
      request.pathParams.put("screenId", String.valueOf(screenId));
    }
    if (tabId != null) {
      request.pathParams.put("tabId", String.valueOf(tabId));
    }
    if (projectKey != null) {
      request.queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllScreenTabFields);
  }

  /**
   * Get all screen tabs
   * <p>Returns the list of tabs for a screen.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</li> <li><em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.</li> </ul> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param projectKey <p>The key of the project.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ScreenableTab&gt;&gt;
   */
  public Single<List<ScreenableTab>> getAllScreenTabs(
    Long screenId, String projectKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/{screenId}/tabs";
    if (screenId != null) {
      request.pathParams.put("screenId", String.valueOf(screenId));
    }
    if (projectKey != null) {
      request.queryParams.put("projectKey", Collections.singleton(String.valueOf(projectKey)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllScreenTabs);
  }

  /**
   * Get all screens
   * <p>Returns all screens.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>100</code>.</p>  (optional, default to 100)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanScreen&gt;
   */
  public Single<PageBeanScreen> getAllScreens(
    Long startAt, Integer maxResults, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens";
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllScreens);
  }

  /**
   * Get available screen fields
   * <p>Returns the fields that can be added to a tab on a screen.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ScreenableField&gt;&gt;
   */
  public Single<List<ScreenableField>> getAvailableScreenFields(
    Long screenId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/{screenId}/availableFields";
    if (screenId != null) {
      request.pathParams.put("screenId", String.valueOf(screenId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAvailableScreenFields);
  }

  /**
   * Move screen tab
   * <p>Moves a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param pos <p>The position of tab. The base index is 0.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> moveScreenTab(
    Long screenId, Long tabId, Integer pos, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/{screenId}/tabs/{tabId}/move/{pos}";
    if (screenId != null) {
      request.pathParams.put("screenId", String.valueOf(screenId));
    }
    if (tabId != null) {
      request.pathParams.put("tabId", String.valueOf(tabId));
    }
    if (pos != null) {
      request.pathParams.put("pos", String.valueOf(pos));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_moveScreenTab);
  }

  /**
   * Move screen tab field
   * <p>Moves a screen tab field.</p> <p>If <code>after</code> and <code>position</code> are provided in the request, <code>position</code> is ignored.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param id <p>The ID of the field.</p>  (required)
   * @param moveFieldBean  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> moveScreenTabField(
    Long screenId, Long tabId, String id, MoveFieldBean moveFieldBean, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}/move";
    if (screenId != null) {
      request.pathParams.put("screenId", String.valueOf(screenId));
    }
    if (tabId != null) {
      request.pathParams.put("tabId", String.valueOf(tabId));
    }
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
      request.requestBody = Optional.ofNullable(moveFieldBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_moveScreenTabField);
  }

  /**
   * Remove screen tab field
   * <p>Removes a field from a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param id <p>The ID of the field.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeScreenTabField(
    Long screenId, Long tabId, String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}";
    if (screenId != null) {
      request.pathParams.put("screenId", String.valueOf(screenId));
    }
    if (tabId != null) {
      request.pathParams.put("tabId", String.valueOf(tabId));
    }
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Update screen tab
   * <p>Updates the name of a screen tab.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param screenId <p>The ID of the screen.</p>  (required)
   * @param tabId <p>The ID of the screen tab.</p>  (required)
   * @param screenableTab  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ScreenableTab&gt;
   */
  public Single<ScreenableTab> renameScreenTab(
    Long screenId, Long tabId, ScreenableTab screenableTab, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/screens/{screenId}/tabs/{tabId}";
    if (screenId != null) {
      request.pathParams.put("screenId", String.valueOf(screenId));
    }
    if (tabId != null) {
      request.pathParams.put("tabId", String.valueOf(tabId));
    }
      request.requestBody = Optional.ofNullable(screenableTab);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_renameScreenTab);
  }

}
