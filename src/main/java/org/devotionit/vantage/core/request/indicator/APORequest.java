package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.*;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.APO;

/**
 * @author Strahinja Mitrović
 */
@Data
public class APORequest extends IndicatorRequest {
  private Symbol symbol;
  private TimePeriod timePeriod;
  private SeriesType seriesType;
  private FastPeriod fastPeriod;
  private SlowPeriod slowPeriod;
  private MAType maType;

  @Builder
  public APORequest(Interval interval, Symbol symbol, TimePeriod timePeriod, SeriesType seriesType, FastPeriod fastPeriod, SlowPeriod slowPeriod, MAType maType) {
    super(APO, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.timePeriod = requireNonNull(timePeriod, "TimePeriod can't be null.");
    this.seriesType = requireNonNull(seriesType, "SeriesType can't be null.");
    this.fastPeriod = fastPeriod;
    this.slowPeriod = slowPeriod;
    this.maType = maType;
  }
}
