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
public class ForgotPasswordWithExternalValidationResponse extends Response {

  @Markup(name = "validaepannumberandsecuritykey")
  private String statusMessage;
  @Markup(name = "validtoken")
  private String validToken;

  public void setValidToken(String validToken) {
    this.validToken = validToken;
  }

  public String getValidToken() {
    return validToken;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  @Override
  public String toString() {
    return "ForgotPasswordWithExternalValidationResponse{" + "statusMessage=" + statusMessage + ", validToken=" + validToken + '}';
  }
}
