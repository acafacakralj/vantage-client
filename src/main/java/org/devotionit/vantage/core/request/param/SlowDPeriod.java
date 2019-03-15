package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class SlowDPeriod implements QueryParam {
  private int period;

  private SlowDPeriod(int slowDPeriod) {
    this.period = slowDPeriod;
  }

  @Override
  public String getName() {
    return "slowdperiod";
  }

  @Override
  public String getValue() {
    return String.valueOf(period);
  }

  /**
   * Method is used for instantiating new instance of {@link SlowDPeriod}.
   *
   * @param slowDPeriod {@link int}
   * @return {@link SlowDPeriod}
   */
  public static SlowDPeriod from(int slowDPeriod) {
    if (slowDPeriod < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new SlowDPeriod(slowDPeriod);
  }
}
