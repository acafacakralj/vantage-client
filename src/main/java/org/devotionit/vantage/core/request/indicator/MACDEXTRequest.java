package org.devotionit.vantage.core.request.indicator;

import lombok.Data;
import org.devotionit.vantage.core.request.param.*;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.Function.MACDEXT;

/**
 * @author Strahinja Mitrović
 */
@Data
public class MACDEXTRequest extends IndicatorRequest {
  private Symbol symbol;
  private SeriesType seriesType;
  private FastPeriod fastPeriod;
  private SlowPeriod slowPeriod;
  private SignalPeriod signalPeriod;
  private SignalMAType signalMAType;
  private SlowMAType slowMAType;
  private FastMAType fastMAType;

  public MACDEXTRequest(MACDEXTRequestBuilder builder) {
    super(MACDEXT, builder.interval);
    this.symbol = requireNonNull(builder.symbol, "Symbol can't be null.");
    this.seriesType = requireNonNull(builder.seriesType, "SeriesType can't be null.");
    this.fastPeriod = builder.fastPeriod;
    this.slowPeriod = builder.slowPeriod;
    this.signalPeriod = builder.signalPeriod;
    this.signalMAType = builder.signalMAType;
    this.slowMAType = builder.slowMAType;
    this.fastMAType = builder.fastMAType;
  }

  public static MACDEXTRequestBuilder builder() {
    return new MACDEXTRequestBuilder();
  }


  public static class MACDEXTRequestBuilder {
    private Interval interval;
    private Symbol symbol;
    private SeriesType seriesType;
    private FastPeriod fastPeriod;
    private SlowPeriod slowPeriod;
    private SignalPeriod signalPeriod;
    private SignalMAType signalMAType;
    private SlowMAType slowMAType;
    private FastMAType fastMAType;

    MACDEXTRequestBuilder() {
    }

    public MACDEXTRequestBuilder interval(Interval interval) {
      this.interval = interval;
      return this;
    }

    public MACDEXTRequestBuilder symbol(Symbol symbol) {
      this.symbol = symbol;
      return this;
    }

    public MACDEXTRequestBuilder seriesType(SeriesType seriesType) {
      this.seriesType = seriesType;
      return this;
    }

    public MACDEXTRequestBuilder fastPeriod(FastPeriod fastPeriod) {
      this.fastPeriod = fastPeriod;
      return this;
    }

    public MACDEXTRequestBuilder slowPeriod(SlowPeriod slowPeriod) {
      this.slowPeriod = slowPeriod;
      return this;
    }

    public MACDEXTRequestBuilder signalPeriod(SignalPeriod signalPeriod) {
      this.signalPeriod = signalPeriod;
      return this;
    }

    public MACDEXTRequestBuilder signalMAType(SignalMAType signalMAType) {
      this.signalMAType = signalMAType;
      return this;
    }

    public MACDEXTRequestBuilder slowMAType(SlowMAType slowMAType) {
      this.slowMAType = slowMAType;
      return this;
    }

    public MACDEXTRequestBuilder fastMAType(FastMAType fastMAType) {
      this.fastMAType = fastMAType;
      return this;
    }

    public MACDEXTRequest build() {
      return new MACDEXTRequest(this);
    }

    public String toString() {
      return "MACDEXTRequest.MACDEXTRequestBuilder(interval=" + this.interval + ", symbol=" + this.symbol + ", seriesType=" + this.seriesType + ", fastPeriod=" + this.fastPeriod + ", slowPeriod=" + this.slowPeriod + ", signalPeriod=" + this.signalPeriod + ", signalMAType=" + this.signalMAType + ", slowMAType=" + this.slowMAType + ", fastMAType=" + this.fastMAType + ")";
    }
  }
}
