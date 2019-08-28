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

import org.openapitools.client.model.CustomFieldDefinitionJsonBean;
import org.openapitools.client.model.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class FieldApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<Field> returnType_createCustomField = new TypeReference<Field>() {};


  private static final TypeReference<List<Field>> returnType_getFields = new TypeReference<List<Field>>() {};


  private final HttpClient httpClient;

  public FieldApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Create custom field
   * <p>Creates a custom field.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param customFieldDefinitionJsonBean <p>Definition of the custom field to be created</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Field&gt;
   */
  public Single<Field> createCustomField(
    CustomFieldDefinitionJsonBean customFieldDefinitionJsonBean, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/field";
      request.requestBody = Optional.ofNullable(customFieldDefinitionJsonBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createCustomField);
  }

  /**
   * Get fields
   * <p>Returns system and custom issue fields according to the following rules:</p> <ul> <li>Fields that cannot be added to the issue navigator are always returned.</li> <li>Fields that cannot be placed on an issue screen are always returned.</li> <li>Fields that depend on global Jira settings are only returned if the setting is enabled. That is, timetracking fields, subtasks, votes, and watches.</li> <li>For all other fields, this operation only returns the fields that the user has permission to view (that is, the field is used in at least one project that the user has <em>Browse Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for.)</li> </ul> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Field&gt;&gt;
   */
  public Single<List<Field>> getFields(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/field";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getFields);
  }

}
