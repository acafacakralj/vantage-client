package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.util.Objects.requireNonNull;

/**
 * Represents a three-letter symbol from the forex currency list to be converted in.
 *
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class ToSymbol implements QueryParam {
  private String symbol;

  private ToSymbol(String toSymbol) {
    this.symbol = requireNonNull(toSymbol, "Symbol can't be null.");
  }

  @Override
  public String getName() {
    return "to_symbol";
  }

  @Override
  public String getValue() {
    return symbol;
  }

  /**
   * Method is used for instantiating new instance of {@link ToSymbol}.
   *
   * @param toSymbol {@link String}
   * @return {@link ToSymbol}
   */
  public static ToSymbol from(String toSymbol) {
    return new ToSymbol(toSymbol);
  }
}
