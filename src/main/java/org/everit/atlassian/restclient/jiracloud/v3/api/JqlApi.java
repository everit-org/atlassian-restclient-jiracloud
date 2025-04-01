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

import org.everit.atlassian.restclient.jiracloud.v3.model.AutoCompleteSuggestions;
import org.everit.atlassian.restclient.jiracloud.v3.model.ConvertedJQLQueries;
import org.everit.atlassian.restclient.jiracloud.v3.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v3.model.JQLPersonalDataMigrationRequest;
import org.everit.atlassian.restclient.jiracloud.v3.model.JQLReferenceData;
import org.everit.atlassian.restclient.jiracloud.v3.model.JqlQueriesToParse;
import org.everit.atlassian.restclient.jiracloud.v3.model.JqlQueriesToSanitize;
import org.everit.atlassian.restclient.jiracloud.v3.model.ParsedJqlQueries;
import org.everit.atlassian.restclient.jiracloud.v3.model.SanitizedJqlQueries;
import org.everit.atlassian.restclient.jiracloud.v3.model.SearchAutoCompleteFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JqlApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<JQLReferenceData> returnType_getAutoComplete = new TypeReference<JQLReferenceData>() {};

  private static final TypeReference<JQLReferenceData> returnType_getAutoCompletePost = new TypeReference<JQLReferenceData>() {};

  private static final TypeReference<AutoCompleteSuggestions> returnType_getFieldAutoCompleteForQueryString = new TypeReference<AutoCompleteSuggestions>() {};

  private static final TypeReference<ConvertedJQLQueries> returnType_migrateQueries = new TypeReference<ConvertedJQLQueries>() {};

  private static final TypeReference<ParsedJqlQueries> returnType_parseJqlQueries = new TypeReference<ParsedJqlQueries>() {};

  private static final TypeReference<SanitizedJqlQueries> returnType_sanitiseJqlQueries = new TypeReference<SanitizedJqlQueries>() {};

  private final RestClient restClient;

  public JqlApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get field reference data (GET)
   * Returns reference data for JQL searches. This is a downloadable version of the documentation provided in [Advanced searching - fields reference](https://confluence.atlassian.com/x/gwORLQ) and [Advanced searching - functions reference](https://confluence.atlassian.com/x/hgORLQ), along with a list of JQL-reserved words. Use this information to assist with the programmatic creation of JQL queries or the validation of queries built in a custom query builder.  To filter visible field details by project or collapse non-unique fields by field type then [Get field reference data (POST)](#api-rest-api-3-jql-autocompletedata-post) can be used.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;JQLReferenceData&gt;
   */
  public Single<JQLReferenceData> getAutoComplete(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/jql/autocompletedata");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAutoComplete);
  }

  /**
   * Get field reference data (POST)
   * Returns reference data for JQL searches. This is a downloadable version of the documentation provided in [Advanced searching - fields reference](https://confluence.atlassian.com/x/gwORLQ) and [Advanced searching - functions reference](https://confluence.atlassian.com/x/hgORLQ), along with a list of JQL-reserved words. Use this information to assist with the programmatic creation of JQL queries or the validation of queries built in a custom query builder.  This operation can filter the custom fields returned by project. Invalid project IDs in `projectIds` are ignored. System fields are always returned.  It can also return the collapsed field for custom fields. Collapsed fields enable searches to be performed across all fields with the same name and of the same field type. For example, the collapsed field `Component - Component[Dropdown]` enables dropdown fields `Component - cf[10061]` and `Component - cf[10062]` to be searched simultaneously.  **[Permissions](#permissions) required:** None.
   * @param searchAutoCompleteFilter  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;JQLReferenceData&gt;
   */
  public Single<JQLReferenceData> getAutoCompletePost(
    SearchAutoCompleteFilter searchAutoCompleteFilter, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/jql/autocompletedata");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(searchAutoCompleteFilter));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAutoCompletePost);
  }

  /**
   * Get field auto complete suggestions
   * Returns the JQL search auto complete suggestions for a field.  Suggestions can be obtained by providing:   *  `fieldName` to get a list of all values for the field.  *  `fieldName` and `fieldValue` to get a list of values containing the text in `fieldValue`.  *  `fieldName` and `predicateName` to get a list of all predicate values for the field.  *  `fieldName`, `predicateName`, and `predicateValue` to get a list of predicate values containing the text in `predicateValue`.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
   * @param fieldName The name of the field. (optional)
   * @param fieldValue The partial field item name entered by the user. (optional)
   * @param predicateName The name of the [ CHANGED operator predicate](https://confluence.atlassian.com/x/hQORLQ#Advancedsearching-operatorsreference-CHANGEDCHANGED) for which the suggestions are generated. The valid predicate operators are *by*, *from*, and *to*. (optional)
   * @param predicateValue The partial predicate item name entered by the user. (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;AutoCompleteSuggestions&gt;
   */
  public Single<AutoCompleteSuggestions> getFieldAutoCompleteForQueryString(
    Optional<String> fieldName, Optional<String> fieldValue, Optional<String> predicateName, Optional<String> predicateValue, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/jql/autocompletedata/suggestions");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (fieldName.isPresent()) {
      queryParams.put("fieldName", Collections.singleton(String.valueOf(fieldName.get())));
    }
    if (fieldValue.isPresent()) {
      queryParams.put("fieldValue", Collections.singleton(String.valueOf(fieldValue.get())));
    }
    if (predicateName.isPresent()) {
      queryParams.put("predicateName", Collections.singleton(String.valueOf(predicateName.get())));
    }
    if (predicateValue.isPresent()) {
      queryParams.put("predicateValue", Collections.singleton(String.valueOf(predicateValue.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getFieldAutoCompleteForQueryString);
  }

  /**
   * Convert user identifiers to account IDs in JQL queries
   * Converts one or more JQL queries with user identifiers (username or user key) to equivalent JQL queries with account IDs.  You may wish to use this operation if your system stores JQL queries and you want to make them GDPR-compliant. For more information about GDPR-related changes, see the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/).  **[Permissions](#permissions) required:** Permission to access Jira.
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

  /**
   * Parse JQL query
   * Parses and validates JQL queries.  Validation is performed in context of the current user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
   * @param validation How to validate the JQL query and treat the validation results. Validation options include:   *  `strict` Returns all errors. If validation fails, the query structure is not returned.  *  `warn` Returns all errors. If validation fails but the JQL query is correctly formed, the query structure is returned.  *  `none` No validation is performed. If JQL query is correctly formed, the query structure is returned. (required)
   * @param jqlQueriesToParse  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ParsedJqlQueries&gt;
   */
  public Single<ParsedJqlQueries> parseJqlQueries(
    String validation, JqlQueriesToParse jqlQueriesToParse, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/jql/parse");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    queryParams.put("validation", Collections.singleton(String.valueOf(validation)));
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(jqlQueriesToParse));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_parseJqlQueries);
  }

  /**
   * Sanitize JQL queries
   * Sanitizes one or more JQL queries by converting readable details into IDs where a user doesn't have permission to view the entity.  For example, if the query contains the clause *project = 'Secret project'*, and a user does not have browse permission for the project \"Secret project\", the sanitized query replaces the clause with *project = 12345\"* (where 12345 is the ID of the project). If a user has the required permission, the clause is not sanitized. If the account ID is null, sanitizing is performed for an anonymous user.  Note that sanitization doesn't make the queries GDPR-compliant, because it doesn't remove user identifiers (username or user key). If you need to make queries GDPR-compliant, use [Convert user identifiers to account IDs in JQL queries](https://developer.atlassian.com/cloud/jira/platform/rest/v3/api-group-jql/#api-rest-api-3-jql-sanitize-post).  Before sanitization each JQL query is parsed. The queries are returned in the same order that they were passed.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param jqlQueriesToSanitize  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SanitizedJqlQueries&gt;
   */
  public Single<SanitizedJqlQueries> sanitiseJqlQueries(
    JqlQueriesToSanitize jqlQueriesToSanitize, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/jql/sanitize");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(jqlQueriesToSanitize));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_sanitiseJqlQueries);
  }

}
