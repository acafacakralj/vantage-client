package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.*;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.BBANDS;

/**
 * @author Strahinja Mitrović
 */
@Data
public class BBANDSRequest extends IndicatorRequest {
  private Symbol symbol;
  private TimePeriod timePeriod;
  private SeriesType seriesType;
  private MAType maType;
  private NBDEVDn nbdevDn;
  private NBDEVUp nbdevUp;

  @Builder
  public BBANDSRequest(Interval interval, Symbol symbol, TimePeriod timePeriod, SeriesType seriesType, MAType maType, NBDEVDn nbdevDn, NBDEVUp nbdevUp) {
    super(BBANDS, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.timePeriod = requireNonNull(timePeriod, "TimePeriod can't be null.");
    this.seriesType = requireNonNull(seriesType, "SeriesType can't be null.");
    this.maType = maType;
    this.nbdevDn = nbdevDn;
    this.nbdevUp = nbdevUp;
  }
}
