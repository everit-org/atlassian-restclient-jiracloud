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

public class WorklogPropertyApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<EntityProperty> returnType_getWorklogProperty = new TypeReference<EntityProperty>() {};


  private static final TypeReference<PropertyKeys> returnType_getWorklogPropertyKeys = new TypeReference<PropertyKeys>() {};


  private static final TypeReference<Object> returnType_setWorklogProperty = new TypeReference<Object>() {};


  private final HttpClient httpClient;

  public WorklogPropertyApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Delete worklog property
   * <p>Deletes a worklog property.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param worklogId <p>The ID of the worklog.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteWorklogProperty(
    String issueIdOrKey, String worklogId, String propertyKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (worklogId != null) {
      request.pathParams.put("worklogId", String.valueOf(worklogId));
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
   * Get worklog property
   * <p>Returns the value of a worklog property.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param worklogId <p>The ID of the worklog.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getWorklogProperty(
    String issueIdOrKey, String worklogId, String propertyKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (worklogId != null) {
      request.pathParams.put("worklogId", String.valueOf(worklogId));
    }
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getWorklogProperty);
  }

  /**
   * Get worklog property keys
   * <p>Returns the keys of all properties for a worklog.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param worklogId <p>The ID of the worklog.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getWorklogPropertyKeys(
    String issueIdOrKey, String worklogId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (worklogId != null) {
      request.pathParams.put("worklogId", String.valueOf(worklogId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getWorklogPropertyKeys);
  }

  /**
   * Set worklog property
   * <p>Sets the value of a worklog property. Use this operation to store custom data against the worklog.</p> <p>The value of the request body must be a <a href=\"http://tools.ietf.org/html/rfc4627\">valid</a>, non-empty JSON blob. The maximum length is 32768 characters.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li><em>Edit all worklogs</em><a href=\"https://confluence.atlassian.com/x/yodKLg\"> project permission</a> to update any worklog or <em>Edit own worklogs</em> to update worklogs created by the user.</li> <li>If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param worklogId <p>The ID of the worklog.</p>  (required)
   * @param propertyKey <p>The key of the issue property. The maximum length is 255 characters.</p>  (required)
   * @param body  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setWorklogProperty(
    String issueIdOrKey, String worklogId, String propertyKey, Object body, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (worklogId != null) {
      request.pathParams.put("worklogId", String.valueOf(worklogId));
    }
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
      request.requestBody = Optional.ofNullable(body);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_setWorklogProperty);
  }

}
