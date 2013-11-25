/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.DefaultResponse;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.LoginResponse;

/**
 *
 * @author marembo
 */
public class LoginRequest extends PostRequest {

  public LoginRequest(String userId, String password, String ip) {
    super("/XMLServlets/servlet/OmneLogin");
    addParameter("uid", userId);
    addParameter("pwd", password);
    addParameter("ip", ip);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<logintoken>")) {
      return processResponse(response, LoginResponse.class);
    }
    return processResponse(response, DefaultResponse.class);
  }
}
