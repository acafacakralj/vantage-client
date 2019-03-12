package org.devotionit.vantage.core.request.param;

/**
 * Represents the searchData type in which the response will be returned.
 *
 * @author Strahinja Mitrović
 */
public enum DataType implements QueryParam {
  JSON("json"),
  CSV("csv");

  private final String urlParam;

  DataType(String dataType) {
    this.urlParam = dataType;
  }

  @Override
  public String getName() {
    return "datatype";
  }

  @Override
  public String getValue() {
    return urlParam;
  }
}
