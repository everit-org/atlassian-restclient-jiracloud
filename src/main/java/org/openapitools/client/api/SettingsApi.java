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

import org.openapitools.client.model.ColumnItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class SettingsApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<List<ColumnItem>> returnType_getIssueNavigatorDefaultColumns = new TypeReference<List<ColumnItem>>() {};


  private static final TypeReference<Object> returnType_setIssueNavigatorDefaultColumns = new TypeReference<Object>() {};


  private final HttpClient httpClient;

  public SettingsApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get issue navigator default columns
   * <p>Returns the default issue navigator columns.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ColumnItem&gt;&gt;
   */
  public Single<List<ColumnItem>> getIssueNavigatorDefaultColumns(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/settings/columns";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getIssueNavigatorDefaultColumns);
  }

  /**
   * Set issue navigator default columns
   * <p>Sets the default issue navigator columns.</p> <p>The <code>columns</code> parameter accepts a navigable field value and is expressed as HTML form data. To specify multiple columns, pass multiple <code>columns</code> parameters. For example, in curl:</p> <p><code>curl -X PUT -d columns=summary -d columns=description https://your-domain.atlassian.net/rest/api/3/settings/columns</code></p> <p>If no column details are sent, then all default columns are removed.</p> <p>A navigable field is one that can be used as a column on the issue navigator. Find details of navigable issue columns using <a href=\"#api-rest-api-3-field-get\">Get fields</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param requestBody <p>A navigable field value.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> setIssueNavigatorDefaultColumns(
    List<String> requestBody, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/settings/columns";
      request.requestBody = Optional.ofNullable(requestBody);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_setIssueNavigatorDefaultColumns);
  }

}
