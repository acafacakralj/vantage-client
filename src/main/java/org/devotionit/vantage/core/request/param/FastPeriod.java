package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class FastPeriod implements QueryParam {
  private int period;

  private FastPeriod(int fastPeriod) {
    this.period = fastPeriod;
  }

  @Override
  public String getName() {
    return "fastperiod";
  }

  @Override
  public String getValue() {
    return String.valueOf(period);
  }

  /**
   * Method is used for instantiating new instance of {@link FastPeriod}.
   *
   * @param fastPeriod {@link int}
   * @return {@link FastPeriod}
   */
  public static FastPeriod from(int fastPeriod) {
    if (fastPeriod < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new FastPeriod(fastPeriod);
  }
}
