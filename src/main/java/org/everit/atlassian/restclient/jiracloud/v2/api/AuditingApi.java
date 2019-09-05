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

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.jiracloud.v2.model.AuditRecords;
import java.time.OffsetDateTime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuditingApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<AuditRecords> returnType_getAuditRecords = new TypeReference<AuditRecords>() {};

  private final RestClient restClient;

  public AuditingApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get audit records
   * <p>Returns a list of audit records. The list can be filtered to include items:</p> <ul> <li>containing a string in at least one field. For example, providing <em>up</em> will return all audit records where one or more fields contains words such as <em>update</em>.</li> <li>created on or after a date and time.</li> <li>created or or before a date and time.</li> <li>created during a time period.</li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param offset <p>The number of records to skip before returning the first result.</p>  (optional, default to 0)
   * @param limit <p>The maximum number of results to return. The maximum is <code>1000</code>.</p>  (optional, default to 1000)
   * @param filter <p>The query string.</p>  (optional)
   * @param from <p>The date and time on or after which returned audit records must have been created. If <code>to</code> is provided <code>from</code> must be before <code>to</code> or no audit records are returned.</p>  (optional)
   * @param to <p>The date and time on or before which returned audit results must have been created. If <code>from</code> is provided <code>to</code> must be after <code>from</code> or no audit records are returned.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;AuditRecords&gt;
   */
  public Single<AuditRecords> getAuditRecords(
    Optional<Integer> offset, Optional<Integer> limit, Optional<String> filter, Optional<OffsetDateTime> from, Optional<OffsetDateTime> to, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/auditing/record");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (offset.isPresent()) {
      queryParams.put("offset", Collections.singleton(String.valueOf(offset.get())));
    }
    if (limit.isPresent()) {
      queryParams.put("limit", Collections.singleton(String.valueOf(limit.get())));
    }
    if (filter.isPresent()) {
      queryParams.put("filter", Collections.singleton(String.valueOf(filter.get())));
    }
    if (from.isPresent()) {
      queryParams.put("from", Collections.singleton(String.valueOf(from.get())));
    }
    if (to.isPresent()) {
      queryParams.put("to", Collections.singleton(String.valueOf(to.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAuditRecords);
  }

}
