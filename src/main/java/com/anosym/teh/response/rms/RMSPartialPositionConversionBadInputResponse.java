/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.rms;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class RMSPartialPositionConversionBadInputResponse extends RMSPartialPositionConversionResponse {

  @Markup(name = "partialpositiontext")
  private String partialPositionMessage;

  public String getPartialPositionMessage() {
    return partialPositionMessage;
  }

  public void setPartialPositionMessage(String partialPositionMessage) {
    this.partialPositionMessage = partialPositionMessage;
  }

  @Override
  public String toString() {
    return "RMSPartialPositionConversionBadInputResponse{" + "partialPositionMessage=" + partialPositionMessage + '}' + super.toString();
  }
}
