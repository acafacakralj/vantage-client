package org.devotionit.vantage.core.request.param;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents interval parameter for the alpha vantage api.
 *
 * @author Strahinja Mitrović
 */
public enum Interval implements QueryParam {
  ONE_MIN("1min"),
  FIVE_MIN("5min"),
  TEN_MIN("10min"),
  FIFTEEN_MIN("15min"),
  THIRTY_MIN("30min"),
  SIXTY_MIN("60min");

  private static final Map<String, Interval> INTERVAL_MAP =
    Arrays.stream(Interval.values()).collect(Collectors.toMap(i -> i.getValue(), Function.identity()));
  private final String urlParam;

  Interval(String interval) {
    this.urlParam = interval;
  }

  public static Interval fromString(String interval) {
    return Interval.INTERVAL_MAP.get(interval);
  }

  @Override
  public String getName() {
    return "interval";
  }

  @Override
  public String getValue() {
    return urlParam;
  }
}
