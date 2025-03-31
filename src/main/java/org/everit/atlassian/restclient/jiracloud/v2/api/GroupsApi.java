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
package org.everit.atlassian.restclient.jiracloud.v2.api;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.jiracloud.v2.model.FoundGroups;
import org.everit.atlassian.restclient.jiracloud.v2.model.Group;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanGroupDetails;
import org.everit.atlassian.restclient.jiracloud.v2.model.PageBeanUserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Group> returnType_addUserToGroup = new TypeReference<Group>() {};

  private static final TypeReference<PageBeanGroupDetails> returnType_bulkGetGroups = new TypeReference<PageBeanGroupDetails>() {};

  private static final TypeReference<Group> returnType_createGroup = new TypeReference<Group>() {};

  private static final TypeReference<FoundGroups> returnType_findGroups = new TypeReference<FoundGroups>() {};

  private static final TypeReference<Group> returnType_getGroup = new TypeReference<Group>() {};

  private static final TypeReference<PageBeanUserDetails> returnType_getUsersFromGroup = new TypeReference<PageBeanUserDetails>() {};

  private final RestClient restClient;

  public GroupsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Add user to group
   * Adds a user to a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
   * @param requestBody The user to add to the group. (required)
   * @param groupname As a group's name can change, use of `groupId` is recommended to identify a group.   The name of the group. This parameter cannot be used with the `groupId` parameter. (optional)
   * @param groupId The ID of the group. This parameter cannot be used with the `groupName` parameter. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Group&gt;
   */
  public Single<Group> addUserToGroup(
    Map<String, Object> requestBody, Optional<String> groupname, Optional<String> groupId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/group/user");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    if (groupId.isPresent()) {
      queryParams.put("groupId", Collections.singleton(String.valueOf(groupId.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(requestBody));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_addUserToGroup);
  }

  /**
   * Bulk get groups
   * Returns a [paginated](#pagination) list of groups.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page. (optional, default to 50)
   * @param groupId The ID of a group. To specify multiple IDs, pass multiple `groupId` parameters. For example, `groupId=5b10a2844c20165700ede21g&groupId=5b10ac8d82e05b22cc7d4ef5`. (optional, default to new ArrayList&lt;&gt;())
   * @param groupName The name of a group. To specify multiple names, pass multiple `groupName` parameters. For example, `groupName=administrators&groupName=jira-software-users`. (optional, default to new ArrayList&lt;&gt;())
   * @param accessType The access level of a group. Valid values: 'site-admin', 'admin', 'user'. (optional)
   * @param applicationKey The application key of the product user groups to search for. Valid values: 'jira-servicedesk', 'jira-software', 'jira-product-discovery', 'jira-core'. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanGroupDetails&gt;
   */
  public Single<PageBeanGroupDetails> bulkGetGroups(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<List<String>> groupId, Optional<List<String>> groupName, Optional<String> accessType, Optional<String> applicationKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/group/bulk");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (groupId.isPresent()) {
      queryParams.put("groupId", RestClientUtil.objectCollectionToStringCollection(groupId.get()));
    }
    if (groupName.isPresent()) {
      queryParams.put("groupName", RestClientUtil.objectCollectionToStringCollection(groupName.get()));
    }
    if (accessType.isPresent()) {
      queryParams.put("accessType", Collections.singleton(String.valueOf(accessType.get())));
    }
    if (applicationKey.isPresent()) {
      queryParams.put("applicationKey", Collections.singleton(String.valueOf(applicationKey.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_bulkGetGroups);
  }

  /**
   * Create group
   * Creates a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
   * @param requestBody The name of the group. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Group&gt;
   */
  public Single<Group> createGroup(
    Map<String, Object> requestBody, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/group");

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
   * Find groups
   * Returns a list of groups whose names contain a query string. A list of group names can be provided to exclude groups from the results.  The primary use case for this resource is to populate a group picker suggestions list. To this end, the returned object includes the `html` field where the matched query term is highlighted in the group name with the HTML strong tag. Also, the groups list is wrapped in a response object that contains a header for use in the picker, specifically *Showing X of Y matching groups*.  The list returns with the groups sorted. If no groups match the list criteria, an empty list is returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg). Anonymous calls and calls by users without the required permission return an empty list.  *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg). Without this permission, calls where query is not an exact match to an existing group will return an empty list.
   * @param accountId This parameter is deprecated, setting it does not affect the results. To find groups containing a particular user, use [Get user groups](#api-rest-api-2-user-groups-get). (optional)
   * @param query The string to find in group names. (optional)
   * @param exclude As a group's name can change, use of `excludeGroupIds` is recommended to identify a group.   A group to exclude from the result. To exclude multiple groups, provide an ampersand-separated list. For example, `exclude=group1&exclude=group2`. This parameter cannot be used with the `excludeGroupIds` parameter. (optional, default to new ArrayList&lt;&gt;())
   * @param excludeId A group ID to exclude from the result. To exclude multiple groups, provide an ampersand-separated list. For example, `excludeId=group1-id&excludeId=group2-id`. This parameter cannot be used with the `excludeGroups` parameter. (optional, default to new ArrayList&lt;&gt;())
   * @param maxResults The maximum number of groups to return. The maximum number of groups that can be returned is limited by the system property `jira.ajax.autocomplete.limit`. (optional)
   * @param caseInsensitive Whether the search for groups should be case insensitive. (optional, default to false)
   * @param userName This parameter is no longer available. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;FoundGroups&gt;
   */
  public Single<FoundGroups> findGroups(
    Optional<String> accountId, Optional<String> query, Optional<List<String>> exclude, Optional<List<String>> excludeId, Optional<Integer> maxResults, Optional<Boolean> caseInsensitive, Optional<String> userName, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/groups/picker");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
    if (exclude.isPresent()) {
      queryParams.put("exclude", RestClientUtil.objectCollectionToStringCollection(exclude.get()));
    }
    if (excludeId.isPresent()) {
      queryParams.put("excludeId", RestClientUtil.objectCollectionToStringCollection(excludeId.get()));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (caseInsensitive.isPresent()) {
      queryParams.put("caseInsensitive", Collections.singleton(String.valueOf(caseInsensitive.get())));
    }
    if (userName.isPresent()) {
      queryParams.put("userName", Collections.singleton(String.valueOf(userName.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_findGroups);
  }

  /**
   * Get group
   * This operation is deprecated, use [`group/member`](#api-rest-api-2-group-member-get).  Returns all users in a group.  **[Permissions](#permissions) required:** either of:   *  *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param groupname As a group's name can change, use of `groupId` is recommended to identify a group.   The name of the group. This parameter cannot be used with the `groupId` parameter. (optional)
   * @param groupId The ID of the group. This parameter cannot be used with the `groupName` parameter. (optional)
   * @param expand List of fields to expand. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Group&gt;
   * @deprecated
   */
  @Deprecated
  public Single<Group> getGroup(
    Optional<String> groupname, Optional<String> groupId, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/group");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    if (groupId.isPresent()) {
      queryParams.put("groupId", Collections.singleton(String.valueOf(groupId.get())));
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
   * Returns a [paginated](#pagination) list of all users in a group.  Note that users are ordered by username, however the username is not returned in the results due to privacy reasons.  **[Permissions](#permissions) required:** either of:   *  *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param groupname As a group's name can change, use of `groupId` is recommended to identify a group.   The name of the group. This parameter cannot be used with the `groupId` parameter. (optional)
   * @param groupId The ID of the group. This parameter cannot be used with the `groupName` parameter. (optional)
   * @param includeInactiveUsers Include inactive users. (optional, default to false)
   * @param startAt The index of the first item to return in a page of results (page offset). (optional, default to 0l)
   * @param maxResults The maximum number of items to return per page (number should be between 1 and 50). (optional, default to 50)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanUserDetails&gt;
   */
  public Single<PageBeanUserDetails> getUsersFromGroup(
    Optional<String> groupname, Optional<String> groupId, Optional<Boolean> includeInactiveUsers, Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/group/member");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    if (groupId.isPresent()) {
      queryParams.put("groupId", Collections.singleton(String.valueOf(groupId.get())));
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
   * Deletes a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* strategic [group](https://confluence.atlassian.com/x/24xjL)).
   * @param groupname  (optional)
   * @param groupId The ID of the group. This parameter cannot be used with the `groupname` parameter. (optional)
   * @param swapGroup As a group's name can change, use of `swapGroupId` is recommended to identify a group.   The group to transfer restrictions to. Only comments and worklogs are transferred. If restrictions are not transferred, comments and worklogs are inaccessible after the deletion. This parameter cannot be used with the `swapGroupId` parameter. (optional)
   * @param swapGroupId The ID of the group to transfer restrictions to. Only comments and worklogs are transferred. If restrictions are not transferred, comments and worklogs are inaccessible after the deletion. This parameter cannot be used with the `swapGroup` parameter. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeGroup(
    Optional<String> groupname, Optional<String> groupId, Optional<String> swapGroup, Optional<String> swapGroupId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/group");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    if (groupId.isPresent()) {
      queryParams.put("groupId", Collections.singleton(String.valueOf(groupId.get())));
    }
    if (swapGroup.isPresent()) {
      queryParams.put("swapGroup", Collections.singleton(String.valueOf(swapGroup.get())));
    }
    if (swapGroupId.isPresent()) {
      queryParams.put("swapGroupId", Collections.singleton(String.valueOf(swapGroupId.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Remove user from group
   * Removes a user from a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
   * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*. (required)
   * @param groupname As a group's name can change, use of `groupId` is recommended to identify a group.   The name of the group. This parameter cannot be used with the `groupId` parameter. (optional)
   * @param groupId The ID of the group. This parameter cannot be used with the `groupName` parameter. (optional)
   * @param username This parameter is no longer available. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeUserFromGroup(
    String accountId, Optional<String> groupname, Optional<String> groupId, Optional<String> username, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/group/user");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (groupname.isPresent()) {
      queryParams.put("groupname", Collections.singleton(String.valueOf(groupname.get())));
    }
    if (groupId.isPresent()) {
      queryParams.put("groupId", Collections.singleton(String.valueOf(groupId.get())));
    }
    if (username.isPresent()) {
      queryParams.put("username", Collections.singleton(String.valueOf(username.get())));
    }
    queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

}
