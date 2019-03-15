package org.devotionit.vantage.core.response.data;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Strahinja Mitrović
 */
@Data
@AllArgsConstructor
public class IndicatorData {
  private LocalDateTime date;
  private Map<String, String> data;
}
