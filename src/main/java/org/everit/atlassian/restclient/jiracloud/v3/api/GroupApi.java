/*
 * Copyright © 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.atlassian.restclient.jiracloud.v3.api;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.jiracloud.v3.model.AddGroupBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.Group;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanUserDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.UpdateUserToGroupBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<Group> returnType_addUserToGroup = new TypeReference<Group>() {};

  private static final TypeReference<Group> returnType_createGroup = new TypeReference<Group>() {};

  private static final TypeReference<Group> returnType_getGroup = new TypeReference<Group>() {};

  private static final TypeReference<PageBeanUserDetails> returnType_getUsersFromGroup = new TypeReference<PageBeanUserDetails>() {};

  private final RestClient restClient;

  public GroupApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add user to group
   * <p>Adds a user to a group.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Site administration (that is, member of the <em>site-admin</em> <a href=\"https://confluence.atlassian.com/x/24xjL\">group</a>).</p> 
   * @param requestBody <p>The user to add to the group.</p>  (required)
   * @param groupname <p>The name of the group (case sensitive).</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Group&gt;
   */
  public Single<Group> addUserToGroup(
    UpdateUserToGroupBean requestBody, Optional<String> groupname, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/group/user");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addUserToGroup);
  }

  /**
   * Create group
   * <p>Creates a group.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Site administration (that is, member of the <em>site-admin</em> <a href=\"https://confluence.atlassian.com/x/24xjL\">group</a>).</p> 
   * @param requestBody <p>The name of the group.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Group&gt;
   */
  public Single<Group> createGroup(
    AddGroupBean requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/group");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createGroup);
  }

  /**
   * Get group
   * <p>This operation is deprecated, use <a href=\"#api-rest-api-3-group-member-get\"><code>group/member</code></a>.</p> <p>Returns all users in a group.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param groupname <p>The name of the group.</p>  (optional)
   * @param expand <p>List of fields to expand.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Group&gt;
   * @deprecated
   */
  @Deprecated
  public Single<Group> getGroup(
    Optional<String> groupname, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/group");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getGroup);
  }

  /**
   * Get users from group
   * <p>Returns all users in a group.</p> <p>Note that users are ordered by username, however the username is not returned in the results due to privacy reasons.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param groupname <p>The name of the group.</p>  (optional)
   * @param includeInactiveUsers <p>Include inactive users.</p>  (optional, default to false)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>50</code>.</p>  (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanUserDetails&gt;
   */
  public Single<PageBeanUserDetails> getUsersFromGroup(
    Optional<String> groupname, Optional<Boolean> includeInactiveUsers, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/group/member");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    if (includeInactiveUsers.isPresent()) {
      queryParams.put("includeInactiveUsers", Collections.singleton(String.valueOf(includeInactiveUsers.get())));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getUsersFromGroup);
  }

  /**
   * Remove group
   * <p>Deletes a group.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Site administration (that is, member of the <em>site-admin</em> strategic <a href=\"https://confluence.atlassian.com/x/24xjL\">group</a>).</p> 
   * @param groupname <p>The name of the group.</p>  (optional)
   * @param swapGroup <p>The group to transfer restrictions to. Only comments and worklogs are transferred. If restrictions are not transferred, comments and worklogs are inaccessible after the deletion.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeGroup(
    Optional<String> groupname, Optional<String> swapGroup, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/group");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    if (swapGroup.isPresent()) {
      queryParams.put("swapGroup", Collections.singleton(String.valueOf(swapGroup.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Remove user from group
   * <p>Removes a user from a group.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Site administration (that is, member of the <em>site-admin</em> <a href=\"https://confluence.atlassian.com/x/24xjL\">group</a>).</p> 
   * @param groupname <p>The name of the group.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">deprecation notice</a> for details.</p>  (optional)
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeUserFromGroup(
    Optional<String> groupname, Optional<String> username, Optional<String> accountId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/group/user");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

}
