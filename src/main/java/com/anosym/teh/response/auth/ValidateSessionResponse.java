/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.auth;

import com.anosym.teh.response.Response;

/**
 *
 * @author marembo
 */
public class ValidateSessionResponse extends Response {

  private String validation;

  public String getValidation() {
    return validation;
  }

  public void setValidation(String validation) {
    this.validation = validation;
  }

  @Override
  public String toString() {
    return "ValidateSessionResponse{" + "validation=" + validation + '}';
  }
}
