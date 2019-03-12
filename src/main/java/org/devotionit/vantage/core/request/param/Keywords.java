package org.devotionit.vantage.core.request.param;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.util.Objects.requireNonNull;

/**
 * Represents keywords parameter for alpha vantage api.
 *
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public class Keywords implements QueryParam {
  private String word;

  private Keywords(String keywords) {
    this.word = requireNonNull(keywords, "Keywords can't be null.");
  }

  @Override
  public String getName() {
    return "keywords";
  }

  @Override
  public String getValue() {
    return word;
  }

  /**
   * Method is used for instantiating new instance of {@link Keywords}.
   *
   * @param keywords {@link String}
   * @return {@link Keywords}
   */
  public static Keywords from(String keywords) {
    return new Keywords(keywords);
  }
}
