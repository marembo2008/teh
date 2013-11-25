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
public class MarketWatchDeleteScripResponse extends Response {

  @Markup(name = "omnedeletemwscrip")
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "MarketWatchDeleteScripResponse{" + "message=" + message + '}';
  }
}
