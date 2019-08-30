package org.everit.atlassian.restclient.jiracloud.v3.api;

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

import org.everit.atlassian.restclient.jiracloud.v3.model.ModelConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<ModelConfiguration> returnType_getConfiguration = new TypeReference<ModelConfiguration>() {};

  private final HttpClient httpClient;

  public ConfigurationApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get global settings
   * <p>Returns the <a href=\"https://confluence.atlassian.com/x/qYXKM\">global settings</a> in Jira. These settings determine whether optional features (for example, subtasks, time tracking, and others) are enabled. If time tracking is enabled, this operation also returns the time tracking configuration.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ModelConfiguration&gt;
   */
  public Single<ModelConfiguration> getConfiguration(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/configuration");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getConfiguration);
  }

}
