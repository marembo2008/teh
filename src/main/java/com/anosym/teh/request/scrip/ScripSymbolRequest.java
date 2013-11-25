/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.scrip;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.ScripSymbolResponse;

/**
 *
 * @author marembo
 */
public class ScripSymbolRequest extends ScripInstrumentNameRequest {

  public ScripSymbolRequest(String userId, String token, String exchange, String instrumentName) {
    super(userId, token, exchange);
    addParameter("instrname", instrumentName);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, ScripSymbolResponse.class);
  }
}
