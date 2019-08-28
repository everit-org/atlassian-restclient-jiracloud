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

import org.openapitools.client.model.ErrorCollection;
import org.openapitools.client.model.PageBeanWorkflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class WorkflowSearchApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<PageBeanWorkflow> returnType_getWorkflowsPaginated = new TypeReference<PageBeanWorkflow>() {};


  private final HttpClient httpClient;

  public WorkflowSearchApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get workflows paginated
   * <p>Returns a <a href=\"#pagination\">paginated</a> list of published classic workflows. When workflow names are specified, details of those workflows are returned. Otherwise, all published classic workflows are returned.</p> <p>This operation does not return next-gen workflows.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page.</p>  (optional, default to 50)
   * @param workflowName <p>The name of a workflow to return.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>transition</code> For each workflow, returns information about the transitions inside the workflow.</li> <li><code>statuses</code> For each workflow, returns information about the statuses inside the workflow.</li> <li><code>statuses.properties</code> For each workflow status, returns information about its properties. Statuses are included automatically if this expand is requested.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanWorkflow&gt;
   */
  public Single<PageBeanWorkflow> getWorkflowsPaginated(
    Long startAt, Integer maxResults, List<String> workflowName, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/workflow/search";
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (workflowName != null) {
      request.queryParams.put("workflowName", RestCallUtil.objectCollectionToStringCollection(workflowName));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getWorkflowsPaginated);
  }

}
