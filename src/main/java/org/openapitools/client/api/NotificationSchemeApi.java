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

import org.openapitools.client.model.NotificationScheme;
import org.openapitools.client.model.PageBeanNotificationScheme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class NotificationSchemeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<NotificationScheme> returnType_getNotificationScheme = new TypeReference<NotificationScheme>() {};


  private static final TypeReference<PageBeanNotificationScheme> returnType_getNotificationSchemes = new TypeReference<PageBeanNotificationScheme>() {};


  private final HttpClient httpClient;

  public NotificationSchemeApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get notification scheme
   * <p>Returns a <a href=\"https://confluence.atlassian.com/x/8YdKLg\">notification scheme</a>, including the list of events and the recipients who will receive notifications for those events.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however the user must have permission to administer at least one project associated with the notification scheme.</p> 
   * @param id <p>The ID of the notification scheme. Use <a href=\"#api-rest-api-3-notificationscheme-get\">Get notification schemes paginated</a> to get a list of notification scheme IDs.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>all</code> Returns all expandable information.</li> <li><code>field</code> Returns information about any custom fields assigned to receive an event.</li> <li><code>group</code> Returns information about any groups assigned to receive an event.</li> <li><code>notificationSchemeEvents</code> Returns a list of event associations. This list is returned for all expandable information.</li> <li><code>projectRole</code> Returns information about any project roles assigned to receive an event.</li> <li><code>user</code> Returns information about any users assigned to receive an event.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;NotificationScheme&gt;
   */
  public Single<NotificationScheme> getNotificationScheme(
    Long id, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/notificationscheme/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getNotificationScheme);
  }

  /**
   * Get notification schemes paginated
   * <p>Returns a <a href=\"#pagination\">paginated</a> list of <a href=\"https://confluence.atlassian.com/x/8YdKLg\">notification schemes</a> in order by display name.</p> <h3>About notification schemes</h3> <p>A notification scheme is a list of events and recipients who will receive notifications for those events. The list is contained within the <code>notificationSchemeEvents</code> object and contains pairs of <code>events</code> and <code>notifications</code>:</p> <ul> <li> <p><code>event</code> Identifies the type of event. The events can be <a href=\"https://confluence.atlassian.com/x/8YdKLg#Creatinganotificationscheme-eventsEvents\">Jira system events</a> or <a href=\"https://confluence.atlassian.com/x/AIlKLg\">custom events</a>.</p> </li> <li> <p><code>notifications</code> Identifies the <a href=\"https://confluence.atlassian.com/x/8YdKLg#Creatinganotificationscheme-recipientsRecipients\">recipients</a> of notifications for each event. Recipients can be any of the following types:</p> <ul> <li><code>CurrentAssignee</code></li> <li><code>Reporter</code></li> <li><code>CurrentUser</code></li> <li><code>ProjectLead</code></li> <li><code>ComponentLead</code></li> <li><code>User</code> (the <code>parameter</code> is the user key)</li> <li><code>Group</code> (the <code>parameter</code> is the group name)</li> <li><code>ProjectRole</code> (the <code>parameter</code> is the project role ID)</li> <li><code>EmailAddress</code></li> <li><code>AllWatchers</code></li> <li><code>UserCustomField</code> (the <code>parameter</code> is the ID of the custom field)</li> <li><code>GroupCustomField</code>(the <code>parameter</code> is the ID of the custom field)</li> </ul> </li> </ul> <p><em>Note that you should allow for events without recipients to appear in responses.</em></p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira, however the user must have permission to administer at least one project associated with a notification scheme for it to be returned.</p> 
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>50</code>.</p>  (optional, default to 50)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>all</code> Returns all expandable information.</li> <li><code>field</code> Returns information about any custom fields assigned to receive an event.</li> <li><code>group</code> Returns information about any groups assigned to receive an event.</li> <li><code>notificationSchemeEvents</code> Returns a list of event associations. This list is returned for all expandable information.</li> <li><code>projectRole</code> Returns information about any project roles assigned to receive an event.</li> <li><code>user</code> Returns information about any users assigned to receive an event.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanNotificationScheme&gt;
   */
  public Single<PageBeanNotificationScheme> getNotificationSchemes(
    Long startAt, Integer maxResults, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/notificationscheme";
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

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getNotificationSchemes);
  }

}
