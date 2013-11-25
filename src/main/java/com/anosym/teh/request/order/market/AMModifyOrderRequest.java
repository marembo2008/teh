/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order.market;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.market.AMModifyOrderResponse;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class AMModifyOrderRequest extends AMPlaceOrderRequest {

  public AMModifyOrderRequest(
          String userId, String accountId, String exchange, String tradingSymbol, String symbol,
          String transactionType, String orderDuration, Calendar validDate, int quantity,
          BigDecimal priceToFill, BigDecimal triggerPrice, String priceType, String productCode,
          int disclosedQuantity, String token, String orderNumber, String orderRequestId) {
    super("/XMLServlets/servlet/ModifyAMO", userId, accountId, exchange, tradingSymbol, symbol,
            transactionType, orderDuration, validDate, quantity, priceToFill, triggerPrice,
            priceType, productCode, disclosedQuantity, token);
    addParameter("NestOrderNo", orderNumber);
    addParameter("NestOrderReqId", orderRequestId);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<nestmodifyordernumber>")) {
      return processResponse(response, AMModifyOrderResponse.class);
    }
    return super.getResponse(response);
  }
}
