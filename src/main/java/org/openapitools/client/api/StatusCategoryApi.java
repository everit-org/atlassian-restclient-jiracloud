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

import org.openapitools.client.model.StatusCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class StatusCategoryApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<List<StatusCategory>> returnType_getStatusCategories = new TypeReference<List<StatusCategory>>() {};


  private static final TypeReference<StatusCategory> returnType_getStatusCategory = new TypeReference<StatusCategory>() {};


  private final HttpClient httpClient;

  public StatusCategoryApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get all status categories
   * <p>Returns a list of all status categories.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;StatusCategory&gt;&gt;
   */
  public Single<List<StatusCategory>> getStatusCategories(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/statuscategory";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getStatusCategories);
  }

  /**
   * Get status category
   * <p>Returns a status category. Status categories provided a mechanism for categorizing <a href=\"#api-rest-api-3-status-idOrName-get\">statuses</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Permission to access Jira.</p> 
   * @param idOrKey <p>The ID or key of the status category.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;StatusCategory&gt;
   */
  public Single<StatusCategory> getStatusCategory(
    String idOrKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/statuscategory/{idOrKey}";
    if (idOrKey != null) {
      request.pathParams.put("idOrKey", String.valueOf(idOrKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getStatusCategory);
  }

}
