package org.devotionit.vantage.core.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.devotionit.vantage.core.response.data.TimeSeriesData;

import java.util.List;
import java.util.Map;

/**
 * @author Strahinja Mitrović
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TimeSeriesResponse extends ApiResponse {
  private List<TimeSeriesData> timeSeriesData;

  public TimeSeriesResponse(Map<String, String> metaData, List<TimeSeriesData> timeSeriesData) {
    super(metaData);
    this.timeSeriesData = timeSeriesData;
  }
}
