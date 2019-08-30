package org.openapitools.client.api;

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

import org.openapitools.client.model.PageBeanUser;
import org.openapitools.client.model.PageBeanUserKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSearchApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<PageBeanUserKey> returnType_findUserKeysByQuery = new TypeReference<PageBeanUserKey>() {};

  private static final TypeReference<PageBeanUser> returnType_findUsersByQuery = new TypeReference<PageBeanUser>() {};

  private final HttpClient httpClient;

  public UserSearchApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Find user keys by query
   * <p>Finds users with a structured query and returns a list of user keys.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> <p>The query statements are:</p> <ul> <li><code>is assignee of PROJ</code> Returns the users that are assignees of at least one issue in project <em>PROJ</em>.</li> <li><code>is assignee of (PROJ-1, PROJ-2)</code> Returns users that are assignees on the issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>is reporter of (PROJ-1, PROJ-2)</code> Returns users that are reporters on the issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>is watcher of (PROJ-1, PROJ-2)</code> Returns users that are watchers on the issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>is voter of (PROJ-1, PROJ-2)</code> Returns users that are voters on the issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>is commenter of (PROJ-1, PROJ-2)</code> Returns users that have posted a comment on the issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>is transitioner of (PROJ-1, PROJ-2)</code> Returns users that have performed a transition on issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>[propertyKey].entity.property.path is &quot;property value&quot;</code> Returns users with the entity property value.</li> </ul> <p>The list of issues can be extended as needed, as in <em>(PROJ-1, PROJ-2, ... PROJ-n)</em>. Statements can be combined using the <code>AND</code> and <code>OR</code> operators to form more complex queries. For example:</p> <p><code>is assignee of PROJ AND [propertyKey].entity.property.path is &quot;property value&quot;</code></p> 
   * @param query <p>The search query.</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 100)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanUserKey&gt;
   */
  public Single<PageBeanUserKey> findUserKeysByQuery(
    Optional<String> query, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/search/query/key");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_findUserKeysByQuery);
  }

  /**
   * Find users by query
   * <p>Finds users with a structured query and returns user details.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> <p>The query statements are:</p> <ul> <li><code>is assignee of PROJ</code> Returns the users that are assignees of at least one issue in project <em>PROJ</em>.</li> <li><code>is assignee of (PROJ-1, PROJ-2)</code> Returns users that are assignees on the issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>is reporter of (PROJ-1, PROJ-2)</code> Returns users that are reporters on the issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>is watcher of (PROJ-1, PROJ-2)</code> Returns users that are watchers on the issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>is voter of (PROJ-1, PROJ-2)</code> Returns users that are voters on the issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>is commenter of (PROJ-1, PROJ-2)</code> Returns users that have posted a comment on the issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>is transitioner of (PROJ-1, PROJ-2)</code> Returns users that have performed a transition on issues <em>PROJ-1</em> or <em>PROJ-2</em>.</li> <li><code>[propertyKey].entity.property.path is &quot;property value&quot;</code> Returns users with the entity property value.</li> </ul> <p>The list of issues can be extended as needed, as in <em>(PROJ-1, PROJ-2, ... PROJ-n)</em>. Statements can be combined using the <code>AND</code> and <code>OR</code> operators to form more complex queries. For example:</p> <p><code>is assignee of PROJ AND [propertyKey].entity.property.path is &quot;property value&quot;</code></p> 
   * @param query <p>The search query.</p>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>1000</code>.</p>  (optional, default to 100)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanUser&gt;
   */
  public Single<PageBeanUser> findUsersByQuery(
    Optional<String> query, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/search/query");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_findUsersByQuery);
  }

}
