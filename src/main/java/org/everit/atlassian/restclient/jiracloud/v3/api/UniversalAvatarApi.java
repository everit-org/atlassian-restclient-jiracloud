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

import org.everit.atlassian.restclient.jiracloud.v3.model.Avatar;
import org.everit.atlassian.restclient.jiracloud.v3.model.Avatars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversalAvatarApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<Avatars> returnType_getAvatars = new TypeReference<Avatars>() {};

  private static final TypeReference<Avatar> returnType_storeAvatar = new TypeReference<Avatar>() {};

  private final RestClient restClient;

  public UniversalAvatarApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Delete avatar
   * <p>Deletes an avatar from a project or issue type.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param type <p>The type of the entity. Valid values are <code>project</code> and <code>issuetype</code>.</p>  (required)
   * @param owningObjectId <p>The ID of the entity item.</p>  (required)
   * @param id <p>The ID of the avatar.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteAvatar(
    String type, String owningObjectId, Long id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/universal_avatar/type/{type}/owner/{owningObjectId}/avatar/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("type", String.valueOf(type));
    pathParams.put("owningObjectId", String.valueOf(owningObjectId));
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get avatars
   * <p>Returns the system and custom avatars for a project or issue type.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param type <p>The type of the entity. Valid values are <code>project</code> and <code>issuetype</code>.</p>  (required)
   * @param entityId <p>The ID of the entity item.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Avatars&gt;
   */
  public Single<Avatars> getAvatars(
    String type, String entityId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/universal_avatar/type/{type}/owner/{entityId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("type", String.valueOf(type));
    pathParams.put("entityId", String.valueOf(entityId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAvatars);
  }

  /**
   * Load avatar
   * <p>Loads a custom avatar for a project or issue type.</p> <p>Specify the avatar's local file location in the body of the request. Also, include the following headers:</p> <ul> <li><code>X-Atlassian-Token: no-check</code> To prevent XSRF protection blocking the request, for more information see <a href=\"#special-request-headers\">Special Headers</a>.</li> <li><code>Content-Type: image/image type</code> Valid image types are JPEG, GIF, or PNG.</li> </ul> <p>For example:<br /> <code>curl --request POST </code></p> <p><code>--user email@example.com:&lt;api_token&gt; </code></p> <p><code>--header 'X-Atlassian-Token: no-check' </code></p> <p><code>--header 'Content-Type: image/&lt; image_type&gt;' </code></p> <p><code>--data-binary &quot;&lt;@/path/to/file/with/your/avatar&gt;&quot; </code></p> <p><code>--url 'https://your-domain.atlassian.net/rest/api/3/universal_avatar/type/{type}/owner/{entityId}'</code></p> <p>The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square's sides is set to the smaller of the height or width of the image.</p> <p>The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.</p> <p>After creating the avatar use:</p> <ul> <li><a href=\"#api-rest-api-3-issuetype-id-put\">Update issue type</a> to set it as the issue type's displayed avatar.</li> <li><a href=\"#api-rest-api-3-project-projectIdOrKey-avatar-put\">Set project avatar</a> to set it as the project's displayed avatar.</li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param type <p>The type of the entity. Valid values are <code>project</code> and <code>issuetype</code>.</p>  (required)
   * @param entityId <p>The ID of the entity item.</p>  (required)
   * @param body  (required)
   * @param x <p>The X coordinate of the top-left corner of the crop region.</p>  (optional, default to 0)
   * @param y <p>The Y coordinate of the top-left corner of the crop region.</p>  (optional, default to 0)
   * @param size <p>The length of each side of the crop region.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Avatar&gt;
   */
  public Single<Avatar> storeAvatar(
    String type, String entityId, Object body, Optional<Integer> x, Optional<Integer> y, Optional<Integer> size, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/universal_avatar/type/{type}/owner/{entityId}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("type", String.valueOf(type));
    pathParams.put("entityId", String.valueOf(entityId));
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

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_storeAvatar);
  }

}
