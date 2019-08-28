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

import org.openapitools.client.model.DeprecatedWorkflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class WorkflowsApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<List<DeprecatedWorkflow>> returnType_getAllWorkflows = new TypeReference<List<DeprecatedWorkflow>>() {};


  private final HttpClient httpClient;

  public WorkflowsApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get all workflows
   * <p>Returns all workflows in Jira or a workflow. Deprecated, use <a href=\"#api-rest-api-3-workflow-search-get\">Get workflows paginated</a>.</p> <p>If the <code>workflowName</code> parameter is specified, the workflow is returned as an object (not in an array). Otherwise, an array of workflow objects is returned.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param workflowName <p>The name of the workflow to be returned. Only one workflow can be specified.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;DeprecatedWorkflow&gt;&gt;
   * @deprecated
   */
  @Deprecated
  public Single<List<DeprecatedWorkflow>> getAllWorkflows(
    String workflowName, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/workflow";
    if (workflowName != null) {
      request.queryParams.put("workflowName", Collections.singleton(String.valueOf(workflowName)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllWorkflows);
  }

}
