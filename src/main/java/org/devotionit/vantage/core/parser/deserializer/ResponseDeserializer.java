package org.devotionit.vantage.core.parser.deserializer;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

/**
 * Class is an extension of {@link JsonDeserializer<T>} class.
 *
 * @param <T>
 * @author Strahinja Mitrović
 */
public abstract class ResponseDeserializer<T> extends JsonDeserializer<T> {
  protected boolean isNodeEmtpy(JsonNode node) {
    return node.size() == 0;
  }

  protected Map<String, String> getMetaData(JsonNode rootNode) {
    return stream(spliteratorUnknownSize(rootNode.get("Meta Data").fields(), ORDERED), false)
      .map(entry -> new SimpleEntry<String, String>(entry.getKey(), entry.getValue().asText()))
      .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
  }

  protected List<String> getFieldNames(JsonNode node) {
    return stream(spliteratorUnknownSize(node.fieldNames(), ORDERED), false).collect(Collectors.toList());
  }
}
