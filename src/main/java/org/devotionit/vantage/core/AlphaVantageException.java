package org.devotionit.vantage.core;

/**
 * Class is an extension of {@link RuntimeException} class.
 *
 * @author Strahinja Mitrović
 */
public class AlphaVantageException extends RuntimeException {
  public AlphaVantageException(String message) {
    super(message);
  }
}
