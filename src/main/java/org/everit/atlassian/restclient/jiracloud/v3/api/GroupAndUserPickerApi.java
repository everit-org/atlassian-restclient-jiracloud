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

import org.everit.atlassian.restclient.jiracloud.v3.model.FoundUsersAndGroups;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAndUserPickerApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<FoundUsersAndGroups> returnType_findUsersAndGroups = new TypeReference<FoundUsersAndGroups>() {};

  private final RestClient restClient;

  public GroupAndUserPickerApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Find users and groups
   * Returns a list of users and groups matching a string. The string is used:   *  for users, to find a case-insensitive match with display name and e-mail address. Note that if a user has hidden their email address in their user profile, partial matches of the email address will not find the user. An exact match is required.  *  for groups, to find a case-sensitive match with group name.  For example, if the string *tin* is used, records with the display name *Tina*, email address *sarah@tinplatetraining.com*, and the group *accounting* would be returned.  Optionally, the search can be refined to:   *  the projects and issue types associated with a custom field, such as a user picker. The search can then be further refined to return only users and groups that have permission to view specific:           *  projects.      *  issue types.          If multiple projects or issue types are specified, they must be a subset of those enabled for the custom field or no results are returned. For example, if a field is enabled for projects A, B, and C then the search could be limited to projects B and C. However, if the search is limited to projects B and D, nothing is returned.  *  not return Connect app users and groups.  *  return groups that have a case-insensitive match with the query.  The primary use case for this resource is to populate a picker field suggestion list with users or groups. To this end, the returned object includes an `html` field for each list. This field highlights the matched query term in the item name with the HTML strong tag. Also, each list is wrapped in a response object that contains a header for use in a picker, specifically *Showing X of Y matching groups*.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/yodKLg).
   * @param query The search string. (required)
   * @param maxResults The maximum number of items to return in each list. (optional, default to 50)
   * @param showAvatar Whether the user avatar should be returned. If an invalid value is provided, the default value is used. (optional, default to false)
   * @param fieldId The custom field ID of the field this request is for. (optional)
   * @param projectId The ID of a project that returned users and groups must have permission to view. To include multiple projects, provide an ampersand-separated list. For example, `projectId=10000&projectId=10001`. This parameter is only used when `fieldId` is present. (optional, default to new ArrayList&lt;&gt;())
   * @param issueTypeId The ID of an issue type that returned users and groups must have permission to view. To include multiple issue types, provide an ampersand-separated list. For example, `issueTypeId=10000&issueTypeId=10001`. Special values, such as `-1` (all standard issue types) and `-2` (all subtask issue types), are supported. This parameter is only used when `fieldId` is present. (optional, default to new ArrayList&lt;&gt;())
   * @param avatarSize The size of the avatar to return. If an invalid value is provided, the default value is used. (optional, default to xsmall)
   * @param caseInsensitive Whether the search for groups should be case insensitive. (optional, default to false)
   * @param excludeConnectAddons Whether Connect app users and groups should be excluded from the search results. If an invalid value is provided, the default value is used. (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;FoundUsersAndGroups&gt;
   */
  public Single<FoundUsersAndGroups> findUsersAndGroups(
    String query, Optional<Integer> maxResults, Optional<Boolean> showAvatar, Optional<String> fieldId, Optional<List<String>> projectId, Optional<List<String>> issueTypeId, Optional<String> avatarSize, Optional<Boolean> caseInsensitive, Optional<Boolean> excludeConnectAddons, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/groupuserpicker");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("query", Collections.singleton(String.valueOf(query)));
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (showAvatar.isPresent()) {
      queryParams.put("showAvatar", Collections.singleton(String.valueOf(showAvatar.get())));
    }
    if (fieldId.isPresent()) {
      queryParams.put("fieldId", Collections.singleton(String.valueOf(fieldId.get())));
    }
    if (projectId.isPresent()) {
      queryParams.put("projectId", RestClientUtil.objectCollectionToStringCollection(projectId.get()));
    }
    if (issueTypeId.isPresent()) {
      queryParams.put("issueTypeId", RestClientUtil.objectCollectionToStringCollection(issueTypeId.get()));
    }
    if (avatarSize.isPresent()) {
      queryParams.put("avatarSize", Collections.singleton(String.valueOf(avatarSize.get())));
    }
    if (caseInsensitive.isPresent()) {
      queryParams.put("caseInsensitive", Collections.singleton(String.valueOf(caseInsensitive.get())));
    }
    if (excludeConnectAddons.isPresent()) {
      queryParams.put("excludeConnectAddons", Collections.singleton(String.valueOf(excludeConnectAddons.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_findUsersAndGroups);
  }

}
