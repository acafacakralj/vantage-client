package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class NBDEVUp implements QueryParam {
  private int multiplier;

  private NBDEVUp(int nbdevup) {
    this.multiplier = nbdevup;
  }

  @Override
  public String getName() {
    return "nbdevup";
  }

  @Override
  public String getValue() {
    return String.valueOf(multiplier);
  }

  /**
   * Method is used for instantiating new instance of {@link NBDEVUp}.
   *
   * @param nbdevup {@link int}
   * @return {@link NBDEVUp}
   */
  public static NBDEVUp from(int nbdevup) {
    if (nbdevup < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new NBDEVUp(nbdevup);
  }
}
