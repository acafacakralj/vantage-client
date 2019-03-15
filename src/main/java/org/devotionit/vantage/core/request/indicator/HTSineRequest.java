package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.SeriesType;
import org.devotionit.vantage.core.request.param.Symbol;
import org.devotionit.vantage.core.request.param.TimePeriod;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.HT_SINE;

/**
 * @author Strahinja Mitrović
 */
@Data
public class HTSineRequest extends IndicatorRequest {
  private Symbol symbol;
  private SeriesType seriesType;

  @Builder
  public HTSineRequest(Interval interval, Symbol symbol, TimePeriod timePeriod, SeriesType seriesType) {
    super(HT_SINE, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.seriesType = requireNonNull(seriesType, "SeriesType can't be null.");
  }
}
