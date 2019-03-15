package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.*;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.PPO;

/**
 * @author Strahinja Mitrović
 */
@Data
public class PPORequest extends IndicatorRequest {
  private Symbol symbol;
  private SeriesType seriesType;
  private FastPeriod fastPeriod;
  private SlowPeriod slowPeriod;
  private MAType maType;

  @Builder
  public PPORequest(Interval interval, Symbol symbol, SeriesType seriesType, FastPeriod fastPeriod, SlowPeriod slowPeriod, MAType maType) {
    super(PPO, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.seriesType = requireNonNull(seriesType, "SeriesType can't be null.");
    this.fastPeriod = fastPeriod;
    this.slowPeriod = slowPeriod;
    this.maType = maType;
  }
}
