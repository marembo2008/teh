/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.rms;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;
import com.anosym.vjax.annotations.v3.ArrayParented;

/**
 *
 * @author marembo
 */
public class RMSPossibleValuesResponse extends Response {

  public static class RMSPossibleLimit extends RMSLimitResponse.RMSLimit {

    private String segment;

    public String getSegment() {
      return segment;
    }

    public void setSegment(String segment) {
      this.segment = segment;
    }

    @Override
    public String toString() {
      return "RMSPossibleLimit{" + "segment=" + segment + '}' + super.toString();
    }
  }
  @Markup(name = "rmspossiblevalueslist")
  @ArrayParented(componentMarkup = "omnesingleentry")
  private RMSPossibleLimit[] rmsLimits;

  public RMSPossibleLimit[] getRmsLimits() {
    return rmsLimits;
  }

  public void setRmsLimits(RMSPossibleLimit[] rmsLimits) {
    this.rmsLimits = rmsLimits;
  }

  @Override
  public String toString() {
    return "RMSPossibleValuesResponse{" + "rmsLimits=" + rmsLimits + '}';
  }
}
