package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.*;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.STOCH;

/**
 * @author Strahinja Mitrović
 */
@Data
public class STOCHRequest extends IndicatorRequest {
  private Symbol symbol;
  private FastKPeriod fastKPeriod;
  private SlowKPeriod slowKPeriod;
  private SlowDPeriod slowDPeriod;
  private SlowMAType slowMAType;
  private SlowDMAType slowDMAType;

  @Builder
  public STOCHRequest(Interval interval, Symbol symbol, FastKPeriod fastKPeriod, SlowKPeriod slowKPeriod, SlowDPeriod slowDPeriod, SlowMAType slowMAType, SlowDMAType slowDMAType) {
    super(STOCH, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.fastKPeriod = fastKPeriod;
    this.slowKPeriod = slowKPeriod;
    this.slowDPeriod = slowDPeriod;
    this.slowMAType = slowMAType;
    this.slowDMAType = slowDMAType;
  }
}
