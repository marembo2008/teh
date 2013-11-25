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
public class ChangePasswordRequest extends PostRequest {

  public ChangePasswordRequest(String userId, String oldPassword, String newPassword, String confirmNewPassword, String token) {
    super("/XMLServlets/servlet/ChangePassword");
    addParameter("token", token);
    addParameter("uid", userId);
    addParameter("oldpwd", oldPassword);
    addParameter("newpwd", newPassword);
    addParameter("confirmnewpwd", confirmNewPassword);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<omnechangepasserror>")) {
      return processResponse(response, ChangePasswordErrorResponse.class);
    }
    return processResponse(response, ChangePasswordResponse.class);
  }
}
