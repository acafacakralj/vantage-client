package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitroivć
 */
@ToString
@EqualsAndHashCode
public class FastLimit implements QueryParam {
  private float limit;

  private FastLimit(float fastLimit) {
    this.limit = fastLimit;
  }

  @Override
  public String getName() {
    return "fastlimit";
  }

  @Override
  public String getValue() {
    return String.valueOf(limit);
  }

  /**
   * Method is used for instantiating new instance of {@link FastLimit}.
   *
   * @param fastLimit {@link float}
   * @return {@link FastLimit}
   */
  public static FastLimit from(float fastLimit) {
    if (fastLimit < 0) {
      throw new IllegalArgumentException("Only positive floats are accepted.");
    }
    return new FastLimit(fastLimit);
  }
}
