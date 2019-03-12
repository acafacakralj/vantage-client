package org.devotionit.vantage.core.parser.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.devotionit.vantage.core.AlphaVantageException;
import org.devotionit.vantage.core.response.data.SearchData;
import org.devotionit.vantage.core.response.SearchResponse;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import static org.devotionit.vantage.core.parser.JsonPaser.LOCAL_TIME_FORMATTER;

public class SearchDeserializer extends ResponseDeserializer<SearchResponse> {
  @Override
  public SearchResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);
    if (isNodeEmtpy(node)) {
      throw new AlphaVantageException("Alpha vantage response json is empty.");
    }
    JsonNode matchesNode = node.get(getFieldNames(node).get(0));
    List<SearchData> dataList = new ArrayList<>();
    matchesNode.forEach(jsonNode -> {
      List<String> fieldNames = getFieldNames(jsonNode);
      SearchData searchData = SearchData.builder()
        .symbol(jsonNode.get(fieldNames.get(0)).asText())
        .name(jsonNode.get(fieldNames.get(1)).asText())
        .type(jsonNode.get(fieldNames.get(2)).asText())
        .region(jsonNode.get(fieldNames.get(3)).asText())
        .marketOpen(LocalTime.parse(jsonNode.get(fieldNames.get(4)).asText(), LOCAL_TIME_FORMATTER))
        .marketClose(LocalTime.parse(jsonNode.get(fieldNames.get(5)).asText(), LOCAL_TIME_FORMATTER))
        .timeZone(TimeZone.getTimeZone(jsonNode.get(fieldNames.get(6)).asText()))
        .currency(jsonNode.get(fieldNames.get(7)).asText())
        .matchScore(jsonNode.get(fieldNames.get(8)).asDouble())
        .build();
      dataList.add(searchData);
    });
    return new SearchResponse(dataList);
  }
}
