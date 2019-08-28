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

import org.openapitools.client.model.EntityProperty;
import org.openapitools.client.model.PropertyKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class UserPropertyApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<EntityProperty> returnType_getUserProperty = new TypeReference<EntityProperty>() {};


  private static final TypeReference<PropertyKeys> returnType_getUserPropertyKeys = new TypeReference<PropertyKeys>() {};


  private static final TypeReference<Object> returnType_setUserProperty = new TypeReference<Object>() {};


  private final HttpClient httpClient;

  public UserPropertyApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Delete user property
   * <p>Deletes a property from a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to delete a property from any user.</li> <li>Access to Jira, to delete a property from the calling user's record.</li> </ul> <p>Note: These user properties are unrelated to the <a href=\"https://confluence.atlassian.com/cloud/add-data-to-users-for-advanced-functions-jira-applications-only-744721649.html\">Jira properties</a> that are set in Jira.</p> 
   * @param propertyKey <p>The key of the user's property.</p>  (required)
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param userKey <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteUserProperty(
    String propertyKey, String accountId, String userKey, String username, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/properties/{propertyKey}";
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (userKey != null) {
      request.queryParams.put("userKey", Collections.singleton(String.valueOf(userKey)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Get user property
   * <p>Returns the value of a user's property. If no property key is provided <a href=\"#api-rest-api-3-user-properties-get\">Get user property keys</a> is called.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to get a property from any user.</li> <li>Access to Jira, to get a property from the calling user's record.</li> </ul> <p>Note: These user properties are unrelated to the <a href=\"https://confluence.atlassian.com/cloud/add-data-to-users-for-advanced-functions-jira-applications-only-744721649.html\">Jira properties</a> that are set in Jira.</p> 
   * @param propertyKey <p>The key of the user's property.</p>  (required)
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param userKey <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getUserProperty(
    String propertyKey, String accountId, String userKey, String username, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/properties/{propertyKey}";
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (userKey != null) {
      request.queryParams.put("userKey", Collections.singleton(String.valueOf(userKey)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getUserProperty);
  }

  /**
   * Get user property keys
   * <p>Returns the keys of all properties for a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to access the property keys on any user.</li> <li>Access to Jira, to access the calling user's property keys.</li> </ul> <p>Note: These user properties are unrelated to the <a href=\"https://confluence.atlassian.com/x/8YxjL\">Jira properties</a> that are set in Jira.</p> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param userKey <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getUserPropertyKeys(
    String accountId, String userKey, String username, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/properties";
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (userKey != null) {
      request.queryParams.put("userKey", Collections.singleton(String.valueOf(userKey)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getUserPropertyKeys);
  }

  /**
   * Set user property
   * <p>Sets the value of a user's property. Use this resource to store custom data against a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to set a property on any user.</li> <li>Access to Jira, to set a property on the calling user's record.</li> </ul> <p>Note: These user properties are unrelated to the <a href=\"https://confluence.atlassian.com/x/8YxjL\">Jira properties</a> that are set in Jira.</p> 
   * @param propertyKey <p>The key of the user's property. The maximum length is 255 characters.</p>  (required)
   * @param body  (required)
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param userKey <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setUserProperty(
    String propertyKey, Object body, String accountId, String userKey, String username, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/properties/{propertyKey}";
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (userKey != null) {
      request.queryParams.put("userKey", Collections.singleton(String.valueOf(userKey)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
      request.requestBody = Optional.ofNullable(body);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_setUserProperty);
  }

}
