/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.auth.otp;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class OTPAuthLoginResponse extends Response {

  public static class AuthDetail {

    @Markup(name = "loginid")
    private String loginId;
    @Markup(name = "memberid")
    private String memberId;
    @Markup(name = "omneotptag")
    private String detail;

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

    public String getDetail() {
      return detail;
    }

    public void setDetail(String detail) {
      this.detail = detail;
    }

    @Override
    public String toString() {
      return "AuthDetail{" + "loginId=" + loginId + ", memberId=" + memberId + ", detail=" + detail + '}';
    }
  }
  private String message;
  @Markup(name = "omneotp")
  private AuthDetail authDetail;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public AuthDetail getAuthDetail() {
    return authDetail;
  }

  public void setAuthDetail(AuthDetail authDetail) {
    this.authDetail = authDetail;
  }

  @Override
  public String toString() {
    return "AuthLoginResponse{" + "message=" + message + ", authDetail=" + authDetail + '}';
  }
}
