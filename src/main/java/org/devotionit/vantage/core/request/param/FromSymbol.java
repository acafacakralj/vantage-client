package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.util.Objects.requireNonNull;

/**
 * Represents a three-letter symbol from the forex currency list
 * which is the base of the conversion.
 *
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class FromSymbol implements QueryParam {
  private String symbol;

  private FromSymbol(String fromSymbol) {
    this.symbol = requireNonNull(fromSymbol, "Symbol can't be null.");
  }

  @Override
  public String getName() {
    return "from_symbol";
  }

  @Override
  public String getValue() {
    return symbol;
  }

  /**
   * Method is used for instantiating new instance of {@link FromSymbol}.
   *
   * @param fromSymbol {@link String}
   * @return {@link FromSymbol}
   */
  public static FromSymbol from(String fromSymbol) {
    return new FromSymbol(fromSymbol);
  }
}
