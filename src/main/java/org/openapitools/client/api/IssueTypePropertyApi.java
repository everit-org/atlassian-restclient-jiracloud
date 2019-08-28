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

public class IssueTypePropertyApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<EntityProperty> returnType_getIssueTypeProperty = new TypeReference<EntityProperty>() {};


  private static final TypeReference<PropertyKeys> returnType_getIssueTypePropertyKeys = new TypeReference<PropertyKeys>() {};


  private static final TypeReference<Object> returnType_setIssueTypeProperty = new TypeReference<Object>() {};


  private final HttpClient httpClient;

  public IssueTypePropertyApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Delete issue type property
   * <p>Deletes the <a href=\"https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties\">issue type property</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param issueTypeId <p>The ID of the issue type.</p>  (required)
   * @param propertyKey <p>The key of the property. Use <a href=\"#api-rest-api-3-issuetype-issueTypeId-properties-get\">Get issue type property keys</a> to get a list of all issue type property keys.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteIssueTypeProperty(
    String issueTypeId, String propertyKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey}";
    if (issueTypeId != null) {
      request.pathParams.put("issueTypeId", String.valueOf(issueTypeId));
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
   * Get issue type property
   * <p>Returns the key and value of the <a href=\"https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties\">issue type property</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> to get the details of any issue type.</li> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> to get the details of any issue types associated with the projects the user has permission to browse.</li> </ul> 
   * @param issueTypeId <p>The ID of the issue type.</p>  (required)
   * @param propertyKey <p>The key of the property. Use <a href=\"#api-rest-api-3-issuetype-issueTypeId-properties-get\">Get issue type property keys</a> to get a list of all issue type property keys.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getIssueTypeProperty(
    String issueTypeId, String propertyKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey}";
    if (issueTypeId != null) {
      request.pathParams.put("issueTypeId", String.valueOf(issueTypeId));
    }
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueTypeProperty);
  }

  /**
   * Get issue type property keys
   * <p>Returns all the <a href=\"https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties\">issue type property</a> keys of the issue type.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> to get the property keys of any issue type.</li> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> to get the property keys of any issue types associated with the projects the user has permission to browse.</li> </ul> 
   * @param issueTypeId <p>The ID of the issue type.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getIssueTypePropertyKeys(
    String issueTypeId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype/{issueTypeId}/properties";
    if (issueTypeId != null) {
      request.pathParams.put("issueTypeId", String.valueOf(issueTypeId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueTypePropertyKeys);
  }

  /**
   * Set issue type property
   * <p>Creates or updates the value of the <a href=\"https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties\">issue type property</a>. Use this resource to store and update data against an issue type.</p> <p>The value of the request body must be a <a href=\"http://tools.ietf.org/html/rfc4627\">valid</a>, non-empty JSON blob. The maximum length is 32768 characters.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param issueTypeId <p>The ID of the issue type.</p>  (required)
   * @param propertyKey <p>The key of the issue type property. The maximum length is 255 characters.</p>  (required)
   * @param body  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setIssueTypeProperty(
    String issueTypeId, String propertyKey, Object body, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey}";
    if (issueTypeId != null) {
      request.pathParams.put("issueTypeId", String.valueOf(issueTypeId));
    }
    if (propertyKey != null) {
      request.pathParams.put("propertyKey", String.valueOf(propertyKey));
    }
      request.requestBody = Optional.ofNullable(body);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_setIssueTypeProperty);
  }

}
