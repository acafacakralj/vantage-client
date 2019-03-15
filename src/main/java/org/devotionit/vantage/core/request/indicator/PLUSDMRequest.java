package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.Symbol;
import org.devotionit.vantage.core.request.param.TimePeriod;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.PLUS_DM;

/**
 * @author Strahinja Mitrović
 */
@Data
public class PLUSDMRequest extends IndicatorRequest {
  private Symbol symbol;
  private TimePeriod timePeriod;

  @Builder
  public PLUSDMRequest(Interval interval, Symbol symbol, TimePeriod timePeriod) {
    super(PLUS_DM, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.timePeriod = requireNonNull(timePeriod, "TimePeriod can't be null.");
  }
}
