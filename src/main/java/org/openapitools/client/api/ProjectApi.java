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

import org.openapitools.client.model.Avatar;
import org.openapitools.client.model.Component;
import org.openapitools.client.model.IssueTypeWithStatus;
import org.openapitools.client.model.PageBeanComponentWithIssueCount;
import org.openapitools.client.model.PageBeanProject;
import org.openapitools.client.model.PageBeanVersion;
import org.openapitools.client.model.Project;
import org.openapitools.client.model.ProjectAvatars;
import org.openapitools.client.model.ProjectIdentifiers;
import org.openapitools.client.model.ProjectInputBean;
import org.openapitools.client.model.Version;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class ProjectApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<ProjectIdentifiers> returnType_createProject = new TypeReference<ProjectIdentifiers>() {};


  private static final TypeReference<Avatar> returnType_createProjectAvatar = new TypeReference<Avatar>() {};


  private static final TypeReference<ProjectAvatars> returnType_getAllProjectAvatars = new TypeReference<ProjectAvatars>() {};


  private static final TypeReference<List<Project>> returnType_getAllProjects = new TypeReference<List<Project>>() {};


  private static final TypeReference<List<IssueTypeWithStatus>> returnType_getAllStatuses = new TypeReference<List<IssueTypeWithStatus>>() {};


  private static final TypeReference<Project> returnType_getProject = new TypeReference<Project>() {};


  private static final TypeReference<List<Component>> returnType_getProjectComponents = new TypeReference<List<Component>>() {};


  private static final TypeReference<PageBeanComponentWithIssueCount> returnType_getProjectComponentsPaginated = new TypeReference<PageBeanComponentWithIssueCount>() {};


  private static final TypeReference<List<Version>> returnType_getProjectVersions = new TypeReference<List<Version>>() {};


  private static final TypeReference<PageBeanVersion> returnType_getProjectVersionsPaginated = new TypeReference<PageBeanVersion>() {};


  private static final TypeReference<PageBeanProject> returnType_searchProjects = new TypeReference<PageBeanProject>() {};


  private static final TypeReference<Project> returnType_updateProject = new TypeReference<Project>() {};


  private static final TypeReference<Object> returnType_updateProjectAvatar = new TypeReference<Object>() {};


  private static final TypeReference<Project> returnType_updateProjectType = new TypeReference<Project>() {};


  private final HttpClient httpClient;

  public ProjectApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Create project
   * <p>Creates a project based on a project type template, as shown in the following table:</p> <table>   <thead>    <tr>     <th>Project Type Key</th>     <th>Project Template Key</th>    </tr>   </thead>   <tbody>    <tr>     <td><code>business</code></td>     <td><code>com.atlassian.jira-core-project-templates:jira-core-simplified-content-management</code>, <code>com.atlassian.jira-core-project-templates:jira-core-simplified-document-approval</code>, <code>com.atlassian.jira-core-project-templates:jira-core-simplified-lead-tracking</code>, <code>com.atlassian.jira-core-project-templates:jira-core-simplified-process-control</code>, <code>com.atlassian.jira-core-project-templates:jira-core-simplified-procurement</code>, <code>com.atlassian.jira-core-project-templates:jira-core-simplified-project-management</code>, <code>com.atlassian.jira-core-project-templates:jira-core-simplified-recruitment</code>, <code>com.atlassian.jira-core-project-templates:jira-core-simplified-task-tracking</code> </td>    </tr>    <tr>     <td><code>service_desk</code></td>     <td><code>com.atlassian.servicedesk:simplified-it-service-desk</code>, <code>com.atlassian.servicedesk:simplified-internal-service-desk</code>, <code>com.atlassian.servicedesk:simplified-external-service-desk</code> </td>    </tr>    <tr>     <td><code>software</code></td>     <td><code>com.pyxis.greenhopper.jira:gh-simplified-agility-kanban</code>, <code>com.pyxis.greenhopper.jira:gh-simplified-agility-scrum</code>, <code>com.pyxis.greenhopper.jira:gh-simplified-basic</code>, <code>com.pyxis.greenhopper.jira:gh-simplified-kanban-classic</code>, <code>com.pyxis.greenhopper.jira:gh-simplified-scrum-classic</code> </td>    </tr>   </tbody>  <tbody>   </tbody> </table> <p>The project types are available according to the installed Jira features as follows:</p> <ul> <li>Jira Core, the default, enables <code>business</code> projects.</li> <li>Jira Service Desk enables <code>service_desk</code> projects.</li> <li>Jira Software enables <code>software</code> projects.</li> </ul> <p>To determine which features are installed, go to <strong>Jira settings</strong> &gt; <strong>Apps</strong> &gt; <strong>Manage apps</strong> and review the System Apps list. To add JIRA Software or JIRA Service Desk into a JIRA instance, use <strong>Jira settings</strong> &gt; <strong>Apps</strong> &gt; <strong>Finding new apps</strong>. For more information, see <a href=\"https://confluence.atlassian.com/x/S31NLg\"> Managing add-ons</a>.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param projectInputBean <p>The JSON representation of the project being created.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectIdentifiers&gt;
   */
  public Single<ProjectIdentifiers> createProject(
    ProjectInputBean projectInputBean, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project";
      request.requestBody = Optional.ofNullable(projectInputBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createProject);
  }

  /**
   * Load project avatar
   * <p>Loads an avatar for a project.</p> <p>Specify the avatar's local file location in the body of the request. Also, include the following headers:</p> <ul> <li><code>X-Atlassian-Token: no-check</code> To prevent XSRF protection blocking the request, for more information see <a href=\"#special-request-headers\">Special Headers</a>.</li> <li><code>Content-Type: image/image type</code> Valid image types are JPEG, GIF, or PNG.</li> </ul> <p>For example:<br /> <code>curl --request POST </code></p> <p><code>--user email@example.com:&lt;api_token&gt; </code></p> <p><code>--header 'X-Atlassian-Token: no-check' </code></p> <p><code>--header 'Content-Type: image/&lt; image_type&gt;' </code></p> <p><code>--data-binary &quot;&lt;@/path/to/file/with/your/avatar&gt;&quot; </code></p> <p><code>--url 'https://your-domain.atlassian.net/rest/api/3/project/{projectIdOrKey}/avatar2'</code></p> <p>The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square's sides is set to the smaller of the height or width of the image.</p> <p>The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.</p> <p>After creating the avatar use <a href=\"#api-rest-api-3-project-projectIdOrKey-avatar-put\">Set project avatar</a> to set it as the project's displayed avatar.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a>.</p> 
   * @param projectIdOrKey <p>The ID or (case-sensitive) key of the project.</p>  (required)
   * @param body  (required)
   * @param x <p>The X coordinate of the top-left corner of the crop region.</p>  (optional, default to 0)
   * @param y <p>The Y coordinate of the top-left corner of the crop region.</p>  (optional, default to 0)
   * @param size <p>The length of each side of the crop region.</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Avatar&gt;
   */
  public Single<Avatar> createProjectAvatar(
    String projectIdOrKey, Object body, Integer x, Integer y, Integer size, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.POST;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}/avatar2";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    if (x != null) {
      request.queryParams.put("x", Collections.singleton(String.valueOf(x)));
    }
    if (y != null) {
      request.queryParams.put("y", Collections.singleton(String.valueOf(y)));
    }
    if (size != null) {
      request.queryParams.put("size", Collections.singleton(String.valueOf(size)));
    }
      request.requestBody = Optional.ofNullable(body);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_createProjectAvatar);
  }

  /**
   * Delete project
   * <p>Deletes a project.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteProject(
    String projectIdOrKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Delete project avatar
   * <p>Deletes a custom avatar from a project. Note that system avatars cannot be deleted.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a>.</p> 
   * @param projectIdOrKey <p>The project ID or (case-sensitive) key.</p>  (required)
   * @param id <p>The ID of the avatar.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable deleteProjectAvatar(
    String projectIdOrKey, Long id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}/avatar/{id}";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

  /**
   * Get all project avatars
   * <p>Returns all project avatars, grouped by system and custom avatars.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> 
   * @param projectIdOrKey <p>The ID or (case-sensitive) key of the project.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;ProjectAvatars&gt;
   */
  public Single<ProjectAvatars> getAllProjectAvatars(
    String projectIdOrKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}/avatars";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllProjectAvatars);
  }

  /**
   * Get all projects
   * <p>Returns all projects visible to the user. Deprecated, use <a href=\"#api-rest-api-3-project-search-get\"> Get projects paginated</a> that supports search and pagination.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Projects are returned only where the user has <em>Browse Projects</em> or <em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> 
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>description</code> Returns the project description.</li> <li><code>issueTypes</code> Returns all issue types associated with the project.</li> <li><code>lead</code> Returns information about the the project lead.</li> <li><code>projectKeys</code> Returns all project keys associated with the project.</li> </ul>  (optional)
   * @param recent <p>Returns the user's most recently accessed projects. You may specify the number of results to return up to a maximum of 20. If access is anonymous, then the recently accessed projects are based on the current HTTP session.</p>  (optional)
   * @param properties <p>A comma-separated list of project properties to return for the project.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Project&gt;&gt;
   * @deprecated
   */
  @Deprecated
  public Single<List<Project>> getAllProjects(
    String expand, Integer recent, List<String> properties, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project";
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    if (recent != null) {
      request.queryParams.put("recent", Collections.singleton(String.valueOf(recent)));
    }
    if (properties != null) {
      request.queryParams.put("properties", RestCallUtil.objectCollectionToStringCollection(properties));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllProjects);
  }

  /**
   * Get all statuses for project
   * <p>Returns the valid statuses for a project. The statuses are grouped by issue type, as each project has a set of valid issue types and each issue type has a set of valid statuses.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;IssueTypeWithStatus&gt;&gt;
   */
  public Single<List<IssueTypeWithStatus>> getAllStatuses(
    String projectIdOrKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}/statuses";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAllStatuses);
  }

  /**
   * Get project
   * <p>Returns the <a href=\"https://confluence.atlassian.com/x/ahLpNw\">project details</a> for a project.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that the project description, issue types, and project lead are included in all responses by default:</p> <ul> <li><code>description</code> The project description.</li> <li><code>issueTypes</code> The issue types associated with the project.</li> <li><code>lead</code> The project lead.</li> <li><code>projectKeys</code> All project keys associated with the project.</li> <li><code>issueTypeHierarchy</code> The project issue type hierarchy.</li> </ul>  (optional)
   * @param properties <p>A comma-separated list of project properties to return for the project.</p>  (optional, default to new ArrayList&lt;&gt;())
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Project&gt;
   */
  public Single<Project> getProject(
    String projectIdOrKey, String expand, List<String> properties, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    if (properties != null) {
      request.queryParams.put("properties", RestCallUtil.objectCollectionToStringCollection(properties));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getProject);
  }

  /**
   * Get project components
   * <p>Returns all components in a project. See the <a href=\"#api-rest-api-3-project-projectIdOrKey-component-get\">Get project components paginated</a> resource if you want to get a full list of components with pagination.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Component&gt;&gt;
   */
  public Single<List<Component>> getProjectComponents(
    String projectIdOrKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}/components";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getProjectComponents);
  }

  /**
   * Get project components paginated
   * <p>Returns a <a href=\"#pagination\">paginated</a> representation of all components in a project. See the <a href=\"#api-rest-api-3-project-projectIdOrKey-components-get\">Get project components</a> resource if you want to get a full list of versions without pagination.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>50</code>.</p>  (optional, default to 50)
   * @param orderBy <p><a href=\"#ordering\">Order</a> the results by a field:</p> <ul> <li><code>description</code> Sorts components in alphabetical order by description.</li> <li><code>issueCount</code> Sorts components by the count of issues associated with the component in ascending order.</li> <li><code>lead</code> Sorts by the project lead's user key in alphabetical order.</li> <li><code>name</code> Sorts components in alphabetical order by component name.</li> </ul>  (optional)
   * @param query <p>Filter the results using a literal string. Components with a matching <code>name</code> or <code>description</code> are returned (case insensitive).</p>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanComponentWithIssueCount&gt;
   */
  public Single<PageBeanComponentWithIssueCount> getProjectComponentsPaginated(
    String projectIdOrKey, Long startAt, Integer maxResults, String orderBy, String query, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}/component";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (orderBy != null) {
      request.queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy)));
    }
    if (query != null) {
      request.queryParams.put("query", Collections.singleton(String.valueOf(query)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getProjectComponentsPaginated);
  }

  /**
   * Get project versions
   * <p>Returns all versions in a project. The response is not paginated. Use <a href=\"#api-rest-api-3-project-projectIdOrKey-version-get\">Get project versions paginated</a> if you want to get the versions in a project with pagination.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>operations</code> Returns actions that can be performed on the specified version.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;List&lt;Version&gt;&gt;
   */
  public Single<List<Version>> getProjectVersions(
    String projectIdOrKey, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}/versions";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getProjectVersions);
  }

  /**
   * Get project versions paginated
   * <p>Returns a <a href=\"#pagination\">paginated</a> representation of all versions in a project. See the <a href=\"#api-rest-api-3-project-projectIdOrKey-versions-get\">Get project versions</a> resource if you want to get a full list of versions without pagination.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Browse Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>50</code>.</p>  (optional, default to 50)
   * @param orderBy <p><a href=\"#ordering\">Order</a> the results by a field:</p> <ul> <li><code>description</code> Sorts versions in alphabetical order by description.</li> <li><code>name</code> Sorts versions in alphabetical order by version name.</li> <li><code>releaseDate</code> Sorts versions in order by release date, starting with the oldest date. Versions with no release date are listed last.</li> <li><code>sequence</code> Sorts versions by the order of appearance in the user interface.</li> <li><code>startDate</code> Sorts versions in order by start date, starting with the oldest date. Versions with no start date are listed last.</li> </ul>  (optional)
   * @param query <p>Filter the results using a literal string. Versions with matching <code>name</code> or <code>description</code> are returned (case insensitive).</p>  (optional)
   * @param status <p>A comma-separated list of status values used to filter the results by version status. The status values are <code>released</code>, <code>unreleased</code>, and <code>archived</code>.</p>  (optional)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>issuesstatus</code> Returns the number of issues in each status category for each version.</li> <li><code>operations</code> Returns actions that can be performed on the specified version.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanVersion&gt;
   */
  public Single<PageBeanVersion> getProjectVersionsPaginated(
    String projectIdOrKey, Long startAt, Integer maxResults, String orderBy, String query, String status, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}/version";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (orderBy != null) {
      request.queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy)));
    }
    if (query != null) {
      request.queryParams.put("query", Collections.singleton(String.valueOf(query)));
    }
    if (status != null) {
      request.queryParams.put("status", Collections.singleton(String.valueOf(status)));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getProjectVersionsPaginated);
  }

  /**
   * Get projects paginated
   * <p>Returns projects visible to the user.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> Projects are returned only where the user has <em>Browse Projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> 
   * @param startAt <p>The index of the first item to return in a page of results (page offset).</p>  (optional, default to 0l)
   * @param maxResults <p>The maximum number of items to return per page. The maximum is <code>50</code>.</p>  (optional, default to 50)
   * @param orderBy <p><a href=\"#ordering\">Order</a> the results by a field. If the <code>orderBy</code> field is not set, then projects are listed in ascending order by project key:</p> <ul> <li><code>category</code> Sorts projects in order by project category. A complete list of category IDs is found using the <a href=\"#api-rest-api-3-projectCategory-get\">Get all project categories</a> operation.</li> <li><code>key</code> Sorts projects in order by project key.</li> <li><code>name</code> Sorts projects in alphabetical order by project name.</li> <li><code>owner</code> Sorts projects in order by the project lead.</li> </ul>  (optional, default to key)
   * @param query <p>Filter the results using a literal string. Projects with a matching <code>key</code> or <code>name</code> are returned (case insensitive).</p>  (optional)
   * @param typeKey <p>Orders results by the <a href=\"https://confluence.atlassian.com/x/GwiiLQ#Jiraapplicationsoverview-Productfeaturesandprojecttypes\">project type</a>. This parameter accepts multiple values separated by a comma. Valid values are <code>business</code>, <code>service_desk</code>, and <code>software</code>.</p>  (optional)
   * @param categoryId <p>The ID of the project's category. A complete list of category IDs is found using the <a href=\"#api-rest-api-3-projectCategory-get\">Get all project categories</a> operation.</p>  (optional)
   * @param action <p>Filter results by projects for which the user can:</p> <ul> <li> <p><code>view</code> the project, meaning that they have one of the following permissions:</p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</li> <li><em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</li> <li>site administration (that is, member of the <em>site-admin</em> <a href=\"https://confluence.atlassian.com/x/24xjL&quot;\">group</a>).</li> </ul> </li> <li> <p><code>browse</code> the project, meaning that they have the <em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</p> </li> <li> <p><code>edit</code> the project, meaning that they have one of the following permissions:</p> <ul> <li><em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project.</li> <li>site administration (that is, member of the <em>site-admin</em> <a href=\"https://confluence.atlassian.com/x/24xjL&quot;\">group</a>).</li> </ul> </li> </ul>  (optional, default to view)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma:</p> <ul> <li><code>description</code> Returns the project description.</li> <li><code>projectKeys</code> Returns all project keys associated with a project.</li> <li><code>lead</code> Returns information about the the project lead.</li> <li><code>issueTypes</code> Returns all issue types associated with the project.</li> <li><code>url</code> Returns the URL associated with the project.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;PageBeanProject&gt;
   */
  public Single<PageBeanProject> searchProjects(
    Long startAt, Integer maxResults, String orderBy, String query, String typeKey, Long categoryId, String action, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/search";
    if (startAt != null) {
      request.queryParams.put("startAt", Collections.singleton(String.valueOf(startAt)));
    }
    if (maxResults != null) {
      request.queryParams.put("maxResults", Collections.singleton(String.valueOf(maxResults)));
    }
    if (orderBy != null) {
      request.queryParams.put("orderBy", Collections.singleton(String.valueOf(orderBy)));
    }
    if (query != null) {
      request.queryParams.put("query", Collections.singleton(String.valueOf(query)));
    }
    if (typeKey != null) {
      request.queryParams.put("typeKey", Collections.singleton(String.valueOf(typeKey)));
    }
    if (categoryId != null) {
      request.queryParams.put("categoryId", Collections.singleton(String.valueOf(categoryId)));
    }
    if (action != null) {
      request.queryParams.put("action", Collections.singleton(String.valueOf(action)));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_searchProjects);
  }

  /**
   * Update project
   * <p>Updates the <a href=\"https://confluence.atlassian.com/x/ahLpNw\">project details</a> of a project.</p> <p>All parameters are optional in the body of the request.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param projectInputBean <p>The project details to be updated.</p>  (required)
   * @param expand <p>Use <a href=\"#expansion\">expand</a> to include additional information in the response. This parameter accepts multiple values separated by a comma. Note that the project description, issue types, and project lead are included in all responses by default:</p> <ul> <li><code>description</code> The project description.</li> <li><code>issueTypes</code> The issue types associated with the project.</li> <li><code>lead</code> The project lead.</li> <li><code>projectKeys</code> All project keys associated with the project.</li> </ul>  (optional)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Project&gt;
   */
  public Single<Project> updateProject(
    String projectIdOrKey, ProjectInputBean projectInputBean, String expand, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    if (expand != null) {
      request.queryParams.put("expand", Collections.singleton(String.valueOf(expand)));
    }
      request.requestBody = Optional.ofNullable(projectInputBean);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_updateProject);
  }

  /**
   * Set project avatar
   * <p>Sets the avatar displayed for a project.</p> <p>Use <a href=\"#api-rest-api-3-project-projectIdOrKey-avatar2-post\">Load project avatar</a> to store avatars against the project, before using this operation to set the displayed avatar.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a>.</p> 
   * @param projectIdOrKey <p>The ID or (case-sensitive) key of the project.</p>  (required)
   * @param avatar  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Object&gt;
   */
  public Single<Object> updateProjectAvatar(
    String projectIdOrKey, Avatar avatar, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}/avatar";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
      request.requestBody = Optional.ofNullable(avatar);
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_updateProjectAvatar);
  }

  /**
   * Update project type
   * <p>Deprecated, this feature is no longer supported and no alternatives are available, see <a href=\"https://confluence.atlassian.com/x/yEKeOQ\">Convert project to a different template or type</a>. Updates a <a href=\"https://confluence.atlassian.com/x/GwiiLQ\">project type</a>. The project type can be updated for classic projects only, project type cannot be updated for next-gen projects.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> <em>Administer Jira</em> <a href=\"https://confluence.atlassian.com/x/x4dKLg\">global permission</a>.</p> 
   * @param projectIdOrKey <p>The project ID or project key (case sensitive).</p>  (required)
   * @param newProjectTypeKey <p>The key of the new project type.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;Project&gt;
   * @deprecated
   */
  @Deprecated
  public Single<Project> updateProjectType(
    String projectIdOrKey, String newProjectTypeKey, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.PUT;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/project/{projectIdOrKey}/type/{newProjectTypeKey}";
    if (projectIdOrKey != null) {
      request.pathParams.put("projectIdOrKey", String.valueOf(projectIdOrKey));
    }
    if (newProjectTypeKey != null) {
      request.pathParams.put("newProjectTypeKey", String.valueOf(newProjectTypeKey));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_updateProjectType);
  }

}
