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

import org.openapitools.client.model.ContainerOfWorkflowSchemeAssociations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class WorkflowSchemeProjectApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<ContainerOfWorkflowSchemeAssociations> returnType_getWorkflowSchemeProjectAssociations = new TypeReference<ContainerOfWorkflowSchemeAssociations>() {};


  private final HttpClient httpClient;

  public WorkflowSchemeProjectApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get workflow scheme project associations
   * <p>Returns a list of the workflow schemes associated with a list of projects. Each returned workflow scheme includes a list of the requested projects associated with it. Any next-gen or non-existent projects in the request are ignored and no errors are returned.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param projectId <p>The ID of a project to return the workflow schemes for. To include multiple projects, provide multiple copies of this parameter. For example, <code>projectId=10000&amp;projectId=10001</code>.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ContainerOfWorkflowSchemeAssociations&gt;
   */
  public Single<ContainerOfWorkflowSchemeAssociations> getWorkflowSchemeProjectAssociations(
    List<Long> projectId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/workflowscheme/project";
    if (projectId != null) {
      request.queryParams.put("projectId", RestCallUtil.objectCollectionToStringCollection(projectId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getWorkflowSchemeProjectAssociations);
  }

}
