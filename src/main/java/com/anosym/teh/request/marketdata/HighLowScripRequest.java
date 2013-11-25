/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.marketdata;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.marketdata.HighLowScripResponse;

/**
 *
 * @author marembo
 */
public class HighLowScripRequest extends PostRequest {

  public static enum KeyOfInterest {

    UpperCircuit,
    LowerCircuit,
    _52WeekHigh,
    _52WeekLow;

    @Override
    public String toString() {
      return name().replace("_", "");
    }
  }

  public HighLowScripRequest(KeyOfInterest key, String userId, String token) {
    super("/XMLServlets/servlet/GetHighLowScrips", userId, token);
    addParameter("key", key);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, HighLowScripResponse.class);
  }
}
