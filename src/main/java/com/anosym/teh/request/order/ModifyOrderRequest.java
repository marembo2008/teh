/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.ModifyOrderResponse;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class ModifyOrderRequest extends PlaceOrderRequest {

  public ModifyOrderRequest(String orderNumber, String userId, String accountId, String exchange,
          String tradingSymbol, String transactionType, String orderDuration, Calendar validDate,
          BigDecimal priceToFill, BigDecimal triggerPrice, String priceType, String productCode,
          int disclosedQuantity, String token, String remarks) {
    super(userId, accountId, exchange, tradingSymbol, transactionType, orderDuration, validDate,
            priceToFill, triggerPrice, priceType, productCode, disclosedQuantity, token, remarks);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<nestmodifyordernumber>")) {
      return processResponse(response, ModifyOrderResponse.class);
    }
    return super.getResponse(response);
  }
}
