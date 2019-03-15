package org.devotionit.vantage.core.request.indicator;

import lombok.Builder;
import lombok.Data;
import org.devotionit.vantage.core.request.param.*;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.STOCHRSI;

/**
 * @author Strahinja Mitrović
 */
@Data
public class STOCHRSIRequest extends IndicatorRequest {
  private Symbol symbol;
  private TimePeriod timePeriod;
  private SeriesType seriesType;
  private FastKPeriod fastKPeriod;
  private FastDPeriod fastDPeriod;
  private FastDMAType fastDMAType;

  @Builder
  public STOCHRSIRequest(Interval interval, Symbol symbol, TimePeriod timePeriod, SeriesType seriesType, FastKPeriod fastKPeriod, FastDPeriod fastDPeriod, FastDMAType fastDMAType) {
    super(STOCHRSI, interval);
    this.symbol = requireNonNull(symbol, "Symbol can't be null.");
    this.timePeriod = requireNonNull(timePeriod, "TimePeriod can't be null.");
    this.seriesType = requireNonNull(seriesType, "SeriesType can't be null.");
    this.fastKPeriod = fastKPeriod;
    this.fastDPeriod = fastDPeriod;
    this.fastDMAType = fastDMAType;
  }
}
