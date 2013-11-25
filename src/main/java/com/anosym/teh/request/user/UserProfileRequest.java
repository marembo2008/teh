/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.user;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.user.UserProfileResponse;

/**
 *
 * @author marembo
 */
public class UserProfileRequest extends PostRequest {

  public UserProfileRequest(String userId, String token, String accountId) {
    super("/XMLServlets/servlet/GetUserProfile", userId, token, null);
    addParameter("accId", accountId);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, UserProfileResponse.class);
  }
}
