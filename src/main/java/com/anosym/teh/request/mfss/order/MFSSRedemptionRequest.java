/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.request.mfss.order.MFSSSubscriptionRequest.DPSettlement;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.PlaceOrderResponse;

/**
 * <PRE>• DP Settlement can take values-Demat and Physical</PRE>
 * <PRE>• If DP Settlement is Demat then DP Id has to be entered which is got from MFDpIds servlet.</PRE>
 * <PRE>• If DP Settlement is Physical then Folio Number has to be entered.</PRE>
 * <PRE>•If the Quantity entered is less than minredempqty which is got from
 * GetMarketWatchInfoMF servlet then “Quantity / Value entered is less than the minimum specified
 * limit for this scheme.</PRE>
 * <PRE>Do you still want to continue?” this msg has to be dispayed and if the
 * user wants to continue then the req has to be sent.</PRE>
 *
 * @author marembo
 */
public class MFSSRedemptionRequest extends PostRequest {

  public MFSSRedemptionRequest(String userId, String token, String accountId,
          String tradingSymbol, int quantityToFill, String arnNumber,
          DPSettlement dpSettlement, String dpId, String folioNumber, String applicationNumber) {
    super("/XMLServlets/servlet/MFRedemption", userId, token, accountId);
    addParameter("tradingsymbol", tradingSymbol);
    addParameter("qtytofill", quantityToFill);
    addParameter("arnnum", arnNumber);
    addParameter("dpsettflag", dpSettlement);
    addParameter("dpid", dpId);
    addParameter("folionum", folioNumber);
    addParameter("applinum", applicationNumber);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, PlaceOrderResponse.class);
  }
}
