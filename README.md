atlassian-restclient-jiracloud
==============================

Asynchronous REST client for Jira Cloud written in Java.

## Introduction

The goal of this library to have an asynchronous, typesafe and independent
library for Atlassian Jira Cloud.

## Usage

    // Create a HTTPClient instance (currently Jetty Client is supported
    // as it is non-blocking
    HttpClient httpClient = ...
    
    // Create a Rest Client instance. This instance will have the right
    // ObjectMapper inside, so conversion of date-times should be OK.
    RestClient restClient =
        JiraCloudRestClientFactory.createRestClient(httpClient);
    
    // Create a reusable API instance. E.g.:
    VersionApi versionApi = new VersionApi(restClient);
    
    // If needed, create a RestRequstEnhancer. Such enhancer can be
    // used to attach an act-as-user or a call-as-addon token to the
    // request, or replace the basePath to the URL of the Jira Cloud
    // instance of the client.
    RestRequestEnhancer enhancer = ...
    
    // Call any function on the created API
    Single<Version> versionSingle = versionApi.getVersion(id,
        Optional.empty(), Optional.of(enhancer));
    
    // Use the functions of RXJava Single to receive the version synchronously
    // or asynchronously. E.g.:
    single.subscribe(version -> {...}, error -> {...});

## Handling errors

In case of the response arrives back, but the status is >= 400, a
RestException is passed to the error handler of Single. RestException
contains the status and the body of the response as String if available.

## See also

- Documentation of [Everit HTTP Client][0] library
- Additional libraries that help creating RestRequestEnhancers for the
  different Jira Clients having basePath modification, act-as-user or
  call-as-addon authentication tokens. _(coming soon)_

[0]: https://github.com/everit-org/everit-httpclient
