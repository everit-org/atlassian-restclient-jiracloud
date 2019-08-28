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

import org.openapitools.client.model.PermissionGrant;
import org.openapitools.client.model.PermissionGrants;
import org.openapitools.client.model.PermissionScheme;
import org.openapitools.client.model.PermissionSchemes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class PermissionSchemeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<PermissionGrant> returnType_createPermissionGrant = new TypeReference<PermissionGrant>() {};


  private static final TypeReference<PermissionScheme> returnType_createPermissionScheme = new TypeReference<PermissionScheme>() {};


  private static final TypeReference<PermissionSchemes> returnType_getAllPermissionSchemes = new TypeReference<PermissionSchemes>() {};


  private static final TypeReference<PermissionScheme> returnType_getPermissionScheme = new TypeReference<PermissionScheme>() {};


  private static final TypeReference<PermissionGrant> returnType_getPermissionSchemeGrant = new TypeReference<PermissionGrant>() {};


  private static final TypeReference<PermissionGrants> returnType_getPermissionSchemeGrants = new TypeReference<PermissionGrants>() {};


  private static final TypeReference<PermissionScheme> returnType_updatePermissionScheme = new TypeReference<PermissionScheme>() {};


  private final HttpClient httpClient;

  public PermissionSchemeApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Create permission grant
   * <p>Creates a permission grant in a permission scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param schemeId <p>The ID of the permission scheme in which to create a new permission grant.</p>  (required)
   * @param permissionGrant <p>The permission grant to create.</p>  (required)
   * @param expand <p>Use expand to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that permissions are always included when you specify any value:</p> <ul> <li><code>permissions</code> Returns all permission grants for each permission scheme.</li> <li><code>user</code> Returns information about the user who is granted the permission.</li> <li><code>group</code> Returns information about the group that is granted the permission.</li> <li><code>projectRole</code> Returns information about the project role granted the permission.</li> <li><code>field</code> Returns information about the custom field granted the permission.</li> <li><code>all</code> Returns all expandable information.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PermissionGrant&gt;
   */
  public Single<PermissionGrant> createPermissionGrant(
    Long schemeId, PermissionGrant permissionGrant, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/permissionscheme/{schemeId}/permission";
    if (schemeId != null) {
      request.pathParams.put("schemeId", String.valueOf(schemeId));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
      request.requestBody = Optional.ofNullable(permissionGrant);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createPermissionGrant);
  }

  /**
   * Create permission scheme
   * <p>Creates a new permission scheme. You can create a permission scheme with or without defining a set of permission grants.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param requestBody <p>The permission scheme to create.</p>  (required)
   * @param expand <p>Use expand to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that permissions are always included when you specify any value:</p> <ul> <li><code>all</code> Returns all expandable information.</li> <li><code>field</code> Returns information about the custom field granted the permission.</li> <li><code>group</code> Returns information about the group that is granted the permission.</li> <li><code>permissions</code> Returns all permission grants for each permission scheme.</li> <li><code>projectRole</code> Returns information about the project role granted the permission.</li> <li><code>user</code> Returns information about the user who is granted the permission.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PermissionScheme&gt;
   */
  public Single<PermissionScheme> createPermissionScheme(
    PermissionScheme requestBody, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/permissionscheme";
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createPermissionScheme);
  }

  /**
   * Delete permission scheme
   * <p>Deletes a permission scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param schemeId <p>The ID of the permission scheme being deleted.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deletePermissionScheme(
    Long schemeId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/permissionscheme/{schemeId}";
    if (schemeId != null) {
      request.pathParams.put("schemeId", String.valueOf(schemeId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Delete permission scheme grant
   * <p>Deletes a permission grant from a permission scheme. See <a href=\"#about-permission-schemes\">About permission schemes and grants</a> for more details.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param schemeId <p>The ID of the permission scheme to delete the permission grant from.</p>  (required)
   * @param permissionId <p>The ID of the permission grant to delete.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deletePermissionSchemeEntity(
    Long schemeId, Long permissionId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/permissionscheme/{schemeId}/permission/{permissionId}";
    if (schemeId != null) {
      request.pathParams.put("schemeId", String.valueOf(schemeId));
    }
    if (permissionId != null) {
      request.pathParams.put("permissionId", String.valueOf(permissionId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Get all permission schemes
   * <p>Returns all permission schemes.</p> <h3>About permission schemes and grants</h3> <p>A permission scheme is a collection of permission grants. A permission grant consists of a <code>holder</code> and a <code>permission</code>.</p> <h4>Holder</h4> <p>The <code>holder</code> object contains information about the user or group being granted the permission. For example, the <em>Administer projects</em> permission is granted to a group named <em>Teams in space administrators</em>. In this case, the type is <code>&quot;type&quot;: &quot;group&quot;</code>, and the parameter is the group name, <code>&quot;parameter&quot;: &quot;Teams in space administrators&quot;</code>. The <code>holder</code> object is defined by the following properties:</p> <ul> <li><code>type</code> Identifies the user or group (see the list of types below).</li> <li><code>parameter</code> The value of this property depends on the <code>type</code>. For example, if the <code>type</code> is a group, then you need to specify the group name.</li> </ul> <p>The following <code>types</code> are available. The expected values for the <code>parameter</code> are given in parenthesis (some <code>types</code> may not have a <code>parameter</code>):</p> <ul> <li><code>anyone</code> Grant for anonymous users.</li> <li><code>applicationRole</code> Grant for users with access to the specified application (application name). See <a href=\"https://confluence.atlassian.com/cloud/manage-application-access-744721629.html\">Manage application access</a> for more information.</li> <li><code>assignee</code> Grant for the user currently assigned to an issue.</li> <li><code>group</code> Grant for the specified group (group name).</li> <li><code>groupCustomField</code> Grant for a user in the group selected in the specified custom field (custom field ID).</li> <li><code>projectLead</code> Grant for a project lead.</li> <li><code>projectRole</code> Grant for the specified project role (project role ID).</li> <li><code>reporter</code> Grant for the user who reported the issue.</li> <li><code>sd.customer.portal.only</code> Jira Service Desk only. Grants customers permission to access the customer portal but not Jira. See <a href=\"https://confluence.atlassian.com/x/24dKLg\">Customizing Jira Service Desk permissions</a> for more information.</li> <li><code>user</code> Grant for the specified user (user ID - historically this was the userkey but that is deprecated and the account ID should be used).</li> <li><code>userCustomField</code> Grant for a user selected in the specified custom field (custom field ID).</li> </ul> <h4>Permissions</h4> <p>The <a href=\"https://confluence.atlassian.com/x/yodKLg\">built-in Jira permissions</a> are listed below. Apps can also define custom permissions. See the <a href=\"https://developer.atlassian.com/cloud/jira/platform/modules/project-permission/\">project permission</a> and <a href=\"https://developer.atlassian.com/cloud/jira/platform/modules/global-permission/\">global permission</a> module documentation for more information.</p> <p><strong>Project permissions</strong></p> <ul> <li><code>ADMINISTER_PROJECTS</code></li> <li><code>BROWSE_PROJECTS</code></li> <li><code>MANAGE_SPRINTS_PERMISSION</code> (Jira Software only)</li> <li><code>SERVICEDESK_AGENT</code> (Jira Service Desk only)</li> <li><code>VIEW_DEV_TOOLS</code> (Jira Software only)</li> <li><code>VIEW_READONLY_WORKFLOW</code></li> </ul> <p><strong>Issue permissions</strong></p> <ul> <li><code>ASSIGNABLE_USER</code></li> <li><code>ASSIGN_ISSUES</code></li> <li><code>CLOSE_ISSUES</code></li> <li><code>CREATE_ISSUES</code></li> <li><code>DELETE_ISSUES</code></li> <li><code>EDIT_ISSUES</code></li> <li><code>LINK_ISSUES</code></li> <li><code>MODIFY_REPORTER</code></li> <li><code>MOVE_ISSUES</code></li> <li><code>RESOLVE_ISSUES</code></li> <li><code>SCHEDULE_ISSUES</code></li> <li><code>SET_ISSUE_SECURITY</code></li> <li><code>TRANSITION_ISSUES</code></li> </ul> <p><strong>Voters and watchers permissions</strong></p> <ul> <li><code>MANAGE_WATCHERS</code></li> <li><code>VIEW_VOTERS_AND_WATCHERS</code></li> </ul> <p><strong>Comments permissions</strong></p> <ul> <li><code>ADD_COMMENTS</code></li> <li><code>DELETE_ALL_COMMENTS</code></li> <li><code>DELETE_OWN_COMMENTS</code></li> <li><code>EDIT_ALL_COMMENTS</code></li> <li><code>EDIT_OWN_COMMENTS</code></li> </ul> <p><strong>Attachments permissions</strong></p> <ul> <li><code>CREATE_ATTACHMENTS</code></li> <li><code>DELETE_ALL_ATTACHMENTS</code></li> <li><code>DELETE_OWN_ATTACHMENTS</code></li> </ul> <p><strong>Time tracking permissions</strong></p> <ul> <li><code>DELETE_ALL_WORKLOGS</code></li> <li><code>DELETE_OWN_WORKLOGS</code></li> <li><code>EDIT_ALL_WORKLOGS</code></li> <li><code>EDIT_OWN_WORKLOGS</code></li> <li><code>WORK_ON_ISSUES</code></li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param expand <p>Use expand to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that permissions are included when you specify any value:</p> <ul> <li><code>all</code> Returns all expandable information.</li> <li><code>field</code> Returns information about the custom field granted the permission.</li> <li><code>group</code> Returns information about the group that is granted the permission.</li> <li><code>permissions</code> Returns all permission grants for each permission scheme.</li> <li><code>projectRole</code> Returns information about the project role granted the permission.</li> <li><code>user</code> Returns information about the user who is granted the permission.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PermissionSchemes&gt;
   */
  public Single<PermissionSchemes> getAllPermissionSchemes(
    String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/permissionscheme";
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllPermissionSchemes);
  }

  /**
   * Get permission scheme
   * <p>Returns a permission scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param schemeId <p>The ID of the permission scheme to return.</p>  (required)
   * @param expand <p>Use expand to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that permissions are included when you specify any value:</p> <ul> <li><code>all</code> Returns all expandable information.</li> <li><code>field</code> Returns information about the custom field granted the permission.</li> <li><code>group</code> Returns information about the group that is granted the permission.</li> <li><code>permissions</code> Returns all permission grants for each permission scheme.</li> <li><code>projectRole</code> Returns information about the project role granted the permission.</li> <li><code>user</code> Returns information about the user who is granted the permission.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PermissionScheme&gt;
   */
  public Single<PermissionScheme> getPermissionScheme(
    Long schemeId, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/permissionscheme/{schemeId}";
    if (schemeId != null) {
      request.pathParams.put("schemeId", String.valueOf(schemeId));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getPermissionScheme);
  }

  /**
   * Get permission scheme grant
   * <p>Returns a permission grant.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param schemeId <p>The ID of the permission scheme.</p>  (required)
   * @param permissionId <p>The ID of the permission grant.</p>  (required)
   * @param expand <p>Use expand to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that permissions are always included when you specify any value:</p> <ul> <li><code>all</code> Returns all expandable information.</li> <li><code>field</code> Returns information about the custom field granted the permission.</li> <li><code>group</code> Returns information about the group that is granted the permission.</li> <li><code>permissions</code> Returns all permission grants for each permission scheme.</li> <li><code>projectRole</code> Returns information about the project role granted the permission.</li> <li><code>user</code> Returns information about the user who is granted the permission.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PermissionGrant&gt;
   */
  public Single<PermissionGrant> getPermissionSchemeGrant(
    Long schemeId, Long permissionId, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/permissionscheme/{schemeId}/permission/{permissionId}";
    if (schemeId != null) {
      request.pathParams.put("schemeId", String.valueOf(schemeId));
    }
    if (permissionId != null) {
      request.pathParams.put("permissionId", String.valueOf(permissionId));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getPermissionSchemeGrant);
  }

  /**
   * Get permission scheme grants
   * <p>Returns all permission grants for a permission scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param schemeId <p>The ID of the permission scheme.</p>  (required)
   * @param expand <p>Use expand to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that permissions are always included when you specify any value:</p> <ul> <li><code>permissions</code> Returns all permission grants for each permission scheme.</li> <li><code>user</code> Returns information about the user who is granted the permission.</li> <li><code>group</code> Returns information about the group that is granted the permission.</li> <li><code>projectRole</code> Returns information about the project role granted the permission.</li> <li><code>field</code> Returns information about the custom field granted the permission.</li> <li><code>all</code> Returns all expandable information.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PermissionGrants&gt;
   */
  public Single<PermissionGrants> getPermissionSchemeGrants(
    Long schemeId, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/permissionscheme/{schemeId}/permission";
    if (schemeId != null) {
      request.pathParams.put("schemeId", String.valueOf(schemeId));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getPermissionSchemeGrants);
  }

  /**
   * Update permission scheme
   * <p>Updates a permission scheme. Below are some important things to note when using this resource:</p> <ul> <li>If a permissions list is present in the request, then it is set in the permission scheme, overwriting <em>all existing</em> grants.</li> <li>If you want to update only the name and description, then do not send a permissions list in the request.</li> <li>Sending an empty list will remove all permission grants from the permission scheme.</li> </ul> <p>If you want to add or delete a permission grant instead of updating the whole list, see <a href=\"#api-rest-api-3-permissionscheme-schemeId-permission-post\">Create permission grant</a> or <a href=\"#api-rest-api-3-permissionscheme-schemeId-permission-permissionId-delete\">Delete permission scheme entity</a>.</p> <p>See <a href=\"#about-permission-schemes\">About permission schemes and grants</a> for more details.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param schemeId <p>The ID of the permission scheme to update.</p>  (required)
   * @param requestBody  (required)
   * @param expand <p>Use expand to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that permissions are always included when you specify any value:</p> <ul> <li><code>all</code> Returns all expandable information.</li> <li><code>field</code> Returns information about the custom field granted the permission.</li> <li><code>group</code> Returns information about the group that is granted the permission.</li> <li><code>permissions</code> Returns all permission grants for each permission scheme.</li> <li><code>projectRole</code> Returns information about the project role granted the permission.</li> <li><code>user</code> Returns information about the user who is granted the permission.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PermissionScheme&gt;
   */
  public Single<PermissionScheme> updatePermissionScheme(
    Long schemeId, PermissionScheme requestBody, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/permissionscheme/{schemeId}";
    if (schemeId != null) {
      request.pathParams.put("schemeId", String.valueOf(schemeId));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_updatePermissionScheme);
  }

}
