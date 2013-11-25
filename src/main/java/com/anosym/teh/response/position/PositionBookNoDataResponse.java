/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.position;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class PositionBookNoDataResponse extends Response {

  @Markup(name = "nestpositionnodata")
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "PositionBookNoDataResponse{" + "message=" + message + '}';
  }
}
