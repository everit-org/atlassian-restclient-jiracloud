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

import org.openapitools.client.model.IdBean;
import org.openapitools.client.model.PermissionScheme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class ProjectPermissionSchemeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<PermissionScheme> returnType_assignPermissionScheme = new TypeReference<PermissionScheme>() {};


  private static final TypeReference<PermissionScheme> returnType_getAssignedPermissionScheme = new TypeReference<PermissionScheme>() {};


  private final HttpClient httpClient;

  public ProjectPermissionSchemeApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Assign permission scheme
   * <p>Assigns a permission scheme with a project. See <a href=\"https://confluence.atlassian.com/x/yodKLg\">Managing project permissions</a> for more information about permission schemes.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a></p> 
   * @param projectKeyOrId <p>The project ID or project key (case sensitive).</p>  (required)
   * @param idBean  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that permissions are included when you specify any value:</p> <ul> <li><code>all</code> Returns all expandable information.</li> <li><code>field</code> Returns information about the custom field granted the permission.</li> <li><code>group</code> Returns information about the group that is granted the permission.</li> <li><code>permissions</code> Returns all permission grants for each permission scheme.</li> <li><code>projectRole</code> Returns information about the project role granted the permission.</li> <li><code>user</code> Returns information about the user who is granted the permission.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PermissionScheme&gt;
   */
  public Single<PermissionScheme> assignPermissionScheme(
    String projectKeyOrId, IdBean idBean, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectKeyOrId}/permissionscheme";
    if (projectKeyOrId != null) {
      request.pathParams.put("projectKeyOrId", String.valueOf(projectKeyOrId));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
      request.requestBody = Optional.ofNullable(idBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_assignPermissionScheme);
  }

  /**
   * Get assigned permission scheme
   * <p>Gets the <a href=\"https://confluence.atlassian.com/x/yodKLg\">permission scheme</a> associated with the project.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a>.</p> 
   * @param projectKeyOrId <p>The project ID or project key (case sensitive).</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that permissions are included when you specify any value:</p> <ul> <li><code>all</code> Returns all expandable information.</li> <li><code>field</code> Returns information about the custom field granted the permission.</li> <li><code>group</code> Returns information about the group that is granted the permission.</li> <li><code>permissions</code> Returns all permission grants for each permission scheme.</li> <li><code>projectRole</code> Returns information about the project role granted the permission.</li> <li><code>user</code> Returns information about the user who is granted the permission.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PermissionScheme&gt;
   */
  public Single<PermissionScheme> getAssignedPermissionScheme(
    String projectKeyOrId, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectKeyOrId}/permissionscheme";
    if (projectKeyOrId != null) {
      request.pathParams.put("projectKeyOrId", String.valueOf(projectKeyOrId));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAssignedPermissionScheme);
  }

}
