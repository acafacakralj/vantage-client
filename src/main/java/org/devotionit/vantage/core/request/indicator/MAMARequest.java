package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.request.param.SeriesType;
import org.devotionit.vantage.core.request.param.Symbol;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.MAMA;

/**
 * @author Strahinja Mitrović
 */
@Data
public class MAMARequest extends IndicatorRequest {
  private Symbol symbol;
  private SeriesType seriesType;

  @Builder
  public MAMARequest(Interval interval, Symbol symbol, SeriesType seriesType) {
    super(MAMA, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.seriesType = requireNonNull(seriesType, "SeriesType can't be null.");
  }
}
