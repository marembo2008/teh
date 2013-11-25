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
public class ValidateWebSessionResponse extends Response {

  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "ValidateWebSessionResponse{" + "status=" + status + '}';
  }
}
