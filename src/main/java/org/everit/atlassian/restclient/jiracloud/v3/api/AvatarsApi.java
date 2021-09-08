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
import org.everit.atlassian.restclient.jiracloud.v3.model.SystemAvatars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvatarsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<SystemAvatars> returnType_getAllSystemAvatars = new TypeReference<SystemAvatars>() {};

  private static final TypeReference<Avatars> returnType_getAvatars = new TypeReference<Avatars>() {};

  private static final TypeReference<Avatar> returnType_storeAvatar = new TypeReference<Avatar>() {};

  private final RestClient restClient;

  public AvatarsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Delete avatar
   * Deletes an avatar from a project or issue type.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param type The avatar type. (required)
   * @param owningObjectId The ID of the item the avatar is associated with. (required)
   * @param id The ID of the avatar. (required)
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
   * Get system avatars by type
   * Returns a list of system avatar details by owner type, where the owner types are issue type, project, or user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
   * @param type The avatar type. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SystemAvatars&gt;
   */
  public Single<SystemAvatars> getAllSystemAvatars(
    String type, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/avatar/{type}/system");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("type", String.valueOf(type));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAllSystemAvatars);
  }

  /**
   * Get avatars
   * Returns the system and custom avatars for a project or issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  for custom project avatars, *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project the avatar belongs to.  *  for custom issue type avatars, *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for at least one project the issue type is used in.  *  for system avatars, none.
   * @param type The avatar type. (required)
   * @param entityId The ID of the item the avatar is associated with. (required)
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
   * Loads a custom avatar for a project or issue type.  Specify the avatar's local file location in the body of the request. Also, include the following headers:   *  `X-Atlassian-Token: no-check` To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  `Content-Type: image/image type` Valid image types are JPEG, GIF, or PNG.  For example:   `curl --request POST `  `--user email@example.com:<api_token> `  `--header 'X-Atlassian-Token: no-check' `  `--header 'Content-Type: image/< image_type>' `  `--data-binary \"<@/path/to/file/with/your/avatar>\" `  `--url 'https://your-domain.atlassian.net/rest/api/3/universal_avatar/type/{type}/owner/{entityId}'`  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square's sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar use:   *  [Update issue type](#api-rest-api-3-issuetype-id-put) to set it as the issue type's displayed avatar.  *  [Set project avatar](#api-rest-api-3-project-projectIdOrKey-avatar-put) to set it as the project's displayed avatar.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param type The avatar type. (required)
   * @param entityId The ID of the item the avatar is associated with. (required)
   * @param size The length of each side of the crop region. (required)
   * @param body  (required)
   * @param x The X coordinate of the top-left corner of the crop region. (optional, default to 0)
   * @param y The Y coordinate of the top-left corner of the crop region. (optional, default to 0)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Avatar&gt;
   */
  public Single<Avatar> storeAvatar(
    String type, String entityId, Integer size, Object body, Optional<Integer> x, Optional<Integer> y, Optional<RestRequestEnhancer> restRequestEnhancer) {

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
    queryParams.put("size", Collections.singleton(String.valueOf(size)));
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(body));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_storeAvatar);
  }

}
