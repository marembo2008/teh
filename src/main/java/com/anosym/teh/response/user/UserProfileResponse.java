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
