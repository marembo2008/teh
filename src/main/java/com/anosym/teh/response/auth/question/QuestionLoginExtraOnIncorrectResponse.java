/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.auth.question;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class QuestionLoginExtraOnIncorrectResponse extends Response {

  public static class Question {

    @Markup(name = "omnesinglequest")
    private String question;
    @Markup(name = "omnesingleindex")
    private String index;

    public String getQuestion() {
      return question;
    }

    public void setQuestion(String question) {
      this.question = question;
    }

    public String getIndex() {
      return index;
    }

    public void setIndex(String index) {
      this.index = index;
    }

    @Override
    public String toString() {
      return "Question{" + "question=" + question + ",\n index=" + index + '}';
    }
  }

  public static class LoginInfo {

    @Markup(name = "loginid")
    private String loginId;
    @Markup(name = "memberid")
    private String memberId;
    @Markup(name = "tfaq")
    private Question[] questions;

    public String getLoginId() {
      return loginId;
    }

    public void setLoginId(String loginId) {
      this.loginId = loginId;
    }

    public String getMemberId() {
      return memberId;
    }

    public void setMemberId(String memberId) {
      this.memberId = memberId;
    }

    public Question[] getQuestions() {
      return questions;
    }

    public void setQuestions(Question[] questions) {
      this.questions = questions;
    }

    @Override
    public String toString() {
      return "LoginInfo{" + "loginId=" + loginId + ",\n memberId=" + memberId + ",\n questions=" + Arrays.toString(questions) + '}';
    }
  }
  private String message;
  @Markup(name = "omneloginmsg")
  private LoginInfo loginInfo;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LoginInfo getLoginInfo() {
    return loginInfo;
  }

  public void setLoginInfo(LoginInfo loginInfo) {
    this.loginInfo = loginInfo;
  }

  @Override
  public String toString() {
    return "QuestionLoginExtraOnIncorrectResponse{" + "message=" + message + ",\n loginInfo=" + loginInfo + '}';
  }
}
