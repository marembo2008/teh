/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.scrip;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.ScripExpiryDateResponse;

/**
 *
 * @author marembo
 */
public class ScripExpiryDateRequest extends ScripSymbolRequest {

  public ScripExpiryDateRequest(String userId, String token, String exchange,
          String instrumentName, String symbol) {
    super(userId, token, exchange, instrumentName);
    addParameter("symbol", symbol);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, ScripExpiryDateResponse.class);
  }
}
