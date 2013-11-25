/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.rms;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;
import java.util.Arrays;

/**
 *
 * @author marembo
 */
public class RMSPositionConversionResponse extends Response {

  public static class RMSPositionStatus {

    @Markup(name = "positionstatus")
    private String positionStatus;

    public String getPositionStatus() {
      return positionStatus;
    }

    public void setPositionStatus(String positionStatus) {
      this.positionStatus = positionStatus;
    }
  }
  @Markup(name = "positionconversion")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private RMSPositionStatus[] positionStatus;

  public RMSPositionStatus[] getPositionStatus() {
    return positionStatus;
  }

  public void setPositionStatus(RMSPositionStatus[] positionStatus) {
    this.positionStatus = positionStatus;
  }

  @Override
  public String toString() {
    return "RMSPositionConversionResponse{" + "positionStatus=" + Arrays.toString(positionStatus) + '}';
  }
}
