package org.devotionit.vantage.core.request.indicator;

import lombok.Data;
import org.devotionit.vantage.core.request.ApiRequest;
import org.devotionit.vantage.core.request.param.Function;
import org.devotionit.vantage.core.request.param.Interval;
import org.devotionit.vantage.core.response.IndicatorResponse;

import static java.util.Objects.requireNonNull;

/**
 * @author Strahinja Mitrović
 */
@Data
public abstract class IndicatorRequest extends ApiRequest<IndicatorResponse> {
  protected Interval interval;

  protected IndicatorRequest(Function function, Interval interval) {
    super(function, null);
    this.interval = requireNonNull(interval, "Interval can't be null.");
  }

  public static ADOSCRequest.ADOSCRequestBuilder adoscBuilder() {
    return ADOSCRequest.builder();
  }

  public static ADRequest.ADRequestBuilder adRequestBuilder() {
    return ADRequest.builder();
  }

  public static ADXRequest.ADXRequestBuilder adxRequestBuilder() {
    return ADXRequest.builder();
  }

  public static ADXRRequest.ADXRRequestBuilder adxrRequestBuilder() {
    return ADXRRequest.builder();
  }

  public static APORequest.APORequestBuilder apoRequestBuilder() {
    return APORequest.builder();
  }

  public static AROONRequest.AROONRequestBuilder aroonRequestBuilder() {
    return AROONRequest.builder();
  }

  public static ATRRequest.ATRRequestBuilder atrRequestBuilder() {
    return ATRRequest.builder();
  }

  public static BBANDSRequest.BBANDSRequestBuilder bbandsRequestBuilder() {
    return BBANDSRequest.builder();
  }

  public static BOPRequest.BOPRequestBuilder bopRequestBuilder() {
    return BOPRequest.builder();
  }

  public static CCIRequest.CCIRequestBuilder cciRequestBuilder() {
    return CCIRequest.builder();
  }

  public static CMORequest.CMORequestBuilder cmoRequestBuilder() {
    return CMORequest.builder();
  }

  public static DEMARequest.DEMARequestBuilder demaRequestBuilder() {
    return DEMARequest.builder();
  }

  public static DXRequest.DXRequestBuilder dxRequestBuilder() {
    return DXRequest.builder();
  }

  public static EMARequest.EMARequestBuilder emaRequestBuilder() {
    return EMARequest.builder();
  }

  public static HTDCPeriodRequest.HTDCPeriodRequestBuilder htdcPeriodRequestBuilder() {
    return HTDCPeriodRequest.builder();
  }

  public static HTDCPhaseRequest.HTDCPhaseRequestBuilder htdcPhaseRequestBuilder() {
    return HTDCPhaseRequest.builder();
  }

  public static HTPHASORRequest.HTPHASORRequestBuilder htphasorRequestBuilder() {
    return HTPHASORRequest.builder();
  }

  public static HTSineRequest.HTSineRequestBuilder htSineRequestBuilder() {
    return HTSineRequest.builder();
  }

  public static HTTrendLineRequest.HTTrendLineRequestBuilder htTrendLineRequestBuilder() {
    return HTTrendLineRequest.builder();
  }

  public static HTTrendModeRequest.HTTrendModeRequestBuilder htTrendModeRequestBuilder() {
    return HTTrendModeRequest.builder();
  }

  public static KAMARequest.KAMARequestBuilder kamaRequestBuilder() {
    return KAMARequest.builder();
  }

  public static MACDEXTRequest.MACDEXTRequestBuilder macdextRequestBuilder() {
    return MACDEXTRequest.builder();
  }

  public static MACDRequest.MACDRequestBuilder macdRequestBuilder() {
    return MACDRequest.builder();
  }

  public static MAMARequest.MAMARequestBuilder mamaRequestBuilder() {
    return MAMARequest.builder();
  }

  public static MFIRequest.MFIRequestBuilder mfiRequestBuilder() {
    return MFIRequest.builder();
  }

  public static MIDPOINTRequest.MIDPOINTRequestBuilder midpointRequestBuilder() {
    return MIDPOINTRequest.builder();
  }

  public static MIDPRICERequest.MIDPRICERequestBuilder midpriceRequestBuilder() {
    return MIDPRICERequest.builder();
  }

  public static MINUSDIRequest.MINUSDIRequestBuilder minusdiRequestBuilder() {
    return MINUSDIRequest.builder();
  }

  public static MINUSDMRequest.MINUSDMRequestBuilder minusdmRequestBuilder() {
    return MINUSDMRequest.builder();
  }

  public static MOMRequest.MOMRequestBuilder momRequestBuilder() {
    return MOMRequest.builder();
  }

  public static NATRRequest.NATRRequestBuilder natrRequestBuilder() {
    return NATRRequest.builder();
  }

  public static OBVRequest.OBVRequestBuilder obvRequestBuilder() {
    return OBVRequest.builder();
  }

  public static PLUSDIRequest.PLUSDIRequestBuilder plusdiRequestBuilder() {
    return PLUSDIRequest.builder();
  }

  public static PLUSDMRequest.PLUSDMRequestBuilder plusdmRequestBuilder() {
    return PLUSDMRequest.builder();
  }

  public static PPORequest.PPORequestBuilder ppoRequestBuilder() {
    return PPORequest.builder();
  }

  public static ROCRequest.ROCRequestBuilder rocRequestBuilder() {
    return ROCRequest.builder();
  }

  public static ROCRRequest.ROCRRequestBuilder rocrRequestBuilder() {
    return ROCRRequest.builder();
  }

  public static RSIRequest.RSIRequestBuilder rsiRequestBuilder() {
    return RSIRequest.builder();
  }

  public static SARRequest.SARRequestBuilder sarRequestBuilder() {
    return SARRequest.builder();
  }

  public static SMARequest.SMARequestBuilder smaRequestBuilder() {
    return SMARequest.builder();
  }

  public static STOCHFRequest.STOCHFRequestBuilder stochfRequestBuilder() {
    return STOCHFRequest.builder();
  }

  public static STOCHRequest.STOCHRequestBuilder stochRequestBuilder() {
    return STOCHRequest.builder();
  }

  public static STOCHRSIRequest.STOCHRSIRequestBuilder stochrsiRequestBuilder() {
    return STOCHRSIRequest.builder();
  }

  public static T3Request.T3RequestBuilder t3RequestBuilder() {
    return T3Request.builder();
  }

  public static TEMARequest.TEMARequestBuilder temaRequestBuilder() {
    return TEMARequest.builder();
  }

  public static TRANGERequest.TRANGERequestBuilder trangeRequestBuilder() {
    return TRANGERequest.builder();
  }

  public static TRIMARequest.TRIMARequestBuilder trimaRequestBuilder() {
    return TRIMARequest.builder();
  }

  public static TRIXRequest.TRIXRequestBuilder trixRequestBuilder() {
    return TRIXRequest.builder();
  }

  public static ULTOSCRequest.ULTOSCRequestBuilder ultoscRequestBuilder() {
    return ULTOSCRequest.builder();
  }

  public static VWAPRequest.VWAPRequestBuilder vwapRequestBuilder() {
    return VWAPRequest.builder();
  }

  public static WILLRRequest.WILLRRequestBuilder willrRequestBuilder() {
    return WILLRRequest.builder();
  }

  public static WMARequest.WMARequestBuilder wmaRequestBuilder() {
    return WMARequest.builder();
  }
}
