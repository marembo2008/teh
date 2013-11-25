/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.trade;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.trade.TradeBookResponse;

/**
 *
 * @author marembo
 */
public class TradeBookRequest extends PostRequest {

  public TradeBookRequest(String userId, String token) {
    super("/XMLServlets/servlet/GetTrades");
    addParameter("uid", userId);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, TradeBookResponse.class);
  }
}
