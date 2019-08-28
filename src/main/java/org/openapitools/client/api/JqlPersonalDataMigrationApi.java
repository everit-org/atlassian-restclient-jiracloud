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

import org.openapitools.client.model.ConvertedJQLQueries;
import org.openapitools.client.model.JQLPersonalDataMigrationRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class JqlPersonalDataMigrationApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<ConvertedJQLQueries> returnType_migrateQueries = new TypeReference<ConvertedJQLQueries>() {};


  private final HttpClient httpClient;

  public JqlPersonalDataMigrationApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Convert user identifiers to account IDs in JQL queries
   * <p>Converts one or more JQL queries with user identifiers (username or user key) to equivalent JQL queries with account IDs.</p> <p>You may wish to use this operation if your system stores JQL queries and you want to make them GDPR-compliant. For more information about GDPR-related changes, see the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">migration guide</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param jqLPersonalDataMigrationRequest  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ConvertedJQLQueries&gt;
   */
  public Single<ConvertedJQLQueries> migrateQueries(
    JQLPersonalDataMigrationRequest jqLPersonalDataMigrationRequest, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/jql/pdcleaner";
      request.requestBody = Optional.ofNullable(jqLPersonalDataMigrationRequest);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_migrateQueries);
  }

}
