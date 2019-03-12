package org.devotionit.vantage.core.request;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.devotionit.vantage.core.request.param.DataType;
import org.devotionit.vantage.core.request.param.Function;
import org.devotionit.vantage.core.request.param.OutputSize;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.request.param.DataType.JSON;
import static org.devotionit.vantage.core.request.param.OutputSize.COMPACT;

/**
 * Represents base for alpha vantage API request.
 *
 * @author Strahinja Mitrović
 */
@ToString
@EqualsAndHashCode
public abstract class ApiRequest<T> {
  protected final Function function;
  protected final OutputSize outputSize;
  protected static final DataType DATA_TYPE = JSON;

  public ApiRequest(Function function, OutputSize outputSize) {
    this.function = requireNonNull(function, "Function can't be null.");
    this.outputSize = isNull(outputSize) ? COMPACT : outputSize;
  }
}
