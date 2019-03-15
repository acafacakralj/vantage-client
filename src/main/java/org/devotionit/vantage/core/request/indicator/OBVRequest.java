package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.Symbol;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.OBV;

/**
 * @author Strahinja Mitrović
 */
@Data
public class OBVRequest extends IndicatorRequest {
  private Symbol symbol;

  @Builder
  public OBVRequest(Interval interval, Symbol symbol) {
    super(OBV, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
  }
}
