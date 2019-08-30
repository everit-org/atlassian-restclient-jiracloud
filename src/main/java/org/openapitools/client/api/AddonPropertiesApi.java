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

import org.openapitools.client.model.EntityProperty;
import org.openapitools.client.model.OperationMessage;
import org.openapitools.client.model.PropertyKeys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddonPropertiesApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<PropertyKeys> returnType_getAddonProperties = new TypeReference<PropertyKeys>() {};

  private static final TypeReference<EntityProperty> returnType_getAddonProperty = new TypeReference<EntityProperty>() {};

  private static final TypeReference<OperationMessage> returnType_putAddonProperty = new TypeReference<OperationMessage>() {};

  private final HttpClient httpClient;

  public AddonPropertiesApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Delete app property
   * <p>Deletes an app's property.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only a Connect app whose key matches <code>addonKey</code> can make this request.</p> 
   * @param addonKey <p>The key of the app, as defined in its descriptor.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteAddonProperty(
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get app properties
   * <p>Gets all the properties of an app.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only a Connect app whose key matches <code>addonKey</code> can make this request.</p> 
   * @param addonKey <p>The key of the app, as defined in its descriptor.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getAddonProperties(
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAddonProperties);
  }

  /**
   * Get app property
   * <p>Returns the key and value of an app's property.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only a Connect app whose key matches <code>addonKey</code> can make this request.</p> 
   * @param addonKey <p>The key of the app, as defined in its descriptor.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getAddonProperty(
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAddonProperty);
  }

  /**
   * Set app property
   * <p>Sets the value of an app's property. Use this resource to store custom data for your app.</p> <p>The value of the request body must be a <a href=\"http://tools.ietf.org/html/rfc4627\">valid</a>, non-empty JSON blob. The maximum length is 32768 characters.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only a Connect app whose key matches <code>addonKey</code> can make this request.</p> 
   * @param addonKey <p>The key of the app, as defined in its descriptor.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param body  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;OperationMessage&gt;
   */
  public Single<OperationMessage> putAddonProperty(
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_putAddonProperty);
  }

}
