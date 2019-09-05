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

import org.everit.atlassian.restclient.jiracloud.v2.model.BulkIssuePropertyUpdateRequest;
import org.everit.atlassian.restclient.jiracloud.v2.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v2.model.IssueFilterForBulkPropertyDelete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssuePropertyBulkUpdateApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private final RestClient restClient;

  public IssuePropertyBulkUpdateApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Bulk delete issue property
   * <p>Deletes a property value from multiple issues. The issues to be updated can be specified by filter criteria.</p> <p>The criteria the filter used to identify eligible issues are:</p> <ul> <li><code>entityIds</code> Only issues from this list are eligible.</li> <li><code>currentValue</code> Only issues with the property set to this value are eligible.</li> </ul> <p>If both criteria is specified, they are joined with the logical <em>AND</em>: only issues that satisfy both criteria are considered eligible.</p> <p>If no filter criteria are specified, all the issues visible to the user and where the user has the EDIT_ISSUES permission for the issue are considered eligible.</p> <p>This operation is:</p> <ul> <li>transactional, either the property is deleted from all eligible issues or, when errors occur, no properties are deleted.</li> <li><a href=\"#async\">asynchronous</a>. Follow the <code>location</code> link in the response to determine the status of the task and use <a href=\"#api-rest-api-2-task-taskId-get\">Get task</a> to obtain subsequent updates.</li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\"> project permission</a> for each project containing issues.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li><em>Edit issues</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for each issue.</li> </ul> 
   * @param propertyKey <p>The key of the property.</p>  (required)
   * @param issueFilterForBulkPropertyDelete  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable bulkDeleteIssueProperty(
    String propertyKey, IssueFilterForBulkPropertyDelete issueFilterForBulkPropertyDelete, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(issueFilterForBulkPropertyDelete));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Bulk set issue property
   * <p>Sets a property value on multiple issues. The issues to be updated can be specified by a filter.</p> <p>The filter identifies issues eligible for update using these criteria:</p> <ul> <li> <p><code>entityIds</code> Only issues from this list are eligible.</p> </li> <li> <p><code>currentValue</code> Only issues with the property set to this value are eligible.</p> </li> <li> <p><code>hasProperty</code>:</p> <ul> <li>If <em>true</em>, only issues with the property are eligible.</li> <li>If <em>false</em>, only issues without the property are eligible.</li> </ul> </li> </ul> <p>If more than one criteria is specified, they are joined with the logical <em>AND</em>: only issues that satisfy all criteria are eligible.</p> <p>If an invalid combination of criteria is provided, an error is returned. For example, specifying a <code>currentValue</code> and <code>hasProperty</code> as <em>false</em> would not match any issues (because without the property the property cannot have a value).</p> <p>The filter is optional. Without the filter all the issues visible to the user and where the user has the EDIT_ISSUES permission for the issue are considered eligible.</p> <p>This operation is:</p> <ul> <li>transactional, either all eligible issues are updated or, when errors occur, none are updated.</li> <li><a href=\"#async\">asynchronous</a>. Follow the <code>location</code> link in the response to determine the status of the task and use <a href=\"#api-rest-api-2-task-taskId-get\">Get task</a> to obtain subsequent updates.</li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for each project containing issues.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> <li><em>Edit issues</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for each issue.</li> </ul> 
   * @param propertyKey <p>The key of the property. The maximum length is 255 characters.</p>  (required)
   * @param bulkIssuePropertyUpdateRequest  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable bulkSetIssueProperty(
    String propertyKey, BulkIssuePropertyUpdateRequest bulkIssuePropertyUpdateRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/issue/properties/{propertyKey}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("propertyKey", String.valueOf(propertyKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(bulkIssuePropertyUpdateRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

}
