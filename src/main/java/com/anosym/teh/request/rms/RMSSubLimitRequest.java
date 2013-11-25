/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.rms;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.rms.RMSSubLimitResponse;

/**
 *
 * @author marembo
 */
public class RMSSubLimitRequest extends PostRequest {

  public RMSSubLimitRequest(String userId, String token, String accountId) {
    super("/XMLServlets/servlet/GetRMSSubLimits", userId, token, accountId);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, RMSSubLimitResponse.class);
  }
}
