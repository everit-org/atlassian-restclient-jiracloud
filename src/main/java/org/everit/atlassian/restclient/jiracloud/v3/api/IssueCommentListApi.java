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

import org.everit.atlassian.restclient.jiracloud.v3.model.IssueCommentListRequestBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanComment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueCommentListApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<PageBeanComment> returnType_getCommentsByIds = new TypeReference<PageBeanComment>() {};

  private final HttpClient httpClient;

  public IssueCommentListApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get comments by IDs
   * <p>Returns the comments for a list of comment IDs.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Comments are returned where the user:</p> <ul> <li>has <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the comment.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueCommentListRequestBean <p>The list of comment IDs.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about comments in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>renderedBody</code> Returns the comment body rendered in HTML.</li> <li><code>properties</code> Returns the comment's properties.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanComment&gt;
   */
  public Single<PageBeanComment> getCommentsByIds(
    IssueCommentListRequestBean issueCommentListRequestBean, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/comment/list");

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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getCommentsByIds);
  }

}