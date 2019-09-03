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

import org.everit.atlassian.restclient.jiracloud.v3.model.EntityProperty;
import org.everit.atlassian.restclient.jiracloud.v3.model.PropertyKeys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentPropertyApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<EntityProperty> returnType_getCommentProperty = new TypeReference<EntityProperty>() {};

  private static final TypeReference<PropertyKeys> returnType_getCommentPropertyKeys = new TypeReference<PropertyKeys>() {};

  private static final TypeReference<Object> returnType_setCommentProperty = new TypeReference<Object>() {};

  private final HttpClient httpClient;

  public CommentPropertyApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Delete comment property
   * <p>Deletes a comment property.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> either of:</p> <ul> <li><em>Edit All Comments</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> to delete a property from any comment.</li> <li><em>Edit Own Comments</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> to delete a property from a comment created by the user.</li> </ul> <p>Also, when the visibility of a comment is restricted to a role or group the user must be a member of that role or group.</p> 
   * @param commentId <p>The ID of the comment.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteCommentProperty(
    String commentId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/comment/{commentId}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("commentId", String.valueOf(commentId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get comment property
   * <p>Returns the value of a comment property.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param commentId <p>The ID of the comment.</p>  (required)
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;EntityProperty&gt;
   */
  public Single<EntityProperty> getCommentProperty(
    String commentId, String propertyKey, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/comment/{commentId}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("commentId", String.valueOf(commentId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getCommentProperty);
  }

  /**
   * Get comment property keys
   * <p>Returns the keys of all the properties of a comment.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li>If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.</li> </ul> 
   * @param commentId <p>The ID of the comment.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PropertyKeys&gt;
   */
  public Single<PropertyKeys> getCommentPropertyKeys(
    String commentId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/comment/{commentId}/properties");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("commentId", String.valueOf(commentId));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getCommentPropertyKeys);
  }

  /**
   * Set comment property
   * <p>Creates or updates the value of a property for a comment. Use this resource to store custom data against a comment.</p> <p>The value of the request body must be a <a href=\"http://tools.ietf.org/html/rfc4627\">valid</a>, non-empty JSON blob. The maximum length is 32768 characters.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> either of:</p> <ul> <li><em>Edit All Comments</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> to create or update the value of a property on any comment.</li> <li><em>Edit Own Comments</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> to create or update the value of a property on a comment created by the user.</li> </ul> <p>Also, when the visibility of a comment is restricted to a role or group the user must be a member of that role or group.</p> 
   * @param commentId <p>The ID of the comment.</p>  (required)
   * @param propertyKey <p>The key of the property. The maximum length is 255 characters.</p>  (required)
   * @param body  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setCommentProperty(
    String commentId, String propertyKey, Object body, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/comment/{commentId}/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("commentId", String.valueOf(commentId));
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(body));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_setCommentProperty);
  }

}
