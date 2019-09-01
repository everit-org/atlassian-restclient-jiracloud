package org.everit.atlassian.restclient.jiracloud.v3.api;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.restclient.RestCallUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;

import org.everit.http.client.HttpClient;
import org.everit.http.client.HttpMethod;
import org.everit.http.client.HttpRequest;

import org.everit.atlassian.restclient.jiracloud.v3.model.ContainerOfWorkflowSchemeAssociations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ContainerOfWorkflowSchemeAssociations&gt;
   */
  public Single<ContainerOfWorkflowSchemeAssociations> getWorkflowSchemeProjectAssociations(
    Optional<List<Long>> projectId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/workflowscheme/project");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (projectId.isPresent()) {
      queryParams.put("projectId", RestCallUtil.objectCollectionToStringCollection(projectId.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getWorkflowSchemeProjectAssociations);
  }

}
