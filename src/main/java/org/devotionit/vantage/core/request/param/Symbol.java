package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

/**
 * Represents symbol parameter for alpha vantage api.
 *
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class Symbol implements QueryParam {
  private String value;

  private Symbol(String symbol) {
    this.value = Objects.requireNonNull(symbol, "Symbol can't be null.");
  }

  @Override
  public String getName() {
    return "symbol";
  }

  @Override
  public String getValue() {
    return value;
  }

  /**
   * Method is used for instantiating new instance of {@link Symbol}.
   *
   * @param symbol {@link String}
   * @return {@link Symbol}
   */
  public static Symbol from(String symbol) {
    return new Symbol(symbol);
  }
}
