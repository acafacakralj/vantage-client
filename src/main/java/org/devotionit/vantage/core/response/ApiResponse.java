package org.devotionit.vantage.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * @author Strahinja Mitrović
 */
@Data
@AllArgsConstructor
public abstract class ApiResponse {
  protected Map<String, String> metaData;
}
