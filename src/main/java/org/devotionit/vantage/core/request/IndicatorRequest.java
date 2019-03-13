package org.devotionit.vantage.core.request;

import org.devotionit.vantage.core.request.param.Function;
import org.devotionit.vantage.core.request.param.OutputSize;
import org.devotionit.vantage.core.response.IndicatorResponse;

public class IndicatorRequest extends ApiRequest<IndicatorResponse> {
  public IndicatorRequest(Function function, OutputSize outputSize) {
    super(function, outputSize);
  }
}
