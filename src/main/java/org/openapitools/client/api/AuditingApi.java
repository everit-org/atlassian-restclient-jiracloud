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

import org.openapitools.client.model.AuditRecords;
import java.time.OffsetDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class AuditingApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<AuditRecords> returnType_getAuditRecords = new TypeReference<AuditRecords>() {};


  private final HttpClient httpClient;

  public AuditingApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get audit records
   * <p>Returns a list of audit records. The list can be filtered to include items:</p> <ul> <li>containing a string in at least one field. For example, providing <em>up</em> will return all audit records where one or more fields contains words such as <em>update</em>.</li> <li>created on or after a date and time.</li> <li>created or or before a date and time.</li> <li>created during a time period.</li> </ul> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param offset <p>The number of records to skip before returning the first result.</p>  (optional, default to 0)
   * @param limit <p>The maximum number of results to return. The maximum is <code>1000</code>.</p>  (optional, default to 1000)
   * @param filter <p>The query string.</p>  (optional)
   * @param from <p>The date and time on or after which returned audit records must have been created. If <code>to</code> is provided <code>from</code> must be before <code>to</code> or no audit records are returned.</p>  (optional)
   * @param to <p>The date and time on or before which returned audit results must have been created. If <code>from</code> is provided <code>to</code> must be after <code>from</code> or no audit records are returned.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;AuditRecords&gt;
   */
  public Single<AuditRecords> getAuditRecords(
    Integer offset, Integer limit, String filter, OffsetDateTime from, OffsetDateTime to, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/auditing/record";
    if (offset != null) {
      request.queryParams.put("offset", Collections.singleton(String.valueOf(offset)));
    }
    if (limit != null) {
      request.queryParams.put("limit", Collections.singleton(String.valueOf(limit)));
    }
    if (filter != null) {
      request.queryParams.put("filter", Collections.singleton(String.valueOf(filter)));
    }
    if (from != null) {
      request.queryParams.put("from", Collections.singleton(String.valueOf(from)));
    }
    if (to != null) {
      request.queryParams.put("to", Collections.singleton(String.valueOf(to)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAuditRecords);
  }

}
