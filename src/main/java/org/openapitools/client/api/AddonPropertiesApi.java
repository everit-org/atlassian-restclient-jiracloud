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
import org.openapitools.client.model.MethodCallResult;
import org.openapitools.client.model.PropertyKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class AddonPropertiesApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<PropertyKeys> returnType_getAddonProperties = new TypeReference<PropertyKeys>() {};


  private static final TypeReference<EntityProperty> returnType_getAddonProperty = new TypeReference<EntityProperty>() {};


  private static final TypeReference<MethodCallResult> returnType_putAddonProperty = new TypeReference<MethodCallResult>() {};


  private final HttpClient httpClient;

  public AddonPropertiesApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Delete app property
   * <p>Deletes an app's property.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only a Connect app whose key matches <code>addonKey</code> can make this request.</p> 
   * @param addonKey <p>The key of the app, as defined in its descriptor.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteAddonProperty(
    String addonKey, String propertyKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}";
    if (addonKey != null) {
      request.pathParams.put("addonKey", String.valueOf(addonKey));
    }
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Get app properties
   * <p>Gets all the properties of an app.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only a Connect app whose key matches <code>addonKey</code> can make this request.</p> 
   * @param addonKey <p>The key of the app, as defined in its descriptor.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getAddonProperties(
    String addonKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/atlassian-connect/1/addons/{addonKey}/properties";
    if (addonKey != null) {
      request.pathParams.put("addonKey", String.valueOf(addonKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAddonProperties);
  }

  /**
   * Get app property
   * <p>Returns the key and value of an app's property.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only a Connect app whose key matches <code>addonKey</code> can make this request.</p> 
   * @param addonKey <p>The key of the app, as defined in its descriptor.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getAddonProperty(
    String addonKey, String propertyKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}";
    if (addonKey != null) {
      request.pathParams.put("addonKey", String.valueOf(addonKey));
    }
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAddonProperty);
  }

  /**
   * Set app property
   * <p>Sets the value of an app's property. Use this resource to store custom data for your app.</p> <p>The value of the request body must be a <a href=\"http://tools.ietf.org/html/rfc4627\">valid</a>, non-empty JSON blob. The maximum length is 32768 characters.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only a Connect app whose key matches <code>addonKey</code> can make this request.</p> 
   * @param addonKey <p>The key of the app, as defined in its descriptor.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param body  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;MethodCallResult&gt;
   */
  public Single<MethodCallResult> putAddonProperty(
    String addonKey, String propertyKey, Object body, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}";
    if (addonKey != null) {
      request.pathParams.put("addonKey", String.valueOf(addonKey));
    }
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
      request.requestBody = Optional.ofNullable(body);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_putAddonProperty);
  }

}
