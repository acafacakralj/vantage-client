package org.devotionit.vantage.core.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.devotionit.vantage.core.request.param.Symbol;
import org.devotionit.vantage.core.response.QuoteResponse;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.GLOBAL_QUOTE;

/**
 * Represents a request for retrieving latest price and volume information from alpha vantage.
 * Class is an extension of {@link ApiRequest< QuoteResponse >} class.
 *
 * @author Strahinja Mitrović
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class QuoteRequest extends ApiRequest<QuoteResponse> {
  private Symbol symbol;

  public QuoteRequest(Symbol symbol) {
    super(GLOBAL_QUOTE, null);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
  }
}
