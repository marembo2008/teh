/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.mfss.order;

import com.anosym.teh.response.Response;
import com.anosym.vjax.annotations.Markup;

/**
 *
 * @author marembo
 */
public class MFSSSIPIndicatorResponse extends Response {

  @Markup(name = "sipindicator")
  private String sipIndicator;

  public String getSipIndicator() {
    return sipIndicator;
  }

  public void setSipIndicator(String sipIndicator) {
    this.sipIndicator = sipIndicator;
  }

  @Override
  public String toString() {
    return "MFSSSIPIndicatorResponse{" + "sipIndicator=" + sipIndicator + '}';
  }
}
