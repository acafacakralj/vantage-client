package org.devotionit.vantage.core.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * @author Strahinja Mitrović
 */
@Data
@Builder
public class ExchangeRateResponse {
  private String fromCurrencyCode;
  private String fromCurrencyName;
  private String toCurrencyCode;
  private String toCurrencyName;
  private double exchangeRate;
  private LocalDateTime lastRefreshed;
  private TimeZone timeZone;
}
