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

import org.openapitools.client.model.ChangedWorklogs;
import org.openapitools.client.model.Worklog;
import org.openapitools.client.model.WorklogIdsRequestBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

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
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ChangedWorklogs&gt;
   */
  public Single<ChangedWorklogs> getIdsOfWorklogsDeletedSince(
    Long since, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/worklog/deleted";
    if (since != null) {
      request.queryParams.put("since", Collections.singleton(String.valueOf(since)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIdsOfWorklogsDeletedSince);
  }

  /**
   * Get IDs of updated worklogs
   * <p>Returns a list of IDs and update timestamps for worklogs updated after a date and time.</p> <p>This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, <code>until</code> indicates the timestamp of the youngest item on the page. Also, <code>nextPage</code> provides the URL for the next page of worklogs. The <code>lastPage</code> parameter is set to true on the last page of worklogs.</p> <p>This resource does not return worklogs updated during the minute preceding the request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however, worklogs are only returned where either of the following is true:</p> <ul> <li>the worklog is set as <em>Viewable by All Users</em>.</li> <li>the user is a member of a project role or group with permission to view the worklog.</li> </ul> 
   * @param since <p>The date and time, in UNIX timestamp format, after which updated worklogs are returned.</p>  (optional, default to 0l)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about worklogs in the response. This parameter accepts <code>properties</code> that returns the properties of each worklog.</p>  (optional, default to &quot;&quot;)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ChangedWorklogs&gt;
   */
  public Single<ChangedWorklogs> getIdsOfWorklogsModifiedSince(
    Long since, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/worklog/updated";
    if (since != null) {
      request.queryParams.put("since", Collections.singleton(String.valueOf(since)));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIdsOfWorklogsModifiedSince);
  }

  /**
   * Get worklogs
   * <p>Returns worklog details for a list of worklog IDs.</p> <p>The returned list of worklogs is limited to 1000 items.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however, worklogs are only returned where either of the following is true:</p> <ul> <li>the worklog is set as <em>Viewable by All Users</em>.</li> <li>the user is a member of a project role or group with permission to view the worklog.</li> </ul> 
   * @param worklogIdsRequestBean <p>A JSON object containing a list of worklog IDs.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about worklogs in the response. This parameter accepts <code>properties</code> that returns the properties of each worklog.</p>  (optional, default to &quot;&quot;)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Worklog&gt;&gt;
   */
  public Single<List<Worklog>> getWorklogsForIds(
    WorklogIdsRequestBean worklogIdsRequestBean, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/worklog/list";
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
      request.requestBody = Optional.ofNullable(worklogIdsRequestBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getWorklogsForIds);
  }

}
