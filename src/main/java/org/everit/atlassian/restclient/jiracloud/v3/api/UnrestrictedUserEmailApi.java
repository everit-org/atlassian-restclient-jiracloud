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

import org.everit.atlassian.restclient.jiracloud.v3.model.UnrestrictedUserEmail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnrestrictedUserEmailApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<UnrestrictedUserEmail> returnType_getUserEmail = new TypeReference<UnrestrictedUserEmail>() {};

  private static final TypeReference<UnrestrictedUserEmail> returnType_getUserEmailBulk = new TypeReference<UnrestrictedUserEmail>() {};

  private final HttpClient httpClient;

  public UnrestrictedUserEmailApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get user email
   * <p>Returns a user's email address. This API is only available to apps approved by Atlassian, according to these <a href=\"https://community.developer.atlassian.com/t/guidelines-for-requesting-access-to-email-address/27603\">guidelines</a>.</p> 
   * @param accountId <p>The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, <code>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</code>. Note, this should be treated as an opaque identifier (i.e. do not assume any structure in the value). Required.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;UnrestrictedUserEmail&gt;
   */
  public Single<UnrestrictedUserEmail> getUserEmail(
    Optional<String> accountId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/email");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", Collections.singleton(String.valueOf(accountId.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getUserEmail);
  }

  /**
   * Get user email bulk
   * <p>Returns a user's email address. This API is only available to apps approved by Atlassian, according to these <a href=\"https://community.developer.atlassian.com/t/guidelines-for-requesting-access-to-email-address/27603\">guidelines</a>.</p> 
   * @param accountId <p>the account IDs of the users for which emails are required. An <code>accountId</code> is an identifier that uniquely identifies the user across all Atlassian products. For example, <code>384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192</code>. Note, this should be treated as an opaque identifier (i.e. do not assume any structure in the value).</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;UnrestrictedUserEmail&gt;
   */
  public Single<UnrestrictedUserEmail> getUserEmailBulk(
    Optional<List<String>> accountId, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/user/email/bulk");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (accountId.isPresent()) {
      queryParams.put("accountId", RestCallUtil.objectCollectionToStringCollection(accountId.get()));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getUserEmailBulk);
  }

}
