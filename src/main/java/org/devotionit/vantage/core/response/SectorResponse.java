package org.devotionit.vantage.core.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * Represents the realtime and historical sector performances
 * calculated from S&P500 incumbents.
 *
 * @author Strahinja Mitrović
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SectorResponse extends ApiResponse {
  private Map<String, String> realTimePerf;
  private Map<String, String> oneDayPerf;
  private Map<String, String> fiveDayPerf;
  private Map<String, String> oneMonthPerf;
  private Map<String, String> threeMonthPerf;
  private Map<String, String> yearToDatePerf;
  private Map<String, String> oneYearPerf;
  private Map<String, String> threeYearPerf;
  private Map<String, String> fiveYearPerf;
  private Map<String, String> tenYearPerf;

  @JsonCreator
  public SectorResponse(@JsonProperty("Meta Data") Map<String, String> metaData,
                        @JsonProperty("Rank A: Real-Time Performance") Map<String, String> realTimePerf,
                        @JsonProperty("Rank B: 1 Day Performance") Map<String, String> oneDayPerf,
                        @JsonProperty("Rank C: 5 Day Performance") Map<String, String> fiveDayPerf,
                        @JsonProperty("Rank D: 1 Month Performance") Map<String, String> oneMonthPerf,
                        @JsonProperty("Rank E: 3 Month Performance") Map<String, String> threeMonthPerf,
                        @JsonProperty("Rank F: Year-to-Date (YTD) Performance") Map<String, String> yearToDatePerf,
                        @JsonProperty("Rank G: 1 Year Performance") Map<String, String> oneYearPerf,
                        @JsonProperty("Rank H: 3 Year Performance") Map<String, String> threeYearPerf,
                        @JsonProperty("Rank I: 5 Year Performance") Map<String, String> fiveYearPerf,
                        @JsonProperty("Rank J: 10 Year Performance") Map<String, String> tenYearPerf) {
    super(metaData);
    this.realTimePerf = realTimePerf;
    this.oneDayPerf = oneDayPerf;
    this.fiveDayPerf = fiveDayPerf;
    this.oneMonthPerf = oneMonthPerf;
    this.threeMonthPerf = threeMonthPerf;
    this.yearToDatePerf = yearToDatePerf;
    this.oneYearPerf = oneYearPerf;
    this.threeYearPerf = threeYearPerf;
    this.fiveYearPerf = fiveYearPerf;
    this.tenYearPerf = tenYearPerf;
  }
}
