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

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.jiracloud.v2.model.Comment;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueCommentListRequestBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanComment;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageOfComments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueCommentsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Comment> returnType_addComment = new TypeReference<Comment>() {};

  private static final TypeReference<Comment> returnType_getComment = new TypeReference<Comment>() {};

  private static final TypeReference<PageOfComments> returnType_getComments = new TypeReference<PageOfComments>() {};

  private static final TypeReference<PageBeanComment> returnType_getCommentsByIds = new TypeReference<PageBeanComment>() {};

  private static final TypeReference<Comment> returnType_updateComment = new TypeReference<Comment>() {};

  private final RestClient restClient;

  public IssueCommentsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add comment
   * Adds a comment to an issue.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Add comments* [ project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue containing the comment is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
   * @param issueIdOrKey The ID or key of the issue. (required)
   * @param requestBody  (required)
   * @param expand Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts `renderedBody`, which returns the comment body rendered in HTML. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Comment&gt;
   */
  public Single<Comment> addComment(
    String issueIdOrKey, Map<String, Object> requestBody, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addComment);
  }

  /**
   * Delete comment
   * Deletes a comment.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue containing the comment is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Delete all comments*[ project permission](https://confluence.atlassian.com/x/yodKLg) to delete any comment or *Delete own comments* to delete comment created by the user,  *  If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.
   * @param issueIdOrKey The ID or key of the issue. (required)
   * @param id The ID of the comment. (required)
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get comment
   * Returns a comment.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the comment.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.
   * @param issueIdOrKey The ID or key of the issue. (required)
   * @param id The ID of the comment. (required)
   * @param expand Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts `renderedBody`, which returns the comment body rendered in HTML. (optional)
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getComment);
  }

  /**
   * Get comments
   * Returns all comments for an issue.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Comments are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the comment.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, belongs to the group or has the role visibility is role visibility is restricted to.
   * @param issueIdOrKey The ID or key of the issue. (required)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 5000)
   * @param orderBy [Order](#ordering) the results by a field. Accepts *created* to sort comments by their created date. (optional)
   * @param expand Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts `renderedBody`, which returns the comment body rendered in HTML. (optional)
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getComments);
  }

  /**
   * Get comments by IDs
   * Returns a [paginated](#pagination) list of comments specified by a list of comment IDs.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Comments are returned where the user:   *  has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the comment.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.
   * @param issueCommentListRequestBean The list of comment IDs. (required)
   * @param expand Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts a comma-separated list. Expand options include:   *  `renderedBody` Returns the comment body rendered in HTML.  *  `properties` Returns the comment's properties. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanComment&gt;
   */
  public Single<PageBeanComment> getCommentsByIds(
    IssueCommentListRequestBean issueCommentListRequestBean, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/comment/list");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueCommentListRequestBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getCommentsByIds);
  }

  /**
   * Update comment
   * Updates a comment.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue containing the comment is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit all comments*[ project permission](https://confluence.atlassian.com/x/yodKLg) to update any comment or *Edit own comments* to update comment created by the user.  *  If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.
   * @param issueIdOrKey The ID or key of the issue. (required)
   * @param id The ID of the comment. (required)
   * @param requestBody  (required)
   * @param notifyUsers Whether users are notified when a comment is updated. (optional, default to true)
   * @param overrideEditableFlag Whether screen security is overridden to enable uneditable fields to be edited. Available to Connect app users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) and Forge apps acting on behalf of users with *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). (optional, default to false)
   * @param expand Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts `renderedBody`, which returns the comment body rendered in HTML. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Comment&gt;
   */
  public Single<Comment> updateComment(
    String issueIdOrKey, String id, Map<String, Object> requestBody, Optional<Boolean> notifyUsers, Optional<Boolean> overrideEditableFlag, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/{issueIdOrKey}/comment/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (notifyUsers.isPresent()) {
      queryParams.put("notifyUsers", Collections.singleton(String.valueOf(notifyUsers.get())));
    }
    if (overrideEditableFlag.isPresent()) {
      queryParams.put("overrideEditableFlag", Collections.singleton(String.valueOf(overrideEditableFlag.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateComment);
  }

}
