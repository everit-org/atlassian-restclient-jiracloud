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
package org.everit.atlassian.restclient.jiracloud.util;

import org.everit.http.client.HttpClient;
import org.everit.http.restclient.RestClient;

/**
 * Factory class to create new {@link RestClient} instance to be used with any of the Api classes.
 */
public class JiraCloudRestClientFactory {

  /**
   * Creates the standard rest client to be used with the api classes.
   *
   * @param httpClient
   *          The http client implementation to be used during rest calls.
   * @return The instantiated rest client.
   */
  public static RestClient createRestClient(HttpClient httpClient) {
    return new RestClient(httpClient, JiraCloudJSONObjectMapper.INSTANCE);
  }
}
