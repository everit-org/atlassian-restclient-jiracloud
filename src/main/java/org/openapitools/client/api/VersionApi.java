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

import org.openapitools.client.model.DeleteAndReplaceVersionBean;
import org.openapitools.client.model.Version;
import org.openapitools.client.model.VersionIssueCounts;
import org.openapitools.client.model.VersionMoveBean;
import org.openapitools.client.model.VersionUnresolvedIssuesCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

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
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Version&gt;
   */
  public Single<Version> createVersion(
    Version version, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/version";
      request.requestBody = Optional.ofNullable(version);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createVersion);
  }

  /**
   * Delete and replace version
   * <p>Deletes a project version.</p> <p>Alternative versions can be provided to update issues that use the deleted version in <code>fixVersion</code>, <code>affectedVersion</code>, or any version picker custom fields. If alternatives are not provided, occurrences of <code>fixVersion</code>, <code>affectedVersion</code>, and any version picker custom field, that contain the deleted version, are cleared. Any replacement version must be in the same project as the version being deleted and cannot be the version being deleted.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that contains the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param deleteAndReplaceVersionBean  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteAndReplaceVersion(
    String id, DeleteAndReplaceVersionBean deleteAndReplaceVersionBean, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/version/{id}/removeAndSwap";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
      request.requestBody = Optional.ofNullable(deleteAndReplaceVersionBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_deleteAndReplaceVersion);
  }

  /**
   * Delete version
   * <p>Deletes a project version.</p> <p>Deprecated, use <a href=\"#api-rest-api-3-version-id-removeAndSwap-post\"> Delete and replace version</a> that supports swapping version values in custom fields, in addition to the swapping for <code>fixVersion</code> and <code>affectedVersion</code> provided in this resource.</p> <p>Alternative versions can be provided to update issues that use the deleted version in <code>fixVersion</code> or <code>affectedVersion</code>. If alternatives are not provided, occurrences of <code>fixVersion</code> and <code>affectedVersion</code> that contain the deleted version are cleared.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that contains the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param moveFixIssuesTo <p>The ID of the version to update <code>fixVersion</code> to when the field contains the deleted version. The replacement version must be in the same project as the version being deleted and cannot be the version being deleted.</p>  (optional)
   * @param moveAffectedIssuesTo <p>The ID of the version to update <code>affectedVersion</code> to when the field contains the deleted version. The replacement version must be in the same project as the version being deleted and cannot be the version being deleted.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   * @deprecated
   */
  @Deprecated
  public Completable deleteVersion(
    String id, String moveFixIssuesTo, String moveAffectedIssuesTo, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/version/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    if (moveFixIssuesTo != null) {
      request.queryParams.put("moveFixIssuesTo", Collections.singleton(String.valueOf(moveFixIssuesTo)));
    }
    if (moveAffectedIssuesTo != null) {
      request.queryParams.put("moveAffectedIssuesTo", Collections.singleton(String.valueOf(moveAffectedIssuesTo)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Get version
   * <p>Returns a project version.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project containing the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information about version in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>operations</code> Returns the list of operations available for this version.</li> <li><code>issuesstatus</code> Returns the count of issues in this version for each of the status categories <em>to do</em>, <em>in progress</em>, <em>done</em>, and <em>unmapped</em>. The <em>unmapped</em> property represents the number of issues with a status other than <em>to do</em>, <em>in progress</em>, and <em>done</em>.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Version&gt;
   */
  public Single<Version> getVersion(
    String id, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/version/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getVersion);
  }

  /**
   * Get version's related issues count
   * <p>Returns the following counts for a version:</p> <ul> <li>Number of issues where the <code>fixVersion</code> is set to the version.</li> <li>Number of issues where the <code>affectedVersion</code> is set to the version.</li> <li>Number of issues where a version custom field is set to the version.</li> </ul> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> project permission for the project that contains the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;VersionIssueCounts&gt;
   */
  public Single<VersionIssueCounts> getVersionRelatedIssues(
    String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/version/{id}/relatedIssueCounts";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getVersionRelatedIssues);
  }

  /**
   * Get version's unresolved issues count
   * <p>Returns counts of the issues and unresolved issues for the project version.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> project permission for the project that contains the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;VersionUnresolvedIssuesCount&gt;
   */
  public Single<VersionUnresolvedIssuesCount> getVersionUnresolvedIssues(
    String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/version/{id}/unresolvedIssueCount";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getVersionUnresolvedIssues);
  }

  /**
   * Merge versions
   * <p>Merges two project versions. The merge is completed by deleting the version specified in <code>id</code> and replacing any occurrences of its ID in <code>fixVersion</code> with the version ID specified in <code>moveIssuesTo</code>.</p> <p>Consider using <a href=\"#api-rest-api-3-version-id-removeAndSwap-post\"> Delete and replace version</a> instead. This resource supports swapping version values in <code>fixVersion</code>, <code>affectedVersion</code>, and custom fields.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that contains the version.</p> 
   * @param id <p>The ID of the version to delete.</p>  (required)
   * @param moveIssuesTo <p>The ID of the version to merge into.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> mergeVersions(
    String id, String moveIssuesTo, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/version/{id}/mergeto/{moveIssuesTo}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    if (moveIssuesTo != null) {
      request.pathParams.put("moveIssuesTo", String.valueOf(moveIssuesTo));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_mergeVersions);
  }

  /**
   * Move version
   * <p>Modifies the version's sequence within the project, which affects the display order of the versions in Jira.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> project permission for the project that contains the version.</p> 
   * @param id <p>The ID of the version to be moved.</p>  (required)
   * @param versionMoveBean  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Version&gt;
   */
  public Single<Version> moveVersion(
    String id, VersionMoveBean versionMoveBean, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/version/{id}/move";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
      request.requestBody = Optional.ofNullable(versionMoveBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_moveVersion);
  }

  /**
   * Update version
   * <p>Updates a project version.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a> or <em>Administer Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that contains the version.</p> 
   * @param id <p>The ID of the version.</p>  (required)
   * @param version  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Version&gt;
   */
  public Single<Version> updateVersion(
    String id, Version version, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/version/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
      request.requestBody = Optional.ofNullable(version);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_updateVersion);
  }

}
