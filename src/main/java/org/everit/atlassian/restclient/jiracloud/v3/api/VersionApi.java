package org.everit.atlassian.restclient.jiracloud.v3.api;

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

import org.everit.atlassian.restclient.jiracloud.v3.model.DeleteAndReplaceVersionBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.Version;
import org.everit.atlassian.restclient.jiracloud.v3.model.VersionIssueCounts;
import org.everit.atlassian.restclient.jiracloud.v3.model.VersionMoveBean;
import org.everit.atlassian.restclient.jiracloud.v3.model.VersionUnresolvedIssuesCount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VersionApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<Version> returnType_createVersion = new TypeReference<Version>() {};

  private static final TypeReference<Object> returnType_deleteAndReplaceVersion = new TypeReference<Object>() {};

  private static final TypeReference<Version> returnType_getVersion = new TypeReference<Version>() {};

  private static final TypeReference<VersionIssueCounts> returnType_getVersionRelatedIssues = new TypeReference<VersionIssueCounts>() {};

  private static final TypeReference<VersionUnresolvedIssuesCount> returnType_getVersionUnresolvedIssues = new TypeReference<VersionUnresolvedIssuesCount>() {};

  private static final TypeReference<Object> returnType_mergeVersions = new TypeReference<Object>() {};

  private static final TypeReference<Version> returnType_moveVersion = new TypeReference<Version>() {};

  private static final TypeReference<Version> returnType_updateVersion = new TypeReference<Version>() {};

  private final HttpClient httpClient;

  public VersionApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Create version
   * <p>Creates a project version.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project the version is added to.</p> 
   * @param version  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Version&gt;
   */
  public Single<Version> createVersion(
    Version version, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/version");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(version));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_createVersion);
  }

  /**
   * Delete and replace version
   * <p>Deletes a project version.</p> <p>Alternative versions can be provided to update issues that use the deleted version in <code>fixVersion</code>, <code>affectedVersion</code>, or any version picker custom fields. If alternatives are not provided, occurrences of <code>fixVersion</code>, <code>affectedVersion</code>, and any version picker custom field, that contain the deleted version, are cleared. Any replacement version must be in the same project as the version being deleted and cannot be the version being deleted.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that contains the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param deleteAndReplaceVersionBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteAndReplaceVersion(
    String id, DeleteAndReplaceVersionBean deleteAndReplaceVersionBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/version/{id}/removeAndSwap");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(deleteAndReplaceVersionBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_deleteAndReplaceVersion);
  }

  /**
   * Delete version
   * <p>Deletes a project version.</p> <p>Deprecated, use <a href=\"#api-rest-api-3-version-id-removeAndSwap-post\"> Delete and replace version</a> that supports swapping version values in custom fields, in addition to the swapping for <code>fixVersion</code> and <code>affectedVersion</code> provided in this resource.</p> <p>Alternative versions can be provided to update issues that use the deleted version in <code>fixVersion</code> or <code>affectedVersion</code>. If alternatives are not provided, occurrences of <code>fixVersion</code> and <code>affectedVersion</code> that contain the deleted version are cleared.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that contains the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param moveFixIssuesTo <p>The ID of the version to update <code>fixVersion</code> to when the field contains the deleted version. The replacement version must be in the same project as the version being deleted and cannot be the version being deleted.</p>  (optional)
   * @param moveAffectedIssuesTo <p>The ID of the version to update <code>affectedVersion</code> to when the field contains the deleted version. The replacement version must be in the same project as the version being deleted and cannot be the version being deleted.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   * @deprecated
   */
  @Deprecated
  public Completable deleteVersion(
    String id, Optional<String> moveFixIssuesTo, Optional<String> moveAffectedIssuesTo, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.DELETE)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/version/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (moveFixIssuesTo.isPresent()) {
      queryParams.put("moveFixIssuesTo", Collections.singleton(String.valueOf(moveFixIssuesTo.get())));
    }
    if (moveAffectedIssuesTo.isPresent()) {
      queryParams.put("moveAffectedIssuesTo", Collections.singleton(String.valueOf(moveAffectedIssuesTo.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer);
  }

  /**
   * Get version
   * <p>Returns a project version.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about version in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>operations</code> Returns the list of operations available for this version.</li> <li><code>issuesstatus</code> Returns the count of issues in this version for each of the status categories <em>to do</em>, <em>in progress</em>, <em>done</em>, and <em>unmapped</em>. The <em>unmapped</em> property represents the number of issues with a status other than <em>to do</em>, <em>in progress</em>, and <em>done</em>.</li> </ul>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Version&gt;
   */
  public Single<Version> getVersion(
    String id, Optional<String> expand, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/version/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (expand.isPresent()) {
      queryParams.put("expand", Collections.singleton(String.valueOf(expand.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getVersion);
  }

  /**
   * Get version's related issues count
   * <p>Returns the following counts for a version:</p> <ul> <li>Number of issues where the <code>fixVersion</code> is set to the version.</li> <li>Number of issues where the <code>affectedVersion</code> is set to the version.</li> <li>Number of issues where a version custom field is set to the version.</li> </ul> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> project permission for the project that contains the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;VersionIssueCounts&gt;
   */
  public Single<VersionIssueCounts> getVersionRelatedIssues(
    String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/version/{id}/relatedIssueCounts");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getVersionRelatedIssues);
  }

  /**
   * Get version's unresolved issues count
   * <p>Returns counts of the issues and unresolved issues for the project version.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> project permission for the project that contains the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;VersionUnresolvedIssuesCount&gt;
   */
  public Single<VersionUnresolvedIssuesCount> getVersionUnresolvedIssues(
    String id, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/version/{id}/unresolvedIssueCount");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getVersionUnresolvedIssues);
  }

  /**
   * Merge versions
   * <p>Merges two project versions. The merge is completed by deleting the version specified in <code>id</code> and replacing any occurrences of its ID in <code>fixVersion</code> with the version ID specified in <code>moveIssuesTo</code>.</p> <p>Consider using <a href=\"#api-rest-api-3-version-id-removeAndSwap-post\"> Delete and replace version</a> instead. This resource supports swapping version values in <code>fixVersion</code>, <code>affectedVersion</code>, and custom fields.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that contains the version.</p> 
   * @param id <p>The ID of the version to delete.</p>  (required)
   * @param moveIssuesTo <p>The ID of the version to merge into.</p>  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> mergeVersions(
    String id, String moveIssuesTo, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/version/{id}/mergeto/{moveIssuesTo}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    pathParams.put("moveIssuesTo", String.valueOf(moveIssuesTo));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_mergeVersions);
  }

  /**
   * Move version
   * <p>Modifies the version's sequence within the project, which affects the display order of the versions in Jira.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> project permission for the project that contains the version.</p> 
   * @param id <p>The ID of the version to be moved.</p>  (required)
   * @param versionMoveBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Version&gt;
   */
  public Single<Version> moveVersion(
    String id, VersionMoveBean versionMoveBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.POST)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/version/{id}/move");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(versionMoveBean));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_moveVersion);
  }

  /**
   * Update version
   * <p>Updates a project version.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that contains the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param version  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Version&gt;
   */
  public Single<Version> updateVersion(
    String id, Version version, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/version/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(version));

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_updateVersion);
  }

}
