/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.marketwatch;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class MarketWatchCreateResponse extends Response {

  @Markup(name = "omnemw")
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "MarketWatchCreateResponse{" + "message=" + message + '}';
  }
}
