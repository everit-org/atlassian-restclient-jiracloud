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

import org.openapitools.client.model.WorkflowTransitionProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class WorkflowTransitionApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<WorkflowTransitionProperty> returnType_createWorkflowTransitionProperty = new TypeReference<WorkflowTransitionProperty>() {};


  private static final TypeReference<WorkflowTransitionProperty> returnType_getWorkflowTransitionProperties = new TypeReference<WorkflowTransitionProperty>() {};


  private static final TypeReference<WorkflowTransitionProperty> returnType_updateWorkflowTransitionProperty = new TypeReference<WorkflowTransitionProperty>() {};


  private final HttpClient httpClient;

  public WorkflowTransitionApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Create workflow transition property
   * <p>Adds a property to a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see <a href=\"https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties\">Transition properties</a> and <a href=\"https://confluence.atlassian.com/x/JYlKLg\">Workflow properties</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param transitionId <p>The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.</p>  (required)
   * @param requestBody  (required)
   * @param key <p>The key of the property being added, also known as the name of the property. Set this to the same value as the <code>key</code> defined in the request body.</p>  (optional)
   * @param workflowName <p>The name of the workflow that the transition belongs to.</p>  (optional)
   * @param workflowMode <p>The workflow status. Set to <em>live</em> for inactive workflows or <em>draft</em> for draft workflows. Active workflows cannot be edited.</p>  (optional, default to live)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowTransitionProperty&gt;
   */
  public Single<WorkflowTransitionProperty> createWorkflowTransitionProperty(
    Long transitionId, WorkflowTransitionProperty requestBody, String key, String workflowName, String workflowMode, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/workflow/transitions/{transitionId}/properties";
    if (transitionId != null) {
      request.pathParams.put("transitionId", String.valueOf(transitionId));
    }
    if (key != null) {
      request.queryParams.put("key", Collections.singleton(String.valueOf(key)));
    }
    if (workflowName != null) {
      request.queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    }
    if (workflowMode != null) {
      request.queryParams.put("workflowMode", Collections.singleton(String.valueOf(workflowMode)));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createWorkflowTransitionProperty);
  }

  /**
   * Delete workflow transition property
   * <p>Deletes a property from a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see <a href=\"https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties\">Transition properties</a> and <a href=\"https://confluence.atlassian.com/x/JYlKLg\">Workflow properties</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param transitionId <p>The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.</p>  (required)
   * @param key <p>The name of the transition property to delete, also known as the name of the property.</p>  (optional)
   * @param workflowName <p>The name of the workflow that the transition belongs to.</p>  (optional)
   * @param workflowMode <p>The workflow status. Set to <code>live</code> for inactive workflows or <code>draft</code> for draft workflows. Active workflows cannot be edited.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteWorkflowTransitionProperty(
    Long transitionId, String key, String workflowName, String workflowMode, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/workflow/transitions/{transitionId}/properties";
    if (transitionId != null) {
      request.pathParams.put("transitionId", String.valueOf(transitionId));
    }
    if (key != null) {
      request.queryParams.put("key", Collections.singleton(String.valueOf(key)));
    }
    if (workflowName != null) {
      request.queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    }
    if (workflowMode != null) {
      request.queryParams.put("workflowMode", Collections.singleton(String.valueOf(workflowMode)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Get workflow transition properties
   * <p>Returns the properties on a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see <a href=\"https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties\">Transition properties</a> and <a href=\"https://confluence.atlassian.com/x/JYlKLg\">Workflow properties</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param transitionId <p>The ID of the transition. To get the ID, view the workflow in text mode in the Jira administration console. The ID is shown next to the transition.</p>  (required)
   * @param includeReservedKeys <p>Some properties with keys that have the <em>jira.</em> prefix are reserved, which means they are not editable. To include these properties in the results, set this parameter to <em>true</em>.</p>  (optional, default to false)
   * @param key <p>The key of the property being returned, also known as the name of the property. If this parameter is not specified, all properties on the transition are returned.</p>  (optional)
   * @param workflowName <p>The name of the workflow that the transition belongs to.</p>  (optional)
   * @param workflowMode <p>The workflow status. Set to <em>live</em> for active and inactive workflows, or <em>draft</em> for draft workflows.</p>  (optional, default to live)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowTransitionProperty&gt;
   */
  public Single<WorkflowTransitionProperty> getWorkflowTransitionProperties(
    Long transitionId, Boolean includeReservedKeys, String key, String workflowName, String workflowMode, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/workflow/transitions/{transitionId}/properties";
    if (transitionId != null) {
      request.pathParams.put("transitionId", String.valueOf(transitionId));
    }
    if (includeReservedKeys != null) {
      request.queryParams.put("includeReservedKeys", Collections.singleton(String.valueOf(includeReservedKeys)));
    }
    if (key != null) {
      request.queryParams.put("key", Collections.singleton(String.valueOf(key)));
    }
    if (workflowName != null) {
      request.queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    }
    if (workflowMode != null) {
      request.queryParams.put("workflowMode", Collections.singleton(String.valueOf(workflowMode)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getWorkflowTransitionProperties);
  }

  /**
   * Update workflow transition property
   * <p>Updates a workflow transition by changing the property value. Trying to update a property that does not exist results in a new property being added to the transition. Transition properties are used to change the behavior of a transition. For more information, see <a href=\"https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties\">Transition properties</a> and <a href=\"https://confluence.atlassian.com/x/JYlKLg\">Workflow properties</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param transitionId <p>The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.</p>  (required)
   * @param requestBody  (required)
   * @param key <p>The key of the property being updated, also known as the name of the property. Set this to the same value as the <code>key</code> defined in the request body.</p>  (optional)
   * @param workflowName <p>The name of the workflow that the transition belongs to.</p>  (optional)
   * @param workflowMode <p>The workflow status. Set to <code>live</code> for inactive workflows or <code>draft</code> for draft workflows. Active workflows cannot be edited.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WorkflowTransitionProperty&gt;
   */
  public Single<WorkflowTransitionProperty> updateWorkflowTransitionProperty(
    Long transitionId, WorkflowTransitionProperty requestBody, String key, String workflowName, String workflowMode, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/workflow/transitions/{transitionId}/properties";
    if (transitionId != null) {
      request.pathParams.put("transitionId", String.valueOf(transitionId));
    }
    if (key != null) {
      request.queryParams.put("key", Collections.singleton(String.valueOf(key)));
    }
    if (workflowName != null) {
      request.queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    }
    if (workflowMode != null) {
      request.queryParams.put("workflowMode", Collections.singleton(String.valueOf(workflowMode)));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_updateWorkflowTransitionProperty);
  }

}
