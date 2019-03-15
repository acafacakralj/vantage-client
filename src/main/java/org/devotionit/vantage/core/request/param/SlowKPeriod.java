package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class SlowKPeriod implements QueryParam {
  private int period;

  private SlowKPeriod(int slowKPeriod) {
    this.period = slowKPeriod;
  }

  @Override
  public String getName() {
    return "slowkperiod";
  }

  @Override
  public String getValue() {
    return String.valueOf(period);
  }

  /**
   * Method is used for instantiating new instance of {@link SlowKPeriod}.
   *
   * @param slowKPeriod {@link int}
   * @return {@link SlowKPeriod}
   */
  public static SlowKPeriod from(int slowKPeriod) {
    if (slowKPeriod < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new SlowKPeriod(slowKPeriod);
  }
}
