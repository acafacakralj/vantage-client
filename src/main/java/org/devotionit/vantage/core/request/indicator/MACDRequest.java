package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.*;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.MACD;

/**
 * @author Strahinja Mitrović
 */
@Data
public class MACDRequest extends IndicatorRequest {
  private Symbol symbol;
  private SeriesType seriesType;
  private FastPeriod fastPeriod;
  private SlowPeriod slowPeriod;
  private SignalPeriod signalPeriod;

  @Builder
  public MACDRequest(Interval interval, Symbol symbol, SeriesType seriesType, FastPeriod fastPeriod, SlowPeriod slowPeriod, SignalPeriod signalPeriod) {
    super(MACD, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.seriesType = requireNonNull(seriesType, "SeriesType can't be null.");
    this.fastPeriod = fastPeriod;
    this.slowPeriod = slowPeriod;
    this.signalPeriod = signalPeriod;
  }
}
