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

import org.openapitools.client.model.Comment;
import org.openapitools.client.model.PageOfComments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

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
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Comment&gt;
   */
  public Single<Comment> addComment(
    String issueIdOrKey, Comment requestBody, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/comment";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_addComment);
  }

  /**
   * Delete comment
   * <p>Deletes a comment.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue containing the comment is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li><em>Delete all comments</em><a href=\"https://confluence.atlassian.com/x/yodKLg\"> project permission</a> to delete any comment or <em>Delete own comments</em> to delete comment created by the user,</li> <li>If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param id <p>The ID of the comment.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteComment(
    String issueIdOrKey, String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/comment/{id}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Get comment
   * <p>Returns a comment.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the comment.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param id <p>The ID of the comment.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about comments in the response. This parameter accepts <code>renderedBody</code>, which returns the comment body rendered in HTML.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Comment&gt;
   */
  public Single<Comment> getComment(
    String issueIdOrKey, String id, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/comment/{id}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getComment);
  }

  /**
   * Get comments
   * <p>Returns all comments for an issue.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Comments are included in the response where the user has:</p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the comment.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the comment has visibility restrictions, belongs to the group or has the role visibility is role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>100</code>.</p>  (optional, default to 50)
   * @param orderBy <p>The field to order returned comments by. Only accepts the value <em>created</em>, which orders comments by their created date.</p>  (optional)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about comments in the response. This parameter accepts <code>renderedBody</code>, which returns the comment body rendered in HTML.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageOfComments&gt;
   */
  public Single<PageOfComments> getComments(
    String issueIdOrKey, Long startAt, Integer maxResults, String orderBy, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/comment";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (orderBy != null) {
      request.queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy)));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getComments);
  }

  /**
   * Update comment
   * <p>Updates a comment.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue containing the comment is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li><em>Edit all comments</em><a href=\"https://confluence.atlassian.com/x/yodKLg\"> project permission</a> to update any comment or <em>Edit own comments</em> to update comment created by the user.</li> <li>If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param id <p>The ID of the comment.</p>  (required)
   * @param requestBody  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about comments in the response. This parameter accepts <code>renderedBody</code>, which returns the comment body rendered in HTML.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Comment&gt;
   */
  public Single<Comment> updateComment(
    String issueIdOrKey, String id, Comment requestBody, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/comment/{id}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_updateComment);
  }

}
