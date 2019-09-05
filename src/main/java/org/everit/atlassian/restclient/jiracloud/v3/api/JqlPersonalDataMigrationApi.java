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

import org.everit.atlassian.restclient.jiracloud.v3.model.ConvertedJQLQueries;
import org.everit.atlassian.restclient.jiracloud.v3.model.JQLPersonalDataMigrationRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JqlPersonalDataMigrationApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<ConvertedJQLQueries> returnType_migrateQueries = new TypeReference<ConvertedJQLQueries>() {};

  private final RestClient restClient;

  public JqlPersonalDataMigrationApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Convert user identifiers to account IDs in JQL queries
   * <p>Converts one or more JQL queries with user identifiers (username or user key) to equivalent JQL queries with account IDs.</p> <p>You may wish to use this operation if your system stores JQL queries and you want to make them GDPR-compliant. For more information about GDPR-related changes, see the <a href=\"https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/\">migration guide</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param jqLPersonalDataMigrationRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ConvertedJQLQueries&gt;
   */
  public Single<ConvertedJQLQueries> migrateQueries(
    JQLPersonalDataMigrationRequest jqLPersonalDataMigrationRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/jql/pdcleaner");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(jqLPersonalDataMigrationRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_migrateQueries);
  }

}
