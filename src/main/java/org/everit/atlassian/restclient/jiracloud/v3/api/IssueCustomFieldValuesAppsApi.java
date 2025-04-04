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

import org.everit.atlassian.restclient.jiracloud.v3.model.CustomFieldValueUpdateDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.MultipleCustomFieldValuesUpdateDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueCustomFieldValuesAppsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_updateCustomFieldValue = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_updateMultipleCustomFieldValues = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueCustomFieldValuesAppsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Update custom field value
   * Updates the value of a custom field on one or more issues.  Apps can only perform this operation on [custom fields](https://developer.atlassian.com/platform/forge/manifest-reference/modules/jira-custom-field/) and [custom field types](https://developer.atlassian.com/platform/forge/manifest-reference/modules/jira-custom-field-type/) declared in their own manifests.  **[Permissions](#permissions) required:** Only the app that owns the custom field or custom field type can update its values with this operation.  The new `write:app-data:jira` OAuth scope is 100% optional now, and not using it won't break your app. However, we recommend adding it to your app's scope list because we will eventually make it mandatory.
   * @param fieldIdOrKey The ID or key of the custom field. For example, `customfield_10010`. (required)
   * @param customFieldValueUpdateDetails  (required)
   * @param generateChangelog Whether to generate a changelog for this update. (optional, default to true)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateCustomFieldValue(
    String fieldIdOrKey, CustomFieldValueUpdateDetails customFieldValueUpdateDetails, Optional<Boolean> generateChangelog, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/app/field/{fieldIdOrKey}/value");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("fieldIdOrKey", String.valueOf(fieldIdOrKey));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (generateChangelog.isPresent()) {
      queryParams.put("generateChangelog", Collections.singleton(String.valueOf(generateChangelog.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(customFieldValueUpdateDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateCustomFieldValue);
  }

  /**
   * Update custom fields
   * Updates the value of one or more custom fields on one or more issues. Combinations of custom field and issue should be unique within the request.  Apps can only perform this operation on [custom fields](https://developer.atlassian.com/platform/forge/manifest-reference/modules/jira-custom-field/) and [custom field types](https://developer.atlassian.com/platform/forge/manifest-reference/modules/jira-custom-field-type/) declared in their own manifests.  **[Permissions](#permissions) required:** Only the app that owns the custom field or custom field type can update its values with this operation.  The new `write:app-data:jira` OAuth scope is 100% optional now, and not using it won't break your app. However, we recommend adding it to your app's scope list because we will eventually make it mandatory.
   * @param multipleCustomFieldValuesUpdateDetails  (required)
   * @param generateChangelog Whether to generate a changelog for this update. (optional, default to true)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateMultipleCustomFieldValues(
    MultipleCustomFieldValuesUpdateDetails multipleCustomFieldValuesUpdateDetails, Optional<Boolean> generateChangelog, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/app/field/value");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (generateChangelog.isPresent()) {
      queryParams.put("generateChangelog", Collections.singleton(String.valueOf(generateChangelog.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(multipleCustomFieldValuesUpdateDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_updateMultipleCustomFieldValues);
  }

}
