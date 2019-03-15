package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class NBDEVDn implements QueryParam {
  private int multiplier;

  private NBDEVDn(int nbdevdn) {
    this.multiplier = nbdevdn;
  }

  @Override
  public String getName() {
    return "nbdevdn";
  }

  @Override
  public String getValue() {
    return String.valueOf(multiplier);
  }

  /**
   * Method is used for instantiating new instance of {@link NBDEVDn}.
   *
   * @param nbdevdn {@link int}
   * @return {@link NBDEVDn}
   */
  public static NBDEVDn from(int nbdevdn) {
    if (nbdevdn < 0) {
      throw new IllegalArgumentException("Only positive integers are accepted.");
    }
    return new NBDEVDn(nbdevdn);
  }
}
