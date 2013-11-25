/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.auth;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class CheckTransactionPasswordResponse extends Response {

  @Markup(name = "omnetranspassmsg")
  private String verified;

  public String getVerified() {
    return verified;
  }

  public void setVerified(String verified) {
    this.verified = verified;
  }

  @Override
  public String toString() {
    return "CheckTransactionPasswordResponse{" + "verified=" + verified + '}';
  }
}
