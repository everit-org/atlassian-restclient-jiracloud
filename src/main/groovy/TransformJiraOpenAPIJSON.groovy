/**
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
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

// Changing class and function names

def classnameByTag = [:];
// def properties = ['openapi-file': 'src/main/resources/META-INF/jira-cloud-v3.openapi.json'];
def jsonText = new File(properties['openapi-file']).getText();
def json = new JsonSlurper().parseText(jsonText);
def paths = json['paths'];

paths.each { pathEntry ->
  pathEntry.value.each { methodEntry ->
    def tag = methodEntry.value['tags'][0];
    def operationId = methodEntry.value['operationId'];
    def underscoreIndex = operationId.lastIndexOf('_');
    def lastDotIndex = operationId.lastIndexOf('.');
    def classNameBeginIndex = operationId.lastIndexOf('.', lastDotIndex - 1);

    def className = operationId.substring(classNameBeginIndex + 1, lastDotIndex);
    if (className.endsWith('Resource')) {
      className = className.substring(0, className.length() - 8)
    }

    def functionName = operationId.substring(lastDotIndex + 1, underscoreIndex);

    classnameByTag.put(tag, className);
    methodEntry.value['tags'][0] = className;

    methodEntry.value['operationId'] = functionName;
  }
}

json['tags'].each { tag -> tag['name'] = classnameByTag[tag['name']] }

// Replacing commonmark language with html

def parser = Parser.builder().build();
def htmlRenderer = HtmlRenderer.builder().build();

json['tags'].each { tag ->
  def description = tag['description'];
  if (description != null) {
    tag['description'] = htmlRenderer.render(parser.parse(description));
  }
}


paths.each { pathEntry ->
  pathEntry.value.each { methodEntry ->
    def description =  methodEntry.value['description'];
    if (description != null) {
      methodEntry.value['description'] = htmlRenderer.render(parser.parse(description));
    }

    if (methodEntry.value.parameters != null) {
      methodEntry.value.parameters.each { parameter ->
        description =  parameter['description'];
        if (description != null) {
          parameter['description'] = htmlRenderer.render(parser.parse(description));
        }
      }
    }

    if (methodEntry.value.requestBody != null && methodEntry.value.requestBody.description != null) {
      methodEntry.value.requestBody.description = htmlRenderer.render(parser.parse(methodEntry.value.requestBody.description));
    }

    if (methodEntry.value.responses != null) {
      methodEntry.value.responses.each { responseEntry ->
        description =  responseEntry.value['description'];
        if (description != null) {
          responseEntry.value['description'] = htmlRenderer.render(parser.parse(description));
        }
      }
    }
  }
}

// Removing duplicates from enums

def removeIgnoreCaseDuplicatesFromList(stringList) {
  def iterator = stringList.iterator();
  def processedValues = new HashSet();
  while (iterator.hasNext()) {
    def value = iterator.next();
    if (value instanceof String && !processedValues.add(value.toUpperCase(Locale.ENGLISH))) {
      iterator.remove();
    }
  }
}

def removeNullValuesFromList(stringList) {
  def iterator = stringList.iterator();
  def processedValues = new HashSet();
  while (iterator.hasNext()) {
    def value = iterator.next();
    if (value == null) {
      iterator.remove();
    }
  }
}

def recursiveEnumSearch(currentNode) {
  if (currentNode instanceof java.util.Map) {
    currentNode.each { childEntry ->
      if (childEntry.key.equals('enum') && childEntry.value instanceof java.util.List) {
        removeIgnoreCaseDuplicatesFromList(childEntry.value);
        removeNullValuesFromList(childEntry.value);
      } else {
        recursiveEnumSearch(childEntry.value);
      }
    }
  } else if (currentNode instanceof java.util.List) {
    currentNode.each { child -> recursiveEnumSearch(child) }
  }
}

recursiveEnumSearch(json);

new File(properties['openapi-file']).setText(JsonOutput.toJson(json), 'UTF-8');