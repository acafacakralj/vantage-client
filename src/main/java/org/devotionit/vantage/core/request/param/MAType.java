package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class MAType implements QueryParam {
  private int type;

  private MAType(int maType) {
    this.type = maType;
  }

  @Override
  public String getName() {
    return "matype";
  }

  @Override
  public String getValue() {
    return String.valueOf(type);
  }

  /**
   * Method is used for instantiating new instance of {@link MAType}.
   *
   * @param maType {@link int}
   * @return {@link MAType}
   */
  public static MAType from(int maType) {
    if (maType < 0 || maType > 8) {
      throw new IllegalArgumentException("Only integers between 0 and 8 are accepted for more info visit https://www.alphavantage.co/documentation/");
    }
    return new MAType(maType);
  }
}
