package org.devotionit.vantage.ut.core.request;

import org.devotionit.vantage.core.request.TimeSeriesRequest;
import org.devotionit.vantage.core.request.param.FromSymbol;
import org.devotionit.vantage.core.request.param.Function;
import org.devotionit.vantage.core.request.param.Symbol;
import org.devotionit.vantage.core.request.param.ToSymbol;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TimeSeriesRequestTest {
  @Test
  public void Should_CreateForexRequest_When_DataIsValid() {
    TimeSeriesRequest request = TimeSeriesRequest.forexRequestBuilder()
      .fromSymbol(FromSymbol.from("USD"))
      .toSymbol(ToSymbol.from("EUR"))
      .function(Function.FX_DAILY)
      .build();
    assertNotNull(request);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToForexCreateRequest_When_IntervalIsNullAndFunctionIsIntraday() {
    TimeSeriesRequest.forexRequestBuilder()
      .fromSymbol(FromSymbol.from("USD"))
      .toSymbol(ToSymbol.from("EUR"))
      .function(Function.FX_INTRADAY)
      .build();
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateForexRequest_When_FromSymbolIsNull() {
    TimeSeriesRequest.forexRequestBuilder()
      .fromSymbol(null)
      .toSymbol(ToSymbol.from("EUR"))
      .function(Function.FX_INTRADAY)
      .build();
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateForexRequest_When_ToSymbolIsNull() {
    TimeSeriesRequest.forexRequestBuilder()
      .fromSymbol(FromSymbol.from("USD"))
      .toSymbol(null)
      .function(Function.FX_INTRADAY)
      .build();
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateForexRequest_When_FunctionIsNull() {
    TimeSeriesRequest.forexRequestBuilder()
      .fromSymbol(FromSymbol.from("USD"))
      .toSymbol(ToSymbol.from("EUR"))
      .function(null)
      .build();
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateForexRequest_When_OutputSizeIsNull() {
    TimeSeriesRequest.forexRequestBuilder()
      .fromSymbol(FromSymbol.from("USD"))
      .toSymbol(ToSymbol.from("EUR"))
      .function(Function.FX_INTRADAY)
      .outputSize(null)
      .build();
  }

  @Test
  public void Should_CreateStockRequest_When_DataIsValid() {
    TimeSeriesRequest request = TimeSeriesRequest.stockRequestBuilder()
      .symbol(Symbol.from("USD"))
      .function(Function.TIME_SERIES_DAILY)
      .build();
    assertNotNull(request);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToStockCreateRequest_When_IntervalIsNullAndFunctionIsIntraday() {
    TimeSeriesRequest.stockRequestBuilder()
      .symbol(Symbol.from("USD"))
      .function(Function.TIME_SERIES_INTRADAY)
      .build();
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateStockRequest_When_SymbolIsNull() {
    TimeSeriesRequest.stockRequestBuilder()
      .symbol(null)
      .function(Function.TIME_SERIES_DAILY)
      .build();
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateStockRequest_When_FunctionIsNull() {
    TimeSeriesRequest.stockRequestBuilder()
      .symbol(Symbol.from("EUR"))
      .function(null)
      .build();
  }
}
