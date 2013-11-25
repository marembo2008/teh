/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.logout;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.logout.UserLogoutErrorResponse;
import com.anosym.teh.response.auth.logout.UserLogoutResponse;

/**
 *
 * @author marembo
 */
public class UserLogoutRequest extends PostRequest {

  public UserLogoutRequest(String userId, String password, String token) {
    super("/XMLServlets/servlet/LogoutRequest");
    addParameter("uid", userId);
    addParameter("pwd", password);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<omlogoutreqmsg>")) {
      return processResponse(response, UserLogoutResponse.class);
    }
    return processResponse(response, UserLogoutErrorResponse.class);
  }
}
