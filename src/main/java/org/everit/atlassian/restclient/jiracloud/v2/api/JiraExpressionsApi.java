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

import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.JiraExpressionEvalRequestBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.JiraExpressionResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JiraExpressionsApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<JiraExpressionResult> returnType_evaluateJiraExpression = new TypeReference<JiraExpressionResult>() {};

  private final HttpClient httpClient;

  public JiraExpressionsApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Evaluate Jira expression
   * <p>Evaluates a Jira expression and returns its value.</p> <p>This resource can be used to test Jira expressions that you plan to use elsewhere, or to fetch data in a flexible way. Consult the <a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions/\">Jira expressions documentation</a> for more details.</p> <h4>Context variables</h4> <p>The following context variables are available to Jira expressions evaluated by this resource. Their presence depends on various factors; usually you need to manually request them in the context object sent in the payload, but some of them are added automatically under certain conditions.</p> <ul> <li><code>user</code> (<a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#user\">User</a>): The current user. Always available and equal to <code>null</code> if the request is anonymous.</li> <li><code>app</code> (<a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#app\">App</a>): The Connect app that made the request. Available only for authenticated requests made by Connect Apps (read more here: <a href=\"https://developer.atlassian.com/cloud/jira/platform/authentication-for-apps/\">Authentication for Connect apps</a>).</li> <li><code>issue</code> (<a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#issue\">Issue</a>): The current issue. Available only when the issue is provided in the request context object.</li> <li><code>issues</code> (<a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#list\">List</a> of <a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#issue\">Issues</a>): A collection of issues matching a given JQL. Available only when the JQL is provided in the request context object (<strong>experimental</strong>).</li> <li><code>project</code> (<a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#project\">Project</a>): The current project. Available only when the project is provided in the request context object.</li> <li><code>sprint</code> (<a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#sprint\">Sprint</a>): The current sprint. Available only when the sprint is provided in the request context object.</li> <li><code>board</code> (<a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#board\">Board</a>): The current board. Available only when the board is provided in the request context object.</li> <li><code>serviceDesk</code> (<a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#servicedesk\">ServiceDesk</a>): The current service desk. Available only when the service desk is provided in the request context object.</li> <li><code>customerRequest</code> (<a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#customerrequest\">CustomerRequest</a>): The current customer request. Available only when the customer request is provided in the request context object.</li> </ul> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required</strong>: None. However, an expression may return different results for different users depending on their permissions. For example, different users may see different comments on the same issue.<br /> Permission to access Jira Software is required to access Jira Software context variables (<code>board</code> and <code>sprint</code>) or fields (for example, <code>issue.sprint</code>).</p> 
   * @param jiraExpressionEvalRequestBean <p>The Jira expression and the evaluation context.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>meta.complexity</code> Returns information about the expression complexity (for example, the number of expensive operations used by the expression) and how close the expression is to reaching the <a href=\"https://developer.atlassian.com/cloud/jira/platform/jira-expressions/#restrictions\">complexity limit</a>. Useful when designing and debugging your expressions.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;JiraExpressionResult&gt;
   */
  public Single<JiraExpressionResult> evaluateJiraExpression(
    JiraExpressionEvalRequestBean jiraExpressionEvalRequestBean, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/expression/eval");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(jiraExpressionEvalRequestBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_evaluateJiraExpression);
  }

}
