package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.Symbol;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.SAR;
import static org.devotionit.vantage.core.request.param.Function.TRANGE;

/**
 * @author Strahinja Mitrović
 */
@Data
public class TRANGERequest extends IndicatorRequest {
  private Symbol symbol;

  @Builder
  public TRANGERequest(Interval interval, Symbol symbol) {
    super(TRANGE, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
  }
}
