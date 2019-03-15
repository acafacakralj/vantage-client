package org.devotionit.vantage.ut;


import org.devotionit.vantage.core.parser.JsonPaser;
import org.devotionit.vantage.core.response.IndicatorResponse;

import java.io.IOException;

public class Test {
  public static void main(String[] args) throws IOException {
    // empty

    String json = "{\"Meta Data\": { \"1: Symbol\": \"MSFT\", \"2: Indicator\": \"Double Exponential Moving Average (DEMA)\", \"3: Last Refreshed\": \"2019-03-13 12:48:30\", \"4: Interval\": \"weekly\", \"5: Time Period\": 10, \"6: Series Type\": \"open\", \"7: Time Zone\": \"US/Eastern\" }, \"Technical Analysis: DEMA\": { \"2019-03-13 12:48:30\": { \"DEMA\": \"110.1648\" } } }";

    System.out.println(JsonPaser.getInstance().readValue(json, IndicatorResponse.class));
  }
}
