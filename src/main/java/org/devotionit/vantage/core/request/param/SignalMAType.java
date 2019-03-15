package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class SignalMAType implements QueryParam {
  private int type;

  private SignalMAType(int signalMAType) {
    this.type = signalMAType;
  }

  @Override
  public String getName() {
    return "signalmatype";
  }

  @Override
  public String getValue() {
    return String.valueOf(type);
  }

  /**
   * Method is used for instantiating new instance of {@link SignalMAType}.
   *
   * @param signalMAType {@link int}
   * @return {@link SignalMAType}
   */
  public static SignalMAType from(int signalMAType) {
    if (signalMAType < 0 || signalMAType > 8) {
      throw new IllegalArgumentException("Only integers between 0 and 8 are accepted for more info visit https://www.alphavantage.co/documentation/");
    }
    return new SignalMAType(signalMAType);
  }
}
