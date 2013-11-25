/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.rms;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.rms.RMST1HoldingResponse;

/**
 *
 * @author marembo
 */
public class RMST1HoldingRequest extends RMSHoldingRequest {

  public RMST1HoldingRequest(String userId, String token, String accountId, String broker) {
    super("/XMLServlets/servlet/T1Holdings", userId, token, accountId, broker);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, RMST1HoldingResponse.class);
  }
}
