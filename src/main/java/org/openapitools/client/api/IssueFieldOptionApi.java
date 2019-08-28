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

import org.openapitools.client.model.IssueFieldOption;
import org.openapitools.client.model.IssueFieldOptionCreateBean;
import org.openapitools.client.model.PageBeanIssueFieldOption;
import org.openapitools.client.model.TaskProgressBeanRemoveOptionFromIssuesResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class IssueFieldOptionApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<IssueFieldOption> returnType_createIssueFieldOption = new TypeReference<IssueFieldOption>() {};


  private static final TypeReference<Object> returnType_deleteIssueFieldOption = new TypeReference<Object>() {};


  private static final TypeReference<PageBeanIssueFieldOption> returnType_getAllIssueFieldOptions = new TypeReference<PageBeanIssueFieldOption>() {};


  private static final TypeReference<IssueFieldOption> returnType_getIssueFieldOption = new TypeReference<IssueFieldOption>() {};


  private static final TypeReference<PageBeanIssueFieldOption> returnType_getSelectableIssueFieldOptions = new TypeReference<PageBeanIssueFieldOption>() {};


  private static final TypeReference<PageBeanIssueFieldOption> returnType_getVisibleIssueFieldOptions = new TypeReference<PageBeanIssueFieldOption>() {};


  private static final TypeReference<IssueFieldOption> returnType_updateIssueFieldOption = new TypeReference<IssueFieldOption>() {};


  private final HttpClient httpClient;

  public IssueFieldOptionApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Create issue field option
   * <p>Creates an option for a select list issue field.</p> <p>Note that this operation <strong>cannot be used with the built-in custom fields</strong>. It only works with issue fields added by Connect apps, as described above.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Jira permissions are not required for the app providing the field.</p> 
   * @param fieldKey <p>The field key is specified in the following format: <strong>$(app-key)\\_\\_$(field-key)</strong>. For example, <em>example-add-on\\_\\_example-issue-field</em>.</p>  (required)
   * @param requestBody  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueFieldOption&gt;
   */
  public Single<IssueFieldOption> createIssueFieldOption(
    String fieldKey, IssueFieldOptionCreateBean requestBody, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/field/{fieldKey}/option";
    if (fieldKey != null) {
      request.pathParams.put("fieldKey", String.valueOf(fieldKey));
    }
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createIssueFieldOption);
  }

  /**
   * Delete issue field option
   * <p>Deletes an option from a select list issue field.</p> <p>Note that this operation <strong>cannot be used with the built-in custom fields</strong>. It only works with issue fields added by Connect apps, as described above.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Jira permissions are not required for the app providing the field.</p> 
   * @param fieldKey <p>The field key is specified in the following format: <strong>$(app-key)\\_\\_$(field-key)</strong>. For example, <em>example-add-on\\_\\_example-issue-field</em>.</p>  (required)
   * @param optionId <p>The ID of the option to be deleted.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> deleteIssueFieldOption(
    String fieldKey, Long optionId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/field/{fieldKey}/option/{optionId}";
    if (fieldKey != null) {
      request.pathParams.put("fieldKey", String.valueOf(fieldKey));
    }
    if (optionId != null) {
      request.pathParams.put("optionId", String.valueOf(optionId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_deleteIssueFieldOption);
  }

  /**
   * Get all issue field options
   * <p>Returns all options defined for a select list issue field. A select list issue field is a type of <a href=\"https://developer.atlassian.com/cloud/jira/platform/modules/issue-field/\">issue field</a> that allows a user to select n value from a list of options.</p> <p>Note that this operation <strong>cannot be used with the built-in custom fields</strong>. It only works with issue fields added by Connect apps, as described above.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Jira permissions are not required for the app providing the field.</p> 
   * @param fieldKey <p>The field key is specified in the following format: <strong>$(app-key)\\_\\_$(field-key)</strong>. For example, <em>example-add-on\\_\\_example-issue-field</em>.</p>  (required)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>100</code>.</p>  (optional, default to 50)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueFieldOption&gt;
   */
  public Single<PageBeanIssueFieldOption> getAllIssueFieldOptions(
    String fieldKey, Long startAt, Integer maxResults, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/field/{fieldKey}/option";
    if (fieldKey != null) {
      request.pathParams.put("fieldKey", String.valueOf(fieldKey));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllIssueFieldOptions);
  }

  /**
   * Get issue field option
   * <p>Returns an option from a select list issue field.</p> <p>Note that this operation <strong>cannot be used with the built-in custom fields</strong>. It only works with issue fields added by Connect apps, as described above.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Jira permissions are not required for the app providing the field.</p> 
   * @param fieldKey <p>The field key is specified in the following format: <strong>$(app-key)\\_\\_$(field-key)</strong>. For example, <em>example-add-on\\_\\_example-issue-field</em>.</p>  (required)
   * @param optionId <p>The ID of the option to be returned.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueFieldOption&gt;
   */
  public Single<IssueFieldOption> getIssueFieldOption(
    String fieldKey, Long optionId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/field/{fieldKey}/option/{optionId}";
    if (fieldKey != null) {
      request.pathParams.put("fieldKey", String.valueOf(fieldKey));
    }
    if (optionId != null) {
      request.pathParams.put("optionId", String.valueOf(optionId));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueFieldOption);
  }

  /**
   * Get selectable issue field options
   * <p>Returns options defined for a select list issue field that can be viewed and selected by the user.</p> <p>Note that this operation <strong>cannot be used with the built-in custom fields</strong>. It only works with issue fields added by Connect apps, as described above.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param fieldKey <p>The field key is specified in the following format: <strong>$(app-key)\\_\\_$(field-key)</strong>. For example, <em>example-add-on\\_\\_example-issue-field</em>.</p>  (required)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>100</code>.</p>  (optional, default to 50)
   * @param projectId <p>Filters the results to options that are only available in the specified project.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueFieldOption&gt;
   */
  public Single<PageBeanIssueFieldOption> getSelectableIssueFieldOptions(
    String fieldKey, Long startAt, Integer maxResults, Long projectId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/field/{fieldKey}/option/suggestions/edit";
    if (fieldKey != null) {
      request.pathParams.put("fieldKey", String.valueOf(fieldKey));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (projectId != null) {
      request.queryParams.put("projectId", Collections.singleton(String.valueOf(projectId)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getSelectableIssueFieldOptions);
  }

  /**
   * Get visible issue field options
   * <p>Returns options defined for a select list issue field that can be viewed by the user.</p> <p>Note that this operation <strong>cannot be used with the built-in custom fields</strong>. It only works with issue fields added by Connect apps, as described above.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param fieldKey <p>The field key is specified in the following format: <strong>$(app-key)\\_\\_$(field-key)</strong>. For example, <em>example-add-on\\_\\_example-issue-field</em>.</p>  (required)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>100</code>.</p>  (optional)
   * @param projectId <p>Filters the results to options that are only available in the specified project.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanIssueFieldOption&gt;
   */
  public Single<PageBeanIssueFieldOption> getVisibleIssueFieldOptions(
    String fieldKey, Long startAt, Integer maxResults, Long projectId, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/field/{fieldKey}/option/suggestions/search";
    if (fieldKey != null) {
      request.pathParams.put("fieldKey", String.valueOf(fieldKey));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (projectId != null) {
      request.queryParams.put("projectId", Collections.singleton(String.valueOf(projectId)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getVisibleIssueFieldOptions);
  }

  /**
   * Replace issue field option
   * <p>Deselects an issue-field select-list option from all issues where it is selected. A different option can be selected to replace the deselected option. The update can also be limited to a smaller set of issues by using a JQL query.</p> <p>This is an <a href=\"#async\">asynchronous operation</a>. The response object contains a link to the long-running task.</p> <p>Note that this operation <strong>cannot be used with the built-in custom fields</strong>. It only works with issue fields added by Connect apps, as described above.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Jira permissions are not required for the app providing the field.</p> 
   * @param fieldKey <p>The field key is specified in the following format: <strong>$(app-key)\\_\\_$(field-key)</strong>. For example, <em>example-add-on\\_\\_example-issue-field</em>.</p>  (required)
   * @param optionId <p>The ID of the option to be deselected.</p>  (required)
   * @param replaceWith <p>The ID of the option that will replace the currently selected option.</p>  (optional)
   * @param jql <p>A JQL query that specifies the issues to be updated. For example, <em>project=10000</em>.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable replaceIssueFieldOption(
    String fieldKey, Long optionId, Long replaceWith, String jql, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/field/{fieldKey}/option/{optionId}/issue";
    if (fieldKey != null) {
      request.pathParams.put("fieldKey", String.valueOf(fieldKey));
    }
    if (optionId != null) {
      request.pathParams.put("optionId", String.valueOf(optionId));
    }
    if (replaceWith != null) {
      request.queryParams.put("replaceWith", Collections.singleton(String.valueOf(replaceWith)));
    }
    if (jql != null) {
      request.queryParams.put("jql", Collections.singleton(String.valueOf(jql)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Update issue field option
   * <p>Updates or creates an option for a select list issue field. This operation requires that the option ID is provided when creating an option, therefore, the option ID needs to be specified as a path and body parameter. The option ID provided in the path and body must be identical.</p> <p>Note that this operation <strong>cannot be used with the built-in custom fields</strong>. It only works with issue fields added by Connect apps, as described above.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>. Jira permissions are not required for the app providing the field.</p> 
   * @param fieldKey <p>The field key is specified in the following format: <strong>$(app-key)\\_\\_$(field-key)</strong>. For example, <em>example-add-on\\_\\_example-issue-field</em>.</p>  (required)
   * @param optionId <p>The ID of the option to be updated.</p>  (required)
   * @param issueFieldOption  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;IssueFieldOption&gt;
   */
  public Single<IssueFieldOption> updateIssueFieldOption(
    String fieldKey, Long optionId, IssueFieldOption issueFieldOption, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/field/{fieldKey}/option/{optionId}";
    if (fieldKey != null) {
      request.pathParams.put("fieldKey", String.valueOf(fieldKey));
    }
    if (optionId != null) {
      request.pathParams.put("optionId", String.valueOf(optionId));
    }
      request.requestBody = Optional.ofNullable(issueFieldOption);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_updateIssueFieldOption);
  }

}
