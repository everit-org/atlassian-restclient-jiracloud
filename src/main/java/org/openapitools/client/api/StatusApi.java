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

import org.openapitools.client.model.StatusDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class StatusApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<StatusDetails> returnType_getStatus = new TypeReference<StatusDetails>() {};


  private static final TypeReference<List<StatusDetails>> returnType_getStatuses = new TypeReference<List<StatusDetails>>() {};


  private final HttpClient httpClient;

  public StatusApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get status
   * <p>Returns a status. The status must be associated with a workflow to be returned.</p> <p>If a name is used on more than one status, only the status found first is returned. Therefore, identifying the status by its ID may be preferable.</p> <p>This operation can be accessed anonymously.</p> <p><a href=\"#permissions\">Permissions</a> required: None.</p> 
   * @param idOrName <p>The ID or name of the status.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;StatusDetails&gt;
   */
  public Single<StatusDetails> getStatus(
    String idOrName, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/status/{idOrName}";
    if (idOrName != null) {
      request.pathParams.put("idOrName", String.valueOf(idOrName));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getStatus);
  }

  /**
   * Get all statuses
   * <p>Returns a list of all statuses associated with workflows.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;StatusDetails&gt;&gt;
   */
  public Single<List<StatusDetails>> getStatuses(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/status";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getStatuses);
  }

}
