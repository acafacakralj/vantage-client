package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.FastPeriod;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.SlowPeriod;
import org.devotionit.vantage.core.request.param.Symbol;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.ADOSC;

/**
 * @author Strahinja Mitrović
 */
@Data
public class ADOSCRequest extends IndicatorRequest {
  private Symbol symbol;
  private FastPeriod fastPeriod;
  private SlowPeriod slowPeriod;

  @Builder
  public ADOSCRequest(Interval interval, Symbol symbol, FastPeriod fastPeriod, SlowPeriod slowPeriod) {
    super(ADOSC, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.fastPeriod = fastPeriod;
    this.slowPeriod = slowPeriod;
  }
}
