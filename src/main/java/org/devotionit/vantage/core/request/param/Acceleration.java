package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitroivć
 */
@ToString
@EqualsAndHashCode
public class Acceleration implements QueryParam {
  private float factor;

  private Acceleration(float acceleration) {
    this.factor = acceleration;
  }

  @Override
  public String getName() {
    return "acceleration";
  }

  @Override
  public String getValue() {
    return String.valueOf(factor);
  }

  /**
   * Method is used for instantiating new instance of {@link Acceleration}.
   *
   * @param acceleration {@link float}
   * @return {@link Acceleration}
   */
  public static Acceleration from(float acceleration) {
    if (acceleration < 0) {
      throw new IllegalArgumentException("Only positive floats are accepted.");
    }
    return new Acceleration(acceleration);
  }
}
