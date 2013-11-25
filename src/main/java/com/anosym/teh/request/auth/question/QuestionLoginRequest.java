/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth.question;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.DefaultResponse;
import com.anosym.teh.response.auth.question.QuestionLoginExtraOnIncorrectResponse;
import com.anosym.teh.response.auth.LoginResponse;

/**
 *
 * @author marembo
 */
public class QuestionLoginRequest extends PostRequest {

  public QuestionLoginRequest() {
    super("/XMLServlets/servlet/VerifyAnswerAndLogin");
    addParameter("uid", null);
    addParameter("sQI1", null);
    addParameter("sQI2", null);
    addParameter("sQA1", null);
    addParameter("sQA2", null);
  }

  public QuestionLoginRequest(
          String userId,
          String questionIndex1,
          String questionIndex2,
          String answer1,
          String answer2) {
    super("/XMLServlets/servlet/VerifyAnswerAndLogin");
    addParameter("uid", userId);
    addParameter("sQI1", questionIndex1);
    addParameter("sQI2", questionIndex2);
    addParameter("sQA1", answer1);
    addParameter("sQA2", answer2);
  }

  @Override
  protected Response getResponse(String response) {
    if (response.contains("<logintoken>")) {
      return processResponse(response, LoginResponse.class);
    } else if (response.contains("<tfaq>")) {
      return processResponse(response, QuestionLoginExtraOnIncorrectResponse.class);
    } else {
      return processResponse(response, DefaultResponse.class);
    }
  }
}
