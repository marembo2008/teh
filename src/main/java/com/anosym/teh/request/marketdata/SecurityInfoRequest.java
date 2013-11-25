/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketdata.SecurityInfoResponse;

/**
 *
 * @author marembo
 */
public class SecurityInfoRequest extends PostRequest {

  public SecurityInfoRequest(String userId, String token, String exchange, String symbol) {
    super("/XMLServlets/servlet/SecurityInfo", userId, token);
    addParameter("symbol", symbol);
    addParameter("exchange", exchange);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, SecurityInfoResponse.class);
  }
}
