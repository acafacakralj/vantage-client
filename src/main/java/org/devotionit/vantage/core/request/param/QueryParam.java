package org.devotionit.vantage.core.request.param;

/**
 * Represents request parameter.
 *
 * @author Strahinja Mitrović
 */
public interface QueryParam {
  /**
   * Method returns request query param name.
   *
   * @return {@link String}
   */
  String getName();

  /**
   * Method returns request query param value.
   *
   * @return {@link String}
   */
  String getValue();
}
