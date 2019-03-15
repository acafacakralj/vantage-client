package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.*;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.ULTOSC;

/**
 * @author Strahinja Mitrović
 */
@Data
public class ULTOSCRequest extends IndicatorRequest {
  private Symbol symbol;
  private TimePeriod1 timePeriod1;
  private TimePeriod2 timePeriod2;
  private TimePeriod3 timePeriod3;

  @Builder
  public ULTOSCRequest(Interval interval, Symbol symbol, TimePeriod1 timePeriod1, TimePeriod2 timePeriod2, TimePeriod3 timePeriod3) {
    super(ULTOSC, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.timePeriod1 = timePeriod1;
    this.timePeriod2 = timePeriod2;
    this.timePeriod3 = timePeriod3;
  }
}
