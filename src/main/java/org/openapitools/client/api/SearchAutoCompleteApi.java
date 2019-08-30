package org.openapitools.client.api;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.atlassian.restclient.common.RestCallUtil;
import org.everit.atlassian.restclient.common.RestRequest;
import org.everit.atlassian.restclient.common.RestRequestEnhancer;

import org.everit.http.client.HttpClient;
import org.everit.http.client.HttpMethod;
import org.everit.http.client.HttpRequest;

import org.openapitools.client.model.AutoCompleteSuggestions;
import org.openapitools.client.model.JQLReferenceData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchAutoCompleteApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<JQLReferenceData> returnType_getAutoComplete = new TypeReference<JQLReferenceData>() {};

  private static final TypeReference<AutoCompleteSuggestions> returnType_getFieldAutoCompleteForQueryString = new TypeReference<AutoCompleteSuggestions>() {};

  private final HttpClient httpClient;

  public SearchAutoCompleteApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get field reference data
   * <p>Returns reference data for JQL searches. This is a downloadable version of the documentation provided in <a href=\"https://confluence.atlassian.com/x/gwORLQ\">Advanced searching - fields reference</a> and <a href=\"https://confluence.atlassian.com/x/hgORLQ\">Advanced searching - functions reference</a>, along with a list of JQL-reserved words. Use this information to assist with the programmatic creation of JQL queries or the validation of queries built in a custom query builder.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;JQLReferenceData&gt;
   */
  public Single<JQLReferenceData> getAutoComplete(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/jql/autocompletedata");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getAutoComplete);
  }

  /**
   * Get field auto complete suggestions
   * <p>Returns the JQL search auto complete suggestions for a field.</p> <p>Suggestions can be obtained by providing:</p> <ul> <li><code>fieldName</code> to get a list of all values for the field.</li> <li><code>fieldName</code> and <code>fieldValue</code> to get a list of values containing the text in <code>fieldValue</code>.</li> <li><code>fieldName</code> and <code>predicateName</code> to get a list of all predicate values for the field.</li> <li><code>fieldName</code>, <code>predicateName</code>, and <code>predicateValue</code> to get a list of predicate values containing the text in <code>predicateValue</code>.</li> </ul> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param fieldName <p>The name of the field.</p>  (optional)
   * @param fieldValue <p>The partial field item name entered by the user.</p>  (optional)
   * @param predicateName <p>The name of the <a href=\"https://confluence.atlassian.com/x/hQORLQ#Advancedsearching-operatorsreference-CHANGEDCHANGED\"> CHANGED operator predicate</a> for which the suggestions are generated. The valid predicate operators are <em>by</em>, <em>from</em>, and <em>to</em>.</p>  (optional)
   * @param predicateValue <p>The partial predicate item name entered by the user.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;AutoCompleteSuggestions&gt;
   */
  public Single<AutoCompleteSuggestions> getFieldAutoCompleteForQueryString(
    Optional<String> fieldName, Optional<String> fieldValue, Optional<String> predicateName, Optional<String> predicateValue, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/jql/autocompletedata/suggestions");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (fieldName.isPresent()) {
      queryParams.put("fieldName", Collections.singleton(String.valueOf(fieldName.get())));
    }
    if (fieldValue.isPresent()) {
      queryParams.put("fieldValue", Collections.singleton(String.valueOf(fieldValue.get())));
    }
    if (predicateName.isPresent()) {
      queryParams.put("predicateName", Collections.singleton(String.valueOf(predicateName.get())));
    }
    if (predicateValue.isPresent()) {
      queryParams.put("predicateValue", Collections.singleton(String.valueOf(predicateValue.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return RestCallUtil.callEndpoint(httpClient, requestBuilder.build(), restRequestEnhancer, returnType_getFieldAutoCompleteForQueryString);
  }

}
