/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.PlaceOrderResponse;

/**
 * <pre>• Purchase Type can take values-Fresh and AdditionalM</pre>
 * <pre>• DP Settlement can take values-Demat and Physical </pre>
 * <pre>• If DP Settlement is Demat then DP Id has to be entered which is got from MFDpIds servlet.</pre>
 * <pre>• If DP Settlement is Physical and Purchase Type is Additional then Folio Number has to be entered.</pre>
 * <pre>• If sipindicator in GetSipIndicator is “Y” and user wants to subscribe for SIP then SIP Flag has to be “S” and
 * details like Frequency ,DayDate, Month(for annual,semi annual and quarterly SIP), Period has to
 * be entered which is got from MFSipDetails.</pre>
 *
 * @author marembo
 */
public class MFSSSubscriptionRequest extends PostRequest {

  public static enum PurchaseType {

    Fresh,
    Additional;
  }

  public static enum DPSettlement {

    Demat,
    Physical;
  }

  public MFSSSubscriptionRequest(String userId, String token, String accountId,
          String tradingSymbol, PurchaseType purchaseType, String arnNumber,
          DPSettlement dpSettlement, String sipFlag, String sipFrequency, String sipDayDate,
          String sipMonth, String sipPeriod, String dpId, String folioNumber, String applicationNumber) {
    super("/XMLServlets/servlet/MFSubscription", userId, token, accountId);
    addParameter("tradingsymbol", tradingSymbol);
    addParameter("purchasetype", purchaseType);
    addParameter("arnnum", arnNumber);
    addParameter("dpsettflag", dpSettlement);
    addParameter("sipflag", sipFlag);
    addParameter("sipfreq", sipFrequency);
    addParameter("sipdaydate", sipDayDate);
    addParameter("sipmonth", sipMonth);
    addParameter("sipperiod", sipPeriod);
    addParameter("dpid", dpId);
    addParameter("folionum", folioNumber);
    addParameter("applinum", applicationNumber);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, PlaceOrderResponse.class);
  }
}
