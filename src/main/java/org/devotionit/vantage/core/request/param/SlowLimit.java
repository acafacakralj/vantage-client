package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitroivć
 */
@ToString
@EqualsAndHashCode
public class SlowLimit implements QueryParam {
  private float limit;

  private SlowLimit(float slowLimit) {
    this.limit = slowLimit;
  }

  @Override
  public String getName() {
    return "slowlimit";
  }

  @Override
  public String getValue() {
    return String.valueOf(limit);
  }

  /**
   * Method is used for instantiating new instance of {@link SlowLimit}.
   *
   * @param slowLimit {@link float}
   * @return {@link SlowLimit}
   */
  public static SlowLimit from(float slowLimit) {
    if (slowLimit < 0) {
      throw new IllegalArgumentException("Only positive floats are accepted.");
    }
    return new SlowLimit(slowLimit);
  }
}
