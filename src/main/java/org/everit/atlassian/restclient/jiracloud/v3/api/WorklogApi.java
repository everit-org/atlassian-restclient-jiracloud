package org.everit.atlassian.restclient.jiracloud.v3.api;

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

import org.everit.atlassian.restclient.jiracloud.v3.model.ChangedWorklogs;
import org.everit.atlassian.restclient.jiracloud.v3.model.Worklog;
import org.everit.atlassian.restclient.jiracloud.v3.model.WorklogIdsRequestBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorklogApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<ChangedWorklogs> returnType_getIdsOfWorklogsDeletedSince = new TypeReference<ChangedWorklogs>() {};

  private static final TypeReference<ChangedWorklogs> returnType_getIdsOfWorklogsModifiedSince = new TypeReference<ChangedWorklogs>() {};

  private static final TypeReference<List<Worklog>> returnType_getWorklogsForIds = new TypeReference<List<Worklog>>() {};

  private final HttpClient httpClient;

  public WorklogApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get IDs of deleted worklogs
   * <p>Returns a list of IDs and delete timestamps for worklogs deleted after a date and time.</p> <p>This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, <code>until</code> indicates the timestamp of the youngest item on the page. Also, <code>nextPage</code> provides the URL for the next page of worklogs. The <code>lastPage</code> parameter is set to true on the last page of worklogs.</p> <p>This resource does not return worklogs deleted during the minute preceding the request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param since <p>The date and time, in UNIX timestamp format, after which deleted worklogs are returned.</p>  (optional, default to 0l)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ChangedWorklogs&gt;
   */
  public Single<ChangedWorklogs> getIdsOfWorklogsDeletedSince(
    Optional<Long> since, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/worklog/deleted");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (since.isPresent()) {
      queryParams.put("since", Collections.singleton(String.valueOf(since.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getIdsOfWorklogsDeletedSince);
  }

  /**
   * Get IDs of updated worklogs
   * <p>Returns a list of IDs and update timestamps for worklogs updated after a date and time.</p> <p>This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, <code>until</code> indicates the timestamp of the youngest item on the page. Also, <code>nextPage</code> provides the URL for the next page of worklogs. The <code>lastPage</code> parameter is set to true on the last page of worklogs.</p> <p>This resource does not return worklogs updated during the minute preceding the request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however, worklogs are only returned where either of the following is true:</p> <ul> <li>the worklog is set as <em>Viewable by All Users</em>.</li> <li>the user is a member of a project role or group with permission to view the worklog.</li> </ul> 
   * @param since <p>The date and time, in UNIX timestamp format, after which updated worklogs are returned.</p>  (optional, default to 0l)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about worklogs in the response. This parameter accepts <code>properties</code> that returns the properties of each worklog.</p>  (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ChangedWorklogs&gt;
   */
  public Single<ChangedWorklogs> getIdsOfWorklogsModifiedSince(
    Optional<Long> since, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/worklog/updated");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (since.isPresent()) {
      queryParams.put("since", Collections.singleton(String.valueOf(since.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getIdsOfWorklogsModifiedSince);
  }

  /**
   * Get worklogs
   * <p>Returns worklog details for a list of worklog IDs.</p> <p>The returned list of worklogs is limited to 1000 items.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however, worklogs are only returned where either of the following is true:</p> <ul> <li>the worklog is set as <em>Viewable by All Users</em>.</li> <li>the user is a member of a project role or group with permission to view the worklog.</li> </ul> 
   * @param worklogIdsRequestBean <p>A JSON object containing a list of worklog IDs.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about worklogs in the response. This parameter accepts <code>properties</code> that returns the properties of each worklog.</p>  (optional, default to &quot;&quot;)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Worklog&gt;&gt;
   */
  public Single<List<Worklog>> getWorklogsForIds(
    WorklogIdsRequestBean worklogIdsRequestBean, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/worklog/list");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(worklogIdsRequestBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getWorklogsForIds);
  }

}
