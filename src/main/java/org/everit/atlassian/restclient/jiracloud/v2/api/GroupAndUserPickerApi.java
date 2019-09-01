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

import org.everit.atlassian.restclient.jiracloud.v2.model.FoundUsersAndGroups;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAndUserPickerApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<FoundUsersAndGroups> returnType_findUsersAndGroups = new TypeReference<FoundUsersAndGroups>() {};

  private final HttpClient httpClient;

  public GroupAndUserPickerApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Find users and groups
   * <p>Returns a list of users and groups matching a string. The string is used:</p> <ul> <li>for users, to find a case-insensitive match with display name and e-mail address. Note that if a user has hidden their email address in their user profile, partial matches of the email address will not find the user. An exact match is required.</li> <li>for groups, to find a case-sensitive match with group name.</li> </ul> <p>For example, if the string <em>tin</em> is used, records with the display name <em>Tina</em>, email address <em>sarah@tinplatetraining.com</em>, and the group <em>accounting</em> would be returned.</p> <p>Optionally, the search can be refined to:</p> <ul> <li> <p>the projects and issue types associated with a custom field, such as a user picker. The search can then be further refined to return only users and groups that have permission to view specific:</p> <ul> <li>projects.</li> <li>issue types.</li> </ul> <p>If multiple projects or issue types are specified, they must be a subset of those enabled for the custom field or no results are returned. For example, if a field is enabled for projects A, B, and C then the search could be limited to projects B and C. However, if the search is limited to projects B and D, nothing is returned.</p> </li> <li> <p>not return Connect app users and groups.</p> </li> <li> <p>return groups that have a case-insensitive match with the query.</p> </li> </ul> <p>The primary use case for this resource is to populate a picker field suggestion list with users or groups. To this end, the returned object includes an <code>html</code> field for each list. This field highlights the matched query term in the item name with the HTML strong tag. Also, each list is wrapped in a response object that contains a header for use in a picker, specifically <em>Showing X of Y matching groups</em>.</p> <p>This operation can be accessed anonymously if permissions allow open access.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse users and groups</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">global permission</a>.</p> 
   * @param query <p>The search string.</p>  (optional)
   * @param maxResults <p>The maximum number of items to return in each list. The maximum is <code>1000</code>.</p>  (optional, default to 50)
   * @param showAvatar <p>Indicates whether the user avatar should be returned. If an invalid value is provided, the default value is used.</p>  (optional, default to false)
   * @param fieldId <p>The custom field ID of the field this request is for.</p>  (optional)
   * @param projectId <p>The ID of a project that returned users and groups must have permission to view. To include multiple projects, provide multiple copies of this parameter. For example, <code>projectId=10000&amp;projectId=10001</code>. This parameter is only used when <code>fieldId</code> is present.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param issueTypeId <p>The ID of an issue type that returned users and groups must have permission to view. To include multiple issue types, provide multiple copies of this parameter. For example, <code>issueTypeId=10000&amp;issueTypeId=10001</code>. Special values, such as <code>-1</code> (all standard issue types) and <code>-2</code> (all subtask issue types), are supported. This parameter is only used when <code>fieldId</code> is present.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param avatarSize <p>The size of the avatar to return. If an invalid value is provided, the default value is used.</p>  (optional, default to xsmall)
   * @param caseInsensitive <p>Indicates whether the search for groups should be case insensitive.</p>  (optional, default to false)
   * @param excludeConnectAddons <p>Indicates whether Connect app users and groups should be excluded from the search results. If an invalid value is provided, the default value is used.</p>  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;FoundUsersAndGroups&gt;
   */
  public Single<FoundUsersAndGroups> findUsersAndGroups(
    Optional<String> query, Optional<Integer> maxResults, Optional<Boolean> showAvatar, Optional<String> fieldId, Optional<List<String>> projectId, Optional<List<String>> issueTypeId, Optional<String> avatarSize, Optional<Boolean> caseInsensitive, Optional<Boolean> excludeConnectAddons, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/groupuserpicker");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (query.isPresent()) {
      queryParams.put("query", Collections.singleton(String.valueOf(query.get())));
    }
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
      queryParams.put("projectId", RestCallUtil.objectCollectionToStringCollection(projectId.get()));
    }
    if (issueTypeId.isPresent()) {
      queryParams.put("issueTypeId", RestCallUtil.objectCollectionToStringCollection(issueTypeId.get()));
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

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_findUsersAndGroups);
  }

}
