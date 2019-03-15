package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Acceleration;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.MaxAcceleration;
import org.devotionit.vantage.core.request.param.Symbol;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.SAR;

/**
 * @author Strahinja Mitrović
 */
@Data
public class SARRequest extends IndicatorRequest {
  private Symbol symbol;
  private Acceleration acceleration;
  private MaxAcceleration maxAcceleration;

  @Builder
  public SARRequest(Interval interval, Symbol symbol, Acceleration acceleration, MaxAcceleration maxAcceleration) {
    super(SAR, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.acceleration = acceleration;
    this.maxAcceleration = maxAcceleration;
  }
}
