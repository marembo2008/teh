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
public class MFSSMarketWatchScripDeleteResponse extends Response {

  @Markup(name = "omnedeletemwscripmf")
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "MFSSMarketWatchScripDeleteResponse{" + "message=" + message + '}';
  }
}
