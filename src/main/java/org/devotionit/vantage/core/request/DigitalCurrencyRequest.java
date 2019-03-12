package org.devotionit.vantage.core.request;

import lombok.*;
import org.devotionit.vantage.core.request.param.Function;
import org.devotionit.vantage.core.request.param.Market;
import org.devotionit.vantage.core.request.param.OutputSize;
import org.devotionit.vantage.core.request.param.Symbol;
import org.devotionit.vantage.core.response.DigitalCurrencyResponse;
import org.devotionit.vantage.core.response.ExchangeRateResponse;

import static java.util.Objects.requireNonNull;

/**
 * Represents a request for retrieving daily historical time series for a
 * digital currency (e.g., BTC) traded on a specific market (e.g., CNY/Chinese Yuan),
 * refreshed daily at midnight (UTC) from alpha vantage. Class is an extension
 * of {@link ApiRequest<  ExchangeRateResponse  >} class.
 *
 * @author Strahinja Mitrović
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DigitalCurrencyRequest extends ApiRequest<DigitalCurrencyResponse> {
  private final Symbol symbol;
  private final Market market;

  @Builder
  public DigitalCurrencyRequest(Function function, OutputSize outputSize, Symbol symbol, Market market) {
    super(function, outputSize);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.market = requireNonNull(market, "Market can't be null.");
  }
}
