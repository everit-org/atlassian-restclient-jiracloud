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

import org.everit.atlassian.restclient.jiracloud.v2.model.FieldAssociationsRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueCustomFieldAssociationsApi {

  private static final String DEFAULT_BASE_PATH = "https://your-domain.atlassian.net";

  private static final TypeReference<Object> returnType_createAssociations = new TypeReference<Object>() {};

  private static final TypeReference<Object> returnType_removeAssociations = new TypeReference<Object>() {};

  private final RestClient restClient;

  public IssueCustomFieldAssociationsApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Create associations
   * Associates fields with projects.  Fields will be associated with each issue type on the requested projects.  Fields will be associated with all projects that share the same field configuration which the provided projects are using. This means that while the field will be associated with the requested projects, it will also be associated with any other projects that share the same field configuration.  If a success response is returned it means that the field association has been created in any applicable contexts where it wasn't already present.  Up to 50 fields and up to 100 projects can be associated in a single request. If more fields or projects are provided a 400 response will be returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldAssociationsRequest Payload containing the fields to associate and the projects to associate them to. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> createAssociations(
    FieldAssociationsRequest fieldAssociationsRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/association");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(fieldAssociationsRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_createAssociations);
  }

  /**
   * Remove associations
   * Unassociates a set of fields with a project and issue type context.  Fields will be unassociated with all projects/issue types that share the same field configuration which the provided project and issue types are using. This means that while the field will be unassociated with the provided project and issue types, it will also be unassociated with any other projects and issue types that share the same field configuration.  If a success response is returned it means that the field association has been removed in any applicable contexts where it was present.  Up to 50 fields and up to 100 projects and issue types can be unassociated in a single request. If more fields or projects are provided a 400 response will be returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
   * @param fieldAssociationsRequest Payload containing the fields to uassociate and the projects and issue types to unassociate them to. (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> removeAssociations(
    FieldAssociationsRequest fieldAssociationsRequest, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/2/field/association");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(fieldAssociationsRequest));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_removeAssociations);
  }

}
