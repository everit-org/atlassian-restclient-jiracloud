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

import org.everit.atlassian.restclient.jiracloud.v2.model.SearchRequestBean;
import org.everit.atlassian.restclient.jiracloud.v2.model.SearchResults;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<SearchResults> returnType_searchForIssuesUsingJql = new TypeReference<SearchResults>() {};

  private static final TypeReference<SearchResults> returnType_searchForIssuesUsingJql_0 = new TypeReference<SearchResults>() {};

  private final HttpClient httpClient;

  public SearchApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Search for issues using JQL (GET)
   * <p>Searches for issues using <a href=\"https://confluence.atlassian.com/x/egORLQ\">JQL</a>.</p> <p>If the JQL query expression is too large to be encoded as a query parameter, use the <a href=\"#api-rest-api-2-search-post\">POST</a> version of this resource.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Issues are included in the response where the user has:</p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the issue.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param jql <p>The <a href=\"https://confluence.atlassian.com/x/egORLQ\">JQL</a> that defines the search. Note:</p> <ul> <li>If no JQL expression is provided, all issues are returned.</li> <li><code>username</code> and <code>userkey</code> cannot be used as search terms due to privacy reasons. Use <code>accountId</code> instead.</li> <li>If a user has hidden their email address in their user profile, partial matches of the email address will not find the user. An exact match is required.</li> </ul>  (optional)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0)
   * @param maxResults <p>The maximum number of items to return per page. To manage page size, Jira may return fewer items per page where a large number of fields are requested. The greatest number of items returned per page is achieved when requesting <code>id</code> or <code>key</code> only.</p>  (optional, default to 50)
   * @param validateQuery <p>Determines how to validate the JQL query and treat the validation results. Supported values are:</p> <ul> <li><code>strict</code> Returns a 400 response code if any errors are found, along with a list of all errors (and warnings).</li> <li><code>warn</code> Returns all errors as warnings.</li> <li><code>none</code> No validation is performed.</li> <li><code>true</code> <em>Deprecated</em> A legacy synonym for <code>strict</code>.</li> <li><code>false</code> <em>Deprecated</em> A legacy synonym for <code>warn</code>.</li> </ul> <p>Note: If the JQL is not correctly formed a 400 response code is returned, regardless of the <code>validateQuery</code> value.</p>  (optional, default to strict)
   * @param fields <p>A comma-separated list of fields to return for each issue, use it to retrieve a subset of fields. Allowed values:</p> <ul> <li><code>*all</code> Returns all fields.</li> <li><code>*navigable</code> Returns navigable fields.</li> <li>Any issue field, prefixed with a minus to exclude.</li> </ul> <p>Examples:</p> <ul> <li><code>summary,comment</code> Returns only the summary and comments fields.</li> <li><code>-description</code> Returns all navigable (default) fields except description.</li> <li><code>*all,-comment</code> Returns all fields except comments.</li> </ul> <p>This parameter may be specified multiple times. For example, <code>fields=field1,field2&amp;fields=field3</code>.</p> <p>Note: All navigable fields are returned by default. This differs from <a href=\"#api-rest-api-2-issue-issueIdOrKey-get\">GET issue</a> where the default is all fields.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about issues in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>renderedFields</code> Returns field values rendered in HTML format.</li> <li><code>names</code> Returns the display name of each field.</li> <li><code>schema</code> Returns the schema describing a field type.</li> <li><code>transitions</code> Returns all possible transitions for the issue.</li> <li><code>operations</code> Returns all possible operations for the issue.</li> <li><code>editmeta</code> Returns information about how each field can be edited.</li> <li><code>changelog</code> Returns a list of recent updates to an issue, sorted by date, starting from the most recent.</li> <li><code>versionedRepresentations</code> Instead of <code>fields</code>, returns <code>versionedRepresentations</code> a JSON array containing each version of a field's value, with the highest numbered item representing the most recent version.</li> </ul>  (optional)
   * @param properties <p>A comma-separated list of issue property keys for issue properties to include in the results. This parameter may be specified multiple times. For example, <code>properties=prop1,prop2&amp;properties=prop3</code>. A maximum of 5 issue property keys can be specified.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param fieldsByKeys <p>Reference fields by their key (rather than ID).</p>  (optional, default to false)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SearchResults&gt;
   */
  public Single<SearchResults> searchForIssuesUsingJql(
    Optional<String> jql, Optional<Integer> startAt, Optional<Integer> maxResults, Optional<String> validateQuery, Optional<List<String>> fields, Optional<String> expand, Optional<List<String>> properties, Optional<Boolean> fieldsByKeys, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (jql.isPresent()) {
      queryParams.put("jql", Collections.singleton(String.valueOf(jql.get())));
    }
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    if (validateQuery.isPresent()) {
      queryParams.put("validateQuery", Collections.singleton(String.valueOf(validateQuery.get())));
    }
    if (fields.isPresent()) {
      queryParams.put("fields", RestCallUtil.objectCollectionToStringCollection(fields.get()));
    }
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    if (properties.isPresent()) {
      queryParams.put("properties", RestCallUtil.objectCollectionToStringCollection(properties.get()));
    }
    if (fieldsByKeys.isPresent()) {
      queryParams.put("fieldsByKeys", Collections.singleton(String.valueOf(fieldsByKeys.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_searchForIssuesUsingJql);
  }

  /**
   * Search for issues using JQL (POST)
   * <p>Searches for issues using <a href=\"https://confluence.atlassian.com/x/egORLQ\">JQL</a>.</p> <p>There is a <a href=\"#api-rest-api-2-search-get\">GET</a> version of this resource that can be used for smaller JQL query expressions.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Issues are included in the response where the user has:</p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the issue.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param searchRequestBean <p>A JSON object containing the search request.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;SearchResults&gt;
   */
  public Single<SearchResults> searchForIssuesUsingJql_0(
    SearchRequestBean searchRequestBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/search");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(searchRequestBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_searchForIssuesUsingJql_0);
  }

}
