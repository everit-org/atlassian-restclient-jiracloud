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

import org.everit.atlassian.restclient.jiracloud.v2.model.CustomFieldOption;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomFieldOptionApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<CustomFieldOption> returnType_getCustomFieldOption = new TypeReference<CustomFieldOption>() {};

  private final HttpClient httpClient;

  public CustomFieldOptionApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get custom field option
   * <p>Returns a custom field option. For example, an option in a cascading select list.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param id <p>The ID of the custom field option. To find this ID, <a href=\"https://confluence.atlassian.com/x/B4hKLg\"> configure the custom field</a> and edit its options in Jira. Click the option and its ID will show in the URL as the <code>selectedParentOptionId</code> parameter.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CustomFieldOption&gt;
   */
  public Single<CustomFieldOption> getCustomFieldOption(
    String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/customFieldOption/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getCustomFieldOption);
  }

}
