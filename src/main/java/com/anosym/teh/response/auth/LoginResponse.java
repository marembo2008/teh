/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.auth;

import com.anosym.teh.request.Exchange;
import com.anosym.teh.response.Response;
import com.anosym.teh.util.DateTimeConverter;
import com.anosym.utilities.FormattedCalendar;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import com.anosym.vjax.annotations.v3.Converter;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author marembo
 */
public class LoginResponse extends Response {

  public static class LoginInfo {

    @Markup(name = "loginid")
    private String loginId;
    @Markup(name = "logintoken")
    private String loginToken;
    @Markup(name = "memberid")
    private String memberId;
    @Markup(name = "usertype")
    private String userType;
    @Markup(name = "logintime")
    @Converter(DateTimeConverter.class)
    private Calendar loginTime;
    @Markup(name = "guisubscription")
    private String guiSubscription;
    @Markup(name = "loginexchange")
    @ArrayParented(componentMarkup = "exchange")
    private Exchange[] loginExchange;
    @ArrayParented(componentMarkup = "product")
    @Markup(name = "loginproducts")
    private String[] loginProducts;
    @Markup(name = "loginpricetype")
    @ArrayParented(componentMarkup = "pricetype")
    private String[] loginPriceType;
    @ArrayParented(componentMarkup = "group")
    @Markup(name = "logingroups")
    private String loginGroups;
    @Markup(name = "logindefaultmw")
    private String loginDefaultMw;
    @Markup(name = "loginaccountid")
    private String loginAccountId;
    @Markup(name = "loginaccountname")
    private String loginAccountName;
    @Markup(name = "loginpasswordreset")
    private String loginPasswordReset;
    @Markup(name = "expirymessage")
    private String expiryMessage;
    private String broker;
    @Markup(name = "brokerbranchid")
    private String brokerBranchId;

    public String getLoginId() {
      return loginId;
    }

    public void setLoginId(String loginId) {
      this.loginId = loginId;
    }

    public String getLoginToken() {
      return loginToken;
    }

    public void setLoginToken(String loginToken) {
      this.loginToken = loginToken;
    }

    public String getMemberId() {
      return memberId;
    }

    public void setMemberId(String memberId) {
      this.memberId = memberId;
    }

    public String getUserType() {
      return userType;
    }

    public void setUserType(String userType) {
      this.userType = userType;
    }

    public Calendar getLoginTime() {
      return loginTime;
    }

    public void setLoginTime(Calendar loginTime) {
      this.loginTime = loginTime;
    }

    public String getGuiSubscription() {
      return guiSubscription;
    }

    public void setGuiSubscription(String guiSubscription) {
      this.guiSubscription = guiSubscription;
    }

    public void setLoginExchange(Exchange[] loginExchange) {
      this.loginExchange = loginExchange;
    }

    public Exchange[] getLoginExchange() {
      return loginExchange;
    }

    public String[] getLoginProducts() {
      return loginProducts;
    }

    public void setLoginProducts(String[] loginProducts) {
      this.loginProducts = loginProducts;
    }

    public String[] getLoginPriceType() {
      return loginPriceType;
    }

    public void setLoginPriceType(String[] loginPriceType) {
      this.loginPriceType = loginPriceType;
    }

    public String getLoginGroups() {
      return loginGroups;
    }

    public void setLoginGroups(String loginGroups) {
      this.loginGroups = loginGroups;
    }

    public String getLoginDefaultMw() {
      return loginDefaultMw;
    }

    public void setLoginDefaultMw(String loginDefaultMw) {
      this.loginDefaultMw = loginDefaultMw;
    }

    public String getLoginAccountId() {
      return loginAccountId;
    }

    public void setLoginAccountId(String loginAccountId) {
      this.loginAccountId = loginAccountId;
    }

    public String getLoginAccountName() {
      return loginAccountName;
    }

    public void setLoginAccountName(String loginAccountName) {
      this.loginAccountName = loginAccountName;
    }

    public String getLoginPasswordReset() {
      return loginPasswordReset;
    }

    public void setLoginPasswordReset(String loginPasswordReset) {
      this.loginPasswordReset = loginPasswordReset;
    }

    public String getExpiryMessage() {
      return expiryMessage;
    }

    public void setExpiryMessage(String expiryMessage) {
      this.expiryMessage = expiryMessage;
    }

    public String getBroker() {
      return broker;
    }

    public void setBroker(String broker) {
      this.broker = broker;
    }

    public String getBrokerBranchId() {
      return brokerBranchId;
    }

    public void setBrokerBranchId(String brokerBranchId) {
      this.brokerBranchId = brokerBranchId;
    }

    @Override
    public String toString() {
      return "LoginInfo{" + "loginId=" + loginId + ",\n loginToken=" + loginToken + ",\n memberId=" + memberId + ",\n userType=" + userType + ",\n loginTime=" + FormattedCalendar.toISOString(loginTime) + ",\n guiSubscription=" + guiSubscription + ",\n loginExchange=" + Arrays.toString(loginExchange) + ",\n loginProducts=" + Arrays.toString(loginProducts) + ",\n loginPriceType=" + Arrays.toString(loginPriceType) + ",\n loginGroups=" + loginGroups + ",\n loginDefaultMw=" + loginDefaultMw + ",\n loginAccountId=" + loginAccountId + ",\n loginAccountName=" + loginAccountName + ",\n loginPasswordReset=" + loginPasswordReset + ",\n expiryMessage=" + expiryMessage + ",\n broker=" + broker + ",\n brokerBranchId=" + brokerBranchId + '}';
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
    return "QuestionLoginResponse{" + "message=" + message + ",\n loginInfo=" + loginInfo + '}';
  }
}
