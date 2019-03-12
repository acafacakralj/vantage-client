package org.devotionit.vantage.core.parser.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.devotionit.vantage.core.AlphaVantageException;
import org.devotionit.vantage.core.response.QuoteResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.devotionit.vantage.core.parser.JsonPaser.DATE_TIME_FORMATTER;

public class QuoteDeserializer extends ResponseDeserializer<QuoteResponse> {
  @Override
  public QuoteResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);
    if (isNodeEmtpy(node)) {
      throw new AlphaVantageException("Alpha vantage response json is empty.");
    }
    JsonNode quoteNode = node.get("Global Quote");
    List<String> fieldNames = getFieldNames(quoteNode);
    return QuoteResponse.builder()
      .symbol(quoteNode.get(fieldNames.get(0)).asText())
      .open(quoteNode.get(fieldNames.get(1)).asDouble())
      .high(quoteNode.get(fieldNames.get(2)).asDouble())
      .low(quoteNode.get(fieldNames.get(3)).asDouble())
      .price(quoteNode.get(fieldNames.get(4)).asDouble())
      .volume(quoteNode.get(fieldNames.get(5)).asLong())
      .latestTradingDay(LocalDateTime.parse(quoteNode.get(fieldNames.get(6)).asText(), DATE_TIME_FORMATTER))
      .previousClose(quoteNode.get(fieldNames.get(7)).asDouble())
      .change(quoteNode.get(fieldNames.get(8)).asDouble())
      .changePercent(quoteNode.get(fieldNames.get(9)).asText())
      .build();
  }
}
