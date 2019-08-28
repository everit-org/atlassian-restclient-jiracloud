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

import org.openapitools.client.model.IssueMatches;
import org.openapitools.client.model.IssuesAndJQLQueries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class IssueMatchApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<IssueMatches> returnType_matchIssues = new TypeReference<IssueMatches>() {};


  private final HttpClient httpClient;

  public IssueMatchApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Check issues against JQL
   * <p>Checks whether one or more issues would be returned by one or more JQL queries.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None, however, issues are only matched against JQL queries where the user has:</p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param issuesAndJQLQueries  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueMatches&gt;
   */
  public Single<IssueMatches> matchIssues(
    IssuesAndJQLQueries issuesAndJQLQueries, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/jql/match";
      request.requestBody = Optional.ofNullable(issuesAndJQLQueries);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_matchIssues);
  }

}
