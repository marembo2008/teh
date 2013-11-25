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
public class RMSPartialPositionConversionResponse extends Response {

  @Markup(name = "partialpositionstatus")
  private String partialPositionStatus;

  public String getPartialPositionStatus() {
    return partialPositionStatus;
  }

  public void setPartialPositionStatus(String partialPositionStatus) {
    this.partialPositionStatus = partialPositionStatus;
  }

  @Override
  public String toString() {
    return "RMSPartialPositionConversionResponse{" + "partialPositionStatus=" + partialPositionStatus + '}';
  }
}
