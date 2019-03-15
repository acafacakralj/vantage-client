package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class SlowMAType implements QueryParam {
  private int type;

  private SlowMAType(int slowMAType) {
    this.type = slowMAType;
  }

  @Override
  public String getName() {
    return "slowmatype";
  }

  @Override
  public String getValue() {
    return String.valueOf(type);
  }

  /**
   * Method is used for instantiating new instance of {@link SlowMAType}.
   *
   * @param slowMAType {@link int}
   * @return {@link SlowMAType}
   */
  public static SlowMAType from(int slowMAType) {
    if (slowMAType < 0 || slowMAType > 8) {
      throw new IllegalArgumentException("Only integers between 0 and 8 are accepted for more info visit https://www.alphavantage.co/documentation/");
    }
    return new SlowMAType(slowMAType);
  }
}
