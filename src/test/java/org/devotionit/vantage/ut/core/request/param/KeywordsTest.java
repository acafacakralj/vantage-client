package org.devotionit.vantage.ut.core.request.param;

import org.devotionit.vantage.core.request.param.Keywords;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class KeywordsTest {
  @Test
  public void Should_CreateKeywords_When_DataIsValid() {
    Keywords keywords = Keywords.from("BYC");
    assertNotNull(keywords);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateKeywords_When_DataIsNull() {
    Keywords.from(null);
  }

  @Test
  public void Should_ReturnKeywordsQueryParamName() {
    Keywords keywords = Keywords.from("BA");
    assertNotNull(keywords);
    assertEquals("keywords", keywords.getName());
  }

  @Test
  public void Should_ReturnKeywordsQueryParamValue() {
    String testData = "BYC";
    Keywords keywords = Keywords.from(testData);
    assertNotNull(keywords);
    assertEquals(keywords.getValue(), testData);
  }
}
