/*
 * Copyright © 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.atlassian.restclient.jiracloud.v3.api;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.jiracloud.v3.model.IssueLink;
import org.everit.atlassian.restclient.jiracloud.v3.model.LinkIssueRequestJsonBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkIssueApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<IssueLink> returnType_getIssueLink = new TypeReference<IssueLink>() {};

  private static final TypeReference<Object> returnType_linkIssues = new TypeReference<Object>() {};

  private final RestClient restClient;

  public LinkIssueApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Delete issue link
   * <p>Deletes an issue link.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li>Browse project <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for all the projects containing the issues in the link.</li> <li><em>Link issues</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for at least one of the projects containing issues in the link.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, permission to view both of the issues.</li> </ul> 
   * @param linkId <p>The ID of the issue link.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteIssueLink(
    String linkId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issueLink/{linkId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("linkId", String.valueOf(linkId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get issue link
   * <p>Returns an issue link.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse project</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for all the projects containing the linked issues.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, permission to view both of the issues.</li> </ul> 
   * @param linkId <p>The ID of the issue link.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueLink&gt;
   */
  public Single<IssueLink> getIssueLink(
    String linkId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issueLink/{linkId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("linkId", String.valueOf(linkId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getIssueLink);
  }

  /**
   * Create issue link
   * <p>Creates a link between two issues. Use this operation to indicate a relationship between two issues and optionally add a comment to the from (outward) issue. To use this resource the site must have <a href=\"https://confluence.atlassian.com/x/yoXKM\">Issue Linking</a> enabled.</p> <p>This resource returns nothing on the creation of an issue link. To obtain the ID of the issue link, use <code>https://your-domain.atlassian.net/rest/api/3/issue/[linked issue key]?fields=issuelinks</code>.</p> <p>If the link request duplicates a link, the response indicates that the issue link was created. If the request included a comment, the comment is added.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse project</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for all the projects containing the issues to be linked,</li> <li><em>Link issues</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> on the project containing the from (outward) issue,</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param linkIssueRequestJsonBean <p>The issue link request.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> linkIssues(
    LinkIssueRequestJsonBean linkIssueRequestJsonBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/issueLink");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(linkIssueRequestJsonBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_linkIssues);
  }

}
