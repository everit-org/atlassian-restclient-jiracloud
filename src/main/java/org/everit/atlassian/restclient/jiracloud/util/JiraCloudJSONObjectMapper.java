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

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.everit.http.restclient.JSONObjectMapper;
import org.everit.http.restclient.TypeReference;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializerBase;

public class JiraCloudJSONObjectMapper implements JSONObjectMapper {

  /**
   * Helper class to be able to deserialize iso offset date time with millisecs.
   */
  private static class OffsetDateTimeDeserializer extends InstantDeserializer<OffsetDateTime> {

    private static final long serialVersionUID = 4935425608165819930L;

    /**
     * constructor.
     */
    OffsetDateTimeDeserializer() {
      super(
          OffsetDateTime.class,
          JiraCloudJSONObjectMapper.JIRA_CLOUD_DATETIME_FORMATTER,
          OffsetDateTime::from,
          a -> OffsetDateTime.ofInstant(Instant.ofEpochMilli(a.value), a.zoneId),
          a -> OffsetDateTime.ofInstant(Instant.ofEpochSecond(a.integer, a.fraction), a.zoneId),
          (d, z) -> d.withOffsetSameInstant(z.getRules().getOffset(d.toLocalDateTime())),
          false);

    }

    public OffsetDateTimeDeserializer(InstantDeserializer<OffsetDateTime> base,
        Boolean adjustToContextTimezoneOverride) {
      super(base, adjustToContextTimezoneOverride);
    }
  }

  private static class OffsetDateTimeSerializer extends InstantSerializerBase<OffsetDateTime> {

    private static final long serialVersionUID = 998887473102198507L;

    protected OffsetDateTimeSerializer() {
      super(OffsetDateTime.class, dt -> dt.toInstant().toEpochMilli(),
          OffsetDateTime::toEpochSecond, OffsetDateTime::getNano,
          JiraCloudJSONObjectMapper.JIRA_CLOUD_DATETIME_FORMATTER);
    }

    protected OffsetDateTimeSerializer(OffsetDateTimeSerializer base,
        Boolean useTimestamp, Boolean useNanoseconds, DateTimeFormatter formatter) {
      super(base, useTimestamp, useNanoseconds, formatter);
    }

    protected OffsetDateTimeSerializer(OffsetDateTimeSerializer base,
        Boolean useTimestamp, DateTimeFormatter formatter) {
      this(base, useTimestamp, null, JiraCloudJSONObjectMapper.JIRA_CLOUD_DATETIME_FORMATTER);
    }

    @Override
    protected OffsetDateTimeSerializer withFeatures(Boolean writeZoneId,
        Boolean writeNanoseconds) {
      return new OffsetDateTimeSerializer(this, false, false,
          JiraCloudJSONObjectMapper.JIRA_CLOUD_DATETIME_FORMATTER);
    }

    @Override
    protected OffsetDateTimeSerializer withFormat(Boolean useTimestamp,
        DateTimeFormatter formatter, JsonFormat.Shape shape) {
      return new OffsetDateTimeSerializer(this, false, formatter);
    }
  }

  private static class PreDefinedTypeReference<T>
      extends com.fasterxml.jackson.core.type.TypeReference<T> {

    private Type valueType;

    PreDefinedTypeReference(TypeReference<T> typeReference) {
      this.valueType = typeReference.getType();

    }

    @Override
    public Type getType() {
      return this.valueType;
    }
  }

  /**
   * An instance of {@link JSONObjectMapper} that works for Jira Cloud REST requests.
   */
  public static final JSONObjectMapper INSTANCE;

  /**
   * The date time formatter that can be used to convert date-time values to JSON representation of
   * Jira Cloud and vice versa. Example: 2000-01-01T11:11:25.123+0100
   */
  public static final DateTimeFormatter JIRA_CLOUD_DATETIME_FORMATTER;

  static {
    JIRA_CLOUD_DATETIME_FORMATTER =
        new DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
            .toFormatter();

    INSTANCE = new JiraCloudJSONObjectMapper();
  }

  private final ObjectMapper objectMapper;

  public JiraCloudJSONObjectMapper() {
    this.objectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    JavaTimeModule javaTimeModule = new JavaTimeModule();

    // We need this trick otherwise we would lose the zone from the offset date time
    javaTimeModule.addDeserializer(OffsetDateTime.class,
        new OffsetDateTimeDeserializer(new OffsetDateTimeDeserializer(), false));

    javaTimeModule.addSerializer(OffsetDateTime.class, new OffsetDateTimeSerializer());
    this.objectMapper.registerModule(javaTimeModule);
    this.objectMapper.registerModule(new Jdk8Module());
  }

  @Override
  public <T> T convertValue(Object fromValue, Class<T> toValueType) {
    return this.objectMapper.convertValue(fromValue, toValueType);
  }

  @Override
  public <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) {
    return this.objectMapper.convertValue(fromValue, new PreDefinedTypeReference<>(toValueTypeRef));
  }

  @Override
  public <T> T fromJSON(String json, Class<T> valueType) {
    try {
      return this.objectMapper.readValue(json, valueType);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  @Override
  public <T> T fromJSON(String json, TypeReference<T> valueTypeReference) {
    try {
      return this.objectMapper.readValue(json, new PreDefinedTypeReference<>(valueTypeReference));
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  @Override
  public String toJSON(Object object) {
    try {
      return this.objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

}
