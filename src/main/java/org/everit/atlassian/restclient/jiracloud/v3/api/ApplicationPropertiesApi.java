/*
 * Copyright © 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.atlassian.restclient.jiracloud.v3.api;

import java.util.Optional;

import io.reactivex.Single;
import io.reactivex.Completable;

import org.everit.http.client.HttpMethod;

import org.everit.http.restclient.RestClient;
import org.everit.http.restclient.RestClientUtil;
import org.everit.http.restclient.RestRequest;
import org.everit.http.restclient.RestRequestEnhancer;
import org.everit.http.restclient.TypeReference;

import org.everit.atlassian.restclient.jiracloud.v3.model.ApplicationProperty;
import org.everit.atlassian.restclient.jiracloud.v3.model.SimpleApplicationPropertyBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationPropertiesApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";

  private static final TypeReference<List<ApplicationProperty>> returnType_getAdvancedSettings = new TypeReference<List<ApplicationProperty>>() {};

  private static final TypeReference<List<ApplicationProperty>> returnType_getApplicationProperty = new TypeReference<List<ApplicationProperty>>() {};

  private static final TypeReference<ApplicationProperty> returnType_setApplicationProperty = new TypeReference<ApplicationProperty>() {};

  private final RestClient restClient;

  public ApplicationPropertiesApi(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Get advanced settings
   * <p>Returns the application properties that are accessible on the <em>Advanced Settings</em> page. To navigate to the <em>Advanced Settings</em> page in Jira, choose the Jira icon &gt; <strong>Jira settings</strong> &gt; <strong>System</strong>, <strong>General Configuration</strong> and then click <strong>Advanced Settings</strong> (in the upper right).</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ApplicationProperty&gt;&gt;
   */
  public Single<List<ApplicationProperty>> getAdvancedSettings(Optional<RestRequestEnhancer> restRequestEnhancer)
     {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/application-properties/advanced-settings");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getAdvancedSettings);
  }

  /**
   * Get application property
   * <p>Returns all application properties or an application property.</p> <p>If you specify a value for the <code>key</code> parameter, then an application property is returned as an object (not in an array). Otherwise, an array of all editable application properties is returned. See <a href=\"#api-rest-api-3-application-properties-id-put\">Set application property</a> for descriptions of editable properties.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param key <p>The key of the application property.</p>  (optional)
   * @param permissionLevel <p>The permission level of all items being returned in the list.</p>  (optional)
   * @param keyFilter <p>When a <code>key</code> isn't provided, this filters the list of results by the application property <code>key</code> using a regular expression. For example, using <code>jira.lf.*</code> will return all application properties with keys that start with <em>jira.lf.</em>.</p>  (optional)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;ApplicationProperty&gt;&gt;
   */
  public Single<List<ApplicationProperty>> getApplicationProperty(
    Optional<String> key, Optional<String> permissionLevel, Optional<String> keyFilter, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.GET)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/application-properties");

    Map<String, String> pathParams = new HashMap<>();
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    if (key.isPresent()) {
      queryParams.put("key", Collections.singleton(String.valueOf(key.get())));
    }
    if (permissionLevel.isPresent()) {
      queryParams.put("permissionLevel", Collections.singleton(String.valueOf(permissionLevel.get())));
    }
    if (keyFilter.isPresent()) {
      queryParams.put("keyFilter", Collections.singleton(String.valueOf(keyFilter.get())));
    }
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_getApplicationProperty);
  }

  /**
   * Set application property
   * <p>Changes the value of an application property. For example, you can change the value of the <code>jira.clone.prefix</code> from its default value of <em>CLONE -</em> to <em>Clone -</em> if you prefer sentence case capitalization. Editable properties are described below along with their default values.</p> <h4>Advanced settings</h4> <p>The advanced settings below are also accessible in <a href=\"https://confluence.atlassian.com/x/vYXKM\">Jira</a>.</p> <table>   <thead>    <tr>     <th>Key</th>     <th>Description</th>     <th>Default value</th>    </tr>   </thead>   <tbody>    <tr>     <td><code>jira.clone.prefix</code></td>     <td>A string of text that automatically precedes the title of a cloned issue.</td>     <td><code>CLONE -</code></td>    </tr>    <tr>     <td><code>jira.date.picker.java.format</code></td>     <td>The date format for the Java (server-side) generated dates. This must be the same as the <code>jira.date.picker.javascript.format</code> format setting.</td>     <td><code>d/MMM/yy</code></td>    </tr>    <tr>     <td><code>jira.date.picker.javascript.format</code></td>     <td>This date format is for the JavaScript (client-side) generated dates. This must be the same as the <code>jira.date.picker.java.format</code> format setting.</td>     <td><code>%e/%b/%y</code></td>    </tr>    <tr>     <td><code>jira.date.time.picker.java.format</code></td>     <td>The date format for the Java (server-side) generated date times. This must be the same as the <code>jira.date.time.picker.javascript.format</code> format setting.</td>     <td><code>dd/MMM/yy h:mm a</code></td>    </tr>    <tr>     <td><code>jira.date.time.picker.javascript.format</code></td>     <td>This date format is for the JavaScript (client-side) generated date times. This must be the same as the <code>jira.date.time.picker.java.format</code> format setting.</td>     <td><code>%e/%b/%y %I:%M %p</code></td>    </tr>    <tr>     <td><code>jira.issue.actions.order</code></td>     <td>The default order of actions (such as <em>Comments</em> or <em>Change history</em>) displayed on the issue view.</td>     <td><code>asc</code></td>    </tr>    <tr>     <td><code>jira.table.cols.subtasks</code></td>     <td>The columns to show while viewing subtask issues in a table. For example, a list of subtasks on an issue.</td>     <td><code>issuetype, status, assignee, progress</code></td>    </tr>    <tr>     <td><code>jira.view.issue.links.sort.order</code></td>     <td>The sort order of the list of issue links on the issue view.</td>     <td><code>type, status, priority</code></td>    </tr>    <tr>     <td><code>jira.comment.collapsing.minimum.hidden</code></td>     <td>The minimum number of comments required for comment collapsing to occur. A value of <code>0</code> disables comment collapsing.</td>     <td><code>4</code></td>    </tr>    <tr>     <td><code>jira.newsletter.tip.delay.days</code></td>     <td>The number of days before a prompt to sign up to the Jira Insiders newsletter is shown. A value of <code>-1</code> disables this functionality.</td>     <td><code>7</code></td>    </tr>   </tbody>  </table> <h4>Look and feel</h4> <p>The settings listed below adjust the <a href=\"https://confluence.atlassian.com/x/VwCLLg\">look and feel</a>.</p> <table>   <thead>    <tr>     <th>Key</th>     <th>Description</th>     <th>Default value</th>    </tr>   </thead>   <tbody>    <tr>     <td><code>jira.lf.date.time</code></td>     <td>Look and feel of the <a href=\"https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html\" rel=\"nofollow\">time format</a>.</td>     <td><code>h:mm a</code></td>    </tr>    <tr>     <td><code>jira.lf.date.day</code></td>     <td>Look and feel of the <a href=\"https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html\" rel=\"nofollow\">day format</a>.</td>     <td><code>EEEE h:mm a</code></td>    </tr>    <tr>     <td><code>jira.lf.date.complete</code></td>     <td>Look and feel of the <a href=\"https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html\" rel=\"nofollow\">date and time format</a>.</td>     <td><code>dd/MMM/yy h:mm a</code></td>    </tr>    <tr>     <td><code>jira.lf.date.dmy</code></td>     <td>Look and feel of the <a href=\"https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html\" rel=\"nofollow\">date format</a>.</td>     <td><code>dd/MMM/yy</code></td>    </tr>    <tr>     <td><code>jira.date.time.picker.use.iso8061</code></td>     <td>When enabled, sets Monday as the first day of the week in the date picker, as specified by the ISO8601 standard.</td>     <td><code>false</code></td>    </tr>    <tr>     <td><code>jira.lf.logo.url</code></td>     <td>The URL of the logo image file.</td>     <td><code>/images/icon-jira-logo.png</code></td>    </tr>    <tr>     <td><code>jira.lf.logo.show.application.title</code></td>     <td>Controls the visibility of the application title on the sidebar.</td>     <td><code>false</code></td>    </tr>    <tr>     <td><code>jira.lf.favicon.url</code></td>     <td>The URL of the favicon.</td>     <td><code>/favicon.ico</code></td>    </tr>    <tr>     <td><code>jira.lf.favicon.hires.url</code></td>     <td>The URL of the high resolution favicon.</td>     <td><code>/images/64jira.png</code></td>    </tr>    <tr>     <td><code>jira.lf.top.adg3.bgcolour</code></td>     <td>The background color of the sidebar.</td>     <td><code>#0747A6</code></td>    </tr>    <tr>     <td><code>jira.lf.top.adg3.textcolour</code></td>     <td>The color of the text and logo of the sidebar.</td>     <td><code>#DEEBFF</code></td>    </tr>    <tr>     <td><code>jira.lf.hero.button.base.bg.colour</code></td>     <td></td>     <td><code>#3b7fc4</code></td>    </tr>    <tr>     <td><code>jira.title</code></td>     <td>The text for the application title. The application title can also be set in <em>General settings</em>.</td>     <td><code>Jira</code></td>    </tr>    <tr>     <td><code>jira.option.globalsharing</code></td>     <td>boolean</td>     <td><code>true</code></td>    </tr>    <tr>     <td><code>xflow.product.suggestions.enabled</code></td>     <td>Indicates whether to expose product suggestions for other Atlassian products within Jira.</td>     <td><code>true</code></td>    </tr>   </tbody>  </table> <h4>Other settings</h4> <table>   <thead>    <tr>     <th>Key</th>     <th>Description</th>     <th>Default value</th>    </tr>   </thead>   <tbody>    <tr>     <td><code>jira.issuenav.criteria.autoupdate</code></td>     <td>Supports instant updates to search criteria.</td>     <td><code>true</code></td>    </tr>   </tbody>  </table> <p><em>Note: Be careful when changing <a href=\"https://confluence.atlassian.com/x/vYXKM\">application properties and advanced settings</a>.</em></p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param id <p>The key of the application property to update.</p>  (required)
   * @param simpleApplicationPropertyBean  (required)
   * @param restRequestEnhancer <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ApplicationProperty&gt;
   */
  public Single<ApplicationProperty> setApplicationProperty(
    String id, SimpleApplicationPropertyBean simpleApplicationPropertyBean, Optional<RestRequestEnhancer> restRequestEnhancer) {

    RestRequest.Builder requestBuilder = RestRequest.builder()
        .method(HttpMethod.PUT)
        .basePath(DEFAULT_BASE_PATH)
        .path("/rest/api/3/application-properties/{id}");

    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("id", String.valueOf(id));
    requestBuilder.pathParams(pathParams);

    Map<String, Collection<String>> queryParams = new HashMap<>();
    requestBuilder.queryParams(queryParams);

    Map<String, String> headers = new HashMap<>();
    requestBuilder.headers(headers);

    requestBuilder.requestBody(Optional.of(simpleApplicationPropertyBean));

    return restClient.callEndpoint(requestBuilder.build(), restRequestEnhancer, returnType_setApplicationProperty);
  }

}
