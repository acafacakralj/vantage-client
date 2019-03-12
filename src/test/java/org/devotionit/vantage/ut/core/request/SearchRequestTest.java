package org.devotionit.vantage.ut.core.request;

import org.devotionit.vantage.core.request.SearchRequest;
import org.devotionit.vantage.core.request.param.Keywords;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SearchRequestTest {
  @Test
  public void Should_CreateRequest_When_DataIsValid() {
    SearchRequest request = new SearchRequest(Keywords.from("BYN"));
    assertNotNull(request);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateRequest_When_KeywordsAreNull() {
    new SearchRequest(null);
  }
}
