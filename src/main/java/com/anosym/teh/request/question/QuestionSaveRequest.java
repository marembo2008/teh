/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.question;

import com.anosym.teh.request.PostRequest;
import com.anosym.teh.response.Response;
import com.anosym.teh.response.image.SaveDataResponse;

/**
 *
 * @author marembo
 */
public class QuestionSaveRequest extends PostRequest {

  public QuestionSaveRequest() {
    super("/XMLServlets/servlet/ModifyUserAnswer");
    addParameter("uid", null);
    addParameter("QA1", null);
    addParameter("QA2", null);
    addParameter("QA3", null);
    addParameter("QA4", null);
    addParameter("QA5", null);
  }

  public QuestionSaveRequest(
          String userId,
          String questionIndex1,
          String questionIndex2,
          String questionIndex3,
          String questionIndex4,
          String questionIndex5,
          String questionAnswer1,
          String questionAnswer2,
          String questionAnswer3,
          String questionAnswer4,
          String questionAnswer5) {
    super("/XMLServlets/servlet/ModifyUserAnswer");
    addParameter("uid", userId);
    addParameter("QA1", questionIndex1 + " " + questionAnswer1);
    addParameter("QA2", questionIndex2 + " " + questionAnswer2);
    addParameter("QA3", questionIndex3 + " " + questionAnswer3);
    addParameter("QA4", questionIndex4 + " " + questionAnswer4);
    addParameter("QA5", questionIndex5 + " " + questionAnswer5);
  }

  @Override
  protected Response getResponse(String response) {
    return processResponse(response, SaveDataResponse.class);
  }
}
