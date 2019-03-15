package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.Symbol;
import org.devotionit.vantage.core.request.param.TimePeriod;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.NATR;

/**
 * @author Strahinja Mitrović
 */
@Data
public class NATRRequest extends IndicatorRequest {
  private Symbol symbol;
  private TimePeriod timePeriod;

  @Builder
  public NATRRequest(Interval interval, Symbol symbol, TimePeriod timePeriod) {
    super(NATR, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.timePeriod = requireNonNull(timePeriod, "TimePeriod can't be null.");
  }
}
