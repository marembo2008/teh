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
public class TokenCheckResponse extends Response {

  @Markup(name = "logintokenstate")
  private String tokenState;

  public String getTokenState() {
    return tokenState;
  }

  public void setTokenState(String tokenState) {
    this.tokenState = tokenState;
  }

  @Override
  public String toString() {
    return "TokenCheckResponse{" + "tokenState=" + tokenState + '}';
  }
}
