/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.ChangePasswordErrorResponse;
import com.anosym.teh.response.auth.ChangePasswordResponse;

/**
 *
 * @author marembo
 */
public class EnableAndChangePasswordRequest extends PostRequest {

  public EnableAndChangePasswordRequest(String userId, String securityKey, String panNumber, String token) {
    super("/XMLServlets/servlet/EnableAndChangePassword");
    addParameter("uid", userId);
    addParameter("confirmnewpwd", panNumber);
    addParameter("newpwd", securityKey);
    addParameter("token", token);
  }

  protected EnableAndChangePasswordRequest(String servletUrl, String userId, String securityKey, String panNumber, String token) {
    super(servletUrl);
    addParameter("uid", userId);
    addParameter("confirmnewpwd", panNumber);
    addParameter("newpwd", securityKey);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<omnechangepasserror>")) {
      return processResponse(response, ChangePasswordErrorResponse.class);
    }
    return processResponse(response, ChangePasswordResponse.class);
  }
}
