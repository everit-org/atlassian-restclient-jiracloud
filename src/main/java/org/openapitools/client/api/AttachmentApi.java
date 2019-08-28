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

import org.openapitools.client.model.AttachmentArchiveImpl;
import org.openapitools.client.model.AttachmentArchiveMetadataReadable;
import org.openapitools.client.model.AttachmentMetadata;
import org.openapitools.client.model.AttachmentSettings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class AttachmentApi {

  private static final String DEFAULT_BASE_PATH = "http://localhost";


  private static final TypeReference<AttachmentArchiveMetadataReadable> returnType_expandAttachmentForHumans = new TypeReference<AttachmentArchiveMetadataReadable>() {};


  private static final TypeReference<AttachmentArchiveImpl> returnType_expandAttachmentForMachines = new TypeReference<AttachmentArchiveImpl>() {};


  private static final TypeReference<AttachmentMetadata> returnType_getAttachment = new TypeReference<AttachmentMetadata>() {};


  private static final TypeReference<AttachmentSettings> returnType_getAttachmentMeta = new TypeReference<AttachmentSettings>() {};


  private final HttpClient httpClient;

  public AttachmentApi(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  /**
   * Get all metadata for an expanded attachment
   * <p>Returns the metadata for the contents of an attachment, if it is an archive, and metadata for the attachment itself. For example, if the attachment is a ZIP archive, then information about the files in the archive is returned and metadata for the ZIP archive. Currently, only the ZIP archive format is supported.</p> <p>Use this operation to retrieve data that is presented to the user, as this operation returns the metadata for the attachment itself, such as the attachment's ID and name. Otherwise, use <a href=\"#api-rest-api-3-attachment-id-expand-raw-get\"> Get contents metadata for an expanded attachment</a>, which only returns the metadata for the attachment's contents.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> For the issue containing the attachment:</p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param id <p>The ID of the attachment.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;AttachmentArchiveMetadataReadable&gt;
   */
  public Single<AttachmentArchiveMetadataReadable> expandAttachmentForHumans(
    String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/attachment/{id}/expand/human";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_expandAttachmentForHumans);
  }

  /**
   * Get contents metadata for an expanded attachment
   * <p>Returns the metadata for the contents of an attachment, if it is an archive. For example, if the attachment is a ZIP archive, then information about the files in the archive is returned. Currently, only the ZIP archive format is supported.</p> <p>Use this operation if you are processing the data without presenting it to the user, as this operation only returns the metadata for the contents of the attachment. Otherwise, to retrieve data to present to the user, use <a href=\"#api-rest-api-3-attachment-id-expand-human-get\"> Get all metadata for an expanded attachment</a> which also returns the metadata for the attachment itself, such as the attachment's ID and name.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> For the issue containing the attachment:</p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param id <p>The ID of the attachment.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;AttachmentArchiveImpl&gt;
   */
  public Single<AttachmentArchiveImpl> expandAttachmentForMachines(
    String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/attachment/{id}/expand/raw";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_expandAttachmentForMachines);
  }

  /**
   * Get attachment metadata
   * <p>Returns the metadata for an attachment. Note that the attachment itself is not returned.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong></p> <ul> <li><em>Browse projects</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> for the project that the issue is in.</li> <li>If <a href=\"https://confluence.atlassian.com/x/J4lKLg\">issue-level security</a> is configured, issue-level security permission to view the issue.</li> </ul> 
   * @param id <p>The ID of the attachment.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;AttachmentMetadata&gt;
   */
  public Single<AttachmentMetadata> getAttachment(
    String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/attachment/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAttachment);
  }

  /**
   * Get Jira attachment settings
   * <p>Returns the attachment settings, that is, whether attachments are enabled and the maximum attachment size allowed.</p> <p>Note that there are also <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permissions</a> that restrict whether users can create and delete attachments.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> None.</p> 
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Single&lt;AttachmentSettings&gt;
   */
  public Single<AttachmentSettings> getAttachmentMeta(Optional<RestRequestInterceptor> restRequestInterceptor)
     {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.GET;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/attachment/meta";
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request, returnType_getAttachmentMeta);
  }

  /**
   * Delete attachment
   * <p>Deletes an attachment from an issue.</p> <p>This operation can be accessed anonymously.</p> <p><strong><a href=\"#permissions\">Permissions</a> required:</strong> For the project holding the issue containing the attachment:</p> <ul> <li><em>Delete own attachments</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> to delete an attachment created by the calling user.</li> <li><em>Delete all attachments</em> <a href=\"https://confluence.atlassian.com/x/yodKLg\">project permission</a> to delete an attachment created by any user.</li> </ul> 
   * @param id <p>The ID of the attachment.</p>  (required)
   * @param restRequestInterceptor <p>Adds the possibility to modify the rest request before sending out. This can be useful to add authorizations tokens for example.</p>
   * @return Completable
   */
  public Completable removeAttachment(
    String id, Optional<RestRequestInterceptor> restRequestInterceptor) {

    RestRequest request = new RestRequest();
    request.method = HttpMethod.DELETE;
    request.basePath = DEFAULT_BASE_PATH;
    request.path = "/rest/api/3/attachment/{id}";
    if (id != null) {
      request.pathParams.put("id", String.valueOf(id));
    }
    
    if (restRequestInterceptor.isPresent()) {
      restRequestInterceptor.get().enhanceRestRequest(request);
    }

    return RestCallUtil.callEndpoint(httpClient, request);
  }

}
