package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class FastDMAType implements QueryParam {
  private int type;

  private FastDMAType(int fastDMAType) {
    this.type = fastDMAType;
  }

  @Override
  public String getName() {
    return "fastdmatype";
  }

  @Override
  public String getValue() {
    return String.valueOf(type);
  }

  /**
   * Method is used for instantiating new instance of {@link FastDMAType}.
   *
   * @param fastDMAType {@link int}
   * @return {@link FastDMAType}
   */
  public static FastDMAType from(int fastDMAType) {
    if (fastDMAType < 0 || fastDMAType > 8) {
      throw new IllegalArgumentException("Only integers between 0 and 8 are accepted for more info visit https://www.alphavantage.co/documentation/");
    }
    return new FastDMAType(fastDMAType);
  }
}
