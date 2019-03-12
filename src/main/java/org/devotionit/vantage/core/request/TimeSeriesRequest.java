package org.devotionit.vantage.core.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.devotionit.vantage.core.request.param.*;
import org.devotionit.vantage.core.response.TimeSeriesResponse;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.TimeSeriesRequestType.FOREX;
import static org.devotionit.vantage.core.request.TimeSeriesRequestType.STOCK;
import static org.devotionit.vantage.core.request.param.Function.FX_INTRADAY;
import static org.devotionit.vantage.core.request.param.Function.TIME_SERIES_INTRADAY;
import static org.devotionit.vantage.core.request.param.OutputSize.COMPACT;

/**
 * Represents a request for retrieving stock
 * time series searchData from alpha vantage.
 *
 * @author Strahinja Mitrović
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TimeSeriesRequest extends ApiRequest<TimeSeriesResponse> {
  private Interval interval;
  private Symbol symbol;
  private FromSymbol fromSymbol;
  private ToSymbol toSymbol;
  private TimeSeriesRequestType type;

  public TimeSeriesRequest(Function function,
                           OutputSize outputSize,
                           Interval interval,
                           Symbol symbol,
                           FromSymbol fromSymbol,
                           ToSymbol toSymbol,
                           TimeSeriesRequestType type) {
    super(function, outputSize);
    this.type = type;
    this.interval = this.function.equals(FX_INTRADAY) || this.function.equals(TIME_SERIES_INTRADAY) ? requireNonNull(interval, "Interval can't be null.") : interval;
    this.symbol = this.type.equals(STOCK) ? requireNonNull(symbol, "Interval can't be null.") : symbol;
    this.fromSymbol = !this.type.equals(STOCK) ? requireNonNull(fromSymbol, "FromSymbol can't be null.") : fromSymbol;
    this.toSymbol = !this.type.equals(STOCK) ? requireNonNull(toSymbol, "ToSymbol can't be null.") : toSymbol;
  }

  private static class Builder {
    protected Function function;
    protected Interval interval;
    protected OutputSize outputSize = COMPACT;
  }

  public static class ForexRequestBuilder extends Builder {
    private FromSymbol fromSymbol;
    private ToSymbol toSymbol;

    public ForexRequestBuilder fromSymbol(FromSymbol fromSymbol) {
      this.fromSymbol = fromSymbol;
      return this;
    }

    public ForexRequestBuilder toSymbol(ToSymbol toSymbol) {
      this.toSymbol = toSymbol;
      return this;
    }

    public ForexRequestBuilder function(Function function) {
      this.function = function;
      return this;
    }

    public ForexRequestBuilder interval(Interval interval) {
      this.interval = interval;
      return this;
    }

    public ForexRequestBuilder outputSize(OutputSize outputSize) {
      this.outputSize = outputSize;
      return this;
    }

    public TimeSeriesRequest build() {
      return new TimeSeriesRequest(this.function, this.outputSize, this.interval, null, this.fromSymbol, this.toSymbol, FOREX);
    }
  }

  public static ForexRequestBuilder forexRequestBuilder() {
    return new ForexRequestBuilder();
  }

  public static class StockRequestBuilder extends Builder {
    private Symbol symbol;

    public StockRequestBuilder symbol(Symbol symbol) {
      this.symbol = symbol;
      return this;
    }

    public StockRequestBuilder function(Function function) {
      this.function = function;
      return this;
    }

    public StockRequestBuilder interval(Interval interval) {
      this.interval = interval;
      return this;
    }

    public StockRequestBuilder outputSize(OutputSize outputSize) {
      this.outputSize = outputSize;
      return this;
    }

    public TimeSeriesRequest build() {
      return new TimeSeriesRequest(this.function, this.outputSize, this.interval, this.symbol, null, null, STOCK);
    }
  }

  public static StockRequestBuilder stockRequestBuilder() {
    return new StockRequestBuilder();
  }
}
