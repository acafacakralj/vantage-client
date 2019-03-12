package org.devotionit.vantage.core.response.data;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Strahinja Mitrović
 */
@Data
@Builder
public class TimeSeriesData {
  private LocalDateTime date;
  private double open;
  private double high;
  private double low;
  private double close;
  private long volume;
}
