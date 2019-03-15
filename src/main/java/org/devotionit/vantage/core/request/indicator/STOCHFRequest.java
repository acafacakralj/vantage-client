package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.*;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.STOCHF;

/**
 * @author Strahinja Mitrović
 */
@Data
public class STOCHFRequest extends IndicatorRequest {
  private Symbol symbol;
  private FastKPeriod fastKPeriod;
  private FastDPeriod fastDPeriod;
  private FastDMAType fastDMAType;

  @Builder
  public STOCHFRequest(Interval interval, Symbol symbol, FastKPeriod fastKPeriod, FastDPeriod fastDPeriod, FastDMAType fastDMAType) {
    super(STOCHF, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.fastKPeriod = fastKPeriod;
    this.fastDPeriod = fastDPeriod;
    this.fastDMAType = fastDMAType;
  }
}
