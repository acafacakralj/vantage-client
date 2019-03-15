package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.Symbol;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.AD;

/**
 * @author Strahinja Mitrović
 */
@Data
public class ADRequest extends IndicatorRequest {
  private Symbol symbol;

  @Builder
  public ADRequest(Interval interval, Symbol symbol) {
    super(AD, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
  }
}
