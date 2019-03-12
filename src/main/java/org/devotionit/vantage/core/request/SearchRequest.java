package org.devotionit.vantage.core.request;

import lombok.*;
import org.devotionit.vantage.core.request.param.Keywords;
import org.devotionit.vantage.core.response.SearchResponse;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.SYMBOL_SEARCH;


/**
 * Represents a request for retrieving best-matching symbols and market
 * information based on keywords from alpha vantage. Class is an extension
 * of {@link ApiRequest< SearchResponse >} class.
 *
 * @author Strahinja Mitrović
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SearchRequest extends ApiRequest<SearchResponse> {
  private Keywords keywords;

  @Builder
  public SearchRequest(Keywords keywords) {
    super(SYMBOL_SEARCH, null);
    this.keywords = requireNonNull(keywords, "Keywords can't be null.");
  }
}
