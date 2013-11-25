/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.PlaceOrderErrorResponse;
import com.anosym.teh.response.order.PlaceOrderResponse;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class PlaceOrderRequest extends PostRequest {

  public PlaceOrderRequest(
          String userId,
          String accountId,
          String exchange,
          String tradingSymbol,
          String transactionType,
          String orderDuration,
          Calendar validDate,
          BigDecimal priceToFill,
          BigDecimal triggerPrice,
          String priceType,
          String productCode,
          int disclosedQuantity,
          String token,
          String remarks) {
    super("/XMLServlets/servlet/PostOrder");
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<nestordernumber>")) {
      return processResponse(response, PlaceOrderResponse.class);
    }
    return processResponse(response, PlaceOrderErrorResponse.class);
  }
}
