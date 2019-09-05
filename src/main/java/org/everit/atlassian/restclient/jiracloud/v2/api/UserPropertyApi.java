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

import org.everit.atlassian.restclient.jiracloud.v2.model.EntityProperty;
import org.everit.atlassian.restclient.jiracloud.v2.model.PropertyKeys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserPropertyApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<EntityProperty> returnType_getUserProperty = new TypeReference<EntityProperty>() {};

  private static final TypeReference<PropertyKeys> returnType_getUserPropertyKeys = new TypeReference<PropertyKeys>() {};

  private static final TypeReference<Object> returnType_setUserProperty = new TypeReference<Object>() {};

  private final RestClient restClient;

  public UserPropertyApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Delete user property
   * <p>Deletes a property from a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to delete a property from any user.</li> <li>Access to Jira, to delete a property from the calling user's record.</li> </ul> <p>Note: These user properties are unrelated to the <a href=\"https://confluence.atlassian.com/x/74xjL\">user properties</a> that are set in Jira.</p> 
   * @param propertyKey <p>The key of the user's property.</p>  (required)
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param userKey <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteUserProperty(
    String propertyKey, Optional<String> accountId, Optional<String> userKey, Optional<String> username, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/user/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (userKey.isPresent()) {
      queryParams.put("userKey", Collections.singleton(String.valueOf(userKey.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get user property
   * <p>Returns the value of a user's property. If no property key is provided <a href=\"#api-rest-api-2-user-properties-get\">Get user property keys</a> is called.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to get a property from any user.</li> <li>Access to Jira, to get a property from the calling user's record.</li> </ul> <p>Note: These user properties are unrelated to the <a href=\"https://confluence.atlassian.com/x/74xjL\">user properties</a> that are set in Jira.</p> 
   * @param propertyKey <p>The key of the user's property.</p>  (required)
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param userKey <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getUserProperty(
    String propertyKey, Optional<String> accountId, Optional<String> userKey, Optional<String> username, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/user/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (userKey.isPresent()) {
      queryParams.put("userKey", Collections.singleton(String.valueOf(userKey.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getUserProperty);
  }

  /**
   * Get user property keys
   * <p>Returns the keys of all properties for a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to access the property keys on any user.</li> <li>Access to Jira, to access the calling user's property keys.</li> </ul> <p>Note: These user properties are unrelated to the <a href=\"https://confluence.atlassian.com/x/8YxjL\">user properties</a> that are set in Jira.</p> 
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param userKey <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getUserPropertyKeys(
    Optional<String> accountId, Optional<String> userKey, Optional<String> username, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/user/properties");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (userKey.isPresent()) {
      queryParams.put("userKey", Collections.singleton(String.valueOf(userKey.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getUserPropertyKeys);
  }

  /**
   * Set user property
   * <p>Sets the value of a user's property. Use this resource to store custom data against a user.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, to set a property on any user.</li> <li>Access to Jira, to set a property on the calling user's record.</li> </ul> <p>Note: These user properties are unrelated to the <a href=\"https://confluence.atlassian.com/x/8YxjL\">user properties</a> that are set in Jira.</p> 
   * @param propertyKey <p>The key of the user's property. The maximum length is 255 characters.</p>  (required)
   * @param body  (required)
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param userKey <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setUserProperty(
    String propertyKey, Object body, Optional<String> accountId, Optional<String> userKey, Optional<String> username, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/user/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (userKey.isPresent()) {
      queryParams.put("userKey", Collections.singleton(String.valueOf(userKey.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(body));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setUserProperty);
  }

}
