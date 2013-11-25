/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.trade;

import com.anosym.teh.request.order.history.OrderHistoryRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.trade.TradeHistoryResponse;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class TradeHistoryRequest extends OrderHistoryRequest {

  public TradeHistoryRequest(String loginId, String accountId, Calendar startDate,
          Calendar endDate, String sortOn, String sortType, String token) {
    super("/XMLServlets/servlet/TradeHistory", loginId, accountId, startDate, endDate, sortOn, sortType, token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, TradeHistoryResponse.class);
  }
}
