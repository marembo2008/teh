/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.rms;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.rms.RMSMaxPayoutAmountResponse;

/**
 *
 * @author marembo
 */
public class RMSMaxPayoutAmountRequest extends PostRequest {

  public RMSMaxPayoutAmountRequest(String userId, String token, String accountId, String segment) {
    super("/XMLServlets/servlet/GetMaxPayoutAmount", userId, token, accountId);
    addParameter("segment", segment);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, RMSMaxPayoutAmountResponse.class);
  }
}
