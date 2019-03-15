package org.devotionit.vantage.core.response;

import lombok.Data;
import org.devotionit.vantage.core.response.data.IndicatorData;

import java.util.List;
import java.util.Map;

/**
 * @author Strahinja Mitrović
 */
@Data
public class IndicatorResponse extends ApiResponse {
  private List<IndicatorData> indicatorData;

  public IndicatorResponse(Map<String, String> metaData, List<IndicatorData> indicatorData) {
    super(metaData);
    this.indicatorData = indicatorData;
  }
}
