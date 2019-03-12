package org.devotionit.vantage.core.parser.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.devotionit.vantage.core.AlphaVantageException;
import org.devotionit.vantage.core.response.data.CurrencyData;
import org.devotionit.vantage.core.response.DigitalCurrencyResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.devotionit.vantage.core.parser.JsonPaser.DATE_TIME_FORMATTER;

/**
 * Class is an extension of {@link ResponseDeserializer <DigitalCurrencyResponse>} class.
 *
 * @author Strahinja Mitrović
 */
public class DigitalCurrencyDeserializer extends ResponseDeserializer<DigitalCurrencyResponse> {
  @Override
  public DigitalCurrencyResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);
    if (isNodeEmtpy(node)) {
      throw new AlphaVantageException("Alpha vantage response json is empty.");
    }
    Map<String, String> metaData = getMetaData(node);
    List<CurrencyData> currencyDataList = extractCurrencyData(node.get(getFieldNames(node).get(1)));
    return new DigitalCurrencyResponse(metaData, currencyDataList);
  }

  private List<CurrencyData> extractCurrencyData(JsonNode node) {
    List<CurrencyData> currencyDataList = new ArrayList<>();
    node.fields().forEachRemaining(entry -> {
      JsonNode dataNode = entry.getValue();
      List<String> fieldNames = getFieldNames(dataNode);
      CurrencyData.CurrencyDataBuilder builder = CurrencyData.builder()
        .date(LocalDateTime.parse(entry.getKey(), DATE_TIME_FORMATTER))
        .open(dataNode.get(fieldNames.get(0)).asDouble())
        .usdOpen(dataNode.get(fieldNames.get(1)).asDouble())
        .high(dataNode.get(fieldNames.get(2)).asDouble())
        .usdHigh(dataNode.get(fieldNames.get(3)).asDouble())
        .low(dataNode.get(fieldNames.get(4)).asDouble())
        .usdlow(dataNode.get(fieldNames.get(5)).asDouble())
        .close(dataNode.get(fieldNames.get(6)).asDouble())
        .usdClose(dataNode.get(fieldNames.get(7)).asDouble())
        .volume(dataNode.get(fieldNames.get(8)).asDouble())
        .usdMarketCap(dataNode.get(fieldNames.get(9)).asDouble());
      currencyDataList.add(builder.build());
    });
    return currencyDataList;
  }
}
