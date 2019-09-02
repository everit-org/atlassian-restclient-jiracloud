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

import org.everit.atlassian.restclient.jiracloud.v2.model.Avatar;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeCreateBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueTypeUpdateBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeBean&gt;
   */
  public Single<IssueTypeBean> createIssueType(
    IssueTypeCreateBean issueTypeCreateBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetype");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeCreateBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_createIssueType);
  }

  /**
   * Load issue type avatar
   * <p>Loads an avatar for the issue type.</p> <p>Specify the avatar's local file location in the body of the request. Also, include the following headers:</p> <ul> <li><code>X-Atlassian-Token: no-check</code> To prevent XSRF protection blocking the request, for more information see <a href=\"#special-request-headers\">Special Headers</a>.</li> <li><code>Content-Type: image/image type</code> Valid image types are JPEG, GIF, or PNG.</li> </ul> <p>For example:<br /> <code>curl --request POST \\ --user email@example.com:&lt;api_token&gt; \\ --header 'X-Atlassian-Token: no-check' \\ --header 'Content-Type: image/&lt; image_type&gt;' \\ --data-binary &quot;&lt;@/path/to/file/with/your/avatar&gt;&quot; \\ --url 'https://your-domain.atlassian.net/rest/api/2/issuetype/{issueTypeId}'This</code></p> <p>The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square's sides is set to the smaller of the height or width of the image.</p> <p>The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.</p> <p>After creating the avatar, use <a href=\"#api-rest-api-2-issuetype-id-put\"> Update issue type</a> to set it as the issue type's displayed avatar.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the issue type.</p>  (required)
   * @param body  (required)
   * @param x <p>The X coordinate of the top-left corner of the crop region.</p>  (optional, default to 0)
   * @param y <p>The Y coordinate of the top-left corner of the crop region.</p>  (optional, default to 0)
   * @param size <p>The length of each side of the crop region.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Avatar&gt;
   */
  public Single<Avatar> createIssueTypeAvatar(
    String id, Object body, Optional<Integer> x, Optional<Integer> y, Optional<Integer> size, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetype/{id}/avatar2");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (x.isPresent()) {
      queryParams.put("x", Collections.singleton(String.valueOf(x.get())));
    }
    if (y.isPresent()) {
      queryParams.put("y", Collections.singleton(String.valueOf(y.get())));
    }
    if (size.isPresent()) {
      queryParams.put("size", Collections.singleton(String.valueOf(size.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(body));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_createIssueTypeAvatar);
  }

  /**
   * Delete issue type
   * <p>Deletes the issue type. If the issue type is in use, all uses are updated with the alternative issue type (<code>alternativeIssueTypeId</code>). A list of alternative issue types are obtained from the <a href=\"#api-rest-api-2-issuetype-id-alternatives-get\">Get alternative issue types</a> resource.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the issue type.</p>  (required)
   * @param alternativeIssueTypeId <p>The ID of the replacement issue type.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteIssueType(
    String id, Optional<String> alternativeIssueTypeId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetype/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (alternativeIssueTypeId.isPresent()) {
      queryParams.put("alternativeIssueTypeId", Collections.singleton(String.valueOf(alternativeIssueTypeId.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get alternative issue types
   * <p>Returns a list of issue types that can be used to replace the issue type. The alternative issue types are those assigned to the same workflow scheme, field configuration scheme, and screen scheme.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param id <p>The ID of the issue type.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;IssueTypeBean&gt;&gt;
   */
  public Single<List<IssueTypeBean>> getAlternativeIssueTypes(
    String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetype/{id}/alternatives");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAlternativeIssueTypes);
  }

  /**
   * Get all issue types for user
   * <p>Returns all issue types.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Issue types are only returned as follows:</p> <ul> <li>if the user has the <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>, all issue types are returned.</li> <li>if the user has the <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for one or more projects, the issue types associated with the projects the user has permission to browse are returned.</li> </ul> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;IssueTypeBean&gt;&gt;
   */
  public Single<List<IssueTypeBean>> getIssueAllTypes(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetype");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getIssueAllTypes);
  }

  /**
   * Get issue type
   * <p>Returns an issue type.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> in a project the issue type is associated with or <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the issue type.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeBean&gt;
   */
  public Single<IssueTypeBean> getIssueType(
    String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetype/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getIssueType);
  }

  /**
   * Update issue type
   * <p>Updates the issue type.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The ID of the issue type.</p>  (required)
   * @param issueTypeUpdateBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueTypeBean&gt;
   */
  public Single<IssueTypeBean> updateIssueType(
    String id, IssueTypeUpdateBean issueTypeUpdateBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issuetype/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueTypeUpdateBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_updateIssueType);
  }

}
