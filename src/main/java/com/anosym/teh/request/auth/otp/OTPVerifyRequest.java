/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.otp;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.DefaultResponse;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.LoginResponse;

/**
 *
 * @author marembo
 */
public class OTPVerifyRequest extends PostRequest {

  public OTPVerifyRequest(String userId, String otpPassword) {
    super("/XMLServlets/servlet/CheckOTP");
    addParameter("uid", userId);
    addParameter("pwd", otpPassword);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<logintoken>")) {
      return processResponse(response, LoginResponse.class);
    }
    return processResponse(response, DefaultResponse.class);
  }
}
