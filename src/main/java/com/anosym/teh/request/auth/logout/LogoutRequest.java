/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.logout;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.logout.LogoutResponse;

/**
 *
 * @author marembo
 */
public class LogoutRequest extends PostRequest {

  public LogoutRequest(String token, String userId) {
    super("/XMLServlets/servlet/OmneLogout");
    addParameter("uid", userId);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, LogoutResponse.class);
  }
}
