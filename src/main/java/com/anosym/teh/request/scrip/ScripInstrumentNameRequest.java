/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.scrip;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.scrip.ScripInstrumentNameResponse;

/**
 *
 * @author marembo
 */
public class ScripInstrumentNameRequest extends PostRequest {

  public ScripInstrumentNameRequest(String userId, String token, String exchange) {
    super("/XMLServlets/servlet/SearchFOScrip");
    addParameter("uid", userId);
    addParameter("token", token);
    addParameter("exchange", exchange);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, ScripInstrumentNameResponse.class);
  }
}
