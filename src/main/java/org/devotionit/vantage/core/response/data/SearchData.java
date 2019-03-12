package org.devotionit.vantage.core.response.data;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.TimeZone;

/**
 * @author Strahinja Mitrović
 */
@Data
@Builder
public class SearchData {
  private String symbol;
  private String name;
  private String type;
  private String region;
  private LocalTime marketOpen;
  private LocalTime marketClose;
  private TimeZone timeZone;
  private String currency;
  private double matchScore;
}
