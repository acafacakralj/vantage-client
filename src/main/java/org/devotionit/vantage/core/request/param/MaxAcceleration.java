package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitroivć
 */
@ToString
@EqualsAndHashCode
public class MaxAcceleration implements QueryParam {
  private float factor;

  private MaxAcceleration(float acceleration) {
    this.factor = acceleration;
  }

  @Override
  public String getName() {
    return "maximum";
  }

  @Override
  public String getValue() {
    return String.valueOf(factor);
  }

  /**
   * Method is used for instantiating new instance of {@link MaxAcceleration}.
   *
   * @param acceleration {@link float}
   * @return {@link MaxAcceleration}
   */
  public static MaxAcceleration from(float acceleration) {
    if (acceleration < 0) {
      throw new IllegalArgumentException("Only positive floats are accepted.");
    }
    return new MaxAcceleration(acceleration);
  }
}
