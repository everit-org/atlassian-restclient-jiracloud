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

import org.openapitools.client.model.PageOfWorklogs;
import org.openapitools.client.model.Worklog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class IssueWorklogsApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<Worklog> returnType_addWorklog = new TypeReference<Worklog>() {};


  private static final TypeReference<PageOfWorklogs> returnType_getIssueWorklog = new TypeReference<PageOfWorklogs>() {};


  private static final TypeReference<Worklog> returnType_getWorklog = new TypeReference<Worklog>() {};


  private static final TypeReference<Worklog> returnType_updateWorklog = new TypeReference<Worklog>() {};


  private final HttpClient httpClient;

  public IssueWorklogsApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Add worklog
   * <p>Adds a worklog to an issue.</p> <p>Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see <a href=\"https://confluence.atlassian.com/x/qoXKM\">Configuring time tracking</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> and <em>Work on issues</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key the issue.</p>  (required)
   * @param requestBody  (required)
   * @param notifyUsers <p>Indicates whether users watching the issue are notified by email.</p>  (optional, default to true)
   * @param adjustEstimate <p>Defines how to update the issue's time estimate, the options are:</p> <ul> <li><code>new</code> Sets the estimate to a specific value, defined in <code>newEstimate</code>.</li> <li><code>leave</code> Leaves the estimate unchanged.</li> <li><code>manual</code> Reduces the estimate by amount specified in <code>reduceBy</code>.</li> <li><code>auto</code> Reduces the estimate by the value of <code>timeSpent</code> in the worklog.</li> </ul>  (optional, default to auto)
   * @param newEstimate <p>The value to set as the issue's remaining time estimate, as days (#d), hours (#h), or minutes (#m or #). For example, <em>2d</em>. Required when <code>adjustEstimate</code> is <code>new</code>.</p>  (optional)
   * @param reduceBy <p>The amount to reduce the issue's remaining estimate by, as days (#d), hours (#h), or minutes (#m). For example, <em>2d</em>. Required when <code>adjustEstimate</code> is <code>manual</code>.</p>  (optional)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about work logs in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>properties</code> Returns worklog properties.</li> </ul>  (optional, default to &quot;&quot;)
   * @param overrideEditableFlag <p>Indicates whether the worklog entry should be added to the issue even if the issue is not editable, because jira.issue.editable set to false or missing. For example, the issue is closed. Only connect app users with admin scope permission can use this flag.</p>  (optional, default to false)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Worklog&gt;
   */
  public Single<Worklog> addWorklog(
    String issueIdOrKey, Worklog requestBody, Boolean notifyUsers, String adjustEstimate, String newEstimate, String reduceBy, String expand, Boolean overrideEditableFlag, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/worklog";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (notifyUsers != null) {
      request.queryParams.put("notifyUsers", Collections.singleton(String.valueOf(notifyUsers)));
    }
    if (adjustEstimate != null) {
      request.queryParams.put("adjustEstimate", Collections.singleton(String.valueOf(adjustEstimate)));
    }
    if (newEstimate != null) {
      request.queryParams.put("newEstimate", Collections.singleton(String.valueOf(newEstimate)));
    }
    if (reduceBy != null) {
      request.queryParams.put("reduceBy", Collections.singleton(String.valueOf(reduceBy)));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    if (overrideEditableFlag != null) {
      request.queryParams.put("overrideEditableFlag", Collections.singleton(String.valueOf(overrideEditableFlag)));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_addWorklog);
  }

  /**
   * Delete worklog
   * <p>Deletes a worklog from an issue.</p> <p>Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see <a href=\"https://confluence.atlassian.com/x/qoXKM\">Configuring time tracking</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li><em>Delete all worklogs</em><a href=\"https://confluence.atlassian.com/x/yodKLg\"> project permission</a> to delete any worklog or <em>Delete own worklogs</em> to delete worklogs created by the user,</li> <li>If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param id <p>The ID of the worklog.</p>  (required)
   * @param notifyUsers <p>Indicates whether users watching the issue are notified by email.</p>  (optional, default to true)
   * @param adjustEstimate <p>Defines how to update the issue's time estimate, the options are:</p> <ul> <li><code>new</code> Sets the estimate to a specific value, defined in <code>newEstimate</code>.</li> <li><code>leave</code> Leaves the estimate unchanged.</li> <li><code>manual</code> Increases the estimate by amount specified in <code>increaseBy</code>.</li> <li><code>auto</code> Reduces the estimate by the value of <code>timeSpent</code> in the worklog.</li> </ul>  (optional, default to auto)
   * @param newEstimate <p>The value to set as the issue's remaining time estimate, as days (#d), hours (#h), or minutes (#m or #). For example, <em>2d</em>. Required when <code>adjustEstimate</code> is <code>new</code>.</p>  (optional)
   * @param increaseBy <p>The amount to increase the issue's remaining estimate by, as days (#d), hours (#h), or minutes (#m or #). For example, <em>2d</em>. Required when <code>adjustEstimate</code> is <code>manual</code>.</p>  (optional)
   * @param overrideEditableFlag <p>Indicates whether the work log entry should be added to the issue even if the issue is not editable, because jira.issue.editable set to false or missing. For example, the issue is closed. Only connect app users with admin permissions can use this flag.</p>  (optional, default to false)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteWorklog(
    String issueIdOrKey, String id, Boolean notifyUsers, String adjustEstimate, String newEstimate, String increaseBy, Boolean overrideEditableFlag, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/worklog/{id}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    if (notifyUsers != null) {
      request.queryParams.put("notifyUsers", Collections.singleton(String.valueOf(notifyUsers)));
    }
    if (adjustEstimate != null) {
      request.queryParams.put("adjustEstimate", Collections.singleton(String.valueOf(adjustEstimate)));
    }
    if (newEstimate != null) {
      request.queryParams.put("newEstimate", Collections.singleton(String.valueOf(newEstimate)));
    }
    if (increaseBy != null) {
      request.queryParams.put("increaseBy", Collections.singleton(String.valueOf(increaseBy)));
    }
    if (overrideEditableFlag != null) {
      request.queryParams.put("overrideEditableFlag", Collections.singleton(String.valueOf(overrideEditableFlag)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Get issue worklogs
   * <p>Returns all worklogs for an issue.</p> <p>Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see <a href=\"https://confluence.atlassian.com/x/qoXKM\">Configuring time tracking</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Workloads are only returned where the user has:</p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1048576</code>.</p>  (optional, default to 1048576)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about worklogs in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>properties</code> Returns worklog properties.</li> </ul>  (optional, default to &quot;&quot;)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageOfWorklogs&gt;
   */
  public Single<PageOfWorklogs> getIssueWorklog(
    String issueIdOrKey, Long startAt, Integer maxResults, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/worklog";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueWorklog);
  }

  /**
   * Get worklog
   * <p>Returns a worklog.</p> <p>Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see <a href=\"https://confluence.atlassian.com/x/qoXKM\">Configuring time tracking</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key of the issue.</p>  (required)
   * @param id <p>The ID of the worklog.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about work logs in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>properties</code> Returns worklog properties.</li> </ul>  (optional, default to &quot;&quot;)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Worklog&gt;
   */
  public Single<Worklog> getWorklog(
    String issueIdOrKey, String id, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/worklog/{id}";
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

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getWorklog);
  }

  /**
   * Update worklog
   * <p>Updates a worklog.</p> <p>Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see <a href=\"https://confluence.atlassian.com/x/qoXKM\">Configuring time tracking</a>.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li><em>Edit all worklogs</em><a href=\"https://confluence.atlassian.com/x/yodKLg\"> project permission</a> to update any worklog or <em>Edit own worklogs</em> to update worklogs created by the user.</li> <li>If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param issueIdOrKey <p>The ID or key the issue.</p>  (required)
   * @param id <p>The ID of the worklog.</p>  (required)
   * @param requestBody  (required)
   * @param notifyUsers <p>Indicates whether users watching the issue are notified by email.</p>  (optional, default to true)
   * @param adjustEstimate <p>Defines how to update the issue's time estimate, the options are:</p> <ul> <li><code>new</code> Sets the estimate to a specific value, defined in <code>newEstimate</code>.</li> <li><code>leave</code> Leaves the estimate unchanged.</li> <li><code>auto</code> Updates the estimate by the difference between the original and updated value of <code>timeSpent</code> or <code>timeSpentSeconds</code>.</li> </ul>  (optional, default to auto)
   * @param newEstimate <p>The value to set as the issue's remaining time estimate, as days (#d), hours (#h), or minutes (#m or #). For example, <em>2d</em>. Required when <code>adjustEstimate</code> is <code>new</code>.</p>  (optional)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about worklogs in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>properties</code> Returns worklog properties.</li> </ul>  (optional, default to &quot;&quot;)
   * @param overrideEditableFlag <p>Indicates whether the worklog should be added to the issue even if the issue is not editable. For example, because the issue is closed. Only connect app users with admin permissions can use this flag.</p>  (optional, default to false)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Worklog&gt;
   */
  public Single<Worklog> updateWorklog(
    String issueIdOrKey, String id, Worklog requestBody, Boolean notifyUsers, String adjustEstimate, String newEstimate, String expand, Boolean overrideEditableFlag, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issue/{issueIdOrKey}/worklog/{id}";
    if (issueIdOrKey != null) {
      request.pathParams.put("issueIdOrKey", String.valueOf(issueIdOrKey));
    }
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    if (notifyUsers != null) {
      request.queryParams.put("notifyUsers", Collections.singleton(String.valueOf(notifyUsers)));
    }
    if (adjustEstimate != null) {
      request.queryParams.put("adjustEstimate", Collections.singleton(String.valueOf(adjustEstimate)));
    }
    if (newEstimate != null) {
      request.queryParams.put("newEstimate", Collections.singleton(String.valueOf(newEstimate)));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    if (overrideEditableFlag != null) {
      request.queryParams.put("overrideEditableFlag", Collections.singleton(String.valueOf(overrideEditableFlag)));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_updateWorklog);
  }

}
