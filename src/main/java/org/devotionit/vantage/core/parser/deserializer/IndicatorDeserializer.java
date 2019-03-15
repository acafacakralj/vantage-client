package org.devotionit.vantage.core.parser.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.devotionit.vantage.core.AlphaVantageException;
import org.devotionit.vantage.core.response.IndicatorResponse;
import org.devotionit.vantage.core.response.data.IndicatorData;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.devotionit.vantage.core.parser.JsonPaser.DATE_TIME_FORMATTER;

/**
 * Class is an extension of {@link ResponseDeserializer<IndicatorResponse>} class.
 *
 * @author Strahinja Mitrović
 */
public class IndicatorDeserializer extends ResponseDeserializer<IndicatorResponse> {
  @Override
  public IndicatorResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);
    if (isNodeEmtpy(node)) {
      throw new AlphaVantageException("Alpha vantage response json is empty.");
    }
    Map<String, String> metaData = getMetaData(node);
    List<IndicatorData> indicatorDataList = extractIndicatorData(node.get(getFieldNames(node).get(1)));
    return new IndicatorResponse(metaData, indicatorDataList);
  }

  private List<IndicatorData> extractIndicatorData(JsonNode node) {
    List<IndicatorData> indicatorDataList = new ArrayList<>();
    node.fields().forEachRemaining(entry -> {
      JsonNode dataNode = entry.getValue();
      Map<String, String> indicatorData = getFieldNames(dataNode).stream()
        .map(prop -> new AbstractMap.SimpleEntry<String, String>(prop, dataNode.get(prop).asText()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
      indicatorDataList.add(new IndicatorData(LocalDateTime.parse(entry.getKey(), DATE_TIME_FORMATTER), indicatorData));
    });
    return indicatorDataList;
  }
}
