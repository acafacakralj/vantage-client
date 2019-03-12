package org.devotionit.vantage.core.request;

import lombok.*;
import org.devotionit.vantage.core.request.param.FromCurrency;
import org.devotionit.vantage.core.request.param.ToCurrency;
import org.devotionit.vantage.core.response.ExchangeRateResponse;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.CURRENCY_EXCHANGE_RATE;

/**
 * Represents a request for retrieving realtime exchange rate for
 * any pair of digital currency (e.g., Bitcoin) or physical currency
 * from alpha vantage. Class is an extension of {@link ApiRequest<  ExchangeRateResponse  >} class.
 *
 * @author Strahinja Mitrović
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ExchangeRateRequest extends ApiRequest<ExchangeRateResponse> {
  private final FromCurrency fromCurrency;
  private final ToCurrency toCurrency;

  @Builder
  public ExchangeRateRequest(FromCurrency fromCurrency, ToCurrency toCurrency) {
    super(CURRENCY_EXCHANGE_RATE, null);
    this.fromCurrency = requireNonNull(fromCurrency, "FromCurrency can't be null.");
    this.toCurrency = requireNonNull(toCurrency, "ToCurrency can't be null.");
  }
}
