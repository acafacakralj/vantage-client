package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.util.Objects.requireNonNull;

/**
 * Represents the currency to be converted in.
 *
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class ToCurrency implements QueryParam {
  private String currency;

  private ToCurrency(String toCurrency) {
    this.currency = requireNonNull(toCurrency, "Currency can't be null.");
  }

  @Override
  public String getName() {
    return "to_currency";
  }

  @Override
  public String getValue() {
    return currency;
  }

  /**
   * Method is used for instantiating new instance of {@link ToCurrency}.
   *
   * @param toCurrency {@link String}
   * @return {@link ToCurrency}
   */
  public static ToCurrency from(String toCurrency) {
    return new ToCurrency(toCurrency);
  }
}
