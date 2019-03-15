package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class SlowPeriod implements QueryParam {
  private int period;

  private SlowPeriod(int slowPeriod) {
    this.period = slowPeriod;
  }

  @Override
  public String getName() {
    return "slowperiod";
  }

  @Override
  public String getValue() {
    return String.valueOf(period);
  }

  /**
   * Method is used for instantiating new instance of {@link SlowPeriod}.
   *
   * @param slowPeriod {@link int}
   * @return {@link SlowPeriod}
   */
  public static SlowPeriod from(int slowPeriod) {
    if (slowPeriod < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new SlowPeriod(slowPeriod);
  }
}
