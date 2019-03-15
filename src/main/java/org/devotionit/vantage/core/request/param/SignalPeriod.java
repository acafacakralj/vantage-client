package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class SignalPeriod implements QueryParam {
  private final int period;

  private SignalPeriod(int period) {
    this.period = period;
  }

  @Override
  public String getName() {
    return "signalperiod";
  }

  @Override
  public String getValue() {
    return String.valueOf(period);
  }

  /**
   * Method is used for instantiating new instance of {@link SignalPeriod}.
   *
   * @param signalPeriod {@link int}
   * @return {@link SignalPeriod}
   */
  public static SignalPeriod from(int signalPeriod) {
    if (signalPeriod < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new SignalPeriod(signalPeriod);
  }
}
