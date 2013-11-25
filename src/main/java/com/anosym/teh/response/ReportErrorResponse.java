/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response;

import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class ReportErrorResponse extends Response {

  @Markup(name = "errormsg")
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "ReportErrorMessage{" + "message=" + message + '}';
  }
}
