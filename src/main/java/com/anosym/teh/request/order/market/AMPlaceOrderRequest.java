/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.order.market;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.order.market.AMPlaceOrderErrorResponse;
import com.anosym.teh.response.order.market.AMPlaceOrderResponse;
import com.anosym.utilities.FormattedCalendar;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class AMPlaceOrderRequest extends PostRequest {

  public AMPlaceOrderRequest(
          String userId,
          String accountId,
          String exchange,
          String tradingSymbol,
          String symbol,
          String transactionType,
          String orderDuration,
          Calendar validDate,
          int quantity,
          BigDecimal priceToFill,
          BigDecimal triggerPrice,
          String priceType,
          String productCode,
          int disclosedQuantity,
          String token) {
    this("/XMLServlets/servlet/PostAMO", userId, accountId, exchange, tradingSymbol,
            symbol, transactionType, orderDuration, validDate, quantity, priceToFill,
            triggerPrice, priceType, productCode, disclosedQuantity, token);
  }

  protected AMPlaceOrderRequest(
          String servletUrl,
          String userId,
          String accountId,
          String exchange,
          String tradingSymbol,
          String symbol,
          String transactionType,
          String orderDuration,
          Calendar validDate,
          int quantity,
          BigDecimal priceToFill,
          BigDecimal triggerPrice,
          String priceType,
          String productCode,
          int disclosedQuantity,
          String token) {
    super(servletUrl);
    addParameter("uid", userId);
    addParameter("acId", accountId);
    addParameter("exchange", exchange);
    addParameter("tradingsymbol", tradingSymbol);
    addParameter("symbol", symbol);
    addParameter("transactiontype", transactionType);
    addParameter("orderduration", orderDuration);
    addParameter("validdate", FormattedCalendar.toDateString(validDate, "dd/mm/yyyy"));
    addParameter("qtytofill", quantity);
    addParameter("pricetofill", priceToFill);
    addParameter("triggerprice", triggerPrice);
    addParameter("pricetype", priceType);
    addParameter("productcode", productCode);
    addParameter("disclosedqty", disclosedQuantity);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<errormsg>")) {
      return processResponse(response, AMPlaceOrderErrorResponse.class);
    } else {
      return processResponse(response, AMPlaceOrderResponse.class);
    }
  }
}
