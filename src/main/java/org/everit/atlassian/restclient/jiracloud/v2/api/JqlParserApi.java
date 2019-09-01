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

import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.JqlQueriesToParse;
import org.everit.atlassian.restclient.jiracloud.v2.model.ParsedJqlQueries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JqlParserApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<ParsedJqlQueries> returnType_parseJqlQueries = new TypeReference<ParsedJqlQueries>() {};

  private final HttpClient httpClient;

  public JqlParserApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Parse JQL query
   * <p>Parses and validates JQL queries.</p> <p>Validation is performed in context of the current user.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param jqlQueriesToParse  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ParsedJqlQueries&gt;
   */
  public Single<ParsedJqlQueries> parseJqlQueries(
    JqlQueriesToParse jqlQueriesToParse, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/jql/parse");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(jqlQueriesToParse));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_parseJqlQueries);
  }

}
