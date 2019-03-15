package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class SlowDMAType implements QueryParam {
  private int type;

  private SlowDMAType(int slowDMAType) {
    this.type = slowDMAType;
  }

  @Override
  public String getName() {
    return "slowdmatype";
  }

  @Override
  public String getValue() {
    return String.valueOf(type);
  }

  /**
   * Method is used for instantiating new instance of {@link SlowDMAType}.
   *
   * @param slowDMAType {@link int}
   * @return {@link SlowDMAType}
   */
  public static SlowDMAType from(int slowDMAType) {
    if (slowDMAType < 0 || slowDMAType > 8) {
      throw new IllegalArgumentException("Only integers between 0 and 8 are accepted for more info visit https://www.alphavantage.co/documentation/");
    }
    return new SlowDMAType(slowDMAType);
  }
}
