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

import org.openapitools.client.model.TimeTrackingConfiguration;
import org.openapitools.client.model.TimeTrackingProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class TimeTrackingApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<Object> returnType_disableTimeTracking = new TypeReference<Object>() {};


  private static final TypeReference<List<TimeTrackingProvider>> returnType_getAvailableTimeTrackingImplementations = new TypeReference<List<TimeTrackingProvider>>() {};


  private static final TypeReference<TimeTrackingProvider> returnType_getSelectedTimeTrackingImplementation = new TypeReference<TimeTrackingProvider>() {};


  private static final TypeReference<TimeTrackingConfiguration> returnType_getSharedTimeTrackingConfiguration = new TypeReference<TimeTrackingConfiguration>() {};


  private static final TypeReference<Object> returnType_selectTimeTrackingImplementation = new TypeReference<Object>() {};


  private static final TypeReference<TimeTrackingConfiguration> returnType_setSharedTimeTrackingConfiguration = new TypeReference<TimeTrackingConfiguration>() {};


  private final HttpClient httpClient;

  public TimeTrackingApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Disable time tracking
   * <p>Disables time tracking.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   * @deprecated
   */
  @Deprecated
  public Single<Object> disableTimeTracking(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/configuration/timetracking";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_disableTimeTracking);
  }

  /**
   * Get all time tracking providers
   * <p>Returns all time tracking providers. By default, Jira only has one time tracking provider: <em>JIRA provided time tracking</em>. However, you can install other time tracking providers via apps from the Atlassian Marketplace. For more information on time tracking providers, see the documentation for the <a href=\"https://developer.atlassian.com/cloud/jira/platform/modules/time-tracking-provider/\"> Time Tracking Provider</a> module.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;TimeTrackingProvider&gt;&gt;
   */
  public Single<List<TimeTrackingProvider>> getAvailableTimeTrackingImplementations(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/configuration/timetracking/list";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAvailableTimeTrackingImplementations);
  }

  /**
   * Get selected time tracking provider
   * <p>Returns the time tracking provider that is currently selected. Note that if time tracking is disabled, then a successful but empty response is returned.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;TimeTrackingProvider&gt;
   */
  public Single<TimeTrackingProvider> getSelectedTimeTrackingImplementation(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/configuration/timetracking";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getSelectedTimeTrackingImplementation);
  }

  /**
   * Get time tracking settings
   * <p>Returns the time tracking settings. This includes settings such as the time format, default time unit, and others. For more information, see <a href=\"https://confluence.atlassian.com/x/qoXKM\">Configuring time tracking</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;TimeTrackingConfiguration&gt;
   */
  public Single<TimeTrackingConfiguration> getSharedTimeTrackingConfiguration(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/configuration/timetracking/options";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getSharedTimeTrackingConfiguration);
  }

  /**
   * Select time tracking provider
   * <p>Selects a time tracking provider.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param timeTrackingProvider  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> selectTimeTrackingImplementation(
    TimeTrackingProvider timeTrackingProvider, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/configuration/timetracking";
      request.requestBody = Optional.ofNullable(timeTrackingProvider);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_selectTimeTrackingImplementation);
  }

  /**
   * Set time tracking settings
   * <p>Sets the time tracking settings.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param timeTrackingConfiguration  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;TimeTrackingConfiguration&gt;
   */
  public Single<TimeTrackingConfiguration> setSharedTimeTrackingConfiguration(
    TimeTrackingConfiguration timeTrackingConfiguration, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/configuration/timetracking/options";
      request.requestBody = Optional.ofNullable(timeTrackingConfiguration);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_setSharedTimeTrackingConfiguration);
  }

}
