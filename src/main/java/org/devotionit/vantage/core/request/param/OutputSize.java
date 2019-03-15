package org.devotionit.vantage.core.request.param;

import lombok.ToString;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents output size parameter for the alpha vantage api.
 *
 * @author Strahinja Mitrović
 */
@ToString
public enum OutputSize implements QueryParam {
  COMPACT("compact"),
  FULL("full");

  private static final Map<String, OutputSize> OUTPUT_SIZE_MAP =
    Arrays.stream(OutputSize.values()).collect(Collectors.toMap(o -> o.getValue(), Function.identity()));
  private final String urlParam;

  OutputSize(String outputSize) {
    this.urlParam = outputSize;
  }

  @Override
  public String getName() {
    return "outputsize";
  }

  @Override
  public String getValue() {
    return urlParam;
  }

  /**
   * Method is used for retrieving  {@link OutputSize} enum from provided {@link String}.
   *
   * @param outputSize {@link String}
   * @return {@link Interval}
   */
  public static OutputSize fromString(String outputSize) {
    return OutputSize.OUTPUT_SIZE_MAP.get(outputSize.toLowerCase());
  }
}
