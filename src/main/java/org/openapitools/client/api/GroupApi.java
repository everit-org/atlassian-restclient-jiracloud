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

import org.openapitools.client.model.AddGroupBean;
import org.openapitools.client.model.Group;
import org.openapitools.client.model.PageBeanUserDetails;
import org.openapitools.client.model.UpdateUserToGroupBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class GroupApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<Group> returnType_addUserToGroup = new TypeReference<Group>() {};


  private static final TypeReference<Group> returnType_createGroup = new TypeReference<Group>() {};


  private static final TypeReference<Group> returnType_getGroup = new TypeReference<Group>() {};


  private static final TypeReference<PageBeanUserDetails> returnType_getUsersFromGroup = new TypeReference<PageBeanUserDetails>() {};


  private final HttpClient httpClient;

  public GroupApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Add user to group
   * <p>Adds a user to a group.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Site administration (that is, member of the <em>site-admin</em> <a href=\"https://confluence.atlassian.com/x/24xjL\">group</a>).</p> 
   * @param requestBody <p>The user to add to the group.</p>  (required)
   * @param groupname <p>The name of the group (case sensitive).</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Group&gt;
   */
  public Single<Group> addUserToGroup(
    UpdateUserToGroupBean requestBody, String groupname, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/group/user";
    if (groupname != null) {
      request.queryParams.put("groupname", Collections.singleton(String.valueOf(groupname)));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_addUserToGroup);
  }

  /**
   * Create group
   * <p>Creates a group.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Site administration (that is, member of the <em>site-admin</em> <a href=\"https://confluence.atlassian.com/x/24xjL\">group</a>).</p> 
   * @param requestBody <p>The name of the group.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Group&gt;
   */
  public Single<Group> createGroup(
    AddGroupBean requestBody, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/group";
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createGroup);
  }

  /**
   * Get group
   * <p>This operation is deprecated, use <a href=\"#api-rest-api-3-group-member-get\"><code>group/member</code></a>.</p> <p>Returns all users in a group.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param groupname <p>The name of the group.</p>  (optional)
   * @param expand <p>List of fields to expand.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Group&gt;
   * @deprecated
   */
  @Deprecated
  public Single<Group> getGroup(
    String groupname, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/group";
    if (groupname != null) {
      request.queryParams.put("groupname", Collections.singleton(String.valueOf(groupname)));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getGroup);
  }

  /**
   * Get users from group
   * <p>Returns all users in a group.</p> <p>Note that users are ordered by username, however the username is not returned in the results due to privacy reasons.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param groupname <p>The name of the group.</p>  (optional)
   * @param includeInactiveUsers <p>Include inactive users.</p>  (optional, default to false)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>50</code>.</p>  (optional, default to 50)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanUserDetails&gt;
   */
  public Single<PageBeanUserDetails> getUsersFromGroup(
    String groupname, Boolean includeInactiveUsers, Long startAt, Integer maxResults, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/group/member";
    if (groupname != null) {
      request.queryParams.put("groupname", Collections.singleton(String.valueOf(groupname)));
    }
    if (includeInactiveUsers != null) {
      request.queryParams.put("includeInactiveUsers", Collections.singleton(String.valueOf(includeInactiveUsers)));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getUsersFromGroup);
  }

  /**
   * Remove group
   * <p>Deletes a group.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Site administration (that is, member of the <em>site-admin</em> strategic <a href=\"https://confluence.atlassian.com/x/24xjL\">group</a>).</p> 
   * @param groupname <p>The name of the group.</p>  (optional)
   * @param swapGroup <p>The group to transfer restrictions to. Only comments and worklogs are transferred. If restrictions are not transferred, comments and worklogs are inaccessible after the deletion.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeGroup(
    String groupname, String swapGroup, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/group";
    if (groupname != null) {
      request.queryParams.put("groupname", Collections.singleton(String.valueOf(groupname)));
    }
    if (swapGroup != null) {
      request.queryParams.put("swapGroup", Collections.singleton(String.valueOf(swapGroup)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Remove user from group
   * <p>Removes a user from a group.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Site administration (that is, member of the <em>site-admin</em> <a href=\"https://confluence.atlassian.com/x/24xjL\">group</a>).</p> 
   * @param groupname <p>The name of the group.</p>  (optional)
   * @param username <p>This parameter is no longer available and will be removed from the documentation soon. See the <a href=\"&quot;https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/&quot;\">deprecation notice</a> for details.</p>  (optional)
   * @param accountId <p>The accountId of the user, which uniquely identifies the user across all Atlassian products. For example, <em>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</em>. Required.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeUserFromGroup(
    String groupname, String username, String accountId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/group/user";
    if (groupname != null) {
      request.queryParams.put("groupname", Collections.singleton(String.valueOf(groupname)));
    }
    if (username != null) {
      request.queryParams.put("username", Collections.singleton(String.valueOf(username)));
    }
    if (accountId != null) {
      request.queryParams.put("accountId", Collections.singleton(String.valueOf(accountId)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

}
