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
package org.everit.atlassian.restclient.jiracloud.v2.api;

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

import org.everit.atlassian.restclient.jiracloud.v2.model.Comment;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageOfComments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueCommentApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<Comment> returnType_addComment = new TypeReference<Comment>() {};

  private static final TypeReference<Comment> returnType_getComment = new TypeReference<Comment>() {};

  private static final TypeReference<PageOfComments> returnType_getComments = new TypeReference<PageOfComments>() {};

  private static final TypeReference<Comment> returnType_updateComment = new TypeReference<Comment>() {};

  private final HttpClient httpClient;

  public IssueCommentApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Add comment
   * <p>Adds a comment to an issue.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> and <em>Add comments</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\"> project permission</a> for the project that the issue containing the comment is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param requestBody  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about comments in the response. This parameter accepts <code>renderedBody</code>, which returns the comment body rendered in HTML.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Comment&gt;
   */
  public Single<Comment> addComment(
    String issueIdOrKey, Comment requestBody, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/comment");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_addComment);
  }

  /**
   * Delete comment
   * <p>Deletes a comment.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue containing the comment is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li><em>Delete all comments</em><a href=\"https://confluence.atlassian.com/x/yodKLg\"> project permission</a> to delete any comment or <em>Delete own comments</em> to delete comment created by the user,</li> <li>If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param id <p>The ID of the comment.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteComment(
    String issueIdOrKey, String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/comment/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get comment
   * <p>Returns a comment.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the comment.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param id <p>The ID of the comment.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about comments in the response. This parameter accepts <code>renderedBody</code>, which returns the comment body rendered in HTML.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Comment&gt;
   */
  public Single<Comment> getComment(
    String issueIdOrKey, String id, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/comment/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getComment);
  }

  /**
   * Get comments
   * <p>Returns all comments for an issue.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Comments are included in the response where the user has:</p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the comment.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the comment has visibility restrictions, belongs to the group or has the role visibility is role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>100</code>.</p>  (optional, default to 50)
   * @param orderBy <p>The field to order returned comments by. Only accepts the value <em>created</em>, which orders comments by their created date.</p>  (optional)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about comments in the response. This parameter accepts <code>renderedBody</code>, which returns the comment body rendered in HTML.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageOfComments&gt;
   */
  public Single<PageOfComments> getComments(
    String issueIdOrKey, Optional<Long> startAt, Optional<Integer> maxResults, Optional<String> orderBy, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/comment");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (orderBy.isPresent()) {
      queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getComments);
  }

  /**
   * Update comment
   * <p>Updates a comment.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue containing the comment is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li><em>Edit all comments</em><a href=\"https://confluence.atlassian.com/x/yodKLg\"> project permission</a> to update any comment or <em>Edit own comments</em> to update comment created by the user.</li> <li>If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param id <p>The ID of the comment.</p>  (required)
   * @param requestBody  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about comments in the response. This parameter accepts <code>renderedBody</code>, which returns the comment body rendered in HTML.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Comment&gt;
   */
  public Single<Comment> updateComment(
    String issueIdOrKey, String id, Comment requestBody, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/comment/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_updateComment);
  }

}
