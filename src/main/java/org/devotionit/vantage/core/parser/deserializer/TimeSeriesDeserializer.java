package org.devotionit.vantage.core.parser.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.devotionit.vantage.core.AlphaVantageException;
import org.devotionit.vantage.core.response.TimeSeriesResponse;
import org.devotionit.vantage.core.response.data.TimeSeriesData;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.devotionit.vantage.core.parser.JsonPaser.DATE_TIME_FORMATTER;

public class TimeSeriesDeserializer extends ResponseDeserializer<TimeSeriesResponse> {
  @Override
  public TimeSeriesResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);
    if (isNodeEmtpy(node)) {
      throw new AlphaVantageException("Alpha vantage response json is empty.");
    }
    Map<String, String> metaData = getMetaData(node);
    List<TimeSeriesData> timeSeriesData = extractTimeSeriesData(node.get(getFieldNames(node).get(1)));
    return new TimeSeriesResponse(metaData, timeSeriesData);
  }

  private List<TimeSeriesData> extractTimeSeriesData(JsonNode node) {
    List<TimeSeriesData> timeSeriesData = new ArrayList<>();
    node.fields().forEachRemaining(entry -> {
      JsonNode dataNode = entry.getValue();
      List<String> fieldNames = getFieldNames(node);
      TimeSeriesData.TimeSeriesDataBuilder builder = TimeSeriesData.builder()
        .date(LocalDateTime.parse(entry.getKey(), DATE_TIME_FORMATTER))
        .open(dataNode.get(fieldNames.get(0)).asDouble())
        .high(dataNode.get(fieldNames.get(1)).asDouble())
        .low(dataNode.get(fieldNames.get(2)).asDouble())
        .close(dataNode.get(fieldNames.get(3)).asDouble())
        .volume(dataNode.get(fieldNames.get(4)).asLong());
      timeSeriesData.add(builder.build());
    });
    return timeSeriesData;
  }
}


