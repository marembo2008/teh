/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.user;

import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author marembo
 */
@Entity
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 73737371L;

    @Markup(name = "loginaccountid")
    @Id
    private String loginAccountId;
    @Markup(name = "dpdetails")
    @ArrayParented
    private String[] dpIds;
    @Markup(name = "pannumber")
    private String panNumber;
    @Markup(name = "bankdetails")
    private UserProfileResponse.Bank[] banks;
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

    public UserProfileResponse.Bank[] getBanks() {
        return banks;
    }

    public void setBanks(UserProfileResponse.Bank[] banks) {
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
