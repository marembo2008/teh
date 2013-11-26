/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketdata.IntraDayGraphResponse;

/**
 *
 * @author marembo
 */
public class IntraDayGraphRequest extends PostRequest {

  /**
   *
   * @param userId
   * @param token
   * @param symbol
   * @param exchange
   * @param interval Optional(Note that this should contain the interval value in seconds. For a 1
   * minute = 60 seconds so 60 will be the value that should be passed to get data in 60 second
   * interval)
   */
  public IntraDayGraphRequest(String userId, String token,
          String symbol, String exchange, String interval) {
    super("/XMLServlets/servlet/GetChart", userId, token);
    addParameter("Symbol", symbol);
    addParameter("exchange", exchange);
    addParameter("interval", interval);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, IntraDayGraphResponse.class);
  }
}
