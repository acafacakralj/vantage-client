package org.devotionit.vantage.core.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.devotionit.vantage.core.parser.deserializer.*;
import org.devotionit.vantage.core.response.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Objects;

/**
 * Thread-safe Singleton class. The instance is lazily initialized and thus needs synchronization
 * mechanism. It is used for creating and configuring jackson {@link ObjectMapper}.
 *
 * @author Strahinja Mitrović
 */
public class JsonPaser {
  public static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd[ HH:mm:ss]")
    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
    .toFormatter();
  public static final DateTimeFormatter LOCAL_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
  private static ObjectMapper mapper;

  private JsonPaser() {
  }

  /**
   * Method is used for creating and configuring only once {@link ObjectMapper} lazy-loading.
   *
   * @return {@link ObjectMapper}
   */
  public static synchronized ObjectMapper getInstance() {
    if (!Objects.isNull(mapper)) {
      return mapper;
    }
    JavaTimeModule module = new JavaTimeModule();
    module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DATE_TIME_FORMATTER));
    module.addDeserializer(TimeSeriesResponse.class, new TimeSeriesDeserializer());
    module.addDeserializer(ExchangeRateResponse.class, new ExchangeRateDeserializer());
    module.addDeserializer(DigitalCurrencyResponse.class, new DigitalCurrencyDeserializer());
    module.addDeserializer(QuoteResponse.class, new QuoteDeserializer());
    module.addDeserializer(SearchResponse.class, new SearchDeserializer());
    mapper = new ObjectMapper();
    mapper.registerModule(module);
    mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    return mapper;
  }
}

