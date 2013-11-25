/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.ChangeTransactionPasswordErrorResponse;
import com.anosym.teh.response.auth.ChangeTransactionPasswordResponse;

/**
 *
 * @author marembo
 */
public class ChangeTransactionPasswordRequest extends PostRequest {

  public ChangeTransactionPasswordRequest(
          String userId,
          String oldTransactionPassword,
          String newTransactionPassword,
          String confirmNewTransactionPassword,
          String token) {
    super("/XMLServlets/servlet/ChangeTransPassword");
    addParameter("token", token);
    addParameter("uid", userId);
    addParameter("oldTransPass  ", oldTransactionPassword);
    addParameter("newtranspwd", newTransactionPassword);
    addParameter("confirmnewtranspwd", confirmNewTransactionPassword);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<omnechangetranspasserror>")) {
      return processResponse(response, ChangeTransactionPasswordErrorResponse.class);
    }
    return processResponse(response, ChangeTransactionPasswordResponse.class);
  }
}
