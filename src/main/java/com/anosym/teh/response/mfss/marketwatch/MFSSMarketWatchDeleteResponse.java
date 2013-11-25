/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.marketwatch;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class MFSSMarketWatchDeleteResponse extends Response {

  @Markup(name = "omnedeletemw")
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "MFSSMarketWatchDeleteResponse{" + "message=" + message + '}';
  }
}
