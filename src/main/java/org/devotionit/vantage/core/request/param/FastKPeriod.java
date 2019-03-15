package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class FastKPeriod implements QueryParam {
  private int period;

  private FastKPeriod(int fastKPeriod) {
    this.period = fastKPeriod;
  }

  @Override
  public String getName() {
    return "fastkperiod";
  }

  @Override
  public String getValue() {
    return String.valueOf(period);
  }

  /**
   * Method is used for instantiating new instance of {@link FastKPeriod}.
   *
   * @param fastKPeriod {@link int}
   * @return {@link FastKPeriod}
   */
  public static FastKPeriod from(int fastKPeriod) {
    if (fastKPeriod < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new FastKPeriod(fastKPeriod);
  }
}
