/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.image;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class ImageRetrievalAuthenticationFailureResponse extends Response {

  public static class ErrorMessage {

    @Markup(name = "omneimage")
    private String errorMessage;

    public ErrorMessage() {
    }

    public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
      return errorMessage;
    }

    @Override
    public String toString() {
      return errorMessage;
    }

  }
  @Markup(name = "omneimagetag")
  private ErrorMessage error;

  public void setError(ErrorMessage error) {
    this.error = error;
  }

  public ErrorMessage getError() {
    return error;
  }

  @Override
  public String toString() {
    return "ImageRetrievalAuthenticationFailure{" + "errorMessage=" + error + '}';
  }

}
