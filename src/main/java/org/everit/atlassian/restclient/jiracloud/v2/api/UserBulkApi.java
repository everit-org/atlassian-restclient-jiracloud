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

import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanUser;
import org.everit.atlassian.restclient.jiracloud.v2.model.UserMigrationBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param key <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param accountId <p>Account ID of a user. To specify multiple users, pass multiple <code>accountId</code> parameters. For example, <code>accountId=99:27935d01-92a7-4687-8272-a9b8d3b2ae2e&amp;accountId=26912:8347-325f-ef346-bd0342234324</code>. Required.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanUser&gt;
   */
  public Single<PageBeanUser> bulkGetUsers(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<String>> username, Optional<List<String>> key, Optional<List<String>> accountId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/user/bulk");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", RestCallUtil.objectCollectionToStringCollection(username.get()));
    }
    if (key.isPresent()) {
      queryParams.put("key", RestCallUtil.objectCollectionToStringCollection(key.get()));
    }
    if (accountId.isPresent()) {
      queryParams.put("accountId", RestCallUtil.objectCollectionToStringCollection(accountId.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_bulkGetUsers);
  }

  /**
   * Get account IDs for users
   * <p>Returns the account IDs for the users specified in the <code>key</code> or <code>username</code> parameters. Note that multiple <code>key</code> or <code>username</code> parameters can be specified.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page.</p>  (optional, default to 10)
   * @param username <p>Username of a user. To specify multiple users, pass multiple copies of this parameter. For example, <code>username=fred&amp;username=barney</code>. Required if <code>key</code> isn't provided. Cannot be provided if <code>key</code> is present.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param key <p>Key of a user. To specify multiple users, pass multiple copies of this parameter. For example, <code>key=fred&amp;key=barney</code>. Required if <code>username</code> isn't provided. Cannot be provided if <code>username</code> is present.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;UserMigrationBean&gt;&gt;
   */
  public Single<List<UserMigrationBean>> bulkGetUsersMigration(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<String>> username, Optional<List<String>> key, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/user/bulk/migration");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", RestCallUtil.objectCollectionToStringCollection(username.get()));
    }
    if (key.isPresent()) {
      queryParams.put("key", RestCallUtil.objectCollectionToStringCollection(key.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_bulkGetUsersMigration);
  }

}
