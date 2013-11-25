/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.ChangeTransactionPasswordResponse;

/**
 *
 * @author marembo
 */
public class CheckTransactionPasswordRequest extends PostRequest {

  public CheckTransactionPasswordRequest(String userId, String transactionPassword, String token) {
    super("/XMLServlets/servlet/TransPass");
    addParameter("uid", userId);
    addParameter("TransPass", transactionPassword);
    addParameter("token", token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, ChangeTransactionPasswordResponse.class);
  }
}
