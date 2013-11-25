/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.user;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class UserProfileResponse extends Response {

  public static class Bank {

    @Markup(name = "bankname", regex = "bankname\\d", useRegex = true)
    private String bankName;
    @Markup(name = "bankbranch", regex = "bankbranch\\d", useRegex = true)
    private String bankBranch;
    @Markup(name = "bankaccountid", regex = "bankaccountid\\d", useRegex = true)
    private String bankAccountId;

    public String getBankName() {
      return bankName;
    }

    public void setBankName(String bankName) {
      this.bankName = bankName;
    }

    public String getBankBranch() {
      return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
      this.bankBranch = bankBranch;
    }

    public String getBankAccountId() {
      return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
      this.bankAccountId = bankAccountId;
    }

    @Override
    public String toString() {
      return "Bank{" + "bankName=" + bankName + ", bankBranch=" + bankBranch + ", bankAccountId=" + bankAccountId + '}';
    }
  }

  public static class UserProfile {

    @Markup(name = "loginaccountid")
    private String loginAccountId;
    @Markup(name = "dpdetails")
    @ArrayParented
    private String[] dpIds;
    @Markup(name = "pannumber")
    private String panNumber;
    @Markup(name = "bankdetails")
    private Bank[] banks;
    @Markup(name = "emailaddress")
    private String emailAddress;
    @Markup(name = "cellnumber")
    private String cellNumber;

    public String getLoginAccountId() {
      return loginAccountId;
    }

    public void setLoginAccountId(String loginAccountId) {
      this.loginAccountId = loginAccountId;
    }

    public String[] getDpIds() {
      return dpIds;
    }

    public void setDpIds(String[] dpIds) {
      this.dpIds = dpIds;
    }

    public String getPanNumber() {
      return panNumber;
    }

    public void setPanNumber(String panNumber) {
      this.panNumber = panNumber;
    }

    public Bank[] getBanks() {
      return banks;
    }

    public void setBanks(Bank[] banks) {
      this.banks = banks;
    }

    public String getEmailAddress() {
      return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
    }

    public String getCellNumber() {
      return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
      this.cellNumber = cellNumber;
    }

    @Override
    public String toString() {
      return "UserProfile{" + "loginAccountId=" + loginAccountId + ", dpIds=" + dpIds + ", panNumber=" + panNumber + ", banks=" + Arrays.toString(banks) + ", emailAddress=" + emailAddress + ", cellNumber=" + cellNumber + '}';
    }
  }
  @Markup(name = "userprofile")
  private UserProfile userProfile;

  public UserProfile getUserProfile() {
    return userProfile;
  }

  public void setUserProfile(UserProfile userProfile) {
    this.userProfile = userProfile;
  }

  @Override
  public String toString() {
    return "UserProfileResponse{" + "userProfile=" + userProfile + '}';
  }
}
