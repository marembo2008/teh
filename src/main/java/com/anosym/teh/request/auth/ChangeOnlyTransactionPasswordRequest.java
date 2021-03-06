/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.ChangeTransactionPasswordErrorResponse;
import com.anosym.teh.response.auth.ChangeTransactionPasswordResponse;

/**
 *
 * @author marembo
 */
public class ChangeOnlyTransactionPasswordRequest extends EnableAndChangePasswordRequest {

  public ChangeOnlyTransactionPasswordRequest(String userId, String securityKey, String panNumber, String token) {
    super("/XMLServlets/servlet/ChangeOnlyTransactionPassword", userId, securityKey, panNumber, token);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<omnechangetranspasserror>")) {
      return processResponse(response, ChangeTransactionPasswordErrorResponse.class);
    }
    return processResponse(response, ChangeTransactionPasswordResponse.class);
  }
}
