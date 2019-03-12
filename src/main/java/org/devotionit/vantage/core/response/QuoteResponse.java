package org.devotionit.vantage.core.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Represents the latest price and volume information.
 *
 * @author Strahinja Mitrović
 */
@Data
@Builder
public class QuoteResponse {
  private Map<String, String> quote;
  private String symbol;
  private double open;
  private double high;
  private double low;
  private double price;
  private long volume;
  private LocalDateTime latestTradingDay;
  private double previousClose;
  private double change;
  private String changePercent;
}
