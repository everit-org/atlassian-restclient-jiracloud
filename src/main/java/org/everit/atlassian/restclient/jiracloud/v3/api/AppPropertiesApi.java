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

import org.everit.atlassian.restclient.jiracloud.v3.model.EntityProperty;
import org.everit.atlassian.restclient.jiracloud.v3.model.OperationMessage;
import org.everit.atlassian.restclient.jiracloud.v3.model.PropertyKeys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppPropertiesApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<PropertyKeys> returnType_addonPropertiesResourceGetAddonPropertiesGet = new TypeReference<PropertyKeys>() {};

  private static final TypeReference<EntityProperty> returnType_addonPropertiesResourceGetAddonPropertyGet = new TypeReference<EntityProperty>() {};

  private static final TypeReference<OperationMessage> returnType_addonPropertiesResourcePutAddonPropertyPut = new TypeReference<OperationMessage>() {};

  private static final TypeReference<OperationMessage> returnType_putForgeAppProperty = new TypeReference<OperationMessage>() {};

  private final RestClient restClient;

  public AppPropertiesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Delete app property
   * Deletes an app's property.  **[Permissions](#permissions) required:** Only a Connect app whose key matches `addonKey` can make this request. Additionally, Forge apps can access Connect app properties (stored against the same `app.connect.key`).
   * @param addonKey The key of the app, as defined in its descriptor. (required)
   * @param propertyKey The key of the property. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable addonPropertiesResourceDeleteAddonPropertyDelete(
    String addonKey, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("addonKey", String.valueOf(addonKey));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get app properties
   * Gets all the properties of an app.  **[Permissions](#permissions) required:** Only a Connect app whose key matches `addonKey` can make this request. Additionally, Forge apps can access Connect app properties (stored against the same `app.connect.key`).
   * @param addonKey The key of the app, as defined in its descriptor. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> addonPropertiesResourceGetAddonPropertiesGet(
    String addonKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/atlassian-connect/1/addons/{addonKey}/properties");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("addonKey", String.valueOf(addonKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addonPropertiesResourceGetAddonPropertiesGet);
  }

  /**
   * Get app property
   * Returns the key and value of an app's property.  **[Permissions](#permissions) required:** Only a Connect app whose key matches `addonKey` can make this request. Additionally, Forge apps can access Connect app properties (stored against the same `app.connect.key`).
   * @param addonKey The key of the app, as defined in its descriptor. (required)
   * @param propertyKey The key of the property. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> addonPropertiesResourceGetAddonPropertyGet(
    String addonKey, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("addonKey", String.valueOf(addonKey));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addonPropertiesResourceGetAddonPropertyGet);
  }

  /**
   * Set app property
   * Sets the value of an app's property. Use this resource to store custom data for your app.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  **[Permissions](#permissions) required:** Only a Connect app whose key matches `addonKey` can make this request. Additionally, Forge apps can access Connect app properties (stored against the same `app.connect.key`).
   * @param addonKey The key of the app, as defined in its descriptor. (required)
   * @param propertyKey The key of the property. (required)
   * @param body  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;OperationMessage&gt;
   */
  public Single<OperationMessage> addonPropertiesResourcePutAddonPropertyPut(
    String addonKey, String propertyKey, Object body, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("addonKey", String.valueOf(addonKey));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(body));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addonPropertiesResourcePutAddonPropertyPut);
  }

  /**
   * Delete app property (Forge)
   * Deletes a Forge app's property.  **[Permissions](#permissions) required:** Only Forge apps can make this request.  The new `write:app-data:jira` OAuth scope is 100% optional now, and not using it won't break your app. However, we recommend adding it to your app's scope list because we will eventually make it mandatory.
   * @param propertyKey The key of the property. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteForgeAppProperty(
    String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/forge/1/app/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Set app property (Forge)
   * Sets the value of a Forge app's property. These values can be retrieved in [Jira expressions](/cloud/jira/platform/jira-expressions/) through the `app` [context variable](/cloud/jira/platform/jira-expressions/#context-variables). They are also available in [entity property display conditions](/platform/forge/manifest-reference/display-conditions/entity-property-conditions/).  For other use cases, use the [Storage API](/platform/forge/runtime-reference/storage-api/).  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  **[Permissions](#permissions) required:** Only Forge apps can make this request.  The new `write:app-data:jira` OAuth scope is 100% optional now, and not using it won't break your app. However, we recommend adding it to your app's scope list because we will eventually make it mandatory.
   * @param propertyKey The key of the property. (required)
   * @param body  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;OperationMessage&gt;
   */
  public Single<OperationMessage> putForgeAppProperty(
    String propertyKey, Object body, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/forge/1/app/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(body));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_putForgeAppProperty);
  }

}
