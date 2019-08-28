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

import org.openapitools.client.model.Avatar;
import org.openapitools.client.model.IssueTypeBean;
import org.openapitools.client.model.IssueTypeCreateBean;
import org.openapitools.client.model.IssueTypeUpdateBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class IssueTypeApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<IssueTypeBean> returnType_createIssueType = new TypeReference<IssueTypeBean>() {};


  private static final TypeReference<Avatar> returnType_createIssueTypeAvatar = new TypeReference<Avatar>() {};


  private static final TypeReference<List<IssueTypeBean>> returnType_getAlternativeIssueTypes = new TypeReference<List<IssueTypeBean>>() {};


  private static final TypeReference<List<IssueTypeBean>> returnType_getIssueAllTypes = new TypeReference<List<IssueTypeBean>>() {};


  private static final TypeReference<IssueTypeBean> returnType_getIssueType = new TypeReference<IssueTypeBean>() {};


  private static final TypeReference<IssueTypeBean> returnType_updateIssueType = new TypeReference<IssueTypeBean>() {};


  private final HttpClient httpClient;

  public IssueTypeApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Create issue type
   * <p>Creates an issue type and adds it to the default issue type scheme.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param issueTypeCreateBean  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeBean&gt;
   */
  public Single<IssueTypeBean> createIssueType(
    IssueTypeCreateBean issueTypeCreateBean, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype";
      request.requestBody = Optional.ofNullable(issueTypeCreateBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createIssueType);
  }

  /**
   * Load issue type avatar
   * <p>Loads an avatar for the issue type.</p> <p>Specify the avatar's local file location in the body of the request. Also, include the following headers:</p> <ul> <li><code>X-Atlassian-Token: no-check</code> To prevent XSRF protection blocking the request, for more information see <a href=\"#special-request-headers\">Special Headers</a>.</li> <li><code>Content-Type: image/image type</code> Valid image types are JPEG, GIF, or PNG.</li> </ul> <p>For example:<br /> <code>curl --request POST \\ --user email@example.com:&lt;api_token&gt; \\ --header 'X-Atlassian-Token: no-check' \\ --header 'Content-Type: image/&lt; image_type&gt;' \\ --data-binary &quot;&lt;@/path/to/file/with/your/avatar&gt;&quot; \\ --url 'https://your-domain.atlassian.net/rest/api/3/issuetype/{issueTypeId}'This</code></p> <p>The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square's sides is set to the smaller of the height or width of the image.</p> <p>The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.</p> <p>After creating the avatar, use <a href=\"#api-rest-api-3-issuetype-id-put\"> Update issue type</a> to set it as the issue type's displayed avatar.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the issue type.</p>  (required)
   * @param body  (required)
   * @param x <p>The X coordinate of the top-left corner of the crop region.</p>  (optional, default to 0)
   * @param y <p>The Y coordinate of the top-left corner of the crop region.</p>  (optional, default to 0)
   * @param size <p>The length of each side of the crop region.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Avatar&gt;
   */
  public Single<Avatar> createIssueTypeAvatar(
    String id, Object body, Integer x, Integer y, Integer size, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype/{id}/avatar2";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    if (x != null) {
      request.queryParams.put("x", Collections.singleton(String.valueOf(x)));
    }
    if (y != null) {
      request.queryParams.put("y", Collections.singleton(String.valueOf(y)));
    }
    if (size != null) {
      request.queryParams.put("size", Collections.singleton(String.valueOf(size)));
    }
      request.requestBody = Optional.ofNullable(body);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createIssueTypeAvatar);
  }

  /**
   * Delete issue type
   * <p>Deletes the issue type. If the issue type is in use, all uses are updated with the alternative issue type (<code>alternativeIssueTypeId</code>). A list of alternative issue types are obtained from the <a href=\"#api-rest-api-3-issuetype-id-alternatives-get\">Get alternative issue types</a> resource.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the issue type.</p>  (required)
   * @param alternativeIssueTypeId <p>The ID of the replacement issue type.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteIssueType(
    String id, String alternativeIssueTypeId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    if (alternativeIssueTypeId != null) {
      request.queryParams.put("alternativeIssueTypeId", Collections.singleton(String.valueOf(alternativeIssueTypeId)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Get alternative issue types
   * <p>Returns a list of issue types that can be used to replace the issue type. The alternative issue types are those assigned to the same workflow scheme, field configuration scheme, and screen scheme.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param id <p>The ID of the issue type.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;IssueTypeBean&gt;&gt;
   */
  public Single<List<IssueTypeBean>> getAlternativeIssueTypes(
    String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype/{id}/alternatives";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAlternativeIssueTypes);
  }

  /**
   * Get all issue types for user
   * <p>Returns all issue types.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Issue types are only returned as follows:</p> <ul> <li>if the user has the <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, all issue types are returned.</li> <li>if the user has the <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for one or more projects, the issue types associated with the projects the user has permission to browse are returned.</li> </ul> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;IssueTypeBean&gt;&gt;
   */
  public Single<List<IssueTypeBean>> getIssueAllTypes(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueAllTypes);
  }

  /**
   * Get issue type
   * <p>Returns an issue type.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> in a project the issue type is associated with or <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the issue type.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeBean&gt;
   */
  public Single<IssueTypeBean> getIssueType(
    String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueType);
  }

  /**
   * Update issue type
   * <p>Updates the issue type.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the issue type.</p>  (required)
   * @param issueTypeUpdateBean  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeBean&gt;
   */
  public Single<IssueTypeBean> updateIssueType(
    String id, IssueTypeUpdateBean issueTypeUpdateBean, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/issuetype/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
      request.requestBody = Optional.ofNullable(issueTypeUpdateBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_updateIssueType);
  }

}
