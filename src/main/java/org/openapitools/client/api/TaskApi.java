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

import org.openapitools.client.model.TaskProgressBeanObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<Object> returnType_cancelTask = new TypeReference<Object>() {};

  private static final TypeReference<TaskProgressBeanObject> returnType_getTask = new TypeReference<TaskProgressBeanObject>() {};

  private final HttpClient httpClient;

  public TaskApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Cancel task
   * <p>Cancels a task.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> either of:</p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</li> <li>Creator of the task.</li> </ul> 
   * @param taskId <p>The ID of the task.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> cancelTask(
    String taskId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/task/{taskId}/cancel");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("taskId", String.valueOf(taskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_cancelTask);
  }

  /**
   * Get task
   * <p>Returns the status of a <a href=\"#async\">long-running asynchronous task</a>.</p> <p>When a task has finished, this operation returns the JSON blob applicable to the task. See the documentation of the operation that created the task for details. Task details are not permanently retained. As of September 2019, details are retained for 14 days although this period may change without notice.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> either of:</p> <ul> <li><em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</li> <li>Creator of the task.</li> </ul> 
   * @param taskId <p>The ID of the task.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;TaskProgressBeanObject&gt;
   */
  public Single<TaskProgressBeanObject> getTask(
    String taskId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/task/{taskId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("taskId", String.valueOf(taskId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getTask);
  }

}
