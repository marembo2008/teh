/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.otp;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.DefaultResponse;
import com.anosym.teh.response.Response;

/**
 *
 * @author marembo
 */
public class OTPSendRequest extends PostRequest {

  public OTPSendRequest(String userId) {
    super("/XMLServlets/servlet/OTPSendMail");
    addParameter("uid", userId);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, DefaultResponse.class);
  }
}
