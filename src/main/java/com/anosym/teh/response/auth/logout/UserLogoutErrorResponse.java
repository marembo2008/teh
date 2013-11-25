/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.auth.logout;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class UserLogoutErrorResponse extends Response {

  @Markup(name = "omlogoutreqerror")
  private String statusMessage;

  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  @Override
  public String toString() {
    return "UserLogoutErrorResponse{" + "statusMessage=" + statusMessage + '}';
  }
}
