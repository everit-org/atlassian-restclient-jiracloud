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

import org.openapitools.client.model.PageBeanChangelog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class IssueChangelogApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<PageBeanChangelog> returnType_getChangeLogs = new TypeReference<PageBeanChangelog>() {};


  private final HttpClient httpClient;

  public IssueChangelogApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get change logs
   * <p>Returns all changelogs for an issue sorted by date, starting from the oldest.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>100</code>.</p>  (optional, default to 100)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanChangelog&gt;
   */
  public Single<PageBeanChangelog> getChangeLogs(
    String issueIdOrKey, Integer startAt, Integer maxResults, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/changelog";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getChangeLogs);
  }

}
