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

import org.openapitools.client.model.PageBeanUser;
import org.openapitools.client.model.UserMigrationBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class UserBulkApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<PageBeanUser> returnType_bulkGetUsers = new TypeReference<PageBeanUser>() {};


  private static final TypeReference<List<UserMigrationBean>> returnType_bulkGetUsersMigration = new TypeReference<List<UserMigrationBean>>() {};


  private final HttpClient httpClient;

  public UserBulkApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Bulk get users
   * <p>Returns details of the users specified by one or more account IDs.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>200</code>.</p>  (optional, default to 10)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param key <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param accountId <p>Account ID of a user. To specify multiple users, pass multiple <code>accountId</code> parameters. For example, <code>accountId=99:27935d01-92a7-4687-8272-a9b8d3b2ae2e&amp;accountId=26912:8347-325f-ef346-bd0342234324</code>. Required.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanUser&gt;
   */
  public Single<PageBeanUser> bulkGetUsers(
    Long startAt, Integer maxResults, List<String> username, List<String> key, List<String> accountId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/bulk";
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (username != null) {
      request.queryParams.put("username", RestCallUtil.objectCollectionToStringCollection(username));
    }
    if (key != null) {
      request.queryParams.put("key", RestCallUtil.objectCollectionToStringCollection(key));
    }
    if (accountId != null) {
      request.queryParams.put("accountId", RestCallUtil.objectCollectionToStringCollection(accountId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_bulkGetUsers);
  }

  /**
   * Bulk get users migration
   * <p>Returns account IDs for the users specified in one or more user key or username parameters.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>200</code>.</p>  (optional, default to 10)
   * @param username <p>Username of a user. To specify multiple users, pass multiple <code>username</code> parameters. For example, <code>username=fred&amp;username=barney</code>. Required if <code>key</code> isn't provided. Cannot be provided if <code>key</code> is present.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param key <p>Key of a user. To specify multiple users, pass multiple <code>key</code> parameters. For example, <code>key=fred&amp;key=barney</code>. Required if <code>username</code> isn't provided. Cannot be provided if <code>username</code> is present.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;UserMigrationBean&gt;&gt;
   */
  public Single<List<UserMigrationBean>> bulkGetUsersMigration(
    Long startAt, Integer maxResults, List<String> username, List<String> key, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/user/bulk/migration";
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (username != null) {
      request.queryParams.put("username", RestCallUtil.objectCollectionToStringCollection(username));
    }
    if (key != null) {
      request.queryParams.put("key", RestCallUtil.objectCollectionToStringCollection(key));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_bulkGetUsersMigration);
  }

}
