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
public class ErrorResponse extends Response {

  @Markup(name = "omneerror")
  private String errorMessage;

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String toString() {
    return "ErrorResponse{" + "errorMessage=" + errorMessage + '}';
  }
}
