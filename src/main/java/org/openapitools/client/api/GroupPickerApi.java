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

import org.openapitools.client.model.FoundGroups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class GroupPickerApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<FoundGroups> returnType_findGroups = new TypeReference<FoundGroups>() {};


  private final HttpClient httpClient;

  public GroupPickerApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Find groups
   * <p>Returns a list of groups whose names contain a query string. A list of group names can be provided to exclude groups from the results.</p> <p>The primary use case for this resource is to populate a group picker suggestions list. To this end, the returned object includes the <code>html</code> field where the matched query term is highlighted in the group name with the HTML strong tag. Also, the groups list is wrapped in a response object that contains a header for use in the picker, specifically <em>Showing X of Y matching groups</em>.</p> <p>The list returns with the groups sorted. If no groups match the list criteria, an empty list is returned.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a>. Anonymous calls and calls by users without the required permission return an empty list.</p> 
   * @param accountId <p>This parameter is deprecated, setting it does not affect the results. To find groups containing a particular user, use <a href=\"#api-rest-api-3-user-groups-get\">Get user groups</a>.</p>  (optional)
   * @param query <p>The string to find in group names.</p>  (optional)
   * @param exclude <p>A group to exclude from the result. To exclude multiple groups, provide multiple copies of this parameter. For example, <code>exclude=group1&amp;exclude=group2</code>.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param maxResults <p>The maximum number of groups to return. The maximum number of groups that can be returned is limited by the system property <code>jira.ajax.autocomplete.limit</code>.</p>  (optional)
   * @param userName <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;FoundGroups&gt;
   */
  public Single<FoundGroups> findGroups(
    String accountId, String query, List<String> exclude, Integer maxResults, String userName, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/groups/picker";
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    if (query != null) {
      request.queryParams.put("query", Collections.singleton(String.valueOf(query)));
    }
    if (exclude != null) {
      request.queryParams.put("exclude", RestCallUtil.objectCollectionToStringCollection(exclude));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (userName != null) {
      request.queryParams.put("userName", Collections.singleton(String.valueOf(userName)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_findGroups);
  }

}
