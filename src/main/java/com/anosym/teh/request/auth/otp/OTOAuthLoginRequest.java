/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.otp;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.otp.OTPAuthLoginResponse;
import com.anosym.teh.response.DefaultResponse;

/**
 *
 * @author marembo
 */
public class OTOAuthLoginRequest extends PostRequest {

  public OTOAuthLoginRequest(String userId, String password, String ip) {
    super("/XMLServlets/servlet/AuthLogin");
    addParameter("uid", userId);
    addParameter("pwd", password);
    addParameter("ip", ip);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<omneotp>")) {
      return processResponse(response, OTPAuthLoginResponse.class);
    }
    return processResponse(response, DefaultResponse.class);
  }
}
