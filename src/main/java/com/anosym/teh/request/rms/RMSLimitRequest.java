/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.rms;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.rms.RMSLimitResponse;
import com.anosym.teh.response.Response;

/**
 *
 * @author marembo
 */
public class RMSLimitRequest extends PostRequest {

  public RMSLimitRequest(String userId, String accountId, String segment, String token) {
    super("/XMLServlets/servlet/GetRMSLimits");
    addParameter("uid", userId);
    addParameter("acId", accountId);
    addParameter("segment", segment);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, RMSLimitResponse.class);
  }
}
