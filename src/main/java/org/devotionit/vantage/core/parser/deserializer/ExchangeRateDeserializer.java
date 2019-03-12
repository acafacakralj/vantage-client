package org.devotionit.vantage.core.parser.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.devotionit.vantage.core.AlphaVantageException;
import org.devotionit.vantage.core.response.ExchangeRateResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

import static org.devotionit.vantage.core.parser.JsonPaser.DATE_TIME_FORMATTER;

/**
 * Class is an extension of {@link ResponseDeserializer <ExchangeRateResponse>} class.
 *
 * @author Strahinja Mitrović
 */
public class ExchangeRateDeserializer extends ResponseDeserializer<ExchangeRateResponse> {
  @Override
  public ExchangeRateResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);
    if (isNodeEmtpy(node)) {
      throw new AlphaVantageException("Alpha vantage response json is empty.");
    }
    JsonNode rateData = node.get("Realtime Currency Exchange Rate");
    List<String> fieldsName = getFieldNames(rateData);
    return ExchangeRateResponse.builder()
      .fromCurrencyCode(rateData.get(fieldsName.get(0)).asText())
      .fromCurrencyName(rateData.get(fieldsName.get(1)).asText())
      .toCurrencyCode(rateData.get(fieldsName.get(2)).asText())
      .toCurrencyName(rateData.get(fieldsName.get(3)).asText())
      .exchangeRate(rateData.get(fieldsName.get(4)).asDouble())
      .lastRefreshed(LocalDateTime.parse(rateData.get(fieldsName.get(5)).asText(), DATE_TIME_FORMATTER))
      .timeZone(TimeZone.getTimeZone(rateData.get(fieldsName.get(6)).asText()))
      .build();
  }
}
