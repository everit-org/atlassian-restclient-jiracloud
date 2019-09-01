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

import org.everit.atlassian.restclient.jiracloud.v2.model.NotificationScheme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectNotificationSchemeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<NotificationScheme> returnType_getNotificationScheme = new TypeReference<NotificationScheme>() {};

  private final HttpClient httpClient;

  public ProjectNotificationSchemeApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get project notification scheme
   * <p>Gets a <a href=\"https://confluence.atlassian.com/x/8YdKLg\">notification scheme</a> associated with the project. See the <a href=\"#api-rest-api-2-notificationscheme-id-get\">Get notification scheme</a> resource for more information about notification schemes.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a>.</p> 
   * @param projectKeyOrId <p>The project ID or project key (case sensitive).</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>all</code> Returns all expandable information.</li> <li><code>field</code> Returns information about any custom fields assigned to receive an event.</li> <li><code>group</code> Returns information about any groups assigned to receive an event.</li> <li><code>notificationSchemeEvents</code> Returns a list of event associations. This list is returned for all expandable information.</li> <li><code>projectRole</code> Returns information about any project roles assigned to receive an event.</li> <li><code>user</code> Returns information about any users assigned to receive an event.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;NotificationScheme&gt;
   */
  public Single<NotificationScheme> getNotificationScheme(
    String projectKeyOrId, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/project/{projectKeyOrId}/notificationscheme");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("projectKeyOrId", String.valueOf(projectKeyOrId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getNotificationScheme);
  }

}
