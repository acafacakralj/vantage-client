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
public class TimePeriod1 implements QueryParam {
  private int period;

  private TimePeriod1(int timePeriod) {
    this.period = timePeriod;
  }

  @Override
  public String getName() {
    return "timeperiod1";
  }

  @Override
  public String getValue() {
    return String.valueOf(period);
  }

  /**
   * Method is used for instantiating new instance of {@link TimePeriod1}.
   *
   * @param timePeriod {@link int}
   * @return {@link TimePeriod1}
   */
  public static TimePeriod1 from(int timePeriod) {
    if (timePeriod < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new TimePeriod1(timePeriod);
  }
}
