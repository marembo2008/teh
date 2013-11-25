/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.question;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.DefaultResponse;
import com.anosym.teh.response.auth.question.QuestionAuthenticationResponse;

/**
 *
 * @author marembo
 */
public class QuestionAuthenticationRequest extends PostRequest {

  protected QuestionAuthenticationRequest() {
    super("/XMLServlets/servlet/AuthLogin");
    addParameter("uid", null);
    addParameter("pwd", null);
    addParameter("ip", null);
  }

  public QuestionAuthenticationRequest(String userId, String password, String ip) {
    super("/XMLServlets/servlet/AuthLogin");
    addParameter("uid", userId);
    addParameter("pwd", password);
    addParameter("ip", ip);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<omnequestionstag>")) {
      return processResponse(response, QuestionAuthenticationResponse.class);
    } else {
      return processResponse(response, DefaultResponse.class);
    }
  }
}
