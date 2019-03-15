package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.Symbol;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.BOP;

/**
 * @author Strahinja Mitrović
 */
@Data
public class BOPRequest extends IndicatorRequest {
  private Symbol symbol;

  @Builder
  public BOPRequest(Interval interval, Symbol symbol) {
    super(BOP, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
  }
}
