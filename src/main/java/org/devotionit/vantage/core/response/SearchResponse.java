package org.devotionit.vantage.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.devotionit.vantage.core.response.data.SearchData;

import java.util.List;

/**
 * Represents the best-matching symbols and market information based on keywords.
 *
 * @author Strahinja Mitrović
 */
@Data
@AllArgsConstructor
public class SearchResponse {
  private List<SearchData> searchData;
}
