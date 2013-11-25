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
public class ChangePasswordErrorResponse extends Response {

  @Markup(name = "omnechangepasserror")
  private String statusMessage;

  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  @Override
  public String toString() {
    return "ChangePasswordResponse{" + "statusMessage=" + statusMessage + '}';
  }
}
