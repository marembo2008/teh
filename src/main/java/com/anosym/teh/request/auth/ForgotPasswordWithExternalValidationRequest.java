/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.ForgotPasswordWithExternalValidationErrorResponse;
import com.anosym.teh.response.auth.ForgotPasswordWithExternalValidationResponse;

/**
 *
 * @author marembo
 */
public class ForgotPasswordWithExternalValidationRequest extends PostRequest {

  public ForgotPasswordWithExternalValidationRequest(String loginId, String securityKey, String panNumber) {
    super(">/XMLServlets/servlet/ForgotPasswordWithExternalKeyCheck");
    addParameter("pan", panNumber);
    addParameter("securitykey", securityKey);
    addParameter("uid", loginId);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<validtoken>")) {
      return processResponse(response, ForgotPasswordWithExternalValidationResponse.class);
    }
    return processResponse(response, ForgotPasswordWithExternalValidationErrorResponse.class);
  }
}
