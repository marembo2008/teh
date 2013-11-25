/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.rms;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.rms.RMSSpanCalculatorResponse;

/**
 *
 * @author marembo
 */
public class RMSSpanCalculatorRequest extends PostRequest {

  public RMSSpanCalculatorRequest(String input, String userId, String token) {
    super("/XMLServlets/servlet/SpanCalculation", userId, token);
    addParameter("input", input);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, RMSSpanCalculatorResponse.class);
  }
}
