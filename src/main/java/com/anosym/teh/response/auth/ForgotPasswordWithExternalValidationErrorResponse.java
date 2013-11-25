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
public class ForgotPasswordWithExternalValidationErrorResponse extends Response {

  @Markup(name = "validaepannumberandsecuritykey")
  private String statusMessage;
  @Markup(name = "rejectionreason")
  private String rejectionReason;

  public void setRejectionReason(String rejectionReason) {
    this.rejectionReason = rejectionReason;
  }

  public String getRejectionReason() {
    return rejectionReason;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  @Override
  public String toString() {
    return "ForgotPasswordWithExternalValidationResponse{" + "statusMessage=" + statusMessage + ", rejectionReason=" + rejectionReason + '}';
  }
}
