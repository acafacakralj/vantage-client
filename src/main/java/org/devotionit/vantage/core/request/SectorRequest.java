package org.devotionit.vantage.core.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.devotionit.vantage.core.response.SectorResponse;

import static org.devotionit.vantage.core.request.param.Function.SECTOR;


/**
 * Represents a request for retrieving sector performance searchData from alpha vantage.
 * Class is an extension of {@link ApiRequest<  SectorResponse  >} class.
 *
 * @author Strahinja Mitrović
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SectorRequest extends ApiRequest<SectorResponse> {
  public SectorRequest() {
    super(SECTOR, null);
  }
}
