/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.mfss.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.request.mfss.order.MFSSSubscriptionRequest.DPSettlement;
import com.anosym.teh.request.mfss.order.MFSSSubscriptionRequest.PurchaseType;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.PlaceOrderResponse;
import java.math.BigDecimal;

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
public class MFSSModifyOrderRequest extends PostRequest {

  public static enum TransactionType {

    Redemption,
    Subscription;
  }

  public MFSSModifyOrderRequest(String userId, String token, String accountId,
          TransactionType transactionType, BigDecimal priceToFill, Integer orderQuantity,
          String orderDuration, String orderNumber, PurchaseType purchaseType,
          DPSettlement dpSettlement, String sipFlag, String sipFrequency, String sipDayDate,
          String sipMonth, String sipPeriod, String folioNumber) {
    super("/XMLServlets/servlet/MFModifyOrder", userId, token, accountId);
    addParameter("transactiontype", transactionType);
    addParameter("ptype", purchaseType);
    addParameter("dpsettflag", dpSettlement);
    addParameter("sipflag", sipFlag);
    addParameter("sipfreq", sipFrequency);
    addParameter("sipdaydate", sipDayDate);
    addParameter("sipmonth", sipMonth);
    addParameter("sipperiod", sipPeriod);
    addParameter("folionum", folioNumber);
    addParameter("pricetofill", priceToFill);
    addParameter("qtytofill", orderQuantity);
    addParameter("orderduration", orderDuration);
    addParameter("ordernum", orderNumber);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, PlaceOrderResponse.class);
  }
}
