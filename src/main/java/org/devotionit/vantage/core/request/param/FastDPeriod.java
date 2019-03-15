package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class FastDPeriod implements QueryParam {
  private int period;

  private FastDPeriod(int fastDPeriod) {
    this.period = fastDPeriod;
  }

  @Override
  public String getName() {
    return "fastdperiod";
  }

  @Override
  public String getValue() {
    return String.valueOf(period);
  }

  /**
   * Method is used for instantiating new instance of {@link FastDPeriod}.
   *
   * @param fastDPeriod {@link int}
   * @return {@link FastDPeriod}
   */
  public static FastDPeriod from(int fastDPeriod) {
    if (fastDPeriod < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new FastDPeriod(fastDPeriod);
  }
}
