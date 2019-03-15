package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.Symbol;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.VWAP;

/**
 * @author Strahinja Mitrović
 */
@Data
public class VWAPRequest extends IndicatorRequest {
  private Symbol symbol;

  @Builder
  public VWAPRequest(Interval interval, Symbol symbol) {
    super(VWAP, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
  }
}
