package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.SeriesType;
import org.devotionit.vantage.core.request.param.Symbol;
import org.devotionit.vantage.core.request.param.TimePeriod;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.SMA;

/**
 * @author Strahinja Mitrović
 */
@Data
public class SMARequest extends IndicatorRequest {
  private Symbol symbol;
  private TimePeriod timePeriod;
  private SeriesType seriesType;

  @Builder
  public SMARequest(Interval interval, Symbol symbol, TimePeriod timePeriod, SeriesType seriesType) {
    super(SMA, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.timePeriod = requireNonNull(timePeriod, "TimePeriod can't be null.");
    this.seriesType = requireNonNull(seriesType, "SeriesType can't be null.");
  }
}
