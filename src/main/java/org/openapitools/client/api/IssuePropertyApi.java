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

public class IssuePropertyApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<EntityProperty> returnType_getIssueProperty = new TypeReference<EntityProperty>() {};


  private static final TypeReference<PropertyKeys> returnType_getIssuePropertyKeys = new TypeReference<PropertyKeys>() {};


  private static final TypeReference<Object> returnType_setIssueProperty = new TypeReference<Object>() {};


  private final HttpClient httpClient;

  public IssuePropertyApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Delete issue property
   * <p>Deletes an issue's property.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> and <em>Edit issues</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permissions</a> for the project containing the issue.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param issueIdOrKey <p>The key or ID of the issue.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteIssueProperty(
    String issueIdOrKey, String propertyKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/properties/{propertyKey}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
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
   * Get issue property
   * <p>Returns the key and value of an issue's property.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the issue.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param issueIdOrKey <p>The key or ID of the issue.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getIssueProperty(
    String issueIdOrKey, String propertyKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/properties/{propertyKey}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueProperty);
  }

  /**
   * Get issue property keys
   * <p>Returns the URLs and keys of an issue's properties.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Property details are only returned where the user has:</p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the issue.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param issueIdOrKey <p>The key or ID of the issue.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getIssuePropertyKeys(
    String issueIdOrKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/properties";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssuePropertyKeys);
  }

  /**
   * Set issue property
   * <p>Sets the value of an issue's property. Use this resource to store custom data against an issue.</p> <p>The value of the request body must be a <a href=\"http://tools.ietf.org/html/rfc4627\">valid</a>, non-empty JSON blob. The maximum length is 32768 characters.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> and <em>Edit issues</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permissions</a> for the project containing the issue.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param propertyKey <p>The key of the issue property. The maximum length is 255 characters.</p>  (required)
   * @param body  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setIssueProperty(
    String issueIdOrKey, String propertyKey, Object body, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/properties/{propertyKey}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
      request.requestBody = Optional.ofNullable(body);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_setIssueProperty);
  }

}
