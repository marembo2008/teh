/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.ValidateSessionResponse;

/**
 *
 * @author marembo
 */
public class ValidateSessionRequest extends PostRequest {

  public ValidateSessionRequest(String userId, String accountId, String externalToken) {
    super("/XMLServlets/servlet/ValidateSessionId");
    addParameter("uid", userId);
    addParameter("aCid", accountId);
    addParameter("extoken", externalToken);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, ValidateSessionResponse.class);
  }
}
