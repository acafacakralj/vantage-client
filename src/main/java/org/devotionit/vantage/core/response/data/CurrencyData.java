package org.devotionit.vantage.core.response.data;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Strahinja Mitrović
 */
@Data
@Builder
public class CurrencyData {
  private LocalDateTime date;
  private double open;
  private double usdOpen;
  private double high;
  private double usdHigh;
  private double low;
  private double usdlow;
  private double close;
  private double usdClose;
  private double volume;
  private double usdMarketCap;
}
