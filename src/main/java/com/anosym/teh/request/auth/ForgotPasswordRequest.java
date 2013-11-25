/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.ForgotPasswordResponse;

/**
 *
 * @author marembo
 */
public class ForgotPasswordRequest extends PostRequest {

  public ForgotPasswordRequest(String loginId, String email, String panNumber) {
    super("/XMLServlets/servlet/ForgotPassword");
    addParameter("pan", panNumber);
    addParameter("email", email);
    addParameter("uid", loginId);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, ForgotPasswordResponse.class);
  }
}
