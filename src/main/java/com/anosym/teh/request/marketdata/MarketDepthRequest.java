/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata;

import com.anosym.teh.request.Exchange;
import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketdata.MarketDepthResponse;

/**
 *
 * @author marembo
 */
public class MarketDepthRequest extends PostRequest {

  public MarketDepthRequest(String userId, String token, Exchange exchange, String symbol) {
    super("/XMLServlets/servlet/MktPicture", userId, token);
    addParameter("symbol", symbol);
    addParameter("exhange", exchange);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, MarketDepthResponse.class);
  }
}
