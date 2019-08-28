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

import org.openapitools.client.model.IssueCommentListRequestBean;
import org.openapitools.client.model.PageBeanComment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

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
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanComment&gt;
   */
  public Single<PageBeanComment> getCommentsByIds(
    IssueCommentListRequestBean issueCommentListRequestBean, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/comment/list";
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
      request.requestBody = Optional.ofNullable(issueCommentListRequestBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getCommentsByIds);
  }

}
