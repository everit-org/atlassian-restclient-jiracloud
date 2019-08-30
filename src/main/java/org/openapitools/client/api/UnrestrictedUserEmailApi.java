package org.openapitools.client.api;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.atlassian.restclient.common.RestCallUtil;
import org.everit.atlassian.restclient.common.RestRequest;
import org.everit.atlassian.restclient.common.RestRequestEnhancer;

import org.everit.http.client.HttpClient;
import org.everit.http.client.HttpMethod;
import org.everit.http.client.HttpRequest;

import org.openapitools.client.model.UnrestrictedUserEmail;

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
