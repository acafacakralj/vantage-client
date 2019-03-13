package org.devotionit.vantage.ut.core.parser;

import org.devotionit.vantage.core.parser.JsonPaser;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class JsonParserTest {
  @Test
  public void Should_CreateObjectMapper() {
    assertNotNull(JsonPaser.getInstance());
  }
}
