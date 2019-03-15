package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class FastMAType implements QueryParam {
  private int type;

  private FastMAType(int fastMAType) {
    this.type = fastMAType;
  }

  @Override
  public String getName() {
    return "fastmatype";
  }

  @Override
  public String getValue() {
    return String.valueOf(type);
  }

  /**
   * Method is used for instantiating new instance of {@link FastMAType}.
   *
   * @param fastMAType {@link int}
   * @return {@link FastMAType}
   */
  public static FastMAType from(int fastMAType) {
    if (fastMAType < 0 || fastMAType > 8) {
      throw new IllegalArgumentException("Only integers between 0 and 8 are accepted for more info visit https://www.alphavantage.co/documentation/");
    }
    return new FastMAType(fastMAType);
  }
}
