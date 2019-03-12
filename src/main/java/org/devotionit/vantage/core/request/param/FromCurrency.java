package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.util.Objects.requireNonNull;

/**
 * Represents the currency which is the base of the conversion.
 *
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class FromCurrency implements QueryParam {
  private final String currency;

  private FromCurrency(String fromCurrency) {
    this.currency = requireNonNull(fromCurrency, "Currency can't be null.");
  }

  @Override
  public String getName() {
    return "from_currency";
  }

  @Override
  public String getValue() {
    return currency;
  }

  /**
   * Method is used for instantiating new instance of {@link FromCurrency}.
   *
   * @param fromCurrency {@link String}
   * @return {@link FromCurrency}
   */
  public static FromCurrency from(String fromCurrency) {
    return new FromCurrency(fromCurrency);
  }
}
