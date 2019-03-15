package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents the number of searchData points used to
 * calculate each moving average value.
 *
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class TimePeriod implements QueryParam {
  private int period;

  private TimePeriod(int timePeriod) {
    this.period = timePeriod;
  }

  @Override
  public String getName() {
    return "time_period";
  }

  @Override
  public String getValue() {
    return String.valueOf(period);
  }

  /**
   * Method is used for instantiating new instance of {@link TimePeriod}.
   *
   * @param timePeriod {@link int}
   * @return {@link TimePeriod}
   */
  public static TimePeriod from(int timePeriod) {
    if (timePeriod < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new TimePeriod(timePeriod);
  }
}
