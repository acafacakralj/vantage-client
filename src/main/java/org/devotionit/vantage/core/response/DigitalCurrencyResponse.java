package org.devotionit.vantage.core.response;

import lombok.Data;
import org.devotionit.vantage.core.response.data.CurrencyData;

import java.util.List;
import java.util.Map;

/**
 * @author Strahinja Mitrović
 */
@Data
public class DigitalCurrencyResponse extends ApiResponse {
  private List<CurrencyData> currencyData;

  public DigitalCurrencyResponse(Map<String, String> metaData, List<CurrencyData> currencyData) {
    super(metaData);
    this.currencyData = currencyData;
  }
}
