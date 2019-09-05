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

import org.everit.atlassian.restclient.jiracloud.v3.model.ContainerForRegisteredWebhooks;
import org.everit.atlassian.restclient.jiracloud.v3.model.ContainerForWebhookIDs;
import org.everit.atlassian.restclient.jiracloud.v3.model.ErrorCollection;
import org.everit.atlassian.restclient.jiracloud.v3.model.PageBeanWebhook;
import org.everit.atlassian.restclient.jiracloud.v3.model.WebhookRegistrationDetails;
import org.everit.atlassian.restclient.jiracloud.v3.model.WebhooksExpirationDate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicWebhookApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<PageBeanWebhook> returnType_getDynamicWebhooksForApp = new TypeReference<PageBeanWebhook>() {};

  private static final TypeReference<WebhooksExpirationDate> returnType_refreshWebhooks = new TypeReference<WebhooksExpirationDate>() {};

  private static final TypeReference<ContainerForRegisteredWebhooks> returnType_registerDynamicWebhooks = new TypeReference<ContainerForRegisteredWebhooks>() {};

  private final RestClient restClient;

  public DynamicWebhookApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Delete webhooks by ID
   * <p>Removes webhooks by ID. Only webhooks registered by the calling Connect app are removed. If webhooks created by other apps are specified, they are ignored.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only <a href=\"https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect\">Connect apps</a> can use this operation.</p> 
   * @param containerForWebhookIDs  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteWebhookById(
    ContainerForWebhookIDs containerForWebhookIDs, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/webhook");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(containerForWebhookIDs));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get dynamic webhooks for app
   * <p>Returns the webhooks registered by the calling app.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only <a href=\"https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect\">Connect apps</a> can use this operation.</p> 
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page.</p>  (optional, default to 100)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanWebhook&gt;
   */
  public Single<PageBeanWebhook> getDynamicWebhooksForApp(
    Optional<Long> startAt, Optional<Integer> maxResults, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/webhook");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (startAt.isPresent()) {
      queryParams.put("startAt", Collections.singleton(String.valueOf(startAt.get())));
    }
    if (maxResults.isPresent()) {
      queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getDynamicWebhooksForApp);
  }

  /**
   * Extend webhook life
   * <p>Webhooks registered through the REST API expire after 30 days. Call this resource periodically to keep them alive.</p> <p>Unrecognized webhook IDs (nonexistent or belonging to other apps) are ignored. <strong><a href=\"#permissions\">Permissions</a> required:</strong> Only <a href=\"https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect\">Connect apps</a> can use this operation.</p> 
   * @param containerForWebhookIDs  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;WebhooksExpirationDate&gt;
   */
  public Single<WebhooksExpirationDate> refreshWebhooks(
    ContainerForWebhookIDs containerForWebhookIDs, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/webhook/refresh");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(containerForWebhookIDs));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_refreshWebhooks);
  }

  /**
   * Register dynamic webhooks
   * <p>Registers webhooks.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Only <a href=\"https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect\">Connect apps</a> can use this operation.</p> 
   * @param webhookRegistrationDetails  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ContainerForRegisteredWebhooks&gt;
   */
  public Single<ContainerForRegisteredWebhooks> registerDynamicWebhooks(
    WebhookRegistrationDetails webhookRegistrationDetails, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/webhook");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(webhookRegistrationDetails));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_registerDynamicWebhooks);
  }

}
