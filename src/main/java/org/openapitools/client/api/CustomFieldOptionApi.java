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

import org.openapitools.client.model.CustomFieldOption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class CustomFieldOptionApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<CustomFieldOption> returnType_getCustomFieldOption = new TypeReference<CustomFieldOption>() {};


  private final HttpClient httpClient;

  public CustomFieldOptionApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get custom field option
   * <p>Returns a custom field option. For example, an option in a cascading select list.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param id <p>The ID of the custom field option. To find this ID, <a href=\"https://confluence.atlassian.com/x/B4hKLg\"> configure the custom field</a> and edit its options in Jira. Click the option and its ID will show in the URL as the <code>selectedParentOptionId</code> parameter.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;CustomFieldOption&gt;
   */
  public Single<CustomFieldOption> getCustomFieldOption(
    String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/customFieldOption/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getCustomFieldOption);
  }

}
