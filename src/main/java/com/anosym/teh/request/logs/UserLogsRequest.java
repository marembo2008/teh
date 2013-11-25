/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.logs;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.logs.UserLogsResponse;

/**
 *
 * @author marembo
 */
public class UserLogsRequest extends PostRequest {

  public UserLogsRequest(String userId, String token) {
    super("/XMLServlets/servlet/UserLogs", userId, token);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, UserLogsResponse.class);
  }
}
