package org.devotionit.vantage.core.request.param;

/**
 * Represents series type parameter for alpha vantage api.
 *
 * @author Strahinja Mitrović
 */
public enum SeriesType implements QueryParam {
  OPEN("open"),
  HIGH("high"),
  LOW("low"),
  CLOSE("close");

  private String urlParam;

  SeriesType(String urlParam) {
    this.urlParam = urlParam;
  }

  @Override
  public String getName() {
    return "series_type";
  }

  @Override
  public String getValue() {
    return null;
  }
}
