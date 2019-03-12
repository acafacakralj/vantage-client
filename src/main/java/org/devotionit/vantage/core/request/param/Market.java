package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.util.Objects.requireNonNull;

/**
 * Represents exchange market parameter for alpha vantage api.
 *
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class Market implements QueryParam {
  private String symbol;

  private Market(String symbol) {
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
  }

  @Override
  public String getName() {
    return "market";
  }

  @Override
  public String getValue() {
    return symbol;
  }

  /**
   * Method is used for instantiating new instance of {@link Market}.
   *
   * @param market {@link String}
   * @return {@link Market}
   */
  public static Market from(String market) {
    return new Market(market);
  }
}
