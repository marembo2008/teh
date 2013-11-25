/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.ErrorResponse;
import com.anosym.teh.response.auth.TokenCheckResponse;

/**
 *
 * @author marembo
 */
public class TokenCheckRequest extends PostRequest {

  public TokenCheckRequest(String userId, String token) {
    super("/XMLServlets/servlet/LoginIsActive");
    addParameter("token", token);
    addParameter("uid", userId);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<omneerror>")) {
      return processResponse(response, ErrorResponse.class);
    }
    return processResponse(response, TokenCheckResponse.class);
  }
}
