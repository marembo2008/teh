/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.auth.ValidateWebSessionResponse;

/**
 *
 * @author marembo
 */
public class ValidateWebSessionRequest extends PostRequest {

  public ValidateWebSessionRequest(String userId, String token) {
    super("/XMLServlets/servlet/ThirdPartyInterMediate");
    addParameter("token", token);
    addParameter("uid", userId);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, ValidateWebSessionResponse.class);
  }
}
